import java.util.LinkedList;
import java.util.List;

/**
 * SD2x Homework #8 - Business Logic Unit
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 *
 * @author Solange U. Gasengayire
 */
public class LogicTier {

	// Link to the Data Tier
	private DataTier dataTier;
	private List<Book> books;

	/**
	 * Constructor
	 * @param dataTier the data tier
	 */
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
		this.loadData();
	}

	/**
	 * Return the titles of books whose author name includes the input name
	 * @param author the requested author name
	 * @return a list of book titles
	 */
	public List<String> findBookTitlesByAuthor(String author) {
		List<String> titles = new LinkedList<>();
		for (Book book: books) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				titles.add(book.getTitle());
			}
		}
		return titles;
	}

	/**
	 * Return the number of books published in the requested year
	 * @param year the input year as a string
	 * @return the number of books published in that year
	 */
	public int findNumberOfBooksInYear(String year) {
		int bookCount = 0;
		for (Book book : books) {
			if (book.getPublicationYear() == Integer.valueOf(year)) {
				bookCount++;
			}
		}
		return bookCount;
	}

	/**
	 * Load books data
	 */
	private void loadData() {
		// assume "normal input values", so dataTier can't be null
		this.books = this.dataTier.getAllBooks();
	}
	

}
