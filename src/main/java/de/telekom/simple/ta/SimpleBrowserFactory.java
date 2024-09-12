package de.telekom.simple.ta;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.playwright.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

        // Start tracing before creating / navigating a page.
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        page.navigate("https://develop.simplardev.telekom.de/");

        // Stop tracing and export it into a zip archive.
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        return page;

    }

    /**
     * Setup of configuration of browser to test with
     */
    public class loadBrowserConfig {
        public void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                BrowserType chromium = playwright.chromium();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("browser", "playwright-chromium");
                jsonObject.addProperty("browser_version", "latest");
                jsonObject.addProperty("os", "osx");
                jsonObject.addProperty("os_version", "catalina");
                jsonObject.addProperty("browserstack.networkLogs", true);
                jsonObject.addProperty("browserstack.local", true);
                jsonObject.addProperty("browserstack.console", "errors");
                jsonObject.addProperty("browserstack.username", "");
                jsonObject.addProperty("browserstack.accessKey", "");
                // Adding playwright arguments here
                JsonArray arguments = new JsonArray();
                arguments.add("--disable-print-preview");
                arguments.add("--ignore-certifcate-errors");
                jsonObject.add("args", arguments);
                String caps = URLEncoder.encode(jsonObject.toString(), "utf-8");
                String ws_endpoint = "wss://cdp.browserstack.com/playwright?caps=" + caps;
                Browser browser = chromium.connect(ws_endpoint);
                Page page = browser.newPage();
                page.navigate("http://127.0.0.1:3002");
                page.locator("[id=printBox]").click();
                Thread.sleep(10000);
                browser.close();
            } catch (UnsupportedEncodingException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
