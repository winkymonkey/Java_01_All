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
		class Employee {
			private int id;
			private String name;
			private String role;
			private String location;
			
			Employee(int id, String name, String role, String location) {
				this.id = id;
				this.name = name;
				this.role = role;
				this.location = location;
			}
			
			public int getId() {
				return id;
			}
			public String getName() {
				return name;
			}
			public String getRole() {
				return role;
			}
			public String getLocation() {
				return location;
			}
		}
		List<String> strList = Arrays.asList("Reflection","Collection","Stream","Static","Static","Reflection","Final");
		List<Employee> objList = Arrays.asList(new Employee(1, "Cameron", "Developer", "Germany"),
												new Employee(4, "Bob", "Tester", "Australia"),
												new Employee(3, "Daniel", "Support", "Japan"),
												new Employee(5, "Emily", "Developer", "India"),
												new Employee(2, "Alice", "Support", "Japan"),
												new Employee(6, "George", "Developer", "India"));
		
		Stream<String> streamOfStr = strList.stream();
		Stream<Employee> streamOfObj = objList.stream();
		/*--------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * ----------------------------
		 * Using "Collectors.toList()"
		 * ----------------------------
		 */
		List<String> list1 = streamOfStr.collect(Collectors.toList());
		List<Employee> list2 = streamOfObj.collect(Collectors.toList());
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.toSet()"
		 * ---------------------------
		 */
		Set<String> set1 = streamOfStr.collect(Collectors.toSet());
		Set<Employee> set2 = streamOfObj.collect(Collectors.toSet());
		
		
		/**
		 * ----------------------------------
		 * Using "Collectors.toCollection()"
		 * ----------------------------------
		 */
		HashSet<String> set3 = streamOfStr.collect(Collectors.toCollection(HashSet::new));
		HashSet<Employee> set4 = streamOfObj.collect(Collectors.toCollection(HashSet::new));
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.toMap()"
		 * ---------------------------
		 */
		// "Function KeyMapper" ---- To produce map keys
		// "Function ValueMapper" -- To produce map values
		Map<Integer, String> map1 = streamOfStr.collect(Collectors.toMap(str->str.length(), str->str));
		Map<Integer, String> map2 = streamOfObj.collect(Collectors.toMap(Employee::getId, Employee::getName));
		
		// "Function KeyMapper" ------------- To produce map keys
		// "Function ValueMapper" ----------- To produce map values
		// "BinaryOperator MergeFunction" --- How to merge the values if keys are duplicate (according to Object.equals())
		Map<Integer, String> map3 = streamOfStr.collect(Collectors.toMap(str->str.length(), str->str, (val1,val2)->val1+"&"+val2));
		Map<Integer, String> map4 = streamOfObj.collect(Collectors.toMap(Employee::getId, Employee::getName, (val1,val2)->val1+"&"+val2));
		
		// "Function KeyMapper" ------------- To produce map keys
		// "Function ValueMapper" ----------- To produce map values
		// "BinaryOperator MergeFunction" --- How to merge the values if keys are duplicate (according to Object.equals())
		// "Supplier mapSupplier" ----------- A function which returns a new, empty Map into which the results will be inserted
		LinkedHashMap<Integer, String> map5 = streamOfStr.collect(Collectors.toMap(str->str.length(), str->str, (val1,val2)->val1+"&"+val2, LinkedHashMap::new));
		LinkedHashMap<Integer, String> map6 = streamOfObj.collect(Collectors.toMap(Employee::getId, Employee::getName, (val1,val2)->val1+"&"+val2, LinkedHashMap::new));
	
		
		/**
		 * -------------------------------------
		 * Using "Collectors.toConcurrentMap()"
		 * -------------------------------------
		 */
		//SIMILAR AS toMap()
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.maxBy()"
		 * ---------------------------
		 */
		Optional<String> opt1 = streamOfStr.collect(Collectors.maxBy(Comparator.comparing(str->str.length())));
		Optional<Employee> opt2 = streamOfObj.collect(Collectors.maxBy(Comparator.comparing(Employee::getName)));
		
		
		/**
		 * ---------------------------
		 * Using "Collectors.minBy()"
		 * ---------------------------
		 */
		//SIMILAR AS maxBy()
		
		
		/**
		 * ------------------------------
		 * Using "Collectors.counting()"
		 * ------------------------------
		 */
		Long count1 = streamOfStr.collect(Collectors.counting());
		Long count2 = streamOfObj.collect(Collectors.counting());
		
		
		/**
		 * --------------------------------
		 * Using "Collectors.groupingBy()"
		 * --------------------------------
		 */
		//group elements by their length
		Map<Integer, List<String>> map7 = streamOfStr.collect(Collectors.groupingBy(str->str.length()));
		
		//group elements by their occurrence
		Map<String, Long> map8 = streamOfStr.collect(Collectors.groupingBy(str->str, Collectors.counting()));
		
		//group students by their role
		Map<String, List<Employee>> map9 = streamOfObj.collect(Collectors.groupingBy(Employee::getRole));
		
		//group students by their role (In SET)
		Map<String, Set<Employee>> map10 = streamOfObj.collect(Collectors.groupingBy(Employee::getRole, Collectors.toSet()));
		
		//group students by their role, then further group by location
		Map<String, Map<String, List<Employee>>> map11 = streamOfObj.collect(Collectors.groupingBy(Employee::getRole, Collectors.groupingBy(Employee::getLocation)));
		
	}
}

