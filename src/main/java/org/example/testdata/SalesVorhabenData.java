package org.example.testdata;

import org.example.pages.NeuesVorhabenAnlegenPage;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesVorhabenData {

    private LocalDate vertragsbeginn = null;
    private LocalDate vertragsende = null;
    private String vorhabenname = null;
    private BigDecimal volumenDtts = null;
    private String kundenname = null;

    private NeuesVorhabenAnlegenPage.SicherheitsstufeEnumItems sicherheitsstufe;

    public LocalDate getVertragsbeginn() {
        return vertragsbeginn;
    }

    public void setVertragsbeginn(LocalDate vertragsbeginn) {
        this.vertragsbeginn = vertragsbeginn;
    }

    public LocalDate getVertragsende() {
        return vertragsende;
    }

    public void setVertragsende(LocalDate vertragsende) {
        this.vertragsende = vertragsende;
    }

    public String getVorhabenname() {
        return vorhabenname;
    }

    public void setVorhabenname(String vorhabenname) {
        this.vorhabenname = vorhabenname;
    }

    public BigDecimal getVolumenDtts() {
        return volumenDtts;
    }

    public void setVolumenDtts(BigDecimal volumenDtts) {
        this.volumenDtts = volumenDtts;
    }

    public NeuesVorhabenAnlegenPage.SicherheitsstufeEnumItems getSicherheitsstufe() {
        return sicherheitsstufe;
    }

    public void setSicherheitsstufe(NeuesVorhabenAnlegenPage.SicherheitsstufeEnumItems sicherheitsstufe) {
        this.sicherheitsstufe = sicherheitsstufe;
    }

    public String getKundenname() {
        return kundenname;
    }

    public void setKundenname(String kundenname) {
        this.kundenname = kundenname;
    }
}
