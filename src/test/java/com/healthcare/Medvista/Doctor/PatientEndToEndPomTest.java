package com.healthcare.Medvista.Doctor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.common.value.qual.ArrayLen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.ObjectRepoPom.MainHomePage;
import com.ObjectRepoPom.doctormodule.DoctorLoginPage;
import com.ObjectRepoPom.patientModule.PatientLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.IpathConstant;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;

public class PatientEndToEndPomTest {
	
public static void main(String[] args) throws IOException {
	 JavaUtils jlib = new JavaUtils();
	 FileUtils flib = new FileUtils();
	 ExcelUtils elib = new ExcelUtils();
	 WebDriverUtils wlib = new WebDriverUtils();
	 //read the data from property file
	String url = flib.readDataFromPropertyFile("url");
	//get random number
	int r = jlib.getRabdomNumber(1500);
	//launch browser
	WebDriver driver= new ChromeDriver();
	 MainHomePage mp = new MainHomePage(driver);
	 PatientLoginPage plogin = new PatientLoginPage(driver);
	 DoctorLoginPage dlogin = new DoctorLoginPage(driver);
	//maximize the window
	wlib.maximizeWindow(driver);
	//wait statement
	wlib.waitforpageLoad(driver, 20);
	//enter the url
	driver.get(url);
	//click on patinet login link
	mp.patientLoginLink();
	//click on add new patient link
	plogin.getCreateAccountLink().click();
	//enter all the details
	//read the data from excel file
	String pusername=null;
  	String ppassword=null;
  	String pname=null;
	HashMap<String, String> map = elib.hashMapData("Patient");
	for(Entry<String, String> s:map.entrySet())
	{
		if(s.getKey().contains("email"))
		{
			pusername=s.getValue()+r+"@hms.com";
			driver.findElement(By.name(s.getKey())).sendKeys(pusername);
		}
		else if (s.getKey().contains("password")) {
			ppassword=s.getValue()+r;
			driver.findElement(By.name(s.getKey())).sendKeys(ppassword);
		}
		else if (s.getKey().contains("full_name")) {
			pname=s.getValue()+r;
			driver.findElement(By.name(s.getKey())).sendKeys(pname);
		}
		else if (s.getKey().contains("address")) {
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+r);
		}
		else if (s.getKey().contains("city")) {
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+r);
		}
		else if (s.getKey().contains("password_again")) {
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+r);
		}
		driver.findElement(By.xpath("//label[@for='rg-male']")).click();
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}
	wlib.accepAlertPopup(driver);
	//write the data into excel file
	HashMap< String, String> hs = new HashMap<String, String>();
	hs.put("Patient Name", pname);
	hs.put("Patient Username", pusername);
	hs.put("Password", ppassword);
	System.out.println("---Data added sucessfully into Hash Map-------");
	/*ArrayList<String>al = new ArrayList<String>();
	al.add(pname);
	al.add(pusername);
	al.add(ppassword);*/
	FileInputStream fis = new FileInputStream(IpathConstant.EXCELFILEPATH);
	Workbook wb = WorkbookFactory.create(fis);
	//Sheet sh = wb.getSheet("Sheet1");
	Sheet sh=wb.createSheet("Patient"+r);
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
	System.out.println("Data inserted");
	
	
	System.out.println(pusername + " : " + ppassword);
	plogin.getNewPatientLoginLink().click();	
	plogin.setPatientLogin(pusername, ppassword);
	
	driver.quit();
}

}

