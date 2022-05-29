package com.flatMap;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FlatMapExercise1 {
	public static void main(String[] args) {
		String[][] data = new String[][] { { "Ironman", "Tony Stark" }, { "Batman", "Bruce Wayne" },
				{ "Superman", "Clark Kent" }, { "Spiderman", "Peter Parker" } };
		/*
		 * we simply cannot use stream with primitive two dimensional array so we're
		 * converting it to Arrays which is part of collection Stream returns
		 * stream<String[]> When we're using fiter directly on stream type of data,
		 * we'll only get a blank output The workaround for this is to convert it into
		 * flatmap and send it to a filter
		 */

		// Without flatmap
		Stream<String[]> dataStream = Arrays.stream(data);
		Stream<String[]> dataStreamFilter = dataStream.filter(x -> "Ironman".equalsIgnoreCase(x.toString()));
		dataStreamFilter.forEach(System.out::println);// blank output

		// with flatmap
		/*
		 * FlatMap:
		 * Returns a stream consisting of the results of replacing each element of this
		 * stream with the contents of a mapped stream produced by applying the provided
		 * mapping function to each element. Each mapped stream is closed after its
		 * contents have been placed into this stream. (If a mapped stream is null an
		 * empty stream is used, instead.)
		 * 
		 * We need to make sure that flatmap returns stream<string>
		 */
		
		Stream<String[]> newDataStream = Arrays.stream(data);
		
		Stream<String> dataStreamMap = newDataStream.flatMap(x -> Arrays.stream(x));
		Stream<String> dataFiltered = dataStreamMap.filter(x->"Ironman".equals(x.toString()));
		dataFiltered.forEach(System.out::println);
		
		//Everything in a single line
		
		Stream<String> singleLineStreamEg = Arrays.stream(data)
				.flatMap(x->Arrays.stream(x))
			  .filter(x->"Batman".equals(x.toString()));
		singleLineStreamEg.forEach(x->System.out.println(x));
			  
		//Printing n to n-1 values
		Stream.iterate(0, n->n+1)
			  .limit(7)
			  .forEach(System.out::println);
		
		//Finding odd numbers
		Predicate<Integer> oddPredicate=n->n%2!=0;
		Stream.iterate(0, n->n+1)
				.limit(10)
				.filter(oddPredicate)
				.forEach(System.out::println);
		
		
		
	}
}
