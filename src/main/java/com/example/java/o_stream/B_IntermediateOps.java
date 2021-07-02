package com.example.java.o_stream;

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
		
		Stream<String> strStream = strList.stream();
		Stream<Student> objStream = objList.stream();		
		/*--------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * ---------------------------
		 * Using "map(Function)"
		 * ---------------------------
		 */
		Stream<Integer> stream1 = strStream.map(str->str.length() );
		Stream<String> stream2 = objStream.map(stu->stu.getName() );
		
		
		/**
		 * ---------------------------
		 * Using "filter(Predicate)"
		 * ---------------------------
		 */
		Stream<String> stream3 = strStream.filter(str->str.startsWith("S") );
		Stream<Student> stream4 = objStream.filter(stu->stu.getRole().startsWith("D") );
		
		
		/**
		 * ---------------------------
		 * Using "sorted(Comparator)"
		 * ---------------------------
		 */
		Stream<String> stream5 = strStream.sorted();
		Stream<Student> stream6 = objStream.sorted(Comparator.comparing(Student::getId) );
		Stream<Student> stream7 = objStream.sorted(Comparator.comparing(Student::getId).thenComparing(Student::getName) );
		
		
		/**
		 * ----------------------
		 * Using "distinct()"
		 * ----------------------
		 */
		Stream<String> stream8 = strStream.distinct();
		Stream<Student> stream9 = objStream.distinct();		//(not possible to decide distinct as per property)
		
		
		/**
		 * ----------------------
		 * Using "limit(long)"
		 * ----------------------
		 */
		Stream<String> stream10 = strStream.limit(5);
		Stream<Student> stream11 = objStream.limit(3);
		
		
		/**
		 * -------------------------------------------------------
		 * Using "flatMap(Function)" -- with collection of String
		 * -------------------------------------------------------
		 */
		List<String> list1 = Arrays.asList("CC","GG","AA","PP");
		List<String> list2 = Arrays.asList("XX","MM","BB");
		List<String> list3 = Arrays.asList("CC","AA","FF","YY");
		Stream<List<String>> listStream = Stream.of(list1, list2, list3);
		Stream<String> stream12 = listStream.flatMap(eachList -> eachList.stream());
		
		
		/**
		 * --------------------------------------------------------
		 * Using "flatMap(Function)" -- with collection of Objects
		 * --------------------------------------------------------
		 */
		class OrderLineItem {
			private String itemName;
			public OrderLineItem(String itemName) {
				this.itemName = itemName;
			}
		}
		class Order {
			private Integer oid;
			private List<OrderLineItem> lineItemList;
			public Order(Integer oid, List<OrderLineItem> lineItemList) {
				this.oid = oid;
				this.lineItemList = lineItemList;
			}
		}
		Order o1 = new Order(123, Arrays.asList(new OrderLineItem("AAA"), new OrderLineItem("BBB"), new OrderLineItem("CCC")));
		Order o2 = new Order(456, Arrays.asList(new OrderLineItem("AAA"), new OrderLineItem("BBB")));
		Order o3 = new Order(789, Arrays.asList(new OrderLineItem("AAA"), new OrderLineItem("XXX"), new OrderLineItem("PPP")));
		List<Order> orderList = Arrays.asList(o1,o2,o3);
		Stream<OrderLineItem> stream13 = orderList.stream().flatMap(order -> order.lineItemList.stream());
	
	}
		
}
