package com.example.java.h_cloning;


public class B_DeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		CourseB science = new CourseB("Physics", "Chemistry", "Biology");
		
		StudentB s1 = new StudentB(111, "John", science);
		StudentB s2 = (StudentB) s1.clone();

		System.out.println(s1.course.subject3); 	// Output: Biology
		s2.course.subject3 = "Maths";
		System.out.println(s1.course.subject3); 	// Output: Biology
	}
}


class StudentB implements Cloneable {
	int id;
	String name;
	CourseB course;

	public StudentB(int id, String name, CourseB course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		StudentB student = (StudentB) super.clone();
		student.course = (CourseB) course.clone();
		return student;
	}
}


class CourseB implements Cloneable {
	String subject1;
	String subject2;
	String subject3;

	public CourseB(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
