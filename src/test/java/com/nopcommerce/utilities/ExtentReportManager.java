package com.nopcommerce.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends TestListenerAdapter{


	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext) 
	{
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+repname);//specify location of the report
		
		htmlReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		htmlReporter.config().setReportName("Functional Testing"); // name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","pavan");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,IE");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	}
	

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Case SKIIPED  IS " + result.getName());
	}

	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.FAIL, "Test Case FAILED IS " + result.getName());
		
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // SEND LOGS TO REPORTS
		
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		try
		{
			test.addScreenCaptureFromPath(screenshotpath);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}
