package de.telekom.simple.ta.testdata;

import de.telekom.simple.ta.common.PropertyManager;
import de.telekom.simple.ta.constants.SimpleTAProperties;
import de.telekom.simple.ta.exceptions.SimpleTestAutomationSystemException;
import de.telekom.simple.ta.testdata.common.SimpleUserRole;
import de.telekom.simple.ta.testdata.model.TestDataReader;
import de.telekom.simple.ta.testdata.model.User;
import de.telekom.simple.ta.utils.UserSetNumberPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Users extends TestDataReader
{
    private static final Logger logger = LoggerFactory.getLogger(Users.class);

    private static final String DEFAULT_EXCELFILE = "testdata/Users.xlsx";

    private static final Integer DEFAULT_USER_SET_NUMBER_OBJ = 1;

    public static final String REAL_LDAP_USER = "Khuseinova, Elvira";

    private static String usersDataFile = null;

    private static boolean usersDataFileIsInResourceDir = false;

    private static final ThreadLocal<Boolean> adminUsersOnlyThreadLocal = ThreadLocal.withInitial(() -> false);

    public static Boolean getAdminusersonly() {
        return adminUsersOnlyThreadLocal.get();
    }

    public static void setAdminusersonly(Boolean adminUsersOnly) {
        adminUsersOnlyThreadLocal.set(adminUsersOnly);
    }

    public static User getUserByUsername(String username)
    {
        if (username == null)
        {
            return null;
        }
        determineUsersDataFile();
        Map<String, String> data = readDataFromExcel(usersDataFile, usersDataFileIsInResourceDir, username, "Users");

        return setupUserData(data);
    }

    public static User getUserByRoleAndSetNumber(SimpleUserRole role, int requiredUserSet)
    {
        if (role == null)
        {
            return null;
        }
        if (adminUsersOnlyThreadLocal.get()) {
            role = SimpleUserRole.ADMINISTRATOR;
        }
        determineUsersDataFile();
        logger.debug("Searching user for role \"" + role + "\" and user-set " +
                requiredUserSet + " in file " + usersDataFile);
        List<Map<String, String>> data = readAllDataFromExcel(usersDataFile, usersDataFileIsInResourceDir, "Users");
        for (Map<String, String> currentRow : data) {
            if (role.toString().equals(currentRow.get("role"))) {
                String currentUserSetString = currentRow.get("setNumber").trim();
                int currentUserSet = 1;
                if (!currentUserSetString.isEmpty()) {
                    currentUserSet = Integer.parseInt(currentUserSetString);
                }
                if (requiredUserSet <= 1 &&
                        currentUserSet == 1 ||
                        requiredUserSet > 1 &&
                                currentUserSet == requiredUserSet
                ) {
                    return setupUserData(currentRow);
                }
            }
        }
        String errorMsg = "Could not find entry for role \"" + role +
                "\" and user-set " + requiredUserSet +
                " in current data sheet";
        logger.error(errorMsg);
        throw new SimpleTestAutomationSystemException(errorMsg);
    }

    public static User determineUser(SimpleUserRole role, String requiredUserSetString, String username)
    {
        try {
            requiredUserSetString = UserSetNumberPool.getUserSetNumber(requiredUserSetString);
        } catch (InterruptedException e) {
            Assert.fail("Can not determine userSetNumber: " + requiredUserSetString);
        }
        if (!username.isEmpty())
        {
            return getUserByUsername(username);
        }
        else
        {
            int requiredUserSet = 0;
            if (!requiredUserSetString.isEmpty())
            {
                requiredUserSet = Integer.parseInt(requiredUserSetString);
            }
            return getUserByRoleAndSetNumber(role, requiredUserSet);
        }
    }

    private static void determineUsersDataFile()
    {
        if (usersDataFile == null)
        {
            usersDataFileIsInResourceDir = false;
            usersDataFile = PropertyManager.getProperty(SimpleTAProperties.USERS_DATA_FILE, null);
            if (usersDataFile == null)
            {
                usersDataFile = PropertyManager.getProperty(SimpleTAProperties.USERS_DATA_RESOURCE_FILE, DEFAULT_EXCELFILE);
                usersDataFileIsInResourceDir = true;
            }
        }
    }

    private static User setupUserData(Map<String, String> rowData)
    {
        User user = new User();

        user.setBenutzername(rowData.get("username"));
        user.setPasswort(rowData.get("password"));
        user.setFirstName(rowData.get("forname"));
        user.setSurename(rowData.get("surname"));
        user.setRole(rowData.get("role"));
        String setNumberStr = rowData.get("setNumber");
        if (setNumberStr.isEmpty())
        {
            user.setSetNumber(DEFAULT_USER_SET_NUMBER_OBJ);
        }
        else
        {
            user.setSetNumber(Integer.valueOf(setNumberStr));
        }
        logger.debug("Found username is " + user.getBenutzername());

        return user;
    }

}

