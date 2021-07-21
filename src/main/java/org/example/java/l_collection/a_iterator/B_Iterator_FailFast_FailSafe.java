package org.example.java.l_collection.a_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class B_Iterator_FailFast_FailSafe {
	
	public static void main(String[] args) {
		failFastIterator();
		failSafeIterator();
	}
	
	
	private static void failFastIterator() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
		    Integer k = itr.next();
		    list.remove(k);				//UNSAFE (will throw Exception on calling next() method)
		}
		
		Iterator<Integer> itr2 = list.iterator();
		while (itr2.hasNext()) {
		    if (itr2.next()==2) {
		    	itr2.remove();			//SAFE (will not throw Exception)
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


