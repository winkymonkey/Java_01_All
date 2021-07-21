package org.example.java.m_lambda.q_methodReference;


@FunctionalInterface
interface Sayable {
	void say();
}


public class Aaaa {
	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) {
		// Referring static method
		Sayable sayable = Aaaa::saySomething;
		
		// Calling interface method
		sayable.say();
	}
}


