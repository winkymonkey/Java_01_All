package com.example.java.o_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class E_TerminalOps_others {
	
	public static void main(String[] args) {
		/*-------------------------------------------------------------------------------------------------------------------*/
		List<String> strList = Arrays.asList("Reflection","Collection","Stream","Static","Static","Reflection","Final");
		List<Student> objList = Arrays.asList(new Student(1, "Cameron", "Developer", "Germany"),
												new Student(4, "Bob", "Tester", "Australia"),
												new Student(3, "Daniel", "Support", "Japan"),
												new Student(5, "Emily", "Developer", "India"),
												new Student(2, "Alice", "Support", "Japan"),
												new Student(6, "George", "Developer", "India"));
		
		Stream<String> strStream = strList.stream();
		Stream<Student> objStream = objList.stream();
		/*-------------------------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * --------------------------
		 * Using "forEach(Consumer)"
		 * --------------------------
		 */
		strStream.forEach(str -> System.out.println(str+","));
		objStream.forEach(obj -> System.out.println(obj.getName()));
		
		
		/**
		 * ----------------------------
		 * Using "anyMatch(Predicate)"
		 * ----------------------------
		 */
		strStream.anyMatch(str -> str.startsWith("S"));
		objStream.anyMatch(obj -> obj.getId()>4);
		
		
		/**
		 * -------------------
		 * Using "findFirst()"
		 * -------------------
		 */
		Optional<String> optn1 = strStream.findFirst();
		optn1.ifPresent(str -> System.out.println(str));
		optn1.orElse("BLANK STRING");
		
		Optional<Student> optn2 = objStream.findFirst();
		optn2.ifPresent(obj -> System.out.println(obj));
		optn2.orElse(new Student(0, "XX", "NoRole", "Any"));
	
	}

}
