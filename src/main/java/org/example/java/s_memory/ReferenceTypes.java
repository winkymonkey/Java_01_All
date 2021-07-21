package org.example.java.s_memory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;


/*************************************************
 *				Strong Reference
 *************************************************/
class MyClass {
	public void print() {
		System.out.println("hello");
	}
}

class Test01 {
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		cls.print();
		cls = null;
	}
}





/*************************************************
 *				Soft Reference
 *************************************************/
class Test02 {
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		cls.print();
		
		SoftReference<MyClass> softref = new SoftReference<MyClass>(cls);
		
		cls = null;
		
		cls = softref.get();
		cls.print();
	}
}





/*************************************************
 *				Weak Reference
 *************************************************/
class Test03 {
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		cls.print();
		
		WeakReference<MyClass> weakref = new WeakReference<MyClass>(cls);
		
		cls = null;
		
		cls = weakref.get();
		cls.print();
	}
}





/*************************************************
 *				Phantom Reference
 *************************************************/
@SuppressWarnings({"unused"})
class Test04 {
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		cls.print();

		ReferenceQueue<MyClass> refQueue = new ReferenceQueue<MyClass>();

		PhantomReference<MyClass> phantomRef = new PhantomReference<MyClass>(cls, refQueue);

		cls = null;
		
		/*Reference ref = refQueue.poll();
		while (ref != null) {
			// Do the cleanup task
		}*/
	}
}



