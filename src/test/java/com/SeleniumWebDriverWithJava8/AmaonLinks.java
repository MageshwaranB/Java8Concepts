package com.SeleniumWebDriverWithJava8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmaonLinks
{
	static WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		/*
		 * Below three lines suggest we're using a headless browser
		 * i.e. we won't launch the browser and do the operations
		 */
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		driver=new ChromeDriver(options);
		
	}
	
	@Test
	public void streamApiApproachWithSeleniumWebdriver() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		List<WebElement> amazonLinks = driver.findElements(By.tagName("a"));
		System.out.println(amazonLinks.size());
		
		
		//For each approach
		System.out.println("For each approach:");
		for (WebElement webElement : amazonLinks) {
			System.out.println(webElement.getText());
		}
		//Stream approach
		System.out.println("Stream api approach");
		amazonLinks.forEach(links->System.out.println(links.getText()));
		
		
		//Stream with a filter
		System.out.println("Stream with a filter");
		/*
		 * This will remove all the unnecessary blank text that we're getting from the 
		 * above approaches
		 */
		amazonLinks.stream()
					.filter(element->!element.getText().equals(""))
					.map(element->element.getText())
					.forEach(System.out::println);
		
		//Stream with a filter and getting the first value
		/*
		 * In this we'll be getting the first value considering it is not empty
		 */
		System.out.println("Stream with a filter + findfirst value");
		String firstLink = amazonLinks.stream()
					.filter(ele->!ele.getText().equals(""))
					.findFirst()
					.get()
					.getText();
		System.out.println("First non blank link's text:"+ firstLink);
		
		//Stream with findAny
		System.out.println("Stream with a filter + findAny value");
		String findAnyText = amazonLinks.stream()
					.filter(ele->!ele.getText().equals(""))
					.findAny()
					.get()
					.getText();
		System.out.println(findAnyText);
		
		//exclude the blank links and linktext that starts with amazon
		System.out.println("Stream with a filter by excluding blank linktext + starts with amazon");
		amazonLinks.stream()
					.filter(ele->!ele.getText().equals("")&&ele.getText().startsWith("Amazon"))
					.map(ele->ele.getText())
					.forEach(System.out::println);
		
		System.out.println("Another way for Stream with a filter by excluding blank linktext + starts with amazon");
		amazonLinks.stream()
					.filter(ele->!ele.getText().isEmpty())
					.filter(ele->!ele.getText().startsWith(""))
					.map(ele->ele.getText().trim())
					.forEach(System.out::println);
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
}
