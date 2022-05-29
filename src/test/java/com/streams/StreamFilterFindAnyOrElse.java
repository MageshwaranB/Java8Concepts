package com.streams;

import java.util.Arrays;
import java.util.List;

public class StreamFilterFindAnyOrElse 
{
	public static void main(String[] args) {
		List<CustomerPOJO> customerList=Arrays.asList( 
					new CustomerPOJO("Bruce Wayne", 30),
					new CustomerPOJO("Tony Stark", 41),
					new CustomerPOJO("Peter Parker", 23),
					new CustomerPOJO("Clark Kent", 32),
					new CustomerPOJO("Eddie Brock", 31)
				);
	/*
	 * First we have created a list which takes customerPojo class as the generics
	 * and we have populated the list with name and age
	 */
	
	/*
	 * 1. Converting the list into a stream
	 * 2. Then we're filtering out the list whose name is equals to tony stark. 
	 * Here X represents the customer class object.
	 * 3. If the value we've entered to be filtered out existed, we'll get back the value, if not, or else
	 * method will be executed in which we've created an object of customer with values not found as name
	 * and 0 as age will be returned. 	
	 */
		CustomerPOJO filteredResult = customerList.stream()
					.filter(x->"Tony stark".equalsIgnoreCase(x.getName()))//
					.findAny()
					.orElse(new CustomerPOJO("Not Found", 0));
		System.out.println(filteredResult.getName()+" is "+filteredResult.getAge());
		
		//Filter with multiple conditions
		CustomerPOJO results = customerList.stream()
					.filter((x->"Eddie Brock".equalsIgnoreCase(x.getName())&& 31==x.getAge()))
					.findAny()
					.orElse(null);
		System.out.println(results.getName());
	}
}
