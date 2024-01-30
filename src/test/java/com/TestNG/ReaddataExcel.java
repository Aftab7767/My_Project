package com.TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericUtility.IpathConstant;

public class ReaddataExcel {
	
	@Test(dataProvider = "read")
	public void readDataFromExcel(String p,String k)
	{
		System.out.println(p+" =======> "+k);
	}
@DataProvider
public Object[][] read() throws EncryptedDocumentException, IOException
{
	//read the data from excel file
	//create file input stream cobject and pass the path as an argument
	FileInputStream fis = new FileInputStream(IpathConstant.EXCELFILEPATH);
	//load the excel file
	Workbook wb = WorkbookFactory.create(fis);
	//get the sheet from which we have to fetch the data
	Sheet sh = wb.getSheet("Aftab");
	//find the last row number
	int row = sh.getPhysicalNumberOfRows();
	//find the last cell number
	int cell = sh.getRow(0).getPhysicalNumberOfCells();
	//store the data into 2-D array by using Data provider
	//Step 1: create one 2-D Object type array
	 Object[][] obj = new Object[row][cell];
	 //fetch the excel data and store inside the array
	for(int i =0;i<row;i++)
	{
		for(int j=0;j<cell;j++)
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}
}
