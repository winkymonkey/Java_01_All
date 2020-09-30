package com.example.java.k_collection;

import java.util.LinkedHashMap;
import java.util.Map;


public class LinkedHashMap_AccessOrder {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>(16, 0.75F, true);
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "--" + entry.getValue()));
		
		System.out.println(map.get("B"));
		
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "--" + entry.getValue()));
	}
}


