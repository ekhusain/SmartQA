import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.SimpleBrowserFactory;
import org.example.pages.CustomerSearchPage;
import org.example.pages.MeineVorhabenPage;
import org.example.pages.NeuesVorhabenAnlegenPage;
import org.example.pages.SimpleLoginPage;
import org.testng.annotations.*;

public class BasicSuite {
    SimpleBrowserFactory pf;

    Playwright playwright;
    Browser browser;

    Page page;

    SimpleLoginPage loginPage;
    MeineVorhabenPage vorhabenPage;
    NeuesVorhabenAnlegenPage neuesVorhabenAnlegenPage;
    CustomerSearchPage customerSearchPage;

    @BeforeClass
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeTest
    public void  setup() {
        pf = new SimpleBrowserFactory();
        page = pf.initBrowser("chrome");
        loginPage = new SimpleLoginPage(page);
        vorhabenPage = new MeineVorhabenPage(page);
    }

    @Test
    public void testLogin() {
        loginPage.navigate();
        loginPage.doLogin("test1171.admin", "test.admin01");
    }


//    @AfterTest
//    public void closeBrowser() {
//        page.context().browser().close();
//    }



}
