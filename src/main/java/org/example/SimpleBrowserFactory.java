package org.example;

import com.microsoft.playwright.*;

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
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome"));
                break;

            default:
                System.out.println("please pass the right browser name ...");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("http://develop.simplardev.telekom.de/auth");

        return page;

    }
}
