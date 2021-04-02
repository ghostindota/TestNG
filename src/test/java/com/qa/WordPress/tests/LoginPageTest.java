package com.qa.WordPress.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.WordPress.base.BaseTest;
import com.qa.WordPress.utils.Constants;

//@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest {

	
	@Test(priority =1)
	public void verifyLoginPageTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority =2)
	public void verifyForgotPwdLink() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Test(priority =3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
