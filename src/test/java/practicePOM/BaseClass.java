package practicePOM;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
@BeforeSuite(alwaysRun = true)
public void config_suite()
{
	Reporter.log("Before Suite ",true);
}

@BeforeTest(alwaysRun = true)
public void config_test()
{
	Reporter.log("Before Test ",true);
}
@BeforeClass(alwaysRun = true)
public void config_class()
{
	Reporter.log("Before Class",true);
}
@BeforeMethod(alwaysRun = true)
public void config_method()
{
	Reporter.log("Before Method ",true);
}


@AfterSuite(alwaysRun = true)
public void config_aftersuite()
{
	Reporter.log("After Suite ",true);
}

@AfterClass(alwaysRun = true)
public void config_Afterclass()
{
	Reporter.log("After Class ",true);
}

@AfterMethod(alwaysRun = true)
public void config_Aftermethod()
{
	Reporter.log("After Method ",true);
}

@AfterTest
public void config_Aftertest()
{
	Reporter.log("After Test ",true);
}
}
