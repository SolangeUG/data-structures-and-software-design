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
		File dirFile = new File(dirName);
		String[] files = dirFile.list();
		
		Map<String, Integer> numberOfMatches = new HashMap<>();
		
		for (int i = 0; i < files.length; i++) {
			String file1 = files[i];

			for (int j = 0; j < files.length; j++) { 
				String file2 = files[j];
				
				Set<String> file1Phrases = createPhrases(dirName + "/" + file1, windowSize); 
				Set<String> file2Phrases = createPhrases(dirName + "/" + file2, windowSize); 
				
				if (file1Phrases == null || file2Phrases == null)
					return null;
				
				Set<String> matches = findMatches(file1Phrases, file2Phrases);
				
				if (matches == null)
					return null;
								
				if (matches.size() > threshold) {
					String key = file1 + "-" + file2;
					if (numberOfMatches.containsKey(file2 + "-" + file1) == false && file1.equals(file2) == false) {
						numberOfMatches.put(key,matches.size());
					}
				}				
			}
			
		}		
		
		return sortResults(numberOfMatches);

	}

	/**
	 * Read a file into a collection of strings.
	 * Punctuation is ignored and all words are converted to uppercase.
	 * @param filename the file to be read
	 * @return a collection of strings
	 */
	protected static List<String> readFile(String filename) {
		if (filename == null) return null;
		
		List<String> words = new LinkedList<String>();
		
		try {
			Scanner in = new Scanner(new File(filename));
			while (in.hasNext()) {
				words.add(in.next().replaceAll("[^a-zA-Z]", "").toUpperCase());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return words;
	}

	/**
	 * Read a file into a set of distinct phrases of give size.
	 * The words in each phrase are whitespace-separated.
	 * @param filename
	 * @param window
	 * @return
	 */
	protected static Set<String> createPhrases(String filename, int window) {
		if (filename == null || window < 1) return null;
				
		List<String> words = readFile(filename);
		
		Set<String> phrases = new HashSet<String>();
		
		for (int i = 0; i < words.size() - window + 1; i++) {
			String phrase = "";
			for (int j = 0; j < window; j++) {
				phrase += words.get(i+j) + " ";
			}

			phrases.add(phrase);

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
	
		Set<String> matches = new HashSet<String>();
		
		if (myPhrases != null && yourPhrases != null) {
		
			for (String mine : myPhrases) {
				for (String yours : yourPhrases) {
					if (mine.equalsIgnoreCase(yours)) {
						matches.add(mine);
					}
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
		Map<String, Integer> copy = new HashMap<String, Integer>();

		for (String key : possibleMatches.keySet()) {
			copy.put(key, possibleMatches.get(key));
		}	
		
		LinkedHashMap<String, Integer> list = new LinkedHashMap<String, Integer>();

		for (int i = 0; i < copy.size(); i++) {
			int maxValue = 0;
			String maxKey = null;
			for (String key : copy.keySet()) {
				if (copy.get(key) > maxValue) {
					maxValue = copy.get(key);
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
    	long start = System.currentTimeMillis();
    	Map<String, Integer> map = PlagiarismDetector.detectPlagiarism(directory, 4, 5);
    	long end = System.currentTimeMillis();
    	double timeInSeconds = (end - start) / (double)1000;
    	System.out.println("Execution time (wall clock): " + timeInSeconds + " seconds");
    	Set<Map.Entry<String, Integer>> entries = map.entrySet();
    	for (Map.Entry<String, Integer> entry : entries) {
    		System.out.println(entry.getKey() + ": " + entry.getValue());
    	}
    }

}
