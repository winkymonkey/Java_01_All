package e_hierarchy.e_inheritance_and_constructor;


class Parent {
	Parent() {
		System.out.println("I am Parent");
	}
	Parent(int i) {
		System.out.println("I am Parent::"+i);
	}
}

class Child extends Parent {
	Child() {
		super();
		System.out.println("I am Child");
	}
	Child(int x) {
		super();
		System.out.println("I am Child::"+x);
	}
	Child(int x, int y) {
		super(x);
		System.out.println("I am Child::"+x+", "+y);
	}
	Child(int x, int y, int z) {							//super() is implicit here
		System.out.println("I am Child::"+x+", "+y+", "+z);
	}
}

public class Inheritance_and_constructor {
	public static void main(String[] args) {
		new Child();			//I am Parent	 	I am Child
		new Child(5);			//I am Parent	 	I am Child::5
		new Child(5, 10);		//I am Parent::5 	I am Child::5, 10
		new Child(5, 10 ,15);	//I am Parent		I am Child::5, 10, 15
	}
}
