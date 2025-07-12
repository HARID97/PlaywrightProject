package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScopeLocators {
	
	static Page page1;
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		page1 = browser.newPage();
		page1.navigate("https://datatables.net/extensions/select/examples/initialisation/simple.html");
		
		//clicking only the ashtom cox row from a number of rows.
		Locator row = page1.locator("table#example tr");
		row.locator(":scope",new Locator.LocatorOptions().setHasText("Ashton Cox")).click();
//		row.locator(":scope",new Locator.LocatorOptions().setHasText("Ashton Cox")).locator("select-checkbox")click();
		
		row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
	}

}
