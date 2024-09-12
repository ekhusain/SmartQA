package de.telekom.simple.ta.common;

import de.telekom.simple.ta.exceptions.SimpleException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PropertiesParser {
    private static final Pattern a;
    private static final Pattern b;
    private static final Logger c;

    private PropertiesParser() {
    }

    private static String a(String var0, List<String> var1) {
        if (var1 == null) {
            var1 = new ArrayList(1);
        }

        Matcher var2 = a.matcher(var0);
        ArrayList var3 = new ArrayList(1);

        while(var2.find()) {
            String var4 = var0.substring(var2.start(), var2.end());
            var3.add(var4);
        }

        Iterator var10 = var3.iterator();

        while(var10.hasNext()) {
            String var8;
            String var9 = (var8 = (String)var10.next()).substring(1, var8.length() - 1);
            if (((List)var1).contains(var9)) {
                throw new SimpleException("Loop detected while replacing a property: " + var8);
            }

            String var5;
            if ((var5 = c(var9)) == null) {
                c.warn("Property " + var8 + " not found");
            } else {
                BooleanPackedResponse var6;
                var5 = (String)(var6 = b(var5)).getResponse();
                boolean var11 = var6.getBoolean();
                ArrayList var7;
                (var7 = new ArrayList(((List)var1).size() + 1)).addAll((Collection)var1);
                var7.add(var9);
                var5 = a(var5, var7);
                var0 = var0.replace(var8, var5);
                if (var11) {
                    var5 = "###########";
                }

                c.info("Replacing " + var8 + " with >" + var5 + "<");
            }
        }

        return var0;
    }

    private static BooleanPackedResponse<String> b(String var0) {
        if (var0 == null) {
            return new BooleanPackedResponse(var0, false);
        } else if (b.matcher(var0).find()) {
            var0 = var0.replaceAll("@SENSIBLE@", "");
            return new BooleanPackedResponse(var0, true);
        } else {
            return new BooleanPackedResponse(var0, false);
        }
    }

    public static String parseLine(String var0) {
        return a(var0, (List)null);
    }

    static String a(String var0) {
        if ((var0 = c(var0)) != null) {
            var0 = parseLine(var0);
        }

        return (String)b(var0).getResponse();
    }

    private static String c(String var0) {
        String var1 = PropertyManager.b.getProperty(var0);
        var1 = System.getProperty(var0, var1);
        var1 = PropertyManager.c.getProperty(var0, var1);
        if (PropertyManager.a.get() != null) {
            var1 = ((Properties)PropertyManager.a.get()).getProperty(var0, var1);
        }

        return var1;
    }

    static {
        PropertyManager.ensureLoaded();
        a = Pattern.compile("\\{[^\\}]*\\}");
        b = Pattern.compile("@SENSIBLE@");
        c = LoggerFactory.getLogger(PropertiesParser.class);
    }
}
