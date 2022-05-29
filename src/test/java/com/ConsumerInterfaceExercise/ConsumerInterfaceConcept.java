package com.ConsumerInterfaceExercise;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceConcept {
	public static void main(String[] args) {
		/*
		 * Type Parameters: T - the type of the input to the operation 
		 * All Known Subinterfaces: Stream.Builder<T>
		 * 
		 * Represents an operation that accepts a single input argument and returns no
		 * result. Unlike most other functional interfaces, Consumer is expected to
		 * operate via side-effects.
		 * 
		 * This is a functional interface whose functional method is accept(Object).
		 */

		Consumer<String> conFunction = x -> System.out.println(x);
		/*
		 * Since consumer returns void, we can perform operations which usually doesn't
		 * return any values like printing
		 */
		conFunction.accept("My name is Magesh");

		List<Integer> startingList = Arrays.asList(1, 5, 10, 20, 5, 59, 60, 1);
		/*
		 * In list, there's one method called forEach which takes Consumer as an
		 * argument and we're printing the elements one by one.
		 * This basically performs like a foreach loop
		 */
		startingList.forEach(x -> System.out.println(x));

	}

}
