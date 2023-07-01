package com.swaglabs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pageobjects.AddToCartPage;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;

public class AddToCartPageTest extends BaseClass {
	@Test(priority=1)
	public void clickContinueShoppingBtnTest() throws InterruptedException {
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		logger.info("Entered in Homepage");
		HomePage hp = new HomePage(driver);
		hp.clickCartLogo();
		AddToCartPage at = new AddToCartPage(driver);
		at.clickContinueShoppingBtn();
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html")) {
			Assert.assertTrue(true);
			logger.info("Click continue shopping button test passed");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Click continue shopping button test failed");
		}
	}
	
	
	@Test(priority=2)
	public void clickCheckoutBtnTest() throws InterruptedException {
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		logger.info("Entered in Homepage");
		HomePage hp = new HomePage(driver);
		hp.clickCartLogo();
		AddToCartPage at = new AddToCartPage(driver);
		at.clickCheckoutBtn();
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/checkout-step-one.html")) {
			Assert.assertTrue(true);
			logger.info("Click checkout button test passed");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Click checkout button test failed");
		}
	}
	
	

}
