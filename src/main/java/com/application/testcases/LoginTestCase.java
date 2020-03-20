package com.application.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.application.pages.OrgangeHCMLoginPage;
import com.commonmethods.CommonMethods;

public class LoginTestCase extends CommonMethods{
	
@BeforeTest
public void setData() {
	excelfileName ="Login";
	excelSheetName="Sheet1";
	testcaseName="OrangeLoginTest";
	testcaseDec="To test the Login functionality";
	author ="Vidhyananth";
	category ="Sanity";
}

@Test (dataProvider ="fetchData")	
 public void TC001(String baseURL,String Username, String Password) {
	 OrgangeHCMLoginPage lp = new OrgangeHCMLoginPage();
	 
	lp.enterURL(baseURL).enterUsername(Username).enterPassword(Password).clickbutton();
	
	
	 
 }
	

	

}
