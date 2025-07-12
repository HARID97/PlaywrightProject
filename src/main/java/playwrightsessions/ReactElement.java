package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactElement {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.netflix.com/ae-en/");
		
		//entering email
//		Locator loc = page.locator("_react=ControlWrapper[name='email'] >> input").first();
//		loc.click();
//		loc.fill("hari@gmail.com");
		
		//clicking on language dropdown
		page.locator("_react=UISelect[data-uia='language-picker']").click();
		
		Locator footer = page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']");
		List<String> footerlist = footer.allInnerTexts();
		
		System.out.println(footerlist);

	}

}
