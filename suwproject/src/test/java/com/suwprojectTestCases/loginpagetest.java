package com.suwprojectTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.suwproject.Base.BaseClass;
import com.suwprojectPageObjects.indexpage;

import java.time.Duration;

public class loginpagetest extends BaseClass {

    @Test(description = "Valid Credentials")
    public void loginTest() throws Throwable {
        // Navigate to the login page
        System.out.println("Navigating to the login page...");
        driver.get(getUrl());

        // Instantiate the page object for the index page
        indexpage index = new indexpage();
        // Click on the Sign In button
        System.out.println("Clicking on the Sign In button...");
        index.clickOnSignIn();

        // Wait for the page to load completely
        waitForPageLoad();

        // Perform login actions
        performLogin("vaidehi+havard_admin2@startupwind.com", "Test1234");

        // Verify successful login (example verification)
        Assert.assertTrue(isElementDisplayed(By.xpath("//div[@class='col']//input[@placeholder='Search for Business Plans, Ideas or People']")),
                "Login successful, but search input field not found.");
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Use Duration object
        try {
            wait.until(driver -> String.valueOf(((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return document.readyState")).equals("complete"));
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for page to load completely.");
            e.printStackTrace();
            // Handle the timeout as needed
        }
    }

    private void performLogin(String username, String password) {
        // ActionDriver can be replaced with direct Selenium actions for simplicity
        System.out.println("Performing login actions...");
        driver.findElement(By.cssSelector("input[placeholder='Enter email']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    }

    private boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
