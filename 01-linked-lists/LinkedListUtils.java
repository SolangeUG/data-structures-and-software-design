import java.util.Comparator;
import java.util.LinkedList;

/**
 * SD2x Homework #1 - LinkedList methods implementation
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 *
 * @author Solange U. Gasengayire
 */
public class LinkedListUtils {

	/**
	 * Insert a given value into an already sorted LinkedList
	 * @param list The sorted (in non-descending order) list
	 * @param value The value to be added to the list
	 */
	public static void insertSorted(LinkedList<Integer> list, int value) {

		if (list != null) {

			// start from the head node
			int ndx = 0;
			Integer current;
			boolean added = false;

			while (ndx < list.size()) {
				current = list.get(ndx);
				// is the current value is greater than the input value?
				if (current > value) {
					// then, insert the input value at the current value's position.
					list.add(ndx, value);
					added = true;
					break;
				} else {
					// otherwise, move onto the next index
					ndx++;
				}
			}

			// input value hasn't yet been added to the list
			if (! added) {
				// input value will be appended to the end of the list
				list.add(value);
			}
		}
	}

	/**
	 * Remove all instances of the N largest values from a linkedList
	 * @param list The input list
	 * @param N The number of largest values to be removed from the list
	 */
	public static void removeMaximumValues(LinkedList<String> list, int N) {

		// TODO: find an optimized way to do this (without using additional list and array)!

		if (list != null && N > 0) {

			int ndx = 0;
			int count = 0;
			String previous = null;

			// let's copy the input list and sort the copy in reverse order
			LinkedList<String> sortedList = new LinkedList<>(list);
			sortedList.sort(Comparator.reverseOrder());
			String[] unwantedElements = new String[N];

			// collect all elements to be removed into a new list
			while (ndx < sortedList.size() && count < N) {
				String element = sortedList.get(ndx);
				if (! element.equals(previous)) {
					unwantedElements[count] = element;
					previous = element;
					count++;
				}
				ndx++;
			}

			// remove all unwanted elements from original list
			for (ndx = 0; ndx < unwantedElements.length; ndx++) {
				String element = unwantedElements[ndx];
				// make sure all instances of the current word are removed
				while (list.contains(element)) {
					list.remove(element);
				}
			}
		}
	}

	/**
	 * Determine whether a linked list is a subsequence of another linked list
	 * @param one The first (potential container) list
	 * @param two The second (potential subsequence) list
	 * @return true if list two is a subsequence of list one
	 * 		   false otherwise
	 */
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		boolean check = one != null && two != null
					&& !one.isEmpty() && !two.isEmpty();

		if (check) {
			int tCursor = 0;
			Integer current = two.get(tCursor);

			// is the head of list two part of list one?
			int oCursor = one.indexOf(current);
			check = oCursor > -1;

			// are all other elements of list two contained in subsequent order in list one?
			while (check && tCursor < two.size()) {
				tCursor++;
				// make sure we're not out of bounds of list two
				if (tCursor < two.size()) {
					current = two.get(tCursor);
					oCursor++;
					// make sure we're not out of bounds of list one
					check = oCursor < one.size()
							&& one.get(oCursor).equals(current);
				}
			}
		}

		return check;
	}

}
