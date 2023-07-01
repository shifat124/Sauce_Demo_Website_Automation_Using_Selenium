package com.swaglabs.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.swaglabs.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) {

		logger = Logger.getLogger("Swag Labs Website Test");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
//		else if(br.equals("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
//			driver = new FirefoxDriver();
//		}

		driver.get(baseURL);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
