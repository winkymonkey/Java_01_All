package com.example.java.k_collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class B_Iterator_Map {
	public static void main(String[] args) {
		iterate_listOfString();
		//iterate_listOfObject();	//same as above
	}
	
	
	private static void iterate_listOfString() {
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


