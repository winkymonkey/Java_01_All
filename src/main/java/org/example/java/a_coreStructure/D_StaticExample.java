package org.example.java.a_coreStructure;


/*******************************************************************
 *						"static" variable
 *******************************************************************/
@SuppressWarnings("unused")
class CounterA {
	int count;
	
	CounterA() {
		count++;
		System.out.println(count);
	}
	public static void main(String[] args) {
		CounterA c1 = new CounterA();
		CounterA c2 = new CounterA();
	}
}

@SuppressWarnings("unused")
class CounterB {
	static int count;
	
	CounterB() {
		count++;
		System.out.println(count);
	}
	public static void main(String[] args) {
		CounterB c1 = new CounterB();
		CounterB c2 = new CounterB();
	}
}




/*******************************************************************
 *						"static" method
 *******************************************************************/
class Test05 {
	static int getCube(int x) {
		return x*x*x;
	}
	public static void main(String[] args) {
		Test05.getCube(5);
	}
}





