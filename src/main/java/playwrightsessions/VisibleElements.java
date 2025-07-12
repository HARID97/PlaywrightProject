package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		//how to get visible elements
		//1.button:visible
		//2.button >> visible=true
		
		//page.navigate("https://website.com");
		//String text = page.locator("button:visible").textContent();
		//String text = page.locator("button >> visible=true").textContent();
		//System.out.println(text);
		
		page.navigate("https://www.amazon.co.in");
		
		List<String> locators = page.locator("a:visible").allInnerTexts();
		
		for(int i=0;i<locators.size();i++) {
			System.out.println(locators.get(i));
		}
		
		//getting visible elements with xpath
		int images_count = page.locator("xpath=//img >> visible=true").count();
		System.out.println(images_count);
		
		//getting visible elements with text path
		//text=login >> visible=true
		
	}

}
