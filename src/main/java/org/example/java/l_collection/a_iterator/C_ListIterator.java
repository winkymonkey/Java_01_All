package org.example.java.l_collection.a_iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class C_ListIterator {
	
	public static void main(String[] args) {
		iterateOverList();
		iterateOverMap();
	}
	
	
	private static void iterateOverList() {
		List<String> list = new ArrayList<>();
		list.add("hhh");
		list.add("aaa");
		list.add("kkk");
		list.add("ppp");
		list.add("ggg");
		
		System.out.println("---------------");
		ListIterator<String> itr = list.listIterator();
		while (itr.hasNext()) {
			String elem = itr.next();
			System.out.println(elem);
		}
		
		System.out.println("---------------");
		ListIterator<String> itr2 = list.listIterator(list.size());
		while (itr2.hasPrevious()) {
			String elem = itr2.previous();
			System.out.println(elem);
		}
		
		System.out.println("---------------");
		ListIterator<String> itr3 = list.listIterator(list.size());
		System.out.println(itr3.nextIndex());
		System.out.println(itr3.previousIndex());
	}
	
	
	private static void iterateOverMap() {
		// TODO
	}
	
}
