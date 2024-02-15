package de.telekom.simple.ta.pages.sales;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.base.SimpleBasicPage;
import de.telekom.simple.ta.utils.FieldInputUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AnfragelisteIspPage extends SimpleBasicPage {
    Page page;
    private Locator angebotserstellerZuweisen;
    private final Locator filterSuchenStatusMenu;
    private Locator project;

    public AnfragelisteIspPage(Page page) {
        super(page);
        this.page = page;
        this.filterSuchenStatusMenu = page.locator("//select[@id='status-filter']");
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Anfrageliste"))).isVisible();
    }

    public enum AnfrageListeFilterSuchenStatusItems {
        Offene_Anfragen_S1 {
            @Override
            public String toString() {
                return "Offene Anfragen";
            }
        },
        Zugeordnete_Anfragen {
            @Override
            public String toString() {
                return "Zugeordnete Anfragen";
            }
        },
        Abgelehnte_Anfragen {
            @Override
            public String toString() {
                return "Abgelehnte Anfragen";
            }
        },
        Angebote_und_Auftraege {
            @Override
            public String toString() {
                return "Angebote und Aufträge";
            }
        }
    }

        public AngebotserstellerZuordnenPage angebotserstellerZuweisen(String sinValue) {
        angebotserstellerZuweisen = page.locator("//tbody/tr/td/a[.='"+ sinValue + "']/../../descendant::button[@title='Angebotsersteller zuweisen']");
        angebotserstellerZuweisen.click();
        return new AngebotserstellerZuordnenPage(page);
    }

    /**
     * Select entry for item i in the menu for "Status" to be searched for
     *
     */
    public void selectFilterSuchenStatus() {
        FieldInputUtils.select2IfNotNull(page, filterSuchenStatusMenu, AnfrageListeFilterSuchenStatusItems.Zugeordnete_Anfragen.toString());
    }

    public void verifySin(String sin) {
        project = page.locator("//tbody/tr/td/a[.='"+ sin + "']/../..");
    }

}
