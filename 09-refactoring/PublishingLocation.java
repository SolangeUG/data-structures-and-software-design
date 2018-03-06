/**
 * This class represents a publishing location
 * @author Solange U. Gasengayire
 */
public class PublishingLocation {

    private String city;
    private String state;
    private String postCode;

    /**
     * Constructor
     * @param city this publishing city
     * @param state this publishing state
     * @param postCode this publishing postal code
     */
    public PublishingLocation(String city, String state, String postCode) {
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    /**
     * Return this publishing city
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set this publising city
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return this publishing state
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Set this publishing state
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Return this publishing postal code
     * @return the postal code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Set this publishing postal code
     * @param postCode the postal code
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
