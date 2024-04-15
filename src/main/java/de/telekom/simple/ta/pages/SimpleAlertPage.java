package de.telekom.simple.ta.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.pages.offer.OfferDashboardPage;
import de.telekom.simple.ta.pages.onka.LeistungenTabPage;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;

public class SimpleAlertPage {
    Page page;
    Locator confirmButton;

    public SimpleAlertPage(Page page) {
        this.page = page;
        confirmButton = page.locator("//button[@class='btn btn-primary' and .='Bestätigen']");
    }

    public OfferDashboardPage doConfirmAction() {
        confirmButton.click();
        return new OfferDashboardPage(page);
    }

    public SalesDashboardStammdatenPage doBestaetigen() {
        page.locator("//button[contains(., 'Bestätigen')]").click();
        return new SalesDashboardStammdatenPage(page);
    }

    public LeistungenTabPage doLpLoschen() {
        page.getByRole(AriaRole.BUTTON).and(page.getByText("Leistungsposition löschen")).click();
        return new LeistungenTabPage(page);
    }

    public LeistungenTabPage doElementLoschen() {
        page.getByRole(AriaRole.BUTTON).and(page.getByText("Element löschen")).click();
        return new LeistungenTabPage(page);
    }

    public LeistungenTabPage doBerechnungLoeschen() {
        page.getByRole(AriaRole.BUTTON).and(page.getByText("Berechnung löschen")).click();
        return new LeistungenTabPage(page);
    }

}
