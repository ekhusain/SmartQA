package de.telekom.simple.ta.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils extends org.apache.commons.lang3.StringUtils{
    private static final Random a = new Random();
    private static final Pattern b = Pattern.compile("&([a-zA-Z]{4}|(#[0-9]{1,4}));");
    private static final Map<String, String> c;
    public static final Pattern ALLHTMLTAGS;

    private StringUtils() {
    }

    public static String getPlainTextFromHTML(String var0) {
        String var1 = var0 = var0.replaceAll("[\\n\\r\\t]+", " ").trim().replaceAll("\\<.*?\\>", "");

        String var3;
        for(Matcher var2 = b.matcher(var1); var2.find(); var0 = var0.replaceAll(var3, (String)c.get(var3))) {
            var3 = var1.substring(var2.start(), var2.end());
        }

        return var0;
    }

    public static String concat(String... var0) {
        StringBuilder var1 = new StringBuilder();
        int var2 = (var0 = var0).length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String var4 = var0[var3];
            var1.append(var4);
        }

        return var1.toString();
    }

    public static String concat(char var0, Object... var1) {
        String var2 = "";
        int var3 = (var1 = var1).length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object var5 = var1[var4];
            var2 = var2 + var5 + var0;
        }

        return var2.substring(0, var2.length() - 1);
    }

    public static String concat(String var0, Object... var1) {
        String var2 = "";
        int var3 = (var1 = var1).length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object var5 = var1[var4];
            var2 = var2 + var5 + var0;
        }

        return var2.substring(0, var2.length() - var0.length());
    }

    public static String getRandomStringLowerCaseWithLength(int var0) {
        return getRandomStringWithLength(var0).toLowerCase();
    }

    public static String getRandomStringWithLength(int var0) {
        StringBuffer var1 = new StringBuffer(var0);

        for(int var2 = 0; var2 < var0; ++var2) {
            var1.append(Character.toString((char)((int)(Math.random() * 25.0 + 65.0))));
        }

        return var1.toString();
    }

    public static String getRandomStringOfNumbersWithLength(int var0) {
        StringBuffer var1 = new StringBuffer(var0);

        for(int var2 = 0; var2 < var0; ++var2) {
            var1.append(Character.toString((char)((int)(Math.random() * 9.0 + 48.0))));
        }

        return var1.toString();
    }

    public static String getRandomSpecialCharacterStringWithLength(int var0) {
        StringBuffer var1 = new StringBuffer(var0);

        for(int var2 = 0; var2 < var0; ++var2) {
            switch (a.nextInt(4)) {
                case 0:
                    var1.append(Character.toString((char)((int)(Math.random() * 5.0 + 33.0))));
                    break;
                case 1:
                    var1.append(Character.toString((char)((int)(Math.random() * 6.0 + 58.0))));
                    break;
                case 2:
                    var1.append(Character.toString((char)((int)(Math.random() * 5.0 + 91.0))));
                    break;
                case 3:
                    var1.append(Character.toString((char)((int)(Math.random() * 7.0 + 40.0))));
                    break;
                default:
                    var1.append(Character.toString((char)((int)(Math.random() * 3.0 + 123.0))));
            }
        }

        return var1.toString();
    }

    public static String stripSelektorType(String var0) {
        String var1 = var0;
        if (var0 != null) {
            if (var0.startsWith("css=")) {
                var1 = var0.replace("css=", "");
            } else if (var0.startsWith("xpath=")) {
                var1 = var0.replace("xpath=", "");
            }
        }

        return var1;
    }

    public static String trimTemplateSelektor(String var0) {
        String var1 = var0;
        if (var0 != null) {
            if (var0.endsWith("%s&']")) {
                var0.replace("%s&", "");
            }

            var1 = formatStr(var0, "");
        }

        return var1;
    }

    public static String extractLengthInformationFromSelector(String var0) {
        return var0.replaceAll("\\[maxlength='[0-9]+'\\]", "");
    }

    public static String formatStr(String var0, String... var1) {
        return String.format(var0, (Object[])var1);
    }

    public static boolean tryParse(String var0) {
        boolean var1 = true;

        try {
            Integer.parseInt(var0);
        } catch (NumberFormatException var2) {
            var1 = false;
        }

        return var1;
    }

    public static boolean isStringEmpty(String var0) {
        return var0 == null || var0.isEmpty();
    }

    public static boolean isAnyStringEmpty(String... var0) {
        if (var0 == null) {
            return true;
        } else {
            int var1 = (var0 = var0).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                if (isStringEmpty(var0[var2])) {
                    return true;
                }
            }

            return false;
        }
    }

    public static String prepareStringForHTML(String var0) {
        return var0 == null ? "" : var0.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("\r", "").replaceAll("\n", "<br/>").replaceAll("Ä", "&Auml;").replaceAll("Ö", "&Ouml;").replaceAll("Ü", "&Uuml;").replaceAll("ä", "&auml;").replaceAll("ö", "&ouml;").replaceAll("ü", "&uuml;").replaceAll("ß", "&szlig;");
    }

    public static String removeIllegalCharacters(String var0, String var1, String var2) {
        if (isAnyStringEmpty(var0, var1)) {
            return var0;
        } else {
            if (var2 == null) {
                var2 = "";
            }

            String var3 = "";
            Pattern var9 = Pattern.compile(var1);
            char[] var8;
            int var4 = (var8 = var0.toCharArray()).length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char var6 = var8[var5];
                if (var9.matcher("" + var6).find()) {
                    var3 = var3 + var6;
                } else {
                    var3 = var3 + var2;
                }
            }

            return var3;
        }
    }

    public static String enhanceList(String var0, String var1, String var2, boolean var3) {
        if (isStringEmpty(var1)) {
            return var0;
        } else {
            if (var2 == null) {
                var2 = "";
            }

            String var4;
            if (!isStringEmpty(var0)) {
                var4 = var0 + var2;
                if (var3) {
                    var4 = var4 + " ";
                }

                var4 = var4 + var1;
            } else {
                var4 = var1;
            }

            return var4;
        }
    }

    public static String legalizeString(String var0) {
        return removeIllegalCharacters(var0, "\\d|\\w", "_");
    }

    public static boolean equalsWithNull(String... var0) {
        if (var0 != null && var0.length > 1) {
            String var1;
            int var2;
            int var3;
            if ((var1 = var0[0]) == null) {
                var2 = (var0 = var0).length;

                for(var3 = 0; var3 < var2; ++var3) {
                    if (var0[var3] != null) {
                        return false;
                    }
                }

                return true;
            } else {
                var2 = (var0 = var0).length;

                for(var3 = 0; var3 < var2; ++var3) {
                    String var4 = var0[var3];
                    if (!var1.equals(var4)) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return true;
        }
    }

    public static String getFirstValidString(String... var0) {
        if (var0 != null && var0.length != 0) {
            int var1 = (var0 = var0).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                String var3;
                if ((var3 = var0[var2]) != null) {
                    return var3;
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public static boolean containsAll(String var0, boolean var1, String... var2) {
        if (var0 == null) {
            return false;
        } else {
            if (var1) {
                var0 = var0.toLowerCase();
            }

            int var3 = (var2 = var2).length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String var5 = var2[var4];
                if (var1) {
                    var5 = var5.toLowerCase();
                }

                if (!var0.contains(var5)) {
                    return false;
                }
            }

            return true;
        }
    }

    static {
        (c = new HashMap()).put("&uuml;", "ü");
        c.put("&#174;", "®");
        c.put("&#38;", "&");
        c.put("&nbsp;", "&nbsp;");
        ALLHTMLTAGS = Pattern.compile("</?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/?>");
    }
}

