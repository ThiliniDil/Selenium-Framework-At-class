package com.learnAutomation.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnAutomation.constantMsg.ConstantMsg;
import com.learnAutomation.dataProvider.CustomDataProvider;
import com.learnAutomation.helper.BaseClass;
import com.learnAutomation.pages.LoginPO;

public class LoginTest extends BaseClass {
	
	
	
	@Test(dataProvider = "login" ,dataProviderClass = CustomDataProvider.class)	
	public void UserWithInvalidUserName(String userName,String pwd) {
		LoginPO lo=new LoginPO(driver);
		lo.navigateHomePage(userName, pwd);
		Assert.assertTrue(lo.errorMessgeVerification().contains(ConstantMsg.invalidUserName));
		
		/*
	
	@Test(dataProvider = "login" ,dataProviderClass = CustomDataProvider.class)	
	public void loginPage(String username,String pwd) {
		
		
		LoginPO lo=new LoginPO(driver);
		lo.navigateHomePage(username,pwd );
		
	}
	@Test	
	public void UserWithoutUserNamePWD() {
		LoginPO lo=new LoginPO(driver);
		lo.navigateHomePage("", "");
		Assert.assertTrue(lo.errorMessgeVerification().contains(ConstantMsg.EmptyUnamePass));

		
	}
	
			
		
	}
	
	@Test(dataProvider = "login" ,dataProviderClass = CustomDataProvider.class)	
	public void UserWithInvalidUserNamePWD(String userName,String pwd) {
		LoginPO lo=new LoginPO(driver);
		lo.enterDetail(userName, pwd);
		Assert.assertTrue(lo.errorMessgeVerification().contains(ConstantMsg.UserNamepwdMismatch));
	
		
		
	}
	@Test(dataProvider = "login" ,dataProviderClass = CustomDataProvider.class)	
	public void WithoutPWD(String userName,String pwd) {
		LoginPO lo=new LoginPO(driver);
		lo.enterDetail(userName, pwd);
		Assert.assertTrue(lo.errorMessgeVerification().contains(ConstantMsg.withoutPwd));
		
		
		
	}
	
	*/
	
	
	

}
}