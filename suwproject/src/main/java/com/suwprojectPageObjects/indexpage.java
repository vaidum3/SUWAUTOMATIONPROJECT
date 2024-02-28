package com.suwprojectPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suwproject.Base.BaseClass;
import com.suwproject.ActionDriver.action;
public class indexpage extends BaseClass{

	
	
		
		@FindBy(xpath="//a[@class=\"nav-link login\"]")
		WebElement SignInbutton;
		
		@FindBy(xpath="//a[@class=\"nav-link sign-up\"]")
		WebElement SignUpbutton;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[1]/a/img")
		WebElement StartupWindLogo;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[1]/a")
		WebElement HomeTab;

		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[2]/a")
		WebElement StartupsAndSMBs;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[3]/a")
		WebElement Universities;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[4]/a")
		WebElement States;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[5]/div/button")
		WebElement ResourcesDropdown;
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[6]/a")
		WebElement Courses;
		
		
		@FindBy(xpath="/html/body/nav/div[2]/div/div[3]/div/ul/li[7]/div/button")
		WebElement CompanyDropDown;
		
		public indexpage() {
			PageFactory.initElements(driver, this);
			}
		
		public LoginPage clickOnSignIn() throws Throwable {
			 action.click(driver, SignInbutton);
			return  new LoginPage();
			 
			
		}
		public  SignUpPage clickOnSignup() throws Throwable {
			 action.click(driver, SignUpbutton);
			return  new SignUpPage();
		}
		
		}


