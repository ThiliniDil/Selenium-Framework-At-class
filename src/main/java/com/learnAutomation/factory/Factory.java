package com.learnAutomation.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.learnAutomation.dataProvider.ConfigFile_Reader;

public class Factory {
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	/*
	 * This method is used start Browser object with different browsers
	 * @param=browserName
	 * @param=Application url
	 * @return= webdriver reference 
	 */
		public static WebDriver startBrowser(String browserName,String applicationURL) {
			
			
			if(browserName.equalsIgnoreCase("Google Chrome")||browserName.equalsIgnoreCase("Chrome")||browserName.equalsIgnoreCase("GC")) 
			{
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				
				ChromeOptions opt=new ChromeOptions();
				if(ConfigFile_Reader.getProperty("headless").contains("true")) {
				opt.addArguments("--headless=new");
				}
				driver=new ChromeDriver(opt);
				
			}
			
			else if(browserName.equalsIgnoreCase("Edge")||browserName.equalsIgnoreCase("Microsoft Edge")) {
				EdgeOptions opt=new EdgeOptions();
				if(ConfigFile_Reader.getProperty("headless").contains("true")) {
					opt.addArguments("--headless=new");
				}
				driver= new EdgeDriver(opt);		
			}
			else if(browserName.equalsIgnoreCase("FireFox")||browserName.equalsIgnoreCase("FF")) {
				
				FirefoxOptions opt=new FirefoxOptions();
				if(ConfigFile_Reader.getProperty("headless").contains("true")) {
					opt.addArguments("--headless=new");
				}
				driver=new FirefoxDriver(opt);
			}
			else {
				System.out.println("Sorry ubable to find the "+browserName+".Please try againg with correct browser name ");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigFile_Reader.getProperty("pageLoad"))));
			
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Integer.parseInt(ConfigFile_Reader.getProperty("scriptTimeOut"))));
			driver.get(applicationURL);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigFile_Reader.getProperty("implicitWait"))));
			
			return driver;
		}

	}


