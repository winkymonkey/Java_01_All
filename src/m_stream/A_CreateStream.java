package m_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class A_CreateStream {
	public static void main(String[] args) {
		// Stream from collection
		List<String> nameList = Arrays.asList("Reflection","Collection","Stream","Static","Static","Reflection","Final");
		Stream<String> stream1 = nameList.stream();			//sequential stream
		Stream<String> stream2 = nameList.parallelStream();	//parallel stream
		
		
		// Stream from array
		int[] arr = {1, 2, 3, 4};
		IntStream stream3 = Arrays.stream(arr);
		
		
		// Stream.of()
		Stream<Integer> stream4 = Stream.of(1, 2, 3, 4);
		
		
		// Stream.generate()
		Stream<Integer> stream5 = Stream.generate(()->new Random().nextInt()).limit(5);
		
		
		//Stream.iterate()
		Stream<Integer> stream6 = Stream.iterate(0, i->i+1).limit(5);
		
		
		//IntStream.range()
		IntStream stream7 = IntStream.range(4, 10);
	}
}

