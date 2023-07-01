package com.swaglabs.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");

		} else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}

	@Test(dataProvider = "loginData", dataProviderClass = LoginPage.class, priority = 2)
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		Thread.sleep(1000);
		logger.info("user name provided");
		lp.setPassword(pwd);
		Thread.sleep(1000);
		logger.info("password provided");
		lp.clickSubmit();

		Thread.sleep(1000);

		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");

		} else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}

}
