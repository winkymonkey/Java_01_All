package com.example.java.a_coreStructure;


class Test08 {
	void doStuff1(int... x) { }					//Valid
	void doStuff2(char c, int... x) { }			//Valid
	void doStuff3(Object... obj) { }			//Valid
	
	//void doStuff4(int... x) { }					//Illegal
	//void doStuff5(int... x1, int... x2) { }		//Illegal (too many var-args)
	//void doStuff6(int... x, char c) {  }			//Illegal (var-args must be at last)
}
