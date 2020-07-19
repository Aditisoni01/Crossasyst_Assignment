package com.pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
public WebDriver driver;
public Actions act; 
public static String quantity;
public static String costofdress;
public static String totalcost;
public static String shippingcost;
public static String totalcost_withshipping;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(this.driver);
	}
	
	@FindBy(xpath="//a[@title='Women']")
	List <WebElement> link_WomenSection;
	
	@FindBy(xpath="//a[@title='Dresses']")
	List <WebElement> link_Dresses;
	
	@FindBy(xpath="//a[@title='T-shirts']")
	List <WebElement> link_Tshirt;
	
	@FindBy(linkText = "Blouses")
	WebElement link_Bouses;
	
	@FindBy(linkText = "Casual Dresses")
	List<WebElement> link_CasualDresses;
	
	@FindBy(xpath="//a[@href='http://automationpractice.com/index.php?id_category=10&controller=category'][@title='Evening Dresses']")
	List <WebElement> link_EveningDresses;
	
	@FindBy(linkText = "Summer Dresses")
	List <WebElement> link_SummerDresses;
	
	@FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?id_product=4&controller=product']")
	WebElement link_selectDress_QuickView;
	
	@FindBy(xpath= "//iframe[@class='fancybox-iframe']")
	WebElement frame_id;
	
	@FindBy(id="quantity_wanted")
	WebElement quantity_Status;
	
	@FindBy(xpath="//a[@class='btn btn-default button-plus product_quantity_up']")
	WebElement btn_plus_quantity;
	
	@FindBy(xpath="//span[@id='our_price_display']")
	WebElement txt_ItemPrice;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement btn_AddToCart;
	
	@FindBy(xpath="//a[@href='http://automationpractice.com/index.php?controller=order']")
	WebElement link_ProceedToCheckout;
	// and  @title='Proceed to checkout']
	
	@FindBy(xpath="//span[@id='layer_cart_product_price']")
	WebElement txt_CurrentItemPrice;
	
	@FindBy(xpath="//span[@id='layer_cart_product_quantity']")
	WebElement CurrentDress_Quantity;
	
	@FindBy(xpath="//h2[normalize-space(text()='Product successfully added to your shopping cart')]")
	WebElement txt_ProductAddedNotification;
	
	@FindBy(xpath="//span[@class='ajax_block_products_total']")
	WebElement txt_cartItemPrice;
	                                        
	@FindBy(xpath="//span[@class='ajax_cart_shipping_cost']")
	WebElement txt_ShippingCost;
	
	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	WebElement txt_totalcostINCshipping;
	
	@FindBy(xpath="//div[@id='layer_cart']")
	WebElement frame_2;
//	@FindBy(xpath="//a[contains(text(),'T-shirts')]")
//	List <WebElement> link_T_Shirts;
	
	public void hover_dressSection(String dressSection) throws InterruptedException
	{
		if(dressSection.equals("WOMEN"))
		{	
			act.moveToElement(link_WomenSection.get(1)).build().perform();
			link_CasualDresses.get(1).click();
		}
		else if(dressSection.equals("DRESSES"))
		{
			act.moveToElement(link_Dresses.get(1)).build().perform();
			link_EveningDresses.get(1).click();
			link_selectDress_QuickView.click();
			 switch_control();
		}
		else if(dressSection.equals("T-SHIRTS"))
		{
			link_Tshirt.get(0).click();
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void switch_control() throws InterruptedException
	{
		driver.switchTo().frame(frame_id);
		
	/*	
		int price = Integer.parseInt(txt_ItemPrice.getText().replaceAll("$", ""));
		price =price * 2;
		System.out.println(price);
	*/
		costofdress = txt_ItemPrice.getText();
		System.out.println(costofdress);
		btn_plus_quantity.click();
		quantity = quantity_Status.getAttribute("value");
		System.out.println(quantity);
		if(quantity.equals("2"))
		{
			btn_AddToCart.click();
		}
//			String currentWindowHandle = driver.getWindowHandle();
//			driver.switchTo().window(currentWindowHandle);
			if((txt_ProductAddedNotification.isDisplayed()) && (CurrentDress_Quantity.equals(quantity)) && (txt_cartItemPrice.equals(txt_CurrentItemPrice)) )
			{
				link_ProceedToCheckout.click();
			}
		
		totalcost = txt_cartItemPrice.getText();
		shippingcost = txt_ShippingCost.getText();
		totalcost_withshipping = txt_totalcostINCshipping.getText();
		
	}
	
	//public void .
	
//	public void sub_WomenSection()
//	{
//		
//		String womenSubSection = 
//	}

}
