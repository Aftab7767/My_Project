package com.healthcare.Medvista.Doctor;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest {
@BeforeSuite
public void connectDB()
{
	Reporter.log("----Connect to DataBase----",true);
}
@BeforeSuite
public void connectDB1()
{
	Reporter.log("----Connect to DataBase1----",true);
}
@BeforeClass
public void launchBrowser()
{
	Reporter.log("---Launch the Browser----",true);
}
@BeforeClass
public void launchBrowser0()
{
	Reporter.log("---Launch the Browser0----",true);
}
@BeforeClass
public void launchBrowser1()
{
	Reporter.log("---Launch the Browser1----",true);
}
@BeforeMethod
public void loginToapp()
{
	Reporter.log("-----Login to the applicapn-----",true);
}
@BeforeMethod
public void loginToapp1()
{
	Reporter.log("-----Login to the applicapn1-----",true);
}
@BeforeMethod
public void loginToapp2()
{
	Reporter.log("-----Login to the applicapn2-----",true);
}
@AfterClass
public void closeBrowser()
{
	Reporter.log("----Close the browser-----",true);
}
@AfterMethod
public void logoutToApp() {
	Reporter.log("----Log out from application----",true);
}
@AfterMethod
public void logoutToApp1() {
	Reporter.log("----Log out from application1----",true);
}
@AfterSuite
public void closeDB()
{
	Reporter.log("----Disconnect to the Data base-----",true);
}
@Test
public void addSpecialization()
{
	Reporter.log("----Specialization added-----",true);
}
@Test
public void addDoctor()
{
	Reporter.log("====Doctor Added Sucessfully=====",true);
}
@BeforeTest
public void btest()
{
	Reporter.log("===Before test====",true);
}
@AfterTest
public void atest()
{
	Reporter.log("====After test=====",true);
}

}
