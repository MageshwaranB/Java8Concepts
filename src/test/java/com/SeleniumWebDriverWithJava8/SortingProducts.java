package com.SeleniumWebDriverWithJava8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingProducts 
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
	public void sortingTheBooks() {
		driver.findElement(By.xpath("//ul[@class='top-menu']/li[1]")).click();
		Select selectDD=new Select(driver.findElement(By.id("products-orderby")));
		selectDD.selectByVisibleText("Name: Z to A");
		List<WebElement> items = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
		System.out.println("Sorted in descending list using selector: ");
		items.forEach(item->System.out.println(item.getText()));
		 Stream<String> toBeSortedList = items.stream()
		/*
		 * For each and every webelement, we need to capture the text so we're using map
		 */
				.map(x->x.getText());
				
		 System.out.println("Sorted list in ascending order using stream api");
		 toBeSortedList.sorted().collect(Collectors.toList()).forEach(System.out::println);
	}
	
	@Test
	public void sortingPrices() {
		driver.findElement(By.xpath("//ul[@class='top-menu']/li[1]")).click();
		List<WebElement> actualPrices = driver.findElements(By.className("actual-price"));
		List<Double> sortedPriceList = actualPrices.stream()
					.map(price->Double.parseDouble(price.getText()))
					.sorted()
					.collect(Collectors.toList());
		sortedPriceList.forEach(System.out::println);
	}
	
	@Test
	public void productWithPrice() {
		 Map<String, Double> prodMap=new HashMap<>();
		 List<WebElement> prodTitle = driver.findElements(By.className("product-title"));
		 List<WebElement> prodPrice = driver.findElements(By.className("actual-price"));
		 
		 								
		for(int i=0;i<prodTitle.size();i++) {
			prodMap.put(prodTitle.get(i).getText(),Double.parseDouble(prodPrice.get(i).getText()));
		}
		 /*
		  * We cannot directly add a map to a stream
		  * so by using entrySet(), we're converting it into
		  * a set and make use of stream api
		  */
		prodMap.entrySet().stream()
							.filter(price->price.getValue()>=800)
							.forEach(System.out::println);
		 
	}
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
}
