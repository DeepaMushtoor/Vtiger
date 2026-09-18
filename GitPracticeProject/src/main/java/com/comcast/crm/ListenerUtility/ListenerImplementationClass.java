package com.comcast.crm.ListenerUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webDriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {

	public  ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String dateTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
		//SPARK REPORT CONFIGURATION
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReporting/ExtentReport_"+ dateTime+ " .html");
		spark.config().setDocumentTitle("CRM TEST SUITE RESULTS");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.STANDARD);
		
		//ADD ENVIRONMENT INFORMATION AND CREATE TEST     
        UtilityClassObject.setTest(test);                               
		report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-132");
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("========  " + result.getMethod().getMethodName() + "  =======START========");
		 test = report.createTest(result.getMethod().getMethodName());//use listener’s report
		 UtilityClassObject.setTest(test);//use listener’s report
		 test.log(Status.INFO,result.getMethod().getMethodName()+"=====>STARTED<======");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("========  " + result.getMethod().getMethodName() + "=======END=======");
		test.log(Status.PASS,result.getMethod().getMethodName()+"=====>COMPLETED<======");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot)BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		String dateTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
		test.addScreenCaptureFromBase64String(filePath,testName+" "+dateTime);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"=====>FAILED<======");
		
		
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


	
	

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Backup");
		report.flush();
	}

}
