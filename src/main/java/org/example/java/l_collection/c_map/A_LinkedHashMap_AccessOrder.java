package org.example.java.l_collection.c_map;

import java.util.LinkedHashMap;
import java.util.Map;


public class A_LinkedHashMap_AccessOrder {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>(16, 0.75F, true);
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		
		map.entrySet().forEach(entry -> System.out.println(entry.getKey()));
		
		System.out.println(map.get("B"));
		
		map.entrySet().forEach(entry -> System.out.println(entry.getKey()));
	}	

}
