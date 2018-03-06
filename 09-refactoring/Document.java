import java.util.Date;

/**
 * This class represents any published document.
 * @author Solange U. Gasengayire
 */
public abstract class Document {

    private String title;
    private String author;
    private Date date;
    private PublishingLocation location;

    /**
     * Constructor
     * @param title this document's title
     * @param author this document's author
     * @param date this document's date
     * @param city this document's publishing city
     * @param state this document's publishing state
     * @param postCode this document's publishing postal code
     */
    public Document(String title, String author, Date date, String city, String state, String postCode) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.location = new PublishingLocation(city, state, postCode);
    }

    /**
     * Return this document's title
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set this document's title
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return this document's author
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set this document's author
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Return this document's date
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set this document's date
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Return this document publishing location
     * @return the location
     */
    public PublishingLocation getLocation() {
        return location;
    }

    /**
     * Set this document's publishing location
     * @param location the location
     */
    public void setLocation(PublishingLocation location) {
        this.location = location;
    }

    /**
     * Return this document's publishing city
     * @return the city
     */
    public String getCity() {
        return this.location.getCity();
    }

    /**
     * Return this document's publishing state
     * @return the state
     */
    public String getState() {
        return this.location.getState();
    }

    /**
     * Return this document's publishing postal code
     * @return the postal code
     */
    public String getPostCode() {
        return this.location.getPostCode();
    }

    /**
     * Compare document's date to a general date
     * @param date the general date
     * @return the comparison result
     */
    public int compareWithGeneralDate(Date date){
        // Refactoring: use of Extract Superclass pattern
        return this.date.compareTo(date);
    }

    /**
     * Compare document's date to another document's date
     * @param article the other document
     * @return the comparison result
     */
    public int compareDates(Document article){
        // Refactoring: use of Extract Superclass pattern
        return this.date.compareTo(article.getDate());
    }

    /**
     * Compare this article's author to another document's author
     * @param article the other document
     * @return the comparison result
     */
    public boolean sameAuthor(Document article){
        // Refactoring: use of Extract Superclass pattern
        return this.author.equals(article.getAuthor());
    }
}
