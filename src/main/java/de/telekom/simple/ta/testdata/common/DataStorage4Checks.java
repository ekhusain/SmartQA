package de.telekom.simple.ta.testdata.common;

public class DataStorage4Checks {

    private static final ThreadLocal<GeneralData4Checks> generalData4Checks = ThreadLocal.withInitial(() -> null);

    /**
     * Initialisation to be performed in a method, which is annotated with "@BeforeTest"
     */
    public static void beforeTest()
    {
        generalData4Checks.set(new GeneralData4Checks());
    }

    public static GeneralData4Checks getGeneralData4Checks()
    {
        return generalData4Checks.get();
    }
}
