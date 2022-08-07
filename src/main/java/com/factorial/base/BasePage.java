package com.factorial.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factorial.pages.FactorialPage;


public class BasePage  extends TestBase{

	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement find(By locator){
	     return driver.findElement(locator);
	}

	public List<WebElement> findAll(By locator){
	     return driver.findElements(locator);
	}

	public void click(By locator){
	     find(locator).click();
	}

	public void type(By locator , String text){
	     find(locator).sendKeys(text);
	}
	

}
