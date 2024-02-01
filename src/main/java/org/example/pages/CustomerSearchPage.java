package org.example.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.testdata.SalesVorhabenData;

public class CustomerSearchPage {
    private final Page page;

    private final Locator kundenname;
    private final Locator gpNummer;
    private final Locator kundennummer;
    private Locator suchenButton;
    private Locator auswaehlenButton;
    private String customer;

    public CustomerSearchPage(Page page) {
        this.page = page;
        this.kundenname = page.locator("//input[@id='kundenname-input']");
        this.gpNummer = page.locator("//input[@id='gpNummer-input']");
        this.kundennummer = page.locator("//input[@id='kundennummer-input']");
        this.suchenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Suchen"));

    }

    public BrowserContext fillCustomerForSearch(SalesVorhabenData vorhabenData) {
        kundenname.fill(vorhabenData.getKundenname());
        return page.context();
    }

    public void doSearch() {
        suchenButton.click();
    }

    public void doAuswaehlen(String data) {
        auswaehlenButton = page.locator("//*[@id='customer-items-list']/div[1]/div[contains(., '" + data +"')]//following-sibling::div/button");
        auswaehlenButton.click();
    }
}
