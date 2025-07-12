package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");
		
		//handles any download happening
		Download download = page.waitForDownload(() -> {
			page.click("a:text('chromedriver_linux64.zip')");
		});
		
		//to cancel downloads
		download.cancel();
		//print failure cause
		System.out.println(download.failure());
		
		System.out.println(download.url());
		System.out.println(download.page().title());
		
		//prints temporary download path
		System.out.println(download.path().toString());
		download.saveAs(Paths.get("Hari_Chrome.zip"));
		
		//gives suggested file name(filename during time of downloading)
		System.out.println(download.suggestedFilename());
		
	}

}
