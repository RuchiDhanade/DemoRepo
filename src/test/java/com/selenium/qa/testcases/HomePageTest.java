package com.selenium.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.qa.base.TestBase;
import com.selenium.qa.pages.ContactsPage;
import com.selenium.qa.pages.HomePage;
import com.selenium.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabel() {
		boolean flag = homePage.verifyUserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContacts();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
