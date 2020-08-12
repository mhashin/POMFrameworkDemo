package com.qa.freecrm.util;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Muhammed.Hashin
 *
 */
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestUtil {
	
	public Logger log;
	
	public TestUtil() {
	log = Logger.getLogger(this.getClass());
	}

	// Set Date For Log4J.
		public static void setDateForLog4j() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyy_hhmmss");
			System.setProperty("current_date", dateFormat.format(new Date()));
			PropertyConfigurator.configure(".src/main/java/com/qa/freecrm/config/log4j.properties");
		}
		
		public static void clickByActions(WebDriver driver,By locator) {
			
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(locator)).click().perform();
			
		}
}
