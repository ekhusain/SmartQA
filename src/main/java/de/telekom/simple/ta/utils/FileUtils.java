package de.telekom.simple.ta.utils;

import de.telekom.simple.ta.exceptions.SimpleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import de.idyl.winzipaes.AesZipFileEncrypter;
import de.idyl.winzipaes.impl.AESEncrypterJCA;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import de.telekom.simple.ta.exceptions.FileNotFoundException;

public final class FileUtils extends org.apache.commons.io.FileUtils {
    private static String a = "\n";
    private static final Logger b = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
    }

    public static InputStream getResourceInputStream(String var0) throws FileNotFoundException {
        URL var1 = getResourceURL(var0);
        b.info("Loading from: " + var1);

        try {
            return ((URL) Objects.requireNonNull(var1)).openStream();
        } catch (IOException | NullPointerException var2) {
            throw new FileNotFoundException(var0, var2);
        }
    }

    public static InputStream getLocalFileOrResourceInputStream(String var0) {
        try {
            return getLocalFileInputStream(var0);
        } catch (FileNotFoundException var1) {
            return getLocalResourceInputStream(var0);
        }
    }

    public static InputStream getLocalFileInputStream(String var0) throws FileNotFoundException {
        File var1;
        if ((var1 = new File(var0)).exists()) {
            try {
                return new FileInputStream(var1);
            } catch (java.io.FileNotFoundException var2) {
                throw new FileNotFoundException(var0, var2);
            }
        } else {
            throw new FileNotFoundException(var0);
        }
    }

    public static InputStream getLocalResourceInputStream(String var0) throws SimpleException {
        URL var1;
        if ((var1 = getResourceURL(var0)) != null && var1.toString().startsWith("file:")) {
            try {
                return ((URL)Objects.requireNonNull(var1)).openStream();
            } catch (IOException var2) {
                throw new SimpleException(var0, var2);
            }
        } else {
            throw new SimpleException("No local resource file found: " + var0);
        }
    }

    public static String getAbsoluteFilePath(String var0) throws FileNotFoundException {
        URL var1;
        if ((var1 = Thread.currentThread().getContextClassLoader().getResource(var0)) == null) {
            throw new FileNotFoundException(var0);
        } else {
            URI var3;
            try {
                var3 = var1.toURI();
            } catch (URISyntaxException var2) {
                throw new SimpleException("Error getting file uri: " + var1);
            }

            return (new File(var3)).getAbsolutePath();
        }
    }

    public static String readFromResourceFile(String var0) throws IOException {
        String var1;
        try {
            var1 = getAbsoluteFilePath(var0);
        } catch (FileNotFoundException var2) {
            throw new SimpleException("Error loading file: " + var0, var2);
        }

        return readFromFile(var1);
    }

    public static String readFromFile(String var0) throws IOException {
        FileReader var3 = new FileReader(var0);
        BufferedReader var4 = new BufferedReader(var3);
        StringBuilder var1 = new StringBuilder();

        for(String var2 = var4.readLine(); var2 != null; var2 = var4.readLine()) {
            var1.append(var2).append(a);
        }

        var4.close();
        return var1.toString();
    }

    public static String getLineBreak() {
        return a;
    }

    public static void setLineBreak(String var0) {
        a = var0;
    }

    public static void zip(File var0, File... var1) throws ZipException {
        zip(var0, new ZipParameters(), var1);
    }

    public static void zip(File var0, ZipParameters var1, File... var2) throws ZipException {
        if (var1 == null) {
            var1 = new ZipParameters();
        }

        if (var2 == null) {
            throw new IllegalArgumentException("No files named to zip.");
        } else {
            ZipFile var6 = new ZipFile(var0);
            int var3 = (var2 = var2).length;

            for(int var4 = 0; var4 < var3; ++var4) {
                File var5 = var2[var4];
                var6.addFile(var5, var1);
            }

        }
    }

    public static void zip(File var0, InputStream... var1) throws ZipException {
        zip(var0, new ZipParameters(), var1);
    }

    public static void zip(File var0, ZipParameters var1, InputStream... var2) throws ZipException {
        if (var1 == null) {
            var1 = new ZipParameters();
        }

        if (var2 == null) {
            throw new IllegalArgumentException("No files named to zip.");
        } else {
            ZipFile var6 = new ZipFile(var0);
            int var3 = (var2 = var2).length;

            for(int var4 = 0; var4 < var3; ++var4) {
                InputStream var5 = var2[var4];
                var6.addStream(var5, var1);
            }

        }
    }

    public static void zipWinZipAes256(File var0, String var1, File... var2) throws IOException {
        AESEncrypterJCA var3;
        (var3 = new AESEncrypterJCA()).init(var1, 256);
        AesZipFileEncrypter var7 = new AesZipFileEncrypter(var0.getAbsolutePath(), var3);
        int var8 = (var2 = var2).length;

        for(int var4 = 0; var4 < var8; ++var4) {
            File var5;
            String var6 = (var5 = var2[var4]).getName();
            String var9 = var5.getAbsolutePath();
            var7.add(var6, new FileInputStream(var9), var1);
        }

        var7.close();
    }

    public static void unzip(String var0, String var1) throws ZipException {
        unzip(var0, var1, (String)null);
    }

    public static void unzip(String var0, String var1, String var2) throws ZipException {
        ZipFile var3 = new ZipFile(var0);
        if (var2 != null && var3.isEncrypted()) {
            var3.setPassword(var2.toCharArray());
        }

        var3.extractAll(var1);
    }

    public static URL getResourceURL(String var0) {
        return Thread.currentThread().getContextClassLoader().getResource(var0);
    }

    public static File getResourceFile(String var0) {
        URL var1 = getResourceURL(var0);
        return new File(var1.getFile());
    }
}
