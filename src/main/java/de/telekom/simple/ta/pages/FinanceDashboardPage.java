package de.telekom.simple.ta.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.base.SimpleBasicPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FinanceDashboardPage extends SimpleBasicPage {

    Page page;
    private final Locator einstellungenTab;
    private final Locator umsatzLBU;

    public FinanceDashboardPage(Page page) {
        super(page);
        this.page = page;
        this.einstellungenTab = page.locator("//li/a/span[.='Einstellungen']");
        this.umsatzLBU = page.locator("//li/a/span[.='Umsatz / LBU']");

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Finance Dashboard"))).isVisible();
    }


}
