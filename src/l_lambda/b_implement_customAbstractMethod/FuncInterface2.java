package l_lambda.b_implement_customAbstractMethod;

@FunctionalInterface
interface FuncInterface2 {
	void abstractFun(int x);

	default void normalFun() {
		System.out.println("Hello");
	}
}
