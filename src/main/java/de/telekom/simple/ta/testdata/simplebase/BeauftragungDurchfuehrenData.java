package de.telekom.simple.ta.testdata.simplebase;

import de.telekom.simple.ta.enums.DebitorEnumItems;
import de.telekom.simple.ta.pages.offer.OfferDashboardAngebotBeauftragenPage;

import java.time.LocalDate;

public class BeauftragungDurchfuehrenData {

    private Boolean regulaereBeauftragung = null;
    private Boolean vorabbeauftragung = null;
    private OfferDashboardAngebotBeauftragenPage.AngebotsversionEnumItems angebotsversion = null;
    private DebitorEnumItems debitor = null;
    private String sapauftragsnummer = null;
    private LocalDate auftragsdatum = null;
    private String auftragsverantwortlicherSearchString = null;
    private LocalDate vertragsbeginn = null;
    private LocalDate vertragsende = null;
    private LocalDate realisierungsbeginn = null;
    private LocalDate realisierungsende = null;
    private LocalDate betriebsbeginn = null;
    private LocalDate betriebsende = null;
    private LocalDate beauftragungsende = null;
    private boolean checkAllOptionalAps = false;
    private String[] optionaleAps = null;


    public BeauftragungDurchfuehrenData() {
    }

    public OfferDashboardAngebotBeauftragenPage.AngebotsversionEnumItems getAngebotsversion() {
        return angebotsversion;
    }
    public void setAngebotsversion(OfferDashboardAngebotBeauftragenPage.AngebotsversionEnumItems angebotsversion) {
        this.angebotsversion = angebotsversion;
    }

    public DebitorEnumItems getDebitor() {
        return debitor;
    }
    public void setDebitorItems(DebitorEnumItems debitor) {
        this.debitor = debitor;
    }

    public String getSapAuftragsNummer() {
        return sapauftragsnummer;
    }
    public void setSapAuftragsNummer(String v) {
        sapauftragsnummer = v;
    }

    public LocalDate getAuftragsDatum() {
        return auftragsdatum;
    }
    public void setAuftragsDatum(LocalDate v) {
        auftragsdatum = v;
    }

    public String getAVSearchString() {
        return auftragsverantwortlicherSearchString;
    }
    public void setAVSearchString(String v) {
        auftragsverantwortlicherSearchString = v;
    }

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

    public LocalDate getRealisierungsbeginn() {
        return realisierungsbeginn;
    }
    public void setRealisierungsbeginn(LocalDate realisierungsbeginn) {
        this.realisierungsbeginn = realisierungsbeginn;
    }

    public LocalDate getRealisierungsende() {
        return realisierungsende;
    }
    public void setRealisierungsende(LocalDate realisierungsende) {
        this.realisierungsende = realisierungsende;
    }

    public LocalDate getBetriebsbeginn() {
        return betriebsbeginn;
    }
    public void setBetriebsbeginn(LocalDate betriebsbeginn) {
        this.betriebsbeginn = betriebsbeginn;
    }

    public LocalDate getBetriebsende() {
        return betriebsende;
    }
    public void setBetriebsende(LocalDate betriebsende) {
        this.betriebsende = betriebsende;
    }

    public LocalDate getBeauftragungsende() {
        return beauftragungsende;
    }
    public void setBeauftragungsende(LocalDate beauftragungsende) {
        this.beauftragungsende = beauftragungsende;
    }

    public String[] getOptionaleAps() {
        return optionaleAps;
    }
    public void setOptionaleAps(String[] optionaleAps) {
        this.optionaleAps = optionaleAps;
    }

    public boolean getCheckAllOptionalAps() {
        return checkAllOptionalAps;
    }
    public void setCheckAllOptionalAps(boolean checkAllOptionalAps) {
        this.checkAllOptionalAps = checkAllOptionalAps;
    }

    public Boolean getVorabbeauftragung() {
        return vorabbeauftragung;
    }
    public void setVorabbeauftragung(Boolean vorabbeauftragung) {
        this.vorabbeauftragung = vorabbeauftragung;
    }

    public Boolean getRegulaereBeauftragung() {
        return regulaereBeauftragung;
    }
    public void setRegulaereBeauftragung(Boolean regulaereBeauftragung) {
        this.regulaereBeauftragung = regulaereBeauftragung;
    }
}
