package com.application.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.application.pages.GmailLoginpages;
import com.application.pages.OrgangeHCMLoginPage;
import com.commonmethods.CommonMethods;

public class GmailLogin extends CommonMethods {
	@BeforeTest
	public void setData() {
		excelfileName ="Login";
		excelSheetName="Sheet2";
		testcaseName="GmailLogin";
		testcaseDec="To test the Login functionality";
		author ="Vidhyananth";
		category ="Sanity";
	}
	
	@Test(dataProvider ="fetchData")	
	 public void TC002(String baseURL,String userName,String Password) throws InterruptedException {
		
		GmailLoginpages glp = new  GmailLoginpages();
		glp.enterURL(baseURL).clickUserName(userName).enterPassword(Password).clickNext();
		
		
		
		 
	 }
	

}
