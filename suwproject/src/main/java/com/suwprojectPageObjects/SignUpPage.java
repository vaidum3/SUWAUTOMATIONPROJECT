package com.suwprojectPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.suwproject.ActionDriver.action;
import com.suwproject.Base.BaseClass;

public class SignUpPage extends BaseClass {
	
	
	private static final int Entrepreneur = 0;
	
	private static final int Mentor = 0;

	private static final int Investor = 0;
	
	@FindBy(xpath="//span[text()=\"New User\"]")
	WebElement  newuser;
	
	@FindBy(id="Firstname")
	WebElement firstname;
	
	@FindBy(id="Lastname")
	WebElement lastname;
	
	@FindBy(id="Email")
	WebElement Emailaddress;
	
	 @FindBy(id = "Schoolname")
	    private WebElement schoolNameDropdown;
	
	@FindBy(id="password")
	WebElement password;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div/div/div/form/div/div[9]")
	private WebElement radioButton;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div/div/div/div/form/div/a")
	WebElement CREATEACCOUNTbutton;
	
	//Initialize page object using constructor
	//constructor name same as class name 
	
	public  SignUpPage () {
		PageFactory.initElements(driver, this);
		}
	public boolean validateSignUpPage() throws Throwable {
		return action.isDisplayed(driver,newuser);
	}
	
	//write methods 
	 public void selectSchool(String schoolValue) {
	        Select dropdown = new Select(schoolNameDropdown);
	        dropdown.selectByVisibleText(schoolValue);
	    }
	
    public void clickRadioButton() {
    	
    	role role = new role();
		role.clickRadioButton();
    }
    
	
	public  successfulpage login(String firstname1, String lastname1, String  password1,String emailaddress,String schoolname1) throws Throwable{
		action.type(firstname, firstname1);
		action.type(password,lastname1);
		action.type(firstname,  emailaddress);
		
		List<WebElement> elements = driver.findElements(By.cssSelector("div.form-group:nth-child(9)"));

		if (role.equalsIgnoreCase("Entrepreneur")) {
		    int entrepreneurIndex = Entrepreneur; // Replace with the actual index
		    WebElement entrepreneurElement = elements.get(entrepreneurIndex);
		    action.click(driver, entrepreneurElement);
		} else if (role.equalsIgnoreCase("Mentor")) {
		    int mentorIndex = Mentor; // Replace with the actual index
		    WebElement mentorElement = elements.get(mentorIndex);
		    action.click(driver, mentorElement);
		} else if (role.equalsIgnoreCase("Investor")) {
		    int investorIndex = Investor; // Replace with the actual index
		    WebElement investorElement = elements.get(investorIndex);
		    action.click(driver, investorElement);
		}
		action.type(password, schoolname1);
		action.type(password, password1);
		action.click(driver, CREATEACCOUNTbutton);
		return new successfulpage();
	}
}


