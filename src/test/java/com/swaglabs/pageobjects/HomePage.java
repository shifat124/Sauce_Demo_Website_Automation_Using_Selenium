package com.swaglabs.pageobjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.swaglabs.base.BaseClass;

public class HomePage extends BaseClass {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='inventory_container']//div//div[@id='inventory_container']//div[@class='inventory_list']//div[@class='inventory_item']")
	List<WebElement> webElements;

	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']//div[@class='inventory_item_label']//a")
	List<WebElement> webElementsLinks;

	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']//div[@class='inventory_item_label']//a//div[@class='inventory_item_name']")
	List<WebElement> webElementsTitle;
	
	@FindBy(xpath = "//div[@class='inventory_details_name']")
	WebElement detailsTitle;
	
	@FindBy(xpath = "//*[name()='path' and contains(@fill,'currentCol')]")
	WebElement cartLogo;
	
	@FindBy(xpath = "//div[@class='inventory_list']//button")
	List<WebElement> addToCartBtnHomePage;
	
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
	WebElement getCartText;
	
	@FindBy(xpath = "//button[normalize-space()='Open Menu']")
	WebElement menuBtn;
	
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
	WebElement menuAllItems;
	
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	WebElement menuAbout;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement menuLogout;
	
	

	public int countProducts() {
		int count = 0;
		for (WebElement element : webElements) {
			count++;
		}
		
		return count;

	}

	public boolean productTitle() throws InterruptedException {
		List<String> HomeTitleOfProducts = new ArrayList<String>();
		List<String> TitleOfProducts = new ArrayList<String>();
		int count=0;
		for (WebElement element : webElementsLinks) {

			HomeTitleOfProducts.add(element.getText());
		}

		for (WebElement element : webElementsLinks) {
			element.click();
			count++;
			logger.info("Item "+count+" has been clicked");
			
			logger.info("Entered in Details Page");

			
			TitleOfProducts.add(detailsTitle.getText());
			Thread.sleep(2000);
			ldriver.navigate().back();
			logger.info("Back in Home Page");
			Thread.sleep(2000);

		}
		System.out.println("HomeTitleOfProducts is : "+HomeTitleOfProducts);
		System.out.println("TitleOfProducts is : "+TitleOfProducts);
		boolean isEqual = HomeTitleOfProducts.equals(TitleOfProducts);

		return isEqual;

	}
	
	public boolean cartLogoVisible() {
		boolean visibleCartLogo=cartLogo.isDisplayed();
		
		return visibleCartLogo;
		
	}
	
	public void clickCartLogo() throws InterruptedException {
		cartLogo.click();
		Thread.sleep(2000);
		
	}
	
	public void clickAddToCartBtn() throws InterruptedException {
		int count = 0;
		
		for (WebElement element : addToCartBtnHomePage) {
			element.click();
			count++;
			logger.info("Add To Cart Button of item "+count+" has been clicked");
			Thread.sleep(2000);
			
			
			
		}
		
	}
	
	public int returnCartText() {
		return Integer.parseInt(getCartText.getText());
		
	}
	
	public void clickMenuBtn() throws InterruptedException {
		menuBtn.click();
		Thread.sleep(2000);
	}
	
	public void clickMenuAllItemsBtn() throws InterruptedException {
		menuAllItems.click();
		Thread.sleep(2000);
	}
	
	public void clickMenuAboutBtn() throws InterruptedException {
		menuAbout.click();
		Thread.sleep(2000);
	}
	
	
	public void clickLogoutBtn() throws InterruptedException {
		menuLogout.click();
		Thread.sleep(2000);
	}
	
	

}
