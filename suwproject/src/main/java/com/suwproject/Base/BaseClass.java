package com.suwproject.Base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import com.suwproject.ActionDriver.action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//creates objects 
	public static Properties prop;
   public static WebDriver driver;
  
	// Declare ThreadLocal Driver
	//public static ThreadLocal<RemoteWebDriver> driver1 = new ThreadLocal<>();

	//loadConfig method is to load the configuration
	
	@BeforeSuite
	public void loadConfig() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	//public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		//return driver.get();
	//}

	
	public void launchApp() {
		
		 String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  action action = new action();
		action.pageLoadTimeOut(driver, 30);
     driver.get(prop.getProperty("url"));
	
/*
	public String getCurrentTime() {
		// TODO Auto-generated method stub
		return null;
	}


	public String screenShot(WebDriver driver, String filename) {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/	/*
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));

		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeOut"))));

		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}
*/
	
	}
}
		