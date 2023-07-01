package com.swaglabs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglabs.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	WebDriver ldriver;

	public AddToCartPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
	WebElement continueShoppingBtn;
	
	@FindBy(xpath = "//a[normalize-space()='CHECKOUT']")
	WebElement checkoutBtn;
	
	
	public void clickContinueShoppingBtn() throws InterruptedException {
		continueShoppingBtn.click();
		Thread.sleep(2000);
		
	}
	
	public void clickCheckoutBtn() throws InterruptedException {
		checkoutBtn.click();
		Thread.sleep(2000);
	}
	
	

}
