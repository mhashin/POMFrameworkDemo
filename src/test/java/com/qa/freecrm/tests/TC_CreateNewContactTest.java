/**
 * 
 */
package com.qa.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.freecrm.base.BaseTest;
import com.qa.freecrm.pages.ContactPage;
import com.qa.freecrm.pages.HomePage;

/**
 * @author Muhammed.Hashin
 *
 */
public class TC_CreateNewContactTest extends BaseTest{
	
	ContactPage contactPage;
	HomePage homePage;
	
	@Test(priority=1,dataProvider="create record")
	public void verifyCreateContactTest(String email,String FName,String LName) {
		
	
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homePage.goToCreateContactPage();
		contactPage.clickCreateContact();
		contactPage.enterEmail(email);
		contactPage.enterFirstName(FName);
		contactPage.enterLastName(LName);
		contactPage.saveContact();
	}
	
	@Test(priority=2,dataProvider="create record")
	public void verifyContactisDisplayedInTableList(String email,String FName,String LName) {
		contactPage=homePage.goToCreateContactPage();
		contactPage.waitForTabelIsDisplayed();
		Assert.assertEquals(contactPage.isContactDisplayed(email),true);
		
	}
	
 @DataProvider(name="create record")
 public static Object[][] getData() {
	 
	  Object[][] data=new Object[1][3] ;
	  data[0][0]="testuser1@hubspot.com";
	  data[0][1]="test";
	  data[0][2]="User1";
	  
	  return data;
		}
 
 }

