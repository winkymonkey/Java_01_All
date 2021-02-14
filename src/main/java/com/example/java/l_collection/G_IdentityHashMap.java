package com.example.java.l_collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;


public class G_IdentityHashMap {
	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("a", 1);
		hashMap.put(new String("a"), 2);
		System.out.println(hashMap);			//{a=2}
		
		
		Map<String, Integer> identityMap = new IdentityHashMap<>();
		identityMap.put("a", 1);
		identityMap.put(new String("a"), 2);
		System.out.println(identityMap);		//{a=1, a=2}
	}
}
