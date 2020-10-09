package com.example.java.l_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


//Use -------------- "Collections.sort(List<T>)" --- T must implement Comparable
//Otherwise use ---- "Collections.sort(List<T>, Comparator<? super T>)


public class F_Sort_Map {
	public static void main(String[] args) {
		sort_MapKeysOf_string_naturalOrder();					System.out.println("----------");
		sort_MapKeysOf_string_customOrder();					System.out.println("----------");
		sort_MapKeysOf_anyObject_implementsComparable();		System.out.println("----------");
		sort_MapKeysOf_anyObject_dontImplementComparable();		System.out.println("----------");
		sort_MapValuesOf_string();								System.out.println("----------");
	}
	
	
	
	
	
	private static void sort_MapKeysOf_string_naturalOrder() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqr");
		map.put("Bob", "abc");
		map.put("Alice", "xyz");
		
		TreeMap<String, String> treemap = new TreeMap<>(map);
		treemap.entrySet().forEach(str->System.out.println(str));
	}
	
	private static void sort_MapKeysOf_string_customOrder() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqr");
		map.put("Bob", "abc");
		map.put("Alice", "xyz");
		
		List<Entry<String, String>> entrylist = new ArrayList<>(map.entrySet());
		Collections.sort(entrylist, (entry1, entry2)->(entry1.getKey().length()-entry2.getKey().length()) );
		entrylist.forEach(entry -> System.out.println(entry.getKey()) );
	}
	
	
	
	
	
	private static void sort_MapKeysOf_anyObject_implementsComparable() {
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
				return this.name.compareTo(st.name);
			}
		}
		Map<Student, String> map = new HashMap<>();
		map.put(new Student("Bob", 66), "vvv");
		map.put(new Student("Alice", 11), "ppp");
		map.put(new Student("Cameron", 33), "ccc");
		
		TreeMap<Student, String> treemap = new TreeMap<>(map);
		treemap.entrySet().forEach(entry -> System.out.println(entry.getKey().getName()) );
	}
	
	private static void sort_MapKeysOf_anyObject_dontImplementComparable() {
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
		Map<Student, String> map = new HashMap<>();
		map.put(new Student("Bob", 66), "vvv");
		map.put(new Student("Alice", 11), "ppp");
		map.put(new Student("Cameron", 33), "ccc");
		
		List<Entry<Student, String>> entrylist = new ArrayList<>(map.entrySet());
		Collections.sort(entrylist, (entry1, entry2)->entry1.getKey().getAge()-entry2.getKey().getAge() );
		entrylist.forEach(entry -> System.out.println(entry.getKey().getName()) );
	}
	
	
	
	private static void sort_MapValuesOf_string() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqr");
		map.put("Bob", "abc");
		map.put("Alice", "xyz");
		
		List<Entry<String, String>> entrylist = new ArrayList<Entry<String, String>>(map.entrySet());
		Collections.sort(entrylist, (entry1,entry2)->entry1.getValue().compareTo(entry2.getValue()));
		entrylist.forEach(str -> System.out.println(str));
	}
	
}
