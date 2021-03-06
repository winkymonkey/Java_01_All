package com.example.java.n_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class D_TerminalOps_reduceAPI {
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
		 * ------------------------------------------------------------
		 * Using "reduce(BinaryOperator)" -- with collection of String
		 * ------------------------------------------------------------
		 */
		Optional<String> optn1 = streamOfStr.reduce((str1,str2) -> str1+","+str2);
		optn1.ifPresent(str -> System.out.println(str));
		optn1.orElse("BLANK STRING");
		
		
		/**
		 * ------------------------------------------------------------
		 * Using "reduce(BinaryOperator)" -- with collection of Object
		 * ------------------------------------------------------------
		 */
		Optional<Employee> optn2 = streamOfObj.reduce((e1,e2) -> e1.getId()>e2.getId() ? e1:e2);
		optn2.ifPresent(emp1 -> System.out.println(emp1.getName()));
		optn2.orElse(new Employee(0, "XX", "NoRole", "Any"));
	}	
}


