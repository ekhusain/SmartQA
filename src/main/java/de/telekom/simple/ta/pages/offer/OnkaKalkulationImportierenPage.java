package de.telekom.simple.ta.pages.offer;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.testdata.simplebase.SimpleOnlineKalkulationData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OnkaKalkulationImportierenPage {

    Page page;
    private final Locator apSuchenInput;
    private final Locator suchenButton;
    private final Locator kalkulationImportButton;
    private final Locator schliessenButton;

    public OnkaKalkulationImportierenPage(Page page) {
        this.page = page;
        this.apSuchenInput = page.locator("//input[@id='ap_suchen-input']");
        this.suchenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Suchen"));
        // page.locator("//button[contains(., 'Suchen')]");
        this.kalkulationImportButton = page.locator("//button[@title='Kalkulation importieren']");
        this.schliessenButton = page.locator("//button[contains(., 'Schließen')]");

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Kalkulation importieren"))).isVisible();
    }

    public void fillFormData(SimpleOnlineKalkulationData kalkulationData) {
        apSuchenInput.fill(kalkulationData.getSearchType());
    }

    public BrowserContext doSuchen() {
        suchenButton.click();
        return page.context();
    }

    public BrowserContext doKalkulationImport() {
        kalkulationImportButton.click();
        return page.context();
    }

    public OfferDashboardPage doSchliessen() {
        schliessenButton.click();
        return new OfferDashboardPage(page);
    }
}
