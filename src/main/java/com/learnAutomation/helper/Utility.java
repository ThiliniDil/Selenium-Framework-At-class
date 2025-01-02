package com.learnAutomation.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnAutomation.dataProvider.ConfigFile_Reader;

public class Utility {
	/*	
	public static WebDriver startBrowser(String browserName,String applicationURL) {
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("Google Chrome")||browserName.equalsIgnoreCase("Chrome")||browserName.equalsIgnoreCase("GC")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Edge")||browserName.equalsIgnoreCase("Microsoft Edge")) {
			driver= new EdgeDriver();		
		}
		else if(browserName.equalsIgnoreCase("FireFox")||browserName.equalsIgnoreCase("FF")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Sorry ubable to find the "+browserName+".Please try againg with correct browser name ");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.get(applicationURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
*/
	
	public static void selectList(WebDriver driver,String locator,String value) {
		List <WebElement> allSuggetion=driver.findElements(By.xpath(locator));
		
		System.out.println("Number of auto Suggtions are: "+allSuggetion.size());
		
		for (WebElement ele:allSuggetion)
		{
			if(ele.getText().contains(value)) {
				ele.click();
				break;
			}
			
		}
		
			
	}
	
	
	//in above code , we should parse the Xpath . assume if user need to parse ID,Class name or CSS..etc , we can use below code
	
	//Method Overloading 
			
	public static void selectList(WebDriver driver,By locator,String value) {
		List <WebElement> allSuggetion=driver.findElements(locator);
		
		System.out.println("Number of auto Suggtions are: "+allSuggetion.size());
		
		for (WebElement ele:allSuggetion)
		{
			if(ele.getText().contains(value)) {
				ele.click();
				break;
			}
			
		}
		
			
	}
	
	
	//For calendar date Picker 
	
	public static void datePicker(WebDriver driver,By calenderLoc, String dt ) {

		List<WebElement> date=driver.findElements(calenderLoc);
		
		for(WebElement ele:date) {
			if(ele.getText().contains(dt)) {
				ele.click();
				break;
			}
		}
	}
	
	//for next month of the calendar 
	//For calendar date Picker 
	
		public static void nextdatePicker(WebDriver driver,By calenderdatesLoc, String dt,By nextMonth ) throws InterruptedException {
			
			
			driver.findElement(nextMonth).click();
			Thread.sleep(2000);
			List<WebElement> date=driver.findElements(calenderdatesLoc);
			
			for(WebElement ele:date) {
				if(ele.getText().contains(dt)) {
					ele.click();
					break;
				}
			}
		}
		
		public static void waitForAlert(WebDriver driver)  {
			//wait for the alert displays 
			for (int i=0;i<15;i++) {
				try
				{
					System.out.println("The dispalyed text of the alert is: "+driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();
					//Thread.sleep(1000);
					break;
				} 
				
				catch (NoAlertPresentException e) 
				{
					try {
						Thread.sleep(1000);
					}
					catch(Exception e1) {
					
					}
					System.out.println("Sorry the alert not present - Retry");
				}
			}
			
						
		}
		
		// Without hard-coding the wait time 
		public static void waitForAlert(WebDriver driver,int second)  {
			//wait for the alert displays 
			for (int i=0;i<second;i++) {
				try
				{
					System.out.println("The dispalyed text of the alert is: "+driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();
					//Thread.sleep(1000);
					break;
				} 
				
				catch (NoAlertPresentException e) 
				{
					try {
						Thread.sleep(1000);
					}
					catch(Exception e1) {
					
					}
					System.out.println("Sorry the alert not present - Retry");
				}
			}
			
						
		}
		
		public static Alert waitForAlertWithAlertFunctions(WebDriver driver,int second)  {
			//wait for the alert displays and do the all function(Dismiss,Accept,GetText and sendKeys(if we have prompt
			
			Alert alt=null;
			for (int i=0;i<second;i++) {
				try
				{
					System.out.println("The dispalyed text of the alert is: "+driver.switchTo().alert().getText());
					 alt=driver.switchTo().alert();
					//Thread.sleep(1000);
					break;
				} 
				
				catch (NoAlertPresentException e) 
				{
					try {
						Thread.sleep(1000);
					}
					catch(Exception e1) {
					
					}
					System.out.println("Sorry the alert not present - Retry");
				}
			}
			return alt;
			
			
			
						
		}
		
		/*To Set the Date and time of the screenShot to avoid the override the existing screenshot
		 * @Return: Formated Date and Time 
		 */
		public static String getTheDateAndTime() {
			String DateTime=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss").format(new Date());
			return DateTime;
		}
		
		/*
		 * To save the screen shot at the specified location
		 * @para: Webdriver Instance
		 */
		public static void CaptureFullScreenShot(WebDriver driver) {
			TakesScreenshot ts=(TakesScreenshot) driver;

			try {
				FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File(".\\ScreenShot\\ScreenShot"+getTheDateAndTime()+".png"));
			} catch (IOException e) {
				
				System.out.println("Found Exception "+e.getMessage());
			}
		}
		
		
		/*
		 * To capture the Screenshot for Listener  with File type Base64
		 * @Param :WebDriver instance
		 * @Return: The Base64 File for listener
		 */
		public static String TakeScreenShotForListner(WebDriver driver) {
			TakesScreenshot ts=	(TakesScreenshot)driver;
			String ScreenShot=ts.getScreenshotAs(OutputType.BASE64);
			return ScreenShot;
			
		}
		
		/* To capture the WebElement Of the Page 
		 * @param: WebDriver instance
		 * @param: The WebElement which need to take the screen shot
		 */
		public static void captureWebElemet(WebDriver driver,By webElement) {
			File src=driver.findElement(webElement).getScreenshotAs(OutputType.FILE);
			
			try {
				FileHandler.copy(src, new File(".//ScreenShot//WebElement"+Utility.getTheDateAndTime()+".png"));
			} catch (IOException e) {
				System.out.println("The Screen Shot of the webelement is not captured"+e.getMessage());
			}
			

		}
		
		/*
		 * To highlight and un-hightlight the webElement 
		 * @para: driver reference,By reference for the web element
		 * @return WebElement
		 */
			public static WebElement highLightElement(WebDriver driver ,By locator) {
				JavascriptExecutor js= (JavascriptExecutor) driver;
				WebElement element=driver.findElement(locator);
				js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:solid 2px red')", element);		
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Not highlighted "+e.getMessage());
				}
							
				return element;
				
			

				
			}
			
			/*
			 * Highligh Function with the WebElement not locator
			 */
			
			public static WebElement highLightElement(WebDriver driver ,WebElement ele) {
				JavascriptExecutor js= (JavascriptExecutor) driver;
				
				js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:solid 2px red')", ele);		
				
				Utility.threadWait(2);			
				return ele;
				
			

				
			}
			public static WebElement unhighLightElement(WebDriver driver ,By locator) {
				JavascriptExecutor js= (JavascriptExecutor) driver;
				WebElement element=driver.findElement(locator);
				js.executeScript("arguments[0].setAttribute('style', 'border:solid 2px ')", element);		
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Not highlighted "+e.getMessage());
				}
						
				return element;
				
			

				
			}
			
			/*
			 * This method is writing  for thread.sleep method
			 * @para: waiting time in seconds
			 */
			
			public static void threadWait(int second) {
				
				try {
					Thread.sleep(second*1000);
					 
				} catch (Exception e) {
					System.out.println("Something wend wrong...");
				}
			}
			
			/*
			 * This method is write for custom wait 
			 * @Para: Drive reference
			 * @para: WebElement Locator
			 */
			
			
			public static WebElement waitForWedElemet(WebDriver driver,By locator) {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
				if(ConfigFile_Reader.getProperty("highlightElement").contains("true")) {
					return Utility.highLightElement(driver, ele);
				}
				else {
				return ele;
				}
				
				
			}
			public static WebElement waitForElement(WebDriver driver,By locator) {
				
				WebElement element=null;
				for (int i=0;i<=30;i++) {
				try {
					 element =driver.findElement(locator);
					if(element.isDisplayed()&& element.isEnabled()) {
						 highLightElement(driver, locator);
						
					}
				} catch (Exception e) {
					System.out.println("Waiting for condions to be checked");
					threadWait(1);
				}
				}
				
				
				return element;
			}
			
			/*
			 * Override above method with the time to enter by user 
			 */
			
          public static WebElement waitForElement(WebDriver driver,By locator, int sec) {
				
				WebElement element=null;
				for (int i=0;i<=sec;i++) {
				try {
					 element =driver.findElement(locator);
					if(element.isDisplayed()&& element.isEnabled()) {
						 highLightElement(driver, locator);
						
					}
				} catch (Exception e) {
					System.out.println("Waiting for condions to be checked");
					threadWait(1);
				}
				}
				
				
				return element;
			}
			
			
}
		
		

