package g_serializable_clonable.b_seralization_specialMethods;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Test_Serializer {
	private static final String filename = "employee.dat";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Employee emp = new Employee(30, 100, 7);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(emp);
		out.close();
		
		System.out.println(emp.age);
		System.out.println(emp.salary);
		System.out.println(Employee.experience);
	}
}
