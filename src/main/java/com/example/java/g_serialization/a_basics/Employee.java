package com.example.java.g_serialization.a_basics;

import java.io.*;


public class Employee implements Serializable {
	private static final long serialVersionUID = 400105064724244567L;
	
	public int age;
	public transient int salary;
	public static int experience;

	public Employee(int age, int salary, int experience) {
		this.age = age;
		this.salary = salary;
		Employee.experience = experience;
	}
	
}
