package de.telekom.simple.ta.common;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import de.telekom.simple.ta.utils.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XetaCommons {
    private static final Logger a = LoggerFactory.getLogger(XetaCommons.class);
    private static boolean b = false;
    private static boolean c = false;
    public static final String DEFAULT_PACKAGE_NAME = "eu.tsystems.mms.tic";

    private XetaCommons() {
    }

    public static void setXetaLogLevel(Level var0) {
        org.apache.log4j.Logger.getLogger("eu.tsystems.mms.tic.testframework").setLevel(var0);
    }

    public static void setXetaLogLevel() {
        String var0;
        if ((var0 = PropertyManager.getProperty("xeta.loglevel", "INFO")) != null) {
            org.apache.log4j.Logger var1 = org.apache.log4j.Logger.getLogger("eu.tsystems.mms.tic.testframework");
            Level var2 = Level.toLevel(var0.trim().toUpperCase());
            var1.setLevel(var2);
        }

    }

    public static void initializeLogging() {
        PropertyManager.ensureLoaded();
        a(true);
    }

    public static void initializeLogging(boolean var0) {
        a(var0);
    }

    private static void a(boolean var0) {
        if (!b) {
            URL var1;
            if ((var1 = ClassLoader.getSystemResource("test-log4j.xml")) != null) {
                System.setProperty("log4j.configuration", "test-log4j.xml");
                DOMConfigurator.configure(var1);
            } else if (var0) {
                BasicConfigurator.configure();
            }

            b = true;
        }

    }

    public static void initializeProxySettings() {
        if (!c) {
            if (!PropertyManager.getBooleanProperty("xeta.proxy.settings.load", true)) {
                a.info("Skipping loading of Proxy Settings.");
            } else {
                String var0;
                InputStream var1;
                if ((var1 = FileUtils.getLocalFileOrResourceInputStream(var0 = PropertyManager.getProperty("xeta.proxy.settings.file", "proxysettings.properties"))) == null) {
                    a.warn("File " + var0 + " not found. No proxy settings loaded.");
                } else {
                    label40: {
                        Properties var2 = new Properties();

                        try {
                            var2.load(var1);
                        } catch (Exception var4) {
                            a.warn("Not loaded: " + var0);
                            break label40;
                        }

                        Iterator var5 = var2.stringPropertyNames().iterator();

                        while(var5.hasNext()) {
                            String var3;
                            String var6;
                            if (StringUtils.isStringEmpty(var3 = System.getProperty(var6 = (String)var5.next()))) {
                                var3 = var2.getProperty(var6);
                                System.setProperty(var6, var3);
                                a.info("Setting system property " + var6 + " = " + var3);
                            } else {
                                a.warn("System property " + var6 + " is NOT set because it was already set to " + var3);
                            }
                        }
                    }
                }
            }

            c = true;
        }

    }
}
