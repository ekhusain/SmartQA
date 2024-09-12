package de.telekom.simple.ta.testdata.model;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XLSWriter extends AbstractXLSIO {
    public XLSWriter() {
    }

    public XLSWriter openFileFromResource(String var1, String var2) {
        super.openFileFromResource(var1, var2);
        return this;
    }

    public XLSWriter openFileAbsolute(String var1, String var2) {
        super.openFileAbsolute(var1, var2);
        return this;
    }

    public int getLastRowNumber() {
        return this.sheet.getLastRowNum();
    }

    public XLSWriter writeCell(String var1, int var2, String var3) {
        Cell var4;
        (var4 = this.findRowWithIndex(var1).createCell(var2)).setCellType(1);
        var4.setCellValue(var3);
        return this;
    }

    public XLSWriter writeCell(int var1, int var2, String var3) {
        Row var4;
        if ((var4 = this.sheet.getRow(var1)) == null) {
            this.sheet.createRow(var1);
        }

        Cell var5;
        if ((var5 = var4.getCell(var2)) == null) {
            var4.createCell(var2);
        }

        var5.setCellType(1);
        var5.setCellValue(var3);
        return this;
    }

    public void saveAs(String var1) throws IOException {
        LOGGER.info("Writing to " + var1);
        synchronized(LOCK) {
            FileOutputStream var4 = new FileOutputStream(var1);
            this.workbook.write(var4);
            var4.flush();
            var4.close();
        }
    }
}
