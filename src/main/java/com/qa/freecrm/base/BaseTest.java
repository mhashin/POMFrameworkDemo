package com.qa.freecrm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.util.TestUtil;

public class BaseTest  {
	
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginPage;
	public TestUtil testUtil = new TestUtil();
	
	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_prop();
		driver=basePage.init_driver(prop);
		loginPage=new LoginPage(driver);
		
	}
	
	/*@AfterTest
	public void tearDown() {
		driver.quit();
	}*/

}
