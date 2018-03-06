import java.util.*;

/**
 * SD2x Homework #9 - Refactoring
 * This class represents a newspaper article.
 * Refactor the code according to the suggestions in the assignment description.
 */
public class NewspaperArticle {

	private String title;
	private String author;
	private int startPage;
	private int endPage;
	private Set<String> editors;
	private String newspaper;
	private Date date;

	// Refactoring: extract city, state and postCode into a new class
	private PublishingLocation publishingLocation;
	
	public NewspaperArticle(String title, String author, int startPage, int endPage, Set<String> editors,
							String newspaper, Date date, String city, String state, String postCode) {
		this.title = title;
		this.author = author;
		this.startPage = startPage;
		this.endPage = endPage;
		this.editors = editors;
		this.newspaper = newspaper;
		this.date = date;
		this.publishingLocation =
				new PublishingLocation(city, state, postCode);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public Set<String> getEditors() {
		return editors;
	}
	
	public String getNewspaper() {
		return newspaper;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getCity() {
		return this.publishingLocation.getCity();
	}
	
	public String getState() {
		return this.publishingLocation.getState();
	}
	
	public String getPostCode() {
		return this.publishingLocation.getPostCode();
	}

	/**
	 * Return this article's publishing location
	 * @return the publishing location
	 */
	public PublishingLocation getPublishingLocation() {
		return this.publishingLocation;
	}
	
	public int numPages(){
		return endPage - startPage + 1;
	}
	
	public boolean sameAuthor(NewspaperArticle article){
		return this.author.equals(article.author);
	}
	
	public boolean sameNewspaper(NewspaperArticle article) {
		return this.newspaper.equals(article.newspaper);
	}
	
	public int numEditors(){
		return editors.size();
	}
	
	public Set<String> commonEditors(NewspaperArticle article){
		Set<String> sameEditors = new HashSet<>();
		for(String ed : article.editors){
			if(this.editors.contains(ed)){
				sameEditors.add(ed);
			}
		}
		return sameEditors;
	}
	
	public int compareDates(NewspaperArticle article){
		return this.date.compareTo(article.date);
	}
	
	public int compareWithGeneralDate(Date date){
		return this.date.compareTo(date);
	}
	
}
