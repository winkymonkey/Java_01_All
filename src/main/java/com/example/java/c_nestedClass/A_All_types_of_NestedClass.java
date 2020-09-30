package com.example.java.c_nestedClass;


/************************************************************/
/**						Static Nested Class	&				*/
/**							Inner Class					  	*/
/************************************************************/
class Outer {	
	int x = 20;
	static int y = 10;
	private static int z = 30;
	
	/*static nested class*/
	static class Static {
		void display() {
			//System.out.println(outer_x);		//cannot access non-static variable
			System.out.println(y);
			System.out.println(z);
		}
	}
	
	/*inner class*/
	class Inner {
		void display() {
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
		}
	}
	
	public static void main(String[] args) {
		Outer.Static nested = new Outer.Static();
		nested.display();
		
		Outer.Inner inner = new Outer().new Inner();
		inner.display();
	}
}





/************************************************************/
/**							Local Class						*/
/************************************************************/
class Outer2 {
	private void process() {
		int num = 20;						//final OR effectively final
		System.out.println("num = "+ num);
		
		class Inner {
			int result;
			Inner() {
				result = num * 4;
				System.out.println(num);
			}
		}
		
		Inner inner = new Inner();
		System.out.println("result = "+ inner.result);
	}
	
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		outer.process();
	}
}