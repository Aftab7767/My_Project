package com.healthcare.Medvista.Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;

public class AddDoctorSpecializationTest {
	WebDriver  driver ;
	FileUtils flib = new FileUtils();
	JavaUtils jlib = new JavaUtils();
	ExcelUtils elib=new ExcelUtils();
	WebDriverUtils wlib = new  WebDriverUtils();

	
	@Test
	public  void addSpecialization() throws IOException, InterruptedException {
	//for giving random values
		try {
		int r = jlib.getRabdomNumber(5000);
		
	/*Random random = new Random();
	int r = random.nextInt(1000);*/
	//getting data from property file
		String url = flib.readDataFromPropertyFile("url");
		String un=flib.readDataFromPropertyFile("username");
		String pwd=flib.readDataFromPropertyFile("password");
		
	/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String url = p.getProperty("url");
	String un = p.getProperty("username");
	String pwd = p.getProperty("password");*/		
		//create one empty map
	HashMap< String, String> map = new HashMap<String, String>();
	//fetching the data from excel file
	FileInputStream f = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(f);
	Sheet sh = wb.getSheet("Specialization");
	int lastrow = sh.getLastRowNum();
	//launch browser
	 driver = new ChromeDriver();
	//maximize the browser
	 wlib.maximizeWindow(driver);
	//driver.manage().window().maximize();
	//wait statement
	 wlib.waitforpageLoad(driver, 20);
	//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	//enter url
	driver.get(url);
	//click on  admin login link
	driver.findElement(By.xpath("//h3[text()='Admin Login']/../div//a[text()='Click Here']")).click();
	//enter admin login credential
	driver.findElement(By.name("username")).sendKeys(un);
	driver.findElement(By.name("password")).sendKeys(pwd);
	driver.findElement(By.name("submit")).click();
	//click on doctor tab
	driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
	//click on add doctor specialization
	driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
	for(int i =0;i<lastrow;i++)
	{
		String key = sh.getRow(i).getCell(0).getStringCellValue();
		String value = sh.getRow(i).getCell(1).getStringCellValue()+r;
	    map.put(key, value);
	}
	
	for( Entry<String, String> set:map.entrySet())
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
	}
	driver.findElement(By.name("submit")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space(text()='Doctor Specialization added successfully !!')]")));
	String confMessage = driver.findElement(By.xpath("//p[normalize-space(text()='Doctor Specialization added successfully !!')]")).getText();
	if(confMessage.contains("Doctor Specialization added successfully !!"))
	{
		System.out.println(confMessage);
	}
	else
	{
		System.err.println("-------Failed--------");
	}
	//logout as admin
	driver.findElement(By.xpath("//span[@class='username']")).click();
	driver.findElement(By.partialLinkText("Log Out")).click();
	Thread.sleep(5000);
}
	catch(SocketException se)
		{
		System.out.println("Socket exception occured");
		}
		finally {
			driver.quit();
		}
}
}
