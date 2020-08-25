package com.qa.freecrm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.util.TestUtil;

public class BaseTest  {
	
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginPage;
	public TestUtil testUtil = new TestUtil();
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName ) {
		basePage=new BasePage();
		prop=basePage.init_prop();
		prop.setProperty("browser", browserName);
		driver=basePage.init_driver(prop);
		loginPage=new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		testUtil.log.info("Quitting the browser....");
		driver.quit();
	}

}
