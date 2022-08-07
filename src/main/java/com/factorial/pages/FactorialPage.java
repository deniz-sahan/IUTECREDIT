package com.factorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.factorial.base.BasePage;

public class FactorialPage extends BasePage{

	public FactorialPage(WebDriver driver) {
		super(driver);
		
	}

	//@FindBy(id ="number")
	//public WebElement integer_TextBox;
	
	
	public WebElement integer_TextBox = find(By.id("number"));


	WebElement calculateButton = find(By.xpath("//*[@type=\"submit\"]"));
	
	//@FindBy(xpath = "//*[@id=\"resultDiv\"]")
	//public WebElement result;
	
	WebElement result = find(By.id("resultDiv"));
	
	
	public void enterInteger(String input) {
		integer_TextBox.clear();
		integer_TextBox.sendKeys(input);
	}
	
	
	public void clickCalculateButton(){
		calculateButton.click();
	}
	
	public String getResult() {
		
		String[] actualResult = result.getText().split(":");
		
		return actualResult[1];
	}
	

}
