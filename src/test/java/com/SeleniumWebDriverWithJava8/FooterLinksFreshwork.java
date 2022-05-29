package com.SeleniumWebDriverWithJava8;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinksFreshwork {
static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void footer() {
		driver.get("https://www.freshworks.com/");
		List<WebElement> footerLinks = driver.findElements(By.xpath("//ul[@class='footer-nav']"));
		
		footerLinks
					.forEach(footer->System.out.println(footer.getText()));
		List<String> newFooter=new ArrayList<String>();
		footerLinks.stream()
					.forEach(ele->newFooter.add(ele.getText()));
		newFooter.forEach(x->System.out.println(x));
	}
	
	@AfterMethod
	public void cleanup() {
		driver.close();
	}

}
