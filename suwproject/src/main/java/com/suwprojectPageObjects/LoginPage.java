package com.suwprojectPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suwproject.ActionDriver.action;
import com.suwproject.Base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	

	@FindBy(id="signIn")
	WebElement signInbutton;
	
	
	//Initialize page object using constructor
	//constructor name same as calss name 
	
	public LoginPage () {
		PageFactory.initElements(driver, this);
		}
	//write methods 
	
	public  Homepage login(String username1, String  password1) throws Throwable{
		action.type(username, username1);
		action.type(password, password1);
		action.click(driver, signInbutton);
		return new Homepage();
	}
}


