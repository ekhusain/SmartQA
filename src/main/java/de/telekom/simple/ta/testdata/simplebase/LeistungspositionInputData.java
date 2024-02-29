package de.telekom.simple.ta.testdata.simplebase;

import de.telekom.simple.ta.enums.LeistungstypItems;
import java.math.BigDecimal;

/**
 * Data which can be entered for a new offer item ("Leistungsposition")
 * For use to pass test-data to test-methods/test-cases.
 *
 */
public class LeistungspositionInputData
{
    // Old data is needed for verifications in Historisation cases
    private String leistungspositionName = null;
    private String leistungspositionNameOld = null;
    private String[] angebotspositionName = null;
    private String[] lpName = null;
    private Integer menge = null;
    private Integer mengeOld = null;
    private LeistungstypItems leistungstyp = null;
    private LeistungstypItems leistungstypOld = null;
    private Boolean annuitaetenrechnung = null;
    private Boolean nachAufwand = null;
    private Boolean nachAufwandOld = null;
    private Boolean indirekteKosten = null;
    private Boolean material = null;
    private Boolean materialOld = null;
    private String beschreibung = null;
    private String beschreibungOld = null;
    private BigDecimal inflationsfaktorRessourcen = null;
    private BigDecimal inflationsfaktorRessourcenOld = null;
    private BigDecimal inflationsfaktorKosten = null;
    private BigDecimal inflationsfaktorKostenOld = null;
    private BigDecimal annuitaetZinssatz = null;
    private BigDecimal annuitaetZinssatzOld = null;
    private Integer annuitaetLaufzeit = null;
    private Integer annuitaetLaufzeitOld = null;
    private BigDecimal annuitaetKWert = null;
    private BigDecimal annuitaetKWertOld = null;
    private String[] lpEditList = null;

    /**
     * Default constructor
     */
    public LeistungspositionInputData()
    { }

    /**
     * Copy constructor - implements shallow copy
     *
     * @param ref
     */
    protected LeistungspositionInputData(LeistungspositionInputData ref)
    {
        this.leistungspositionName = ref.leistungspositionName;
        this.menge = ref.menge;
        this.nachAufwand = ref.nachAufwand;
        this.material = ref.material;
        this.beschreibung = ref.beschreibung;
        this.inflationsfaktorRessourcen = ref.inflationsfaktorRessourcen;
        this.inflationsfaktorKosten = ref.inflationsfaktorKosten;
        this.annuitaetZinssatz = ref.annuitaetZinssatz;
        this.annuitaetLaufzeit = ref.annuitaetLaufzeit;
        this.annuitaetKWert = ref.annuitaetKWert;
    }

    public String[] getBezeichnung() { return lpName; }
    public void setBezeichnung(String[] lpName) { this.lpName = lpName; }
    public String getLeistungspositionName() { return leistungspositionName; }
    public String getLeistungspositionNameOld() { return leistungspositionNameOld; }
    public void setLeistungspositionName(String v) { leistungspositionName = v; }
    public void setLeistungspositionNameOld(String v) { leistungspositionNameOld = v; }
    public String[] getAngebotspositionName() { return angebotspositionName; }
    public void setAngebotspositionName(String[] angebotspositionName) { this.angebotspositionName = angebotspositionName; }
    public Integer getMenge()
    {
        return menge;
    }
    public void setMenge(Integer v) { menge = v; }
    public Integer getMengeOld()
    {
        return mengeOld;
    }
    public void setMengeOld(Integer v)
    {
        mengeOld = v;
    }
    public LeistungstypItems getLeistungstyp() { return leistungstyp; }
    public void setLeistungstypType(LeistungstypItems leistungstypType) { this.leistungstyp = leistungstypType; }
    public LeistungstypItems getLeistungstypTypeOld() { return leistungstypOld; }
    public void setLeistungstypTypeOld(LeistungstypItems leistungstypTypeOld) { this.leistungstypOld = leistungstypTypeOld; }
    public Boolean getAnnuitaetenrechnung() { return annuitaetenrechnung; }
    public void setAnnuitaetenrechnung(Boolean annuitaetenrechnung) { this.annuitaetenrechnung = annuitaetenrechnung; }
    public Boolean getNachAufwand() { return nachAufwand; }
    public void setNachAufwand(Boolean nachAufwand) { this.nachAufwand = nachAufwand; }
    public Boolean getNachAufwandOld() { return nachAufwandOld; }
    public void setNachAufwandOld(Boolean nachAufwandOld) {
        this.nachAufwandOld = nachAufwandOld;
    }
    public Boolean getIndirekteKosten() { return indirekteKosten; }
    public void setIndirekteKosten(Boolean indirekteKosten) { this.indirekteKosten = indirekteKosten; }
    public Boolean getMaterial() { return material; }
    public void setMaterial(Boolean material) {
        this.material = material;
    }
    public Boolean getMaterialOld() { return materialOld; }
    public void setMaterialOld(Boolean materialOld) {
        this.materialOld = materialOld;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }
    public String getBeschreibungOld() {
        return beschreibungOld;
    }
    public void setBeschreibungOld(String beschreibungOld) {
        this.beschreibungOld = beschreibungOld;
    }
    public BigDecimal getInflationsfaktorRessourcen() {
        return inflationsfaktorRessourcen;
    }
    public void setInflationsfaktorRessourcen(BigDecimal inflationsfaktorRessourcen) { this.inflationsfaktorRessourcen = inflationsfaktorRessourcen; }
    public BigDecimal getInflationsfaktorRessourcenOld() { return inflationsfaktorRessourcenOld; }
    public void setInflationsfaktorRessourcenOld(BigDecimal inflationsfaktorRessourcenOld) { this.inflationsfaktorRessourcenOld = inflationsfaktorRessourcenOld; }
    public BigDecimal getInflationsfaktorKosten() { return inflationsfaktorKosten; }
    public void setInflationsfaktorKosten(BigDecimal inflationsfaktorKosten) { this.inflationsfaktorKosten = inflationsfaktorKosten; }
    public BigDecimal getInflationsfaktorKostenOld() {
        return inflationsfaktorKostenOld;
    }
    public void setInflationsfaktorKostenOld(BigDecimal inflationsfaktorKostenOld) { this.inflationsfaktorKostenOld = inflationsfaktorKostenOld; }
    public BigDecimal getAnnuitaetZinssatz() { return annuitaetZinssatz; }
    public void setAnnuitaetZinssatz(BigDecimal annuitaetZinssatz) { this.annuitaetZinssatz = annuitaetZinssatz; }
    public BigDecimal getAnnuitaetZinssatzOld() { return annuitaetZinssatzOld; }
    public void setAnnuitaetZinssatzOld(BigDecimal annuitaetZinssatzOld) { this.annuitaetZinssatzOld = annuitaetZinssatzOld; }
    public Integer getAnnuitaetLaufzeit() {
        return annuitaetLaufzeit;
    }
    public void setAnnuitaetLaufzeit(Integer annuitaetLaufzeit) { this.annuitaetLaufzeit = annuitaetLaufzeit; }
    public Integer getAnnuitaetLaufzeitOld() {
        return annuitaetLaufzeitOld;
    }
    public void setAnnuitaetLaufzeitOld(Integer annuitaetLaufzeitOld) { this.annuitaetLaufzeitOld = annuitaetLaufzeitOld; }
    public BigDecimal getAnnuitaetKWert() { return annuitaetKWert; }
    public void setAnnuitaetKWert(BigDecimal annuitaetKWert) { this.annuitaetKWert = annuitaetKWert; }
    public BigDecimal getAnnuitaetKWertOld() {
        return annuitaetKWertOld;
    }
    public void setAnnuitaetKWertOld(BigDecimal annuitaetKWertOld) { this.annuitaetKWertOld = annuitaetKWertOld; }
    public String[] getLpEditList() {
        return lpEditList;
    }
    public void setLpEditList(String[] lpEditList) {
        this.lpEditList = lpEditList;
    }
    //Only for Katalog
    private String[] kategorie = null;
    public String[] getKategorie() { return kategorie; }
    public void setKategorie(String[] kategorie) { this.kategorie = kategorie; }
}
