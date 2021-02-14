package com.example.java.l_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class B_Iterator_FailFast_FailSafe {
	public static void main(String[] args) {
		failFastIterator_CollectionRemove();
		failFastIterator_IteratorRemove();
		failSafeIterator();
	}
	
	private static void failFastIterator_CollectionRemove() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
		    Integer k = itr.next();
		    list.remove(k);				//UNSAFE (will throw Exception on calling next() method)
		}
	}
	
	private static void failFastIterator_IteratorRemove() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
		    if (itr.next()==2) {
		    	itr.remove();			//SAFE (will not throw Exception)
		    }
		}
	}
	
	private static void failSafeIterator() {
		List<Integer> list = new CopyOnWriteArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
		    Integer k = itr.next();
		    list.remove(k);
		}
	}
}


