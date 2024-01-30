package com.healthcare.Medvista.Doctor;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
@Listeners(com.genericUtility.ListenerImplimentingClass.class)
public class UpdateDoctorProfileTest extends BaseClass {
	@Test(groups = "Smoke")
public void updateDoctorProfile() throws IOException, InterruptedException {
	//read data from properties file
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String url = p.getProperty("urld");
	String un = p.getProperty("usernamed");
	String pwd = p.getProperty("passwordd");
	
	//launch browser
	WebDriver driver = new ChromeDriver();
	//maximize browser
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	//enter url
	driver.get(url);
	//enter all doctor credential
	driver.findElement(By.name("username")).sendKeys(un);
	driver.findElement(By.name("password")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[normalize-space(text()='Login ')]")).click();
	//click on update profile
	driver.findElement(By.partialLinkText("Update Profile")).click();
	//edit page verification
	String edit = driver.findElement(By.xpath("//h5[text()='Edit Doctor']")).getText();
	if(edit.contains("Edit Doctor"))
	{
		//edit doctor consultency fee
		driver.findElement(By.name("docfees")).sendKeys("2");
		//click on update button
		driver.findElement(By.name("submit")).click();
		//handle the alert popup
		Alert a = driver.switchTo().alert();
		String conupdate=a.getText();
		if(conupdate.contains("Doctor Details updated Successfully"))
{
	System.out.println("Doctor Details updated Successfully");
}
else
{
	System.out.println("-----Failed to update-------");
}
		Assert.fail();
		a.accept();
		//verify edit page is displayed or not
		String editp = driver.findElement(By.xpath("//h1[text()='Doctor | Edit Doctor Details']")).getText();
		
		if(editp.contains("EDIT DOCTOR DETAILS"))
		{
			System.out.println("Edit doctor page is displyed");
		}
		else
		{
			System.out.println("edit doctor details page is not displayed");
		}
		//logout as doctor
		driver.findElement(By.xpath("//span[@class='username']")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Log Out")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
	
}
}
