package de.telekom.simple.ta.constants;

public final class RTConstants {
    private static final String a = System.getProperty("test.properties.file", "test.properties");

    public static String getXetaTestPropertiesFile() {
        return a;
    }

    public static String getDownloadPathByOS(Test0S var0) {
        if (var0 == Test0S.WINDOWS) {
            return "C:\\xetaDownloads\\";
        } else if (var0 == Test0S.LINUX) {
            return "/tmp/xetaDownloads/";
        } else {
            throw new UnsupportedOperationException("OS not supported by Supervisor Downloader. No path for OS set in Constants");
        }
    }

    private RTConstants() {
    }
}
