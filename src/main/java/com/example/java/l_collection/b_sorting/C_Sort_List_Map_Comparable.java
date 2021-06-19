package com.example.java.l_collection.b_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.java.l_collection.StudentB;


public class C_Sort_List_Map_Comparable {
	
	public static void main(String[] args) {
		sortListOf_Objects_implementsComparable();
		sortMapKey_Objects_implementsComparable();
	}
	
	
	
	private static void sortListOf_Objects_implementsComparable() {
		List<StudentB> list = new ArrayList<>();
		list.add(new StudentB("Alice", 66));
		list.add(new StudentB("Cameron", 11));
		list.add(new StudentB("Bob", 33));
		
		Collections.sort(list);								// Alice Bob Cameron
		printStudentB(list);
	}
	
	private static void sortMapKey_Objects_implementsComparable() {
		Map<StudentB, String> map = new HashMap<>();
		map.put(new StudentB("Bob", 66), "vvvv");
		map.put(new StudentB("Alice", 11), "ppppp");
		map.put(new StudentB("Cameron", 33), "ccc");
		
		TreeMap<StudentB, String> treemap = new TreeMap<>(map);
		treemap.entrySet().forEach(entry -> System.out.println(entry.getKey().getName()) );
	}
	
	
	
	private static void printStudentB(List<?> list) {
		System.out.println("-------------");
		list.forEach(System.out::println);
	}
	
}
