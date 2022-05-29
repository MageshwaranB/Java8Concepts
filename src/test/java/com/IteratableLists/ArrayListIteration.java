package com.IteratableLists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIteration 
{
	public static void main(String[] args) {
		ArrayList<String> tvList=new ArrayList<String>();
		tvList.add("Dragonball");
		tvList.add("Naruto");
		tvList.add("KNY");
		tvList.add("Berserk");
		
		//1. Using forEach method which takes consumer as an argument
		System.out.println("-----Printing using forEach method------");
		tvList.forEach(anime->System.out.println(anime));
		
		//2. Using iterator method
		System.out.println("---------Printing using iterator-------");
		Iterator<String> iterate = tvList.iterator();
		while (iterate.hasNext()) {
			String shows = iterate.next();
			System.out.println(shows);
		}
		
		
		//3. Using forEachRemaining Method
		System.out.println("---------Printing using forEachRemaining method-------");
		iterate=tvList.iterator();
		while (iterate.hasNext()) {
			iterate.forEachRemaining(x->System.out.println(x));
		}
		
		//4. For each loop
		System.out.println("---------Printing using forEach loop-------");
		for (String shows : tvList) {
			System.out.println(shows);
		}
		
		//5. Simple For loop
		System.out.println("---------Printing using for loop-------");
		for (int i = 0; i < tvList.size(); i++) {
			System.out.println(tvList.get(i));
		}
		
		//6. Using listIterator() to traverse in both direction
		System.out.println("---------Printing using listIterator method in reverse direction------");
		ListIterator<String> listIterate = tvList.listIterator(tvList.size());
		while (listIterate.hasPrevious()) {
			String string = (String) listIterate.previous();
			System.out.println(string);
			
		}
		
		//7. For Each with method reference
		System.out.println("---------Printing using For Each with method reference------");
		tvList.forEach(System.out::println);
	}
}
