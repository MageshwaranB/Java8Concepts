package com.functionInterfaceExercises;

import java.util.function.Function;



public class FunctionInterfaceConcept {
	public static void main(String[] args) {
		/*
		 * Interface Function<T,R> Type Parameters: T - the type of the input to the
		 * function R - the type of the result of the function
		 */

		Function<String, Integer> function1 = x -> x.length();
		/*
		 * What happening here is we're providing an input type of string in the apply
		 * method and getting the result as an integer with the help of lambda
		 * expression. Here String represents T and Integer represents R
		 */
		System.out.println(function1.apply("We're in this together"));

		// Chaining methods
		Function<Integer, Integer> function2 = x -> x * 2;
		/*
		 * In the below code, we're first executing the string in the apply method since
		 * in the generics of the function1 we've mentioned the input as String, so we're allowed to pass a string
		 * and it will return an integer which is then passed to the input of function2 which in this case is an integer and we're multiplying the length we got from function1 by 2 
		 */
		System.out.println(function1.andThen(function2).apply("Avengers assemble"));
		
		Function<String, Boolean> fun3=x->x.isBlank();
		System.out.println(fun3.apply(""));
	}
}
