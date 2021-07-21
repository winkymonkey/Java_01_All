package org.example.java.b_datatype;


class IntegerLiterals {
	byte by = 10;		//byte stores -- integer literal
	short sh = 10;		//short stores -- integer literal
	int i = 10;			//int stores -- integer literal
	long long1 = 10;	//long stores -- integer literal
	long long2 = 10L;	//long stores -- long literal
	
	int decimal = 26;		//number 26 in decimal
	int hexa = 0x1a;		//number 26 in hexadecimal (1a)
	int binary = 0b11010;	//number 26 in binary (11010)
}


class FloatingPointLiteral {
	double d1 = 12.34;
	double d2 = 12.34D;		//both 12.34 and 12.34D represents same double literal
	
	float f1 = 12.34F;
}


class TypePromotion {
	public static void main(String args[]) {
		byte b = 42;
		char c = 'a';
		short s = 1024;
		int i = 50000;
		float f = 5.67f;
		double d = .1234;
		
		System.out.println(f * b);		//promoted to float
		System.out.println(i / c);		//promoted to int
		System.out.println(d * s);		//promoted to double
		
		double result = (f * b) + (i / c) - (d * s);	//promoted to double
		System.out.println("result =" + result);
	}
}


