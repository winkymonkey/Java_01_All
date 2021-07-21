package org.example.java.o_optional;

import java.util.Optional;


public class A_optionalBasics {

	public static void main(String[] args) {
		// create an empty Optional object
		System.out.println("-------------------------");
		Optional<String> opt1 = Optional.empty();
		System.out.println(opt1.isPresent());
		
		
		// create an Optional object that contains some value
		System.out.println("-------------------------");
		String str2 = "test";
		Optional<String> opt2 = Optional.of(str2); 							// the value should not be null, otherwise NPE
		System.out.println(opt2.isPresent());
		
		
		// create an Optional object that may or may not contains some value
		System.out.println("-------------------------");
		String str3 = null;
		Optional<String> opt3 = Optional.ofNullable(str3); 						// if the value is null, it returns an empty Optional
		System.out.println(opt3.isPresent());
		
		
		// perform conditional action if the Optional contains some value
		System.out.println("-------------------------");
		String str4 = "test";
		Optional<String> opt4 = Optional.ofNullable(str4);
		opt4.ifPresent(name -> System.out.println(name.length()));
		
		
		// return default value if the Optional does NOT contains some value
		System.out.println("-------------------------");
		String str5 = "aaa";
		String name5 = Optional.ofNullable(str5).orElse("EMPTY");
		System.out.println(name5);
		
		
		// return default value if the Optional does NOT contains some value
		System.out.println("-------------------------");
		String str6 = "aaa";
		String name6 = Optional.ofNullable(str6).orElseGet(() -> "EMPTY");
		System.out.println(name6);
	}
}
