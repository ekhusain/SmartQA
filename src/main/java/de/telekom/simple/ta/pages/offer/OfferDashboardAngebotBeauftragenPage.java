package de.telekom.simple.ta.pages.offer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.enums.SimpleMenuItems;
import de.telekom.simple.ta.pages.FinanceDashboardPage;
import de.telekom.simple.ta.testdata.simplebase.BeauftragungDurchfuehrenData;
import de.telekom.simple.ta.utils.FieldInputUtils;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OfferDashboardAngebotBeauftragenPage {
    Page page;
    private final Locator beauftragungsFile;
    private final Locator sapBestellnummer;
    private final Locator angebotsversion;
    private final Locator debitor;
    private final Locator vertragsbeginn;
    private final Locator vertragsende;
    private final Locator angebotBeauftragenButton;

    public OfferDashboardAngebotBeauftragenPage(Page page) {
        this.page = page;
        this.beauftragungsFile = page.locator("//label/span[contains(., 'Beauftragungsdatei')]");
        this.sapBestellnummer = page.locator("//input[@id='sapAuftragsNr']");
        this.angebotsversion = page.locator("//select[@id='vkVersion-input']");
        this.debitor = page.locator("//select[@id='debitor-input']");
        this.vertragsbeginn = page.locator("//input[@id='vertragsbeginn-input']");
        this.vertragsende = page.locator("//input[@id='vertragsende-input']");
        this.angebotBeauftragenButton = page.locator("//button[contains(., 'Angebot beauftragen')]");
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Angebot beauftragen")));

        assertThat(page.locator("//label[@id='sapAuftragsNr__label']")).isVisible();
        assertThat(page.locator("//label[@id='debitor-input__label']")).isVisible();
        assertThat(page.locator("//label[@id='vertragsbeginn-input__label']")).isVisible();
        assertThat(page.locator("//label[@id='vkVersion-input__label']")).isVisible();
        assertThat(page.locator("//label[@id='vertragsende-input__label']")).isVisible();

    }

    public enum AngebotsversionEnumItems implements SimpleMenuItems {
        NEUES_ANGEBOT("Erstversion"),
        ALTES_ANGEBOT("Ein altes Angebot");

        private String valueString;

        AngebotsversionEnumItems(String valueString) {
            this.valueString = valueString;
        }

        public String toSelectString() {
            return valueString;
        }
    }

    public void fillAngebotBeauftragen(BeauftragungDurchfuehrenData data) {
        sapBestellnummer.fill(data.getSapAuftragsNummer());
        page.waitForTimeout(1500);
        FieldInputUtils.select2IfNotNullContains(page, angebotsversion, data.getAngebotsversion());
        page.waitForTimeout(1500);
        FieldInputUtils.select2IfNotNullContains(page, debitor, data.getDebitor());
    }
    public void enterBeauftragungsdatei(String angebotFile) {
        beauftragungsFile.setInputFiles(Paths.get(angebotFile));
    }

    public FinanceDashboardPage doAngebotBeauftragen() {
        angebotBeauftragenButton.click();
        return new FinanceDashboardPage(page);
    }

}
