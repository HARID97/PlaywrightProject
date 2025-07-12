package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightbasics {
	
	public static void main(String args[]) {
		
		//creating playwright class object
		Playwright playwright = Playwright.create();
		
		//selecting desired browser and setting headless mode as false(its true by default)
		//Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//to open in chrome/edge instead of chromium(similar to chromeoptions in selenium)
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		//lp.setChannel("msedge");
		//lp.setChannel("firefox");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		
		//opening a page with desired browser
		Page page = browser.newPage();
		
		page.navigate("https://google.co.in");
		System.out.println("Page title is: "+page.title());
		System.out.println("Page url is: "+page.url());
		
		browser.close();
		playwright.close();
		
	}
	
	

}
