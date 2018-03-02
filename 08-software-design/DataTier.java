import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */
public class DataTier {

	// name of the file to be read
	private String fileName;

	/**
	 * Constructor
	 * @param inputSource name of the input file
	 */
	public DataTier(String inputSource) {
		fileName = inputSource;
	}

	/**
	 * Return a list of Book objects
	 * @return book objects
	 */
	public List<Book> getAllBooks() {
		List<Book> books = new LinkedList<>();

		// read data from the input file
		if (fileName != null && !fileName.isEmpty()) {
			try (InputStream fileStream = new FileInputStream(fileName)) {
				BufferedReader reader =
						new BufferedReader(new InputStreamReader(fileStream));
				String line;
				while ((line = reader.readLine()) != null)  {
					// each row of the input file is formatted as follows:
					// [title] tab [author] tab [year]
					String[] data = line.split("\\t");
					Book book = new Book(data[0], data[1], Integer.valueOf(data[2]));
					books.add(book);
				}

			} catch (IOException exception) {
				System.out.println("Error while reading and retrieving data from the input file: "
									+ exception.getMessage());
			}
		}
		return books;
	}

}
