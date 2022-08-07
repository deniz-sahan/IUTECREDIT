package com.factorial.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.factorial.base.TestBase;


public class BasePageTest extends TestBase {



	@BeforeMethod
	public void setUp() {
		invokeBrowser("chrome");
		waitLoad(5);
		openURL("https://qainterview.pythonanywhere.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
