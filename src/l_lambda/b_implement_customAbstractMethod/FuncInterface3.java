package l_lambda.b_implement_customAbstractMethod;

@FunctionalInterface
interface FuncInterface3 {
	void abstractFun(int x, int y);

	default void normalFun() {
		System.out.println("Hello");
	}
}
