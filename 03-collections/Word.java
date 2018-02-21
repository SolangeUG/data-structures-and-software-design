/**
 * This class represents a word from a sentence.
 */
public class Word implements Comparable<Word> {
	protected String text;
	protected int count;
	protected int total;
	
	/**
	 * Constructor
	 * Note that this does not set the value or increment the counter.
	 * It just creates an object with no count and no total so far.
	 * @param text This word's text content
	 */
	public Word(String text) {
		this.text = text;
		count = 0;
		total = 0;
	}

	/**
	 * Increase this word's total value
	 * @param value the increment in value
	 */
	public void increaseTotal(int value) {
		total += value;
		count++;
	}

	/**
	 * Determine this word's sentiment analysis score
	 * @return the score
	 */
	public double calculateScore() {
		if (count == 0) {
			return 0;
		}
		return ((double) total) / count;
	}

	/**
	 * Return this word's count
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Return this word's total value
	 * @return the total value
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Return this word's text content
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Determine whether two words are equal
	 * @param other The other word
	 * @return true if the two words are equal
	 * 		   false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Word)) return false;
		Word otherWord = (Word)other;
		return text.equals(otherWord.text);
	}

	/**
	 * Return this word's integer representation
	 * @return the hashcode
	 */
	@Override
	public int hashCode() {
		return text.hashCode();
	}

	/**
	 * Compare this word to another
	 * @param o The other word
	 * @return the comparison result
	 */
	@Override
	public int compareTo(Word o) {
		return text.compareTo(o.text);
	}
}
