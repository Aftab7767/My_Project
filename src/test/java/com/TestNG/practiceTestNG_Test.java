package com.TestNG;

import org.testng.annotations.Test;

public class practiceTestNG_Test {
@Test(enabled = false)
public void addDocSpecialization()
{
	System.out.println("----add doctor Specialization-----");
}
@Test(priority = 0)
public void manageSpecialization()
{
	System.out.println("----Edit specialization------");
}
@Test(dependsOnMethods = "addDocSpecialization" )
public void deleteSpecialization()
{
	System.out.println("-----delete Specialization--------");
}
}
