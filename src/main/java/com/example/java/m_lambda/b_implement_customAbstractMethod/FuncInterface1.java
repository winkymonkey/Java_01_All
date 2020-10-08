package com.example.java.m_lambda.b_implement_customAbstractMethod;

@FunctionalInterface
interface FuncInterface1 {
	void abstractFun();

	default void normalFun() {
		System.out.println("Hello");
	}
}
