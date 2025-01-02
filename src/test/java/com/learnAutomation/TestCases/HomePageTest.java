package com.learnAutomation.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnAutomation.helper.BaseClass;

public class HomePageTest extends BaseClass{
	
	@Test 
	public void verifyTitle() {
		Assert.assertTrue(driver.getTitle().contains("Learn Automation Courses"));
	}


}
