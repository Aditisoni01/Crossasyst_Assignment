package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninLinkPage 
{
	public WebDriver driver;
	
	public SigninLinkPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement link_Sign_in;
	
	public void click_Sign_in(String title)
	{
		if(driver.getTitle().equals(title))
		{
			link_Sign_in.click();
		}
	}	
}
