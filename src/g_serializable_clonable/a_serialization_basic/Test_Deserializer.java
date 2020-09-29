package g_serializable_clonable.a_serialization_basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Test_Deserializer {
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		Employee emp2 = (Employee)in.readObject();
		in.close();
		
		System.out.println(emp2.age);				//30
		System.out.println(emp2.salary);			//0
		System.out.println(Employee.experience);	//0
	}
}
