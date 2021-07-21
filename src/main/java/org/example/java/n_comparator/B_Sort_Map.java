package org.example.java.n_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class B_Sort_Map {
	
	public static void main(String[] args) {
		sortMapKey_Strings_naturalOrder();
		sortMapKey_Strings_customOrder();
		
		sortMapKey_Objects_legacyStyle();
		sortMapKey_Objects_Java8style();
	}
	
	
	
	/* **************************************************************************************************************** */
	private static void sortMapKey_Strings_naturalOrder() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqrst");
		map.put("Bob", "abc");
		map.put("Alice", "wxyz");
		
		// in natural order of "key"
		List<Entry<String, String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, (entry1, entry2)->(entry1.getKey().compareTo(entry2.getKey())) );			// to compare values use "entry.getValue()"
		print(entryList);
	}
	
	private static void sortMapKey_Strings_customOrder() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqrst");
		map.put("Bob", "abc");
		map.put("Alice", "wxyz");
		
		// in custom order of "key"
		List<Entry<String, String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, (entry1, entry2)->(entry1.getKey().length()-entry2.getKey().length()) );	// to compare values use "entry.getValue()"
		print(entryList);
	}
	
	
	
	/* **************************************************************************************************************** */
	private static void sortMapKey_Objects_legacyStyle() {
		Map<StudentA, String> map = new HashMap<>();
		map.put(new StudentA("Bob", 66), "vvvv");
		map.put(new StudentA("Alice", 11), "ppppp");
		map.put(new StudentA("Cameron", 33), "ccc");
		
		// in natural order of "object key's field"
		List<Entry<StudentA, String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, (entry1, entry2)->entry1.getKey().getAge()-entry2.getKey().getAge() );
		print(entryList);
		
		// in custom order of "object key's field"
		List<Entry<StudentA, String>> entryList2 = new ArrayList<>(map.entrySet());
		Collections.sort(entryList2, (entry1, entry2)->entry1.getKey().getName().length()-entry2.getKey().getName().length() );
		print(entryList2);;
	}
	
	private static void sortMapKey_Objects_Java8style() {
		Map<StudentA, String> map = new HashMap<>();
		map.put(new StudentA("Bob", 66), "vvvv");
		map.put(new StudentA("Alice", 11), "ppppp");
		map.put(new StudentA("Cameron", 33), "ccc");
		
		// in natural order of "object key's field"
		List<Entry<StudentA, String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, Comparator.comparing(entry -> entry.getKey().getAge()) );
		print(entryList);
		
		// in custom order of "object key's field"
		List<Entry<StudentA, String>> entryList2 = new ArrayList<>(map.entrySet());
		Collections.sort(entryList2, Comparator.comparing(entry -> entry.getKey().getName().length()) );
		print(entryList2);
	}
	
	
	
	private static void print(List<?> entryList) {
		System.out.println("-------------");
		entryList.forEach(System.out::println);
	}
	
}
