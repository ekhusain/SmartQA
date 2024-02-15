package de.telekom.simple.ta;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class SimpleBrowserFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName) {

        System.out.println("browser name is" + browserName);

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setExecutablePath(Paths.get("C:/Users/A11336979/AppData/Local/ms-playwright/chrome-win/chrome.exe")).setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            default:
                System.out.println("please pass the right browser name ...");
                break;
        }

        //browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1700, 1000));
        browserContext = browser.newContext();
        page = browserContext.newPage();

        return page;

    }
}
