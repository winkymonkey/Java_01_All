package org.example.java.g_serialization.b_readObject_writeObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class A_Deserializer {
	
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		Employee emp = (Employee)in.readObject();
		in.close();
		
		System.out.println(emp.age);				// 16		// 20+2-6=16
		System.out.println(emp.salary);				// 0
		System.out.println(Employee.experience);	// 0
	}
	
}
