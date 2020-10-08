package com.example.java.o_multithreading.a_lowLevel;


/****************************************************************************/
/**					SharedResource with Local Variable						*/
/****************************************************************************/
@SuppressWarnings("unused")
class SharedResource1 {
	public void someMethod() {
		long threadSafeInt = 0;
		threadSafeInt++;
	}
}





/****************************************************************************/
/**					SharedResource with Local Object						*/
/****************************************************************************/
class SharedResource2 {
	public void someMethod() {
		LocalObject localObject = new LocalObject();
		localObject.callMethod();
		method2(localObject);
	}

	public void method2(LocalObject localObject) {
		localObject.setValue("value");
	}
}

class LocalObject {
	void callMethod() {}
	void setValue(String s) {}
}





/****************************************************************************/
/**					SharedResource with (sharing) Instance Variable			*/
/****************************************************************************/
class SharedResource3 {
	NotThreadSafe sharedInstance = new NotThreadSafe();
	
	Thread t1 = new Thread(() -> {
		sharedInstance.add("text1");
	});
	Thread t2 = new Thread(() -> {
		sharedInstance.add("text2");
	});
}

class NotThreadSafe {
	StringBuilder builder = new StringBuilder();

	public void add(String text){
        this.builder.append(text);
    }
}




/****************************************************************************/
/**					SharedResource with (not sharing) Instance Variable		*/
/****************************************************************************/
class SharedResource4 {
	Thread t1 = new Thread(() -> {
		new NotThreadSafe().add("text1");
	});
	Thread t2 = new Thread(() -> {
		new NotThreadSafe().add("text2");
	});
}


