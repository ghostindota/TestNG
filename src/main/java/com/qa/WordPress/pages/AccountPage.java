package com.qa.WordPress.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.WordPress.base.BasePage;
import com.qa.WordPress.utils.Constants;
import com.qa.WordPress.utils.ElementUtil;

public class AccountPage extends BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.linkText("Your Store");
	private By search = By.xpath("//div[@id='search']/input[@name='search']");
	private By accountHeaders= By.xpath("//div/h2");
	private By searchButton =By.xpath("//div[@id='search']//span[@class='input-group-btn']");
	private By searchItems = By.xpath("//div[contains(@class,'product-layout')]/div[@class='product-thumb']");
	private By resultsInSearchPage =By.cssSelector(".product-thumb h4 a");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil =new ElementUtil(this.driver);
	}

	public String getAccountPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.ACCOUNT_PAGE_TITLE, 10);
	}

	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	public boolean doSearch(String item) {
		driver.findElement(search).clear();
		elementUtil.doActionsSendKeys(search, item);
		elementUtil.doActionsClick(searchButton);
		if(elementUtil.getElements(searchItems).size()>0){
			return true;
		}else return false;
	}
	
	public int areAccountHeadersExist() {
		return elementUtil.getElements(accountHeaders).size();
	}
	public List<String> getAccountHeadersList() {
		List<WebElement> accList =elementUtil.getElements(accountHeaders);
		List<String> list = new ArrayList<>();
		for(WebElement e:accList) {
			list.add(e.getText());
		}
		System.out.println(list);
		return list;
	}
	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultList= elementUtil.getElements(resultsInSearchPage);
		for(WebElement e:resultList) {
			if(e.getText().equalsIgnoreCase(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
}
