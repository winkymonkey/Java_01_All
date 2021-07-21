package org.example.java.g_serialization.e_nonSerializableSupertype;

import java.io.*;


public class Employee extends Person implements Serializable {
	private static final long serialVersionUID = 400105064724244567L;
	
	public int age;
	public transient int salary;
	public static int experience;

	public Employee(int age, int salary, int experience, int weight) {
		this.age = age;
		this.salary = salary;
		Employee.experience = experience;
		super.weight = weight;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeInt(age + 2);
		oos.writeInt(super.weight);
	}
	private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException {
		ois.defaultReadObject();
		age = ois.readInt() - 6;
		super.weight = ois.readInt();
	}
	
}
