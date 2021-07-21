package org.example.java.a_coreStructure;


@SuppressWarnings("unused")
class Test01 {
	public static void main(String[] args) {
		Employee emp1 = new Employee();			//initialized with -- 0,0
		Employee emp2 = new Employee();			//initialized with -- 0,0
		Employee emp3 = new Employee(22);		//initialized with -- 22,0
		Employee emp4 = new Employee(22, 3000);	//initialized with -- 22,3000
	}
}

class Employee {
	int age;
	int salary;
	
	Employee() {
		//
	}
	Employee(int ag, int sal) {
		age = ag;
		salary = sal;
	}
	Employee(int ag) {
		age = ag;
	}
}

