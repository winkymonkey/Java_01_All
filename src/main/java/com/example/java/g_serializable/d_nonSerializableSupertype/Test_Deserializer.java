package com.example.java.g_serializable.d_nonSerializableSupertype;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Test_Deserializer {
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		Employee emp = (Employee)ois.readObject();
		ois.close();
		
		System.out.println(emp.age);				//20
		System.out.println(emp.salary);				//0
		System.out.println(Employee.experience);	//0
		System.out.println(emp.weight);				//null
	}
}
