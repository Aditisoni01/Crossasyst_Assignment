package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage 
{
	public WebDriver driver;
	public static String Amount_value;
	public static String OrderReference;
	
	public PlaceOrderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Summary 
	
	@FindBy(xpath="//span[@id='product_price_4_16_346858']")
	WebElement txt_UnitPrice;
	
	@FindBy(xpath="//input[@class='cart_quantity_input form-control grey']")
	WebElement txt_Qty;
	
	@FindBy(xpath="//span[@id='total_product_price_4_16_346858']")
	WebElement txt_Total;
	
	@FindBy(xpath="//td[@id='total_product']")
	WebElement txt_Total_Products;
	
	@FindBy(xpath="//td[@id='total_shipping']")
	WebElement txt_TotalShipping;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement txt_TotalCost;
	
	// End Summary 
	
	
	// payment 
	//Total products , Total Shipping , TxtTotal ,unit Price ---------> same
	
	@FindBy(xpath="//td[@id='total_price_container']")
	WebElement Ptxt_TotalCost;
	
	//I Confirm my Order Page
	
	@FindBy(xpath="//span[@class='price']")
	WebElement TotalAmount;
	
	@FindBy(xpath="//*[@id=\"center_column\"]//following-sibling::text()[6]")
	List<WebElement > order_refernce;
	
	@FindBy(linkText="Back to orders")
	WebElement orderHistoryPage;
		
	//*****************************************************************************************************
	@FindBy(xpath="button btn btn-default standard-checkout button-medium")
	WebElement link_ProceedtoCheckout;
	
	@FindBy(xpath="//input[@id='addressesAreEquals']")
	WebElement checkBox_DA_BA;
	
	@FindBy(name="processAddress")
	WebElement btn_ProceedtoCheckout;
	
	@FindBy(id="cgv")
	WebElement chkbox_termsOfServices;
	
	@FindBy(name="processCarrier")
	WebElement btn_ProcessCarrier;
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement link_PayByBankWire;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement link_PayByCheck;
	
	@FindBy(xpath="//h3[contains(text(),'Bank-wire payment')]")
	WebElement BankWirePaymentPage;
	
	@FindBy(xpath="//h3[contains(text(),'Check payment')]")
	WebElement CheckPaymentPage;
	
	@FindBy(xpath="//*[text()='I confirm my order']")
	WebElement btn_confirmOrder;
	
	public void click_Summary()
	{
		if(LoginPage.quantity.equals(txt_Qty.getText()) && (LoginPage.costofdress.equals(txt_UnitPrice.getText())) 
				&& (LoginPage.totalcost.equals(txt_Total.getText())) && (LoginPage.shippingcost.equals(txt_TotalShipping.getText()))
				&&(LoginPage.totalcost_withshipping.equals(txt_TotalCost.getText())) ) 
		link_ProceedtoCheckout.click();
	}
	
	public void click_Address()
	{
		if(checkBox_DA_BA.isSelected())
			btn_ProceedtoCheckout.click();
	}
	
	public void click_Shipping()
	{
		chkbox_termsOfServices.click();
		btn_ProcessCarrier.click();
	}
	
	public void click_Payment(String paymentMethod)
	{
		if(LoginPage.quantity.equals(txt_Qty.getText()) && (LoginPage.costofdress.equals(txt_UnitPrice.getText())) 
				&& (LoginPage.totalcost.equals(txt_Total.getText())) && (LoginPage.shippingcost.equals(txt_TotalShipping.getText()))
				&&(LoginPage.totalcost_withshipping.equals(Ptxt_TotalCost.getText())) ) 
		{	
					if(paymentMethod.equals("Bank Wire"))
					{
						link_PayByBankWire.click();
						btn_confirmOrder.click();
						Amount_value = TotalAmount.getText();
						OrderReference = order_refernce.get(5).getText().substring(46, 56).trim();
						orderHistoryPage.click();
					}
					else if(paymentMethod.equals("Check"))
					{
						link_PayByCheck.click();
						btn_confirmOrder.click();
						Amount_value = TotalAmount.getText();
						OrderReference = order_refernce.get(5).getText().substring(46, 56).trim();
						orderHistoryPage.click();
					}
					}
		}			
	}
	
