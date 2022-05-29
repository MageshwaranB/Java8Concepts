package com.SeleniumWebDriverWithJava8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxStreams 
{
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void checkbox() {
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		List<WebElement> checkBoxLinks = driver.findElements(By.className("select-checkbox"));
		//selecting checkboxes one by one
		checkBoxLinks
					.forEach(checkbox->checkbox.click());
		
	}
	
	@AfterMethod
	public void cleanup() {
		driver.close();
	}
}
