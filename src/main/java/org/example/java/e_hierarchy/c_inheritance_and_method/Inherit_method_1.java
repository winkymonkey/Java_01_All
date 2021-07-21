package org.example.java.e_hierarchy.c_inheritance_and_method;


class Parent {
	void common() {System.out.println("parent common");}
	void aloneParent() {System.out.println("parent alone");}
	
	static void stat() {System.out.println("parent stat");}
}


class Child extends Parent {
	void common() {System.out.println("child common");}
	void aloneChild() {System.out.println("child alone");}
	
	static void stat() {System.out.println("child stat");}
	
	{
		common();			//child common
		this.common();		//child common
		super.common();		//parent common
		
		aloneParent();			//parent alone
		this.aloneParent();		//parent alone
		super.aloneParent();	//parent alone
		
		aloneChild();			//child alone
		this.aloneChild();		//child alone
		//super.aloneChild();	//Compile Error
		
		stat();				//child stat
		this.stat();		//child stat
		super.stat();		//parent stat
	}
}


public class Inherit_method_1 {
	public static void main(String[] args) {
		new Child();
	}
}
