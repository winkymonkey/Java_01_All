package e_hierarchy.d_inheritance_and_variable;


class Parent2 {
	int common = 10;
	int aloneParent = 20;
	
	static int stat1 = 50;
	int stat2 = 60;
	
	static int alone = 99;
}


class Child2 extends Parent2 {
	int common = 100;
	int aloneChild = 300;
	
	int stat1 = 500;
	static int stat2 = 600;
}


class Inherit_variable_2 {
	public static void main(String[] args) {
		Parent2 p = new Parent2();
		System.out.println(p.common);		//10
		System.out.println(p.aloneParent);	//20
		System.out.println(p.stat1);		//50
		System.out.println(p.stat2);		//60
		System.out.println(p.alone);		//99
		
		Child2 c = new Child2();
		System.out.println(c.common);		//100
		System.out.println(c.aloneParent);	//20
		System.out.println(c.stat1);		//500
		System.out.println(c.stat2);		//600
		System.out.println(c.alone);		//99
		
		Parent2 p2 = new Child2();
		System.out.println(p2.common);		//10
		System.out.println(p2.aloneParent);	//20
		System.out.println(p2.stat1);		//50
		System.out.println(p2.stat2);		//60
		System.out.println(p2.alone);		//99
	}
}


