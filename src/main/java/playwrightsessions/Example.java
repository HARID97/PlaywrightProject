package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Example {
	
	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://www.google.co.in/");
	      page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
	      page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("hello world");
	      page.pause();
	      page.navigate("https://www.google.co.in/");
	      
	      //run below command in cmd to open inspector and generate code
	      //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"
	      //can be done by pause method(line 20) and using the PWDEBUG env variable as well.
	    }
	  }

}
