package k_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// If T implements Comparable ------- Collections.sort(List<T>)
// If T not implements Comparable --- Collections.sort(List<T>, Comparator<? super T>)


@SuppressWarnings("unused")
public class E_Sort_Set {
	public static void main(String[] args) {
		sort_SetOf_string_naturalOrder();			System.out.println("----------");
		sort_SetOf_string_customOrder();			System.out.println("----------");
		sort_SetOf_objectImplementsComparable();	System.out.println("----------");
		sort_SetOf_anyObject();						System.out.println("----------");
		sort_SetOf_anyObject_java8();
	}
	
	
	
	private static void sort_SetOf_string_naturalOrder() {
		Set<String> set = new HashSet<>();
		set.add("Bob");
		set.add("Alice");
		set.add("Cameron");
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		list.forEach(str->System.out.println(str));		//Alice Bob Cameron
	}
	
	
	
	private static void sort_SetOf_string_customOrder() {
		Set<String> set = new HashSet<>();
		set.add("Bob");
		set.add("Alice");
		set.add("Cameron");
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, (s1,s2)->(s1.length()-s2.length()) );
		list.forEach(str->System.out.println(str));		//Bob Alice Cameron
	}
	
	
	
	private static void sort_SetOf_objectImplementsComparable() {
		class Student implements Comparable<Student> {
			private String name;
			private int age;
			Student(String name, int age) {
				this.name = name;
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public int getAge() {
				return age;
			}
			public int compareTo(Student st) {
				return this.getName().compareTo(st.getName());
				//return this.getAge() - st.getAge();
			}
		}
		
		Set<Student> set = new HashSet<>();
		Student s1 = new Student("Bob", 33);
		Student s2 = new Student("Alice", 66);
		Student s3 = new Student("Cameron", 11);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		List<Student> list = new ArrayList<>(set);
		Collections.sort(list);
		list.forEach(stu->stu.getName());
	}
	
	
	
	private static void sort_SetOf_anyObject() {
		class Student {
			private String name;
			private int age;
			Student(String name, int age) {
				this.name = name;
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public int getAge() {
				return age;
			}
		}
		
		Set<Student> set = new HashSet<>();
		Student s1 = new Student("Bob", 33);
		Student s2 = new Student("Alice", 66);
		Student s3 = new Student("Cameron", 11);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		List<Student> list = new ArrayList<>(set);
		Collections.sort(list, (st1,st2)->(st1.getName().compareTo(st2.getName())) );
		for(Student st : list) {
			System.out.println(st.getName() + "--" + st.getAge());		
		}
		list.forEach(stu->System.out.println(stu.getName()));			//Alice Bob Cameron
	}
	
	
	
	private static void sort_SetOf_anyObject_java8() {
		class Student {
			private String name;
			private int age;
			Student(String name, int age) {
				this.name = name;
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public int getAge() {
				return age;
			}
		}
		
		Set<Student> set = new HashSet<>();
		Student s1 = new Student("Bob", 33);
		Student s2 = new Student("Alice", 66);
		Student s3 = new Student("Cameron", 11);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		//natural ordering of "name"
		List<Student> list1 = new ArrayList<>(set);
		Collections.sort(list1, Comparator.comparing(Student::getName));
		list1.forEach(student->System.out.println());
		
		//natural ordering of "name". If conflict, then compare as per "age"
		List<Student> list2 = new ArrayList<>(set);
		Collections.sort(list2, Comparator.comparing(Student::getName).thenComparing(Student::getAge));
		list2.forEach(student->System.out.println());
		
		//custom ordering of "name"
		List<Student> list3 = new ArrayList<>(set);
		Collections.sort(list3, Comparator.comparing(Student::getName, (st1,st2)->st1.compareTo(st2)) );
		list3.forEach(student->System.out.println());
	}
}


