import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * SD2x Homework #11 - A program that attemps to detect plagiarism in a corpus of documents.
 * Improve the efficiency of the code below according to the guidelines in the assignment description.
 * Please be sure not to change the signature of the detectPlagiarism method!
 * However, you may modify the signatures of any of the other methods as needed.
 */
public class PlagiarismDetector {

	/**
	 * Return a map that lists pairs of documents
	 * @param dirName the directory containing the corpus of documents to be analyzed
	 * @param windowSize the size of common phrases
	 * @param threshold the limit of common phrases over which a pair of documents are considered "similar"
	 * @return the map of documents with common phrases
	 */
	public static Map<String, Integer> detectPlagiarism(String dirName, int windowSize, int threshold) {

		Map<String, Integer> numberOfMatches = null;
		File dirFile = new File(dirName);
		String[] files = dirFile.list();

		if (files != null) {

			// no need to create a new HashMap object before this line
			numberOfMatches = new HashMap<>();

			Set<String> file1Phrases;
			for (String file1 : files) {

				// move into the outer loop because it doesn't need to be re-evaluated into the inner loop!
				// extract phrases from the comparator file
				file1Phrases = createPhrases(dirName + "/" + file1, windowSize);
				if (file1Phrases == null || file1Phrases.isEmpty()) {
					return null;
				}

				Set<String> file2Phrases;
				for (String file2 : files) {

					// no need to do any work if the files are the same
					if (! file1.equals(file2)) {

						// extract phrases from the current file to compare to
						file2Phrases = createPhrases(dirName + "/" + file2, windowSize);
						if (file2Phrases == null || file2Phrases.isEmpty()) {
							return null;
						}

						// look for matches between the two sets of phrases
						Set<String> matches = findMatches(file1Phrases, file2Phrases);
						if (matches != null && !matches.isEmpty()) {
							int size = matches.size();
							if (size > threshold) {
								String reversedKey = file2 + "-" + file1;
								if (! numberOfMatches.containsKey(reversedKey)) {
									String key = file1 + "-" + file2;
									numberOfMatches.put(key, size);
								}
							}
						}

					}
				}
			}
			// return the sorted map
			numberOfMatches = sortResults(numberOfMatches);
		}

		return numberOfMatches;
	}

	/**
	 * Read a file into a collection of strings.
	 * Punctuation is ignored and all words are converted to uppercase.
	 * @param filename the file to be read
	 * @return a collection of strings
	 */
	protected static List<String> readFile(String filename) {
		// exit as soon as the input does not satisfy preconditions
		if (filename == null) {
			return null;
		}

		List<String> words;

		// use of try-with-resources construct to make sure
		// the scanner will be closed after the method is run...
		// ... whether an exception occurs or not!
		try (Scanner in = new Scanner(new File(filename))) {
			words = new LinkedList<>();
			String regex = "[^a-zA-Z]";
			while (in.hasNext()) {
				String word = in.next();
				words.add(word.replaceAll(regex, "").toUpperCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return words;
	}

	/**
	 * Read a file into a set of distinct phrases of give size.
	 * The words in each phrase are whitespace-separated.
	 * @param filename the file to be read
	 * @param window the size of the phrases
	 * @return a set of phrases of the given size
	 */
	protected static Set<String> createPhrases(String filename, int window) {
		// exit as soon as the input does not satisfy preconditions
		if (window < 1 || filename == null || filename.isEmpty()) {
			return null;
		}
				
		List<String> words = readFile(filename);
		if (words == null || words.isEmpty()) {
			// no need to go further if there are no words to treat
			return null;
		}

		Set<String> phrases = new HashSet<>();
		int limit = words.size() - window + 1;
		StringBuilder phrase;
		for (int i = 0; i < limit; i++) {
			// replace string concatenation inside a loop with a StringBuilder
			phrase = new StringBuilder();
			for (int j = 0; j < window; j++) {
				phrase.append(words.get(i + j)).append(" ");
			}
			phrases.add(phrase.toString());
		}
		
		return phrases;		
	}

	/**
	 * Return a set of strings common to two sets of words.
	 * The comparison is case insensitive.
	 * @param myPhrases first set of words
	 * @param yourPhrases other set of words
	 * @return a set of common words
	 */
	protected static Set<String> findMatches(Set<String> myPhrases, Set<String> yourPhrases) {
		// exit as soon as the input does not satisfy preconditions
		if (myPhrases == null || yourPhrases == null
				|| myPhrases.isEmpty() || yourPhrases.isEmpty()) {
			return null;
		}

		Set<String> matches = new HashSet<>();
		for (String mine : myPhrases) {
			for (String yours : yourPhrases) {
				if (mine.equalsIgnoreCase(yours)) {
					matches.add(mine);
				}
			}
		}
		return matches;
	}


	/**
	 * Return a LinkedHashMap in which the elements of the Map parameter are sorted
	 * according to the value of the Integer, in non-ascending order.
	 * @param possibleMatches a map of possible matches
	 * @return a sorted map
	 */
	protected static LinkedHashMap<String, Integer> sortResults(Map<String, Integer> possibleMatches) {
		
		// Because this approach modifies the Map as a side effect of printing 
		// the results, it is necessary to make a copy of the original Map
		Map<String, Integer> copy = new HashMap<>();
		for (String key : possibleMatches.keySet()) {
			copy.put(key, possibleMatches.get(key));
		}
		
		LinkedHashMap<String, Integer> list = new LinkedHashMap<>();

		for (int i = 0; i < copy.size(); i++) {
			int maxValue = 0;
			String maxKey = null;

			for (String key : copy.keySet()) {
				Integer value = copy.get(key);
				if (value > maxValue) {
					maxValue = value;
					maxKey = key;
				}
			}
			
			list.put(maxKey, maxValue);
			copy.put(maxKey, -1);
		}

		return list;
	}

	/**
	 * Tester method.
	 * Measure the execution time and get the output of the program.
	 * @param args program arguments
	 */
    public static void main(String[] args) {
    	if (args.length == 0) {
    		System.out.println("Please specify the name of the directory containing the corpus.");
    		System.exit(0);
    	}

    	String directory = args[0];
		System.out.println("Test directory is " + args[0]);

    	// measure execution time
    	long start = System.currentTimeMillis();
    	Map<String, Integer> map = PlagiarismDetector.detectPlagiarism(directory, 4, 5);
    	long end = System.currentTimeMillis();

    	// print execution time results
    	double timeInSeconds = (end - start) / (double)1000;
    	System.out.println("\nExecution time (wall clock): " + timeInSeconds + " seconds\n");

    	if (map != null) {
			// print sorted resulting sorted map
			Set<Map.Entry<String, Integer>> entries = map.entrySet();
			for (Map.Entry<String, Integer> entry : entries) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}
    }

}
