package com.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.Create_AccountPage;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.pages.PlaceOrderPage;
import com.pages.SigninLinkPage;
import com.relevantcodes.extentreports.LogStatus;

public class AllTests extends BaseTest
{	
	public Properties prop;
	
	@BeforeClass
	public void Setup() throws IOException
	{	

			launchapp();

	}

	@Test
	public void flowOfTestScripts() throws InterruptedException
	{
		tests = reports.startTest("Starting the flow of executing Automation Practice web application");
		SigninLinkPage sn = new SigninLinkPage(driver);
		sn.click_Sign_in("My Store");
		tests.log(LogStatus.PASS, "Navigated to Home page and verifying title of Home page(correctly Landing to home page) and clicking to Sign in Page");
		LandingPage lp = new LandingPage(driver);
		boolean authpage = lp.check_Landing_Page("Create an account" , "Already registered?");	
		if(authpage)
		tests.log(LogStatus.PASS, "Correctly Clicked to sign in link");
		LandingPage lp1 = new LandingPage(driver);
		lp.click_Create_account(prop.getProperty("New email"));
		tests.log(LogStatus.PASS, "Creating account with email id");
		Create_AccountPage cp = new Create_AccountPage(driver);
		cp.click_Radio_Title();
		cp.fill_First_Name("aditi");	
		cp.fill_Last_Name("soni");
		cp.fill_password("@diti234");
		cp.select_days(1);
		cp.select_months(9);
		cp.select_years(9);
		cp.check_NewsLetter();
		cp.check_SpecialOffer();
		cp.fill_Company("XYZ");
		cp.fill_Address1("hinjewadi , phase 1");
		cp.fill_Address2("Pune");
		cp.select_Country("21");
		cp.select_State(4);
		cp.fill_City("california");
		cp.fill_zipcode("90201");
		cp.fill_MobilePhone("7974852107");
		cp.fill_AliasName("My_Home");
		cp.click_Button_Register();
		Thread.sleep(3000);
		cp.landing_MyAccountPage();
		tests.log(LogStatus.PASS, "New user account has been created successfully");
	}

	
		@Test
		public void flowcheckfromLogin() throws InterruptedException
		{
			tests = reports.startTest("Starting the flow of executing Automation Practice web application");
			SigninLinkPage sn = new SigninLinkPage(driver);
			sn.click_Sign_in("My Store");
			tests.log(LogStatus.PASS, "Navigated to Home page and verifying title of Home page(correctly Landing to home page) and clicking to Sign in Page");
			LandingPage lp = new LandingPage(driver);
			boolean authpage = lp.check_Landing_Page("Create an account" , "Already registered?");	
			if(authpage)
			tests.log(LogStatus.PASS, "Correctly Clicked to sign in link");
		LandingPage lp2 = new LandingPage(driver);
		lp2.Login(prop.getProperty("email") , prop.getProperty("password"));
		Thread.sleep(3000);
		tests.log(LogStatus.PASS, "Login with this email and password");
		LoginPage Lp2 = new LoginPage(driver);
		Lp2.hover_dressSection(prop.getProperty("WomenSubSection"));
		tests.log(LogStatus.PASS, "After login clicking to DRESSES section and selecting Evening Dresses and adding to cart");
		PlaceOrderPage pp = new PlaceOrderPage(driver);
		tests.log(LogStatus.PASS, "Order Proceed to check out");
		pp.click_Summary();
		tests.log(LogStatus.PASS, "Order Summary Section Total amount calculated");
		pp.click_Address();
		tests.log(LogStatus.PASS, "Order Address Details Selected");
		pp.click_Shipping();
		tests.log(LogStatus.PASS, "Order Shipping Charges calculated");
		pp.click_Payment(prop.getProperty("paymentMethod"));
		tests.log(LogStatus.PASS, "Order Payment Method selected (before verifying the total amount and shipping amount)and ORDER Placed");
		
	}

}
