package com.learnAutomation.helper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnAutomation.dataProvider.ConfigFile_Reader;
import com.learnAutomation.factory.Factory;

public class BaseClass {
	
	public WebDriver driver;
	@BeforeClass
	public void setUp() {
		 driver=Factory.startBrowser(ConfigFile_Reader.getProperty("browser"), ConfigFile_Reader.getProperty("url"));
	
	}

	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
