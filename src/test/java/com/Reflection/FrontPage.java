package com.Reflection;

import org.openqa.selenium.By;

public class FrontPage
{
	public By FirstNameText() {
		return By.id("user-name");
	}
	public By LastNameText() {
		return By.name("password");
	}
	
	public String firstTest() {
		return "Testing";
	}
	
	public By acceptedUserNames(int index) {
		return By.xpath("(//div[@class='orangehrm-login-error']/div/p)["+index+"]");
	}
}
