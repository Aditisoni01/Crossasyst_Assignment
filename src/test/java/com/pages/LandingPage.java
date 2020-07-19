package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage 
{
public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Create an account')]")
	WebElement text_account;
	
	@FindBy(xpath="//h3[text()='Already registered?']")
	WebElement text_Login;
	
	@FindBy(xpath="//input[@id='email_create'][@name='email_create']")
	WebElement input_email;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement btn_accountCreate;
	
	@FindBy(xpath="//input[@data-validate='isEmail' and @id='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@data-validate='isPasswd' and @id='passwd']")
	WebElement txt_Password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement button_SignIn;
	
	public boolean check_Landing_Page(String value_1 , String value_2 )
	{
		if(text_account.equals(value_1) && (text_Login.equals(value_2)))
		{
			return true;
		}
		return false;
	}
	
	public void click_Create_account(String email)
	{
		input_email.sendKeys(email);
		btn_accountCreate.click();
	}	
	
	public void Login(String email, String password)
	{
		txt_email.sendKeys(email);
		txt_Password.sendKeys(password);
		button_SignIn.click();
	}
}
