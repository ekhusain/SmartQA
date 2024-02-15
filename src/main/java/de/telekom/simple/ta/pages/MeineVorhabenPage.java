package de.telekom.simple.ta.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;
import de.telekom.simple.ta.utils.FieldInputUtils;

public class MeineVorhabenPage {
    private final Page page;
    private Locator sin;
    private final Locator projectSearchInput;

    public MeineVorhabenPage(Page page) {
        this.page = page;
        this.projectSearchInput = page.locator("//input[@id='projects-search-input']");
    }

    public SalesDashboardStammdatenPage sinAuswaehlen(String sinValue) {
        sin = page.locator("//table[@id='my-projects-table']/tbody/tr/td/a[.='" + sinValue + "']");
        sin.click();
        return new SalesDashboardStammdatenPage(page);
    }

    public void fillSuchenText(String text) {
        FieldInputUtils.typeIfNotNull(projectSearchInput, text);
        projectSearchInput.press("Enter");
    }
}
