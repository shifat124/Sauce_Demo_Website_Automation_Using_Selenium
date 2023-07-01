package com.swaglabs.testcases;

import org.testng.annotations.Test;


import org.testng.Assert;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	

	@Test(priority=1)
	public void countProductTest() throws InterruptedException {
		
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
		int numberOfProducts = hp.countProducts();
		if (numberOfProducts == 6) {
			Assert.assertTrue(true);
			logger.info("Count product test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Count Product test failed");
		}

	}
	@Test(priority=2)
	public void productTitleTest() throws InterruptedException {
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
		
		if (hp.productTitle() == true) {
			Assert.assertTrue(true);
			logger.info("Product title test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Product title test failed");
		}

	}
	
	@Test(priority=3)
	public void cartLogoVisibilityTest() throws InterruptedException {
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
		if(hp.cartLogoVisible()==true) {
			Assert.assertTrue(true);
			logger.info("Cart Logo Visibility test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Cart Logo Visibility test failed");
		}
			
		}
	@Test(priority=4)
	public void clickCartLogoTest() throws InterruptedException {
		
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
		
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/cart.html")) {
			Assert.assertTrue(true);
			logger.info("Click Cart Logo test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Click Cart Logo test failed");
		}
		
	}
	@Test(priority=5)
	public void getCartTextTest() throws InterruptedException {
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
		hp.clickAddToCartBtn();
		
		if(hp.returnCartText()==6) {
			Assert.assertTrue(true);
			logger.info("Add cart in addtocartpage from homepage test passed");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Add cart in addtocartpage from homepage test failed");
		}
	}
	@Test(priority=6)
	public void menuAllItemsBtnTest() throws InterruptedException {
		
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
		hp.clickMenuBtn();
		logger.info("Menu Button Clicked");
		hp.clickMenuAllItemsBtn();
		logger.info("All Items Link Clicked");
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html")) {
			Assert.assertTrue(true);
			logger.info("Click All Items Link of Menu Btn test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Click All Items Link of Menu Btn test failed");
		}
		
		
	}
	
	@Test(priority=7)
	public void menuAboutBtnTest() throws InterruptedException {
		
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
		hp.clickMenuBtn();
		hp.clickMenuAboutBtn();
		
		
		if(driver.getTitle().equals("Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing")) {
			Assert.assertTrue(true);
			logger.info("Click About Link of Menu Btn test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Click About Link of Menu Btn test failed");
		}
		
		
	}
	
	@Test(priority=8)
	public void menuLogoutBtnTest() throws InterruptedException {
		
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
		hp.clickMenuBtn();
		hp.clickLogoutBtn();
		
		
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/index.html")) {
			Assert.assertTrue(true);
			logger.info("Click Logout Link of Menu Btn test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Click Logout Link of Menu Btn test failed");
		}
		
		
	}
	
	
		
		
}
