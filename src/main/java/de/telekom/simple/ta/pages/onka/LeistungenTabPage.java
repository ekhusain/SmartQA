package de.telekom.simple.ta.pages.onka;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.base.SimpleBasicPage;
import de.telekom.simple.ta.pages.SimpleAlertPage;
import de.telekom.simple.ta.testdata.simplebase.LeistungspositionInputData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LeistungenTabPage extends SimpleBasicPage {

    Page page;

    private final Locator neueLPButton;
    private final Locator weitereOptionen;
    private final Locator verteilungButton;

    public LeistungenTabPage(Page page) {
        super(page);
        this.page = page;
        this.neueLPButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Neue Leistungsposition"));
        this.weitereOptionen = page.locator("//div[@id='moreOptionsButton']");
        this.verteilungButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verteilung"));

        assertThat(neueLPButton).isVisible();
        assertThat(weitereOptionen).isVisible();
        assertThat(verteilungButton).isVisible();
    }

    public NeueLeistungspositionPage clickLPButton() {
        neueLPButton.click();
        return new NeueLeistungspositionPage(page);
    }

    public BrowserContext clickVerteilung() {
        verteilungButton.click();
        return page.context();
    }

    public void verifyLPTable(LeistungspositionInputData lpName) {
        assertThat(page.locator("//tbody/tr/td[contains(., '" + lpName.getLeistungspositionName() + "')]")).isVisible();
    }

    public BrowserContext doShowLPDetails(String lpName) {
        page.locator("//tbody/tr/td[contains(., '"+ lpName + "')]/button[@title='Details öffnen']").click();
        return page.context();
    }

    public NeuesElementHinzufuegenPage doNeuesElement(String lpName) {
        page.locator("//tbody/tr/td[contains(., '"+ lpName + "')]/following::button[@title='Neues Element']").click();
        return new NeuesElementHinzufuegenPage(page);
    }

    public BrowserContext doNeuesBerechnung(String lpName) {
        page.locator("//tbody/tr/td[contains(., '"+ lpName + "')]/following::button[@title='Neue Berechnung']").click();
        return page.context();
    }

    public BrowserContext doLPVerteilen(String lpName) {
        page.locator("//tbody/tr/td[contains(., '"+ lpName + "')]/following::button[@title='Leistungsposition verteilen']").click();
        return page.context();
    }

    public NeueLeistungspositionPage doLPBearbeitung(String lpName) {
        page.locator("//tbody/tr/td[contains(., '"+ lpName + "')]/following::button[@title='Leistungsposition bearbeiten']").click();
        return new NeueLeistungspositionPage(page);
    }

    public BrowserContext doLPCopy(String lpName) {
        page.locator("//tbody/tr/td[contains(., '"+ lpName + "')]/following::button[@title='Leistungsposition kopieren']").click();
        return page.context();
    }

    public SimpleAlertPage doLPDelete(String lpName) {
        page.locator("//tbody/tr/td[contains(., '"+ lpName + "')]/following::button[@title='Leistungsposition löschen']").click();
        return new SimpleAlertPage(page);
    }

    public void verifyElement(String lpName, String elData) {
        assertThat(page.locator("//tbody/tr/td[contains(., '" + lpName + "')]")).isVisible();
        assertThat(page.locator("//table/tr/td[contains(., '" + elData + "')]")).isVisible();
    }

    public BrowserContext doCreateElementBer(String lpName, String elName) {
        doShowLPDetails(lpName);
        page.locator("//table/tr/td[contains(., '" + elName + "')]/following::button[1]").click();
        return page.context();
    }

    public NeuesElementHinzufuegenPage doElementEdit(String elName) {
        page.locator("//table/tr/td[contains(., '" + elName + "')]/following::button[2]").click();
        return new NeuesElementHinzufuegenPage(page);
    }

    public SimpleAlertPage doElementDelete(String elName) {
        page.locator("//table/tr/td[contains(., '" + elName + "')]/following::button[3]").click();
        return new SimpleAlertPage(page);
    }

}
