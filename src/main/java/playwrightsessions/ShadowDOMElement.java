package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOMElement {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//There is no need of javascriptexecutor unlike selenium to work on shadowdom elements. can directly write code in playwright.
		
		//Page->DOM-ShadowDOM->elements
		//Page->DOM-IFrame-ShadowDOM->elements
		
		Page page = browser.newPage();
		//page.navigate("https://books-pwakit.appspot.com/");
		page.navigate("https://selectorshub.com/xpath-practice-page/");
//		page.locator("book-app[apptitle='BOOKS'] #input").fill("Hari");
//		String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
//		System.out.println(text);
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Masala Tea");
	}

}
