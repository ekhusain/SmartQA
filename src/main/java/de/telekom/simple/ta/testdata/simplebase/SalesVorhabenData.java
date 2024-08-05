package de.telekom.simple.ta.testdata.simplebase;

import de.telekom.simple.ta.pages.AuftragBeendenPage;
import de.telekom.simple.ta.pages.sales.KlassifizierungBearbeitenPage;
import de.telekom.simple.ta.pages.sales.NeuesVorhabenAnlegenPage;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesVorhabenData {

    private LocalDate vertragsbeginn = null;
    private LocalDate vertragsende = null;
    private String vorhabenname = null;
    private BigDecimal volumenDtts = null;
    private String kundenname = null;
    private String kundennummer;

    /*
            Klassifizierung parameters
             */
    private KlassifizierungBearbeitenPage.SalesBoostEnumItems salesBoost;
    private KlassifizierungBearbeitenPage.ProfitcenterEnumItems profitcenter;
    private KlassifizierungBearbeitenPage.VertriebssegmentEnumItems vertiebssegment;
    private KlassifizierungBearbeitenPage.KundenregionEnumItems kundenregion;
    private KlassifizierungBearbeitenPage.PortfolioElementType portfolio;
    private KlassifizierungBearbeitenPage.TeilprojektGewinnenEnumItems gewinnen;

    private NeuesVorhabenAnlegenPage.SicherheitsstufeEnumItems sicherheitsstufe;


    /*
    Parameter for S1
     */
    private LocalDate lieferterminAngebot = null;


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

    public KlassifizierungBearbeitenPage.SalesBoostEnumItems getSalesBoost() {
        return salesBoost;
    }

    public void setSalesBoost(KlassifizierungBearbeitenPage.SalesBoostEnumItems salesBoost) {
        this.salesBoost = salesBoost;
    }

    public KlassifizierungBearbeitenPage.ProfitcenterEnumItems getProfitcenter() {
        return profitcenter;
    }

    public void setProfitcenter(KlassifizierungBearbeitenPage.ProfitcenterEnumItems profitcenter) {
        this.profitcenter = profitcenter;
    }

    public KlassifizierungBearbeitenPage.VertriebssegmentEnumItems getVertiebssegment() {
        return vertiebssegment;
    }

    public void setVertiebssegment(KlassifizierungBearbeitenPage.VertriebssegmentEnumItems vertiebssegment) {
        this.vertiebssegment = vertiebssegment;
    }

    public KlassifizierungBearbeitenPage.KundenregionEnumItems getKundenregion() {
        return kundenregion;
    }

    public void setKundenregion(KlassifizierungBearbeitenPage.KundenregionEnumItems kundenregion) {
        this.kundenregion = kundenregion;
    }

    public KlassifizierungBearbeitenPage.PortfolioElementType getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(KlassifizierungBearbeitenPage.PortfolioElementType portfolio) {
        this.portfolio = portfolio;
    }

    public KlassifizierungBearbeitenPage.TeilprojektGewinnenEnumItems getGewinnen() {
        return gewinnen;
    }

    public void setGewinnen(KlassifizierungBearbeitenPage.TeilprojektGewinnenEnumItems gewinnen) {
        this.gewinnen = gewinnen;
    }

    public LocalDate getLieferterminAngebot() {
        return lieferterminAngebot;
    }

    public void setLieferterminAngebot(LocalDate date) {
        lieferterminAngebot = date;
    }

    /*
    Parameters for project closing
     */
    private AuftragBeendenPage.AuftragBeendenEnumItems abgeschlossenGrund = null;

    public AuftragBeendenPage.AuftragBeendenEnumItems getAbgeschlossenGrund() {
        return abgeschlossenGrund;
    }

    public void setAbgeschlossenGrund(AuftragBeendenPage.AuftragBeendenEnumItems abgeschlossenGrund) {
        this.abgeschlossenGrund = abgeschlossenGrund;
    }
    public String getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(String kundennummer) {
        this.kundennummer = kundennummer;
    }

}
