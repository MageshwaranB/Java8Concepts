package com.SupplierInterfaceExercises;

import java.util.function.Supplier;

public class SupplierInterfaceConcept {
	public static void main(String[] args) {
		/*
		 * Interface Supplier<T> Type Parameters: T - the type of results supplied by
		 * this supplier Functional Interface: This is a functional interface and can
		 * therefore be used as the assignment target for a lambda expression or method
		 * reference.
		 * 
		 * Represents a supplier of results. There is no requirement that a new or
		 * distinct result be returned each time the supplier is invoked.
		 * 
		 * This is a functional interface whose functional method is get().
		 * 
		 * In simple terms, it doesn't take any argument but it will return something
		 * So, we can say it's an exact inverse of Consumer Interface
		 */

		/*
		 * In the below line of code, we're calling the getText method which takes Supplier Interface
		 * as argument and in turn prints us the length of the value which we passed using
		 * lambda. Note that this get() which is available from supplier interface 
		 * doesn't take any arguments and it only provides the result
		 */
		getText(() -> "java");
		
	}

	public static void getText(Supplier<String> supply) {
		System.out.println(supply.get().length());
	}
}
