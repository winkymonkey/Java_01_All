package com.example.java.r_generics;

import java.util.List;
import static java.util.Collections.*;


/*********************************************************************/
class SimpleBox {/***/}

class Box<T> {
	void add(T t) {
		/***/emptyList();
	}
}
class PairBox<K,V> {
	void add(K k, V v) {
		/***/
	}
}


/*********************************************************************/		//Single Type Parameter
class Test01 {
	Box<Integer> box1;				//it's Type Invocation
	{
		box1 = new Box<Integer>();	//it's Instantiation
		box1 = new Box<>();			//it's Instantiation (Type Inference)
	}
}


/*********************************************************************/		//Multiple Type Parameter
class Test02 {
	PairBox<Integer,String> box2;				//it's Type Invocation
	{
		box2 = new PairBox<Integer,String>();	//it's Instantiation
		box2 = new PairBox<>();					//it's Instantiation (Type Inference)
	}
}


/*********************************************************************/		//Raw-Type
@SuppressWarnings({"rawtypes", "unchecked"})
class Test03 {
	Box<Integer> parameterized;	//Parameterized Type
	Box raw;					//Raw Type
	{
		parameterized = raw;	//WARNING (assigning Raw-Type to Parameterized-Type)
		raw = parameterized;	//OK      (assigning Parameterized-Type to Raw-Type)
	}
}


/*********************************************************************/		//NOT Raw-Type
class Test04 {
	SimpleBox box4;				//Not A Raw Type
}


/*********************************************************************/		//Generic Method
class Test05 {
	<T> void eat(T t) {/***/}
	<E> void walk(Box<E> box) {/***/}
	static <U> void fly(U u) {/***/}
	//
	{
		eat("A");					//for Type Parameter <T>, the Type Argument is 'String'
		walk(new Box<Integer>());	//for Type Parameter <E>, the Type Argument is 'Integer'
		Test05.<String>fly("X");	//for Type Parameter <U>, the Type Argument is 'String'
		Test05.fly("X");			//for Type Parameter <U>, the Type Argument is 'String' (Type Inference)
	}
}


/*********************************************************************/		//Generic Type & Inheritance
class Test06 {
	public void eat(Number n) {/***/}
	//
	{
		eat(new Integer(10));		//OK
		eat(new Double(10.1));		//OK
	}
}

class Test07 {
	Box<Number> list = new Box<Number>();
	//
	{
		list.add(new Integer(10));	//OK
		list.add(new Double(10.1));	//OK
	}
}

class Test08 {
	public void eat(Box<Number> list) {/***/}
	//
	{
		//eat(new Box<Integer>());	//INVALID
		//eat(new Box<Double>());		//INVALID
	}
}


/*********************************************************************/		//Generic Constructor
class Test09 {				//Generic Constructor of a Non-Generic Class
	<T> Test09(T t) {
		//
	}
}

class Test10<X> {			//Generic Constructor of a Generic Class
	<T> Test10(T t) {
		//
	}
}


/*********************************************************************/		//Type Inference & Generic Constructor
class Test11<X> {
	{
		new Test10<Integer>("ABC");							//<T> is 'String', <X> is 'Integer'
		new Test10<>("ABC");								//<T> is 'String', <X> is 'Object' (Type Inference)
	}
	Test10<Integer> test10a = new Test10<Integer>("ABC");	//<T> is 'String', <X> is 'Integer'
	Test10<Integer> test10b = new Test10<>("ABC");			//<T> is 'String', <X> is 'Integer' (Type Inference)
	
	void process(List<String> stringList) {/***/}
}




