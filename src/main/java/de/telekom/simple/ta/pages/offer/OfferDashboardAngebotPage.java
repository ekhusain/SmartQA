package de.telekom.simple.ta.pages.offer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OfferDashboardAngebotPage {

    Page page;
    private Locator neueAngebotspositionButton;
    private final Locator importierenButton;
    private final Locator kalkulationImportButton;


    public OfferDashboardAngebotPage(Page page) {
        this.page = page;
        this.neueAngebotspositionButton = page.locator("//button[@id='createButton__BV_button_']");
        this.importierenButton = page.locator("//div[@id='importierenButton']");
        this.kalkulationImportButton = page.locator("//li/button[contains(., 'Kalkulation importieren')]");
    }

    public OnkaKalkulationImportierenPage openKalkulationImport() {
        importierenButton.click();
        kalkulationImportButton.click();
        return new OnkaKalkulationImportierenPage(page);
    }
}
