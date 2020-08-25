package com.qa.freecrm.base;
/**
 * @author Muhammed.Hashin
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.qa.freecrm.util.BrowserOptions;
import com.qa.freecrm.util.Constants;
import com.qa.freecrm.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public BrowserOptions browserOptions;
	public TestUtil testUtil = new TestUtil();
	
	
	public static ThreadLocal<WebDriver> td=new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	/**
	 * this method is used to initialize driver
	 * @param prop
	 * @return
	 */
	
public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser");
		System.out.println("browser name is : " + browserName);
		if(driver==null) {
			browserOptions = new BrowserOptions(prop);
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				td.set(new ChromeDriver(browserOptions.getChromeOptions()));
			}
			else {
				System.out.println(browserName + " is not found, please pass the correct browser....");
			}
		testUtil.log.info("Launching the browser --->"+browserName);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		testUtil.log.info("Naviagting to url --->"+prop.getProperty("url"));
		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return getDriver();
		}
		else {
			return getDriver();
		}
		
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
	
	//take screenshot:
			public String getScreenshot(ITestResult result){
				File src  = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
				String path = System.getProperty("user.dir")+"/screenshots/Screenshot_"+result.getName()+TestUtil.getCurrentDate()+".png";
				File destination = new File(path);
				try {
					FileUtils.copyFile(src, destination);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return path;
			}

	
}
