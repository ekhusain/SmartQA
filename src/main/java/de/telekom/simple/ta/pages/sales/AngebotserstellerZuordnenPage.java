package de.telekom.simple.ta.pages.sales;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.utils.FieldInputUtils;

public class AngebotserstellerZuordnenPage {

    Page page;
    private final Locator suchenInput;
    private Locator angebotserstellerZuordnen;

    public AngebotserstellerZuordnenPage(Page page) {
        this.page = page;
        suchenInput = page.locator("//input[@id='search-filter']");
    }

    public void fillSuchenText(String searchText) {
        FieldInputUtils.typeIfNotNull(suchenInput, searchText);
    }

    public AnfragelisteIspPage doZuordnen() {
        angebotserstellerZuordnen = page.locator("//table[@id='projects-list-table']/descendant::button");
        angebotserstellerZuordnen.click();
        return new AnfragelisteIspPage(page);
    }



}
