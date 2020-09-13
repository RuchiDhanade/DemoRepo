package com.selenium.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.selenium.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;
	
	public static String TESTDATA_SHEET_PATH = "E:\\Ruchi_workspace\\Selenium_Maven_Project\\src\\main\\java\\com\\selenium\\qa\\testdata\\FreeCRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	static JavascriptExecutor js;
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch(InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		System.out.println(sheet.getLastRowNum()+"------"+sheet.getRow(0).getLastCellNum());
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
//				System.out.println(data[i][j]);
			}
		}
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String CurrentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(CurrentDir + "/screenshot/" +System.currentTimeMillis()+ ".png"));
	}
	
	
	
	
	
	
	
	
	

}
