package com.example.java.a_coreStructure.enums.enum4;


public class MainClass {
	
	public static void main(String[] args) {
		System.out.println(Color.values().length+"\n");
		for (Color col : Color.values()) {
			System.out.println(col.getCode() + "|" + col.getStr());
		}
	}
	
}
