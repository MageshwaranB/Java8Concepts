package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class StreamFilterConcept
{
	public static void main(String[] args) {
		List<String> groceryBuyList=Arrays.asList("Tomato","Onion","Brinjal","LadiesFinger","Eggs","Apple");
		System.out.println("Before applying filter: ");
		groceryBuyList.forEach(x->System.out.println(x));
		List<String> filterList = groceryBuyList.stream()
						.filter(x->!x.equalsIgnoreCase("onion"))
						.collect(Collectors.toList())
						;
		System.out.println("After filtering: ");
		filterList.forEach(x->System.out.println(x));
		
		Faker fakeData=new Faker();
		
		ArrayList<FakeClass> fakeList=new ArrayList<FakeClass>() ;
		fakeList.add(new FakeClass(fakeData.name().firstName(), fakeData.name().lastName(), fakeData.funnyName().name()));
		fakeList.add(new FakeClass(fakeData.name().firstName(), fakeData.name().lastName(), fakeData.funnyName().name()));
		fakeList.add(new FakeClass(fakeData.name().firstName(), fakeData.name().lastName(), fakeData.funnyName().name()));
		fakeList.add(new FakeClass(fakeData.name().firstName(), fakeData.name().lastName(), fakeData.funnyName().name()));
		
		fakeList.stream()
				.filter(n->n.lastName.length()>=8)
				.forEach(x->System.out.println(x.getLastName()));
		
	}
}
