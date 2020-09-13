package com.selenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//div[contains(@class,'right menu')]//span[contains(text(),'Ruchi Dhanade')]")
	WebElement nameLabel;
	
	@FindBy(xpath="//a[contains(@class,'item')]//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(@class,'item')]//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(@class,'item')]//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return nameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContacts() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		dealsLink.click();
		return new TasksPage();
	}
}
