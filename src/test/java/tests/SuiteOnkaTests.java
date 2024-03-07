package tests;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import de.telekom.simple.ta.SimpleBrowserFactory;
import de.telekom.simple.ta.base.SimpleLoginPage;
import de.telekom.simple.ta.enums.KostenartItems;
import de.telekom.simple.ta.enums.LeistungstypItems;
import de.telekom.simple.ta.pages.MeineVorhabenPage;
import de.telekom.simple.ta.pages.SimpleStartseitePage;
import de.telekom.simple.ta.pages.offer.OfferDashboardPage;
import de.telekom.simple.ta.pages.onka.LeistungenTabPage;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;
import de.telekom.simple.ta.testdata.model.User;
import de.telekom.simple.ta.testdata.simplebase.KalkulationsElementData;
import de.telekom.simple.ta.testdata.simplebase.LeistungspositionInputData;
import org.testng.annotations.*;
import testfunctions.LoginFunctions;
import testfunctions.MeineAngeboteFunctions;

import java.util.LinkedList;
import java.util.List;

public class SuiteOnkaTests extends SinPassingOrConsumingTests {

    Playwright playwright;
    Page page;
    SimpleBrowserFactory browserFactory;

    BrowserContext context;

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }


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

    @Test(groups = {"g_testCreateElement"},
            description = "Create new calculation element")
    @Parameters({"sin"})
    public void testCreateElement(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        browserFactory = new SimpleBrowserFactory();
        page = browserFactory.initBrowser("chrome");
        SimpleLoginPage loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        SimpleStartseitePage startseitePage = new SimpleStartseitePage(page);

        List<KalkulationsElementData> elementData = getTestDataCreateElement();

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        MeineAngeboteFunctions.doNeuesElement(offerDashboardPage, elementData);

        leistungenTabPage.doLogout();
    }

    @Test(groups = {"g_testEditElement"},
            description = "Update an existing calculation element")
    @Parameters({"sin"})
    public void testEditElement(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        browserFactory = new SimpleBrowserFactory();
        page = browserFactory.initBrowser("chrome");
        SimpleLoginPage loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        SimpleStartseitePage startseitePage = new SimpleStartseitePage(page);

        List<KalkulationsElementData> elementData = getTestDataEditElement();

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        MeineAngeboteFunctions.doElementBearbeiten(offerDashboardPage, elementData);

        leistungenTabPage.doLogout();
    }

    @Test(groups = {"g_testDeleteElement"},
            description = "Delete an existing calculation element")
    @Parameters({"sin"})
    public void testDeleteElement(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        browserFactory = new SimpleBrowserFactory();
        page = browserFactory.initBrowser("chrome");
        SimpleLoginPage loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        SimpleStartseitePage startseitePage = new SimpleStartseitePage(page);

        List<KalkulationsElementData> elementData = getTestDataEditElement();

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        LeistungenTabPage leistungenTabPage = offerDashboardPage.openLeistungenTab();
        MeineAngeboteFunctions.doDeleteElement(offerDashboardPage, elementData);

        leistungenTabPage.doLogout();
    }

    public static User getUserData() {
        User userData = new User();
        userData.setBenutzername("test1011.admin");
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
        itemData.setLeistungspositionNameOld("LP_1");
        itemData.setLeistungspositionName("Leistungsposition 1");
        itemData.setLeistungstypType(LeistungstypItems.PLAN);
        itemData.setBeschreibung("Leistungsposition wurde bearbeitet.");
        itemData.setMenge(10);
        itemData.setIndirekteKosten(true);
        itemDataList.add(itemData);

        return itemDataList;
    }

    private static List<KalkulationsElementData> getTestDataCreateElement() {
        List<KalkulationsElementData> itemDataList = new LinkedList<>();
        KalkulationsElementData itemData = new KalkulationsElementData();
        itemData.setLeistungspositionsBezeichnung(new String[] {"Leistungsposition 1"});
        itemData.setBezeichnung("new Element");
        itemData.setKostenart(KostenartItems.ISP_SR_SN_SRSNT2FIELDSERVICETECHNIKER);
        itemData.setAufwandStunden((short) 5);
        itemData.setBeschreibung("Ein neues Element wurde erstellt.");
        itemDataList.add(itemData);

        return itemDataList;
    }

    private static List<KalkulationsElementData> getTestDataEditElement() {
        List<KalkulationsElementData> itemDataList = new LinkedList<>();
        KalkulationsElementData itemData = new KalkulationsElementData();
        itemData.setLeistungspositionsBezeichnung(new String[] {"Leistungsposition 1"});
        itemData.setBezeichnungOld("new Element");
        itemData.setBezeichnung("Element 1");
        itemData.setKostenart(KostenartItems.ISP_SR_SN_SRSNT1INSTALLATIONSTECHNIKER);
        itemData.setAufwandStunden((short) 8);
        itemData.setBeschreibung("Element wurde aktualisiert.");
        itemDataList.add(itemData);

        return itemDataList;
    }

}
