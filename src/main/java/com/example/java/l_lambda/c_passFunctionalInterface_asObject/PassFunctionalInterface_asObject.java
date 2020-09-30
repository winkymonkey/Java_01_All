package com.example.java.l_lambda.c_passFunctionalInterface_asObject;

import java.util.ArrayList;


class PassFunctionalInterface_asObject {
	public static void main(String[] args) {
		ArrayList<Integer> arrL = new ArrayList<Integer>(); 
		arrL.add(1); 
		arrL.add(2); 
		arrL.forEach((n) -> System.out.println(n instanceof Integer));
	}
}
