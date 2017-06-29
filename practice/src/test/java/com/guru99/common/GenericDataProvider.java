package com.guru99.common;

import java.io.FileInputStream;


import org.testng.annotations.DataProvider;
import jxl.Workbook;
import jxl.Sheet;

public class GenericDataProvider {
	
	@DataProvider(name = "LoginIntoGuru99")
	public  Object[][] getDataForLoginFunctionality() throws Exception {
		Object[][] loginObject = convertExcelDataIntoDataProviderObject(System.getProperty("user.dir") +"/TestData/LoginPage.xls","Login_TC");
		return loginObject;
	}
	
	/**
	 * This method converts Excel Data and returns a String array object to the requested data provider
	 */
	public Object[][] convertExcelDataIntoDataProviderObject(String fileName,String sheetName){
		Object[][] arrayExcelData =null;
		
		try{
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return arrayExcelData;
	}
}