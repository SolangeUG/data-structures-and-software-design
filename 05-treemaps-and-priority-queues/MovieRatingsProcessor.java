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

			List<String> toBeRemoved = new LinkedList<>();

			movieRatings.forEach((title, ratings) -> {
                // determine if this title's ratings are concerned
				// ie: if the head of the queue is less than the input rating
				if (ratings.peek() < rating) {
					toBeRemoved.add(title);
				}
            });

			if (! toBeRemoved.isEmpty()) {
				for (String title : toBeRemoved) {
					int count = 0;

					// remove all the ratings that are below the input rating from the queue
					PriorityQueue<Integer> ratings = movieRatings.get(title);
					int head = ratings.peek();
					while (head < rating && head > -1) {
						ratings.poll();
						count++;
						if (ratings.isEmpty()) {
							head = -1;
						} else  {
							head = ratings.peek();
						}
					}

					// if the queue is now empty, remove its entry from the treemap
					if (ratings.isEmpty()) {
						movieRatings.remove(title);
					}

					// add the title to the list of removed movie ratings
					if (count > 0) {
						result.put(title, count);
					}
				}
			}
        }

		return result;
	}
}
