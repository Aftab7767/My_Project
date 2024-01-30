package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.genericUtility.WebDriverUtils;

public class IRCTC {
public static void main(String[] args) {
	WebDriverUtils wlib = new WebDriverUtils();
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(opt);
	wlib.maximizeWindow(driver);
	wlib.waitforpageLoad(driver, 50);
	driver.get("https://www.bus.irctc.co.in/home");
	driver.findElement(By.id("departFrom")).sendKeys("bangalore");
	driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
	driver.findElement(By.id("goingTo")).sendKeys("chennai");
	driver.findElement(By.xpath("//div[text()='Chennai']")).click();
	driver.findElement(By.id("departDate")).click();
}
}
