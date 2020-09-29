package a_coreStructure;


/*******************************************************************
 *						"this" with fields
 *******************************************************************/
class Box {
	double width;
	double height;
	double depth;
	
	Box(double wid, double hei, double dep) {
		this.width = wid;
		this.height = hei;
		this.depth = dep;
	}
}



/*******************************************************************
 *					"this" with default constructor
 *******************************************************************/
class Test03 {
	public static void main(String[] args) {
		new Student();
	}
}

class Student {
	Student() {
		this(100);
	}
	Student(int id) {
		System.out.println("id="+id);
	}
}



/*******************************************************************
 *				"this" with parameterized constructor
 *******************************************************************/
class Test04 {
	public static void main(String[] args) {
		new Person(500);
	}
}

class Person {
	Person() {
		System.out.println("default");
	}
	Person(int id) {
		this();
	}
}


