import java.io.InputStream;
import java.util.*;

/**
 * SD2x Homework #3 - Sentiment analysis (positive or negative) of a sentence.
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 *
 * @author Solange U. Gasengayire
 */
public class Analyzer {

    /**
     * Read the content of a file into a list of sentences
     * @param filename The file to read
     * @return the list of sentences in the file
     */
	public static List<Sentence> readFile(String filename) {

	    List<Sentence> sentences = new LinkedList<>();

	    if (filename != null && !filename.isEmpty()) {

			try {

				InputStream stream = Analyzer.class.getClassLoader()
						.getResourceAsStream(filename);
				Scanner scanner = new Scanner(stream);
				while(scanner.hasNextLine()) {
					String textLine = scanner.nextLine();
					Sentence sentence = getSentence(textLine);
					if (sentence != null) {
						sentences.add(sentence);
					}
				}
				scanner.close();
				stream.close();
			} catch (Exception exception) {
				System.out.println("Exception : " + exception.getMessage());
			}

		}

		return sentences;

	}

    /**
     * Return a set of all the words from a list of sentences
     * @param sentences The list of sentences
     * @return the set of all words in the sentences
     */
	public static Set<Word> allWords(List<Sentence> sentences) {

		Set<Word> wordSet = new HashSet<>();
		HashMap<String, Word> wordMap = new HashMap<>();

		if (sentences != null && !sentences.isEmpty()) {
			// store all the strings in sentences into a hash map
			for (Sentence sentence: sentences) {

				if (sentence != null) {
					// split each sentence into individual valid words
					List<String> strings = getStringsFromSentence(sentence.getText());

					for (String string : strings) {
						// we're ready to work with a word object
						Word word;
						if (wordMap.keySet().contains(string)) {
							word = wordMap.get(string);
						} else {
							word = new Word(string);
						}
						word.increaseTotal(sentence.getScore());
						wordMap.put(string, word);
					}
				}
			}

			// add all the generated Word objects to the set
			wordSet.addAll(wordMap.values());
		}

		return wordSet;
	}

    /**
     * Calculate the score of words
     * @param words the input set of words
     * @return a map of words and their scores
     */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		Map<String, Double> scores = new HashMap<>();

		if (words != null && ! words.isEmpty()) {
			// for each non null word in the set, calculate and store its score
			for (Word word: words) {
				if (word != null) {
					double score = word.calculateScore();
					scores.put(word.getText(), score);
				}
			}
		}

		return scores;
	}

    /**
     * Determine the sentiment analysis score of a sentence
     * @param wordScores the input map of words and their respective scores
     * @param sentence the sentence to analyze
     * @return the sentence's sentiment analysis score
     */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		double sentenceScore = 0;

		if (wordScores != null && !wordScores.isEmpty()
				&& sentence != null && !sentence.isEmpty()) {
			// retrieve a list of words from the sentence
			List<String> words = getStringsFromSentence(sentence);

			// does the sentence contain valid words only?
			if (words.size() > 0) {
				// calculate the total cumulative score of the sentence
				for (String word : words) {
					if (wordScores.containsKey(word)) {
						sentenceScore += wordScores.get(word);
					}
				}
				sentenceScore = sentenceScore / (double) words.size();
			}
		}
		return sentenceScore;
	}

    /**
     * Return a Sentence object from the input text line
     * @param line the input text line
     * @return a sentence object if the line starts with an int between -2 and 2, has a single whitespace,
     *         and then is followed by more text.
     */
	private static Sentence getSentence(String line) {
	    Sentence sentence = null;

	    if (line != null && !line.isEmpty() && !line.matches("\\s")) {
            try {

                String[] tokens = line.split("\\s");
                double scoreToken = Double.valueOf(tokens[0]);

                // only scores of -2.0, -1.0, 0, 1.0 and 2.0 are allowed!
				if (isValidScore(scoreToken)) {
					int score = (int) scoreToken;
					int index = tokens[0].length();
					String text = line.substring(index).trim();

					// exclude empty sentences
					if (!text.isEmpty() && !text.matches("\\s")) {
						sentence = new Sentence(score, text);
					}
				}

            } catch (NumberFormatException exception) {
                System.out.println("NumberFormatException: " + exception.getMessage());
            }
        }
	    return sentence;
    }

	/**
	 * Return a list of valid words from a sentence
	 * @param sentence the input text
	 * @return a list of its words
	 */
	private static List<String> getStringsFromSentence(String sentence) {
		List<String> strings = new LinkedList<>();

		if (sentence != null && !sentence.isEmpty() && !sentence.matches("\\s")) {
			String[] tokens = sentence.toLowerCase().split("\\s");
			for (String token : tokens) {
				// retain only words that start with a letter
				if (token.matches("[a-z]+|[a-z]+\\p{Punct}")) {

					// ignore the punctuation at the end of the word if applicable
					if (token.matches("[a-z]+\\p{Punct}")) {
						token = token.substring(0, token.length() - 1);
					}
					strings.add(token);
				}
			}
		}
		return strings;
	}

	/**
	 * Determine whether a given score is part of the valid range
	 * @param scoreToken the input score
	 * @return true if the score is in the valid range
	 * 		   false otherwise
	 */
	private static boolean isValidScore(double scoreToken) {
		return scoreToken == -2.0
				|| scoreToken == -1.0
				|| scoreToken == 0.0
				|| scoreToken == 1.0
				|| scoreToken == 2.0;
	}


    /**
     * Tester method
     * @param args application arguments
     */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}

		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();

		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);

		/*
		String text = "It 's a hard knock life for us!";
		String[] tokens = text.toLowerCase().split(" ");
		for (String string: tokens) {
			if (string.matches("[a-z]+|[a-z]+\\p{Punct}")) {
				if (string.matches("[a-z]+\\p{Punct}")) {
					string = string.substring(0, string.length()-1);
				}
				System.out.println(string);
			}
		}

		String text = "4.8 what Did you do?";
		String[] tokens = text.split("\\s");
		System.out.println(tokens[0]);
		int index = tokens[0].length();
		System.out.println("rest of text is " + text.substring(index).trim());
		*/

	}
}
