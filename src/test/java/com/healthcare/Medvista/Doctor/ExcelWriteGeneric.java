package com.healthcare.Medvista.Doctor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.genericUtility.IpathConstant;

public class ExcelWriteGeneric {
public void writeData(String key,String value,String SheetName) throws EncryptedDocumentException, IOException
{
	HashMap< String, String> hs = new HashMap();
	hs.put(key, value);
	FileInputStream fis = new FileInputStream(IpathConstant.EXCELFILEPATH);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.createSheet(SheetName);
	int rowNum=0;
	for(Entry<String,String> s:hs.entrySet())
	{
		Row row = sh.createRow(rowNum++);
		row.createCell(0).setCellValue(s.getKey());
		row.createCell(1).setCellValue(s.getValue());
	System.out.println(s.getKey()+"------->"+s.getValue());
	}
	FileOutputStream fos = new FileOutputStream(IpathConstant.EXCELFILEPATH);
	wb.write(fos);
}
}
