package de.telekom.simple.ta.pages.sales;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;
import de.telekom.simple.ta.utils.FieldInputUtils;

public class AngebotAnfordernPage {
    Page page;
    private final Locator geplanterVertragsbeginn;
    private final Locator geplantesVertragsende;
    private final Locator lieferterminAngebot;
    private final Locator angebotAnfordernButton;

    public AngebotAnfordernPage(Page page) {
        this.page = page;
        this.geplanterVertragsbeginn = page.locator("//input[@id='vertragsbeginn-input']");
        this.geplantesVertragsende = page.locator("//input[@id='vertragsende-input']");
        this.lieferterminAngebot = page.locator("//input[@id='liefertermin_angebot-input']");
        this.angebotAnfordernButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Angebot anfordern"));
    }

    public void fillAngebotAnfordern(SalesVorhabenData vorhabenData) {
        geplanterVertragsbeginn.press("Control+a");
        geplanterVertragsbeginn.press("Delete");
        FieldInputUtils.typeIfNotNull(geplanterVertragsbeginn, vorhabenData.getVertragsbeginn());
        FieldInputUtils.typeIfNotNull(geplantesVertragsende, vorhabenData.getVertragsende());
        FieldInputUtils.typeIfNotNull(lieferterminAngebot, vorhabenData.getLieferterminAngebot());
    }

    public SalesDashboardStammdatenPage angebotAnfordernSpeichern() {
        angebotAnfordernButton.click();
        return new SalesDashboardStammdatenPage(page);
    }
}
