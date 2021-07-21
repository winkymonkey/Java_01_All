package org.example.java.e_hierarchy.a_interface;


interface I1 {
	default void print() {
		System.out.println("I1 default");
	}
}
interface I2 {
	default void print() {
		System.out.println("I2 default");
	}
}
abstract class Abstract1 {
	abstract void print();
}

class Main1 extends Abstract1 implements I1, I2 {
	public void print() {
		System.out.println("Concrete print");	//Concrete print
		I1.super.print();						//I1 default
		I2.super.print();						//I2 default
	}
	
	public static void main(String[] args) {
		Main1 obj = new Main1();
		obj.print();
	}
}




/**************************************************************************************/

interface I3 {
	default void print() {
		System.out.println("I3 default");
	}
}
interface I4 {
	default void print() {
		System.out.println("I4 default");
	}
}
class Concrete {
	public void print() {
		System.out.println("Concrete default");
	}
}

class Main2 extends Concrete implements I3, I4 {
	public static void main(String[] args) {
		Main2 obj = new Main2();
		obj.print();							//Concrete default
	}
}



/**************************************************************************************/

interface I5 {
	default public void print() {
		System.out.println("I5 default");
	}
}
interface I6 extends I5 {
	default public void print() {
		System.out.println("I6 default");
	}
}
interface I7 extends I5 {
	//
}
class Main5 implements I6, I7 {
	public static void main(String[] args) {
		Main5 obj = new Main5();
		obj.print();					//I6 default
	}
}














