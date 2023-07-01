package com.swaglabs.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.swaglabs.base.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement txtUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement btnLogin;

	public void setUserName(String uname) throws InterruptedException {
		
		Thread.sleep(2000);
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) throws InterruptedException {
		Thread.sleep(2000);
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() throws InterruptedException {
		Thread.sleep(2000);
		btnLogin.click();
	}

	@DataProvider(name = "loginData")
	public static Object[][] readExcelData() throws IOException {
		String filePath = "C:\\eclipse workspace\\swaglabs\\src\\test\\resources\\Testdata\\Swag Labs Login.xlsx";
		String sheetName = "Login";

		FileInputStream inputStream = null;
		Workbook workbook = null;

		try {
			// Load the Excel file
			inputStream = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(inputStream);

			// Get the desired sheet by name
			Sheet sheet = workbook.getSheet(sheetName);

			// Get the number of rows and columns in the sheet
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
			int colCount = sheet.getRow(0).getLastCellNum();

			// Create a 2D array to store the data
			Object[][] data = new Object[rowCount][colCount];

			// Read the data from each cell and store it in the array
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);

				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					data[i][j] = cell.toString();
				}
			}

			return data;
		} finally {
			// Close the workbook and input stream
			if (workbook != null) {
				workbook.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

}
