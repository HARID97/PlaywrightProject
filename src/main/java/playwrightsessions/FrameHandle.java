package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		Page page = browser.newPage();
		//page.navigate("https://londonfreelance.org/courses/frames/index.html");
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		//1. method one using framelocator method
//		String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
//		System.out.println(header);
		
		//2. method two using frame method
//		String h2 = page.frame("main").locator("h2").textContent();
//		System.out.println(h2);
		
		//3. entering an iframe
		page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
		page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8").fill("Harikrishnan D");
		
	}

}
