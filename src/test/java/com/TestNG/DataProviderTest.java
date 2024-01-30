package com.TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericUtility.ExcelUtils;

public class DataProviderTest {
@DataProvider
public Object[][] data()
{
	  Object[][] obj = new Object[3][2];
	  obj[0][0]="Aftab";
	  obj[0][1]="Aalm";
	  
	  obj[1][0]="Kundan";
	  obj[1][1]="Singh";
	  
	  obj[2][0]="Deep";
	  obj[2][1]="Narayan";
	  return obj;
}
@DataProvider
public Object[][] address()
{
	Object[][] obj1 = new Object[3][2];
	obj1[0][0]="Kohra";
	obj1[0][1]=500;
	
	obj1[1][0]="Bisunpura";
	obj1[1][1]=800;
	
	obj1[2][0]="Enayat";
	obj1[2][1]=1000;
	return obj1;
}
@Test(dataProvider = "address")
public void getData(String fname,int lastname)
{
	System.out.println("First Name----> " + fname + " last name " + lastname);
}
@DataProvider
public Object[][] getdata() throws EncryptedDocumentException, IOException {
ExcelUtils elib = new ExcelUtils();
Object[][] obj = elib.readDataFromExcelForDataProvider("Aftab");
return obj;

}
@Test
public void  readfromExcel(String k,String p) {
	System.out.println(k+"======"+p);
}
}







