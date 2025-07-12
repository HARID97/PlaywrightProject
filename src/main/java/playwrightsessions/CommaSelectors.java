package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com");
		
		//multiple possible selectors for the same element(locator)
		//page.locator("a:has-text('Login'),a:has-text('Signin'),a:has-text('LogIn'),a:has-text('SignIn')").click();
		
		//selectors for multiple locators(different elements)
		Locator locs = page.locator("span:has-text('Store'),a:has-text('Login'),a:has-text('EXPLORE COURSES')");
		System.out.println(locs.count());
		
		//xpath union using the | operator
		page.locator("//span[text()='signin'] | //span[text()='login']");
		
	}

}
