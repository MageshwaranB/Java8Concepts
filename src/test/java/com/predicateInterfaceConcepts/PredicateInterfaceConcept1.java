package com.predicateInterfaceConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PredicateInterfaceConcept1 {

	public static void main(String[] args) {
		/*
		 * Type Parameters: T - the type of the input to the predicate 
		 * Functional Interface: This is a functional interface and can therefore be used as the
		 * assignment target for a lambda expression or method reference.
		 * 
		 * Abstract method: boolean test(T t)
			Evaluates this predicate on the given argument.
			Parameters:
			t - the input argument
			Returns:
			true if the input argument matches the predicate, otherwise false
		 */
		
		Predicate<Integer> predicateFun=x->x>10;
		/*
		 * First,we're creating predicate where it takes integer as an input and we're mentioning the values should be greater than 10. In general, we can only perform boolean operations
		 * Next, we're creating list with below given values
		 * Stream->Filter->Sort->Collect
		 * With the help of the list, we're first streaming and then filtering it, notice that filter method takes predicate as an argument so pass our predicate reference
		 * Finally, collect the filtered values as a list with collectors.toList method 
		 *
		 */
		List<Integer> startingList=Arrays.asList(1,5,10,20,5,59,60,1);
		List<Integer> collectedList=startingList.stream().filter(predicateFun).collect(Collectors.toList());
		System.out.println(collectedList);
		
		
		
		List<Integer> collectedList2 = startingList.stream().filter(x-> x>=5 && x<60).collect(Collectors.toList());
		System.out.println(collectedList2);
		
		List<String> randomNames=Arrays.asList("Raju","Sundar","Raghul","Marnus","George","Richard","Abraham");
		Predicate<String> namesPred=x->x.startsWith("Ra");
		/*
		 * What we're doing here is, from the current list with the help of predicate which set up with a condition i.e. names starting with Ra
		 * Then as we know filter takes a predicate in which we're using method negate which will exclude every name that begins with Ra and collect the other names and provide it as list 
		 */
		List<String> collectedNames=randomNames.stream().filter(namesPred.negate()).collect(Collectors.toList());
		System.out.println(collectedNames);
	}
}
