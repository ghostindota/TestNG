package com.qa.WordPress.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String LOGIN_PAGE_TITLE ="Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADER = "Your Store";
	public static final int ACCOUNT_PAGE_HEADER_COUNT =4;
	public static final String REGISTER_SHEET_NAME = "registration";
	public static final String ACCOUNT_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	
	public static List<String> getAccountHeadersList() {
		List<String> list = new ArrayList<String>();
		list.add("My Account");
		list.add("My Orders");
		list.add("My Affiliate Account");
		list.add("Newsletter");
return list;
	}
	
	

	
}

