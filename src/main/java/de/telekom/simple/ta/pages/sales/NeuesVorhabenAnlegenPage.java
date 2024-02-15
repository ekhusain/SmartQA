package de.telekom.simple.ta.pages.sales;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.enums.SimpleGroupedMenuItems;
import de.telekom.simple.ta.utils.FieldInputUtils;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NeuesVorhabenAnlegenPage {
    private final Page page;
    private final Locator sicherheitsstufe;
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
        this.sicherheitsstufe = page.locator("//select[@name='sicherheitsstufe']");
        this.vorhabenname = page.locator("//input[@id='vorhabenname-input']");
        this.angebotsvolumen = page.locator("//input[@id='volumenDtts-input']");
        this.stammSin = page.locator("//input[@id='stammSimpleId-input']");
        this.vertragsbeginn = page.locator("//input[@id='vertragsbeginn-input']");
        this.vertragsende = page.locator("//input[@id='vertragsende-input']");
        this.kundeAuswaehlenButton = page.locator("//button[@id='btn-select-customer']");
        this.fasttrackCheckbox = page.getByLabel("Fasttrack Angebot");
        this.neuesVorhabenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Neues Vorhaben anlegen"));

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Neues Vorhaben anlegen"))).isVisible();
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Vorhaben kopieren"))).isVisible();
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

    public void doFillNeuesVorhaben(SalesVorhabenData vorhabenData) {
        FieldInputUtils.select2IfNotNull(page, sicherheitsstufe, vorhabenData.getSicherheitsstufe().toSelectString());
        vorhabenname.fill(vorhabenData.getVorhabenname());
        angebotsvolumen.fill(vorhabenData.getVolumenDtts().toString());
        if (vorhabenData.getVertragsbeginn() !=null) {
            vertragsbeginn.fill(vorhabenData.getVertragsbeginn().toString());
        }
        if (vorhabenData.getVertragsende() !=null) {
            vertragsende.fill(vorhabenData.getVertragsende().toString());
        }
    }

    public void doFasttrackAngebot() {
        fasttrackCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setChecked(true));
    }

    public KundeSuchenPage doKundeAuswaehlen() {
        kundeAuswaehlenButton.click();
        return new KundeSuchenPage(page);
    }

    public SalesDashboardStammdatenPage doNeuesVorhaben() {
        neuesVorhabenButton.click();
        return new SalesDashboardStammdatenPage(page);
    }


}
