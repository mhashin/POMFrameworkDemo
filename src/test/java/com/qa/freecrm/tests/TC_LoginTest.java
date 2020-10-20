package com.qa.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.freecrm.base.BaseTest;
import com.qa.freecrm.pages.HomePage;

public class TC_LoginTest extends BaseTest{

	HomePage homepage;
	
	@Test
	public void verifyLogin() {
		homepage=new HomePage(driver);
		String pageTitle=homepage.verifyPageTitle();
		Assert.assertEquals(pageTitle, "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
	}
}
