package d_overloading;


class Overloading1 {
	void study() {
		//
	}
	void study(int id) {
		//
	}
	void study(int id, String name) {
		//
	}
	void study(String name, int id) {
		//
	}
}


class Overloading2 {
	void study(long id) {
		System.out.println("study - long");
	}
	void study(Long id) {
		System.out.println("study - Long");
	}
	/***********/	
	void work(long id) {
		System.out.println("work - long");
	}
	void work(long... id) {
		System.out.println("work - long(varArgs)");
	}
	/***********/	
	/*void walk(long... id) {
		System.out.println("sleep - long(varArgs)");
	}
	void walk(long[] id) {
		System.out.println("sleep - long(array)");
	}*/
	/***********/
	void enjoy(String str) {
		System.out.println("enjoy String");
	}
	void enjoy(Object obj) {
		System.out.println("enjoy object");
	}
	
	
	public static void main(String[] args) {
		Overloading2 tricky = new Overloading2();
		
		tricky.study(1);
		tricky.study(1L);
		
		tricky.work(2);
		tricky.work(2L);
		
		//tricky.walk(3);
		//tricky.walk(3L);
		
		tricky.enjoy(null);
	}
}

