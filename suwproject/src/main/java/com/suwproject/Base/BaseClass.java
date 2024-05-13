package com.suwproject.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.suwproject.ActionDriver.action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
   
    public static Properties prop;
    private static String url = "https://devqe.startupwind.com/signin?redirect=/login";  // Declare the url variable at the class level
    protected static Properties loc = new Properties();
    protected WebDriver driver;
    
    @BeforeTest
    public void setUp() {
        loadConfig(); // Load configuration
        launchApp(); // Launch the application
    }

    public static String getUrl() {
        return url;
    }

    public void loadConfig() {
        FileInputStream fis = null;
        try {
            prop = new Properties();
            String filePath = "C:\\Users\\admin\\git\\SUWAUTOMATIONPROJECT\\suwproject\\Configuration";
            System.out.println("Absolute File path: " + new File(filePath).getAbsolutePath());
            fis = new FileInputStream("C:\\Users\\admin\\git\\SUWAUTOMATIONPROJECT\\suwproject\\Configuration\\config.properties");
            prop.load(fis);
            // Correct the property key to "browserName"
            System.out.println("Value of browserName: " + prop.getProperty("browserName"));
            prop.getProperty("browserName");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void launchApp() {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browserName");
        System.out.println("Value of browserName in launchApp: " + browserName);
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        // Maximize the screen
        driver.manage().window().maximize();
        // Delete all the cookies
        driver.manage().deleteAllCookies();
        // Implicit TimeOuts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        action.pageLoadTimeOut(driver, 30);
    }

    @AfterTest
    public void tearDown() {
        // Close WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
