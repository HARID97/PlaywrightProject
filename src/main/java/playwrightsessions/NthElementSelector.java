package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelector {
	
	public static void main(String args[]) {
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.bigbasket.com/");
		
		String first_ele = page.locator("footer.footer li a >> nth=0").textContent();
		String last_ele = page.locator("footer.footer li a >> nth=-1").textContent();
		
		System.out.println(first_ele);
		System.out.println(last_ele);
	
	}

}
