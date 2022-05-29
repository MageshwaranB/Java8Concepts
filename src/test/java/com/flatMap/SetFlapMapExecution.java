package com.flatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SetFlapMapExecution 
{
	public static void main(String[] args) {
		Employee emp1=new Employee();
		emp1.addDevices("One Plus 5");
		emp1.addDevices("Google Pixels");
		emp1.addDevices("Redmi 9A");
		
		Employee emp2=new Employee();
		emp2.addDevices("iPhone 10");
		emp2.addDevices("Moto");
		emp2.addDevices("One Plus Nord");
		emp2.addDevices("Redmi 9A");
		
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		
		/*
		 * Code for getting distinct devices from both employee class
		 * 1. First, we're streaming the list
		 * 2. We're mapping the employee to get the devices 
		 * 3. Remember, inside the flat map, we need to convert everything to a stream.
		 *    we're converting the Stream<Set<String> to Stream<String>, so that we can perform other operations
		 * 4. Using distinct, we'll get the unique items
		 * 5. Finally we're collecting them as a list
		 */
		
		List<String> distinctDevices = employeeList.stream()
					.map(x->x.getEmpDevices())
					.flatMap(x->x.stream())
					.distinct()
					.collect(Collectors.toList());
		distinctDevices.forEach(x->System.out.println(x));
	}
}
