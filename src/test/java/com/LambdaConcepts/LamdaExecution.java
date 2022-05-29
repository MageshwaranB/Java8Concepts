package com.LambdaConcepts;

public class LamdaExecution {
	public static void main(String[] args) {
		// Normal way
		LambdaCreation lamda = new LambdaCreation() {
			public void activity(String value) {
				System.out.println("Hi I'm " + value);
			}// We're not creating a class rather we make use of anonymous method(A method
				// defined without belonging to a class)
		};

		// Lamda Java 8 way
		/*
		 * -> represents the lamda. When we create more than one abstract method in the
		 * interface, we can't use lamda expression, it will throw an error saying,
		 * "there can't be only one functional interface"
		 */
		LambdaCreation lamdaJava8 = (value) -> {
			System.out.println("Hi I'm " + value.toUpperCase() + " in a java 8 way"); //
		};

		lamda.activity("swimming");
		lamdaJava8.activity("cooking");
	}
}
