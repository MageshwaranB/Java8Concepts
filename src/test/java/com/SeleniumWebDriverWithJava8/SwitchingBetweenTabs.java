package com.SeleniumWebDriverWithJava8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingBetweenTabs
{
	static WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void handlingWindows() {
		driver.get("https://www.flipkart.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.in/");
		driver.getWindowHandles()
		.stream()
		/*
		 * Below for each method will get the current url after switching to each tab
		 */
		.forEach(winId->System.out.println("Current Url: "+driver.switchTo().window(winId).getCurrentUrl()));
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
}
