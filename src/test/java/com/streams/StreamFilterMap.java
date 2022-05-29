package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterMap {
	public static void main(String[] args) {
		List<CustomerPOJO> customerList = Arrays.asList(new CustomerPOJO("Bruce Wayne", 30),
				new CustomerPOJO("Tony Stark", 41), new CustomerPOJO("Peter Parker", 23),
				new CustomerPOJO("Clark Kent", 32), new CustomerPOJO("Eddie Brock", 31));
		/*
		 * Returns a stream consisting of the results of applying the given function to
		 * the elements of this stream.
		 * 
		 * This is an intermediate operation.
		 * Whatever we're getting from the filter, will be given to map
		 * map method takes function interface as a parameter, we're providing the method operation
		 * which we wanted it to perform in this case getName(), that will return the filtered name of
		 * customer object
		 */
		System.out.println("-----Filtered Name----");
		String filteredName = customerList
				.stream()
				.filter(x -> "Bruce wayne".equalsIgnoreCase(x.getName()))
				.map(CustomerPOJO::getName).findAny().orElse(null);

		System.out.println(filteredName);
		
		System.out.println("----Non Filtered List-----");
		List<String> nonFilteredListWithNames = customerList.stream()
					.map(CustomerPOJO::getName)
					.collect(Collectors.toList());
		nonFilteredListWithNames.forEach(System.out::println);
	}
}
