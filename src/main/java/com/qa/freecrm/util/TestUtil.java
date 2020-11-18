package com.qa.freecrm.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class TestUtil {
	
	public Logger log;
	public static Workbook book;
	public static Sheet sheet;
	
	
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
		
		public static String getCurrentDate() {
			DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
			Date currentDate=new Date();
			return customFormat.format(currentDate);
			
		}
		
		
		public static Object[][] getTestData(String sheetName) 
		{
			FileInputStream file = null;
			try 
			{
				file = new FileInputStream(Constants.EXCEL_PATH);
			} 
			catch(FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				book = WorkbookFactory.create(file);
			} 
			catch(IOException e) 
			{
				e.printStackTrace();
			}
			
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i = 0; i < sheet.getLastRowNum(); i++) 
			{
				for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
				{
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
			return data;
		}

		
}
