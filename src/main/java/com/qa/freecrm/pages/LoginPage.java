package com.qa.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.util.ElementUtil;

public class LoginPage extends BasePage {
	
	ElementUtil eleutil;
	
	By userName=By.name("email");
	By password=By.name("password");
	By login=By.xpath("//div[text()='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(driver);
	}
	
	public void enterUserName(String user) {
		eleutil.doSendKeys(userName,user );
	}
	
	public void enterPassword(String pwd) {
		eleutil.doSendKeys(password, pwd);
	}
	
	public void clickLogin() {
		eleutil.doClick(login);
	}
	
	public HomePage doLogin(String user,String pwd) {
		
		enterUserName(user);
		enterPassword(pwd);
		clickLogin();
		return new HomePage(driver);
	}

}
