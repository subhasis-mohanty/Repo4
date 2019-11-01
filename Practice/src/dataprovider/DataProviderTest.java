package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	String excelpath="./MySheet1.xlsx";
	@Test(dataProvider="getExcelData")
	public void dataTest(String name,String desc)
	{
		System.out.println("name="+name+",desc="+desc);
	}
	public Object[][] ExcelData(String sheet) throws IOException
	{
		FileInputStream file=new FileInputStream(excelpath);
		Workbook book=WorkbookFactory.create(file);
		Sheet sht=book.getSheet(sheet);
		Object[][] arr=new Object[sht.getLastRowNum()][sht.getRow(0).getLastCellNum()];
		for(int i=0;i<sht.getLastRowNum();i++)
		{
			for(int j=0;j<sht.getRow(0).getLastCellNum();j++)
			{
				arr[i][j]=sht.getRow(i+1).getCell(j).toString();
			}
			
		}
		return arr;
	}
	@DataProvider
	public Object[][] getExcelData() throws IOException
	{
		Object[][] data=ExcelData("Sheet1");
		return data;
	}
}
