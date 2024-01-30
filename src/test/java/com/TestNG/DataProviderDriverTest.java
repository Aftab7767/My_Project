package com.TestNG;

import org.testng.annotations.Test;

public class DataProviderDriverTest {
public class DPExcnTest
{
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "data")
	public void executeDP(String fname,String lastname)
	{
		System.out.println("First Name----> " + fname + " last name " + lastname);
	}
}
}
