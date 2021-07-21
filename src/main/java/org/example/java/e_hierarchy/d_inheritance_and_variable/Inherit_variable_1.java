package org.example.java.e_hierarchy.d_inheritance_and_variable;


class Parent {
	int common = 10;
	int aloneParent = 20;
	
	static int stat1 = 50;
	int stat2 = 60;
	
	static int alone = 99;
}


class Child extends Parent {
	int common = 100;
	int aloneChild = 300;
	
	int stat1 = 500;
	static int stat2 = 600;
	
	{
		System.out.println(common);				//100
		System.out.println(this.common);		//100
		System.out.println(super.common);		//10
		
		System.out.println(aloneParent);		//20
		System.out.println(this.aloneParent);	//20
		System.out.println(super.aloneParent);	//20
		
		System.out.println(aloneChild);			//300
		System.out.println(this.aloneChild);	//300
		//System.out.println(super.aloneChild);	//Compile Error
		
		System.out.println(stat1);			//500
		System.out.println(this.stat1);		//500
		System.out.println(super.stat1);	//50
		
		System.out.println(stat2);			//600
		System.out.println(this.stat2);		//600
		System.out.println(super.stat2);	//60
		
		System.out.println(alone);			//99
		System.out.println(this.alone);		//99
		System.out.println(super.alone);	//99
	}
}

