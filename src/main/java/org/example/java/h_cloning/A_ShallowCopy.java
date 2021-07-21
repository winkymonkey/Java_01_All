package org.example.java.h_cloning;


public class A_ShallowCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		CourseA course = new CourseA("Physics", "Chemistry", "Biology");
		
		StudentA sa1 = new StudentA(111, "John", course);
		StudentA sa2 = (StudentA) sa1.clone();
		
		System.out.println(sa1.course.subject3); 	// Output: Biology
		
		sa2.course.subject3 = "Maths";
		
		System.out.println(sa1.course.subject3); 	// Output: Maths
	}
}


class StudentA implements Cloneable {
	int id;
	String name;
	CourseA course;

	public StudentA(int id, String name, CourseA course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}


class CourseA {
	String subject1;
	String subject2;
	String subject3;

	public CourseA(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}
}
