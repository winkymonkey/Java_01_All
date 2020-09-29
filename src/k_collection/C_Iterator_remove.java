package k_collection;

import java.util.ArrayList;
import java.util.Iterator;


public class C_Iterator_remove {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(8);
		list.add(3);

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			if (itr.next() == 2) {
				itr.remove(); 		//SAFE (will not throw Exception)
			}
		}
		Iterator<Integer> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next() == 3) {
            	list.remove(3); 	 //NOT SAFE (will throw Exception on calling next() method)
            }
        }
	}
}


