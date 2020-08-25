/**
 * 
 */
package com.qa.freecrm.util;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Muhammed.Hashin
 *
 */
public class BrowserOptions {
	
	Properties prop;
	ChromeOptions co;
	
	public BrowserOptions(Properties prop) {
		this.prop=prop;
	}

	public ChromeOptions getChromeOptions(){
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		return co;
	}
}
