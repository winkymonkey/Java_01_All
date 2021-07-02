package com.example.java.l_collection.f_collectionStoringNullElem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


public class CollectionStoringNullElements {
	
	public static void main(String[] args) {
		/**************************************************/
		try {
			List<String> list = new ArrayList<>();
			list.add(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**************************************************/
		try {
			List<String> list = new LinkedList<>();
			list.add(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**************************************************/
		try {
			List<String> list = new CopyOnWriteArrayList<>();
			list.add(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		/**************************************************/
		try {
			Set<String> set = new HashSet<>();
			set.add(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**************************************************/
		try {
			Set<String> set = new LinkedHashSet<>();
			set.add(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**************************************************/
		try {
			Set<String> set = new CopyOnWriteArraySet<>();
			set.add(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**************************************************/
		try {
			Set<String> set = new TreeSet<>();
			set.add(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		/**************************************************/
		try {
			Map<String, String> map = new HashMap<>();
			map.put(null, "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**************************************************/
		try {
			Map<String, String> map = new LinkedHashMap<>();
			map.put(null, "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**************************************************/
		try {
			Map<String, String> map = new ConcurrentHashMap<>();
			map.put(null, "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/**************************************************/
		try {
			Map<String, String> map = new TreeMap<>();
			map.put(null, "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
