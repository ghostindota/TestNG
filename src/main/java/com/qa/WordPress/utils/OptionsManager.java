package com.qa.WordPress.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager {

	Properties prop;
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	public ChromeOptions getChromeOptions() {
		ChromeOptions co = new ChromeOptions();
		if (prop.getProperty("headless").trim().equals("true"))
			co.addArguments("--headless");
		if (prop.getProperty("incognito").trim().equals("true"))
			co.addArguments("--incognito");

		return co;
	}
	
}
