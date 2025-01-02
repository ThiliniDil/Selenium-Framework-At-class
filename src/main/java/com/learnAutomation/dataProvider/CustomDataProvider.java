package com.learnAutomation.dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	@DataProvider (name="login")
	public static Object[][] readUserDetails(){
		
		Object[][] arr= Excel_Reader.ExcelReader("LoginDetails");
		return arr;
		
	}
		

}
