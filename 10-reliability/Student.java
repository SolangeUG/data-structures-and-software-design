/**
 * SD2x Homework #10
 * This class represents a student.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 */
public class Student {
	
	protected String name;

	/**
	 * Constructor
	 * @param name the student's name
	 */
	public Student(String name) {
		this.name = name;
	}

	/**
	 * Return the student's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Determine equality between two student objects
	 * @param obj the other student
	 * @return true if the two objects are equal
	 * 		   false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
