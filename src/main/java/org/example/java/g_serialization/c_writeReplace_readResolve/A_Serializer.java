package org.example.java.g_serialization.c_writeReplace_readResolve;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class A_Serializer {
	
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Employee emp = Employee.getInstance();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(emp);
		out.close();
	}
	
}
