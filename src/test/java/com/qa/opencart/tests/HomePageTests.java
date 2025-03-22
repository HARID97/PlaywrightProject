package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.Homepage;

public class HomePageTests extends BaseTest{
	
	@Test
	public void homePageTitleTest() {
		String title=homepage.getHomePageTitle();
		Assert.assertEquals(title,AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageURLTest() {
		String url=homepage.getHomePageURL();
		Assert.assertEquals(url,prop.getProperty("url"));
	}
	
	@Test(dataProvider="getProductData")
	public void searchTest(String productName) {
		String searchtext=homepage.search(productName);
		Assert.assertEquals(searchtext,"Search - "+productName);
	}
	
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
		
	}

}
