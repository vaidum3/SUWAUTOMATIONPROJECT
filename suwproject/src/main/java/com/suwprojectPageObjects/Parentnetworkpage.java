/**
 * 
 */
package com.suwprojectPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suwproject.ActionDriver.action;
import com.suwproject.Base.BaseClass;

/**
 * 
 */
public class Parentnetworkpage extends BaseClass{

	@FindBy(xpath="/html/body/div[3]/div/div")
	WebElement welcomepopup;
	   
	@FindBy(xpath="/html/body/div[3]/div/div/div[3]/button")
	WebElement StayInNetwork;
	

	
	public  Parentnetworkpage () {
		PageFactory.initElements(driver, this);
		}
	public boolean validatewelcomepopup() throws Throwable {
		return action.isDisplayed(driver,welcomepopup);
	}
	
	public  Parentnetworkpage StayInNetwork() throws Throwable{
		action.click(driver,  StayInNetwork);
		return  StayInNetwork();
	}
	
}
