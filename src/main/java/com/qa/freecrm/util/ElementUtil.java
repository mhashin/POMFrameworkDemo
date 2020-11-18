package com.qa.freecrm.util;
/**
 * @author Muhammed.Hashin
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver; 
	}
	/**
	 * method to create the webelement on passing the locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
		element=driver.findElement(locator);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error occured in locating webelement..."+locator);
		}
		return element;
	}
	
	/*
	 * method to do click the webelement 
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	/**
	 * method to do send value to webelement
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}

	/**
	 * method to get text 
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {
		return getElement(locator).getText();
	}
	
	/**
	 * method to get page title
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isElementPresent(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void waitForElementToBeVisible(By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void isContactDisplayed(String contact) {
		driver.findElement(By.xpath("//td[text()='"+contact+"']"));
	}
	

}
