package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {
	
	//selectors in playwright are similar to locators in selenium
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page1 = browser.newPage();
		//page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		page1.navigate("https://demo.opencart.com/index.php?route=account/login");
		
		//text locators
//		page1.locator("text =Contact Sales").last().click();
//		page1.locator("'Contact Sales'").last.click();		
//		
//		Locator privacy_links = page1.locator("text =Privacy Policy");
//		for(int i=0;i<privacy_links.count();i++) {
//			System.out.println(privacy_links.nth(i).textContent());
//			
//		}
		//xpath
		//String header = page1.locator("//h2[text()='New Customer']").textContent();
		//css selector
		String header = page1.locator("div.well h2:has-text('New Customer')").textContent();
		System.out.println(header);
		
		//locating button using css selector
		page1.locator("form input:has-text('Login')").click();
		
		//in case of button or any other tags, value attribute can also be considered as text
		
		
	}

}
