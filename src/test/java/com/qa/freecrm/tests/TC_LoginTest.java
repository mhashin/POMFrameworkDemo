package com.qa.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.freecrm.base.BaseTest;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;

public class TC_LoginTest extends BaseTest{

	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void verifyLogin() { 
		loginpage=new LoginPage(driver); 
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String userNameText=homepage.verifyUserNameText();
		Assert.assertEquals(userNameText,prop.getProperty("logged_username_text"),"Logged in user verification is failed!");
	}
}
