package com.qa.freecrm.pages;
/**
 * @author Muhammed.Hashin
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.util.ElementUtil;

public class LoginPage extends BasePage {


	public ElementUtil elementUtil;
	
	
	//locators of LoginPage
	By txtEmailaddress=By.id("username");
	By txtPassword=By.id("password");
	By btnLogin=By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	By showPasswordLink=By.xpath("//button//span[text()='Show Password']");
	By forgotMypasswordLink=By.linkText("Forgot my password");
	
	
	//constructor of the LoginPage
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}
	
	/**
	 * method to do login 
	 * @param userName
	 * @param password
	 * @return 
	 * @return 
	 */
	public HomePage doLogin(String userName,String password) {
		elementUtil.waitForElementToBeVisible(txtEmailaddress);
		testUtil.log.info("Log in with the credentials --->"+userName+" & "+password);
		elementUtil.doSendKeys(txtEmailaddress, userName);
		elementUtil.doSendKeys(txtPassword, password);
		elementUtil.doClick(btnLogin);
		testUtil.log.info("Logged in successfully");
		return new HomePage(driver);
	}
	/**
	 * @return the Login page title
	 */
	public String loginPageTitle() {
		return elementUtil.getPageTitle();
	}
	
	public boolean emailaddressIsDisplayed() {
		elementUtil.waitForElementToBeVisible(txtEmailaddress);
		testUtil.log.info("Email address field ---> is present on the Login page");
		return elementUtil.isElementPresent(txtEmailaddress);
	}
	
	public boolean passwordIsDisplayed() {
		elementUtil.waitForElementToBeVisible(txtPassword);
		testUtil.log.info("Password field ---> is present on the Login page");
		return elementUtil.isElementPresent(txtPassword);
	}
	
	public boolean loginIsDisplayed() {
		elementUtil.waitForElementToBeVisible(btnLogin);
		testUtil.log.info("Login button ---> is present on the Login page");
		return elementUtil.isElementPresent(btnLogin);
	}
	
	public boolean signUpLinkIsDisplayed() {
		testUtil.log.info("Sign up link ---> is present on the Login page");
		return elementUtil.isElementPresent(signUpLink);
	}
	
	public boolean showPassowordLinkIsDisplayed() {
		testUtil.log.info("Show password link ---> is present on the Login page");
		return elementUtil.isElementPresent(showPasswordLink);
	}
	
	public boolean forgotMyPasswordLinkIsDisplayed() {
		testUtil.log.info("Forgot Mypassword link ---> is present on the Login page");
		return elementUtil.isElementPresent(forgotMypasswordLink);
	}
	
	
}
