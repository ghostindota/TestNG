package com.qa.WordPress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.WordPress.base.BasePage;
import com.qa.WordPress.utils.Constants;
import com.qa.WordPress.utils.ElementUtil;

public class LoginPage extends BasePage {
	private ElementUtil elementUtil;
	RegisterPage registerPage;

	private WebDriver driver;
	// 1.By. locators :
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@class='btn btn-primary']");
	private By forgotPwdLink = By.linkText("Forgotten Password5");

	private By registerPageLink = By.linkText("Register");

	// 2.constructor of the page class:

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}
	// 3.page actions : features(behavior) of the page in form of methods:

	public String getLoginPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 5);
	}

	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}

	public AccountPage doLogin(String un, String pw) {
		System.out.println("Login with " + un + "and " + pw);
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(password).sendKeys(pw);
//		driver.findElement(loginButton).click();
		elementUtil.doActionsSendKeys(emailId, un);
		elementUtil.doActionsSendKeys(password, pw);
		elementUtil.doActionsClick(loginButton);
		return new AccountPage(driver);
	}

	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(registerPageLink);
		return new RegisterPage(driver);
	}

}
