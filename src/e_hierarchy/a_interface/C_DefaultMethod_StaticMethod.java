package e_hierarchy.a_interface;


interface Inter {
	public default void def() {
		System.out.println("interface def");
	}
	public static void sta() {
		System.out.println("interface sta");
	}
}

class Cls implements Inter {
	public void def() {						//overriding default-method
		System.out.println("class def");
	}
	public void sta() {						//not overriding
		System.out.println("class sta");
	}
	{
		Inter.sta();				//interface sta
		def();						//class def
		Inter.super.def();			//interface def
	}
	public static void main(String[] args) {
		new Cls();
	}
}


