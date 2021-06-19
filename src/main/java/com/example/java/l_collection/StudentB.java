package com.example.java.l_collection;


public class StudentB implements Comparable<StudentB> {	
	private String name;
	private int age;
	
	public StudentB(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public int compareTo(StudentB st) {
		return this.getName().compareTo(st.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[name=").append(name).append(", age=").append(age).append("]");
		return builder.toString();
	}
	
}
