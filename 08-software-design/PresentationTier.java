/**
 * SD2x Homework #8 - This is the User Interface
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */
public class PresentationTier {

	// link to the Logic tier
	private LogicTier logicTier;

	/**
	 * Constructor
	 * @param logicTier the business logic
	 */
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}

	/**
	 * User interface entry point
	 * Asks the user which feature they would like to use,
	 * invokes the appropriate methods in the appropriate classes.
	 * Once the output has been displayed, the program terminates.
	 */
	public void start() {

	}

	/**
	 * Display the titles of books whose author name includes the input name
	 * @param author the requested author name
	 */
	public void showBookTitlesByAuthor(String author) {

	}

	/**
	 * Display the number of books published in the request year
	 * @param yearString the request year
	 */
	public void showNumberOfBooksInYear(String yearString) {

	}
	

}
