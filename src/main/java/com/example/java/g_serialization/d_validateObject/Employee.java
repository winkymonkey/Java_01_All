package com.example.java.g_serialization.d_validateObject;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Employee implements Serializable, ObjectInputValidation {
	private static final long serialVersionUID = -4824652167529907803L;
	
	public int age;
	public transient int salary;
	public static int experience;

	public Employee(int age, int salary, int experience) {
		this.age = age;
		this.salary = salary;
		Employee.experience = experience;
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeInt(age + 2);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException {
		ois.registerValidation(this, 0);	//register validation
		ois.defaultReadObject();
		age = ois.readInt() - 6;
	}
	
	public void validateObject() throws InvalidObjectException {
		System.out.println("validating age");
		if (age<18 || age>70) {
			throw new IllegalArgumentException("Not a valid age");
		}
	}
}
