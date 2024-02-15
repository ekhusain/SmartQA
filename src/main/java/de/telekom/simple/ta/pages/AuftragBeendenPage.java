package de.telekom.simple.ta.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.enums.SimpleGroupedMenuItems;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;
import de.telekom.simple.ta.utils.FieldInputUtils;

public class AuftragBeendenPage {
    Page page;
    private final Locator grund;
    private Locator beendenButton;

    public AuftragBeendenPage(Page page) {
        this.page = page;
        this.grund = page.locator("//select[@id='reason-id']");
    }

    public enum AuftragBeendenEnumItems implements SimpleGroupedMenuItems {

        VERTRAG_BEENDET("Vertrag Beendet", ""),
        GEKUENDIGT_AUFTRAGNEHMER("Gekündigt (Auftragnehmer)", ""),
        GEKUENDIGT_AUFTRAGGEBER("Gekündigt (Auftraggeber)", ""),
        ;

        private String valueString;
        private String optgroup;

        AuftragBeendenEnumItems(String valueString, String optgroup) {
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
    }

    public void fillFormData(SalesVorhabenData data) {
        FieldInputUtils.select2IfNotNull(page, grund, data.getAbgeschlossenGrund().toSelectString());
    }

    public SalesDashboardStammdatenPage doAuftragBeenden() {
        beendenButton = page.locator("//button[contains(., 'Auftrag beenden')]");
        beendenButton.click();
        return new SalesDashboardStammdatenPage(page);
    }


}
