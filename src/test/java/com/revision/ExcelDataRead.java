package com.revision;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataRead {
	@Test
	public void excelReading() throws FileNotFoundException {
	File src= new File("C:\\Users\\Sapna Mishra\\Documents\\TCE QA Defects.xlxs");
	try {
	FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet1=wb.getSheetAt(0);
	String data0=sheet1.getRow(1).getCell(0).getStringCellValue();
	System.out.println("excel data"+ data0);
	int rowCount=sheet1.getLastRowNum();
	System.out.println(rowCount);
	wb.close();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	}

}

