package de.telekom.simple.ta.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class UserSetNumberPool {

    protected static Logger logger = LoggerFactory.getLogger(UserSetNumberPool.class);

    static HashSet<String> freeUserSetNumbers = new HashSet<>();
    static int userSetNumberOffset = 0;
    private static Semaphore semaphor = null;

    private static final ThreadLocal<String> userSetNumberThreadLocal;

    static {
        userSetNumberThreadLocal = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return null;
            }
        };
    }


    /**
     * Get the userSetNumber from the pool. If no user set is available, it waits, until a thread
     * releases one.
     * @throws InterruptedException is described
     */
    public static String getUserSetNumber(String userSetNumberAndThreadCount) throws InterruptedException {
        synchronized (UserSetNumberPool.class) {

            initThreadPool(userSetNumberAndThreadCount);
            logger.debug("semaphor.acquiring:");

            // there is already a usersetnumber, return it
            if (userSetNumberThreadLocal.get() != null) {
                return userSetNumberThreadLocal.get();
            }
            semaphor.acquire();
            String freeNumber = null;
            if (!freeUserSetNumbers.isEmpty()) {
                freeNumber = freeUserSetNumbers.iterator().next();
                freeUserSetNumbers.remove(freeNumber);
            }
            if (freeNumber == null) {
                Assert.fail("got null for freeNumber");
            }
            logger.info("semaphor.acquired userSetNumber:" + freeNumber);
            userSetNumberThreadLocal.set(freeNumber);

            return freeNumber;
        }
    }


    /**
     * Returns the used userSetNumber back to the pool
     */
    public static void releaseUserSetNumber() {
        String userSetNumber = userSetNumberThreadLocal.get();
        if (userSetNumber != null) {

            logger.info("semaphor.releasing userSetNumber:" + userSetNumber);
            synchronized (UserSetNumberPool.class) {
                freeUserSetNumbers.add(userSetNumber);
                userSetNumberThreadLocal.set(null);
            }
            semaphor.release();
            logger.info("semaphor.released userSetNumber:" + userSetNumber);
        }
    }

    /**
     * Method takes the thread count from ITestContext and update the actual test-thread-count. If not present in
     * test ng definiton, it tries to read from SytemProperties;
     */
    public static void setThreadCount(ITestContext itc){
        String userSetNumberAndThreadCount = itc.getSuite().getXmlSuite().getAllParameters().get("userSetNumber");

//        if (userSetNumberAndThreadCount == null) {
//            userSetNumberAndThreadCount = PropertyManager.getProperty("userSetNumber");
//        }

        itc.getSuite().getXmlSuite().setThreadCount(getThreadCountFromUserSetNumberWithThreadCount(userSetNumberAndThreadCount));
    }


    protected static int getThreadCountFromUserSetNumberWithThreadCount(String userSetNumberAndThreadCount){
        int numberOfThreads = 1;

        if (userSetNumberAndThreadCount != null) {
            if (userSetNumberAndThreadCount.contains(":")) {
                String[] userSetNumberAndThreadCountArray = userSetNumberAndThreadCount.split(":");
                if (userSetNumberAndThreadCountArray.length > 1) {
                    numberOfThreads = Integer.parseInt(userSetNumberAndThreadCountArray[1]);
                }
            }else{
                numberOfThreads = userSetNumberAndThreadCount.split("\\s*,\\s*").length;
            }
        }
        return numberOfThreads;
    }

    protected static HashSet<String>  getUserSetNumberFromUserSetNumberWithThreadCount(String userSetNumberAndThreadCount){
        String userSetNumber;
        HashSet<String> userSetNumbers = new HashSet<>() ;
        if (userSetNumberAndThreadCount.contains(":")) {
            String[] userSetNumberAndThreadCountArray = userSetNumberAndThreadCount.split(":");
            if (userSetNumberAndThreadCountArray.length > 0) {
                userSetNumber = userSetNumberAndThreadCountArray[0];
                int count = getThreadCountFromUserSetNumberWithThreadCount(userSetNumberAndThreadCount);
                for (int i = 0; i < count; i++) {
                    userSetNumbers.add(Integer.valueOf(Integer.parseInt(userSetNumber) + i).toString());
                }
                return userSetNumbers;
            }
        }else{

            Collections.addAll(userSetNumbers, userSetNumberAndThreadCount.split("\\s*,\\s*"));
            return userSetNumbers;
        }
        return userSetNumbers;

    }
    /**
     * String userSetNumberAndThreadCount  contains start user number set colon number of threads e.g."1002:3"
     *                                     or user number set only e.g. "1004"
     * @param userSetNumberAndThreadCount
     * @return
     */
    private static void initThreadPool(String userSetNumberAndThreadCount){
        if (semaphor == null) {
            userSetNumberAndThreadCount = getUserSetNumberAndThreadCount(userSetNumberAndThreadCount);

            HashSet<String> userSetNumbers = getUserSetNumberFromUserSetNumberWithThreadCount( userSetNumberAndThreadCount);

            semaphor  = new Semaphore(getThreadCountFromUserSetNumberWithThreadCount(userSetNumberAndThreadCount));
            freeUserSetNumbers.addAll(userSetNumbers);
            logger.info("userSetNumbers: " + userSetNumbers);
        }
    }

    /**
     * returns the userSetNumber from parameter. If it is null, return the  userSetNumber from SystemProperty
     */
    private static String getUserSetNumberAndThreadCount(String userSetNumberAndThreadCount){
        if (userSetNumberAndThreadCount == null || userSetNumberAndThreadCount.isEmpty()) {
            //userSetNumberAndThreadCount = getProperty("userSetNumber");
            logger.debug("UserSetNumberAndThreadCount from SystemProperties:" + userSetNumberAndThreadCount);
        }else{
            logger.debug("UserSetNumberAndThreadCount from testNG:" + userSetNumberAndThreadCount);
        }
        return userSetNumberAndThreadCount;
    }

}

