package playwrightsessions;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeBrowser {
	
	public static void main(String args[]) {
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)screensize.getWidth();
		int height=(int)screensize.getHeight();
				
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		
		Page page = bc.newPage();
		page.navigate("http://www.amazon.com");
		
		bc.close();
		page.close();
		playwright.close();
		
		
	}

}
