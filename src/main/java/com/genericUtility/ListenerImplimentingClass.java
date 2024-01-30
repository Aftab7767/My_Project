package com.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentingClass extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		//Test script execution Start from here
		String methodName= result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+" Execution Started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + " Passed");
		Reporter.log(methodName + " Executed Sucessfully",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		try {
		String path = WebDriverUtils.takeScreenShot(BaseClass.sdriver, methodName);
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, methodName + " Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(methodName+"------>Failed",true);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName + " Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+" -------->Skipped",true);
		
	}
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		JavaUtils jlib = new JavaUtils();
		//configure the reports(look and feel of the report)
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".//CustomizedReport//report"+jlib.getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("SDET-53");
		htmlreport.config().setReportName("HMS-Medvista");
		htmlreport.config().setTheme(Theme.STANDARD);
		
		//content of the report
	    report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Platform", "OS");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Url", "http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("Reporter name", "Aftab");	
	}

	@Override
	public void onFinish(ITestContext context) {
		//delete old report 
		report.flush();
	}

}
