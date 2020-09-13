package com.selenium.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.qa.base.TestBase;
import com.selenium.qa.pages.ContactsPage;
import com.selenium.qa.pages.HomePage;
import com.selenium.qa.pages.LoginPage;
import com.selenium.qa.pages.NewContactPage;
import com.selenium.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactPage newContactPage;
	
	String sheetName = "TestData";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		newContactPage = new NewContactPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContacts();
	}
/*	
	@Test(priority=1)
	public void verifyContactsLabelTset() {
		boolean cont = contactsPage.verifyContactsLabel();
		Assert.assertTrue(cont);
	}
	
	@Test(priority=2)
	public void selectContactsByNameTest() {
		contactsPage.selectContactByName("Ruchi Dhanade");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsByNameTest() {
		contactsPage.selectContactByName("Ruchi Dhanade");
		contactsPage.selectContactByName("Ruchi123");
	}
*/	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void createNewContactTest(String firstname, String middlename, String lastname, String email){
		contactsPage.createNewContact();
//		newContactPage.newContactDetails("Tome", "Jonas", "Peter", "tom@gmail.com");
		newContactPage.newContactDetails(firstname,middlename,lastname, email);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
