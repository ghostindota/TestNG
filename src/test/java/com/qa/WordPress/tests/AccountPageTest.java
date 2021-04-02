package com.qa.WordPress.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.WordPress.base.BaseTest;
import com.qa.WordPress.utils.Constants;

public class AccountPageTest extends BaseTest {

	
	
	@BeforeClass
	public void AccountPageSetup() {
		accountPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority =1)
	public void homePageTitleTest() {
		String title=accountPage.getAccountPageTitle();
		System.out.println("home page title is " + title);
		Assert.assertEquals(title,Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyAccountPageHeaderTest() {
		String headerValue =accountPage.getHeaderValue();
		System.out.println("Account page header is " + headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNT_PAGE_HEADER );
	}
	@Test(priority=3)
	public void verifyAccountHeadersSize() {
		Assert.assertTrue(accountPage.areAccountHeadersExist()==Constants.ACCOUNT_PAGE_HEADER_COUNT);
	}
	@Test (priority=4)
	public void VerifyAccountPageHeaders() {
		Assert.assertEquals(accountPage.getAccountHeadersList(),Constants.getAccountHeadersList());
		
	}
	@Test(priority=5)
	public void verifySearch() {
		Assert.assertTrue(accountPage.doSearch("iMac"));
	}
	
	
}
