package de.telekom.simple.ta.testdata.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractXLSIO {
    protected static final Logger LOGGER = LoggerFactory.getLogger(XLSTestDataReader.class);
    protected Workbook workbook;
    protected FormulaEvaluator formulaEvaluator;
    protected Sheet sheet;
    private SimpleDateFormat a = new SimpleDateFormat("dd.MM.yyyy");
    protected static final Object LOCK = new Object();
    protected int headerRow = 1;
    protected int indexColumn = 1;

    public AbstractXLSIO() {
    }

    protected String getStringCellValue(Cell var1) {
        if (var1 == null) {
            return "";
        } else {
            switch (var1.getCellType()) {
                case 0:
                    if (DateUtil.isCellDateFormatted(var1)) {
                        Date var3 = var1.getDateCellValue();
                        return this.a.format(var3);
                    }

                    return this.getCellValue(var1);
                case 1:
                    return var1.getStringCellValue();
                case 2:
                    return this.getCellValue(var1);
                case 3:
                    return "";
                case 4:
                    return Boolean.toString(var1.getBooleanCellValue());
                case 5:
                    return "Error " + var1.getErrorCellValue();
                default:
                    return "";
            }
        }
    }

    protected String getCellValue(Cell var1) {
        String var2 = "Cell (" + (var1.getRowIndex() + 1) + ", " + (var1.getColumnIndex() + 1) + ") - ";
        String var4;
        if (var1.getCellStyle().getDataFormatString() != null) {
            DataFormatter var3 = new DataFormatter();
            if (var1.getCellType() == 2) {
                LOGGER.debug(var2 + "Found formula: " + var1.getCellFormula());
                var4 = var3.formatCellValue(var1, this.formulaEvaluator);
            } else {
                var4 = var3.formatCellValue(var1);
            }
        } else {
            var4 = "" + var1.getNumericCellValue();
        }

        return this.reformatCellValue(var4);
    }

    protected String reformatCellValue(String var1) {
        return var1.replace("[$EUR]", "EUR");
    }

    public int getHeaderRow() {
        return this.headerRow;
    }

    public void setHeaderRow(int var1) {
        this.headerRow = var1;
    }

    public int getIndexColumn() {
        return this.indexColumn;
    }

    public void setIndexColumn(int var1) {
        this.indexColumn = var1;
    }

    protected XLSWriter openFileFromResource(String var1, String var2) {
        LOGGER.info("Reading from " + var1);
        synchronized(LOCK) {
            InputStream var4;
            if ((var4 = Thread.currentThread().getContextClassLoader().getResourceAsStream(var1)) == null) {
                throw new XetaSystemException("Error reading resource file " + var1);
            } else {
                try {
                    this.workbook = WorkbookFactory.create(var4);
                } catch (IOException var5) {
                    throw new XetaSystemException("Cannot read xls(x) file: " + var1, var5);
                } catch (InvalidFormatException var6) {
                    throw new XetaSystemException("Cannot read xls(x) file: " + var1, var6);
                }

                this.sheet = this.workbook.getSheet(var2);
                if (this.sheet == null) {
                    throw new XetaSystemException("No sheet with name " + var2 + " found.");
                } else {
                    return null;
                }
            }
        }
    }

    protected XLSWriter openFileAbsolute(String var1, String var2) {
        LOGGER.info("Reading from " + var1);
        synchronized(LOCK) {
            try {
                FileInputStream var4 = new FileInputStream(var1);
                this.workbook = WorkbookFactory.create(var4);
            } catch (IOException var5) {
                throw new XetaSystemException("Cannot read xls(x) file: " + var1, var5);
            } catch (InvalidFormatException var6) {
                throw new XetaSystemException("Cannot read xls(x) file: " + var1, var6);
            }
            this.sheet = this.workbook.getSheet(var2);
            if (this.sheet == null) {
                throw new XetaSystemException("No sheet with name " + var2 + " found.");
            } else {
                return null;
            }
        }
    }

    protected Row findRowWithIndex(String var1) {
        Iterator var2 = this.sheet.rowIterator();

        Row var3;
        Cell var4;
        do {
            if (!var2.hasNext()) {
                throw new XetaSystemException("Could not find a dataset for >" + var1 + "< in column " + this.indexColumn + " in current worksheet.");
            }
        } while((var4 = (var3 = (Row)var2.next()).getCell(this.indexColumn - 1)) == null || !this.getStringCellValue(var4).trim().equals(var1.trim()));

        return var3;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return this.a;
    }

    public void setSimpleDateFormat(SimpleDateFormat var1) {
        this.a = var1;
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    public Workbook getWorkbook() {
        return this.workbook;
    }

    public class XetaSystemException extends RuntimeException {
        private static final long serialVersionUID = 2018090500000932L;

        public XetaSystemException(String var1) {
            super(var1);
        }

        public XetaSystemException(String var1, Throwable var2) {
            super(var1, var2);
        }

        public XetaSystemException(Throwable var1) {
            super(var1);
        }
    }
}
