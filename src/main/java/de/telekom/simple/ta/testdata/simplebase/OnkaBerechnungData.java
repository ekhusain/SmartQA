package de.telekom.simple.ta.testdata.simplebase;

import de.telekom.simple.ta.pages.onka.BerechnungErstellenPage;

import java.math.BigDecimal;

public class OnkaBerechnungData {
    private String bezeichnung = null;
    private BerechnungErstellenPage.OperatorEnumItems operator = null;
    private BerechnungErstellenPage.VariableEnumItems variable = null;
    private BigDecimal wert = null;
    private String kommentar = null;
    private String bezeichnungOld = null;
    private BigDecimal wertOld = null;
    private BerechnungErstellenPage.OperatorEnumItems operatorOld = null;
    private String[] leistungspositionsBezeichnung = null;
    private String[] kalkulationsElementBezeichnung = null;
    private String[] angebotspositionsBezeichnung = null;
    private BerechnungErstellenPage.ZielobjektEnumItems zielObjekt;

    private String[] berEditList = null;

    public OnkaBerechnungData()
    { }

    public OnkaBerechnungData(OnkaBerechnungData ref)
    {
        this.bezeichnung = ref.bezeichnung;
        this.operator = ref.operator;
        this.variable = ref.variable;
        this.wert = ref.wert;
        this.kommentar = ref.kommentar;

        this.leistungspositionsBezeichnung = ref.leistungspositionsBezeichnung;
        this.kalkulationsElementBezeichnung = ref.kalkulationsElementBezeichnung;
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }
    public void setBezeichnung(String bezeichnung){this.bezeichnung = bezeichnung;}

    public BerechnungErstellenPage.OperatorEnumItems getOperator()
    {
        return operator;
    }
    public void setOperator(BerechnungErstellenPage.OperatorEnumItems operator) { this.operator = operator; }

    public BerechnungErstellenPage.VariableEnumItems getVariable()
    {
        return variable;
    }
    public void setVariable(BerechnungErstellenPage.VariableEnumItems variable) { this.variable = variable; }

    public BigDecimal getWert()
    {
        return wert;
    }
    public void setWert(BigDecimal wert)
    {
        this.wert = wert;
    }

    public String getKommentar()
    {
        return kommentar;
    }
    public void setKommentar(String kommentar)
    {
        this.kommentar = kommentar;
    }

    public String[] getLeistungspositionsBezeichnung()
    {
        return leistungspositionsBezeichnung;
    }
    public void setLeistungspositionsBezeichnung(String[] leistungspositionsBezeichnung) { this.leistungspositionsBezeichnung = leistungspositionsBezeichnung; }

    public String[] getKalkulationsElementBezeichnung()
    {
        return kalkulationsElementBezeichnung;
    }
    public void setKalkulationsElementBezeichnung(String[] kalkulationsElementBezeichnung) { this.kalkulationsElementBezeichnung = kalkulationsElementBezeichnung; }

    public String[] getAngebotspositionsBezeichnung() {return angebotspositionsBezeichnung;}
    public void setAngebotspositionsBezeichnung(String[] angebotspositionsBezeichnung) { this.angebotspositionsBezeichnung = angebotspositionsBezeichnung; }

    public String getBezeichnungOld() { return bezeichnungOld; }
    public void setBezeichnungOld(String bezeichnungOld) { this.bezeichnungOld = bezeichnungOld; }

    public BigDecimal getWertOld() { return wertOld; }
    public void setWertOld(BigDecimal wertOld) {
        this.wertOld = wertOld;
    }

    public BerechnungErstellenPage.OperatorEnumItems getOperatorOld() {
        return operatorOld;
    }
    public void setOperatorOld(BerechnungErstellenPage.OperatorEnumItems operatorOld) { this.operatorOld = operatorOld; }

    public BerechnungErstellenPage.ZielobjektEnumItems getZielObjekt() {
        return zielObjekt;
    }
    public void setZielObjekt(BerechnungErstellenPage.ZielobjektEnumItems zielObjekt) { this.zielObjekt = zielObjekt; }

    public String[] getBerEditList() {
        return berEditList;
    }
    public void setBerEditList(String[] berEditList) {
        this.berEditList = berEditList;
    }

    //Only for Katalog
    private String[] kategorie = null;

    public String[] getKategorie() { return kategorie; }
    public void setKategorie(String[] kategorie) { this.kategorie = kategorie; }
}
