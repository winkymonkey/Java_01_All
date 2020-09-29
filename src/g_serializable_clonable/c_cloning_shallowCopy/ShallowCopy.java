package g_serializable_clonable.c_cloning_shallowCopy;


class Course {
	String subject1;
	String subject2;
	String subject3;

	public Course(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}
}


class Student implements Cloneable {
	int id;
	String name;
	Course course;

	public Student(int id, String name, Course course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}


public class ShallowCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		Course course = new Course("Physics", "Chemistry", "Biology");
		Student student1 = new Student(111, "John", course);
		Student student2 = (Student) student1.clone();
		
		System.out.println(student1.course.subject3); 	// Output: Biology
		student2.course.subject3 = "Maths";
		System.out.println(student1.course.subject3); 	// Output: Maths
	}
}
