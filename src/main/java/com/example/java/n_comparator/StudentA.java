package com.example.java.n_comparator;


public class StudentA {	
	private String name;
	private int age;
	
	public StudentA(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[name=").append(name).append(", age=").append(age).append("]");
		return builder.toString();
	}
	
}
