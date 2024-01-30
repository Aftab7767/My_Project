package com.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer {
int count =0;    //lower limit
int retrycount =3;  //upper limit
@Override
public boolean retry(ITestResult result) {
	if(retrycount>count)
	{
		count++;
		return true;
	}
	return false;
}
}
