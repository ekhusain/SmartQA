package de.telekom.simple.ta.enums;

/**
 * Represents the values of Kostenart in the Kalkulations-Element... forms
 */
public enum KostenartItems implements SimpleGroupedMenuItems
{
    EMPTY("", ""),

    ISP_SR_SN_SRSNT1INSTALLATIONSTECHNIKER("ISP - SR S/N T1 - Installationstechniker", ""),

    ISP_SR_SN_SRSNT2FIELDSERVICETECHNIKER("ISP - SR S/N T2 - Fieldservice Techniker", ""),

    ISP_SR_SN_SRSNT3SYSTEMENGINEERA("ISP - SR S/N T3 - System Engineer A", ""),

    ISP_SR_SN_SRSNT4SYSTEMENGINEERB("ISP - SR S/N T4 - System Engineer B", ""),

    ISP_SR_SN_SRSNT5SYSTEMENGINEERC("ISP - SR S/N T5 - System Engineer C", ""),

    ISP_SR_SN_SRSNT6SYSTEMENGINEERD("ISP - SR S/N T6 - System Engineer D", ""),

    ISP_SR_SN_SRSNC1CONSULTANTI("ISP - SR S/N C1 - Consultant I", ""),

    ISP_SR_SN_SRSNC2CONSULTANTII("ISP - SR S/N C2 - Consultant II", ""),

    ISP_SR_SN_SRSNP1PROJEKTMANAGERI("ISP - SR S/N P1 - Projektmanager I", ""),

    ISP_SR_SN_SRSNP2PROJEKTMANAGERII("ISP - SR S/N P2 - Projektmanager II", ""),

    ISP_CSO_CSOSERVICEOPERATOR("ISP - CSO Service Operator", ""),

    ISP_CSO_CSOTECHNICALAGENT("ISP - CSO Technical Agent", ""),

    ISP_CSO_CSOTECHNICALEXPERTSUPERVISORDUTYMANAGER("ISP - CSO Technical Expert/Supervisor/Duty Manager", ""),

    ISP_CSO_CSOSPECIALTECHNICALEXPERT("ISP - CSO Special Technical Expert", ""),

    ISP_CSO_CSODELIVERYMANAGER("ISP - CSO Delivery Manager", ""),

    ISP_CSO_CSOSERVICEOPERATIONSDESIGNERSERVICEEXPERT("ISP - CSO Service Operations Designer (Service Expert)", ""),

    ISP_CSO_CSOOPERATIONSMANAGERTECHNICALCONSULTANT("ISP - CSO Operations Manager (Technical Consultant)", ""),

    ISP_CSO_CSOOPTIMIZEQUALITYMANAGER("ISP - CSO Optimize & Quality Manager", ""),

    ISP_CSO_CSOPROJECTTRANSITIONMANAGER("ISP - CSO Project + Transition Manager", ""),

    ISP_CSO_CSOSOLUTIONSENGINEER("ISP - CSO Solutions Engineer", ""),

    ISP_CSO_CSOTECHNOLOGIESOLUTIONSCONSULTANT("ISP - CSO Technologie + Solutions Consultant", ""),

    ISP_SC_SCDEALPROPOSALMANAGERCONTRACTMANAGER("ISP - SC Deal Proposal Manager / Contract Manager", ""),

    ISP_SC_SCSOLUTIONARCHITECT("ISP - SC Solution Architect", ""),

    ISP_PRM_PRMREALISIERUNGSSUPPORT("ISP - PRM Realisierungssupport", ""),

    ISP_PRM_PRMPROJECTSUPPORT("ISP - PRM Project Support", ""),

    ISP_PRM_PRMPROJECTMANAGER("ISP - PRM Project Manager", ""),

    ISP_PRM_PRMSENIORPROJECTMANAGER("ISP - PRM Senior Project Manager", ""),

    ISP_CE_CECDSENIORCONSULTANT("ISP - CE C&D Senior Consultant", ""),

    ISP_CE_CECDEXPERTE("ISP - CE C&D Experte", ""),

    ISP_CE_CECDSPEZIALIST("ISP - CE C&D Spezialist", ""),

    ISP_CE_CESEEXPERTE("ISP - CE S&E Experte", ""),

    ISP_CE_CESESPEZIALIST("ISP - CE S&E Spezialist", ""),

    ISP_BDO_BDOBUSINESSRESSOURCENMANAGER("ISP - BDO Business Ressourcen Manager", ""),

    ISP_PRODUCTS_PRODUCTOPERATIONSDURCHSCHNITT("ISP - Product Operations (Durchschnitt)", ""),

    ALLGEMEINE_KOSTEN_FAHRTPAUSCHALEISP("ISP - Fahrtpauschale - ISP", ""),

    ALLGEMEINE_KOSTEN_MATERIALKOSTENISP("ISP - Materialkosten - ISP", ""),

    ALLGEMEINE_KOSTEN_REISETAGUNGSKOSTENISP("ISP - Reise-/Tagungskosten - ISP", ""),

    ALLGEMEINE_KOSTEN_RISIKOISP("ISP - Risiko - ISP", ""),

    ALLGEMEINE_KOSTEN_RSSBESTANDFESTPREISABGESENKT("ISP - RSS-Bestand Festpreis (abgesenkt)", ""),

    ALLGEMEINE_KOSTEN_DELIVERYBEZOGENESACHKOSTEN1ISP("ISP - Delivery bezogene Sachkosten (1 €) - ISP", ""),

    ALLGEMEINE_KOSTEN_SONSTIGESISP("ISP - Sonstiges - ISP", ""),

    ALLGEMEINE_KOSTEN_SACHKOSTENISP("ISP - Sachkosten - ISP", ""),

    ALLGEMEINE_KOSTEN_FREMDLEISTUNGENFUERBEZOGENEDIENSTLEISTUNGENISP("ISP - Fremdleistungen für bezogene Dienstleistungen - ISP", ""),

    ALLGEMEINE_KOSTEN_FREMDLEISTUNGENFUERERSETZTEEIGENLEISTUNGENISP("ISP - Fremdleistungen für ersetzte Eigenleistungen - ISP", ""),

    SGRK_DTA_AUSSENDIENST_DTAADSERVICESPEZIALIST("DTA - DTA AD Servicespezialist", ""),

    SGRK_DTA_AUSSENDIENST_DTAADTECHNIKER("DTA - DTA AD Techniker", ""),

    SGRK_DTA_AUSSENDIENST_DTAADFAHRPAUSCHALE1PERSON1FAHRZEUGBIS10KM("DTA - DTA AD Fahrpauschale (1 Person, 1 Fahrzeug, bis 10 km)", ""),

    SGRK_DTA_AUSSENDIENST_DTAADDISPOSITION("DTA - DTA AD Disposition", ""),

    SGRK_DTA_AUSSENDIENST_FSDISPOSITION("DTA - FS Disposition", ""),

    SGRK_DTA_AUSSENDIENST_DTAADZUSAETZLICHEFAHRKOSTENPROKMPROFAHRZEUG("DTA - DTA AD Zusätzliche Fahrkosten pro km pro Fahrzeug", ""),

    SGRK_DTA_AUSSENDIENST_DTAADZUSAETZLICHEFAHRKOSTENPROKMPROPERSON("DTA - DTA AD Zusätzliche Fahrkosten pro km pro Person", ""),

    SGRK_DTA_AUSSENDIENST_DTAADMATERIALKOSTENEMOBILITY("DTA - DTA AD Materialkosten - E-Mobility", ""),

    SGRK_DTA_AUSSENDIENST_DTAADMATERIALKOSTEN("DTA - DTA AD Materialkosten", ""),

    SGRK_DTA_AUSSENDIENST_DTAADREISETAGUNGSKOSTEN("DTA - DTA AD Reise-/Tagungskosten", ""),

    SGRK_DTA_AUSSENDIENST_DTAADSACHKOSTEN("DTA - DTA AD Sachkosten", ""),

    SGRK_FC_MWW_DTSMWWLOGISTIKMANAGEMENT("MWW - DTS MWW Logistikmanagement", ""),

    SGRK_FC_MWW_DTSMWWMATERIALKOSTEN("MWW - DTS MWW Materialkosten", ""),

    SGRK_FC_MWW_DTSMWWREISETAGUNGSKOSTEN("MWW - DTS MWW Reise-/Tagungskosten", ""),

    SGRK_FC_MWW_DTSMWWSACHKOSTEN("MWW - DTS MWW Sachkosten", ""),

    SGRK_FC_MWW_MWWLOGISTIKMANAGEMENTEMOBILIY("DTS - MWW Logistikmanagement E-Mobiliy", ""),

    SGRK_CC_T_R_B_DTSSGRKCCTRBINIT("DTS - DTS SGrK CC T R & B IN & IT", ""),

    SGRK_CC_T_R_B_DTSSGRKCCTRBREMOTESERVICE("DTS - DTS SGrK CC T R & B Remote Service", ""),

    SGRK_CC_T_R_B_DTSSGRKCCTRBSDI("DTS - DTS SGrK CC T R & B (SDI)", ""),

    SGRK_CC_T_R_B_DTSSGRKCCTRBRUEN("DTS - DTS SGrK CC T R & B (RÜN)", ""),

    SGRK_E2E_DELIVERY_DTSSGRKE2EDELIVERYKM("DTS - DTS SGrK E2E Delivery KM", ""),

    SGRK_E2E_DELIVERY_DTSSGRKE2EDELIVERYKMZAL("DTS - DTS SGrK E2E Delivery KM (zAL)", ""),

    SGRK_E2E_DELIVERY_DTSSGRKE2EDELIVERYKS("DTS - DTS SGrK E2E Delivery (KS)", ""),

    SGRK_E2E_DELIVERY_DTSSGRKE2EDELIVERYKMBUEN("DTS - DTS SGrK E2E Delivery KM (BÜN)", ""),

    SGRK_E2E_DELIVERY_DTSSGRKE2EDELIVERYKMVHMGESPERRT("DTS - DTS SGrK E2E Delivery KM (Vhm gesperrt)", ""),

    SGRK_E2E_DELIVERY_DTSSGRKE2EDELIVERYREGAV("DTS - DTS SGrK E2E Delivery (regAV)", ""),

    SGRK_E2E_DELIVERY_DTSAUFTRAGSMANAGEMENT("DTS - DTS Auftragsmanagement", ""),

    SGRK_E2E_DELIVERY_DTSSGRKMATERIALKOSTEN("DTS - DTS SGrK Materialkosten", ""),

    SGRK_E2E_DELIVERY_DTSSGRKREISETAGUNGSKOSTEN("DTS - DTS SGrK Reise-/Tagungskosten", ""),

    SGRK_E2E_DELIVERY_DTSSGRKSACHKOSTEN("DTS - DTS SGrK Sachkosten", ""),

    SGRK_E2E_ALLGEMEINE_KOSTEN_DTAADFAHRTPAUSCHALE("DTA - DTA AD Fahrtpauschale", ""),

    SGRK_E2E_ALLGEMEINE_KOSTEN_DTAADRISIKOTECHNISCHPROZESSUAL("DTA - DTA AD Risiko (technisch & prozessual)", ""),

    SGRK_E2E_ALLGEMEINE_KOSTEN_DTSSGRKRISIKOPROZESSUAL("DTS - DTS SGRK Risiko (prozessual)", ""),

    EXTERNAL_WORKFORCE_NUR_FUER_DEN_KATALOG_EWFSKILLA("ISP - EWF SKILL A", ""),

    EXTERNAL_WORKFORCE_NUR_FUER_DEN_KATALOG_EWFSKILLB("ISP - EWF SKILL B", ""),

    EXTERNAL_WORKFORCE_NUR_FUER_DEN_KATALOG_EWFSKILLC("ISP - EWF SKILL C", ""),


    //old kostenart
    SC_ANGEBOTSERSTELLER("SC Angebotsersteller", "");


    private String valueString;
    private final String optgroup;

    KostenartItems(String valueString, String optgroup)
    {
        this.valueString = valueString;
        this.optgroup = optgroup;
    }
    @Override
    public String toSelectString()
    {
        return valueString;
    }

    @Override
    public String getOptgroupLabel()
    {
        return optgroup;
    }

}
