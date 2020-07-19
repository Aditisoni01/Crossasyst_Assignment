package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class NewTest 
{
 	 WebDriver driver;
	
 	 public NewTest()
 	 {
 		 PageFactory.initElements(driver, this);
 	 }
 	 
  @BeforeClass
  public void beforeClass()
  {
	  	System.setProperty("webdriver.chrome.driver", "D:/Selenium/Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://automationpractice.com/index.php");
		 driver.manage().window().maximize();
  }

  @FindBy(linkText = "Sign in")
  WebElement link_Sign_in;
  
  @Test
  public void click_on_Sign_in() 
	{
		link_Sign_in.click();
	}
  
  
  @AfterClass
  public void afterClass() 
  {
	  driver.close();
	  
  }

}
