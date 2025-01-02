package com.learnAutomation.listners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnAutomation.factory.Factory;
import com.learnAutomation.helper.Utility;

public class ExtentTestNGITestListner  implements ITestListener{
		
	ExtentReports extent= ExtentManager.getInstance();
	//ExtentTest extentTest;//Here We have only one reference
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>(); //For MultipleTest
	
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
		System.out.println("LOG:INFO -Test started!! "+ result.getMethod().getMethodName());
	  }
	
	 public synchronized void onFinish(ITestContext context) {
		 extent.flush();
		 System.out.println("LOG-FINISHED "+context.getName());
		  }
	
	public synchronized  void onTestSuccess(ITestResult result) {
	parentTest.get().pass("Test Passed");
	  System.out.println("LOG:PASS - Test Passed!! "+ result.getMethod().getMethodName());
	  }
	
	 public synchronized void onTestFailure(ITestResult result) {
		 String screenShot= Utility.TakeScreenShotForListner(Factory.getDriver() );
		parentTest.get().fail("Test Failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot,"Test Failed").build());
		 System.out.println("LOG:FAIL - Test Failed!! "+ result.getMethod().getMethodName());
		 System.out.println("Exception Trace"+result.getThrowable().getMessage());
		  }
	 
	 public synchronized void onTestSkipped(ITestResult result) {
		parentTest.get().skip("test Skipped"+result. getThrowable().getMessage());
		 System.out.println("LOG:SKIP - Test Skipped!! "+ result.getMethod().getMethodName());
		 System.out.println("Exception Trace "+result.getThrowable().getMessage());		    
		  }

}
