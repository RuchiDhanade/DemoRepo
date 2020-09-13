package com.selenium.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement contactslabel;
	
	@FindBy(xpath="//button[@class='ui linkedin button' and text()='New']")
	WebElement newContact;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]/parent::tr//td//div[contains(@class,'ui fitted read-only checkbox')]")).click();
	}
	
	public NewContactPage createNewContact() {
		newContact.click();
		return new NewContactPage();
	}
}
