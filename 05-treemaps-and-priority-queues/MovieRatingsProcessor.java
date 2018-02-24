import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * SD2x Homework #5 - Movie Rating Processor
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 *
 * @author Solange U. Gasengayire
 */
public class MovieRatingsProcessor {

	/**
	 * Return a list of movie titles
	 * @param movieRatings input movie ratings
	 * @return the list of titles from the input data
	 */
	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		
		return null;
	}

	/**
	 * Return a list of movie titles ranked higher than a given rating
	 * @param movieRatings input movie ratings
	 * @param rating the score limit
	 * @return the list of titles that rank higher than the limit score
	 */
	public static List<String> getAlphabeticalMoviesAboveRating(
								TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		
		return null;
	}

	/**
	 * Remove movie titles that rank below a given rating
	 * @param movieRatings input movie ratings
	 * @param rating the rating limit
	 * @return the removed movie titles
	 */
	public static TreeMap<String, Integer> removeAllRatingsBelow(
												TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		
		return null;
	}
}
