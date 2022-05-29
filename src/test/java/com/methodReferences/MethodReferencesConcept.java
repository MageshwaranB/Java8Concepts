package com.methodReferences;

import java.util.ArrayList;

interface Parser{
	String parse(String str);
}

class StringParser{
	public static String convert(String s) {
		if(s.length()<=3) {
			s=s.toLowerCase();
		}
		else {
			s=s.toUpperCase();
		}
		return s;
	}
}

class MyPrinter{
	public void print(String str,Parser p) {
		str=p.parse(str);
		System.out.println(str);
	}
}

public class MethodReferencesConcept {
	public static void main(String[] args) {
		/*
		 * Method reference is used to refer method of functional interface. It is
		 * compact and easy form of lambda expression. Each time when you are using
		 * lambda expression to just referring a method, you can replace your lambda
		 * expression with method reference 
		 * 
		 * There are following types of method
		 * references in java:
		 * 
		 * 1. Reference to a static method.
		 * 	Syntax: ContainingClass::staticMethodName
		 * 2. Reference to an instance method. 
		 * 	Syntax: containingObject::instanceMethodName
		 * 3. Reference to a constructor.
		 * 	Synatax: ClassName::new  
		 */
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("java");
		list.add("c#");
		list.add("python");
		list.add("c");
		
		/*
		 * We're here using method reference for printing the list by providing 
		 * the class and methodName. This can be used to replace a lambda expression
		 */
		
		 /*
		  * This println method which we're passing belongs to the class out
		  *  which in turns belongs to System
		  *	Basically we're calling a method inside another method
		  */
		list.forEach(System.out::println);
		
		String name="Mageshwaran";
		MyPrinter printer=new MyPrinter();
		printer.print(name, (StringParser::convert));
		
	}
}
