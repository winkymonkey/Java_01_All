package c_nestedClass;


class Outer3 {
	public int x = 0;

	class Inner {
		public int x = 1;
		void methodOfInner(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("Outer3.this.x = " + Outer3.this.x);
		}
	}

	public static void main(String... args) {
		Outer3.Inner inner = new Outer3().new Inner();
		inner.methodOfInner(23);
	}
}
