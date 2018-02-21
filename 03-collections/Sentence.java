/**
 * SD2x Homework #3
 * This class represents a single sentence.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 */
public class Sentence implements Comparable<Sentence> {
	protected int score;
	protected String text;

	/**
	 * Constructor
	 * @param score The sentiment analysis score of this sentence
	 * @param text The text content of this sentence
	 */
	public Sentence(int score, String text) {
		this.score = score;
		this.text = text;
	}

	/**
	 * Return the sentiment analysis score of this sentence
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Return the text content of this sentence
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Determine equality of two sentences
	 * @param obj The other sentence
	 * @return true if the two sentences are equal
	 * 		   false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sentence other = (Sentence) obj;
		if (score != other.score)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	/**
	 * Compare this sentence to another
	 * @param o The other sentence to compare this to
	 * @return The difference in sentiment analysis score between the two sentences
	 */
	@Override
	public int compareTo(Sentence o) {
		return this.score - o.score;
	}
	
	
}
