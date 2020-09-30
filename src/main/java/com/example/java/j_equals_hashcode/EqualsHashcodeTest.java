package com.example.java.j_equals_hashcode;

import java.util.HashMap;


public class EqualsHashcodeTest {
	public static void main(String[] args) {
		Employee emp1 = new Employee();	Employee emp2 = new Employee();	Employee emp3 = new Employee();
		emp1.setId(100);				emp2.setId(100);				emp3.setId(300);
		emp1.setName("aa");				emp2.setName("aa");				emp3.setName("bb");
		
		HashMap<Employee, String> hash = new HashMap<Employee, String>();
		hash.put(emp1, "value1");
		hash.put(emp2, "value2");
		hash.put(emp3, "value3");
		
		for(Employee movie : hash.keySet()) {
			System.out.println(movie.getId() + " & " +movie.getName());
		}
	}
}


class Employee {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return (id + name.hashCode()); 
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee employee = (Employee) obj;
		return (employee.name.equals(this.name) && employee.id == this.id);
	}
}

