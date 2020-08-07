package com.qa.freecrm.pages;

/**
 * @author Muhammed.Hashin
 *
 */
import org.openqa.selenium.WebDriver;

import com.qa.freecrm.util.ElementUtil;

public class HomePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//locators
	
	//constructor of home page
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}
	
	

}
