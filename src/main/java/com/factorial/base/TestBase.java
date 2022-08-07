package com.factorial.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase {
	
	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {
		
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else{
				driver = new EdgeDriver();
			}
		}
		catch(Exception e) {
			// reportFail(e.getMessage());
			System.out.println(e.getMessage());
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	
	public void openURL(String websiteURLKey) {
		try {
			driver.get(websiteURLKey);
			
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	
	
	public void waitLoad(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/****************** Assertion Functions ***********************/
	public void assertTrue(boolean flag) {
		softAssert.assertTrue(flag);
	}

	public void assertfalse(boolean flag) {
		softAssert.assertFalse(flag);
	}

	public void assertequals(String actual, String expected) {
		try{
			System.out.println("Assertion : Actual is -" + actual + " And Expacted is - " + expected);
			softAssert.assertEquals(actual, expected);
		}
		catch(Exception e){
			e.getMessage();
		}
		
	}
	
	
	
}
