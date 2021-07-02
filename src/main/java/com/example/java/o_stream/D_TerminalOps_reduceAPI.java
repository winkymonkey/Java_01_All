package com.example.java.o_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class D_TerminalOps_reduceAPI {
	
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
		 * ------------------------------------------------------------
		 * Using "reduce(BinaryOperator)" -- with collection of String
		 * ------------------------------------------------------------
		 */
		Optional<String> optn1 = strStream.reduce((str1,str2) -> str1+","+str2);
		optn1.ifPresent(str -> System.out.println(str));
		optn1.orElse("BLANK STRING");
		
		
		/**
		 * ------------------------------------------------------------
		 * Using "reduce(BinaryOperator)" -- with collection of Object
		 * ------------------------------------------------------------
		 */
		Optional<Student> optn2 = objStream.reduce((stu1,stu2) -> stu1.getId()>stu2.getId() ? stu1:stu2);
		optn2.ifPresent(stu -> System.out.println(stu.getName()));
		optn2.orElse(new Student(0, "XX", "NoRole", "Any"));
	
	}	

}
