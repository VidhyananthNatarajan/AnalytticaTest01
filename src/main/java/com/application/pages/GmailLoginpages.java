package com.application.pages;

import java.util.concurrent.TimeUnit;

import com.commonmethods.CommonMethods;

public class GmailLoginpages extends CommonMethods {
	

public 	GmailLoginpages enterURL(String baseURL) {
	driver.get(baseURL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	return this;
}

public GmailLoginpages clickUserName(String userName) throws InterruptedException {
	driver.findElementById("identifierId").sendKeys(userName);
	
	driver.findElementByXPath("//span[text()='Next']").click();
	
	return this;
}

public GmailLoginpages enterPassword(String Password) throws InterruptedException {
	Thread.sleep(300);
	driver.findElementByName("password").sendKeys(Password);
	return this;
}

public GmailMailsdetails clickNext() throws InterruptedException {
	Thread.sleep(500);
	driver.findElementByXPath("//span[text()='Next']").click();
    String title = driver.getTitle();
    if (title.contains("Inbox")) {
    	System.out.println("Login Successfull");
    } else {
    	System.out.println("Login Failed");
    }
	return new GmailMailsdetails();
}

}
