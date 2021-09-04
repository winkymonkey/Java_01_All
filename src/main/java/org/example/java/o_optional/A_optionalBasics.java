package org.example.java.o_optional;

import java.util.Optional;


@SuppressWarnings("unused")
public class A_optionalBasics {

	public static void main(String[] args) {
		
		// create an empty Optional object
		System.out.println("--------------------------------------");
		Optional<String> opt1 = Optional.empty();
		
		
		// create a non-empty Optional object
		System.out.println("--------------------------------------");
		Optional<String> opt2 = Optional.of("AAA"); 							// if the value is null, throws NPE
		
		
		// create an Optional object that may contain some value
		System.out.println("--------------------------------------");
		Optional<String> opt3 = Optional.ofNullable(null); 						// if the value is null, it returns an empty Optional
		Optional<String> opt4 = Optional.ofNullable("AAA"); 					// if the value is null, it returns an empty Optional
		
		
		
		
		
		
		// check if Optional contains some value
		System.out.println("--------------------------------------");
		Optional.of("AAA").isPresent();
		
		
		// perform conditional action if the Optional contains some value
		System.out.println("--------------------------------------");
		Optional.ofNullable("AAA").ifPresent( str -> System.out.println(str.length()) );
		
		
		
		
		
		
		// Return the value if present, otherwise return a default value
		System.out.println("--------------------------------------");
		Optional.ofNullable("AAA").orElse("EMPTY");								// returns AAA
		Optional.ofNullable(null).orElse("EMPTY");								// returns EMPTY
		
		
		
		// Return the value if present, otherwise return a default value
		System.out.println("--------------------------------------");
		Optional.ofNullable("AAA").orElseGet(() -> "EMPTY");					// returns AAA
		Optional.ofNullable(null).orElseGet(() -> "EMPTY");						// returns EMPTY
		
		
		
		
		
		
		Optional.of("AAA").get();						// returns AAA
		Optional.of(null).get();						// throws NullPointerException
		
		Optional.ofNullable("AAA").get();				// returns AAA
		Optional.ofNullable(null).get();				// throws NoSuchElementException
		
		Optional.empty().get();							// throws NoSuchElementException
	}
	
}
