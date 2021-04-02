package com.qa.WordPress.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.WordPress.base.BaseTest;
import com.qa.WordPress.utils.Constants;
import com.qa.WordPress.utils.ExcelUtils;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void registerPageSetup() {
		registerPage=loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][]=ExcelUtils.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstname, String lastname, String email, String telephone, String password,
			String subscribe) {
		registerPage.accountRegistration(firstname,lastname,email,telephone,password,subscribe);
		
		
	}

}
