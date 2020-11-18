package com.qa.freecrm.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String path;
	public FileInputStream fis=null;
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	
	public ExcelReader(String path) {
		
		this.path=path;
		try {
			 fis=new FileInputStream(path);
			 workbook=new XSSFWorkbook(fis);
			 sheet=workbook.getSheetAt(0);
			 fis.close();
			 
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
	}

}
