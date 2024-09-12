package de.telekom.simple.ta.constants;

/**
 * Constants with name of properties for configuration
 */
public final class SimpleTAProperties
{
    private SimpleTAProperties()
    { }
    
    /**
     * Path of user data file relative to resource directory
     */
    public static final String USERS_DATA_RESOURCE_FILE = "usersData.resource";
    
    /**
     * Absolute path of user data file
     */
    public static final String USERS_DATA_FILE = "usersData.file";
    
    public static final String ANGEBOTS_DATEI_RESOURCE = "testdata.sales.angebot.resource";
    
    public static final String ANGEBOTS_KALKULATIONS_DATEI_RESOURCE = "testdata.sales.kalkulation.resource";

    public static final String LBU_CSV_DATEI_RESOURCE = "testdata.offer.faktura.resource";

    public static final String LOTEX_DATEI_RESOURCE = "testdata.angebot.lotex.resource";
    
//    /**
//     * Indication if test run is a local test run (boolean) 
//     */
//    public static final String LOCAL_TEST_RUN_INDICATION = "testrun.local";
    
    /**
     * Specifies Mozilla Firefox binary path (usually for local test runs) 
     */

    public static final String CHROME_BINARY = "chrome.binary";
    public static final String FIREFOX_BINARY = "firefox.binary";

    public static final String ANSCHREIBEN_DATEI_RESOURCE = "testdata.sales.anschreiben.resource";

    public static final String BEAUFTRAGUNG_HOCHLADEN_RESOURCE = "testdata.sales.beauftragung.resource";

    /**
     * Specifies the maximum number of retries of user search
     */
    public static final String MAX_NUMBER_USER_SEARCH_RETRIES = "testControl.userSearch.maxRetries";

}
