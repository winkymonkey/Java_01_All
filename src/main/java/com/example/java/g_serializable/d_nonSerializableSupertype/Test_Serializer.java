package com.example.java.g_serializable.d_nonSerializableSupertype;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Test_Serializer {
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Employee emp = new Employee(20, 100, 7, 65);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		oos.writeObject(emp);
		oos.close();
		
		System.out.println(emp.age);				//20
		System.out.println(emp.salary);				//100
		System.out.println(Employee.experience);	//7
		System.out.println(emp.weight);				//
	}
}
