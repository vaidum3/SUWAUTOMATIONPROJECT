package com.suwprojectTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.suwproject.Base.BaseClass;
import com.suwprojectPageObjects.indexpage;

public class indexpagetest extends BaseClass {

	//create before method in class to access for all test cases 
	
	indexpage indexpage;
	
	@BeforeMethod
	public void setup(){
		loadConfig();  // Call loadConfig to initialize properties including 'url'
		launchApp();
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}
	
    /*@Test
	public void VerifyLogo() {
		 indexpage=new indexpage();//create objects of methods in object pages
		boolean result =indexpage.validateLogo();//call menthod using object 
		Assert.assertTrue(result);//verify 
		
	}*/
	
    @Test
    public void VerifyUrl() {
        String expectedUrl = "https://devqe.startupwind.com/signin";
        String actualUrl = BaseClass.getUrl();

        // Assert that the actual URL matches the expected URL
        Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");

        // You can add more assertions if needed
        // For example, you can check if the URL contains a specific substring
        Assert.assertTrue(actualUrl.contains("devqe.startupwind.com"), "URL does not contain the expected domain");
    }


//String websiteUrl = BaseClass.getUrl();
    }
