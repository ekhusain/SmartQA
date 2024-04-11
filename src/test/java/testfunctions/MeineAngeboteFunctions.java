package testfunctions;

import de.telekom.simple.ta.pages.SimpleAlertPage;
import de.telekom.simple.ta.pages.offer.OfferDashboardPage;
import de.telekom.simple.ta.pages.onka.BerechnungErstellenPage;
import de.telekom.simple.ta.pages.onka.LeistungenTabPage;
import de.telekom.simple.ta.pages.onka.NeueLeistungspositionPage;
import de.telekom.simple.ta.pages.onka.NeuesElementHinzufuegenPage;
import de.telekom.simple.ta.pages.sales.KlassifizierungBearbeitenPage;
import de.telekom.simple.ta.pages.sales.KundeSuchenPage;
import de.telekom.simple.ta.pages.sales.NeuesVorhabenAnlegenPage;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;
import de.telekom.simple.ta.testdata.simplebase.KalkulationsElementData;
import de.telekom.simple.ta.testdata.simplebase.LeistungspositionInputData;
import de.telekom.simple.ta.testdata.simplebase.OnkaBerechnungData;
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
        stammdatenPage.pause(1500);
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
            //leistungenTabPage.verifyFlashMsgSuccessContains("Leistungspositionen erfolgreich gespeichert.");
            leistungenTabPage.verifyLPTable(inputData);
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doLPBearbeiten(OfferDashboardPage offerDashboardPage, List<LeistungspositionInputData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (LeistungspositionInputData inputData: inputDataList) {
            NeueLeistungspositionPage neueLeistungspositionPage = leistungenTabPage.doLPBearbeitung(inputData.getLeistungspositionNameOld());
            neueLeistungspositionPage.fillLPEditData(inputData);
            neueLeistungspositionPage.doLpBearbeiten();
            //leistungenTabPage.verifyFlashMsgSuccessContains("Erfolgreich gespeichert.");
            leistungenTabPage.verifyLPTable(inputData);
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doLPLoeschen(OfferDashboardPage offerDashboardPage, List<LeistungspositionInputData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (LeistungspositionInputData inputData: inputDataList) {
            SimpleAlertPage alertPage = leistungenTabPage.doLPDelete(inputData.getLeistungspositionName());
            alertPage.doLpLoschen();
            leistungenTabPage.pause(1500);
            //leistungenTabPage.verifyFlashMsgSuccessContains("Leistungsposition erfolgreich gelöscht");
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doNeuesElement(OfferDashboardPage offerDashboardPage, List<KalkulationsElementData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (KalkulationsElementData inputData: inputDataList) {
            for (int i = 0; i < inputData.getLeistungspositionsBezeichnung().length; i++) {
                leistungenTabPage.doShowLPDetails(inputData.getLeistungspositionsBezeichnung()[i]);
                NeuesElementHinzufuegenPage elementHinzufuegenPage = leistungenTabPage.doNeuesElement(inputData.getLeistungspositionsBezeichnung()[i]);
                elementHinzufuegenPage.fillElementData(inputData);
                elementHinzufuegenPage.pause(1200);
                elementHinzufuegenPage.doElementAnlegen();
                //leistungenTabPage.verifyFlashMsgSuccessContains("Elemente erfolgreich gespeichert");
                leistungenTabPage.verifyElement(inputData.getLeistungspositionsBezeichnung()[i], inputData.getBezeichnung());
            }
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doElementBearbeiten(OfferDashboardPage offerDashboardPage, List<KalkulationsElementData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (KalkulationsElementData inputData: inputDataList) {
            for (int i = 0; i < inputData.getLeistungspositionsBezeichnung().length; i++) {
                leistungenTabPage.doShowLPDetails(inputData.getLeistungspositionsBezeichnung()[i]);
                NeuesElementHinzufuegenPage elementHinzufuegenPage = leistungenTabPage.doElementEdit(inputData.getBezeichnungOld());
                elementHinzufuegenPage.fillElementData(inputData);
                elementHinzufuegenPage.doElementAnlegen();
                //leistungenTabPage.verifyFlashMsgSuccessContains("Element wurden erfolgreich aktualisiert.");
                leistungenTabPage.verifyElement(inputData.getLeistungspositionsBezeichnung()[i], inputData.getBezeichnung());
            }
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doDeleteElement(OfferDashboardPage offerDashboardPage, List<KalkulationsElementData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (KalkulationsElementData inputData: inputDataList) {
            for (int i = 0; i < inputData.getLeistungspositionsBezeichnung().length; i++) {
                leistungenTabPage.doShowLPDetails(inputData.getLeistungspositionsBezeichnung()[i]);
                SimpleAlertPage alertPage = leistungenTabPage.doElementDelete(inputData.getBezeichnung());
                alertPage.doElementLoschen();
                leistungenTabPage.pause(1500);
                //leistungenTabPage.verifyFlashMsgSuccessContains("Element wurde erfolgreich gelöscht.");
            }
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doLPBerErstellen(OfferDashboardPage offerDashboardPage, List<OnkaBerechnungData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (OnkaBerechnungData inputData: inputDataList) {
            for (int i = 0; i < inputData.getLeistungspositionsBezeichnung().length; i++) {
                BerechnungErstellenPage berechnungErstellenPage = leistungenTabPage.doNeueLPBerechnung(inputData.getLeistungspositionsBezeichnung()[i]);
                berechnungErstellenPage.fillBerechnungData(inputData);
                berechnungErstellenPage.pause(1000);
                berechnungErstellenPage.doBerechnungErstellen();
                leistungenTabPage.pause(1500);
                leistungenTabPage.doShowLPDetails(inputData.getLeistungspositionsBezeichnung()[i]);
                //leistungenTabPage.verifyFlashMsgSuccessContains("Berechnung erfolgreich gespeichert");
                leistungenTabPage.verifyElement(inputData.getLeistungspositionsBezeichnung()[i], inputData.getBezeichnung());
            }
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doLPBerBearbeiten(OfferDashboardPage offerDashboardPage, List<OnkaBerechnungData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (OnkaBerechnungData inputData: inputDataList) {
            for (int i = 0; i < inputData.getLeistungspositionsBezeichnung().length; i++) {
                leistungenTabPage.doShowLPDetails(inputData.getLeistungspositionsBezeichnung()[i]);
                BerechnungErstellenPage berechnungErstellenPage = leistungenTabPage.doLPBerEdit(inputData.getBezeichnung());
                berechnungErstellenPage.fillBerechnungData(inputData);
                berechnungErstellenPage.doBerechnungBearbeiten();
                //leistungenTabPage.verifyFlashMsgSuccessContains("Berechnung wurden erfolgreich aktualisiert.");
                leistungenTabPage.verifyElement(inputData.getLeistungspositionsBezeichnung()[i], inputData.getBezeichnung());
            }
        }
        return leistungenTabPage;
    }

    public static LeistungenTabPage doLPBerDelete(OfferDashboardPage offerDashboardPage, List<OnkaBerechnungData> inputDataList) {
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        for (OnkaBerechnungData inputData: inputDataList) {
            for (int i = 0; i < inputData.getLeistungspositionsBezeichnung().length; i++) {
                leistungenTabPage.doShowLPDetails(inputData.getLeistungspositionsBezeichnung()[i]);
                SimpleAlertPage alertPage = leistungenTabPage.doLPBerechnungDelete(inputData.getBezeichnung());
                leistungenTabPage = alertPage.doBerechnungLoeschen();
                leistungenTabPage.pause(1500);
            }
        }
        return leistungenTabPage;
    }

}
