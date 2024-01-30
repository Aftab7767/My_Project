package com.healthcare.Medvista.Doctor;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;
//@Listeners(com.genericUtility.ListenerImplimentingClass.class)
public class PatientEndToEndScenarioTest extends BaseClass
{
	@Test(groups = {"Smoke","Regression"})
	public  void PatientEndToEndScenarioTest () throws IOException, InterruptedException
	{
	WebDriver driver;
	FileInputStream fis;
	Properties p;
	String pUsername=null,pPassword=null;
	//object creation of all generic class
	WebDriverUtils wlib = new WebDriverUtils();
	ExcelUtils elib = new ExcelUtils();
	FileUtils flib = new FileUtils();
	JavaUtils jlib = new JavaUtils();
	
	      int r = jlib.getRabdomNumber(500);
		/*Random random = new Random();
		int r = random.nextInt(5000);*/
		//read the data from properties file
		/*fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
        p = new Properties();
		p.load(fis);
		String url = p.getProperty("urlp");*/
	     String url = flib.readDataFromPropertyFile("url");
		//create one empty hashMap
		/*HashMap< String, String> hs = new HashMap<String, String>();
		//fetching the data from excel file
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test_Doctor.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Patient");
		int lastr = sh.getLastRowNum();
		for(int i=0;i<=lastr;i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value =sh.getRow(i).getCell(1).getStringCellValue();
			hs.put(key, value);
		}*/
	    HashMap<String, String> hs = elib.hashMapData("Patient");
		
		//launch browser
		driver=new ChromeDriver();
		//maximize browser
		wlib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		//wait statement
		wlib.waitforpageLoad(driver, 20);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//enter url
		driver.get(url);
		//click on user login link
		driver.findElement(By.xpath("//h3[text()='Patients']/..//a[text()='Click Here']")).click();
		//click on user registration link
		driver.findElement(By.partialLinkText("Create an account")).click();
		//enter all details of new user
	   // String neww=null;
      //	String key=null;
      	String pusername=null;
      	String ppassword=null;
      	String pname=null;
		for(Entry<String, String> s:hs.entrySet())
		{		if(s.getKey().contains("email"))
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
		
			//neww = s.getValue()+r;
			// key = s.getKey();
		//driver.findElement(By.name(key)).sendKeys(neww);
			Thread.sleep(2000);
		}
		System.out.println(pusername+" : "+ppassword);
		driver.findElement(By.xpath("//label[@for='rg-male']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		//handle confirmation popup
		Alert a = driver.switchTo().alert();
		String confirm = a.getText();
		if(confirm.contains("Successfully Registered. You can login now"))
		{
			a.accept();
			System.out.println("Successfully Registered. You can login now");
		}
		else
		{
			System.out.println("----user not registered successfully------");
		}
		//click on login link
		driver.findElement(By.partialLinkText("Log-in")).click();
		Thread.sleep(3000);
		//enter user credential
		driver.findElement(By.name("username")).sendKeys(pusername);
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys(ppassword);
		Thread.sleep(3000);
		//click on login link
		driver.findElement(By.name("submit")).click();
		//click on book appointment link
		driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();
		//verify book appointment page
		String bookappoint = driver.findElement(By.xpath("//h1[text()='User | Book Appointment']")).getText();
		if(bookappoint.contains("USER | BOOK APPOINTMENT"))
		{
			System.out.println("USER | BOOK APPOINTMENT page is displayed");
		}
		else
		{
			System.out.println("----Failed Appointment-------");
		}
		//booking an appointment
		//select doctor specialization
		WebElement spcl = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		Select s = new Select(spcl);
		s.selectByValue("Dentist");
		//select doctor name
		WebElement doc = driver.findElement(By.xpath("//select[@name='doctor']"));
		Select s1=new Select(doc);
		s1.selectByVisibleText("Aftab");
		//select date
		driver.findElement(By.xpath("//input[@name='appdate']")).click();
		while(true)
		{
		try {
			driver.findElement(By.xpath("//span[text()='Mar']/ancestor::div[@class='datepicker-months']/preceding-sibling::div[@class='datepicker-days']//td[text()='25']")).click();
			
			break;
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//th[@class='next']")).click();
		}
		}
		//select time
		driver.findElement(By.xpath("//input[@name='apptime']")).clear();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']")).sendKeys("03",Keys.TAB,"40",Keys.TAB,"pm");
		
		//click on submit button
		driver.findElement(By.name("submit")).click();
		//verify booking
		 a = driver.switchTo().alert();
		String text = a.getText();
		if(text.contains("Your appointment successfully booked"))
		{
			System.out.println("Your appointment successfully booked");
		}
		else
		{
			System.out.println("------failed to book appointment------");
		}
		a.accept();
		//logout as patient
		driver.findElement(By.xpath("//span[@class=\"username\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Log Out")).click();
		//click on doctor login link
		driver.findElement(By.xpath("//h3[text()='Doctors Login']/ancestor::div[@class='text list_1_of_2']//a[text()='Click Here']")).click();
		//enter doctor credential
		driver.findElement(By.name("username")).sendKeys("aftab@hms.com");
		driver.findElement(By.name("password")).sendKeys("aftab@123");
		driver.findElement(By.name("submit")).click();
		//navigate to appointment history
		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
		//verify appointment
		List<WebElement> appoint = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		for(int i=0;i<appoint.size();i++)
		{
			String pat = appoint.get(i).getText();
			if(pat.contains(pname))
			{
				System.out.println("Appointment successgully done");
				break;
			} 
		}
		Assert.fail();
		//logout as doctor
		driver.findElement(By.xpath("//span[@class='username']")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Log Out")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
