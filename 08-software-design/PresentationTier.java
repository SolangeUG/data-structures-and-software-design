import java.util.List;
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
	private Scanner scanner;

	/**
	 * Constructor
	 * @param logicTier the business logic
	 */
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
		this.scanner = new Scanner(System.in);
	}

	/**
	 * User interface entry point
	 * Asks the user which feature they would like to use,
	 * invokes the appropriate methods in the appropriate classes.
	 * Once the output has been displayed, the program terminates.
	 */
	public void start() {
        String prompt = "What feature of the program would you like to use?\n";
        prompt = prompt + " Enter 1 to display books by a particular author.\n";
        prompt = prompt + " Enter 2 to display books published in a particular year: ";
        System.out.print(prompt);

        // let's assume "normal" input values
		int feature = scanner.nextInt();

        if (feature == 1) {
            showBookTitlesByAuthor();
        } else if (feature == 2) {
            showNumberOfBooksInYear();
        }

        // ensure to close the scaner
        scanner.close();
        // then terminate the program
        System.exit(0);
    }

	/**
	 * Feature #01
	 * Display the titles of books whose author name is specified by the user
	 */
	public void showBookTitlesByAuthor() {
        String prompt = "\nEnter name of author: ";
        System.out.print(prompt);

        // let's assume "normal" input values
		String author = scanner.next();

		// relay the request to the business logic unit
		List<String> titles = this.logicTier.findBookTitlesByAuthor(author);
		StringBuilder builder = new StringBuilder("\nResults: \n");
		for (String title: titles) {
			builder.append(title);
			builder.append("\n");
		}

		// display the results
		System.out.println(builder.toString());
	}

	/**
	 * Feature #02
	 * Display the number of books published in the year specified by the user
	 */
	public void showNumberOfBooksInYear() {
        String prompt = "\nEnter year of publication: ";
        System.out.print(prompt);

        // let's assume "normal" input values
		String year = scanner.next();

		// relay the request to the business logic unit
		int books = this.logicTier.findNumberOfBooksInYear(year);
		// display the results
		System.out.println("\nNumber of books published in " + year + ": " + books);
	}

}
