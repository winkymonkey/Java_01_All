package org.example.java.p_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class B_IntermediateOps {
	
	public static void main(String[] args) {
		/*--------------------------------------------------------------------------------------------------*/
		List<String> strList = Arrays.asList("Reflection","Collection","Stream","Static","Static","Reflection","Final");
		List<Student> objList = Arrays.asList(new Student(1, "Cameron", "Developer", "Germany"),
												new Student(4, "Bob", "Tester", "Australia"),
												new Student(3, "Daniel", "Support", "Japan"),
												new Student(5, "Emily", "Developer", "India"),
												new Student(2, "Alice", "Support", "Japan"),
												new Student(6, "George", "Developer", "India"));
		/*--------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * ---------------------------
		 * Using "map(Function)"
		 * ---------------------------
		 */
		Stream<Integer> stream1 = strList.stream().map(str->str.length() );
		Stream<String> stream2 = objList.stream().map(stu->stu.getName() );
		
		
		/**
		 * ---------------------------
		 * Using "filter(Predicate)"
		 * ---------------------------
		 */
		Stream<String> stream3 = strList.stream().filter(str->str.startsWith("S") );
		Stream<Student> stream4 = objList.stream().filter(stu->stu.getRole().startsWith("D") );
		
		
		/**
		 * ---------------------------
		 * Using "sorted(Comparator)"
		 * ---------------------------
		 */
		Stream<String> stream5 = strList.stream().sorted();
		Stream<Student> stream6 = objList.stream().sorted(Comparator.comparing(Student::getId) );
		
		
		/**
		 * ----------------------
		 * Using "distinct()"
		 * ----------------------
		 */
		Stream<String> stream7 = strList.stream().distinct();
		Stream<Student> stream8 = objList.stream().distinct();		// (not possible to decide distinct as per property)
		
		
		/**
		 * ----------------------
		 * Using "limit(long)"
		 * ----------------------
		 */
		Stream<String> stream9 = strList.stream().limit(5);
		Stream<Student> stream10 = objList.stream().limit(3);
		
		
		/**
		 * -------------------------------------------------------
		 * Using "flatMap(Function)" -- with collection of String
		 * -------------------------------------------------------
		 */
		List<String> list1 = Arrays.asList("CC","GG","AA","PP");
		List<String> list2 = Arrays.asList("XX","MM","BB");
		List<String> list3 = Arrays.asList("CC","AA","FF","YY");
		Stream<String> stream12 = Stream.of(list1, list2, list3).flatMap( eachList -> eachList.stream() );
		
		
		/**
		 * --------------------------------------------------------
		 * Using "flatMap(Function)" -- with collection of Objects
		 * --------------------------------------------------------
		 */
		class OrderItem {
			private String itemName;
			public OrderItem(String itemName) {
				this.itemName = itemName;
			}
		}
		class Order {
			private Integer oid;
			private List<OrderItem> itemList;
			public Order(Integer oid, List<OrderItem> itemList) {
				this.oid = oid;
				this.itemList = itemList;
			}
		}
		Order o1 = new Order(123, Arrays.asList(new OrderItem("AAA"), new OrderItem("BBB"), new OrderItem("CCC")));
		Order o2 = new Order(456, Arrays.asList(new OrderItem("AAA"), new OrderItem("BBB")));
		Order o3 = new Order(789, Arrays.asList(new OrderItem("AAA"), new OrderItem("XXX"), new OrderItem("PPP")));
		Stream<OrderItem> stream13 = Stream.of(o1,o2,o3).flatMap( order -> order.itemList.stream() );
	
	}
		
}
