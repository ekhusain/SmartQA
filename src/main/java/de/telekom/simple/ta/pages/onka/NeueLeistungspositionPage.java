package de.telekom.simple.ta.pages.onka;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.testdata.simplebase.LeistungspositionInputData;
import de.telekom.simple.ta.utils.FieldInputUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NeueLeistungspositionPage extends LeistungenTabPage {

    Page page;
    private final Locator lpName;
    private final Locator lpEditName;
    private final Locator menge;
    private final Locator editMenge;
    private final Locator leistungsTyp;
    private final Locator portfolio;
    private final Locator inflationsfaktorRessourcen;
    private final Locator inflationsfaktorKosten;
    private final Locator checkboxAnnuitaetetenRechnen;
    private final Locator leistungsBeschreibung;
    private final Locator leistungsNachAufwand;
    private final Locator indirekteKosten;
    private final Locator lpAnlegenButton;
    private final Locator lpEditButton;
    private final Locator abbrechenButton;

    public NeueLeistungspositionPage(Page page) {
        super(page);
        this.page = page;
        this.lpName = page.locator("//input[@id='lp-name']");
        this.menge = page.locator("//input[@id='lp-menge']");
        this.leistungsTyp = page.locator("//select[@name='lp-leistungtyp']");
        this.portfolio = page.locator("//select[@name='portfolioId']");
        this.leistungsBeschreibung = page.locator("//textarea[@id='lp-beschreibung']");
        this.inflationsfaktorRessourcen = page.locator("//input[@id='lp-inRessourcen']");
        this.inflationsfaktorKosten = page.locator("//input[@id='lp-inKosten']");
        this.checkboxAnnuitaetetenRechnen = page.locator("//label[contains(., 'Annuitätenrechnung')]");
        this.leistungsNachAufwand = page.locator("//label[contains(., 'Leistung nach Aufwand')]");
        this.indirekteKosten = page.locator("//label[contains(., 'Indirekte Kosten')]");
        this.lpAnlegenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Leistungspositionen anlegen"));
        this.abbrechenButton = page.locator("//button[contains(., 'Abbrechen')]");

        /*
        Elements from Leistungsposition bearbeiten dialog
         */
        this.lpEditName = page.locator("//input[@id='name']");
        this.editMenge = page.locator("//input[@id='menge']");
        this.lpEditButton = page.locator("//button[contains(., 'Leistungsposition bearbeiten')]");

        assertThat(page.locator("//label[contains(., 'Leistungsposition')]")).isVisible();
        assertThat(page.locator("//label[contains(., 'Menge')]")).isVisible();
        assertThat(page.locator("//label[contains(., 'Leistungstyp')]")).isVisible();
        assertThat(page.locator("//label[contains(., 'Portfolio')]")).isVisible();
        assertThat(page.locator("//label[contains(., 'Inflationsfaktor Ressourcen')]")).isVisible();
        assertThat(page.locator("//label[contains(., 'Inflationsfaktor Kosten')]")).isVisible();
        assertThat(page.locator("//label[contains(., 'Leistungsbeschreibung')]")).isVisible();
    }

    public void fillLPData(LeistungspositionInputData inputData) {
        lpName.fill(inputData.getLeistungspositionName());
        menge.fill(inputData.getMenge().toString());
        FieldInputUtils.select2IfNotNull(page, leistungsTyp, inputData.getLeistungstyp().toSelectString());
        leistungsBeschreibung.fill("LP position was created with all mandatory data");
        leistungsNachAufwand.click();
        indirekteKosten.click();
    }

    public void fillLPEditData(LeistungspositionInputData inputData) {
        lpEditName.fill(inputData.getLeistungspositionName());
        editMenge.fill(inputData.getMenge().toString());
        FieldInputUtils.select2IfNotNull(page, leistungsTyp, inputData.getLeistungstyp().toSelectString());
        leistungsBeschreibung.fill("LP position was created with all mandatory data");
        indirekteKosten.click();
    }

    public BrowserContext doLPAnlegen() {
        lpAnlegenButton.click();
        return page.context();
    }

    public BrowserContext doLpBearbeiten() {
        lpEditButton.click();
        return page.context();
    }

}
