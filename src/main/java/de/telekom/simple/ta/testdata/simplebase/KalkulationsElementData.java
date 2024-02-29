package de.telekom.simple.ta.testdata.simplebase;


import de.telekom.simple.ta.enums.KostenartItems;

import java.math.BigDecimal;

public class KalkulationsElementData {
    private String bezeichnung = null;
    private String bezeichnungOld = null;
    private KostenartItems kostenart = null;
    private KostenartItems kostenartOld = null;
    private Boolean mengenabhaengig = null;
    private Boolean mengenabhaengigOld = null;
    private Boolean inflationsfaktorAnwenden = null;
    private Boolean inflationsfaktorAnwendenOld = null;
    private String beschreibung = null;
    private String beschreibungOld = null;
    private String kommentar1 = null;
    private String kommentar2 = null;
    private String[] elEditList = null;

    private BigDecimal gemeinkostenzuschlag = null;
    private BigDecimal gemeinkostenzuschlagOld = null;

    //
    // Elements only for "Kostenart" which is related to "Kosten"
    //
    private BigDecimal kostenwert = null;
    private BigDecimal kostenwertOld = null;

    //
    // Elements only for "Kostenart" which is related to "Resource"
    //
    private Boolean aufwandRadioButton = null;
    private Boolean euroBetragRadioButton = null;
    private Short aufwandStunden = null;
    private Byte aufwandMinuten = null;
    private Byte aufwandSekunden = null;
    private Short aufwandStundenOld = null;
    private Byte aufwandMinutenOld = null;
    private Byte aufwandSekundenOld = null;

    //
    // Elements only for "Kostenart" which is related to "Resource" and read-only
    // value is dependent on "Kostenart"
    //
    private BigDecimal stundensatz = null;

    //
    // Elements which can only be verified but not entered
    //
    private String angelegtVon = null;
    public KalkulationsElementData() {
    }

    public KalkulationsElementData(KalkulationsElementData ref) {
        this.bezeichnung = ref.bezeichnung;
        this.kostenart = ref.kostenart;
        this.mengenabhaengig = ref.mengenabhaengig;
        this.inflationsfaktorAnwenden = ref.inflationsfaktorAnwenden;
        this.beschreibung = ref.beschreibung;
        this.kommentar1 = ref.kommentar1;
        this.kommentar2 = ref.kommentar2;
        this.gemeinkostenzuschlag = ref.gemeinkostenzuschlag;
        this.kostenwert = ref.kostenwert;
        this.aufwandRadioButton = ref.aufwandRadioButton;
        this.euroBetragRadioButton = ref.euroBetragRadioButton;
        this.aufwandStunden = ref.aufwandStunden;
        this.aufwandMinuten = ref.aufwandMinuten;
        this.aufwandSekunden = ref.aufwandSekunden;
        this.stundensatz = ref.stundensatz;
        this.angelegtVon = ref.angelegtVon;
        this.leistungspositionsBezeichnung = ref.leistungspositionsBezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnungOld() {
        return bezeichnungOld;
    }
    public void setBezeichnungOld(String bezeichnungOld) {
        this.bezeichnungOld = bezeichnungOld;
    }

    public KostenartItems getKostenart() {
        return kostenart;
    }
    public void setKostenart(KostenartItems kostenart) {
        this.kostenart = kostenart;
    }

    public KostenartItems getKostenartOld() {
        return kostenartOld;
    }
    public void setKostenartOld(KostenartItems kostenartOld) {
        this.kostenartOld = kostenartOld;
    }

    public Boolean getMengenabhaengig() {
        return mengenabhaengig;
    }
    public void setMengenabhaengig(Boolean mengenabhaengig) {
        this.mengenabhaengig = mengenabhaengig;
    }

    public Boolean getMengenabhaengigOld() {
        return mengenabhaengigOld;
    }
    public void setMengenabhaengigOld(Boolean mengenabhaengigOld) {
        this.mengenabhaengigOld = mengenabhaengigOld;
    }

    public Boolean getInflationsfaktorAnwenden() {
        return inflationsfaktorAnwenden;
    }
    public void setInflationsfaktorAnwenden(Boolean inflationsfaktorAnwenden) { this.inflationsfaktorAnwenden = inflationsfaktorAnwenden; }

    public Boolean getInflationsfaktorAnwendenOld() {
        return inflationsfaktorAnwendenOld;
    }
    public void setInflationsfaktorAnwendenOld(Boolean inflationsfaktorAnwendenOld) { this.inflationsfaktorAnwendenOld = inflationsfaktorAnwendenOld; }

    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBeschreibungOld() {
        return beschreibungOld;
    }
    public void setBeschreibungOld(String beschreibungOld) {
        this.beschreibungOld = beschreibungOld;
    }

    public String getKommentar1() {
        return kommentar1;
    }
    public void setKommentar1(String kommentar1) {
        this.kommentar1 = kommentar1;
    }

    public String getKommentar2() {
        return kommentar2;
    }
    public void setKommentar2(String kommentar2) {
        this.kommentar2 = kommentar2;
    }

    public BigDecimal getGemeinkostenzuschlag() {
        return gemeinkostenzuschlag;
    }
    public void setGemeinkostenzuschlag(BigDecimal gemeinkostenzuschlag) { this.gemeinkostenzuschlag = gemeinkostenzuschlag; }

    public BigDecimal getGemeinkostenzuschlagOld() {
        return gemeinkostenzuschlagOld;
    }
    public void setGemeinkostenzuschlagOld(BigDecimal gemeinkostenzuschlagOld) { this.gemeinkostenzuschlagOld = gemeinkostenzuschlagOld; }

    public BigDecimal getKostenwert() {
        return kostenwert;
    }
    public void setKostenwert(BigDecimal kostenwert) {
        this.kostenwert = kostenwert;
    }

    public BigDecimal getKostenwertOld() {
        return kostenwertOld;
    }
    public void setKostenwertOld(BigDecimal kostenwertOld) {
        this.kostenwertOld = kostenwertOld;
    }

    public Short getAufwandStunden() {
        return aufwandStunden;
    }

    public Short getAufwandStundenOld() {
        return aufwandStundenOld;
    }
    public void setAufwandStundenOld(Short aufwandStundenOld) {
        this.aufwandStundenOld = aufwandStundenOld;
    }

    public Byte getAufwandMinuten() {
        return aufwandMinuten;
    }

    public Byte getAufwandMinutenOld() {
        return aufwandMinutenOld;
    }
    public void setAufwandMinutenOld(Byte aufwandMinutenOld) {
        this.aufwandMinutenOld = aufwandMinutenOld;
    }

    public Byte getAufwandSekunden() {
        return aufwandSekunden;
    }
    public Byte getAufwandSekundenOld() {
        return aufwandSekundenOld;
    }
    public void setAufwandSekundenOld(Byte aufwandSekundenOld) {
        this.aufwandSekundenOld = aufwandSekundenOld;
    }
    public Boolean getAufwandRadioButton() {
        return aufwandRadioButton;
    }
    public void setAufwandRadioButton(Boolean aufwandRadioButton) {
        this.aufwandRadioButton = aufwandRadioButton;
    }
    public Boolean getEuroBetragRadioButton() {
        return euroBetragRadioButton;
    }
    public void setEuroBetragRadioButton(Boolean euroBetragRadioButton) {
        this.euroBetragRadioButton = euroBetragRadioButton;
    }

    public BigDecimal getStundensatz() {
        return stundensatz;
    }
    public void setStundensatz(BigDecimal stundensatz) {
        this.stundensatz = stundensatz;
    }
    private String[] leistungspositionsBezeichnung = null;

    public String[] getLeistungspositionsBezeichnung() {
        return leistungspositionsBezeichnung;
    }
    public void setLeistungspositionsBezeichnung(String[] leistungspositionsBezeichnung) { this.leistungspositionsBezeichnung = leistungspositionsBezeichnung; }

    private String[] angebotspositionBezeichnung = null;

    public String[] getAngebotspositionBezeichnung() { return angebotspositionBezeichnung; }
    public void setAngebotspositionBezeichnung(String[] angebotspositionBezeichnung) {
        this.angebotspositionBezeichnung = angebotspositionBezeichnung;
    }
    public String[] getElEditList() {
        return elEditList;
    }
    public void setElEditList(String[] elEditList) {
        this.elEditList = elEditList;
    }

    //Only for Katalog
    private String[] kategorie = null;

    public String[] getKategorie() { return kategorie; }
    public void setKategorie(String[] kategorie) { this.kategorie = kategorie; }
}

