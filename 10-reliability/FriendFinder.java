import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * SD2x Homework #10 - Reliability
 * Modify the method below so that it uses defensive programming.
 * Please be sure not to change the method signature!
 *
 * @author Solange U. Gasengayire
 */
public class FriendFinder {
	
	protected ClassesDataSource classesDataSource;
	protected StudentsDataSource studentsDataSource;

	/**
	 * Constructor
	 * @param cds class data source
	 * @param sds student data source
	 */
	public FriendFinder(ClassesDataSource cds, StudentsDataSource sds) {
		classesDataSource = cds;
		studentsDataSource = sds;
	}

	/**
	 * Return friend suggestions based on common classes
	 * @param theStudent the student to suggest friends to
	 * @return friend suggestions
	 */
	public Set<String> findClassmates(Student theStudent) {
		
		String name = theStudent.getName();
		
		// find the classes that this student is taking
		List<String> myClasses = classesDataSource.getClasses(name);
		
		Set<String> classmates = new HashSet<>();
		
		// use the classes to find the names of the students
		for (String myClass : myClasses) {
			// list all the students in the class
			List<Student> students = studentsDataSource.getStudents(myClass);
			
			for (Student student : students) {
				
				// find the other classes that they're taking
				List<String> theirClasses = classesDataSource.getClasses(student.getName());
			
				// see if all of the classes that they're taking are the same as the ones this student is taking
				boolean same = true;
				for (String c : myClasses) {
					
					if (theirClasses.contains(c) == false) {
						same = false;
						break;
					}
				}
				if (same) {
					if (student.getName().equals(name) == false && classmates.contains(student.getName()) == false) 
						classmates.add(student.getName());
				}
			}

		}
				
		if (classmates.isEmpty()) { 
			return null;
		}
		else return classmates;
	}
	

}
