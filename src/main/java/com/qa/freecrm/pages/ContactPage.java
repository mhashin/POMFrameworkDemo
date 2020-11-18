/**
 * 
 */
package com.qa.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.util.ElementUtil;

/**
 * @author Muhammed.Hashin
 *
 */
public class ContactPage extends BasePage {

	private WebDriver driver;
	ElementUtil eleutil;
	
	By btn_createContactNew=By.xpath("//a[@href='/contacts/new']");
	By txt_firstName=By.name("first_name");
	By txt_last_Name=By.name("last_name");
	By btn_save=By.xpath("//button[text()='Save']");
    By chkbox_contact=By.xpath("//td[text()='Test user01']/ancestor::tr/descendant::div[@class='ui fitted read-only checkbox']");
	By chkbox_contact1=By.xpath("//td[text()='Test user02']/ancestor::tr/descendant::div[@class='ui fitted read-only checkbox']");
	

	public ContactPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(this.driver);
	}
	
	
	
	public void clickNew() {
		eleutil.waitForElementToBeVisible(btn_createContactNew);
		testUtil.log.info("click on create contact button");
		eleutil.doClick(btn_createContactNew);
	}
	
	public void enterFirstName(String fName) {
		eleutil.waitForElementToBeVisible(txt_firstName);
		eleutil.doSendKeys(txt_firstName, fName);
	}
	
	
	public void enterLastName(String lName) {
		eleutil.doSendKeys(txt_last_Name, lName);
	}
	
	public void clickSave() {
		eleutil.doClick(btn_save);
	}
	
	public void chekbox() {
		eleutil.waitForElementToBeVisible(chkbox_contact);
		eleutil.doClick(chkbox_contact);
		eleutil.doClick(chkbox_contact1);
	}
	
	public void verifyContactIsCreated(String contact) {
		eleutil.isContactDisplayed(contact);
	}
}
