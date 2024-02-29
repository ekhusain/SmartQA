package testfunctions;

import de.telekom.simple.ta.pages.SimpleAlertPage;
import de.telekom.simple.ta.pages.offer.OfferDashboardPage;
import de.telekom.simple.ta.pages.onka.LeistungenTabPage;
import de.telekom.simple.ta.pages.onka.NeueLeistungspositionPage;
import de.telekom.simple.ta.pages.sales.KlassifizierungBearbeitenPage;
import de.telekom.simple.ta.pages.sales.KundeSuchenPage;
import de.telekom.simple.ta.pages.sales.NeuesVorhabenAnlegenPage;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;
import de.telekom.simple.ta.testdata.simplebase.LeistungspositionInputData;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;

import java.util.List;

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

    public static LeistungenTabPage doNeueLeistungsposition(OfferDashboardPage offerDashboardPage, List<LeistungspositionInputData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        NeueLeistungspositionPage neueLeistungspositionPage = leistungenTabPage.clickLPButton();
        for (LeistungspositionInputData inputData: inputDataList) {
            neueLeistungspositionPage.fillLPData(inputData);
            neueLeistungspositionPage.doLPAnlegen();
            leistungenTabPage.verifyFlashMsgSuccessContains("Leistungspositionen erfolgreich gespeichert.");
            leistungenTabPage.verifyLPTable(inputData);
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doLPBearbeiten(OfferDashboardPage offerDashboardPage, List<LeistungspositionInputData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (LeistungspositionInputData inputData: inputDataList) {
            NeueLeistungspositionPage neueLeistungspositionPage = leistungenTabPage.doLPBearbeitung(inputData.getLeistungspositionName());
            neueLeistungspositionPage.fillLPEditData(inputData);
            neueLeistungspositionPage.doLpBearbeiten();
            leistungenTabPage.verifyFlashMsgSuccessContains("Erfolgreich gespeichert.");
            leistungenTabPage.verifyLPTable(inputData);
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doLPLoeschen(OfferDashboardPage offerDashboardPage, List<LeistungspositionInputData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (LeistungspositionInputData inputData: inputDataList) {
            SimpleAlertPage alertPage = leistungenTabPage.doLPDelete(inputData.getLeistungspositionName());
            alertPage.doLpLoschen();
            leistungenTabPage.verifyFlashMsgSuccessContains("Leistungsposition erfolgreich gelöscht");
        }
        return leistungenTabPage;
    }



}
