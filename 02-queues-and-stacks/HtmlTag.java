import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * SD2x Homework #2
 * This class represents a single HTML tag.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 */

public class HtmlTag {

    protected final String element;
    protected final boolean openTag;

    /**
     * Constructor
     * @param element input string
     * @param isOpenTag value that determines whether the input string is an opening tag
     */
    public HtmlTag(String element, boolean isOpenTag) {
        this.element = element.toLowerCase();
        openTag = isOpenTag;
    }

    /**
     * Return this HTML tag element
     * @return element
     */
    public String getElement() {
        return element;
    }

    /**
     * Is this HTML tag an opening tag?
     * @return true if it's an opening tag
     *         false otherwise
     */
    public boolean isOpenTag() {
   	    return openTag && !isSelfClosing();
    }

    /**
     * Determine whether the input tag is a closing match to this
     * @param other input HTML tag
     * @return true if it's a closing match
     *         false otherwise
     */
    public boolean matches(HtmlTag other) {
        return other != null 
        	&& element.equalsIgnoreCase(other.element)
        	&& openTag != other.openTag;
    }

    /**
     * Determine whether this tag is self-closing
     * @return true if it is
     *         false otherwise
     */
    public boolean isSelfClosing() {
        return SELF_CLOSING_TAGS.contains(element);
    }

    /**
     * Is this tag equal to that tag?
     * @param obj That (other) tag
     * @return true if they are equal
     *         false otherwise
     */
    public boolean equals(Object obj) {
        if (obj instanceof HtmlTag) {
            HtmlTag other = (HtmlTag) obj;
            return element.equals(other.element)
            	&& openTag == other.openTag;
        }
        return false;
    }

    /**
     * String representation of this class
     * @return a an object of this class as a string
     */
    public String toString() {
        return "<" + (openTag ? "" : "/")
        	+ (element.equals("!--") ? "!-- --" : element) + ">";
    }
    
    /**
     * The remaining fields and functions are related to HTML file parsing.
     */

    // a set of tags that don't need to be matched (self-closing)
    protected static final Set<String> SELF_CLOSING_TAGS = new HashSet<>(
            Arrays.asList("!doctype", "!--", "?xml", "xml", "area", "base",
                          "basefont", "br", "col", "frame", "hr", "img",
                          "input", "link", "meta", "param"));

    
    protected static final String WHITESPACE = " \f\n\r\t";

    /**
     * Return a a list of tokens from a given text
     * @param text The input text
     * @return a queue of tokens
     */
    public static Queue<HtmlTag> tokenize(String text) {
        StringBuffer buf = new StringBuffer(text);
        Queue<HtmlTag> queue = new LinkedList<HtmlTag>();

        HtmlTag nextTag = nextTag(buf);
        while (nextTag != null) {
            queue.add(nextTag);
            nextTag = nextTag(buf);
        }
        return queue;
    }

    /**
     * Return the next HTML tag from a buffer
     * @param buf The input buffer
     * @return the next HTML tag
     */
    protected static HtmlTag nextTag(StringBuffer buf) {
        int openBracket = buf.indexOf("<");
        int closeBracket = buf.indexOf(">");
        if (openBracket >= 0 && closeBracket > openBracket) {
            // check for HTML comments: <!-- -->
        	int commentIndex = openBracket + 4;
            if (commentIndex <= buf.length()
            		&& buf.substring(openBracket + 1, commentIndex).equals("!--")) {
                // look for closing comment tag -->
                closeBracket = buf.indexOf("-->", commentIndex);
                if (closeBracket < 0) {
                    return null;
                } else {
                    buf.insert(commentIndex, " ");
                    closeBracket += 3;    // advance to the closing bracket >
                }
            }

            String element = buf.substring(openBracket + 1, closeBracket).trim();
            // remove attributes
            for (int i = 0; i < WHITESPACE.length(); i++) {
                int attributeIndex = element.indexOf(WHITESPACE.charAt(i));
                if (attributeIndex >= 0) {
                    element = element.substring(0, attributeIndex);
                }
            }
            
            // determine whether opening or closing tag
            boolean isOpenTag = true;
            int checkForClosing = element.indexOf("/");
            if (checkForClosing == 0) {
                isOpenTag = false;
                element = element.substring(1);
            }
            element = element.replaceAll("[^a-zA-Z0-9!-]+", "");
            
            buf.delete(0, closeBracket + 1);
            return new HtmlTag(element, isOpenTag);
        } else {
            return null;
        }
    }    
}