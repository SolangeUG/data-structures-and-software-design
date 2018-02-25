import java.util.*;

/**
 * SD2x Homework #5 - Movie Rating Processor
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 *
 * @author Solange U. Gasengayire
 */
public class MovieRatingsProcessor {

	/**
	 * Return a list of movie titles in alphabetical order
	 * @param movieRatings input movie ratings
	 * @return the list of titles from the input data
	 */
	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> movies = new LinkedList<>();
		if (movieRatings != null && !movieRatings.isEmpty()) {
            String firstTitle = movieRatings.firstKey();
            SortedMap<String, PriorityQueue<Integer>> sortedMap = movieRatings.tailMap(firstTitle);
            movies.addAll(sortedMap.keySet());
        }
		return movies;
	}

	/**
	 * Return a list of movie titles ranked higher than a given rating
	 * @param movieRatings input movie ratings
	 * @param rating the score limit
	 * @return the list of titles that rank higher than the limit score
	 */
	public static List<String> getAlphabeticalMoviesAboveRating(
								TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> movies = new LinkedList<>();

		if (movieRatings != null && !movieRatings.isEmpty()) {
            String firstTitle = movieRatings.firstKey();
            SortedMap<String, PriorityQueue<Integer>> sortedMap = movieRatings.tailMap(firstTitle);

            // filter titles whose smallest rating is greater than the input rating
            for (String title: sortedMap.keySet()) {
                PriorityQueue<Integer> ratings = sortedMap.get(title);
                if (ratings.peek() > rating) {
                    movies.add(title);
                }
            }
        }

		return movies;
	}

	/**
	 * Remove movie titles that rank below a given rating
	 * @param movieRatings input movie ratings
	 * @param rating the rating limit
	 * @return the removed movie titles
	 */
	public static TreeMap<String, Integer> removeAllRatingsBelow(
												TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		TreeMap<String, Integer> result = new TreeMap<>();

		if (movieRatings != null && !movieRatings.isEmpty()) {
            movieRatings.forEach((title, ratings) -> {
                int count = 0;
                // remove all the ratings that are below than the input rating
                for(Integer value: ratings) {
                    if (value < rating) {
                        ratings.remove(value);
                        count++;
                    }
                }

                // remove treemap entry if its queue is empty
                if (ratings.isEmpty()) {
                    movieRatings.remove(title);
                }

                // add the title to the list of removed movie ratings
                if (count > 0) {
                    result.put(title, count);
                }
            });
        }

		return result;
	}
}
