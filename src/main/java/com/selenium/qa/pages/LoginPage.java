package com.selenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//a[contains(@class,'btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left')]")
	WebElement loginPageBtn;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(@class,'ui fluid large blue submit button')]")
	WebElement login;
	
	@FindBy(xpath="//div[contains(@Class,'rd-navbar-brand')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[contains(@class,'btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30')]")
	WebElement signUpBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();	
	}
	
	public HomePage login(String un, String pwd) {
		loginPageBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
}
