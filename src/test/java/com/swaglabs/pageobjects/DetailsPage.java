package com.swaglabs.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglabs.base.BaseClass;

public class DetailsPage extends BaseClass {
	
	WebDriver ldriver;

	public DetailsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']//div[@class='inventory_item_label']//a")
	List<WebElement> webElementsLinks;
	
	
	@FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
	WebElement addToCartBtnDetailsPage;
	
	@FindBy(xpath = "//button[normalize-space()='<- Back']")
	WebElement backBtnDetailsPage;
	
	@FindBy(xpath = "//*[name()='path' and contains(@fill,'currentCol')]")
	WebElement cartLogo;
	
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
	WebElement getCartText;
	
	
	
	public void clickCartDetailsPage() throws InterruptedException {
		int count=0;
		for (WebElement element : webElementsLinks) {
			element.click();
			count++;
			logger.info("Item "+count+" has been clicked");
			logger.info("Entered in Details Page");
			addToCartBtnDetailsPage.click();
			Thread.sleep(2000);
			backBtnDetailsPage.click();
			logger.info("Entered in Home Page");
			Thread.sleep(2000);
		}
	}
	
	public void clickCartLogo() throws InterruptedException {
		cartLogo.click();
		Thread.sleep(2000);
		
	}
	
	public int returnCartText() {
		return Integer.parseInt(getCartText.getText());
		
	}

}
