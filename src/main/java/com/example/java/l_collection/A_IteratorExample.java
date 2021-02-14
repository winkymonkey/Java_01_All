package com.example.java.l_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class A_IteratorExample {
	public static void main(String[] args) {
		iterateOverList();
		iterateOverMap();
	}
	
	
	private static void iterateOverList() {
		List<String> listOfStr = new ArrayList<>();
		listOfStr.add("hhh");
		listOfStr.add("aaa");
		listOfStr.add("kkk");
		
		Iterator<String> itr = listOfStr.iterator();
		while(itr.hasNext()) {
			String elem = itr.next();
			System.out.println(elem);
		}
	}
	
	
	private static void iterateOverMap() {
		Map<String, String> map = new HashMap<>();
		map.put("b1", "pqr");
		map.put("c1", "abc");
		map.put("a1", "xyz");
		
		Iterator<Entry<String, String>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
	}
	
}
