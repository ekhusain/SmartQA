package testfunctions;

import de.telekom.simple.ta.pages.sales.KlassifizierungBearbeitenPage;
import de.telekom.simple.ta.pages.sales.KundeSuchenPage;
import de.telekom.simple.ta.pages.sales.NeuesVorhabenAnlegenPage;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;

public class MeineAngeboteFunctions {

    public static String doAnlegenNeuesVorhaben(NeuesVorhabenAnlegenPage anlegenPage, SalesVorhabenData vorhabenData, SalesVorhabenData klassificationData) {
        //Go to Neues Vorhaben anlegen page and fill all mandatory parameters

        anlegenPage.doFillNeuesVorhaben(vorhabenData);
        //Search customer and save it

        KundeSuchenPage kundeSuchenPage = anlegenPage.doKundeAuswaehlen();
        kundeSuchenPage.fillCustomerForSearch(vorhabenData);
        kundeSuchenPage.doSearch();
        kundeSuchenPage.doAuswaehlen(anlegenPage, vorhabenData);
        //Save the form and check created project data
        SalesDashboardStammdatenPage stammdatenPage =  anlegenPage.doNeuesVorhaben();
        stammdatenPage.verifyVorhabenData(vorhabenData);
        KlassifizierungBearbeitenPage klassifizierungBearbeitenPage = stammdatenPage.doKlassifizierung();
        klassifizierungBearbeitenPage.addKlassifizierung(klassificationData);
        stammdatenPage = klassifizierungBearbeitenPage.doSpeichern();

        return stammdatenPage.getSin().textContent();
    }

}
