package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	private String email="input#input-email";
	private String pwd="input#input-password";
	private String loginBtn="input:text('Login')";
	private String forgotpwd="a:text('Forgotten Password')";
	private String logoutlink="//div[@class='list-group']/child::a[text()='Logout']";
	
	public LoginPage(Page page) {
		this.page=page;
	}
	
	public String getLoginPageTitle() {
		String title=page.title();
		return title;
	}
	
	public boolean isForgotPwdLinkExists() {
		return page.isVisible(forgotpwd);
	}
	
	public boolean doLogin(String username,String password) {
		page.fill(email,username);
		page.locator(pwd).fill(password);
		page.click(loginBtn);
		if(page.isVisible(logoutlink)) {
			System.out.println("User is logged in successfully");
			return true;
		}
		else {
			System.out.println("Wasnt able to login");
			return false;
		}
		
	}
	

}
