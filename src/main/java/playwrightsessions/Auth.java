package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc1 = browser.newContext();
		
		Page page = bc1.newPage();
		page.navigate("https://www.automationpractice.com");
		page.click("a:text('Sign in')");
		page.fill("#email","hari@gmail.com");
		page.fill("#passwd","testrigor123");
		page.click("#SubmitLogin");
		
		bc1.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
	}

}
