package de.telekom.simple.ta.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Properties;

import de.telekom.simple.ta.constants.RTConstants;
import de.telekom.simple.ta.exceptions.SimpleTestAutomationSystemException;
import de.telekom.simple.ta.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PropertyManager {
    private static final Logger d;
    static final ThreadLocal<Properties> a;
    static final Properties b;
    static final Properties c;

    public static void ensureLoaded() {
    }

    private static void a(Properties var0, String var1, String var2, boolean var3) {
        InputStream var8;
        if (var3) {
            var8 = FileUtils.getLocalFileOrResourceInputStream(var1);
        } else {
            URL var9;
            if ((var9 = Thread.currentThread().getContextClassLoader().getResource(var1)) == null) {
                throw new SimpleTestAutomationSystemException("Property file not found in your resource path: " + var1);
            }

            try {
                var8 = ((URL)Objects.requireNonNull(var9)).openStream();
            } catch (IOException var7) {
                throw new SimpleTestAutomationSystemException("Error reading property file: " + var1);
            }
        }

        if (var2 == null) {
            var2 = Charset.defaultCharset().name();
        }

        try {
            InputStreamReader var10 = new InputStreamReader(var8, var2);
            var0.load(var10);
        } catch (IOException var4) {
            throw new IllegalStateException(String.format("An error occurred during reading from properties file %s.", var1), var4);
        } catch (IllegalArgumentException var5) {
            throw new IllegalStateException(String.format("The properties file %s contains illegal characters!", var1), var5);
        } catch (Exception var6) {
            d.error("Error loading properties file " + var1, var6);
        }
    }

    private static Properties a(String var0, String var1, boolean var2) {
        Properties var3;
        if (a.get() == null) {
            var3 = new Properties();
            a.set(var3);
        } else {
            var3 = (Properties)a.get();
        }

        a(var3, var0, var1, var2);
        d.info("ThreadLocalProperties: " + var3);
        return var3;
    }

    public static Properties loadThreadLocalProperties(String var0, boolean var1) {
        return a(var0, (String)null, var1);
    }

    public static Properties loadThreadLocalProperties(String var0) {
        return loadThreadLocalProperties(var0, true);
    }

    public static Properties loadThreadLocalProperties(String var0, String var1, boolean var2) {
        return a(var0, var1, var2);
    }

    public static Properties loadThreadLocalProperties(String var0, String var1) {
        return loadThreadLocalProperties(var0, var1, true);
    }

    public static Properties loadProperties(String var0, boolean var1) {
        a(b, var0, (String)null, var1);
        d.info("Global Properties: " + b);
        return b;
    }

    public static Properties loadProperties(String var0) {
        return loadProperties(var0, true);
    }

    public static Properties loadProperties(String var0, String var1, boolean var2) {
        a(b, var0, var1, var2);
        d.info("Global Properties: " + b);
        return b;
    }

    public static Properties loadProperties(String var0, String var1) {
        return loadProperties(var0, var1, true);
    }

    private PropertyManager() {
    }

    public static String getProperty(String var0) {
        return PropertiesParser.a(var0);
    }

    public static String getProperty(String var0, String var1) {
        return (var0 = getProperty(var0)) != null && var0.length() > 0 ? var0 : var1;
    }

    public static int getIntProperty(String var0, int var1) {
        var0 = getProperty(var0);

        try {
            return Integer.parseInt(var0);
        } catch (NumberFormatException var2) {
            return var1;
        }
    }

    public static int getIntProperty(String var0) {
        var0 = getProperty(var0);

        try {
            return Integer.parseInt(var0);
        } catch (NumberFormatException var1) {
            return -1;
        }
    }

    public static double getDoubleProperty(String var0, double var1) {
        if ((var0 = getProperty(var0)) == null) {
            return var1;
        } else {
            try {
                return Double.parseDouble(var0);
            } catch (NumberFormatException var3) {
                return var1;
            }
        }
    }

    public static double getDoubleProperty(String var0) {
        if ((var0 = getProperty(var0)) == null) {
            return -1.0;
        } else {
            try {
                return Double.parseDouble(var0);
            } catch (NumberFormatException var1) {
                return -1.0;
            }
        }
    }

    public static boolean getBooleanProperty(String var0) {
        return (var0 = getProperty(var0)) == null ? false : Boolean.parseBoolean(var0.trim());
    }

    public static boolean getBooleanProperty(String var0, boolean var1) {
        if ((var0 = getProperty(var0)) == null) {
            return var1;
        } else if (var0.equalsIgnoreCase("true")) {
            return true;
        } else {
            return var0.equalsIgnoreCase("false") ? false : var1;
        }
    }

    public static void clearProperties() {
        a.remove();
        b.clear();
        c.clear();
    }

    public static Properties getFileProperties() {
        return b;
    }

    public static Properties getThreadLocalProperties() {
        if (a.get() == null) {
            a.set(new Properties());
        }

        return (Properties)a.get();
    }

    public static void clearThreadlocalProperties() {
        a.remove();
    }

    public static void clearGlobalProperties() {
        c.clear();
    }

    public static Properties getGlobalProperties() {
        return c;
    }

    static {
        XetaCommons.initializeLogging();
        d = LoggerFactory.getLogger(PropertyManager.class);
        a = new ThreadLocal();
        b = new Properties();
        c = new Properties();
        String var0 = RTConstants.getXetaTestPropertiesFile();
        a(b, var0, (String)null, true);
        System.out.println("Loaded boot time properties from: " + var0);
        System.out.println("Global Properties: " + b);
    }
}

