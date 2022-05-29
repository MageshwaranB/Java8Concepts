package com.parallelstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamEx1
{
	public static void main(String[] args) {
		/*
		 * In sequential stream, a single core will take care all the stream, so the execution time will be high
		 * Whereas in parallel stream, the streams will divided into multiple smaller streams and then 
		 * multiple cores are used to execute those streams parallelly. This reduces the execution time 
		 */
		
		/*
		 * The below two lines of code will tell us
		 * how many core one's system has
		 */
		
		ForkJoinPool corePool = ForkJoinPool.commonPool();
		System.out.println(corePool.getParallelism());
		
		/*
		 * To achieve parallelism, there are two ways
		 */
		
		//1st way->using parallel() on stream
		
		Stream snackMeal = Stream.of("Biscuit","Chocolate","Tea","Bread","Jam");
		 BaseStream parallelStreamSnack = snackMeal.parallel();
		
		 //sequential stream
		 Stream.of("Biscuit","Chocolate","Tea","Bread","Jam").forEach(x->System.out.println(x));
		 System.out.println("--------------------");
		 //paralle stream
		 Stream.of("Biscuit","Chocolate","Tea","Bread","Jam")
		 .parallel()
		 .forEach(x->System.out.println(x));//order is not the same because of multi threading
		 
		 //2nd way->applying parallelStream on collection
		 System.out.println("--------------------");
		 Arrays.asList("Biscuit","Chocolate","Tea","Bread","Jam")
		 		.parallelStream()
		 		.forEach(x->System.out.println(x));
		 
		 //Print 1 to 10
		 //sequentialStream
		 IntStream.rangeClosed(0, 10)
		 			.forEach(x->System.out.println(x));
		 //parallel Stream
		 System.out.println("--------------------");
		 IntStream.rangeClosed(0, 10)
		 			.parallel()
		 			.forEach(x->System.out.println(x));
		 System.out.println(getAlphabets());
		 System.out.println("--------------------");
		 //Sequential Stream
		 getAlphabets().stream()
		 				.forEach(System.out::println);
		 System.out.println("--------------------");
		 //Parallel Stream
		 getAlphabets().parallelStream()
		 				.forEach(System.out::println);
		 
		 //Check stream is running parallel or not
		 IntStream range = IntStream.rangeClosed(0, 10);
		 IntStream range2 = IntStream.rangeClosed(0, 10)
				 						.parallel();
		 System.out.println(range.isParallel());
		 System.out.println(range2.isParallel());
	}
	
	public static List<String> getAlphabets() {
		List<String> alpha=new ArrayList<String>();
		int n=97;
		while(n<=122) {
			char c=(char) n;
			alpha.add(String.valueOf(c));
			n++;
		}
		return alpha;
	}
}
