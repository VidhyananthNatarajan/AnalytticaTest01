package com.application.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.application.testcases.LoginTestCase;
import com.commonmethods.CommonMethods;

public class OrgangeHCMLoginPage extends CommonMethods {
	
	
public OrgangeHCMLoginPage enterURL (String baseURL) {
	driver.get(baseURL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return this;
}
	
	
public OrgangeHCMLoginPage enterUsername(String Username) {
	
	    driver.findElementByXPath("//input[@id='txtUsername']").sendKeys(Username);
	    //reportStep("Enter the userName:"+Username+"","pass");
	    takeSnap();
		//driver.findElementById("txtUsername").sendKeys(Username);
		return this;
		
	}
	
	public OrgangeHCMLoginPage enterPassword(String Password)  {
		driver.findElementById("txtPassword").sendKeys(Password);
		//reportStep("Enter the password:"+Password+"","pass");
		takeSnap();
		return this;
	}
	
	public OrgangeHCMDashboardPage clickbutton()  {
		driver.findElementById("btnLogin").click();
		if (driver.findElementByXPath("//h1[text()='Dashboard']").isDisplayed()) {
			System.out.println("Login Successful");
			//reportStep("Login Successfull", "pass");
		} else {
			System.out.println("Login Failed");
			//reportStep("Login Failed","fail");
		}
		takeSnap();
		return new OrgangeHCMDashboardPage();
	}

}
