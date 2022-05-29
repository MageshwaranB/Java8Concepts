package com.sequentialStreamsConcept;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialStreamExercise {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Michael", "Sonny", "Fredo", "Vitto");
		stream.forEach(x -> System.out.println(x));
		/*
		 * The below two lines of code will throw IllegalStateException because we've
		 * closed the stream operation in the above line. Once closed, the same stream
		 * cannot be used again
		 */

		// List<String> filteredStream = stream.filter(x->x.contains("aeio"))
		// .collect(Collectors.toList());
		// filteredStream.forEach(System.out::println);

		/*
		 * First, we've Arrays as a list and stream it, Then, we're finding the first
		 * value and if we the first value present is not null then we're just
		 * converting it to uppercase and printing it in the console
		 * 
		 */

		Arrays.asList("Sachin", "Virat", "Lara", "Ponting")
			  .stream()
			  .findFirst()
			  .ifPresent(x -> System.out.println(x.toUpperCase()));
		;

		// IntStream

		/*
		 * A sequence of primitive int-valued elements supporting sequential and
		 * parallel aggregate operations. This is the int primitive specialization of
		 * Stream.
		 */

		/*
		 * This will start with 1 (initial value) and ends at 9 (final value-1).
		 */
		IntStream.range(1, 10)
				.forEach(System.out::println);

		Arrays.stream(new int[] { 1, 2, 3, 4, 5 })
				.map(x->(x*2)+4)
				.average()
				.ifPresent(x -> System.out.println(x));

		// String data objects
		/*
		 * First we are passing a string a1,a2,a3 with the help of substring method,
		 * we're getting integer value from the string which needs to be passed inside a
		 * map method then we're converting the numbers which are in string format to
		 * integer with the help of parseint method and then finally if those elements
		 * present we're printing the max value out of the numbers
		 */
		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt).max()
				.ifPresent(x -> System.out.println(x));

		// Converting a double data to String object
		/*
		 * We're declaring the double values and converting them to an integer using int
		 * Value method by mapping it to Integer
		 * then we're mapping it to a string object also appended it with a
		 * and then printing it using for each method
		 */
		Stream.of(1.0, 3.0, 2.0, 5.0).mapToInt(Double::intValue).mapToObj(x -> "a" + x)
				.forEach(x -> System.out.println(x));

	}
}
