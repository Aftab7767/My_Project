package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils
{
FileInputStream stream ;
Workbook wb;
/**
 * This method is used to read the data from excel file
 * @author Aftab
 * @param sheetName
 * @param row
 * @param col
 * @return String
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcel(String sheetName,int row,int col) throws EncryptedDocumentException, IOException 
{
	stream=new FileInputStream(IpathConstant.EXCELFILEPATH);
	 wb = WorkbookFactory.create(stream);
	Sheet sh = wb.getSheet(sheetName);
	String data = sh.getRow(row).getCell(col).getStringCellValue();
	return data;
}
/**
 * This Method is used to get row count in excel file

 * @author Aftab
 * @param sheetName
 * @return int
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
{
	stream=new FileInputStream(IpathConstant.EXCELFILEPATH);
	wb=WorkbookFactory.create(stream);
	Sheet sh = wb.getSheet(sheetName);
	int rowCount = sh.getLastRowNum();
	return rowCount;
}
/**
 * This method is used to get data from excel sheet using map
 * @author Aftab
 * @param sheetName
 * @return HashMap<String,String>
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public HashMap<String,String> hashMapData(String sheetName) throws EncryptedDocumentException, IOException
{
	stream = new FileInputStream(IpathConstant.EXCELFILEPATH);
	wb=WorkbookFactory.create(stream);
	Sheet sh = wb.getSheet(sheetName);
	int lastRow=sh.getLastRowNum();
	HashMap<String, String> map = new HashMap<String, String>();
	for(int i = 0;i<=lastRow;i++)
	{
		String key = sh.getRow(i).getCell(0).getStringCellValue();
		String value = sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
	}
	return map;
}
/**
 * This method is use to write the into excel file
 * @author Aftab
 * @param sheetName
 * @param row
 * @param col
 * @param data
 * @throws IOException
 */
public void writeDataIntoExcel(String sheetName,String data) throws IOException
{
	stream = new FileInputStream(IpathConstant.EXCELFILEPATH);
	Sheet sh = wb.getSheet(sheetName);
	for(int i=0;i<10;i++)
	{
		for(int j=0;j<2;j++)
		{
			sh.createRow(i).createCell(j).setCellValue(data);
		}
	}
//	sh.createRow(row).createCell(col).setCellValue(data);
	FileOutputStream fos = new FileOutputStream(IpathConstant.EXCELFILEPATH);
	wb.write(fos);
	wb.close();
}


public Object[][] readDataFromExcelForDataProvider(String sheetName) throws EncryptedDocumentException, IOException
{
stream = new FileInputStream(IpathConstant.EXCELFILEPATH);
wb=WorkbookFactory.create(stream);
Sheet sh = wb.getSheet(sheetName);
int row = sh.getPhysicalNumberOfRows();
int cell = sh.getRow(0).getPhysicalNumberOfCells();
Object[][] obj = new Object[row][cell];
for(int i=0;i<row;i++)
{
	for(int j=0;j<cell;j++)
	{
		obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	}
}
return obj;
	
}









}

