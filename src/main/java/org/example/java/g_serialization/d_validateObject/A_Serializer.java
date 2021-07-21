package org.example.java.g_serialization.d_validateObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class A_Serializer {
	
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Employee emp = new Employee(20, 100, 7);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(emp);
		out.close();
		
		System.out.println(emp.age);				// 20
		System.out.println(emp.salary);				// 100
		System.out.println(Employee.experience);	// 7
	}
	
}
