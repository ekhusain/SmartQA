package de.telekom.simple.ta.pages.sales;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;

public class KundeSuchenPage {
    private final Page page;

    private final Locator kundenname;
    private final Locator gpNummer;
    private final Locator kundennummer;
    private Locator suchenButton;
    private Locator auswaehlenButton;
    private String customer;

    public KundeSuchenPage(Page page) {
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

    public NeuesVorhabenAnlegenPage doAuswaehlen(NeuesVorhabenAnlegenPage anlegenPage, SalesVorhabenData data) {
        auswaehlenButton = page.locator("//*[@id='customer-items-list']/div[1]/div[contains(., '" + data.getKundenname() +"')]//following-sibling::div/button");
        auswaehlenButton.click();
        return anlegenPage;
    }
}
