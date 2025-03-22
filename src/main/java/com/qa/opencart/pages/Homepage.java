package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class Homepage {
	
	private Page page;
	
	//1.String Locators
	
	private String search="input[name='search']";
	private String searchIcon="button.btn.btn-default.btn-lg";
	private String searchPageHeader="div#content h1";
	private String loginlink="a:text('Login')";
	private String myaccountLink="a[title='My Account']";
	
	//2.Page Constructors
	public Homepage(Page page) {
		this.page=page;
	}
	
	//3.Page actions/methods
	public String getHomePageTitle() {
		System.out.println("Page title is: "+page.title());
		return page.title();
	}
	
	public String getHomePageURL() {
		System.out.println("Page URL is: "+page.url());
		return page.url();
	}
	
	public String search(String productName) {
		page.fill(search,productName);
		page.locator(searchIcon).click();
		//return page.locator(searchPageHeader).textContent();
		System.out.println("Search Text: "+page.textContent(searchPageHeader));
		return page.textContent(searchPageHeader);
	}
	
	public LoginPage login() {
		page.click(myaccountLink);
		page.locator(loginlink).click();
		return new LoginPage(page);
	}
	

}
