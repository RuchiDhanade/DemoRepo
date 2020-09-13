package com.selenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.qa.base.TestBase;

public class NewContactPage extends TestBase{

	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="middle_name")
	WebElement middleName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='value' and @type='text']")
	WebElement emailAdd;
	
	@FindBy(xpath="//button[@class='ui linkedin button' and text()='Save']")
	WebElement saveBtn;
	
	public NewContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void newContactDetails(String ftname, String mdlname, String ltname, String emailid){
		firstName.sendKeys(ftname);
		middleName.sendKeys(mdlname);
		lastName.sendKeys(ltname);
		emailAdd.sendKeys(emailid);
		saveBtn.click();
	}
}
