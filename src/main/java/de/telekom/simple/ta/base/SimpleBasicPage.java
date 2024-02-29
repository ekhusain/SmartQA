package de.telekom.simple.ta.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.utils.FieldInputUtils;

import java.util.concurrent.TimeUnit;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Base class for page classes for access to SIMPLE application
 */
public class SimpleBasicPage {
    Page page;
    private final Locator toastMsg;
    private final Locator errorMsg;
    private final Locator toastMsgSuccess;
    private final Locator toastMsgError;
    private final Locator closeToastMsg;
    private final Locator abmeldenButton;

    public SimpleBasicPage(Page page) {
        this.page = page;
        this.toastMsg = page.locator("//div[@class='toasts-component']");
        this.errorMsg = page.locator("//body/pre[@class='cake-error']");
        this.toastMsgSuccess = page.locator("//*[@class='b-toast b-toast-append flash-message success']");
        this.toastMsgError = page.locator("//*[@class='b-toast b-toast-append flash-message error']");
        this.closeToastMsg = page.locator("//a[contains(@class, 'toasts-close-button')]");
        this.abmeldenButton = page.locator("//button[@title='Abmelden']");

    }

    /**
     * Wait for and verification that a flash success message is displayed which contains text
     *
     * @param text - text to be checked/expected
     */

    public void verifyFlashMsgSuccessContains(String text) {
        assertThat(toastMsgSuccess);
        FieldInputUtils.verifyDisplayedElementTextContains(toastMsg, text, "success message");
    }

    public void verifyFlashMsgErrorContains(String text) {
        assertThat(toastMsgError);
        FieldInputUtils.verifyDisplayedElementTextContains(toastMsg, text, "error message");
    }

    public void doAllFlashMsgClose() {
        closeToastMsg.click();
    }

    public void doLogout() {
        pause(2000);
        abmeldenButton.click();
        //return page.context();
    }

    /**
     * Method which will pause test execution for certain period of time
     */
    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
