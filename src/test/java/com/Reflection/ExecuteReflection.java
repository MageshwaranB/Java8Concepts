package com.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class ExecuteReflection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		String methodName="firstTest";
		var page=new FrontPage();
//		var methodNames=page.getClass().getDeclaredMethods();
//		for (Method method : methodNames) {
//			System.out.println(method);
//			if(method.getName().equals(methodName)) {
//				var type=method.invoke(page);
//				System.out.println(type);
//			}
//		}
		var type=reflectUtility(page, "FirstNameText");
		var driver=new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(type).sendKeys("HEY THERE");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		var uName=reflectUtility(page, "acceptedUserNames",1);
		System.out.println(driver.findElement(uName).getText());
		Thread.sleep(5000);
		driver.quit();
	}
	
	public static <T> By reflectUtility(T methodName,String exactMethoName,Object ...args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		var methods=methodName.getClass().getDeclaredMethods();
		By type = null;
		for(Method method:methods) {
			if(method.getName().equals(exactMethoName)) {
				type= (By) method.invoke(methodName,args);
			}
		}
		return type;
	}
	
}
