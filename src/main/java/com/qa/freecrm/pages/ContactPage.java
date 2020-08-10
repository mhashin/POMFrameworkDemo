/**
 * 
 */
package com.qa.freecrm.pages;

import org.openqa.selenium.WebDriver;

import com.qa.freecrm.util.ElementUtil;

/**
 * @author Muhammed.Hashin
 *
 */
public class ContactPage {

	private WebDriver driver;
	ElementUtil elementUtil;
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}
}
