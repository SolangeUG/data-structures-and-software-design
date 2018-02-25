import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * SD2x Homework #5 - Movie Rating Parser
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 *
 * @author Solange U. Gasengayire
 */
public class MovieRatingsParser {

	/**
	 * Parse a list of movie ratings into a TreeMap
	 * @param allUsersRatings input list of movie ratings
	 * @return the parsed TreeMap
	 */
	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		TreeMap<String, PriorityQueue<Integer>> movies = new TreeMap<>();

		if (allUsersRatings != null && !allUsersRatings.isEmpty()) {
		    for (UserMovieRating movieRating : allUsersRatings) {
		        // ingore non valid movie ratings
                if (isValid(movieRating)) {
                    PriorityQueue<Integer> ratings;

                    // has the movie been added to the map already?
                    String title = movieRating.getMovie().toLowerCase();
                    if (! movies.containsKey(title)) {
                        ratings = new PriorityQueue<>();
                    } else {
                        ratings = movies.get(title);
                    }
                    // add the movie rating to the corresponding priority queue
                    ratings.add(movieRating.getUserRating());
                    // finally, add/replace the queue to the map
                    movies.put(title, ratings);
                }
            }
        }
		return movies;
	}

    /**
     * Determine whether a given UserMovieRating is valid
     * @param movieRating the input UserMovieRating
     * @return true if the UserMovieRating is not null and not "empty"
     */
	private static boolean isValid(UserMovieRating movieRating) {
	    // movie rating souldn't be null
	    boolean result = movieRating != null;

	    if (result) {
	        // its title shouldn't be null or empty
	        String title = movieRating.getMovie();
	        result = title != null;
	        if (result) {
	            result = ! title.isEmpty();
	            if (result) {
	                // its rating shouldn't be negative
	                int rating = movieRating.getUserRating();
	                result = rating >= 0;
                }
            }
        }
	    return result;
    }

}
