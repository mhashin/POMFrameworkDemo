package com.qa.freecrm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.qa.freecrm.util.TestUtil;

public class BaseTest  {
	
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public TestUtil testUtil = new TestUtil();
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void setUp(String browserName,String url ) {
		basePage=new BasePage();
		prop=basePage.init_prop();
		prop.setProperty("browser", browserName);
		prop.setProperty("url", url);
		driver=basePage.init_driver(prop);
		
	}
	
	
/*	@BeforeTest
	public void setUp() {
		
		basePage=new BasePage();
		prop=basePage.init_prop();
		driver=basePage.init_driver(prop);
	}*/
	
	
	/*@AfterTest
	public void tearDown() {
		testUtil.log.info("Quitting the browser....");
		driver.quit();
	}
*/
}
