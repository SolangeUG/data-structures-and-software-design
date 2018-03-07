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

		// The input value shouldn't be null
		if (theStudent == null || theStudent.getName() == null) {
			throw new IllegalArgumentException("Input value theStudent is null or inappropriate");
		}

		// The internal property classesDataSource shouldn't be null
		if (classesDataSource == null || studentsDataSource == null) {
			throw new IllegalStateException("Interal properties classesDataSource and studentsDataSource shouldn't be null");
		}

		Set<String> classmates = new HashSet<>();
		String name = theStudent.getName();

		if (name != null) {

			// find the classes that this student is taking
			List<String> myClasses = classesDataSource.getClasses(name);

			// Make sure that the list of classes returned previously isn't null
			if (myClasses != null) {

				// use the classes to find the names of the students
				for (String myClass : myClasses) {

					// Make sure the list of classes does not contain any null values
					if (myClass != null) {

						// list all the students in the class
						List<Student> students = studentsDataSource.getStudents(myClass);

						// Make sure that the list of students returned previously isn't null or empty
						if (students != null && !students.isEmpty()) {

							for (Student student : students) {

								// Make sure the list of students does not contain any null values
								if (student != null && student.getName() != null) {

									// find the other classes that they're taking
									List<String> theirClasses = classesDataSource.getClasses(student.getName());

									// Make sure that theirClasses is not null
									if (theirClasses != null && ! theirClasses.isEmpty()) {

										// see if all of the classes that they're taking are the same as the ones this student is taking
										boolean same = true;
										for (String c : myClasses) {
											// Make sure the list of classes does not contain any null values
											if (c != null) {
												if (! theirClasses.contains(c)) {
													same = false;
													break;
												}
											}
										}
										if (same) {
											if (! student.getName().equals(name) && !classmates.contains(student.getName()))
												classmates.add(student.getName());
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (classmates.isEmpty())
			return null;
		else
			return classmates;
	}
	

}
