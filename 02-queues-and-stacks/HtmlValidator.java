import java.util.Queue;
import java.util.Stack;

/**
 * SD2x Homework #2 - HTMLValidator implementation using a Stack
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 *
 * @author Solange U. Gasengayire
 */

public class HtmlValidator {

	/**
	 * Determine whether the input HTML tags are well formatted.
	 * @param tags The queue of HTML tags
	 * @return true if the tags are well formatted
	 * 		   false otherwise
	 */
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		// htmlTagStack will be our result stack
		Stack<HtmlTag> htmlTagStack = new Stack<>();

		if (tags != null ) {

			while (! tags.isEmpty()) {
				HtmlTag current = tags.poll();

				// push opening tags onto the stack
				if (current.isOpenTag()) {
					htmlTagStack.push(current);
				} else {
					// when we encounter a closing tag
					if (! current.isSelfClosing()) {

						if (! htmlTagStack.isEmpty()) {
							// check if it matches the top of the stack
							if (current.matches(htmlTagStack.peek())) {
								// remove the corresponding opening tag
								htmlTagStack.pop();
							} else {
								// stop our endeavour when we encouter the first nonmatch
								break;
							}
						} else {
							// we've emptied the stack but there are still tags to be processed
							htmlTagStack = null;
							break;
						}
					}
				}
			}
		}
		
		return htmlTagStack;
	}
	

}

