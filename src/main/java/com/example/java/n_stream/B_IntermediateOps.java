package com.example.java.n_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class B_IntermediateOps {
	public static void main(String[] args) {
		/*-------------------------------------------------------------------------------------------------------------------*/
		class Employee {
			private int id;
			private String name;
			private String role;
			private String location;
			
			Employee(int id, String name, String role, String location) {
				this.id = id;
				this.name = name;
				this.role = role;
				this.location = location;
			}
			
			public int getId() {
				return id;
			}
			public String getName() {
				return name;
			}
			public String getRole() {
				return role;
			}
			public String getLocation() {
				return location;
			}
		}
		List<String> strList = Arrays.asList("Reflection","Collection","Stream","Static","Static","Reflection","Final");
		List<Employee> objList = Arrays.asList(new Employee(1, "Cameron", "Developer", "Germany"),
												new Employee(4, "Bob", "Tester", "Australia"),
												new Employee(3, "Daniel", "Support", "Japan"),
												new Employee(5, "Emily", "Developer", "India"),
												new Employee(2, "Alice", "Support", "Japan"),
												new Employee(6, "George", "Developer", "India"));
		
		Stream<String> streamOfStr = strList.stream();
		Stream<Employee> streamOfObj = objList.stream();
		/*-------------------------------------------------------------------------------------------------------------------*/
		
		
		
		/**
		 * ----------------------
		 * Using "map()"
		 * ----------------------
		 */
		Stream<Integer> stream1 = streamOfStr.map(str->str.length());
		Stream<String> stream2 = streamOfObj.map(emp->emp.getName());		//same as --- streamOfObj.map(obj -> {return obj.getName();});
		
		
		/**
		 * ----------------------
		 * Using "filter()"
		 * ----------------------
		 */
		Stream<String> stream3 = streamOfStr.filter(str->str.startsWith("S"));
		Stream<Employee> stream4 = streamOfObj.filter(emp->emp.getRole().startsWith("D"));
		
		
		/**
		 * ----------------------
		 * Using "sorted()"
		 * ----------------------
		 */
		Stream<String> stream5 = streamOfStr.sorted();
		Stream<Employee> stream6 = streamOfObj.sorted(Comparator.comparing(Employee::getId));
		Stream<Employee> stream7 = streamOfObj.sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getName));
		
		
		/**
		 * ----------------------
		 * Using "distinct()"
		 * ----------------------
		 */
		Stream<String> stream8 = streamOfStr.distinct();
		Stream<Employee> stream9 = streamOfObj.distinct();		//(not possible to decide distinct as per property)
		
		
		/**
		 * ----------------------
		 * Using "limit()"
		 * ----------------------
		 */
		Stream<String> stream10 = streamOfStr.limit(5);
		Stream<Employee> stream11 = streamOfObj.limit(3);
		
		
		/**
		 * ----------------------------------------------
		 * Using "flatMap()" -- with collection of String
		 * ----------------------------------------------
		 */
		List<String> list1 = Arrays.asList("CC","GG","AA","PP");
		List<String> list2 = Arrays.asList("XX","MM","BB");
		List<String> list3 = Arrays.asList("CC","AA","FF","YY");
		Stream<List<String>> streamOfLists = Stream.of(list1, list2, list3);
		Stream<String> stream = streamOfLists.flatMap(eachList -> eachList.stream());
		
		
		/**
		 * -----------------------------------------------
		 * Using "flatMap()" -- with collection of Objects
		 * -----------------------------------------------
		 */
		class OrderLineItem {
			String itemName;
			public OrderLineItem(String itemName) {
				this.itemName = itemName;
			}
		}
		class Order {
			int oid;
			List<OrderLineItem> lineItemList;
			public Order(int oid, List<OrderLineItem> lineItemList) {
				this.oid = oid;
				this.lineItemList = lineItemList;
			}
		}
		Order o1 = new Order(123, Arrays.asList(new OrderLineItem("AAA"), new OrderLineItem("BBB"), new OrderLineItem("CCC")));
		Order o2 = new Order(456, Arrays.asList(new OrderLineItem("AAA"), new OrderLineItem("BBB")));
		Order o3 = new Order(789, Arrays.asList(new OrderLineItem("AAA"), new OrderLineItem("XXX"), new OrderLineItem("PPP")));
		List<Order> orderList = Arrays.asList(o1,o2,o3);
		Stream<OrderLineItem> orderLineItemStream = orderList.stream().flatMap(order -> order.lineItemList.stream());
	}
}


