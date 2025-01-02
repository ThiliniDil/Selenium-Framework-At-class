package com.learnAutomation.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learnAutomation.dataProvider.ConfigFile_Reader;
import com.learnAutomation.helper.Utility;

public class ExtentManager {
	
	public static ExtentReports extent;
	public static ExtentReports getInstance() 
	{
		if(extent==null)
		{
		
			 extent=createInstance();
			 return extent;
		}
		
		else {
			return extent;
		}
		
		
	}
	
	public static ExtentReports createInstance() {
		ExtentSparkReporter extentSparker=new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/Automation_"+Utility.getTheDateAndTime()+".html");
		extentSparker.config().setTheme(Theme.DARK);
		extentSparker.config().setDocumentTitle(ConfigFile_Reader.getProperty("DocumentTitle"));
		extentSparker.config().setReportName(ConfigFile_Reader.getProperty("ReportName"));
		
		  extent=new ExtentReports();
		 extent.attachReporter(extentSparker);
		 return extent;
	}

}
