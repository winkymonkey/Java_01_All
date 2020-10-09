package com.example.java.l_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// If T implements Comparable ------- Collections.sort(List<T>)
// If T not implements Comparable --- Collections.sort(List<T>, Comparator<? super T>)


public class D_Sort_List {
	public static void main(String[] args) {
		sort_ListOf_string_naturalOrder();							System.out.println("----------");
		sort_ListOf_string_customOrder();							System.out.println("----------");
		sort_ListOf_object_implementsComparable();					System.out.println("----------");
		sort_ListOf_object_dontImplementComparable();				System.out.println("----------");
		sort_ListOf_object_dontImplementComparable_Java8style();	System.out.println("----------");
	}
	
	
	
	
	
	private static void sort_ListOf_string_naturalOrder() {
		List<String> list = new ArrayList<>();
		list.add("Alice");
		list.add("Cameron");
		list.add("Bob");
		
		Collections.sort(list);
		list.forEach(str->System.out.println(str));							//Alice Bob Cameron
	}
	
	private static void sort_ListOf_string_customOrder() {
		List<String> list = new ArrayList<>();
		list.add("Alice");
		list.add("Cameron");
		list.add("Bob");
		
		Collections.sort(list, (s1,s2)->(s1.length()-s2.length()) );
		list.forEach(str->System.out.println(str));							//Bob Alice Cameron
	}
	
	
	
	
	
	private static void sort_ListOf_object_implementsComparable() {
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
			@SuppressWarnings("unused")
			public int getAge() {
				return age;
			}
			public int compareTo(Student st) {
				return this.getName().compareTo(st.getName());
				//return this.getAge() - st.getAge();
			}
		}
		List<Student> list = new ArrayList<>();
		list.add(new Student("Alice", 66));
		list.add(new Student("Cameron", 11));
		list.add(new Student("Bob", 33));
		
		Collections.sort(list);
		list.forEach(student->System.out.println(student.getName()));		//Alice Bob Cameron
	}
	
	
	private static void sort_ListOf_object_dontImplementComparable() {
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
		list.add(new Student("Alice", 66));
		list.add(new Student("Cameron", 11));
		list.add(new Student("Bob", 33));
		
		Collections.sort(list, (st1,st2)->(st1.getAge()-st2.getAge()) );
		list.forEach(student->System.out.println(student.getName()));			//Cameron Bob Alice
	}
	
	
	private static void sort_ListOf_object_dontImplementComparable_Java8style() {
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
		list.add(new Student("Alice", 66));
		list.add(new Student("Cameron", 11));
		list.add(new Student("Bob", 33));
		
		//natural ordering of "name"
		Collections.sort(list, Comparator.comparing(Student::getName));
		
		//natural ordering of "name". If conflict, then compare as per "age"
		Collections.sort(list, Comparator.comparing(Student::getName).thenComparing(Student::getAge));
		
		//custom ordering of "name"
		Collections.sort(list, Comparator.comparing(Student::getName, (st1,st2)->st1.compareTo(st2)) );
	}
	
}
