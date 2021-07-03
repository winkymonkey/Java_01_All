package com.example.java.p_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class C_TerminalOps_collectorAPI {
	
	public static void main(String[] args) {
		/*--------------------------------------------------------------------------------------------------*/
		List<String> strList = Arrays.asList("Reflection","Collection","Stream","Static","Static","Reflection","Final");
		List<Student> objList = Arrays.asList(new Student(1, "Cameron", "Developer", "Germany"),
												new Student(4, "Bob", "Tester", "Australia"),
												new Student(3, "Daniel", "Support", "Japan"),
												new Student(5, "Emily", "Developer", "India"),
												new Student(2, "Alice", "Support", "Japan"),
												new Student(6, "George", "Developer", "India"));
		/*--------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * ----------------------------
		 * Using "Collectors.toList()"
		 * ----------------------------
		 */
		List<String> list1 = strList.stream().collect(Collectors.toList());
		List<Student> list2 = objList.stream().collect(Collectors.toList());
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.toSet()"
		 * ---------------------------
		 */
		Set<String> set1 = strList.stream().collect(Collectors.toSet());
		Set<Student> set2 = objList.stream().collect(Collectors.toSet());
		
		
		/**
		 * ----------------------------------
		 * Using "Collectors.toCollection()"
		 * ----------------------------------
		 */
		HashSet<String> set3 = strList.stream().collect(Collectors.toCollection(HashSet::new));
		HashSet<Student> set4 = objList.stream().collect(Collectors.toCollection(HashSet::new));
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.toMap()"
		 * ---------------------------
		 * "Function KeyMapper" ------------- To produce map keys
		 * "Function ValueMapper" ----------- To produce map values
		 * "BinaryOperator MergeFunction" --- How to merge the values if keys are duplicate (according to Object.equals())
		 * "Supplier mapSupplier" ----------- A function that returns a new, empty Map into which the results will be inserted
		 * ---------------------------
		 */
		//Map<Integer, String> map1 = strList.stream().collect( Collectors.toMap(str->str.length(), str->str) );
		Map<Integer, String> map2 = strList.stream().collect( Collectors.toMap(str->str.length(), str->str, (val1,val2)->val1+"&"+val2));
		Map<Integer, String> map3 = strList.stream().collect( Collectors.toMap(str->str.length(), str->str, (val1,val2)->val1+"&"+val2, LinkedHashMap::new));
		
		Map<Integer, String> map4 = objList.stream().collect( Collectors.toMap(Student::getId, Student::getName) );
		Map<Integer, String> map5 = objList.stream().collect( Collectors.toMap(Student::getId, Student::getName, (val1,val2)->val1+"&"+val2) );
		Map<Integer, String> map6 = objList.stream().collect( Collectors.toMap(Student::getId, Student::getName, (val1,val2)->val1+"&"+val2, LinkedHashMap::new) );
		
		
		/**
		 * -------------------------------------
		 * Using "Collectors.toConcurrentMap()"
		 * -------------------------------------
		 */
		// SIMILAR AS toMap()
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.maxBy()"
		 * ---------------------------
		 */
		Optional<String> optl1 = strList.stream().collect( Collectors.maxBy(Comparator.comparing(str->str.length())) );
		Optional<Student> optl2 = objList.stream().collect( Collectors.maxBy(Comparator.comparing(Student::getName)) );
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.minBy()"
		 * ---------------------------
		 */
		// SIMILAR AS maxBy()
		
		
		/**
		 * ------------------------------
		 * Using "Collectors.counting()"
		 * ------------------------------
		 */
		Long count1 = strList.stream().collect(Collectors.counting());
		Long count2 = objList.stream().collect(Collectors.counting());
		
		
		/**
		 * --------------------------------
		 * Using "Collectors.groupingBy()"
		 * --------------------------------
		 */
		// group elements by their length
		Map<Integer, List<String>> map7 = strList.stream().collect(Collectors.groupingBy(str->str.length()));
		
		// group elements by their occurrence
		Map<String, Long> map8 = strList.stream().collect(Collectors.groupingBy(str->str, Collectors.counting()));
		
		// group students by their role
		Map<String, List<Student>> map9 = objList.stream().collect(Collectors.groupingBy(Student::getRole));
		
		// group students by their role (In SET)
		Map<String, Set<Student>> map10 = objList.stream().collect(Collectors.groupingBy(Student::getRole, Collectors.toSet()));
		
		// group students by their role, then further group by location
		Map<String, Map<String, List<Student>>> map11 = objList.stream().collect(Collectors.groupingBy(Student::getRole, Collectors.groupingBy(Student::getLocation)));
		
	}

}
