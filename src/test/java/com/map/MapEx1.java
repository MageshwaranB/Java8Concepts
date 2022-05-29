package com.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapEx1 
{
	public static void main(String[] args) {
		/*
		 * Map will transform the object and it will perform certain operation
		 * on each and every element before storing the result in the target
		 */
		List<String> vehicles = Arrays.asList("Bus","Train","Truck","Airplane","Car");
		//convert all the names into uppercase and store it
		//Before java 1.8 approach
		List<String> convList=new ArrayList<String>();
		for (String string : convList) {
			convList.add(string.toUpperCase());
		}
		System.out.println(convList);
		
		//java 1.8 approach
		List<String> convertedList = vehicles.stream()
				.map(vehicle->vehicle.toUpperCase())
				.collect(Collectors.toList());
		convertedList.forEach(System.out::println);
		
		//Getting the length of the strings
		//before java 1.8 approach
		
		List<Integer> convLength=new ArrayList<>();
		for (String string : convertedList) {
			convLength.add(string.length());
		}
		System.out.println(convLength);
		
		//Java 1.8 approach
		convLength=vehicles.stream()
				.map(vehicle->vehicle.length())
				.collect(Collectors.toList());
		convLength.forEach(System.out::println);
	}
}
