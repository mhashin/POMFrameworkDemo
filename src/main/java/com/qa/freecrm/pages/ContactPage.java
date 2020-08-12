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
	ElementUtil elementUtil;
	
	By btnCreateContact=By.xpath("//button//span[text()='Create contact']");
	By txtEmail=By.name("textInput");
	By txtFirstName=By.cssSelector("input[data-field='firstname']");
	By txtLasttName=By.cssSelector("input[data-field='lastname']");//button/span[text()='Create contact']
	By btnCreateContact_createContact=By.xpath("//button/span[text()='Create contact']");
	By customerTable=By.cssSelector("div[class^=CustomerDataTable]");

	public ContactPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}
	
	
	
	public void clickCreateContact() {
		elementUtil.waitForElementToBeVisible(btnCreateContact);
		testUtil.log.info("click on create contact button");
		elementUtil.doClick(btnCreateContact);
	}
	
	public void enterEmail(String email) {
		elementUtil.waitForElementToBeVisible(txtEmail);
		testUtil.log.info("Enter email --->"+email);
		elementUtil.doSendKeys(txtEmail, email);
	}
	
	public void enterFirstName(String firstName) {
		testUtil.log.info("Enter firstName --->"+firstName);
		elementUtil.doSendKeys(txtFirstName, firstName);
	}
	
	public void enterLastName(String lastName) {
		testUtil.log.info("Enter lastName --->"+lastName);
		elementUtil.doSendKeys(txtLasttName,lastName);
	}
	
	public void saveContact() {
		testUtil.log.info("Save the contact");
		elementUtil.doClick(btnCreateContact_createContact);
	}
	
	public boolean isContactDisplayed(String email) {
		WebElement element =driver.findElement(By.xpath("//a[text()='"+email+"']"));
		testUtil.log.info("Record is displayed in the list"+email);
		return element.isDisplayed();
	}
	
	public void waitForTabelIsDisplayed() {
		elementUtil.waitForElementToBeVisible(customerTable);
	}
}
