package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSPopupHandle {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		//listener for javascript events. This is not mandatory. Playwright will handle the JS alerts/Prompts automatically. If we want to capture stuff from prompts do this. Otherwise comment.
		page.onDialog(dialog -> {
			String message = dialog.message();
			System.out.println(message);
			dialog.accept("Hello World");
			//dialog.dismiss();
		});
		
		//JS Alerts, Confirmation Popups, Prompts 
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		page.locator("text=Click for JS Alert").click();
		//does same function as above line 
		//page.click("text=Click for JS Alert");
		String result = page.locator("p#result").textContent();
		//does same function as above line
		//String result = page.textContent("p#result");
		System.out.println(result);
		
		page.click("text=Click for JS Confirm");
		result = page.locator("p#result").textContent();
		//does same function as above line
		//String result = page.textContent("p#result");
		System.out.println(result);
		
		page.click("text=Click for JS Prompt");
		result = page.locator("p#result").textContent();
		//does same function as above line
		//String result = page.textContent("p#result");
		System.out.println(result);
		
		page.close();
		browser.close();
		playwright.close();
		
		
		
	}

}
