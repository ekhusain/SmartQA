package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SimpleLoginPage {
    private final Page page;
    private final Locator username;
    private final Locator password;
    private final Locator loginButton;

    public SimpleLoginPage(Page page) {
        this.page = page;
        //this.username = page.getByTestId("username-input");
        this.username = page.locator("//input[@id='username-input']");
        this.password = page.locator("//input[@id='password-input']");
        this.loginButton = page.locator("//button[contains(., 'Anmelden')]");
    }

    public void navigate() {
        page.navigate("http://develop.simplardev.telekom.de/auth");
    }

    public MeineVorhabenPage doLogin(String user, String userPassword) {
        username.fill(user);
        password.fill(userPassword);
        loginButton.click();

        return new MeineVorhabenPage(page);
    }

}
