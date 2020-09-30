package com.example.java.k_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// If T implements Comparable ------- Collections.sort(List<T>)
// If T not implements Comparable --- Collections.sort(List<T>, Comparator<? super T>)


@SuppressWarnings("unused")
public class D_Sort_List {
	public static void main(String[] args) {
		sort_ListOf_string_naturalOrder();			System.out.println("----------");
		sort_ListOf_string_customOrder();			System.out.println("----------");
		sort_ListOf_objectImplementsComparable();	System.out.println("----------");
		sort_ListOf_anyObject();					System.out.println("----------");
		sort_ListOf_anyObject_java8();				System.out.println("----------");
	}
	
	
	
	private static void sort_ListOf_string_naturalOrder() {
		List<String> list = new ArrayList<>();
		list.add("Bob");
		list.add("Alice");
		list.add("Cameron");
		
		Collections.sort(list);
		list.forEach(str->System.out.println(str));			//Alice Bob Cameron
	}
	
	
	
	private static void sort_ListOf_string_customOrder() {
		List<String> list = new ArrayList<>();
		list.add("Cameron");
		list.add("Bob");
		list.add("Alice");
		
		Collections.sort(list, (s1,s2)->(s1.length()-s2.length()) );
		list.forEach(str->System.out.println(str));						//Bob Alice Cameron
	}
	
	
	
	private static void sort_ListOf_objectImplementsComparable() {
		class Student implements Comparable<Student> {
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
			public int compareTo(Student st) {
				return this.getName().compareTo(st.getName());
				//return this.getAge() - st.getAge();
			}
		}
		
		List<Student> list = new ArrayList<>();
		Student s1 = new Student("Bob", 33);
		Student s2 = new Student("Alice", 66);
		Student s3 = new Student("Cameron", 11);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		Collections.sort(list);
		list.forEach(student->System.out.println(student.getName()));	//Alice Bob Cameron
	}
	
	
	
	private static void sort_ListOf_anyObject() {
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
		
		List<Student> list = new ArrayList<>();
		Student s1 = new Student("Bob", 33);
		Student s2 = new Student("Alice", 66);
		Student s3 = new Student("Cameron", 11);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		Collections.sort(list, (st1,st2)->(st1.getName().compareTo(st2.getName())) );
		list.forEach(student->System.out.println(student.getName()));					//Alice Bob Cameron
		System.out.println();
		Collections.sort(list, (st1,st2)->(st1.getAge()-st2.getAge()) );
		list.forEach(student->System.out.println(student.getName()));					//Cameron Bob Alice
	}
	
	
	
	private static void sort_ListOf_anyObject_java8() {
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
		
		List<Student> list = new ArrayList<>();
		Student s1 = new Student("Bob", 33);
		Student s2 = new Student("Alice", 66);
		Student s3 = new Student("Cameron", 11);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		//natural ordering of "name"
		Collections.sort(list, Comparator.comparing(Student::getName));
		
		//natural ordering of "name". If conflict, then compare as per "age"
		Collections.sort(list, Comparator.comparing(Student::getName).thenComparing(Student::getAge));
		
		//custom ordering of "name"
		Collections.sort(list, Comparator.comparing(Student::getName, (st1,st2)->st1.compareTo(st2)) );
	}
}


