package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopup {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bc1 = browser.newContext();
//		BrowserContext bc2 = browser.newContext();
//		
		Page page1 = bc1.newPage();
//		Page page2 = bc2.newPage();
//		
//		page1.navigate("https://www.youtube.com");
//		page2.navigate("https://www.amazon.com");
		
		//1. clicking on a link in parent page and opening a new page
		page1.navigate("https://opensource-demo.orangehrmlive.com/");
//		Page popup = page1.waitForPopup(()-> {
//			page1.click("//a[@href='https://twitter.com/orangehrm?lang=en']");
//		});
//		System.out.println("Popup url: "+popup.url());
//		popup.close();
//		System.out.println("Parent url: "+page1.url());
//		page1.close();
		
		//2. to open a new empty tab/window popup and enter url
		
		Page popup = page1.waitForPopup(()-> {
			page1.click("a[target='_blank']");
		});
		
		popup.waitForLoadState();
		popup.navigate("https://www.google.co.in");
		System.out.println("Popup window title: "+popup.title());
		popup.close();
		
		System.out.println("Parent Window Title: "+page1.title());
		page1.close();
		
	}

}
