package com.qa.freecrm.util;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Muhammed.Hashin
 *
 */
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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
}
