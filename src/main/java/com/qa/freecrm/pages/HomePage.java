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
	ElementUtil eleutil;
	
	//locators
	
    By usernameText=By.xpath("//div[@id='top-header-menu']/child::div[@class='right menu']/descendant::span[text()='Hashin PK']");
    By contactsNavlink=By.xpath("//a[@class='item']/child::span[text()='Contacts']");
    
	
	//constructor of home page
	public HomePage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(this.driver); 
	}
	
	/*public ContactPage goToCreateContactPage() {
		elementUtil.waitForElementToBeVisible(contactsLink);
		elementUtil.doClick(contactsLink);
		TestUtil.clickByActions(driver, contactsSubmenu);
		return new ContactPage(driver);
	}
	*/
	
	public String verifyUserNameText() {
		eleutil.waitForElementToBeVisible(usernameText);
		return eleutil.getText(usernameText);
		
	}
	
	public void clickContactsLink() {
		eleutil.waitForElementToBeVisible(contactsNavlink);
		eleutil.doClick(contactsNavlink);
	}
	
	
	public String verifyPageTitle() {
		return eleutil.getPageTitle();
	}

}
