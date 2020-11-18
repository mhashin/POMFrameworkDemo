package com.qa.freecrm.tests;

import org.testng.annotations.Test;

import com.qa.freecrm.base.BaseTest;
import com.qa.freecrm.pages.ContactPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.util.DataProviders;

public class TC_02_create_contact extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	
	@Test(dataProvider="createContact",dataProviderClass=DataProviders.class)
	public void verifyCreateNewContact(String fName,String lName) {
	
		loginpage=new LoginPage(driver); 
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickContactsLink();
		contactpage=new ContactPage(driver);
		contactpage.clickNew();
		contactpage.enterFirstName(fName);
		contactpage.enterLastName(lName);
		contactpage.clickSave();
		homepage.clickContactsLink();
		
		
	}

}
