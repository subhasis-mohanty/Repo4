package com.actitime.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileLib {
	String propertyPath="./testdata/CommonData.properties";
	static String excelpath="./testdata/customersheet.xlsx";
	
	public String getPropertyFileData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(propertyPath);
		Properties property=new Properties();
		property.load(file);
		String data=property.getProperty(key);
		return data;
	}
	


public static Object[][] ExcelData(String sheet) throws IOException
{
	FileInputStream file=new FileInputStream(excelpath);
	Workbook book=WorkbookFactory.create(file);
	Sheet sht=book.getSheet(sheet);
	Object[][] arr=new Object[sht.getLastRowNum()][sht.getRow(0).getLastCellNum()];
	for(int i=0;i<sht.getLastRowNum();i++)
	{
		for(int j=0;j<sht.getRow(i).getLastCellNum();j++)
		{
			arr[i][j]=sht.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return arr;
}
@DataProvider
public Object[][] getExcelData() throws IOException
{
	Object[][] data=ExcelData("CreateCustomer");
	return data;
}
}
