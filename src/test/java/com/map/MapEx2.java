package com.map;

import java.util.Arrays;
import java.util.List;

public class MapEx2 
{
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3,54,6,12,5,30);
		//multiple each numbers by 3
		numbers.stream()
				.map(number->number*3)
				.forEach(System.out::println);
	}
}
