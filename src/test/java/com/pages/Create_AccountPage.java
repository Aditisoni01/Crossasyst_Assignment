package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Create_AccountPage 
{
public WebDriver driver;
	
	public Create_AccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='id_gender1']")
	List <WebElement> radio_Title;
	
	@FindBy(xpath = "//label[@for='customer_firstname']//following::input[1]")
	WebElement txt_First_Name;
	
	@FindBy(xpath = "//label[@for='customer_lastname']//following::input[1]")
	WebElement txt_lastName;
	
	@FindBy(xpath="//label[@for='passwd']//following ::input[1]")
	WebElement txt_password;
	
	@FindBy(xpath = "//select[@id='days']")
	WebElement dropDown_days;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement dropDown_months;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement dropDown_years;
	
	@FindBy(xpath="//input[@id='newsletter'][@name='newsletter']")
	WebElement checkbox_Newsletter;
	
	@FindBy(xpath="//input[@id='optin'][@name='optin']")
	WebElement checkbox_Special_Offer;
	
	@FindBy(xpath="//input[@id='firstname'][@name='firstname']")
	WebElement Address_firstName;
	
	@FindBy(xpath="//input[@id='lastname'][@name='lastname']")
	WebElement Address_lastname;
	
	@FindBy(xpath="//label[contains(text(),'Company')]//following::input[1]")
	WebElement txt_company;
	
	@FindBy(xpath="//input[@id='address1' and @name='address1']")
	WebElement txt_address1;
	
	@FindBy(xpath="//input[@id='address2' and @name='address2']")
	WebElement txt_address2;
	
	@FindBy(xpath="//label[(contains(text(),'City'))]//following::input[1]")
	WebElement txt_city;
	
	@FindBy(id="id_state")
	WebElement dropdown_State;
	
	@FindBy(xpath="//label[text()='Zip/Postal Code ']//following::input[1]")
	WebElement txt_zipCode;

	@FindBy(xpath="//select[@id='id_country']")
	WebElement dropdown_Country;
	
	@FindBy(id="phone_mobile")
	WebElement txt_MobileNumber;
	
	@FindBy(id="alias")
	WebElement txt_aliasName;
	
	@FindBy(id="submitAccount")
	WebElement btn_Register;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement link_Sign_out;
	
	@FindBy(xpath="//h1[text()='My account']")
	WebElement heading_MyAccount;
	
	public void click_Radio_Title()
	{
			radio_Title.get(0).click();
	}
	
	public void fill_First_Name (String firstName)
	{
		txt_First_Name.sendKeys("hello");
		txt_First_Name.clear();
		txt_First_Name.sendKeys(firstName);
	}
	
	public void fill_Last_Name(String lastName)
	{
		txt_lastName.sendKeys("hello");
		txt_lastName.clear();
		txt_lastName.sendKeys(lastName);
	}
	
	public void  fill_password(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void  select_days(int day)
	{
		new Select(dropDown_days).selectByIndex(day);
	}
	
	public void  select_months(int month)
	{
		new Select(dropDown_months).selectByIndex(month);
	}
	
	public void  select_years(int year)
	{
		new Select(dropDown_years).selectByIndex(year);
	}
	
	public void check_NewsLetter()
	{
		if(checkbox_Newsletter.isEnabled())
			checkbox_Newsletter.click();
	}
	
	public void check_SpecialOffer()
	{
		if(checkbox_Special_Offer.isEnabled())
			checkbox_Special_Offer.click();
	}
	
	public boolean fill_Address_FirstName(String add_FirstName)
	{
		if(add_FirstName.equals(Address_firstName.getAttribute("value")))
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean fill_Address_LastName(String add_LastName)
	{
		if(add_LastName.equals(Address_firstName.getAttribute("value")))
		{
			return true;
		}
		else
			return false;
	}
	
	public void fill_Company(String Company)
	{
		txt_company.clear();
		txt_company.sendKeys(Company);
	}
	
	public void fill_Address1(String AddressLine_1)
	{
		txt_address1.clear();
		txt_address1.sendKeys(AddressLine_1);
	}
	
	public void fill_Address2(String AddressLine_2)
	{
		txt_address2.clear();
		txt_address2.sendKeys(AddressLine_2);
	}
	
	public void fill_City(String city)
	{
		txt_city.clear();
		txt_city.sendKeys(city);
	}
	
	public void  select_State(int state)
	{
		new Select(dropdown_State).selectByIndex(state);
	}
	
	public void fill_zipcode(String zipcode)
	{
		txt_zipCode.sendKeys(zipcode);
	}
	
	public void  select_Country(String value)
	{
		new Select(dropdown_Country).selectByValue(value);
	}
	
	public void fill_MobilePhone(String contactNumber)
	{
		txt_MobileNumber.clear();
		txt_MobileNumber.sendKeys(contactNumber);
	}
	
	public void fill_AliasName(String AliasName)
	{
		txt_aliasName.clear();
		txt_aliasName.sendKeys(AliasName);
	}
	
	public void click_Button_Register()
	{
		btn_Register.click();
	}
	
	public void landing_MyAccountPage()
	{
		if((heading_MyAccount.isDisplayed()) && (link_Sign_out.isDisplayed()))
			link_Sign_out.click();
	}
}
 