package com.qa.WordPress.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.WordPress.base.BasePage;
import com.qa.WordPress.utils.ElementUtil;

public class ProductInfoPage extends BasePage {

	WebDriver driver;
	private ElementUtil elementUtil;
	private By productName = By.xpath("(//div[@class='col-sm-4'])[2]//h1");
	private By productMetaData = By.xpath("(//div[@class='col-sm-4']//ul[@class= 'list-unstyled'])[1]/li");
	private By productPrice = By.xpath("(//div[@class='col-sm-4']//ul[@class= 'list-unstyled'])[2]/li");
	private By quantity = By.id("input-quantity");
	private By addToCarTButton = By.id("button-cart");
	private By productImgs = By.cssSelector(".thumbnails li img");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	

	public Map<String,String> getProductInfo() {
		
		Map<String, String> productInfoMap = new HashMap<>();
		productInfoMap.put("name", elementUtil.doGetText(productName).trim());
		List<WebElement> productInfoList=elementUtil.getElements(productMetaData);
		for(WebElement e:productInfoList) {
			productInfoMap.put(e.getText().split(":")[0].trim(),e.getText().split(":")[1].trim());
		}
		List<WebElement> list=driver.findElements(productPrice);
			productInfoMap.put("price",list.get(0).getText().trim());
			productInfoMap.put("exTaxPrice",list.get(1).getText().split(":")[1].trim());		
			return productInfoMap;
	}
	public void selectQuantity(String value) {
		elementUtil.doSendKeys(quantity, value );
	}
	public void addToCart() {
		elementUtil.doActionsClick(addToCarTButton);
	}
	public int getImgCount() {
		return elementUtil.getElements(productImgs).size();
	}


	public String getProductInfoPageTitle(String title) {
		return elementUtil.waitForTitlePresent(title, 5);
	}
}
