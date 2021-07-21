package org.example.java.p_stream;


public class Student {
	private int id;
	private String name;
	private String role;
	private String location;
	
	Student(int id, String name, String role, String location) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String getLocation() {
		return location;
	}
	
}
