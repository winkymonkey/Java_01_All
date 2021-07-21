package org.example.java.a_coreStructure;


@SuppressWarnings("unused")
class Test09 {
	
	//DECLARATION :: array & 2D array
	{
		byte[] byteArray;
		short[] shortArray;
		char[] charArray;
		int[] intArray;
		long[] longArray;
		float[] floatArray;
		double[] doubleArray;
		boolean[] booleanArray;
		
		String[] stringArray;
		Object[] objectArray;
		
		String[][] names;
		int[][] heights;
	}
	
	
	//INITIALIZATION : array
	{
		int[] intArray = new int[10];
		intArray[0] = 100;
		intArray[1] = 200;
		
		int[] intArray2 = {100, 200, 300};
	}
	
	
	//INITIALIZATION : 2D array
	{
		String[][] names = {{"Mr.","Mrs.","Miss."}, {"Smith","Jones"}};
		System.out.println(names[0][0] + names[1][0]);
		System.out.println(names[0][2] + names[1][1]);
	}
}

