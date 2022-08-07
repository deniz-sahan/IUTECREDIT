package com.factorial.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.factorial.pages.FactorialPage;
import com.factorial.util.ReadData;

public class FactorialPageTest extends BasePageTest {

	
	@Test(dataProvider= "factoryTestData", dataProviderClass = ReadData.class)
	public void verifyFactoryFunction(String input, String expected) {
		
		
		FactorialPage factorialPage = new FactorialPage(driver);
		waitLoad(5);
		factorialPage.enterInteger(input);
		waitLoad(5);
		factorialPage.clickCalculateButton();
		waitLoad(5);
		//factorialPage.assertequals(factorialPage.getResult(), expected);
		Assert.assertEquals(factorialPage.getResult(),expected);
		
	}


}
