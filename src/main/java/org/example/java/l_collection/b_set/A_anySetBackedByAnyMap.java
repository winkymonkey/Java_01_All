package org.example.java.l_collection.b_set;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class A_anySetBackedByAnyMap {
	
	public static void main(String[] args) {
		Map<String, Boolean> map = new ConcurrentHashMap<>();
		Set<String> set = Collections.newSetFromMap(map);
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");

		System.out.println("Map is: " + map);
		System.out.println("Set from Map is: " + set);
	}
	
}
