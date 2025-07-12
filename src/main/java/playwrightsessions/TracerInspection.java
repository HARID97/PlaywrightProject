package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class TracerInspection {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
   // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://www.google.co.in/");
      page.locator("iframe[name=\"callout\"]").contentFrame().getByLabel("Stay signed out").click();
      page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
      page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("microsoft");
      page.getByLabel("Google apps").click();
      page.locator(".L3eUgb > div:nth-child(2)").click();
      
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}