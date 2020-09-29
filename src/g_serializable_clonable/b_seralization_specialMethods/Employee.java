package g_serializable_clonable.b_seralization_specialMethods;

import java.io.*;


public class Employee implements Serializable {
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
		oos.writeInt(age*10);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException {
		ois.defaultReadObject();
		age = ois.readInt();
	}
}
