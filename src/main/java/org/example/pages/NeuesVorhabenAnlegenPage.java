package org.example.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.base.SimpleGroupedMenuItems;
import org.example.testdata.SalesVorhabenData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NeuesVorhabenAnlegenPage {
    private final Page page;
    private String sicherheitsstufe;
    private final Locator vorhabenname;
    private final Locator angebotsvolumen;
    private final Locator stammSin;
    private final Locator vertragsbeginn;
    private final Locator vertragsende;
    private Locator fasttrackCheckbox;
    private final Locator kundeAuswaehlenButton;
    private final Locator neuesVorhabenButton;


    public NeuesVorhabenAnlegenPage(Page page) {
        this.page = page;
        this.vorhabenname = page.locator("//input[@id='vorhabenname-input']");
        this.angebotsvolumen = page.locator("//input[@id='volumenDtts-input']");
        this.stammSin = page.locator("//input[@id='stammSimpleId-input']");
        this.vertragsbeginn = page.locator("//input[@id='vertragsbeginn-input']");
        this.vertragsende = page.locator("//input[@id='vertragsende-input']");
        this.kundeAuswaehlenButton = page.locator("//button[@id='btn-select-customer']");
        this.fasttrackCheckbox = page.getByLabel("Fasttrack Angebot");
        this.neuesVorhabenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Neues Vorhaben anlegen"));

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Neues Vorhaben anlegen"))).isVisible();
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Vorhaben anlegen"))).isVisible();
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Kunde auswählen"))).isVisible();

    }

    public enum SicherheitsstufeEnumItems implements SimpleGroupedMenuItems {
        STANDARD("Standard", ""),
        VERSCHLUSSSACHE("Verschlusssache", ""),
        CHINESEWALL("Chinese Wall", ""),

        ;
        private final String valueString;
        private final String optgroup;

        SicherheitsstufeEnumItems(String valueString, String optgroup) {
            this.valueString = valueString;
            this.optgroup = optgroup;
        }

        @Override
        public String toSelectString() {
            return valueString;
        }

        @Override
        public String getOptgroupLabel() {
            return optgroup;
        }

    } // end enum

    public BrowserContext doFillNeuesVorhaben(SalesVorhabenData vorhabenData) {
        page.getByLabel("Sicherheitsstufe*").selectOption(vorhabenData.getSicherheitsstufe().toSelectString());
        vorhabenname.fill(vorhabenData.getVorhabenname());
        angebotsvolumen.fill(vorhabenData.getVolumenDtts().toString());
        vertragsbeginn.fill(vorhabenData.getVertragsbeginn().toString());
        vertragsende.fill(vorhabenData.getVertragsende().toString());
        return page.context();
    }

    public void doFasttrackAngebot() {
        fasttrackCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setChecked(true));
    }

    public CustomerSearchPage doKundeAuswaehlen() {
        kundeAuswaehlenButton.click();
        return new CustomerSearchPage(page);
    }

    public BrowserContext doNeuesVorhaben() {
        neuesVorhabenButton.click();
        return page.context();
    }
}
