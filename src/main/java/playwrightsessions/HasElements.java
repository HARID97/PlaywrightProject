package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasElements {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		//page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		page.navigate("https://www.amazon.co.in");
		
		//checking for an element which contains another element. Here checking for select element which has option element under it(parent - child/grandchild)
//		Locator loc = page.locator("select[name='Country']:has(option[value='India'])");
//		loc.allInnerTexts().forEach(e -> System.out.println(e));
		
//		Locator footerlist = page.locator("div.navFooterLinkCol:has(a[href='https://amazon.jobs'])");
		Locator footerlist = page.locator("div.navFooterLinkCol:has(a:has-text('About Amazon'))");
//		Locator footerlist = page.locator("div.navFooterLinkCol:has(a[text='About Amazon'])");
		
		footerlist.allInnerTexts().forEach(e -> System.out.println(e));
		
		
	}

}
