package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//constructor
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	//FInding ELement
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEMail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	@CacheLookup
	WebElement loginbutton;
	
	
	
	//Action
	public void SetEMail(String emailname)
	{
	txtEMail.clear();
	txtEMail.sendKeys(emailname);
	
	}
	
	public void SetEPassword(String Password)
	{
	txtpassword.clear();
	txtpassword.sendKeys(Password);
	}
	
	public void clicklogin()
	{
		loginbutton.click();
}
}