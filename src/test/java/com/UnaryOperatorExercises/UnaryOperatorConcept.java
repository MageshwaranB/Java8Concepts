package com.UnaryOperatorExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorConcept {
	public static void main(String[] args) {
		/*
		 * Type Parameters: T - the type of the operand and result of the operator 
		 * All Superinterfaces: Function<T,T>
		 * 
		 * Represents an operation on a single operand (argument) that produces a result
		 * of the same type as its operand (argument). This is a specialization of
		 * Function for the case where the operand and result are of the same type.
		 * 
		 * This is a functional interface whose functional method is
		 * Function.apply(Object).
		 */

		UnaryOperator<String> unaryString = (x) -> x.replace(x, "working fine");// replacing the current value provided
																				// in apply with a new value
		System.out.println(unaryString.apply("JurassicPark"));
		UnaryOperator<Integer> intUnaryOperation = (x) -> x % 10;// provides the reminder of the given number when we
																	// divide it by 10
		System.out.println(intUnaryOperation.apply(78501));

		// Using Function interface since this unary operator interface implements
		// function interface

		Function<Integer, Integer> functionUnary = (x) -> x.sum(x, 10);// We're using function interface and summing it
																		// with 10 and returning the result
		System.out.println(functionUnary.apply(20));

		List<String> programmingLang = new ArrayList<String>();
		programmingLang.add("Java");
		programmingLang.add("Python");
		programmingLang.add("C#");
		System.out.println(programmingLang);

		/*
		 * In the below line of code, since replaceAll method takes UnaryOperator
		 * interface as an argument, we can treat the argument the same way as unary
		 * operator
		 * Here we're just adding a string to previously existing strings
		 */
		programmingLang.replaceAll(element -> element + " is a programming language");
		System.out.println(programmingLang);
	}
}
