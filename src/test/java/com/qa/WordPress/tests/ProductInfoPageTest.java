package com.qa.WordPress.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.WordPress.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoPagesetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority =3)
	public void productInfoPageTitleTest() {
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"),"iMac");
	}

	@Test(priority =1)
	public void verifyProductInfoTest_MacBook() {
		Assert.assertTrue(accountPage.doSearch(prop.getProperty("productName")));
		productInfoPage = accountPage.selectProductFromResults(prop.getProperty("exactProductName"));
		Assert.assertTrue(productInfoPage.getImgCount() == 4);
		Map<String, String> productinfoMap = productInfoPage.getProductInfo();
		System.out.println(productinfoMap);

		Assert.assertEquals(productinfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productinfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productinfoMap.get("Availability"), "Out Of Stock");
		Assert.assertEquals(productinfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(productinfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productinfoMap.get("Reward Points"), "800");
		Assert.assertEquals(productinfoMap.get("exTaxPrice"), "$2,000.00");
	}

	@Test(priority=2)
	public void verifyProductInfoTest_iMac() {
		Assert.assertTrue(accountPage.doSearch("imac"));
		productInfoPage = accountPage.selectProductFromResults("iMac");
		Assert.assertTrue(productInfoPage.getImgCount() == 3);
		Map<String, String> productinfoMap = productInfoPage.getProductInfo();
		System.out.println(productinfoMap);

		Assert.assertEquals(productinfoMap.get("name"), "iMac");
		Assert.assertEquals(productinfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productinfoMap.get("Availability"), "Out Of Stock");
		Assert.assertEquals(productinfoMap.get("price"), "$100.00");
		Assert.assertEquals(productinfoMap.get("Product Code"), "Product 14");
		Assert.assertEquals(productinfoMap.get("exTaxPrice"), "$100.00");
	}

}
