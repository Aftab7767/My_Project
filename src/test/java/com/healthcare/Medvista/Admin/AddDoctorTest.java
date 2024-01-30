package com.healthcare.Medvista.Admin;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepoPom.MainHomePage;
import com.ObjectRepoPom.adminModule.AdminDashboardPage;
import com.ObjectRepoPom.adminModule.AdminLoginPage;
import com.ObjectRepoPom.adminModule.AdminLogoutPage;
import com.genericUtility.BaseClass;
import com.genericUtility.IpathConstant;
import com.genericUtility.IpathConstant;
import com.genericUtility.JavaUtils;
import com.healthcare.Medvista.Doctor.ExcelWriteGeneric;
@Listeners(com.genericUtility.ListenerImplimentingClass.class)
public class AddDoctorTest extends BaseClass {
	//FileUtils flib = new FileUtils();
	
	//ExcelUtils elib = new ExcelUtils();
	//WebDriverUtils wlib = new WebDriverUtils();
	@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
public  void addDoctor() throws IOException, InterruptedException {
	//for getting random value 
		try {
		int r = jlib.getRabdomNumber(5000);
	/*Random random = new Random();
	int r = random.nextInt(5000);*/
	//fetching data from properties file
//		String url=flib.readDataFromPropertyFile("url");
//		String un=flib.readDataFromPropertyFile("username");
//		String pwd =flib.readDataFromPropertyFile("password");
	
	/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String url = p.getProperty("url");
	String un = p.getProperty("username");
	String pwd = p.getProperty("password");*/
	/*//create empty map
	HashMap< String, String> hm= new HashMap<String, String>();
	//fetching data from excel file
	FileInputStream f = new FileInputStream(".\\src\\test\\resources\\Test_Doctor.xlsx");
	Workbook wb = WorkbookFactory.create(f);
	Sheet sh = wb.getSheet("Doctor");
	int lastrow = sh.getLastRowNum();
	//storing data int HashMap
	for(int i =0;i<=lastrow;i++)
	{
		String key = sh.getRow(i).getCell(0).getStringCellValue();
		String value = sh.getRow(i).getCell(1).getStringCellValue();
		hm.put(key, value);
	}*/
	//launch browser
//	WebDriver driver = new ChromeDriver();
//	//maximize browser
//	wlib.maximizeWindow(driver);
//	wlib.waitforpageLoad(driver, 20);
	/*driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));*/
	//enter url
	//driver.get(url);
//	MainHomePage mp = new MainHomePage(driver);
	//click on admin login link
//	mp.adminLoginLink();
  //driver.findElement(By.xpath("//h3[text()='Admin Login']/../div//a[text()='Click Here']")).click();
	//enter admin login credential
//	AdminLoginPage alp= new AdminLoginPage(driver);
//	alp.setAdminLogin(un, pwd);
//	driver.findElement(By.name("username")).sendKeys(un);
//	driver.findElement(By.name("password")).sendKeys(pwd);
//	driver.findElement(By.name("submit")).click();
	//click on doctor tab
	AdminDashboardPage adp = new AdminDashboardPage(driver);
	adp.clickDoctorButton();
	Thread.sleep(2000);
	adp.clickAddDoctor();
	//driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
	//Thread.sleep(5000);
	//click on add doctor
	//driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();
	//select doctor specialization
		WebElement splList = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		List<WebElement> all = wlib.getalldataofDropdown(splList);
		/*Select s = new Select(splList);
		List<WebElement> allSpecialization = s.getOptions();
		String text=null;
		for(int i=0;i<allSpecialization.size();i++)
		{
			text = allSpecialization.get(i).getText();
		}
		s.selectByValue(text);*/
		String text=null;
		for(int i=0;i<all.size();i++)
		{
			text=all.get(i).getText();
		}
		System.out.println(text);
		wlib.select(splList, text);
		String docusername=null;
		String docpassword=null;
		String docName= null;
		String docfees=null;
		String cfpass=null;
		String clinicaddress=null;
		String doccontact=null;
		HashMap<String, String> hm = elib.hashMapData("Doctor");
	for(Entry<String,String>s1:hm.entrySet())
	{
		if(s1.getKey().contains("docemail"))
		{
			docusername=s1.getValue()+r+"@hms.com";
			driver.findElement(By.name(s1.getKey())).sendKeys(docusername);
		}
		else if (s1.getKey().contains("npass")) {
			docpassword=s1.getValue()+r;
			driver.findElement(By.name(s1.getKey())).sendKeys(docpassword);
		}
		else if(s1.getKey().contains("docname"))
		{
			docName=s1.getValue()+r;
			driver.findElement(By.name(s1.getKey())).sendKeys(docName);
		}
		else if (s1.getKey().contains("cfpass")) {
			cfpass=s1.getValue()+r;
			driver.findElement(By.name(s1.getKey())).sendKeys(cfpass);
		} 
		else if (s1.getKey().contains("clinicaddress")) {
			clinicaddress=s1.getValue()+r;
			driver.findElement(By.name(s1.getKey())).sendKeys(clinicaddress);
		}
		else if (s1.getKey().contains("doccontact"))
		{
			doccontact=s1.getValue()+r;
			driver.findElement(By.name(s1.getKey())).sendKeys(doccontact);
		}
		else if(s1.getKey().contains("docfees"))
		{
			docfees=s1.getValue()+r;
			driver.findElement(By.name(s1.getKey())).sendKeys(docfees);
		}
//		String values = s1.getValue()+r;
//		String key=s1.getKey();
//		driver.findElement(By.name(s1.getKey())).sendKeys(values);
		Thread.sleep(2000);

	}
	driver.findElement(By.xpath("//button[@name='submit']")).click();
	wlib.waitforAlertisPresent(driver, 20);
	//Thread.sleep(2000);
	Alert a = driver.switchTo().alert();
	String conmessage = a.getText();
	if(conmessage.contains("Doctor info added Successfully"))
	{
		System.out.println("Doctor info added Successfully " + " doctor username is: " + docusername +  " doctor password is : " + docpassword);
	}
	else
	{
		System.err.println("---Failed Process------");
	}
	a.accept();
	//Assert.fail();
//	ExcelWriteGeneric ewg = new ExcelWriteGeneric();
//	ewg.writeData("Doctor_Name", docName, "Sheet2");
	HashMap< String , String> hs = new HashMap<String, String>();
	hs.put("Doctor Name", docName);
	hs.put("Doctor email",docusername);
	hs.put("Doctor Contact Number", doccontact);
	hs.put("Doctor Password", docpassword);
	hs.put("Doctor Address", clinicaddress);
	hs.put("Doctor fees", docfees);
	FileInputStream fis = new FileInputStream(IpathConstant.EXCELFILEPATH);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.createSheet("Doctor"+r);
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
	
	//doctor verification
	List<WebElement> alldoc = driver.findElements(By.xpath("//tbody/tr/td[3]"));
	for(int i=0;i<alldoc.size();i++)
	{
		String doc = alldoc.get(i).getText();
		if(doc.contains(docName))
		{
			System.out.println("Doctor found ------>" + docName);
		}
	}
	//logout as admin
	//AdminLogoutPage alogout= new AdminLogoutPage(driver);
	//alogout.adminLogout(driver);
//		driver.findElement(By.xpath("//span[@class='username']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.partialLinkText("Log Out")).click();
	//close browser
		//driver.quit();
		}
		catch (SocketException e) {
			e.printStackTrace();
		}
	
}
}
