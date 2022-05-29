package com.LambdaConcepts;

@FunctionalInterface
public interface LambdaCreation {
	/*
	 * Functional interface is a concept in which an interface has only one abstract
	 * methods. We can denote the functional interface by an annotation although it
	 * not needed to explicitly mentioned
	 * We can have more than one abstract methods but in the case, we can't use lambda expression
	 */
	void activity(String value);
	//void failure(); This will throw error 
	/*
	 * However, we're allowed to created static and default methods it will work but the main criteria is there has to be
	 * only one abstract method
	 */
	
	static void staticMethodEg() {
		
	}
	default void defaultMethodEg() {
		
	}
}
