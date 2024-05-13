package com.suwprojectPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suwproject.Base.BaseClass;
import com.suwproject.ActionDriver.action;
public class indexpage extends BaseClass{

	
	
		
		@FindBy(xpath="//*[@class=\"text-info f-15 font-weight-bold nav-link\" and @href=\"/login\"]")
		
		WebElement Loginbutton;
		
		@FindBy(xpath="//*[@id=\"basic-navbar-nav\"]/div/a[7]")
		WebElement GetStartedbutton;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[1]/a/img")
		WebElement StartupWindLogo;
		
		@FindBy(xpath="//*[@id=\"basic-nav\" and @href=\"https://www.startupwind.com\"]")
		WebElement HomeTab;

		@FindBy(xpath="//*[@id=\"basic-nav\" and @href=\"https://startupwind.com/smb.html\"]")
		WebElement SmallBusinesses;
		
		@FindBy(xpath="//*[@id=\"basic-nav\" and @href=\"https://startupwind.com/universities.html\"]")
		WebElement Universities;
		
		@FindBy(xpath="//*[@id=\"basic-nav\" and @href=\"https://www.startupwind.com/states.html\"]")
		WebElement States;
		
		@FindBy(xpath="/html/body/div/div[1]/div/div/nav/div/div/div[1]/a")
		WebElement ResourcesDropdown;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[6]/a")
		WebElement Courses;
		
		
		@FindBy(xpath="tml/body/div/div[1]/div/div/nav/div/div/div[1]/a")
		WebElement CompanyDropDown;
		
		public indexpage() {
			PageFactory.initElements(driver, this);
			}
		//methods 
		
		public LoginPage clickOnSignIn() throws Throwable {
			 try {
				action.click(driver,  Loginbutton);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  new LoginPage();
			 	
		}
			
		//public String getStartupwindTitle() {
			//String startupwindTitle=driver.getTitle();
			//return startupwindTitle;

		  public boolean validateimage() {
		        try {
		            WebElement logoImage = driver.findElement(By.xpath("/html/body/nav/div[2]/div/div[1]/a/img"));
		            return logoImage.isDisplayed();
		        } catch (org.openqa.selenium.NoSuchElementException e) {
		            return false; // Element not found
		        }
		    }

			
		}
		
	
		
