package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getTestData(String filePath, String sheetName) {
		Object[][]	getDataa = null;
		try {
			
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int rowCount = sheet.getLastRowNum();
			System.out.println("Row count is : " + rowCount);
			
			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println("Column count is : " + columnCount);
			
			getDataa = new Object[rowCount][columnCount] ;
			for(int i=0;i<rowCount;i++) {
				for(int j=0;j<columnCount;j++) {
					getDataa[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue().trim();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getDataa;

	}
}
