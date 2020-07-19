package com.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.common.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest
{
	public WebDriver driver;
	public Properties prop;
	public static ExtentReports reports;
	public static ExtentTest tests;
	public static FileInputStream fis;
	
	public void launchapp() throws IOException 
	{	
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/com/utilities/chromedriver.exe");
		driver = new ChromeDriver();
		
		 prop = new Properties();
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/common/config.properties");
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	 	
	 	@BeforeSuite
		public void Reporting()
		{
			String file= GenericMethods.getFileName();
			reports=new ExtentReports(System.getProperty("user.dir")+"/src/test/java/com/AP_Reports/AP_Report_"+file+".html");	
		}
		
		@AfterTest
		public void flushReport()
		{
			reports.endTest(tests);
			reports.flush();
		}

	}
