package k_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


//Use -------------- "Collections.sort(List<T>)" --- T must implement Comparable
//Otherwise use ---- "Collections.sort(List<T>, Comparator<? super T>)


public class F_Sort_Map {
	public static void main(String[] args) {
		sortByKey_stringAsKey();
		sortByKey_stringAsKey_customOrder();
		sortByKey_objectAsKey();
		sortByKey_objectAsKey_customOrder();
		sortByValue();
	}
	
	
	
	private static void sortByKey_stringAsKey() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqr");
		map.put("Bob", "abc");
		map.put("Alice", "xyz");
		
		TreeMap<String, String> treemap = new TreeMap<>(map);
		Set<Entry<String, String>> entryset = treemap.entrySet();
		
		entryset.forEach(str->System.out.println(str));
	}
	
	
	
	private static void sortByKey_stringAsKey_customOrder() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqr");
		map.put("Bob", "abc");
		map.put("Alice", "xyz");
		
		Set<Entry<String, String>> entryset = map.entrySet();
		List<Entry<String, String>> entrylist = new ArrayList<>(entryset);
		Collections.sort(entrylist, (entry1, entry2)->(entry1.getKey().length()-entry2.getKey().length()) );
	}
	
	
	
	private static void sortByKey_objectAsKey() {
		class Student {
			private String name;
			private int age;
			Student(String name, int age) {
				this.name = name;
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public int getAge() {
				return age;
			}
		}
		Map<Student, String> map = new HashMap<>();
		Student s1 = new Student("Cameron", 33);
		Student s2 = new Student("Bob", 66);
		Student s3 = new Student("Alice", 11);
		map.put(s2, "vvv");
		map.put(s3, "ppp");
		map.put(s1, "ccc");
		
		TreeMap<Student, String> treemap = new TreeMap<>(map);
		treemap.entrySet().forEach(entry -> System.out.println(entry.getKey().getName() +","+ entry.getKey().getAge() ));
	}
	
	
	
	private static void sortByKey_objectAsKey_customOrder() {
		class Student {
			private String name;
			private int age;
			Student(String name, int age) {
				this.name = name;
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public int getAge() {
				return age;
			}
		}
		Map<Student, String> map = new HashMap<>();
		Student s1 = new Student("Cameron", 33);
		Student s2 = new Student("Bob", 66);
		Student s3 = new Student("Alice", 11);
		map.put(s2, "vvv");
		map.put(s3, "ppp");
		map.put(s1, "ccc");
		
		Set<Entry<Student, String>> entryset = map.entrySet();
		List<Entry<Student, String>> entrylist = new ArrayList<>(entryset);
		Collections.sort(entrylist, (entry1, entry2)->entry1.getKey().getAge()-entry2.getKey().getAge() );
		entrylist.forEach(entry -> System.out.println(entry.getKey().getName() +","+ entry.getKey().getAge()) );
	}
	
	
	
	private static void sortByValue() {
		Map<String, String> map = new HashMap<>();
		map.put("Cameron", "pqr");
		map.put("Bob", "abc");
		map.put("Alice", "xyz");
		
		Set<Entry<String, String>> entryset = map.entrySet();
		List<Entry<String, String>> entrylist = new ArrayList<Entry<String, String>>(entryset);
		Collections.sort(entrylist, (entry1,entry2)->entry1.getValue().compareTo(entry2.getValue()));
		
		entrylist.forEach(str -> System.out.println(str));
	}
}


