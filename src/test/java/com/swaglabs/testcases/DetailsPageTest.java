package com.swaglabs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pageobjects.DetailsPage;

import com.swaglabs.pageobjects.LoginPage;

public class DetailsPageTest extends BaseClass {
	@Test(priority=1)
	public void addCartTestDetailsPage() throws InterruptedException {
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		logger.info("Entered in Homepage");
		
		
		DetailsPage dp = new DetailsPage(driver);
		dp.clickCartDetailsPage();
		
		
		
		Thread.sleep(2000);
		dp.clickCartLogo();
		logger.info("Entered in AddToCartPage");
		Thread.sleep(2000);
		
		if(dp.returnCartText()==6) {
			Assert.assertTrue(true);
			logger.info("Add cart in addtocartpage from detailspage test passed");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Add cart in addtocartpage from detailspage test failed");
		}
		
		
		
	}

}
