package com.example.java.m_lambda.b_implement_customAbstractMethod;


public class Test_customFunctionalInterface {
	public static void main(String[] args) {
		
		//zero parameter lambda operator
		FuncInterface1 f1 = () -> {System.out.println("zero param lambda operator");};
		f1.abstractFun();
		
		
		//one parameter lambda operator
		FuncInterface2 f2 = (a) -> {System.out.println("one param lambda operator, param is " + a);};
		f2.abstractFun(5);
		
		
		//multiple parameter lambda operator
		FuncInterface3 f3 = (a, b) -> {System.out.println("multi param lambda operator, params are "+a+","+b);};
		f3.abstractFun(10, 20);
	}
}




/*ArrayList<Integer> arrL = new ArrayList<Integer>(); 
arrL.add(1); 
arrL.add(2); 
arrL.forEach((n) -> System.out.println(n instanceof Integer));*/