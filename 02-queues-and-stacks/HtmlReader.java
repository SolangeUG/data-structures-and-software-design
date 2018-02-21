import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * SD2x Homework #2
 * This class contains a method that will read an HTML file and convert it to a Queue of HtmlTags.
 * It is simply provided as a convenience class for you to use during your testing.
 * You do not need to submit this code.
 */

public class HtmlReader {

	/**
	 * Return a colelction of HTML tags from a file
	 * @param filename The input file
	 * @return all the HTML tags contained in the file
	 * @throws IOException if the file name isn't valid, or if it can't be read
	 */
	public static Queue<HtmlTag> getTagsFromHtmlFile(String filename) throws IOException {
	     InputStream stream = new FileInputStream(filename);
	     StringBuilder buffer = new StringBuilder();
	     int ch;
	     while ((ch = stream.read()) > 0) {
	         buffer.append((char) ch);
	     }
	     stream.close();
	     String htmlFileString = buffer.toString();
	     return HtmlTag.tokenize(htmlFileString);
	}

	/**
	 * Return a colelction of HTML tags from an input stream
	 * @param stream The input stream
	 * @return all the HTML tags contained in the stream
	 * @throws IOException if there's a problem reading from the stream
	 */
	private static Queue<HtmlTag> getTagsFromHtmlStream(InputStream stream) throws IOException {
		StringBuilder buffer = new StringBuilder();
		int ch;
		while ((ch = stream.read()) > 0) {
			buffer.append((char) ch);
		}
		String htmlFileString = buffer.toString();
		return HtmlTag.tokenize(htmlFileString);
	}

	/**
	 * Tester method
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		try {

			InputStream htmlFile = Objects.requireNonNull(HtmlReader.class.getClassLoader()
								.getResourceAsStream("test7.html"));

			Queue<HtmlTag> htmlTags = getTagsFromHtmlStream(htmlFile);
			Stack<HtmlTag> validator = HtmlValidator.isValidHtml(htmlTags);

			String response = "NO";
			if (validator != null && validator.isEmpty()) {
				response = "YES";
			}
			System.out.println("Is file valid? " + response);
			htmlFile.close();
			
		} catch (IOException exception) {
			System.out.println("IOException : " + exception.getMessage());
		} catch (Exception otherException) {
			otherException.printStackTrace();
		}

	}

}
