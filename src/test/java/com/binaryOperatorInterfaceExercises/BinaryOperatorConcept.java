package com.binaryOperatorInterfaceExercises;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorConcept {
	public static void main(String[] args) {
		/*
		 * Type Parameters: T - the type of the operands(arguments) and result of the operator 
		 * All Superinterfaces: BiFunction<T,T,T>
		 * Represents an operation upon two operands(arguments)
		 * of the same type, producing a result of the same type as the operands(arguments). This
		 * is a specialization of BiFunction for the case where the operands(arguments) and the
		 * result are all of the same type.
		 * 
		 * This is a functional interface whose functional method is BiFunction.apply(Object, Object).
		 */
		
		BinaryOperator<Integer> biOperator=(x1,x2)->x1+x2; //We're passing two inputs of the same type and performing addition and getting output of the same type 
		System.out.println(biOperator.apply(30, 50));
		
		//Same thing with BiFunction interface
		
		BiFunction<Integer, Integer, Integer> biFunction= (y1,y2)->y1.compareTo(y2); //we're comparing two integers with compareTo method, if they matches it will return 0 else it will 1
		System.out.println(biFunction.apply(606, 606));
		
		
	}
}
