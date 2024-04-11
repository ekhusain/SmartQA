package de.telekom.simple.ta.pages.onka;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import de.telekom.simple.ta.enums.SimpleGroupedMenuItems;
import de.telekom.simple.ta.testdata.simplebase.OnkaBerechnungData;
import de.telekom.simple.ta.utils.FieldInputUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BerechnungErstellenPage extends LeistungenTabPage {

    Page page;
    private final Locator nameBer;
    private final Locator operator;
    private final Locator variable;
    private final Locator wert;
    private final Locator kommentar;
    //private final Locator berechnungErstellenBtn;
    private final Locator abbrechenBtn;
    //private final Locator berBearbeitenBtn;

    public BerechnungErstellenPage(Page page) {
        super(page);
        this.page = page;
        this.nameBer = page.locator("//input[@id='ber-name']");
        this.operator = page.locator("//select[@name='ber-operator']");
        this.variable = page.locator("//select[@name='ber-variable']");
        this.wert = page.locator("//input[@id='ber-wert']");
        this.kommentar = page.locator("//textarea[@id='ber-kommentar']");
        //this.berechnungErstellenBtn = page.locator("//div[@class='modal-content']/descendant::button[contains(., 'Berechnung erstellen')]");
        this.abbrechenBtn = page.locator("//button[contains(., 'Abbrechen')]");
        //this.berBearbeitenBtn = page.locator("//button[contains(., 'Berechnung bearbeiten')]");

        assertThat(page.locator("//label[@id='ber-name__label']")).isVisible();
        assertThat(page.locator("//label[@id='ber-operator__label']")).isVisible();
        assertThat(page.locator("//label[@id='ber-variable__label']")).isVisible();
        assertThat(page.locator("//label[@id='ber-wert__label']")).isVisible();
        assertThat(page.locator("//label[@id='ber-kommentar__label']")).isVisible();

    }

    public enum OperatorEnumItems implements SimpleGroupedMenuItems {
        EMPTY("", ""),

        ADDITION("Addition", "+"),

        SUBTRAKTION("Subtraktion", "-"),

        MULTIPLIKATION("Multiplikation", "*"),

        DIVISION("Division", "/"),

        ;
        private String valueString;
        private String optgroup;

        OperatorEnumItems(String valueString, String optgroup) {
            this.valueString = valueString;
            this.optgroup = optgroup;
        }

        public String toSelectString() {
            return valueString;
        }

        public String getOptgroupLabel() {
            return optgroup;
        }

    } // end enum

    public enum VariableEnumItems implements SimpleGroupedMenuItems {
        EMPTY("", ""),

        ;
        private String valueString;
        private String optgroup;

        VariableEnumItems(String valueString, String optgroup) {
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

    public enum ZielobjektEnumItems implements SimpleGroupedMenuItems {
        KALKULATIONSELEMENT("Kalkulationselement", ""),
        LEISTUNGSPOSITION("Leistungsposition", ""),

        ;
        private String valueString;
        private String optgroup;

        ZielobjektEnumItems(String valueString, String optgroup) {
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

    public void fillBerechnungData(OnkaBerechnungData berData) {
        nameBer.fill(berData.getBezeichnung());
        FieldInputUtils.select2IfNotNull(page, operator, berData.getOperator().toSelectString());
        if (berData.getVariable() !=null) {
            FieldInputUtils.select2IfNotNull(page, variable, berData.getVariable().toSelectString());
        }
        wert.fill(String.valueOf(berData.getWert()));
        kommentar.fill(berData.getKommentar());
    }

    public BrowserContext doBerechnungErstellen() {
        page.locator("//div[@class='modal-content']/descendant::button[contains(., 'Berechnung erstellen')]").click();
        return page.context();
    }
    public BrowserContext doBerechnungBearbeiten() {
        page.locator("//div[@class='modal-content']/descendant::button[contains(., 'Berechnung bearbeiten')]").click();
        return page.context();
    }

}
