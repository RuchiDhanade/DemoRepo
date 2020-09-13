package com.selenium.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.selenium.qa.util.TestUtil;
import com.selenium.qa.util.WebEventListner;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListner;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"E:\\Ruchi_workspace\\Selenium_Maven_Project\\src\\main\\java\\com\\selenium\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Ruchi_workspace\\Dependancies\\Chrome\\V85\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListner = new WebEventListner();
		e_driver.register(eventListner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
	}

}
