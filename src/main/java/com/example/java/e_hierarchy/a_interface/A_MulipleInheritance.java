package com.example.java.e_hierarchy.a_interface;


interface A1 {
	public void print();
}
interface B1 {
	public void print();
}
class Concrete1 implements A1, B1 {
	public void print() {
		//
	}
}



interface A2 {
	public Integer print();
}
interface B2 {
	public Number print();
}
class Concrete2 implements A2, B2 {
	public Integer print() {
		return 1;
	}
}



/***************************************************************************/
interface A3 {
	public void print();
}
interface B3 {
	public int print();
}
/*class Concrete3 implements A3, B3 {
	public void print() {
		//
	}							//DUPLICATE method
	public int print() {
		//
	}
}*/



interface A4 {
	public Integer print();
}
interface B4 {
	public String print();
}
/*class Concrete4 implements A4, B4 {
	public Integer print() {
		return 1;
	}							//DUPLICATE method
	public String print() {
		return "";
	}
}*/




