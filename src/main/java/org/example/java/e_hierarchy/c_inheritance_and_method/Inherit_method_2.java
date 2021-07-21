package org.example.java.e_hierarchy.c_inheritance_and_method;


class Parent2 {
	void common() {System.out.println("parent common");}
	void aloneParent() {System.out.println("parent alone");}
	
	static void stat() {System.out.println("parent stat");}
}


class Child2 extends Parent2 {
	void common() {System.out.println("child common");}
	void aloneChild() {System.out.println("child alone");}
	
	static void stat() {System.out.println("child stat");}
}


public class Inherit_method_2 {
	public static void main(String[] args) {
		Parent2 p = new Parent2();
		p.common();					//parent common
		p.aloneParent();			//parent alone
		p.stat();					//parent stat
		
		Child2 c = new Child2();
		c.common();				//child common
		c.aloneChild();			//child alone
		c.aloneParent();		//parent alone
		c.stat();				//child stat
		
		Parent2 p2 = new Child2();
		p2.common();				//child common
		p2.aloneParent();			//parent alone
		p2.stat();					//parent stat
	}
}

