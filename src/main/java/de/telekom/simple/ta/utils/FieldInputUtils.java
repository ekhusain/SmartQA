package de.telekom.simple.ta.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.enums.SimpleMenuItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

public class FieldInputUtils {
    protected static Logger logger = LoggerFactory.getLogger(FieldInputUtils.class);

    public static void select2IfNotNull(Page page, Locator el, String value) {
        if (value != null) {
            String optionText = value;
            // Select2 arrow selector
            String arrowSelector = "//*[@id='" + el.getAttribute("id") + "']/following::span[@class='select2-selection__arrow']";

            // Click on the Select2 dropdown arrow
            page.click(arrowSelector);

            // Wait for the dropdown options to appear
            page.waitForSelector(".select2-results__option");

            // Get list of options and select the one which is needed
            String optionSelector = String.format(".select2-results__option:has-text('%s')", optionText);
            ElementHandle secondDropdownOption = page.waitForSelector(optionSelector);
            if (secondDropdownOption != null) {
                secondDropdownOption.click();
            }
        }
    }

    public static <V extends Enum<?>> void select2IfNotNullContains(Page page, Locator el, V value) {
        if (value != null) {
            String optionText;
            if (value instanceof SimpleMenuItems) {
                optionText = ((SimpleMenuItems) value).toSelectString();
            } else {
                optionText = value.toString();
            }

            // Select2 arrow selector
            String arrowSelector = "#" + el.getAttribute("id") + "~ span span span span.select2-selection__arrow";

            // Click on the Select2 arrow to open the dropdown
            page.click(arrowSelector);
            page.waitForTimeout(2000);

            // Get list of options and select the one which is needed
            String optionSelector = ".select2-results__option";
            List<ElementHandle> secondDropdownOptions = page.querySelectorAll(optionSelector);

            for (ElementHandle secondDropdownOption : secondDropdownOptions) {
                String optionInnerText = secondDropdownOption.innerText();
                if (optionInnerText.contains(optionText)) {
                    page.waitForTimeout(2500);
                    secondDropdownOption.click();
                    break;
                }
            }
        }
    }

    /**
     * Verifies if text of element el contains string checkText.
     *
     * @param loc                 - element whose text to be verified
     * @param checkText          - text which is expected to be part of the text of el
     * @param elementDescription - description of element el (only for reporting and logging)
     */
    public static void verifyDisplayedElementTextContains(Locator loc,
                                                          String checkText,
                                                          String elementDescription) {
        logger.debug("Verifying if " + elementDescription + " is displayed and contains text \"" + checkText + "\".");
        //assertThat(loc);
        // Ensure the element is displayed
        loc.evaluate("loc => loc.style.display !== 'none'");
        String elementText = loc.textContent();
        // Assert that the text contains the expected value
        if (!elementText.contains(checkText)) {
            throw new AssertionError(elementDescription + " text does not contain \"" + checkText + "\".");
        }
    }

    public static void typeIfNotNull(Locator el, String s) {
        if (s != null) {
            el.press("Control+A");
            el.press("Delete");
            el.fill(s);
        }
    }

    /**
     * If date is not null types date into element el using German formatting rules.
     *
     * @param el   - input element
     * @param date - date to be typed into el
     */
    public static void typeIfNotNull(Locator el, LocalDate date) {
        if (date != null) {
            el.type(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY)));
        }
    }

    /**
     * If time is not null types time into element el using German formatting rules.
     *
     * @param el   - input element
     * @param time - date to be typed into el
     */
    public static void typeIfNotNull(Locator el, LocalTime time) {
        if (time != null) {
            el.type(time.format(DateTimeFormatter.ofPattern("hh:mm:ss").withLocale(Locale.GERMANY)));
        }
    }
}
