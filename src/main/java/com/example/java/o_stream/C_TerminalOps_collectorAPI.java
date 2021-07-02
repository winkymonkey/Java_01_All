package com.example.java.o_stream;

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
		
		Stream<String> strStream = strList.stream();
		Stream<Student> objStream = objList.stream();
		/*--------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * ----------------------------
		 * Using "Collectors.toList()"
		 * ----------------------------
		 */
		List<String> list1 = strStream.collect(Collectors.toList());
		List<Student> list2 = objStream.collect(Collectors.toList());
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.toSet()"
		 * ---------------------------
		 */
		Set<String> set1 = strStream.collect(Collectors.toSet());
		Set<Student> set2 = objStream.collect(Collectors.toSet());
		
		
		/**
		 * ----------------------------------
		 * Using "Collectors.toCollection()"
		 * ----------------------------------
		 */
		HashSet<String> set3 = strStream.collect(Collectors.toCollection(HashSet::new));
		HashSet<Student> set4 = objStream.collect(Collectors.toCollection(HashSet::new));
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.toMap()"
		 * ---------------------------
		 */
		// "Function KeyMapper" ---- To produce map keys
		// "Function ValueMapper" -- To produce map values
		Map<Integer, String> map1 = strStream.collect(Collectors.toMap(str->str.length(), str->str));
		Map<Integer, String> map2 = objStream.collect(Collectors.toMap(Student::getId, Student::getName));
		
		// "Function KeyMapper" ------------- To produce map keys
		// "Function ValueMapper" ----------- To produce map values
		// "BinaryOperator MergeFunction" --- How to merge the values if keys are duplicate (according to Object.equals())
		Map<Integer, String> map3 = strStream.collect(Collectors.toMap(str->str.length(), str->str, (val1,val2)->val1+"&"+val2));
		Map<Integer, String> map4 = objStream.collect(Collectors.toMap(Student::getId, Student::getName, (val1,val2)->val1+"&"+val2));
		
		// "Function KeyMapper" ------------- To produce map keys
		// "Function ValueMapper" ----------- To produce map values
		// "BinaryOperator MergeFunction" --- How to merge the values if keys are duplicate (according to Object.equals())
		// "Supplier mapSupplier" ----------- A function which returns a new, empty Map into which the results will be inserted
		LinkedHashMap<Integer, String> map5 = strStream.collect(Collectors.toMap(str->str.length(), str->str, (val1,val2)->val1+"&"+val2, LinkedHashMap::new));
		LinkedHashMap<Integer, String> map6 = objStream.collect(Collectors.toMap(Student::getId, Student::getName, (val1,val2)->val1+"&"+val2, LinkedHashMap::new));
	
		
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
		Optional<String> opt1 = strStream.collect(Collectors.maxBy(Comparator.comparing(str->str.length())));
		Optional<Student> opt2 = objStream.collect(Collectors.maxBy(Comparator.comparing(Student::getName)));
		
		
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
		Long count1 = strStream.collect(Collectors.counting());
		Long count2 = objStream.collect(Collectors.counting());
		
		
		/**
		 * --------------------------------
		 * Using "Collectors.groupingBy()"
		 * --------------------------------
		 */
		// group elements by their length
		Map<Integer, List<String>> map7 = strStream.collect(Collectors.groupingBy(str->str.length()));
		
		// group elements by their occurrence
		Map<String, Long> map8 = strStream.collect(Collectors.groupingBy(str->str, Collectors.counting()));
		
		// group students by their role
		Map<String, List<Student>> map9 = objStream.collect(Collectors.groupingBy(Student::getRole));
		
		// group students by their role (In SET)
		Map<String, Set<Student>> map10 = objStream.collect(Collectors.groupingBy(Student::getRole, Collectors.toSet()));
		
		// group students by their role, then further group by location
		Map<String, Map<String, List<Student>>> map11 = objStream.collect(Collectors.groupingBy(Student::getRole, Collectors.groupingBy(Student::getLocation)));
		
	}

}
