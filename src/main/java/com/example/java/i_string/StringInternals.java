package com.example.java.i_string;


class Test01 {
	public static void main(String[] args) {
		String hello = "Hello";
		String lo = "lo";

			//Literal strings within same class OR different classes in same/different packages 
			//  ==> represent reference to the same String object.
		System.out.println(hello == "Hello"); 									// true
		System.out.println(Other.hello == hello); 								// true
		
			//Strings which are computed by constant expressions 
			//  ==> are computed at compile time & then treated as if they were literals.
		System.out.println(hello == ("Hel" + "lo")); 							// true
		
			//Strings which are computed by concatenation at run time 
			//  ==> are newly created and therefore distinct.
		System.out.println(hello == ("Hel" + lo)); 								// false
		
			//The result of explicitly interning a computed string  
			//  ==> It is the same string as any existing literal string with the same contents.
		System.out.println(hello == ("Hel" + lo).intern());						// true
	}
}

class Other {
	static String hello = "Hello";
}







class Test02 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "pqr";
		System.out.println(s1 == s2);			//false
		
		String s3 = "pqr";
		System.out.println(s2 == s3);			//true
		
		
		String s4 = "abc" + "pqr";
		String s5 = s1 + s2;
		System.out.println(s4 == s5);			//false
		System.out.println(s4 == s5.intern());	//true
		
		
		String s6 = "abc ".trim();
		System.out.println(s1 == s6);			//false
		System.out.println(s1 == s6.intern());	//true
	}
}







class Test03 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc" + "xyz";
		String s3 = "abc".concat("xyz");
		
		System.out.println(s1);			//abc
		System.out.println(s2);			//abcxyz
		System.out.println(s3);			//abcxyz
	}
}







class Test04 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "pqr";
		
		String s3 = "abc" + "pqr";
		String s4 = s1 + s2;
		
		System.out.println(s3 == s4);			//false
		System.out.println(s3.equals(s4));		//true
	}
}



