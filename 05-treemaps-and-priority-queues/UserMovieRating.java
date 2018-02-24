/**
 * SD2x Homework #5 - Movie Rating
 * This class represents a single rating for a movie.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 *
 * @author Solange U. Gasengayire
 */
public class UserMovieRating implements Comparable<UserMovieRating> {

	protected String movie;
	protected int userRating;

	/**
	 * Constructor
	 * @param movie the title of the movie
	 * @param userRating the user rating of the movie
	 */
	public UserMovieRating(String movie, int userRating) {
		this.movie = movie;
		this.userRating = userRating;
	}

	/**
	 * Return this movie's title
	 * @return the title
	 */
	public String getMovie() {
		return movie;
	}

	/**
	 * Return this movie's rating
	 * @return the rating
	 */
	public int getUserRating() {
		return userRating;
	}

	/**
	 * Determine equality between two movies
	 * @param obj the other movie
	 * @return true of this and the other movie are equal
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
		UserMovieRating other = (UserMovieRating) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (userRating != other.userRating)
			return false;
		return true;
	}

	/**
	 * Compare this movie to another
	 * @param other the other movie to compare to
	 * @return the result of the comparison
	 */
	@Override
	public int compareTo(UserMovieRating other) {
		return this.userRating - other.userRating;
	}
	
	
}
