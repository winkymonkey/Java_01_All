package com.example.java.l_collection.c_map;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;


public class C_WeakHashMap {
	
	public static void main(String[] args) throws InterruptedException {
		Employee emp = new Employee();
		Map<Employee, String> hmap = new HashMap<>();
		hmap.put(emp, "aaa");
		
		emp = null;
		System.gc();
		Thread.sleep(3000);
		System.out.println(hmap);
		
		/* ************************************************* */
		Employee emp2 = new Employee();
		Map<Employee, String> weakMap = new WeakHashMap<>();
		weakMap.put(emp2, "aaa");
		
		emp2 = null;
		System.gc();
		Thread.sleep(3000);
		System.out.println(weakMap);
	}
	
	static class Employee {
		public String toString() {
			return "employee";
		}
		public void finalize() {
			System.out.println("eligible for garbage collection");
		}
	}
	
}
