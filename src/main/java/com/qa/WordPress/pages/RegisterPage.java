package com.qa.WordPress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.WordPress.base.BasePage;
import com.qa.WordPress.utils.Constants;
import com.qa.WordPress.utils.ElementUtil;

public class RegisterPage extends BasePage {

	ElementUtil elementUtil;
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPass = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[2]/input");
	private By checkBox = By.xpath("//input[@name ='agree']");
	private By continueButton = By.xpath("//input[@type ='submit']");
	private By accountSuccessMessage = By.xpath("//div[@id='content']/h1");
	private By logoutButton = By.linkText("Logout");
	private By registerLink = By.linkText("Register");


	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public boolean accountRegistration(String firstname, String lastname, String email, String telephone, String password,
			String subscribe) {

		elementUtil.doSendKeys(firstName, firstname);
		elementUtil.doSendKeys(lastName, lastname);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(confirmPass, password);
		elementUtil.doSendKeys(firstName, firstname);
		
		if (subscribe.equalsIgnoreCase("Yes")) {
			elementUtil.doClick(subscribeYes);
		} else {
			elementUtil.doClick(subscribeNo);
		}
		elementUtil.doClick(checkBox);
		elementUtil.doClick(continueButton);
		
		String text=elementUtil.doGetText(accountSuccessMessage);
		if(text.equals(Constants.ACCOUNT_SUCCESS_MESSAGE)) {
			elementUtil.doClick(logoutButton);	
			elementUtil.doClick(registerLink);
			return true;
		}else return false;

	}

}
