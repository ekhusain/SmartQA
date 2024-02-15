package testfunctions;

import de.telekom.simple.ta.base.SimpleLoginPage;
import de.telekom.simple.ta.pages.SimpleStartseitePage;
import de.telekom.simple.ta.testdata.common.GeneralData4Checks;
import de.telekom.simple.ta.testdata.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFunctions {

    private static final Logger logger = LoggerFactory.getLogger(LoginFunctions.class);

    public static SimpleStartseitePage login(SimpleLoginPage loginPage, User user) {

        // Determine and store database name and database server
        String dbName = "SIMPLAR_develop_WIP";
        String dbServer = "10.105.186.13,1760";
        logger.info("Datenbank: \"" + dbName + "\".");
        logger.info("Datenbank Server: \"" + dbServer + "\".");

        GeneralData4Checks data4checks = new GeneralData4Checks();
        data4checks.setDatabaseName(dbName);
        data4checks.setDatabaseServer(dbServer);

        SimpleStartseitePage simpleStartseitePage = loginPage.doLogin(user);

        return simpleStartseitePage;
    }

}
