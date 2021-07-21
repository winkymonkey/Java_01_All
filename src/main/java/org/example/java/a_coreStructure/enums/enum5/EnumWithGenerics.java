package org.example.java.a_coreStructure.enums.enum5;


interface MyInterface<T> {

}

enum MyEnum implements MyInterface<Integer> {
	RED("S");
	MyEnum(String str) {
		System.out.println(str);
	}
}

public class EnumWithGenerics {
	public static void main(String[] args) {
		System.out.println(MyEnum.RED);
	}
}

