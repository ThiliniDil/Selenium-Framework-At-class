package com.learnAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnAutomation.helper.Utility;

public class LoginPO {
	
	protected WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By userName=By.id("email1");
	private By Password=By.id("password1");
	private By btn_submit=By.className("submit-btn");
	private By errormsg= By.className("errorMessage");
	
	
		
	public HomePO navigateHomePage(String userNm,String PassWd) {
		Utility.waitForWedElemet(driver, userName).sendKeys(userNm);
		Utility.waitForWedElemet(driver, Password).sendKeys(PassWd);
		Utility.waitForWedElemet(driver, btn_submit).click();		
		HomePO hpo=new HomePO();
		return hpo;
		
		
	}
	
	public String errorMessgeVerification() {
		
		String error=Utility.waitForWedElemet(driver, errormsg).getText();
		return error;
		
	}
	
	

}
