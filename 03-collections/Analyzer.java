import java.io.FileInputStream;
import java.io.IOException;
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

	    try {
            InputStream stream = new FileInputStream(filename);
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
	    } catch (IOException exception) {
            System.out.println("IOException: " + exception.getMessage());
            exception.printStackTrace();
        }

		return sentences;

	}
	
	/*
	 * Implement this method in Part 2
	 */

    /**
     * Return a set of all the words from a list of sentences
     * @param sentences The list of sentences
     * @return the set of all words in the sentences
     */
	public static Set<Word> allWords(List<Sentence> sentences) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */

    /**
     * Calculate the score of words
     * @param words the input set of words
     * @return a map of words and their scores
     */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */

    /**
     * Determine the sentiment analysis score of a sentence
     * @param wordScores the input map of words and their respective scores
     * @param sentence the sentence to analyze
     * @return the sentence's sentiment analysis score
     */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		
		return 0; // this line is here only so this code will compile if you don't modify it

	}

    /**
     * Return a Sentence object from the input text line
     * @param line the input text line
     * @return a sentence object if the line starts with an int between -2 and 2, has a single whitespace,
     *         and then is followed by more text.
     */
	private static Sentence getSentence(String line) {
	    Sentence sentence = null;

	    if (line != null && !line.isEmpty()) {
            try {

                int endNdx = 1;
                if (line.startsWith("-")) endNdx = 2;

                int score = Integer.valueOf(line.substring(0, endNdx));
	            String text = line.substring(endNdx);
	            sentence = new Sentence(score, text);

            } catch (NumberFormatException exception) {
                System.out.println("NumberFormatException: " + exception.getMessage());
                exception.printStackTrace();
            }
        }
	    return sentence;
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
	}
}
