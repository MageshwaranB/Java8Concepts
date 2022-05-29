package com.map;

import java.util.ArrayList;
import java.util.List;

class Employee{
	public int empId;
	public String empName,designation;
	public Employee(int empId, String empName, String designation) {
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
	}
	
	
}

public class MapEx3 
{
	public static void main(String[] args) {
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee(100, "John Snow", "King of the north"));
		empList.add(new Employee(101, "The Batman", "The cape crusader"));
		empList.add(new Employee(102,"Naruto Uzumaki", "Hokage"));
		empList.add(new Employee(104, "John Doe", "Nameless corpse"));
		
		empList.stream()
				.filter(emp->emp.designation.toLowerCase().contains("the"))
				.map(emp->emp.empName)
				.forEach(System.out::println);;
	}
}
