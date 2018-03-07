import java.util.List;

/**
 * SD2x Homework #10
 * This is the empty implementation of the ClassesDataSource.
 * Do not change the signature of the method.
 * You do not need to implement or submit this code.
 */
public interface ClassesDataSource {

	/**
	 * Return a list of the classes being taken by a particular student
	 * @param studentName the student's name
	 * @return a list of their classes
	 */
	public List<String> getClasses(String studentName) ;

}
