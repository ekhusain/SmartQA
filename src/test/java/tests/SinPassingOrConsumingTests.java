package tests;

import de.telekom.simple.ta.testdata.common.DataStorage4Checks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

public abstract class SinPassingOrConsumingTests
{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Last created or used SIN per Thread
     */
    private static final ThreadLocal<String> lastUsedSinTL = ThreadLocal.withInitial(() -> "");

    public SinPassingOrConsumingTests()
    { }

    @BeforeTest
    public void beforeSinPassingOrConsumingTest(ITestContext testContext)
    {
        logger.info("Starting test " + testContext.getCurrentXmlTest().getName() + ".");
        // Initialise data for test
        setLastUsedSinOfThread("");
        DataStorage4Checks.beforeTest();
    }

    protected String getLastUsedSinOfThread()
    {
        return lastUsedSinTL.get();
    }

    protected void setLastUsedSinOfThread(String value)
    {
        lastUsedSinTL.set(value);
    }

    protected String checkAndHandleSin(String sin)
    {
        sin = handleSin(sin);
        Assert.assertNotNull(sin, "Test configuration error: sin is null. ");
        Assert.assertFalse(sin.isEmpty(), "Test configuration error: sin is empty. ");
        return sin;
    }

    protected String handleSin(String sin)
    {
        if (sin.isEmpty())
        {
            sin = getLastUsedSinOfThread();
            logger.info("No SIN(s) specified as parameter, using SIN from last test case: " + sin);
        }
        else
        {
            setLastUsedSinOfThread(sin);
            logger.info("Using SIN(s) specified as parameter: " + sin);
        }
        if (!sin.contains("SIN/")) {
            return "SIN/" + sin;
        }
        return sin;
    }

}

