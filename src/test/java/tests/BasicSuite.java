package tests;

import com.microsoft.playwright.*;
import de.telekom.simple.ta.SimpleBrowserFactory;
import de.telekom.simple.ta.base.SimpleBasicPage;
import de.telekom.simple.ta.base.SimpleLoginPage;
import de.telekom.simple.ta.enums.DebitorEnumItems;
import de.telekom.simple.ta.pages.*;
import de.telekom.simple.ta.pages.offer.*;
import de.telekom.simple.ta.pages.sales.*;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;
import de.telekom.simple.ta.testdata.simplebase.SimpleOnlineKalkulationData;
import de.telekom.simple.ta.testdata.simplebase.BeauftragungDurchfuehrenData;
import de.telekom.simple.ta.testdata.model.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.testng.annotations.*;
import testfunctions.LoginFunctions;
import testfunctions.MeineAngeboteFunctions;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;

public class BasicSuite extends SinPassingOrConsumingTests {
    SimpleBrowserFactory pf;
    // New instance for each test method.
    BrowserContext context;
    Playwright playwright;
    Browser browser;
    Page page;

    SimpleBasicPage basicPage;
    SimpleLoginPage loginPage;
    SimpleStartseitePage startseitePage;

//    @BeforeClass
//    public void  setup() {
//        pf = new SimpleBrowserFactory();
//        page = pf.initBrowser("chromium");
//    }

    @BeforeClass
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setExecutablePath(Paths.get("C:/Users/A11336979/AppData/Local/ms-playwright/chrome-win/chrome.exe")).setHeadless(false));
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        playwright = Playwright.create();
        //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setExecutablePath(Paths.get("C:/Users/A11336979/AppData/Local/ms-playwright/chrome-win/chrome.exe")).setHeadless(false));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://develop.simplardev.telekom.de/");

    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

    @Test
    @Disabled("true")
    public void testLogin() {
        page.navigate("https://develop.simplardev.telekom.de/");
        //page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
        loginPage = new SimpleLoginPage(page);
        Allure.step("Login was successful");
        LoginFunctions.login(loginPage, getUserData());
    }

    @Test(groups = {"g_testNeuesVorhabenAnlegen"}, description = "Neues Vorhaben anlegen")
    @Description("Neues Vorhaben anlegen")
    @Severity(SeverityLevel.BLOCKER)
    @Attachment("true")
    public void testNeuesVorhabenAnlegen() {
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);
        startseitePage.doNeuesVorhabenAnlegen();

        // Get test data
        SalesVorhabenData ventureData = getTestDataS0();
        SalesVorhabenData klassificationData = getTestDataKlassifizierung();
        //Go to Neues Vorhaben anlegen page and fill all mandatory parameters
        NeuesVorhabenAnlegenPage neuesVorhabenAnlegenPage = new NeuesVorhabenAnlegenPage(page);

        String sin = checkAndHandleSin(MeineAngeboteFunctions.doAnlegenNeuesVorhaben(neuesVorhabenAnlegenPage, ventureData, klassificationData));
        setLastUsedSinOfThread(sin);
        //Do logout
        basicPage = new SimpleBasicPage(page);
        basicPage.doLogout();
    }

    @Test(groups = {"g_testS1AnfrageErstellt"}, description = "S1 Anfrage Erstellt")
    @Parameters({"sin"})
    public void testS1AnfrageErstellt(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        vorhabenPage.sinAuswaehlen(sin);

        SalesVorhabenData data = getTestDataS1();
        SalesDashboardStammdatenPage stammdatenPage = new SalesDashboardStammdatenPage(page);
        AngebotAnfordernPage anfordernPage = stammdatenPage.doAngebotAnfordern();
        anfordernPage.fillAngebotAnfordern(data);
        stammdatenPage = anfordernPage.angebotAnfordernSpeichern();

        stammdatenPage.doLogout();
    }

    @Test(groups = {"g_testS2AngebotserstellerZugeordnet"}, description = "S2 Angebotsersteller zuordnen")
    @Parameters({"sin"})
    public void testS2AngebotserstellerZugeordnet(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        AnfragelisteIspPage anfragelisteIspPage = startseitePage.openAnfrageListeISP();
        AngebotserstellerZuordnenPage zuordnenPage = anfragelisteIspPage.angebotserstellerZuweisen(sin);
        zuordnenPage.fillSuchenText("Administrator1016");
        anfragelisteIspPage = zuordnenPage.doZuordnen();
        anfragelisteIspPage.selectFilterSuchenStatus();
        anfragelisteIspPage.verifySin(sin);

        anfragelisteIspPage.doLogout();
    }

    @Test(groups = {"g_testS3BearbeitungBeginnen"}, description = "S3 Bearbeitung beginnen")
    @Parameters({"sin"})
    public void testS3BearbeitungBeginnen(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        SimpleAlertPage alertPage = stammdatenPage.doBearbeitungBeginnen();
        OfferDashboardPage offerDashboardPage = alertPage.doConfirmAction();

        offerDashboardPage.doLogout();
    }

    @Test(groups = {"g_testKalkulationImport"},
            description = "Kalkulation importieren with AP, LP and Ber")
    @Parameters({"sin"})
    public void testKalkulationImport(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        OfferDashboardAngebotPage angebotPage = offerDashboardPage.openAngebotTab();
        OnkaKalkulationImportierenPage kalkulationImportierenPage = angebotPage.openKalkulationImport();
        kalkulationImportierenPage.doKalkulationImport();

        SimpleOnlineKalkulationData kalkulationData = getKalkulationImportData();
        kalkulationImportierenPage.fillFormData(kalkulationData);
        kalkulationImportierenPage.doSuchen();
        kalkulationImportierenPage.doKalkulationImport();
        kalkulationImportierenPage.doSchliessen();
        //offerDashboardPage.verifyFlashMsgSuccessContains("Kalkulation erfolgreich importiert");
        offerDashboardPage.openAngebotTab();

        offerDashboardPage.doLogout();
    }

    @Test(groups = {"g_testWorkflowFunctions"}, description = "Angebotsgueltigkeit und Datei hinzufuegen")
    @Parameters({"sin"})
    public void testWorkflowFunctions(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardPage offerDashboardPage = stammdatenPage.openOfferDashboard();
        OfferDashboardWorkflowPage workflowPage = offerDashboardPage.openWorkflowTab();
        workflowPage.enterAngebotsgueltigkeit(LocalDate.now().plusDays(2));
        workflowPage.enterEmpfaenger("Khusainova, Elvira");
        workflowPage.enterAngebotFile("C:\\Users\\A11336979\\Simple_playwright\\src\\test\\resources\\testdata\\Testangebot.docx");
        workflowPage.clickAngebotFertigstellen();
        workflowPage.setAngebotFertigstellen();

        workflowPage.doLogout();
    }

    @Test(groups = {"g_testAngebotBeauftragung"}, description = "Angebot beauftragen, project moved to S6PR")
    @Parameters({"sin"})
    public void testAngebotBeauftragung(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        BeauftragungDurchfuehrenData beauftragenData = getAngebotBeauftragen();
        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        OfferDashboardAngebotBeauftragenPage angebotBeauftragenPage = stammdatenPage.doAngebotBeauftragen();
        angebotBeauftragenPage.enterBeauftragungsdatei("C:\\Users\\A11336979\\Simple_playwright\\src\\test\\resources\\testdata\\Testangebot.docx");
        angebotBeauftragenPage.fillAngebotBeauftragen(beauftragenData);
        FinanceDashboardPage financeDashboardPage = angebotBeauftragenPage.doAngebotBeauftragen();
        financeDashboardPage.doLogout();
    }


    @Test(groups = {"g_testProduktionsreifeBestaetigen"}, description = "Produktionsreife bestaetigen, project moved to S6")
    @Parameters({"sin"})
    public void testProduktionsreifeBestaetigen(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        BeauftragungDurchfuehrenData beaufttagenData = getAngebotBeauftragen();
        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        SimpleAlertPage alertPage = stammdatenPage.doProduktionsreifeBestaetigen();
        stammdatenPage = alertPage.doBestaetigen();

        stammdatenPage.doLogout();
    }

    @Test(groups = {"g_testS7AuftragBeenden"}, description = "Auftrag beenden, project moved to S7")
    @Parameters({"sin"})
    public void testS7AuftragBeenden(@Optional("") String sin) {
        // Determine SIN to use
        sin = checkAndHandleSin(sin);

        // Determine login credentials to use for this test case
        loginPage = new SimpleLoginPage(page);
        LoginFunctions.login(loginPage, getUserData());
        startseitePage = new SimpleStartseitePage(page);

        SalesVorhabenData data = getTestDataS7();
        MeineVorhabenPage vorhabenPage = startseitePage.openMeineVorhaben();
        SalesDashboardStammdatenPage stammdatenPage = vorhabenPage.sinAuswaehlen(sin);
        AuftragBeendenPage auftragBeendenPage = stammdatenPage.doAuftragBeenden();
        auftragBeendenPage.fillFormData(data);
        auftragBeendenPage.doAuftragBeenden();

        stammdatenPage.doLogout();
    }

    public static SalesVorhabenData getTestDataS0() {
        SalesVorhabenData vorhabenData = new SalesVorhabenData();
        // setup further project data
        vorhabenData.setSicherheitsstufe(NeuesVorhabenAnlegenPage.SicherheitsstufeEnumItems.STANDARD);
        vorhabenData.setVorhabenname("Test name");
        vorhabenData.setVolumenDtts(new BigDecimal("100000"));
        vorhabenData.setKundenname("MustHave GmbH");
        vorhabenData.setKundennummer("2710134435");

        return vorhabenData;
    }

    public static User getUserData() {
        User userData = new User();
        userData.setBenutzername("test1015.admin");
        userData.setPasswort("test.admin01");
        return userData;
    }

    public static SalesVorhabenData getTestDataKlassifizierung() {
        SalesVorhabenData vorhabenData = new SalesVorhabenData();
        vorhabenData.setSalesBoost(KlassifizierungBearbeitenPage.SalesBoostEnumItems.TDG);
        vorhabenData.setProfitcenter(KlassifizierungBearbeitenPage.ProfitcenterEnumItems.TDGPRIVATKUNDEN);
        vorhabenData.setVertiebssegment(KlassifizierungBearbeitenPage.VertriebssegmentEnumItems.SONSTIGEREST);
        vorhabenData.setKundenregion(KlassifizierungBearbeitenPage.KundenregionEnumItems.REGIONNORD);
        vorhabenData.setPortfolio(KlassifizierungBearbeitenPage.PortfolioElementType.DATADRIVENSERVICES);
        vorhabenData.setGewinnen(KlassifizierungBearbeitenPage.TeilprojektGewinnenEnumItems.AUFBAURENEWALTEAM);
        return vorhabenData;
    }

    public static SalesVorhabenData getTestDataS1() {
        SalesVorhabenData vorhabenData = new SalesVorhabenData();
        LocalDate today = LocalDate.now();
        vorhabenData.setVertragsbeginn(today);
        vorhabenData.setVertragsende(today.plusYears(1));
        vorhabenData.setLieferterminAngebot(today);
        return vorhabenData;
    }

    public static SimpleOnlineKalkulationData getKalkulationImportData() {
        SimpleOnlineKalkulationData kalkulationData = new SimpleOnlineKalkulationData();
        kalkulationData.setSearchType("1190274");
        return kalkulationData;
    }

    public static BeauftragungDurchfuehrenData getAngebotBeauftragen() {
        BeauftragungDurchfuehrenData data = new BeauftragungDurchfuehrenData();
        data.setSapAuftragsNummer("666102");
        data.setAngebotsversion(OfferDashboardAngebotBeauftragenPage.AngebotsversionEnumItems.NEUES_ANGEBOT);
        data.setDebitorItems(DebitorEnumItems._48001481TDGGESCHAEFTSKUNDEN);
        data.setVertragsbeginn(LocalDate.now());
        data.setVertragsende(LocalDate.now().plusYears(1));
        return data;
    }

    public static SalesVorhabenData getTestDataS7() {
        SalesVorhabenData vorhabenData = new SalesVorhabenData();
        vorhabenData.setAbgeschlossenGrund(AuftragBeendenPage.AuftragBeendenEnumItems.VERTRAG_BEENDET);
        return vorhabenData;
    }

//    @AfterClass
//    void closeBrowser() {
//        page.context().browser().close();
//    }
//    void closeBrowser() {
//        context.close();
//    }

}
