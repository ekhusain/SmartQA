package tests;

import com.microsoft.playwright.Page;
import de.telekom.simple.ta.SimpleBrowserFactory;
import de.telekom.simple.ta.base.SimpleLoginPage;
import de.telekom.simple.ta.enums.LeistungstypItems;
import de.telekom.simple.ta.pages.MeineVorhabenPage;
import de.telekom.simple.ta.pages.SimpleStartseitePage;
import de.telekom.simple.ta.pages.offer.OfferDashboardPage;
import de.telekom.simple.ta.pages.onka.LeistungenTabPage;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;
import de.telekom.simple.ta.testdata.model.User;
import de.telekom.simple.ta.testdata.simplebase.LeistungspositionInputData;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testfunctions.LoginFunctions;
import testfunctions.MeineAngeboteFunctions;

import java.util.LinkedList;
import java.util.List;

public class SuiteOnkaTests extends SinPassingOrConsumingTests {

    Page page;
    SimpleBrowserFactory browserFactory;

    @Test(groups = {"g_createLP"},
            description = "Create new Leistung position")
    @Parameters({"sin"})
    public void testCreateLP(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        browserFactory = new SimpleBrowserFactory();
        page = browserFactory.initBrowser("chrome");
        SimpleLoginPage loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        SimpleStartseitePage startseitePage = new SimpleStartseitePage(page);

        List<LeistungspositionInputData> inputData = getTestDataLeistungspositionen();

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        MeineAngeboteFunctions.doNeueLeistungsposition(offerDashboardPage, inputData);

        leistungenTabPage.doLogout();
    }

    @Test(groups = {"g_testEditLP"},
            description = "Edit Leistungsposition")
    @Parameters({"sin"})
    public void testEditLP(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        browserFactory = new SimpleBrowserFactory();
        page = browserFactory.initBrowser("chrome");
        SimpleLoginPage loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        SimpleStartseitePage startseitePage = new SimpleStartseitePage(page);

        List<LeistungspositionInputData> inputData = getTestDataLPBearbeiten();

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        MeineAngeboteFunctions.doLPBearbeiten(offerDashboardPage, inputData);

        leistungenTabPage.doLogout();
    }

    @Test(groups = {"g_testDeleteLP"},
            description = "Delete existing Leistungsposition")
    @Parameters({"sin"})
    public void testDeleteLP(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        browserFactory = new SimpleBrowserFactory();
        page = browserFactory.initBrowser("chrome");
        SimpleLoginPage loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        SimpleStartseitePage startseitePage = new SimpleStartseitePage(page);

        List<LeistungspositionInputData> inputData = getTestDataLPBearbeiten();

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        MeineAngeboteFunctions.doLPLoeschen(offerDashboardPage, inputData);

        leistungenTabPage.doLogout();
    }

    public static User getUserData() {
        User userData = new User();
        userData.setBenutzername("test1171.admin");
        userData.setPasswort("test.admin01");
        return userData;
    }

    private static List<LeistungspositionInputData> getTestDataLeistungspositionen() {
        List<LeistungspositionInputData> itemDataList = new LinkedList<>();
        LeistungspositionInputData itemData;

        itemData = new LeistungspositionInputData();
        itemData.setLeistungspositionName("LP_1");
        itemData.setLeistungstypType(LeistungstypItems.CONSULTING);
        itemData.setBeschreibung("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus fringilla lacus non condimentum.");
        itemData.setMenge(5);
        itemData.setNachAufwand(false);
        itemData.setIndirekteKosten(false);
        itemDataList.add(itemData);

        return itemDataList;
    }

    private static List<LeistungspositionInputData> getTestDataLPBearbeiten() {
        List<LeistungspositionInputData> itemDataList = new LinkedList<>();
        LeistungspositionInputData itemData;

        itemData = new LeistungspositionInputData();
        itemData.setLeistungspositionName("LP_1");
        itemData.setLeistungstypType(LeistungstypItems.PLAN);
        itemData.setBeschreibung("Leistungsposition wurde bearbeitet.");
        itemData.setMenge(5);
        itemData.setIndirekteKosten(true);
        itemDataList.add(itemData);

        return itemDataList;
    }

}
