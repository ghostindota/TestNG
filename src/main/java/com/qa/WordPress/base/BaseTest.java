package com.qa.WordPress.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.WordPress.pages.AccountPage;
import com.qa.WordPress.pages.LoginPage;
import com.qa.WordPress.pages.ProductInfoPage;
import com.qa.WordPress.pages.RegisterPage;

public class BaseTest {
	public 	LoginPage loginPage;
	public AccountPage accountPage;
	public ProductInfoPage productInfoPage;
	public RegisterPage registerPage;
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	@BeforeTest
	public void setup() {
		
		basePage= new BasePage();
		prop= basePage.init_prop();
		String browser =prop.getProperty("browser");
		driver =basePage.init_driver(browser);
		this.loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
