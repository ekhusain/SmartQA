package de.telekom.simple.ta.pages.onka;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.testdata.simplebase.KalkulationsElementData;
import de.telekom.simple.ta.utils.FieldInputUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NeuesElementHinzufuegenPage extends LeistungenTabPage {

    Page page;
    private final Locator elName;
    private final Locator kostenart;
    private final Locator hour;
    private final Locator mengenabhaengig;
    private final Locator inflationsfaktor;
    private final Locator kostenstelle;
    private final Locator taetigkeitsbeschreibung;
    private final Locator elementAnlegenButton;
    private final Locator abbrechenButton;

    public NeuesElementHinzufuegenPage(Page page) {
        super(page);
        this.page = page;
        this.elName = page.locator("//input[@id='element-name']");
        this.kostenart = page.locator("//select[@id='element-kostenart']");
        this.hour = page.locator("//input[@id='hour']");
        this.mengenabhaengig = page.locator("//label[contains(., 'Mengenabhängig')]");
        this.inflationsfaktor = page.locator("//label[contains(., 'Inflationsfaktor anwenden')]");
        this.kostenstelle = page.locator("//select[@id='element-kostenstelle']");
        this.taetigkeitsbeschreibung = page.locator("//textarea[@id='element-beschreibung']");

        this.elementAnlegenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Speichern"));
        this.abbrechenButton = page.locator("//button[contains(., 'Abbrechen')]");

        assertThat(page.locator("//label[@id='element-kostenart__label']")).isVisible();
        assertThat(page.locator("//label[@id='element-name__label']")).isVisible();
        assertThat(page.locator("//label[@id='hour__label']")).isVisible();
        assertThat(page.locator("//label[@id='element-kostenstelle__label']")).isVisible();
        assertThat(page.locator("//label[@id='element-beschreibung__label']")).isVisible();
    }

    public void fillElementData(KalkulationsElementData elData) {
        elName.fill(elData.getBezeichnung());
        FieldInputUtils.select2IfNotNull(page, kostenart, elData.getKostenart().toSelectString());
        hour.fill(elData.getAufwandStunden().toString());
        taetigkeitsbeschreibung.fill(elData.getBeschreibung());
    }

    public BrowserContext doElementAnlegen() {
        elementAnlegenButton.click();
        return page.context();
    }

}
