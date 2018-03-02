import java.util.Scanner;

/**
 * SD2x Homework #8 - This is the User Interface
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 *
 * @author Solange U. Gasengayire
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
		Scanner scanner = new Scanner(System.in);

		String prompt = "What feature of the program would you like to use?\n";
		prompt = prompt + " Enter 1 to display books by a particular author.\n";
		prompt = prompt + " Enter 2 to display books published in a particular year: ";
		System.out.print(prompt);

		// let's assume "normal" input values
		int feature = scanner.nextInt();
		scanner.close();

		if (feature == 1) {
			showBookTitlesByAuthor();
		} else if (feature == 2) {
			showNumberOfBooksInYear();
		}
	}

	/**
	 * Feature #01
	 * Display the titles of books whose author name is specified by the user
	 */
	public void showBookTitlesByAuthor() {
		Scanner scanner = new Scanner(System.in);

		String prompt = "Enter name of author: ";
		System.out.print(prompt);

		// let's assume "normal" input values
		String author = scanner.nextLine();
		scanner.close();

		// TODO : relay this to the business logic unit
		// TODO : display the results
		// TODO : then terminate the program
	}

	/**
	 * Feature #02
	 * Display the number of books published in the year specified by the user
	 */
	public void showNumberOfBooksInYear() {
		Scanner scanner = new Scanner(System.in);

		String prompt = "Enter year of publication: ";
		System.out.print(prompt);

		// let's assume "normal" input values
		String year = scanner.nextLine();
		scanner.close();

		// TODO : relay this to the business logic unit
		// TODO : display the results
		// TODO : then terminate the program
	}
	

}
