package e_hierarchy.b_inheritance;


class Parent {
	//
}

class Child extends Parent {
	//
}

public class Inheritance_Basic {
	Parent p = new Parent();
	Child c = new Child();
	Parent p2 = new Child();
	//Child c2 = new Parent();	//Compile Error
}
