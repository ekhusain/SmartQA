package de.telekom.simple.ta.testdata.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XLSTestDataReader extends AbstractXLSIO {
    public XLSTestDataReader() {
    }

    public Map<String, String> readXLSTestDataFromResource(String var1, String var2, String var3) {
        this.openFileFromResource(var1, var2);
        return this.a(var3);
    }

    public Map<String, String> readXLSTestDataFromFile(String var1, String var2, String var3) {
        this.openFileAbsolute(var1, var2);
        return this.a(var3);
    }

    private Map<String, String> a(String var1) {
        this.formulaEvaluator = this.workbook.getCreationHelper().createFormulaEvaluator();
        Row var2;
        if ((var2 = this.sheet.getRow(this.headerRow - 1)) == null) {
            throw new XetaSystemException("Header row is empty. Row " + this.headerRow + " (1-based)");
        } else {
            Row var3 = this.findRowWithIndex(var1);
            return this.a(var2, var3);
        }
    }

    private Map<String, String> a(Row var1, Row var2) {
        HashMap var3 = new HashMap();

        for(int var6 = 0; var6 < var1.getLastCellNum(); ++var6) {
            String var4 = this.getStringCellValue(var1.getCell(var6)).trim();
            String var5 = this.getStringCellValue(var2.getCell(var6)).trim();
            var3.put(var4, var5);
        }

        return var3;
    }

    public List<Map<String, String>> readXLSTestDataFromResource(String var1, String var2) {
        return this.readXLSTestDataFromResource(var1, var2, (String)null, (String)null);
    }

    public List<Map<String, String>> readXLSTestDataFromResource(String var1, String var2, String var3, String var4) {
        this.openFileFromResource(var1, var2);
        return this.a(var3, var4);
    }

    public List<Map<String, String>> readXLSTestDataFromFile(String var1, String var2) {
        return this.readXLSTestDataFromFile(var1, var2, (String)null, (String)null);
    }

    public List<Map<String, String>> readXLSTestDataFromFile(String var1, String var2, String var3, String var4) {
        this.openFileAbsolute(var1, var2);
        return this.a(var3, var4);
    }

    private List<Map<String, String>> a(String var1, String var2) {
        this.formulaEvaluator = this.workbook.getCreationHelper().createFormulaEvaluator();
        Row var3 = this.sheet.getRow(this.headerRow - 1);
        LinkedList var4 = new LinkedList();
        Row var7;
        if (var1 == null) {
            if (var3 == null) {
                return var4;
            }

            if (this.sheet.getLastRowNum() == var3.getRowNum()) {
                return var4;
            }

            var7 = this.sheet.getRow(var3.getRowNum() + 1);
        } else {
            var7 = this.findRowWithIndex(var1);
        }

        for(int var6 = var7.getRowNum(); var6 <= this.sheet.getLastRowNum(); ++var6) {
            var7 = this.sheet.getRow(var6);
            Map var5 = this.a(var3, var7);
            var4.add(var5);
            Cell var8;
            if ((var8 = var7.getCell(this.indexColumn - 1)) != null) {
                var1 = this.getStringCellValue(var8);
                if (var2 != null && var1.trim().equals(var2.trim())) {
                    break;
                }
            }
        }

        return var4;
    }
}