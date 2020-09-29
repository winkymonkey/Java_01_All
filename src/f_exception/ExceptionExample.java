package f_exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/********************************************************************************************/
class TryWithResources {
	public static void main(String[] args) throws Exception {
		beforeJava8();
		afterJava8();
	}
	
	private static void beforeJava8() throws FileNotFoundException, IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			System.out.println(br.readLine());
		}
		finally {
			if(null != br) {
				br.close();
			}
		}
	}
	
	private static void afterJava8() throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			System.out.println(br.readLine());
		}
	}
}


/********************************************************************************************/
class MultiCatch {
	public static void main(String[] args) {
		try {
			//
		}
		catch(NullPointerException | ArithmeticException e) {
			//
		}
	}
}


/********************************************************************************************/
class MultiCatch_EffectivelyFinalInstance {
	public static void main(String[] args) {
		try {
			//
		}
		catch(NullPointerException | ArithmeticException e) {
			//e = new NullPointerException();
		}
	}
}


/********************************************************************************************/
class CustomCheckedException extends Exception {
	private static final long serialVersionUID = 3307274333358638887L;
	CustomCheckedException(String str) {
		super(str);
	}
}

class CustomUnCheckedException extends RuntimeException {
	private static final long serialVersionUID = 3307274333358638887L;
	CustomUnCheckedException(String str) {
		super(str);
	}
}


/********************************************************************************************/
class PreciseRethrow {
	void print(int a) throws NullPointerException {
		try {
			if(a<0)
				throw new NullPointerException();
			else
				throw new ArithmeticException();
		}
		catch(Exception e) {
			throw e;
		}
	}
}


