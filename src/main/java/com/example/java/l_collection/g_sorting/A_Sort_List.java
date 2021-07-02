package com.example.java.l_collection.g_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.java.l_collection.StudentA;


public class A_Sort_List {
	
	public static void main(String[] args) {
		sortListOf_Strings_naturalOrder();
		sortListOf_Strings_customOrder();
		sortListOf_Strings_reverseOrder();
		
		sortListOf_Objects_legacyStyle();
		sortListOf_Objects_Java8style();
	}
	
	
	
	/* **************************************************************************************************************** */
	private static void sortListOf_Strings_naturalOrder() {
		List<String> list = new ArrayList<>();
		list.add("Alice");
		list.add("Cameron");
		list.add("Bob");
		
		// in natural order
		Collections.sort(list);												// Alice Bob Cameron
		print(list);
	}
	
	private static void sortListOf_Strings_customOrder() {
		List<String> list = new ArrayList<>();
		list.add("Alice");
		list.add("Cameron");
		list.add("Bob");
		
		// in custom order
		Collections.sort(list, (s1,s2)->(s1.length()-s2.length()) );		// Bob Alice Cameron
		print(list);
	}
	
	private static void sortListOf_Strings_reverseOrder() {
		List<String> list = new ArrayList<>();
		list.add("Alice");
		list.add("Cameron");
		list.add("Bob");
		
		// in reverse order
		Collections.sort(list, Comparator.reverseOrder() );					// Cameron Bob Alice
		print(list);
	}
	
	
	
	/* **************************************************************************************************************** */
	private static void sortListOf_Objects_legacyStyle() {
		List<StudentA> list = new ArrayList<>();
		list.add(new StudentA("Alice", 66));
		list.add(new StudentA("Cameron", 11));
		list.add(new StudentA("Bob", 33));
		
		// in natural order of "name"
		Collections.sort(list, (s1,s2)->(s1.getName().compareTo(s2.getName())) );				// Alice Bob Cameron
		print(list);
		
		// in custom order of "name"
		Collections.sort(list, (s1,s2)->(s1.getName().length()-s2.getName().length()) );		// Cameron Bob Alice
		print(list);
	}
	
	private static void sortListOf_Objects_Java8style() {
		List<StudentA> list = new ArrayList<>();
		list.add(new StudentA("Alice", 66));
		list.add(new StudentA("Cameron", 11));
		list.add(new StudentA("Bob", 33));
		
		// in natural order of "name"
		Collections.sort(list, Comparator.comparing(StudentA::getName) );
		print(list);
		
		// in natural order of "name". If conflict, then in natural order of "age"
		Collections.sort(list, Comparator.comparing(StudentA::getName).thenComparing(StudentA::getAge) );
		print(list);
		
		// in custom order of "name"
		Collections.sort(list, Comparator.comparing(StudentA::getName, (name1,name2)->name1.compareTo(name2)).thenComparing(StudentA::getAge) );
		print(list);
	}
	
	
	
	private static void print(List<?> list) {
		System.out.println("-------------");
		list.forEach(System.out::println);
	}
	
}
