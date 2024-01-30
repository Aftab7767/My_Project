package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepoPom.MainHomePage;
import com.ObjectRepoPom.adminModule.AdminLoginPage;
import com.ObjectRepoPom.adminModule.AdminLogoutPage;

public class BaseClass {
	
//create object for utility classes
 public WebDriver driver;	
 public DatabaseUtils dlib=new DatabaseUtils();
 public FileUtils flib = new FileUtils();
 public JavaUtils jlib = new JavaUtils();
 public ExcelUtils elib = new ExcelUtils();
 public WebDriverUtils wlib = new WebDriverUtils();
 public static WebDriver sdriver;

@BeforeSuite(alwaysRun = true)
public void confif_BS() throws Throwable
{
	dlib.connectToDB();
	System.out.println("-----connect to the database-------");
}
//@Parameters("BROWSER")
@BeforeClass(alwaysRun = true)
public void config_BC() throws IOException
{
	String BROWSER = flib.readDataFromPropertyFile("browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
//	else if (BROWSER.equalsIgnoreCase("firefox"))
//	{
//		driver= new FirefoxDriver();
//	}
//	else
//	{
//		driver=new EdgeDriver();
//	}
	sdriver=driver;
	wlib.maximizeWindow(driver);
	wlib.waitforpageLoad(driver, 20 );
	
	System.out.println("--Launch browser--");
}
@BeforeMethod(alwaysRun = true)
public void config_BM() throws IOException, InterruptedException
{
	String url = flib.readDataFromPropertyFile("url");
	String un = flib.readDataFromPropertyFile("username");
	String pwd = flib.readDataFromPropertyFile("password");
	driver.get(url);
	MainHomePage mp = new MainHomePage(driver);
	mp.adminLoginLink();
	AdminLoginPage alp=new AdminLoginPage(driver);
	alp.setAdminLogin(un, pwd);
	System.out.println("--Logged in--");
	Thread.sleep(2000);
}
@AfterMethod(alwaysRun = true)
public void config_AM()
{
	AdminLogoutPage alogout= new AdminLogoutPage(driver);
	alogout.adminLogout(driver);
	System.out.println("--Logged out--");
}
@AfterClass(alwaysRun = true)
public void config_AC() throws InterruptedException
{
	Thread.sleep(2000);
	driver.quit();
	System.out.println("--close browser--");
}

@AfterSuite
public void config_AS() throws Throwable, InterruptedException
{
	Thread.sleep(2000);
	dlib.closeDatabaseConnection();
	System.out.println("--close DB--");
}

}
