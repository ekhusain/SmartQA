package de.telekom.simple.ta.pages.sales;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.base.SimpleBasicPage;
import de.telekom.simple.ta.pages.*;
import de.telekom.simple.ta.pages.offer.OfferDashboardAngebotBeauftragenPage;
import de.telekom.simple.ta.pages.offer.OfferDashboardPage;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SalesDashboardStammdatenPage extends SimpleBasicPage {

    private final Page page;
    private final Locator sin;
    private final Locator vorhaben;
    private final Locator status;
    private final Locator einstellungenButton;
    private final Locator weitereOptionen;
    private final Locator stammdatenTab;
    private final Locator vorhabenDataEdit;
    private final Locator kundenDataEdit;
    private final Locator klassifizierungHinzufuegenButton;
    private final Locator weitereMerkmaleEdit;
    private final Locator angebotAnfordernLink;
    private final Locator bearbeitungBeginnenLink;
    private final Locator dashboardSwitch;
    private final Locator offerDashboardLink;
    private final Locator angebotBeauftragenLink;
    private final Locator produktionsreifeBestaetigen;
    private final Locator auftragBeendenLink;


    public SalesDashboardStammdatenPage(Page page) {
        super(page);
        this.page = page;
        this.sin = page.locator("//*[@id=\"dashboard-header\"]/div/div[1]/div[1]");
        this.vorhaben = page.locator("//div[@class='label-text' and .='Vorhaben · Kunde']/following-sibling::div[1]");
        this.status = page.locator("//div[@class='label-text' and .='Status']/following-sibling::div[1]");
        this.einstellungenButton = page.locator("//div[@id='workflowButtonDropdown']");
        this.weitereOptionen =  page.getByTitle("Weitere Optionen");
        this.stammdatenTab = page.locator("//span[@class='text' and .='Stammdaten']");
        this.vorhabenDataEdit = page.locator("//div[@id='editProject']");
        this.kundenDataEdit = page.locator("//div[@id='customerEdit']");
        this.klassifizierungHinzufuegenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Klassifizierung bearbeiten"));
        this.weitereMerkmaleEdit = page.getByTitle("Merkmale bearbeiten");
        this.angebotAnfordernLink = page.locator("//li/a[contains(., 'Angebot anfordern')]");
        this.bearbeitungBeginnenLink = page.locator("//li/a[contains(., 'Bearbeitung beginnen')]");
        this.dashboardSwitch = page.locator("//div[@id='dashboard-switch']");
        this.offerDashboardLink = page.locator("//div/div[2][contains(., 'Offer Dashboard')]");
        this.angebotBeauftragenLink = page.locator("//li/a[contains(., 'Angebot beauftragen')]");
        this.produktionsreifeBestaetigen = page.locator("//li/a[contains(., 'Produktionsreife bestätigen')]");
        this.auftragBeendenLink = page.locator("//li/a[contains(., 'Vertrag beenden')]");
        
    }

    public Locator getSin() { return sin; }

    public void verifyVorhabenData(SalesVorhabenData vorhabenData) {
        assertThat(sin).isVisible();
        vorhaben.getByText(vorhabenData.getVorhabenname()).isVisible();
        einstellungenButton.isVisible();
        weitereOptionen.isVisible();
        stammdatenTab.isVisible();
    }

    public KlassifizierungBearbeitenPage doKlassifizierung() {
        klassifizierungHinzufuegenButton.click();
        return new KlassifizierungBearbeitenPage(page);
    }

    public AngebotAnfordernPage doAngebotAnfordern() {
        einstellungenButton.click();
        angebotAnfordernLink.click();
        return new AngebotAnfordernPage(page);
    }

    public SimpleAlertPage doBearbeitungBeginnen() {
        einstellungenButton.click();
        bearbeitungBeginnenLink.click();
        return new SimpleAlertPage(page);
    }

    public OfferDashboardPage openOfferDashboard() {
        dashboardSwitch.click();
        offerDashboardLink.click();
        return new OfferDashboardPage(page);
    }

    public OfferDashboardAngebotBeauftragenPage doAngebotBeauftragen() {
        einstellungenButton.click();
        angebotBeauftragenLink.click();
        return new OfferDashboardAngebotBeauftragenPage(page);
    }

    public SimpleAlertPage doProduktionsreifeBestaetigen() {
        einstellungenButton.click();
        produktionsreifeBestaetigen.click();
        return new SimpleAlertPage(page);
    }

    public AuftragBeendenPage doAuftragBeenden() {
        einstellungenButton.click();
        auftragBeendenLink.click();
        return new AuftragBeendenPage(page);
    }

}
