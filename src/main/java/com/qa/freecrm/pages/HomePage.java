package com.qa.freecrm.pages;

import org.openqa.selenium.By;
/**
 * @author Muhammed.Hashin
 *
 */
import org.openqa.selenium.WebDriver;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.util.ElementUtil;
import com.qa.freecrm.util.TestUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//locators
	
    By contactsLink=By.linkText("Contacts");
    By contactsSubmenu=By.xpath("(//a[@id='nav-secondary-contacts'])[1]");
    
	
	//constructor of home page
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}
	
	public ContactPage goToCreateContactPage() {
		elementUtil.waitForElementToBeVisible(contactsLink);
		elementUtil.doClick(contactsLink);
		TestUtil.clickByActions(driver, contactsSubmenu);
		return new ContactPage(driver);
	}
	

}
