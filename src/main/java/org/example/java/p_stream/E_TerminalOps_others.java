package org.example.java.p_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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
		/*-------------------------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * --------------------------
		 * Using "forEach(Consumer)"
		 * --------------------------
		 */
		strList.stream().forEach(str -> System.out.println(str+","));
		objList.stream().forEach(obj -> System.out.println(obj.getName()));
		
		
		/**
		 * ----------------------------
		 * Using "anyMatch(Predicate)"
		 * ----------------------------
		 */
		strList.stream().anyMatch(str -> str.startsWith("S"));
		objList.stream().anyMatch(obj -> obj.getId()>4);
		
		
		/**
		 * -------------------
		 * Using "findFirst()"
		 * -------------------
		 */
		Optional<String> optl1 = strList.stream().findFirst();
		optl1.ifPresent( str -> System.out.println(str) );
		optl1.orElse( "BLANK STRING" );
		
		Optional<Student> optl2 = objList.stream().findFirst();
		optl2.ifPresent( obj -> System.out.println(obj) );
		optl2.orElse( new Student(0, "XX", "NoRole", "Any") );
	
	}

}
