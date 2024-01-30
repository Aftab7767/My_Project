package com.healthcare.Medvista.Admin;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class RetryAnalyzerDemo extends BaseClass {
	@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
	public void testDemo()
	{
		Assert.assertEquals('A', 'B');
	}

}
