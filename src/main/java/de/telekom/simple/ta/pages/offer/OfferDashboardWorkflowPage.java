package de.telekom.simple.ta.pages.offer;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.base.SimpleBasicPage;
import de.telekom.simple.ta.utils.FieldInputUtils;

import java.nio.file.Paths;
import java.time.LocalDate;

public class OfferDashboardWorkflowPage extends SimpleBasicPage {
    Page page;
    private final Locator angebotGueltig;
    private final Locator angebotsEmpfaenger;
    private final Locator angebotsDokument;
    private  final Locator angebotFertigstellenButton;
    private final Locator checkboxAngebot;
    private final Locator fertigstellenButton;

    public OfferDashboardWorkflowPage(Page page) {
        super(page);
        this.page = page;
        this.angebotGueltig = page.locator("//input[@id='validity-input']");
        this.angebotsEmpfaenger = page.locator("//input[@placeholder='Mitarbeiter suchen']");
        this.angebotsDokument = page.locator("//label[@class='custom-file-label']");
        this.angebotFertigstellenButton = page.locator("//button[contains(., 'Angebot fertigstellen')]");
        this.checkboxAngebot = page.locator("//label[contains(., 'Hiermit bestätige ich, dass das Angebot final ist und gemäß der aktuellen Richtlinien erstellt wurde.')]");
        this.fertigstellenButton = page.locator("//div[@class='modal-content']//button[contains(., 'Angebot fertigstellen')]");
    }

    public void enterAngebotsgueltigkeit(LocalDate date) {
        FieldInputUtils.typeIfNotNull(angebotGueltig, date);
    }

    public void enterAngebotFile(String filePath) {
        angebotsDokument.setInputFiles(Paths.get(filePath));
    }

    public void enterEmpfaenger(String name) {
        angebotsEmpfaenger.fill(name);
        Keyboard.PressOptions pressOptions = new Keyboard.PressOptions();
        pressOptions.setDelay(2000); // setting a 2 sec delay

        page.keyboard().press("Enter", pressOptions);
    }

    public void clickAngebotFertigstellen() {
        angebotFertigstellenButton.click();
    }

    public void setAngebotFertigstellen() {
        checkboxAngebot.click();
        fertigstellenButton.click();
    }

}
