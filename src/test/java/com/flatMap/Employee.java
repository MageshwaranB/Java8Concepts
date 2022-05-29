package com.flatMap;

import java.util.HashSet;
import java.util.Set;

public class Employee 
{
	private String empName;
	private Set<String> empDevices;
	
	public void addDevices(String deviceName) {
		if(this.empDevices==null) {
			this.empDevices=new HashSet<>();
		}
		this.empDevices.add(deviceName);
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Set<String> getEmpDevices() {
		return empDevices;
	}
	public void setEmpDevices(Set<String> empDevices) {
		this.empDevices = empDevices;
	}
	
	
}
