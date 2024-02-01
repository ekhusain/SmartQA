package org.example.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MeineVorhabenPage {

    private final Page page;
    private final Locator neuesVorhabenAnlegen;

    public MeineVorhabenPage(Page page) {
        this.page = page;
        this.neuesVorhabenAnlegen = page.getByTitle("Neues Vorhaben anlegen");

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Meine Vorhaben"))).isVisible();
    }

    public NeuesVorhabenAnlegenPage doNeuesVorhabenAnlegen() {
        neuesVorhabenAnlegen.click();
        return new NeuesVorhabenAnlegenPage(page);
    }
}
