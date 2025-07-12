package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {
	
	public static void main(String args[]) {
		
		//Locator in playwright represents webelements unlike xpath,css selector in selenium.
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bc1 = browser.newContext();
		Page page1 = bc1.newPage();
		page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		//page1.navigate("https://academy.naveenautomationlabs.com");
		
//		Locator contactSales = page1.locator("text = CONTACT SALES");
//		contactSales.hover();
//		contactSales.click();
		
		
		//Handling single webelements
		
		//getting the first login button in case if there are more than one webelement
		//Locator loginBtn = page1.locator("text = Login").first();
		//getting the total count of elements
		//System.out.println("Total number of login elements: "+loginBtn.count());
		//methods to hover and click an element
		//loginBtn.hover();
		//loginBtn.click();
		
		//Handling multiple webelements
		//Locator countryOptions = page1.locator(select#Form_getForm_Country option);
		Locator countryOptions = page1.locator("//select[@name='Country']//option[not(contains(text(),'Country'))]");
		System.out.println(countryOptions.count());
		
		//1. Iterating all the countries
		for(int i=0;i<countryOptions.count();i++) {
			System.out.println(countryOptions.nth(i).textContent());
		}
		
		//2
		List<String> options = countryOptions.allTextContents();
		System.out.println(options);
		
		//3
		options.forEach(ele -> System.out.println(ele));
		
		
		browser.close();
		playwright.close();
		
		
	}

}
