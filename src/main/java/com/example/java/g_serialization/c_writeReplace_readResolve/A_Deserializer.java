package com.example.java.g_serialization.c_writeReplace_readResolve;

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
		
		System.out.println(emp.age);				// 10
	}
	
}
