package com.flatMap;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class StreamIntArrayWithFlatMap {
	public static void main(String[] args) {
		int[] data= {2,14,3,0,10,5};
		Stream<int[]> streamIntData = Stream.of(data);
		IntStream intStream = streamIntData.flatMapToInt(x->Arrays.stream(x));
		System.out.println("Sorted order: ");
		intStream.sorted().forEach(x->System.out.println(x));
		
		Faker fakeData=new Faker();
		
		Arrays.asList(fakeData.book()
				.title(),fakeData.book().title())
				.stream()
				.map(n->"Random Title generator: "+n)
				.forEach(System.out::println);
				
	}
}
