package de.telekom.simple.ta.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.pages.SimpleStartseitePage;
import de.telekom.simple.ta.testdata.model.User;

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

    public SimpleStartseitePage doLogin(User user) {
        username.fill(user.getBenutzername());
        password.fill(user.getPasswort());
        loginButton.click();

        return new SimpleStartseitePage(page);
    }

}
