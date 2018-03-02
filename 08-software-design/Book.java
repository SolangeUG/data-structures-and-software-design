/**
 * SD2x Homework #8
 * This class represents a single book.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 */
public class Book implements Comparable<Book> {

	/**
	 * String representation of this book
	 * @return this book as a string
	 */
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author
				+ ", publicationYear=" + publicationYear + "]";
	}

	protected String title;
	protected String author;
	protected int publicationYear;

	/**
	 * Constructor
	 * @param title book title
	 * @param author book author
	 * @param year year of publication
	 */
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.publicationYear = year;
	}

	/**
	 * Return this book's title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Return this book's author
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Return this book's publication year
	 * @return publication year
	 */
	public int getPublicationYear() {
		return publicationYear;
	}

	/**
	 * Determine equality between two books
	 * @param obj the other object
	 * @return true if this book is equal to the other
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (publicationYear != other.publicationYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * Compare this book to the other
	 * @param other the other book to compare to
	 * @return the result of the comparison
	 */
	@Override
	public int compareTo(Book other) {
		return this.publicationYear - other.publicationYear;
	}

	/**
	 * Integer representation of this book
	 * @return this book as an int
	 */
	@Override
	public int hashCode() {
		return this.author.hashCode();
	}
	
}
