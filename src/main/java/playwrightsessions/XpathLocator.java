package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		//page.navigate("https://www.amazon.com/");
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		
//		Locator checkboxes = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
//		for(int i=0;i<checkboxes.count();i++) {
//			checkboxes.nth(i).click();
//		}
		
		//various indexing methods
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[position()=3]").click();
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[2]").click();
		
		
		
//		page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("Macbook pro");
//		
//		Locator amazonlinks = page.locator("xpath=//a[contains(text(),'Amazon')]");
//		System.out.println(amazonlinks.count());
//		
//		List<String> links = amazonlinks.allInnerTexts();
//		System.out.println(links);
		
	}

}
