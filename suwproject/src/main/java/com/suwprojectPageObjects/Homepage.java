/**
 * 
 */
package com.suwprojectPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.suwproject.ActionDriver.action;
import com.suwproject.Base.BaseClass;

/**
 * 
 */
public class Homepage extends BaseClass  {

	@FindBy(xpath = "/html/body/div[3]/div/div")
	 WebElement welcomepopup;
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div[1]/div")
	 WebElement crossbutton;
	

	public   Homepage () {
		PageFactory.initElements(driver, this);
		}
	public boolean validatewelcomepopup() throws Throwable {
		return action.isDisplayed(driver,welcomepopup);
	}
	
	public  Homepage crossbutton() throws Throwable{
		action.click(driver, crossbutton);
		return new Homepage();
	}
	
	public String  getcurrenturl()
	{
	String homepageurl=driver.getCurrentUrl();
	return homepageurl();
		
	}
	private String homepageurl() {
		// TODO Auto-generated method stub
		return homepageurl();
	}
	
}
