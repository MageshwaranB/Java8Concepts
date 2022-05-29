package com.parallelstream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimaryNumberWithParallelStream {
	public static void main(String[] args) {
		System.out.println(isPrime(7));
		long t1,t2;
		t1=System.currentTimeMillis();
		long count = Stream.iterate(0, n-> n+1)
				.limit(10000)
				.parallel()
				.filter(PrimaryNumberWithParallelStream::isPrime)
				.peek(x->System.out.println(x))//this method will print the result
				.count();
		System.out.println("Total prime numbers in first 1000: "+count);
		t2=System.currentTimeMillis();
		System.out.println("Total time taken by parallel stream: "+(t2-t1)/1000);
		
		t1=System.currentTimeMillis();
		long sequentialCount = Stream.iterate(0, n-> n+1)
				.limit(10000)
				.filter(PrimaryNumberWithParallelStream::isPrime)
				.peek(x->System.out.println(x))//this method will print the result
				.count();
		System.out.println("Total prime numbers in first 1000: "+sequentialCount);
		t2=System.currentTimeMillis();
		System.out.println("Total time taken by sequential stream: "+(t2-t1)/1000);
				
	}
	public static boolean isPrime(int number) {
		if(number<=1)
			return false;
		else
			/*
			 * Here, we're setting the range between 2 to number/2
			 * and we're giving a condition in anyMatch which takes a predicate
			 * and after performing operation mentioned in anymatch if the given 
			 * number is present in the range then it will true.
			 * However for our operation, let say number is 7 which is prime
			 * 7/2->3. Then 7 won't be in the range that's why we 
			 * are inverting the condition. In this case, anyMatch will return false
			 * and the not operator will invert that to true
			 *  
			 */
			return !IntStream.rangeClosed(2, number/2)
						.anyMatch(x->number%x==0);
		
	}
}
