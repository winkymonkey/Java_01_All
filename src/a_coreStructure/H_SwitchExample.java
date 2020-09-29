package a_coreStructure;


class Test10 {
	//types in a switch
	{
		int i = 10;
		switch(i) {
			//TODO
		}
		
		byte by = 10;
		switch(by) {
			//TODO
		}
		
		short sh = 10;
		switch(sh) {
			//TODO
		}
		
		char ch = 'x';
		switch(ch) {
			//TODO
		}
		
		String str = "abcd";
		switch(str) {
			//TODO
		}
	}
	
	
	//case variable
	{
		int i = 2;
		final char ch = '2';
		
		switch(i) {
		case 2:
			System.out.println("aaa");
			break;
		case ch:
			System.out.println("bbb");
			break;
		}
	}
	
	
	//without break statement
	{
		int i = 2;		
		switch(i) {
		case 1:
			System.out.println("it is 1");
		case 2:
			System.out.println("it is 2");
		case 3:
			System.out.println("it is 3");
		case 4:
			System.out.println("it is 4");
			break;
		case 5:
			System.out.println("it is 5");
		}
	}
	
	
	//multiple case labels
	{
		int i = 10;
		switch(i) {
		case 1: case 3: case 5: case 7: case 9:
			System.out.println("odd");
			break;
		case 2: case 4: case 6: case 8: case 10:
			System.out.println("even");
			break;
		}
	}
}


