package org.example.java.o_optional;

import java.util.Optional;


public class B_orElse_vs_orElseGet {

	public static void main(String[] args) {
		B_orElse_vs_orElseGet obj = new B_orElse_vs_orElseGet();
		
		obj.whenOptionalIsWrapperAroundNull();
		System.out.println("==================");
		obj.whenOptionalIsWrapperAroundNonNull();
	}
	
	
	private void whenOptionalIsWrapperAroundNull() {
		System.out.println( Optional.ofNullable(null).orElse(callDefault()) );
		System.out.println("-----------");
		System.out.println( Optional.ofNullable(null).orElseGet(this::callDefault) );
	}
	
	
	private void whenOptionalIsWrapperAroundNonNull() {
		System.out.println( Optional.ofNullable("AAA").orElse(callDefault()) );
		System.out.println("-----------");
		System.out.println( Optional.ofNullable("AAA").orElseGet(this::callDefault) );
	}
	
	
	public String callDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}
	
}
