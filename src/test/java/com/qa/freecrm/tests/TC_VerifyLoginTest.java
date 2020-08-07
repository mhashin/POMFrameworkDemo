package com.qa.freecrm.tests;

/**
 * @author Muhammed.Hashin
 *
 */

import org.testng.Assert;


import org.testng.annotations.Test;
import com.qa.freecrm.base.BaseTest;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.util.Constants;

public class TC_VerifyLoginTest extends BaseTest {
	
	HomePage homePage;
	
	@Test(priority=1)
	public void verifyLoginFieldsDisplayed() {
		Assert.assertEquals(loginPage.emailaddressIsDisplayed(),true);
		Assert.assertEquals(loginPage.passwordIsDisplayed(),true);
		Assert.assertEquals(loginPage.loginIsDisplayed(),true);
		Assert.assertEquals(loginPage.signUpLinkIsDisplayed(),true);
		Assert.assertEquals(loginPage.forgotMyPasswordLinkIsDisplayed(),true);
		Assert.assertEquals(loginPage.showPassowordLinkIsDisplayed(),true);
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitle() {
		String title=loginPage.loginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		testUtil.log.info("The login page title is verified --->"+Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=3)
	public void verifyLogin(){
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	

}
