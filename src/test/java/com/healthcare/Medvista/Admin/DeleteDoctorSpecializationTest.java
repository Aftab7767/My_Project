package com.healthcare.Medvista.Admin;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ObjectRepoPom.MainHomePage;
import com.ObjectRepoPom.adminModule.AddDoctorSpecilaizationPage;
import com.ObjectRepoPom.adminModule.AdminDashboardPage;
import com.ObjectRepoPom.adminModule.AdminLoginPage;
import com.ObjectRepoPom.adminModule.AdminLogoutPage;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

public class DeleteDoctorSpecializationTest {
public static void main(String[] args) throws IOException {
	FileUtils flib = new FileUtils();
	WebDriver driver = new ChromeDriver();
	WebDriverUtils wlib = new WebDriverUtils();
	AdminDashboardPage ad = new AdminDashboardPage(driver);
	AdminLoginPage alp = new AdminLoginPage(driver);
	AdminLogoutPage aout = new AdminLogoutPage(driver);
	MainHomePage mp = new MainHomePage(driver);
	AddDoctorSpecilaizationPage asp = new AddDoctorSpecilaizationPage(driver);
	wlib.maximizeWindow(driver);
	wlib.waitforpageLoad(driver, 400);
	driver.get(flib.readDataFromPropertyFile("url"));
	mp.adminLoginLink();
	alp.setAdminLogin(flib.readDataFromPropertyFile("username"), flib.readDataFromPropertyFile("password"));
	ad.clickDoctorButton();
	ad.getTotalDoctorLink().click();
	//ad.clickDocSpecialization();
	//Script to delete the doctor specialization
	//List<WebElement> all = asp.getDeleteSpecialization();
	//Script to delete the doctor list
	List<WebElement> all = asp.getDeleteDoctorList();
	for(int i=0;i<all.size();i++)
	{
		all.get(i).click();
		wlib.accepAlertPopup(driver);
		//all = asp.getDeleteSpecialization();
		System.out.println(i);
		if(all.size()>0)
		{
			continue;
		}
		
	}
	
	aout.adminLogout(driver);
	driver.quit();
	
}
}
