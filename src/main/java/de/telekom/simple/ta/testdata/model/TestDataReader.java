package de.telekom.simple.ta.testdata.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataReader
{

    private static final Logger logger = LoggerFactory.getLogger(TestDataReader.class);

    private static final Map<String, Map<String, String>> excelDataRowsMap = new HashMap<>();

    private static final Map<String, List<Map<String, String>>> completeExcelDataSheetsMap = new HashMap<>();

    /**
     * Read data from excel.
     *
     * @param excelFile file to read
     * @param fileIsInResourceDir indication whether the file is in resource dir and the path is relative (true)
     *                            or the file is specified wit an absolute path (false)
     * @param id the id which is searched for in key column
     * @param sheet the sheet
     * @return the map
     */
    protected static synchronized Map<String, String> readDataFromExcel(String excelFile,
                                                                        boolean fileIsInResourceDir,
                                                                        String id, String sheet)
    {
        String key = excelFile + "_" + sheet + "_" + id;
        Map<String, String> data = null;

        if (!excelDataRowsMap.containsKey(key))
        {
            logger.debug(String.format("Reading testdata id '%s' from %s", id, sheet));
            XLSTestDataReader xlsTestDataReader = new XLSTestDataReader();
            xlsTestDataReader.setHeaderRow(1);
            if (fileIsInResourceDir)
            {
                data = xlsTestDataReader.readXLSTestDataFromResource(excelFile, sheet, id);
            }
            else
            {
                data = xlsTestDataReader.readXLSTestDataFromFile(excelFile, sheet, id);
            }
            excelDataRowsMap.put(key, data);
        }
        else
        {
            logger.debug(String.format("Reading testdata id '%s' from cache.", id));
            data = excelDataRowsMap.get(key);
        }
        Map<String, String> newMap = new HashMap<>();
        data.forEach((k, v) -> newMap.put(k, v));

        return newMap;
    }

    /**
     * Read all data from specified excel sheet.
     *
     * @param excelFile file to read
     * @param sheet the sheet
     * @return the list of maps
     */
    protected static List<Map<String, String>> readAllDataFromExcel(String excelFile, String sheet)
    {
        return readAllDataFromExcel(excelFile, true, sheet);
    }

    /**
     * Read all data from specified excel sheet.
     *
     * @param excelFile file to read
     * @param fileIsInResourceDir indication whether the file is in resource dir and the path is relative (true)
     *                            or the file is specified wit an absolute path (false)
     * @param sheet the sheet
     * @return the list of maps
     */
    public static synchronized List<Map<String, String>> readAllDataFromExcel(String excelFile,
                                                                              boolean fileIsInResourceDir,
                                                                              String sheet)
    {
        String key = excelFile + "_" + sheet;
        List<Map<String, String>> resultMapList = null;

        if (!completeExcelDataSheetsMap.containsKey(key))
        {
            logger.debug(String.format("Reading all testdata from %s", sheet));
            XLSTestDataReader xlsTestDataReader = new XLSTestDataReader();
            xlsTestDataReader.setHeaderRow(1);
            if (fileIsInResourceDir)
            {
                resultMapList = xlsTestDataReader.readXLSTestDataFromResource(excelFile, sheet);
            }
            else
            {
                resultMapList = xlsTestDataReader.readXLSTestDataFromFile(excelFile, sheet);
            }
            completeExcelDataSheetsMap.put(key, resultMapList);
        }
        else
        {
            logger.debug("Reading all testdata from cache.");
            resultMapList = completeExcelDataSheetsMap.get(key);
        }

        return resultMapList;
    }

}

