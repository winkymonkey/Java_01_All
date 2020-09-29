package a_coreStructure;


/*******************************************************************
 *						All types of init blocks
 *******************************************************************/
class Test06 {
	Test06(int x){ System.out.println("1-arg constructor"); }
	Test06() { System.out.println("no-arg constructor"); }
	static { System.out.println("1st static init"); }
	{ System.out.println("1st instance init"); }
	{ System.out.println("2nd instance init"); }
	static { System.out.println("2nd static init"); }
	{ System.out.println("3rd instance init"); }
	
	
	public static void main(String[] args) {
		new Test06();
		new Test06(7);
	}
}




/*******************************************************************
 *						Exception from init blocks
 *******************************************************************/
class Test07 {
	{
		int arr[] = {1,2,3};
		System.out.println(arr[100]);
	}
	static {
		int arr[] = {1,2,3};
		System.out.println(arr[100]);
	}
	
	public static void main(String[] args) {
		new Test07();
	}
}


