package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bc1 = browser.newContext();
		Page page1 = bc1.newPage();
		page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		page1.fill("#Form_getForm_Name","Hari");
		System.out.println(page1.title());
		
		BrowserContext bc2 = browser.newContext();
		Page page2 = bc2.newPage();
		page2.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		page2.fill("#Form_getForm_Email","hari@gmail.com");
		System.out.println(page2.title());
		
		bc1.close();
		page1.close();
		
		bc2.close();
		page2.close();
	}

}
