package com.swaglabs.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pageobjects.AddToCartPage;
import com.swaglabs.pageobjects.CheckoutPage;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;

public class CheckoutPageTest extends BaseClass {
	@Test(priority=1)
	public void checkOutInfoTest() throws InterruptedException {
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
		hp.clickCartLogo();
		logger.info("Cart Logo Btn Clicked of home Page");
		AddToCartPage ad = new AddToCartPage(driver);
		ad.clickCheckoutBtn();
		logger.info("Entered Checkout info giving page");
		CheckoutPage cp = new CheckoutPage(driver);
		cp.setFirstName();
		logger.info("Entered firstname");
		cp.setLastName();
		logger.info("Entered lastname");
		cp.setPostalCode();
		logger.info("Entered postal code");
		cp.clickContinueBtn();
		logger.info("Entered Checkout Details Page");
		Thread.sleep(2000);
		if (cp.getTotalPrice().equals("Total: $140.3")) {
			Assert.assertTrue(true);
			logger.info("Checkout info test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Checkout info test failed");
		}
	}
	
	 @Test(priority=2)
		public void cancelcheckOutInfoTest() throws InterruptedException {
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
			hp.clickCartLogo();
			logger.info("Cart Logo Btn Clicked of home Page");
			AddToCartPage ad = new AddToCartPage(driver);
			ad.clickCheckoutBtn();
			logger.info("Entered Checkout info giving page");
			CheckoutPage cp = new CheckoutPage(driver);
			cp.clickInfoCancelBtn();
			logger.info("Entered Add to cart Page");
			Thread.sleep(2000);
			if (driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/cart.html")) {
				Assert.assertTrue(true);
				logger.info("Cancel Checkout info test passed");
			} else {
				Assert.assertTrue(false);
				logger.info("Cancel Checkout info test failed");
			}
		}

	@Test(priority = 3)
	public void finishCheckOutTest() throws InterruptedException {
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
		hp.clickCartLogo();
		logger.info("Cart Logo Btn Clicked of home Page");
		AddToCartPage ad = new AddToCartPage(driver);
		ad.clickCheckoutBtn();
		logger.info("Entered Checkout info giving page");
		CheckoutPage cp = new CheckoutPage(driver);
		cp.setFirstName();
		logger.info("Entered firstname");
		cp.setLastName();
		logger.info("Entered lastname");
		cp.setPostalCode();
		logger.info("Entered postal code");
		cp.clickContinueBtn();
		logger.info("Entered Checkout Details Page");
		Thread.sleep(2000);
		cp.clickFinishBtn();
		logger.info("Entered Checkout and payment finish page");
		Thread.sleep(2000);

		if (cp.getFinishPageText().equals("THANK YOU FOR YOUR ORDER")) {
			Assert.assertTrue(true);
			logger.info("Checkout finish test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Checkout finish test failed");
		}
	}
	
	@Test(priority = 4)
	public void cancelCheckOutTest() throws InterruptedException {
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
		hp.clickCartLogo();
		logger.info("Cart Logo Btn Clicked of home Page");
		AddToCartPage ad = new AddToCartPage(driver);
		ad.clickCheckoutBtn();
		logger.info("Entered Checkout info giving page");
		CheckoutPage cp = new CheckoutPage(driver);
		cp.setFirstName();
		logger.info("Entered firstname");
		cp.setLastName();
		logger.info("Entered lastname");
		cp.setPostalCode();
		logger.info("Entered postal code");
		cp.clickContinueBtn();
		logger.info("Entered Checkout Details Page");
		Thread.sleep(2000);
		cp.clickCancelBtn();
		logger.info("Entered in home page");
		Thread.sleep(2000);
		

		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html")) {
			Assert.assertTrue(true);
			logger.info("Checkout cancel test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Checkout cancel test failed");
		}
	}
	
	@Test(priority = 5)
		public void endToEndTest() throws InterruptedException {
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
			hp.clickCartLogo();
			logger.info("Cart Logo Btn Clicked of home Page");
			AddToCartPage ad = new AddToCartPage(driver);
			ad.clickCheckoutBtn();
			logger.info("Entered Checkout info giving page");
			CheckoutPage cp = new CheckoutPage(driver);
			cp.setFirstName();
			logger.info("Entered firstname");
			cp.setLastName();
			logger.info("Entered lastname");
			cp.setPostalCode();
			logger.info("Entered postal code");
			cp.clickContinueBtn();
			logger.info("Entered Checkout Details Page");
			Thread.sleep(2000);
			cp.clickFinishBtn();
			logger.info("Entered Checkout and payment finish page");
			Thread.sleep(2000);
			hp.clickMenuBtn();
			Thread.sleep(2000);
			hp.clickLogoutBtn();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/index.html")) {
				Assert.assertTrue(true);
				logger.info("End To End test passed");
			} else {
				Assert.assertTrue(false);
				logger.info("End To End test failed");
			}

			
		}
		
		@Test(dataProvider = "checkoutinfoddt", dataProviderClass = CheckoutPage.class, priority=6)
		public void ddtCheckOutInfoTest(String firname, String lasname, String pocode) throws InterruptedException {
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
			hp.clickCartLogo();
			logger.info("Cart Logo Btn Clicked of home Page");
			AddToCartPage ad = new AddToCartPage(driver);
			ad.clickCheckoutBtn();
			logger.info("Entered Checkout info giving page");
			CheckoutPage cp = new CheckoutPage(driver);
			cp.ddtSetFirstName(firname);
			logger.info("Entered firstname");
			cp.ddtSetLastName(lasname);
			logger.info("Entered lastname");
			cp.ddtSetPostalCode(pocode);
			logger.info("Entered postal code");
			cp.clickContinueBtn();
			//logger.info("Entered Checkout Details Page");
			Thread.sleep(2000);
			if (cp.getTotalPrice().equals("Total: $140.34")) {
				Assert.assertTrue(true);
				logger.info("Checkout info test passed");
			} else {
				Assert.assertTrue(false);
				logger.info("Checkout info test failed");
			}
		}

}
