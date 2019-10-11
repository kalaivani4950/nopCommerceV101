package com.nopcommerce.testCases;

// This is my login test...
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;


public class TC_LoginTest_001 extends BaseClass {

	
		
	@Test
	public void loginTest() throws IOException
	{
		logger.info("*******Starting TC_LoginTest_001");
		driver.get(configPropObj.getProperty("baseURL"));     //URL
		
		LoginPage lp=new LoginPage(driver); 
		//object creation 
		logger.info("*******Providing Login details");
		lp.SetEMail(configPropObj.getProperty("Username"));
		lp.SetEPassword(configPropObj.getProperty("Password"));
		
		lp.clicklogin();
		logger.info("*******Verifying Login details");
		String exp_title="Dashboard / nopCommerce administration";
		String Act_title=driver.getTitle();
		
		if (exp_title.equals(Act_title))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("*******fail Login details");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
		}
		logger.info("*******ENding TC_Login _001 details");
	}
	
}
