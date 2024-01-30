package com.healthcare.Medvista.Admin;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.ObjectRepoPom.MainHomePage;
import com.ObjectRepoPom.adminModule.AddDoctorSpecilaizationPage;
import com.ObjectRepoPom.adminModule.AdminDashboardPage;
import com.ObjectRepoPom.adminModule.AdminLoginPage;
import com.ObjectRepoPom.adminModule.AdminLogoutPage;
import com.genericUtility.BaseClass;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;
@Listeners(com.genericUtility.ListenerImplimentingClass.class)
public class SpecializationPomTest extends BaseClass {
	@Test
public  void SpecializationPomTest() throws IOException {
	
	//FileUtils flib = new FileUtils();
	//WebDriverUtils wlib = new WebDriverUtils();
	JavaUtils jlib = new JavaUtils();
	
	//get random number
	int r = jlib.getRabdomNumber(500);
	String Sp = "Dentist";
	
	//read data from properties file
	//String url = flib.readDataFromPropertyFile("url");
	//String un = flib.readDataFromPropertyFile("username");
	//String pwd = flib.readDataFromPropertyFile("password");
	
	//launch browser
	//WebDriver driver = new ChromeDriver();
	
	//maximize browser
//	wlib.maximizeWindow(driver);
	
	//implicit wait
	//wlib.waitforpageLoad(driver, 20);
	
	// click on adminlogin link 
	//MainHomePage page = new MainHomePage(driver);
	//driver.get(url);
	//page.adminLoginLink();
	
	//admin login
	//AdminLoginPage alp=new AdminLoginPage(driver);
	//alp.setAdminLogin(un, pwd);
	
	//add doctor Specialization
	AdminDashboardPage ad = new AdminDashboardPage(driver);
	String actual1 = ad.getDashBoardText().getText();
	String expected1 = "DashBoard";
	SoftAssert a = new SoftAssert();
	a.assertEquals(actual1, expected1);
	System.out.println("Hii Aftab!!!!!!");
	ad.clickDoctorButton();
	ad.clickDocSpecialization();
	AddDoctorSpecilaizationPage ap=new AddDoctorSpecilaizationPage(driver);
	ap.addSpecialization(Sp+r);
	List<WebElement> all = ap.getSpecializationList();
	boolean flag = false;
	for(int i =0;i<=all.size();i++)
	{
		 String actual = all.get(i).getText();
		 String expected = Sp;
		Assert.assertEquals(actual, expected, "====Specialization is not created=====");
		
		if(all.get(i).getText().contains(Sp+r))
		{
			System.out.println("Specialization added sucessfully");
			flag = true;
			break;
		}
	}
	if(flag == false)
	{
		System.out.println("Specialization is not Added");
	}
	
	//admin logout
	//AdminLogoutPage al=new AdminLogoutPage(driver);
	//al.adminLogout(driver);
	//driver.quit();
}
}
