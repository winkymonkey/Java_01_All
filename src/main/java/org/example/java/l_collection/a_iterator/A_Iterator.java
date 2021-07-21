package org.example.java.l_collection.a_iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class A_Iterator {
	
	public static void main(String[] args) {
		iterateOverList();
		iterateOverMap();
	}
	
	
	private static void iterateOverList() {
		List<String> list = new ArrayList<>();
		list.add("hhh");
		list.add("aaa");
		list.add("kkk");
		
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
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
		while (itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			System.out.println(entry);
		}
	}
	
}
