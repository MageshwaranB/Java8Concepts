package com.infiniteStreamConcepts;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class InfiniteStreamEX1
{
	public static void main(String[] args) {
		/*
		 * infinite stream used to generate infinite stream of data
		 * 
		 * 1. iterate()
		 * static(T seed, Urnary Operator<T> fun), this will return a stream ->Stream<T>
		 */
		
		/*
		 * In IntStream, we have iterate method, where need to provide a seed 
		 * and unary operator (here in this case n->n+2)
		 * and mapping it to an object by getting the value of the integer 
		 * and storing it in a list
		 * Note that, we're limiting the operation to 10  
		 */
		
		List<Integer> collect = IntStream.iterate(0, n->n+2)
				  .mapToObj(Integer::valueOf)
				  .limit(10)
				  .collect(Collectors.toList())
				  ;
		System.out.println(collect);
		
		//2. generate method
		//To generate some random numbers upto 100
		
		/*
		 * generate will take supplier as a parameter
		 * and we know that supplier interface doesn't take any argument but will return something
		 * that's why we're passing a blank argument and creating a random object that will return
		 * first 100 numbers in random manner.
		 * we're setting the limit to 10 numbers and storing it in a list
		 */
		collect=Stream.generate(()->(new Random()).nextInt(100))
			.limit(10)
			.collect(Collectors.toList());
		System.out.println(collect);
		
		
		//Using faker to generate random names
		Stream.generate(()->(new Faker().funnyName().name()))
				.limit(7)
				.forEach(System.out::println)
				;
	}
}
