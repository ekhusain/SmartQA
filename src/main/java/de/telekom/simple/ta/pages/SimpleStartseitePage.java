package de.telekom.simple.ta.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.pages.sales.AnfragelisteIspPage;
import de.telekom.simple.ta.pages.sales.NeuesVorhabenAnlegenPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SimpleStartseitePage {

    private final Page page;
    private final Locator neuesVorhabenAnlegen;
    private final Locator meineVorhaben;
    private final Locator anfrageListeISP;
    private final Locator salesOfferMenu;

    public SimpleStartseitePage(Page page) {
        this.page = page;
        this.meineVorhaben = page.locator("//span[contains(.,'Meine Vorhaben')]");
        this.neuesVorhabenAnlegen = page.locator("//span[contains(., 'Neues Vorhaben anlegen')]");
        this.anfrageListeISP = page.locator("//span[contains(.,'Anfrageliste ISP')]");
        this.salesOfferMenu = page.locator("//button[@id='sales-offer']");

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Startseite"))).isVisible();
    }

    public NeuesVorhabenAnlegenPage doNeuesVorhabenAnlegen() {
        salesOfferMenu.click();
        neuesVorhabenAnlegen.click();
        return new NeuesVorhabenAnlegenPage(page);
    }

    public MeineVorhabenPage openMeineVorhaben() {
        meineVorhaben.click();
        return new MeineVorhabenPage(page);
    }

    public AnfragelisteIspPage openAnfrageListeISP() {
        salesOfferMenu.click();
        anfrageListeISP.click();
        return new AnfragelisteIspPage(page);
    }

}
