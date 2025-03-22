package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTests extends BaseTest{
	
	@Test(priority=1)
	public void loginPageNavigationTest() {
		loginpage=homepage.login();
		String actLoginPageTitle=loginpage.getLoginPageTitle();
		System.out.println("Actual Title: "+actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle,AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExists(),"The Link does not exist");
	}
	
	@Test(priority=3)
	public void appLoginTest() {
		Boolean didlogin=loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(didlogin,"Wasnt able to login");
	}
	

}
