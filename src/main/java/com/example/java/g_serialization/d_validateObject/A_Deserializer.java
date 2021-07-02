package com.example.java.g_serialization.d_validateObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class A_Deserializer {
	
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		Employee emp2 = (Employee)in.readObject();
		in.close();
		
		System.out.println(emp2.age);				// already caught an exception, hence not deserialized
		System.out.println(emp2.salary);			// already caught an exception, hence not deserialized
		System.out.println(Employee.experience);	// already caught an exception, hence not deserialized
	}
	
}
