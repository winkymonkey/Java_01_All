package com.example.java.l_collection.g_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.java.l_collection.StudentA;


public class D_SortWithNullsFirstOrLast {
	
	public static void main(String[] args) {
		List<StudentA> list = new ArrayList<>();
		list.add(new StudentA("Alice", 66));
		list.add(new StudentA("Cameron", 11));
		list.add(new StudentA("Bob", 33));
		
		// in natural order of "name"
		Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(StudentA::getName)) );
		print(list);
		
		// in natural order of "name". If conflict, then in natural order of "age"
		Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(StudentA::getName).thenComparing(StudentA::getAge)) );
		print(list);
		
		// in custom order of "name"
		Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(StudentA::getName, (name1,name2)->name1.compareTo(name2)).thenComparing(StudentA::getAge)) );
		print(list);
		
		
		
		
		Map<StudentA, String> map = new HashMap<>();
		map.put(new StudentA("Bob", 66), "vvvv");
		map.put(new StudentA("Alice", 11), "ppppp");
		map.put(new StudentA("Cameron", 33), "ccc");
		
		// in natural order of "object key's field"
		List<Entry<StudentA, String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, Comparator.nullsFirst(Comparator.comparing(entry -> entry.getKey().getAge())) );
		print(entryList);
		
		// in custom order of "object key's field"
		List<Entry<StudentA, String>> entryList2 = new ArrayList<>(map.entrySet());
		Collections.sort(entryList2, Comparator.nullsFirst(Comparator.comparing(entry -> entry.getKey().getName().length())) );
		print(entryList2);
	}
	
	private static void print(List<?> list) {
		System.out.println("-------------");
		list.forEach(System.out::println);
	}
	
}
