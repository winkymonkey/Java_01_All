package com.example.java.k_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class A_Iterator_List {
	public static void main(String[] args) {
		iterate_listOfString();
		iterate_listOfObject();
	}
	
	
	private static void iterate_listOfString() {
		List<String> listOfStr = new ArrayList<>();
		listOfStr.add("hhh");
		listOfStr.add("aaa");
		listOfStr.add("kkk");
		
		Iterator<String> itr = listOfStr.iterator();
		while(itr.hasNext()) {
			String elem = itr.next();
			System.out.println(elem);
		}
	}
	
	
	private static void iterate_listOfObject() {
		class Student {
			private String name;
			private int age;
			Student(String name, int age) {
				this.name = name;
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public int getAge() {
				return age;
			}
		}
		List<Student> listOfStudent = new ArrayList<>();
		Student s1 = new Student("GGG", 666);
		Student s2 = new Student("OOO", 111);
		Student s3 = new Student("AAA", 333);
		listOfStudent.add(s1);
		listOfStudent.add(s2);
		listOfStudent.add(s3);
		
		Iterator<Student> itr = listOfStudent.iterator();
		while(itr.hasNext()) {
			Student student = itr.next();
			System.out.println(student.getName() + "---" + student.getAge());
		}
	}
}


