import java.util.List;

/**
 * SD2x Homework #10
 * This is the empty implementation of the StudentsDataSource.
 * Do not change the signature of the method.
 * You do not need to implement or submit this code.
 */
public interface StudentsDataSource {

	/**
	 * Return a list of students who are taking the specified class
	 * @param className the class
	 * @return a the list of student in the class
	 */
	public List<Student> getStudents(String className) ;
	

}
