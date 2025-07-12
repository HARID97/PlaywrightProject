package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {
	
	static Page page;
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		selectUser("Joe.Root");
		selectUser("Jasmine.Morgan");
		
		System.out.println(getUserrole("Joe.Root"));
		System.out.println(getUserrole("John.Smith"));
		
		String above = page.locator("a:above(:text('Joe.Root'))").first().textContent();
		System.out.println(above);
		
		String below = page.locator("a:below(:text('Joe.Root'))").first().textContent();
		System.out.println(below);
		
		Locator near_elements = page.locator("td:near(:text('Joe Root'),400)");
		List<String> near_elem_text = near_elements.allInnerTexts();
		System.out.println(near_elem_text);

	}
	
	public static void selectUser(String username) {
		page.locator("input[type='checkbox']:left-of(:text('"+username+"'))").first().click();
	}
	
	public static String getUserrole(String username) {
		return page.locator("td:right-of(:text('"+username+"'))").first().textContent();
		
	}

}
