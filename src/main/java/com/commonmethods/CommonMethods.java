package com.commonmethods;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.datalibrary.DataLibraryReadExcelData;
import com.datalibrary.Reporter;



public class CommonMethods extends Reporter {
	
	public static RemoteWebDriver driver;
	

	
@BeforeMethod
public void startApp() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
	

	
}

@DataProvider(name = "fetchData")
public Object[][] fetchData() throws IOException {
	return DataLibraryReadExcelData.readExcelData(excelfileName,excelSheetName);
}


@AfterMethod
public void closeApp() {
	driver.close();
}

public long takeSnap(){
	long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
	try {
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
	} catch (WebDriverException e) {
		System.out.println("The browser has been closed.");
	} catch (IOException e) {
		System.out.println("The snapshot could not be taken");
	}
	return number;
}


}
