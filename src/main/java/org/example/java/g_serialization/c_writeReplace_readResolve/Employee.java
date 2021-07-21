package org.example.java.g_serialization.c_writeReplace_readResolve;

import java.io.*;


public class Employee implements Serializable {
	private static final long serialVersionUID = -4824652167529907803L;
	
	public int age = 10;

	private Employee() {}
	public static final Employee INSTANCE = new Employee();
	public static Employee getInstance() {
		return INSTANCE;
	}
	
	
	private Object writeReplace() throws ObjectStreamException {				// Replace serialized object with this
		System.out.println("Replacing serializing object by this");
		return INSTANCE;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeInt(age + 2);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		age = ois.readInt() - 6;
	}
	
	private Object readResolve() throws ObjectStreamException {					// Replace serialized object with this
		System.out.println("Replacing deserializing object by this");
		return INSTANCE;
	}
	
}
