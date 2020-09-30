package com.example.java.e_hierarchy.f_inheritance_andTypeCasting;


class Parent {
	void common() {
		System.out.println("parent common");
	}
	void aloneParent() {
		System.out.println("parent alone");
	}
}
class Child extends Parent {
	void common() {
		System.out.println("child common");
	}
	void aloneChild() {
		System.out.println("child alone");
	}
}

public class Inheritance_and_TypeCasting {
	public static void main(String[] args) {
		Parent p = new Parent();
		((Child)p).common();			//ClassCastException at runtime
		((Child)p).aloneParent();		//ClassCastException at runtime
		((Child)p).aloneChild();		//ClassCastException at runtime
		
		Child c = new Child();
		((Parent)c).common();			//equivalent to p.common()
		((Parent)c).aloneParent();		//equivalent to p.aloneParent()
		//((Parent)c).aloneChild();		//equivalent to p.aloneChild()	==> compile error
	}
}

