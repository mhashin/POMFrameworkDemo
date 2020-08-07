package com.qa.freecrm.base;
/**
 * @author Muhammed.Hashin
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.freecrm.util.Constants;
import com.qa.freecrm.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public TestUtil testUtil = new TestUtil();
	
	public static ThreadLocal<WebDriver> td=new ThreadLocal<WebDriver>();
	
	/**
	 * this method is used to initialize driver
	 * @param prop
	 * @return
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		td.set(new ChromeDriver());
		testUtil.log.info("Launching the browser --->"+browserName);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		testUtil.log.info("Naviagting to url --->"+prop.getProperty("url"));
		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return getDriver();
		
		
	}
	
	public static synchronized WebDriver getDriver() {
		return td.get();
	}

	/**
	 *this method is used to load the config properties
	 * @return 
	 */
	public Properties init_prop() {
		
		File src = new File(Constants.CONFIG_PATH);
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured during loading the config properties....");
		}
		testUtil.log.info("Loading the config properties --->");
		return prop;
	}
	
	
}
