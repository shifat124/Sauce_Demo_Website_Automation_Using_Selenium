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

public class CheckoutPage extends BaseClass {
	
	WebDriver ldriver;

	public CheckoutPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy(xpath = "//input[@value='CONTINUE']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//a[normalize-space()='CANCEL']")
	WebElement infoCancelBtn;
	
	
	
	@FindBy(xpath = "//div[@class='summary_total_label']")
	WebElement totalPrice;
	
	@FindBy(xpath = "//a[normalize-space()='FINISH']")
	WebElement finishBtn;
	
	@FindBy(xpath = "//a[normalize-space()='CANCEL']")
	WebElement cancelBtn;
	
	
	
	@FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
	WebElement finishPageText;
	
	
	
	
	
public void setFirstName() throws InterruptedException {
		
		Thread.sleep(2000);
		firstName.sendKeys("Shifat");
	}

public void setLastName() throws InterruptedException {
	
	Thread.sleep(2000);
	lastName.sendKeys("Laskor");
}

public void setPostalCode() throws InterruptedException {
	
	Thread.sleep(2000);
	postalCode.sendKeys("1200");
}

public void ddtSetFirstName(String fname) throws InterruptedException {
	
	Thread.sleep(2000);
	firstName.sendKeys(fname);
}

public void ddtSetLastName(String lname) throws InterruptedException {

Thread.sleep(2000);
lastName.sendKeys(lname);
}

public void ddtSetPostalCode(String post) throws InterruptedException {

Thread.sleep(2000);
postalCode.sendKeys(post);
}

public void clickContinueBtn() throws InterruptedException {
	Thread.sleep(2000);
	continueBtn.click();
}

public void clickInfoCancelBtn() throws InterruptedException {
	Thread.sleep(2000);
	infoCancelBtn.click();
}

public String getTotalPrice() {
	return totalPrice.getText();
}
public void clickFinishBtn() throws InterruptedException {
	Thread.sleep(2000);
	finishBtn.click();
}

public void clickCancelBtn() throws InterruptedException {
	Thread.sleep(2000);
	cancelBtn.click();
}

public String getFinishPageText() {
	return finishPageText.getText();
	
}


@DataProvider(name = "checkoutinfoddt")
public static Object[][] readExcelData() throws IOException {
	String filePath = "C:\\eclipse workspace\\swaglabs\\src\\test\\resources\\Testdata\\DDTCheckout.xlsx";
	String sheetName = "CheckoutInfo";

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
