package com.example.java.o_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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
		/*--------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * --------------------------------
		 * Using "reduce(BinaryOperator)"
		 * --------------------------------
		 */
		Optional<String> optl1 = strList.stream().reduce( (str1,str2) -> str1+"-"+str2 );
		optl1.ifPresent( str -> System.out.println(str) );
		optl1.orElse( "BLANK STRING" );
		
		Optional<Student> optl2 = objList.stream().reduce( (st1,st2) -> st1.getId()>st2.getId() ? st1:st2 );
		optl2.ifPresent( st -> System.out.println(st.getName()) );
		optl2.orElse( new Student(0, "XX", "NoRole", "Any") );
	
	}	

}
