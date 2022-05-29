package com.SeleniumWebDriverWithJava8;


import java.util.List;


import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks
{
	static WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void links() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("All Links: "+allLinks.size());
		allLinks.forEach(x->System.out.println(x.getText()));
		List<WebElement> nonBrokenLinks = allLinks.stream()
				.filter(x->x.getAttribute("href")!=null)
				.collect(Collectors.toList());
		System.out.println("Non broken links: "+nonBrokenLinks.size());
		List<WebElement> nonBlankLinks = nonBrokenLinks.stream()
						.filter(x->!x.getText().equals(""))
						.collect(Collectors.toList());
		System.out.println("non blank links: "+nonBlankLinks.size());
		
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
}
