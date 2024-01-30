package com.TestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.genericUtility.WebDriverUtils;

public class IrctcBusTicketTest {
@Test
public void irctcTest() throws InterruptedException
{
	//disabled notifications
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	//launch chrome browser
	WebDriver driver = new ChromeDriver(opt);
	//using generic web utility
	WebDriverUtils wlib = new WebDriverUtils();
	//maximize window
	wlib.maximizeWindow(driver);
	//enter url
	driver.get("https://www.irctc.co.in/nget/train-search");
	//driver.get("https://www.bus.irctc.co.in/home");
	//wait statement
	wlib.waitforpageLoad(driver, 20);
	//click on buses tab
	driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
	//switching to new window
	wlib.switchToWindow(driver,"IRCTC Bus - Online Bus Ticket Booking | Bus Reservation" );
	//click on depart text field
	driver.findElement(By.id("departFrom")).sendKeys("Bangalore");
	Thread.sleep(3000);
	List<WebElement> all = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
	for(int i=0;i<all.size();i++)
	{
		if(all.get(i).getText().contains("Bangalore"))
		{
			all.get(i).click();
			break;
		}
	}
	//click on dest text field
	driver.findElement(By.id("goingTo")).sendKeys("Chennai");
	Thread.sleep(3000);
	List<WebElement> alldes = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
	for(int i=0;i<alldes.size();i++)
	{
		if(alldes.get(i).getText().contains("Chennai"))
		{
			alldes.get(i).click();
			break;
		}
	}
	Thread.sleep(3000);
	//select date
	driver.findElement(By.xpath("//a[text()='26']")).click();
	//click on search button
	driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
while(true)
{
	try {
	 WebElement ele = driver.findElement(By.xpath("//h4[text()='Departure Time']/ancestor::div[@class='heading-02-wrap']//label[text()='After 6 pm']/parent::li"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Departure Time']/ancestor::div[@class='heading-02-wrap']//label[text()='After 6 pm']/parent::li")));
		//select depart time
		if(ele.isDisplayed())
		{
		ele.click();
		break;
		}
	}
	catch (Exception e) {
		continue;
	}
}
	//search for bus
	driver.findElement(By.xpath("(//label[text()='SRI SUGAM TRAVELS']/following-sibling::p[text()='AC Sleeper (2 + 1)']/ancestor::div[@class='top-search-result-card']/div/following-sibling::div[@class='SearchCard SearchCard07']//button[text()='Select Seat'])[1]")).click();
	//select seat
	while(true)
	{
		try {
			WebElement ele2 = driver.findElement(By.xpath("//span[@title='Seat No. : U3 | Fare : INR 1050.00']"));
			wait.until(ExpectedConditions.elementToBeClickable(ele2));
			if(ele2.isDisplayed())
			{
			ele2.click();
		}
		}
		catch (Exception e) {
			continue;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
