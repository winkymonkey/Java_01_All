package a_coreStructure;

import static java.lang.Math.sqrt;


class UsingStaticImport {
	public static void main(String[] args) {
		System.out.println(sqrt(4)); 
	}
}

class WithoutStaticImport {
	public static void main(String[] args) {
		System.out.println(Math.sqrt(4)); 
	}
}

class Ambiguous1 {
	public static void main(String[] args) {
		//System.out.println(MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}

class Ambiguous {
	public static void main(String[] args) {
		//Date today;
		//java.util.Date today;
	}
}
