package de.telekom.simple.ta.pages.sales;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.enums.SimpleGroupedMenuItems;
import de.telekom.simple.ta.testdata.simplebase.SalesVorhabenData;
import de.telekom.simple.ta.utils.FieldInputUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class KlassifizierungBearbeitenPage {

    private final Page page;
    private final Locator salesBoost;
    private final Locator profitcenter;
    private final Locator vertriebssegment;
    private final Locator kundenregion;
    private final Locator portfolio;
    private final Locator gewinnen;
    private final Locator speichernButton;

    public KlassifizierungBearbeitenPage(Page page) {
        this.page = page;

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Klassifizierung bearbeiten"))).isVisible();

        this.salesBoost = page.locator("//select[@name='Sales Boost']");
        this.profitcenter = page.locator("//select[@name='Profitcenter']");
        this.vertriebssegment = page.locator("//select[@name='Vertriebssegment']");
        this.kundenregion = page.locator("//select[@name='Kundenregion']");
        this.portfolio = page.locator("//select[@name='Portfolio']");
        this.gewinnen = page.locator("//select[@name='#Gewinnen']");
        this.speichernButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Speichern"));
    }

    public enum SalesBoostEnumItems implements SimpleGroupedMenuItems {
        BITTEAUSWAEHLEN("(Bitte auswählen)", ""),

        TDG("TDG", ""),

        TSIIT("TSI IT", ""),

        TSITC("TSI TC", ""),

        DTITDIRECTBUSINESS("DT IT & Direct Business", ""),

        ;
        private final String valueString;
        private final String optgroup;

        SalesBoostEnumItems(String valueString, String optgroup)
        {
            this.valueString = valueString;
            this.optgroup = optgroup;
        }

        public String toSelectString()
        {
            return valueString;
        }

        public String getOptgroupLabel()
        {
            return optgroup;
        }

    } // end enum

    public enum ProfitcenterEnumItems implements SimpleGroupedMenuItems{
        BITTEAUSWAEHLEN("(Bitte auswählen)", ""),

        TDGPRIVATKUNDEN("TDG Privatkunden", ""),

        TSYSTEMSSOLUTIONTCTOID22593ALTDTTS("T-Systems Solution TC (TOID 22593, alt DTTS)", ""),

        TSYSTEMSSOLUTIONITTOID22594ALTRSS("T-Systems Solution IT (TOID 22594, alt RSS)", ""),

        TDGGESCHAEFTSKUNDEN("TDG Geschäftskunden", ""),

        TDGZENTRUMWHOLESALEMARKTBEREICHCARRIERKUNDEN("TDG Zentrum Wholesale (Marktbereich Carrierkunden)", ""),

        TDGZENTRUMWHOLESALEMARKTBEREICHKONZERNKUNDEN("TDG Zentrum Wholesale (Marktbereich Konzernkunden)", ""),

        DTPRIVATKUNDENVERTRIEBGMBH("DT Privatkunden-Vertrieb GmbH", ""),

        VIVENTOCUSTOMERSERVICESGMBH("Vivento Customer Services GmbH", ""),

        DEUTSCHETELEKOMTECHNIKGMBHBONN("Deutsche Telekom Technik GmbH, Bonn", ""),

        PRODUKTIONSVERBUNDTECHNIKBEITDG("Produktionsverbund Technik bei TDG", ""),

        EXTERNEKUNDENDIREKTFAKTURAZBPAYMENT("Externe Kunden (Direktfaktura, z. B. Payment)", ""),

        MAGYARTELECOM("Magyar Telecom", ""),

        TMOBILEAUSTRIAGMBH("T-Mobile Austria GmbH", ""),

        DTAGGHS("DTAG GHS", ""),

        DTAGVTECHNOLOGYINNOVATIONS("DTAG V Technology & Innovations", ""),

        DTAGVEUROPE("DTAG V Europe", ""),

        MULTIMEDIASOLUTIONS("Multimedia Solutions", ""),

        DEUTSCHETELEKOMCLINICALSOLUTIONSGMBH("Deutsche Telekom Clinical Solutions GmbH", ""),

        TSYSTEMSCLIENTSERVICESGMBH("T-Systems Client Services GmbH", ""),

        TSYSTEMSSCHWEIZAG("T-Systems Schweiz AG", ""),

        TSYSTEMSNORDICAS("T-Systems Nordic A/S", ""),

        TSYSTEMSLIMITED("T-Systems Limited", ""),

        TSYSTEMSNEDERLANDBV("T-Systems Nederland B.V.", ""),

        TSYSTEMSITCIBERIASA("T-Systems ITC Iberia, S.A.", ""),

        TSYSTEMSFRANCESAS("T-Systems France SAS", ""),

        OPERATIONALSERVICESGMBHCOKG("operational services GmbH & Co. KG", ""),

        CTDIGMBH("CTDI GmbH", ""),

        TSYSTEMSINTERNATIONALGMBHTSECURITY("T-Systems International GmbH, T-Security", ""),

        DTAGDTSE("DTAG DTSE", ""),

        DTITGMBH("DT-IT GmbH", ""),

        ITENOS("ITENOS", ""),

        TSYSTEMSSOLUTIONSFORRESEARCHGMBH("T-Systems Solutions for Research GmbH", ""),

        COMFORTCHARGEGMBH("Comfortcharge GmbH", ""),

        TSYSTEMSGEIGMBH("T-Systems GEI GmbH", ""),

        TSIGMBHROADCHARGING("TSI GmbH, Road Charging", ""),

        TSIGMBHCLASSIFIEDICT("TSI GmbH, Classified ICT", ""),

        TSIGMBHINTERNETOFTHINGS("TSI GmbH, Internet of Things", ""),

        TSIGMBHPUBLICCLOUD("TSI GmbH, Public Cloud", ""),

        TSIGMBHDIGITALSOLUTIONS("TSI GmbH, Digital Solutions", ""),

        TSIGMBHDEDICATEDSISOL("TSI GmbH, Dedicated SI Sol", ""),

        TSIGMBHSAP("TSI GmbH, SAP", ""),

        TSIGMBHMISPRIVATECLOUD("TSI GmbH, MIS, Private Cloud", ""),

        TSIGMBHSALESGACROSSDEL("TSI GmbH, Sales, G&A, Cross Del.", ""),

        DFMGDEUTSCHEFUNKTURMGMBH("DFMG Deutsche Funkturm GmbH", ""),

        DEUTSCHETELEKOMHEALTHCAREANDSECURITYSOLUTIONS("Deutsche Telekom Healthcare and Security Solutions", ""),

        PASMPOWERANDAIRCONDITIONSOLUTIONMANAGEMENT("PASM Power and Air Condition Solution Management", ""),

        TSYSTEMSMAGYARORSZGZRT("T-Systems Magyarország ZRt.", ""),

        TSYSTEMSONSITESERVICESGMBH("T-Systems on site services GmbH", ""),

        ;
        private final String valueString;
        private final String optgroup;

        ProfitcenterEnumItems(String valueString, String optgroup)
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

    } // end enum

    public enum VertriebssegmentEnumItems implements SimpleGroupedMenuItems{
        BITTEAUSWAEHLEN("(Bitte auswählen)", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTLNORD("TDG GK Projektgeschäft Segment L Nord", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTLOST("TDG GK Projektgeschäft Segment L Ost", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTLWEST("TDG GK Projektgeschäft Segment L West", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTLMITTE("TDG GK Projektgeschäft Segment L Mitte", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTLSUEDWEST("TDG GK Projektgeschäft Segment L Südwest", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTLSUED("TDG GK Projektgeschäft Segment L Süd", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTMNORD("TDG GK Projektgeschäft Segment M Nord", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTMOST("TDG GK Projektgeschäft Segment M Ost", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTMWEST("TDG GK Projektgeschäft Segment M West", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTMMITTE("TDG GK Projektgeschäft Segment M Mitte", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTMSUEDWEST("TDG GK Projektgeschäft Segment M Südwest", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTMSUED("TDG GK Projektgeschäft Segment M Süd", ""),

        TDGGKPROJEKTGESCHAEFTSEGMENTKMU("TDG GK Projektgeschäft Segment KMU", ""),

        TDGGKMENGENABHAENGIGEKUNDENLEISTUNGEN("TDG GK Mengenabhängige Kundenleistungen", ""),

        TDGGKOPFPRODUKTENTWICKLUNGSSUPPORT("TDG GK OPF & Produktentwicklungssupport", ""),

        TDGGKPLATTFORMMANAGEMENT("TDG GK Plattformmanagement", ""),

        TDGGKCOMMERCIALMANAGEMENT("TDG GK Commercial Management", ""),

        GERMANY("Germany", ""),

        PUBLIC("Public", ""),

        AUTOMOTIVEMANUFACTURINGINDUSTRY("Automotive & Manufacturing Industry", ""),

        INTERNATIONAL("International", ""),

        EXTERNEKUNDENNATIONAL("Externe Kunden National", ""),

        EXTERNEKUNDENINTERNATIONAL("Externe Kunden International", ""),

        SONSTIGEREST("Sonstige / Rest", ""),

        TSYSTEMSINTERN("T-Systems Intern", ""),

        ;
        private final String valueString;
        private final String optgroup;

        VertriebssegmentEnumItems(String valueString, String optgroup)
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

    } // end enum

    public enum KundenregionEnumItems implements SimpleGroupedMenuItems{
        BITTEAUSWAEHLEN("(Bitte auswählen)", ""),

        REGIONNORD("Region Nord", ""),

        REGIONMITTE("Region Mitte", ""),

        REGIONSUED("Region Süd", ""),

        RAHMENVERTRAEGE("Rahmenverträge", ""),

        ;
        private final String valueString;
        private final String optgroup;

        KundenregionEnumItems(String valueString, String optgroup)
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

    } // end enum

    public enum TeilprojektGewinnenEnumItems implements SimpleGroupedMenuItems{
        BITTEAUSWAEHLEN("(Bitte auswählen)", ""),

        AUFBAURENEWALTEAM("Aufbau Renewal Team", ""),

        COMPLEXDEALMANAGER("Complex Deal Manager", ""),

        E2EFSPIMLSEGMENT("E2E / FSP im L-Segment", ""),

        JEDERWIRDSELLER("Jeder wird Seller", ""),

        NEUGESCHAEFTBEIBESTANDSKUNDENCLAIMMANAGEMENT("Neugeschäft bei Bestandskunden / Claimmanagement", ""),

        KMUSOLUTIONS("KMU@Solutions", ""),

        PUSHFUTUREMOBILITY("Push Future Mobility", ""),

        PUSHHUAWEI("Push Huawei", ""),

        PUSHIOTBUSINESSCONTINUITYSOLUTIONS("Push IoT / Business Continuity Solutions", ""),

        PUSHMITTELSTAND("Push Mittelstand", ""),

        PUSHVPN("Push VPN", ""),

        TDGTOECHTER("TDG Töchter", ""),

        VERLAENGERUNGBESTANDSVERTRAEGE("Verlängerung Bestandsverträge", ""),

        VERMARKTUNGVONISPLEISTUNGENUEBERCOMMERCIALMANAGEMENTPIM("Vermarktung von ISP Leistungen über Commercial Management (PIM)", ""),

        VERBANDSARBEIT("Verbandsarbeit", ""),

        VERMEIDUNGVONFREMDVERGABE("Vermeidung von Fremdvergabe", ""),

        VORLEISTUNGENSGRKLADENTHEKE("Vorleistungen SGrK / Ladentheke", ""),

        SONSTIGESNEUGESCHAEFT("sonstiges Neugeschäft", ""),

        ;
        private final String valueString;
        private final String optgroup;

        TeilprojektGewinnenEnumItems(String valueString, String optgroup)
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

    }// end enum

    public enum PortfolioElementType implements SimpleGroupedMenuItems
    {
        BITTEAUSWAEHLEN("(Bitte auswahlen)", ""),

        DATADRIVENSERVICES("Data-driven Services Übergreifend", ""),

        DIGITALIZATIONSERVICES("Digitization Services Übergreifend", ""),

        SERVERSTORAGEVIRTUALIZATION("Server, Storage & Virtualization Übergreifend", ""),

        CLOUDSUPPORTSERVICES("Cloud Support Services Übergreifend", ""),

        NETWORKINGINHOUSESERVICES("Networking & Inhouse Services Übergreifend", ""),

        USSSERVICES("UCC Übergreifend", ""),

        VPNSERVICES("VPN Übergreifend", ""),

        CLASSICWORKPLACEPRINTSERVICES("Classic Workplace & Print Services Übergreifend", ""),

        MANAGEDDESKTOPSOLUTIONS("Managed Desktop Solutions Übergreifend", ""),

        MANAGEDMOBILESOLUTIONS("Managed Mobile Solutions Übergreifend", ""),

        ENDUSERSUPPORTSERVICESCOMPUTERHILFE("End User Support Services Übergreifend", ""),

        PAYMENTSERVICES("Payment Services", ""),

        EMOBILITYSERVICES("E-Mobility Services", ""),

        DIGITALREALITY("Digital Reality", ""),

        BUSINESSCONTINUITY("Business Continuity", ""),

        INDUSTRIALNETWORK("Industrial Network", ""),

        DIGISCHOOL("Digi@School", ""),

        NETWORKING("Networking", ""),

        ALLIPMIGRATION("All IP Migration", ""),

        WLAN("WLAN", ""),

        SWITCHINGDATENCENTER("Switching, incl. Datacenter", ""),

        ROUTING("Routing", ""),

        CLOUDGEMANAGED("Cloud-gemanaged", ""),

        SOFTWAREDEFINEDNETWORKING("Software Defined Networking", ""),

        MANAGEMENTOPTIMIERUNG("Management + Optimierung", ""),

        USSUNIFY("UCC Unify", ""),

        USSCISCO("UCC Cisco", ""),

        USSALCATEL("UCC Alcatel", ""),

        VPNCONNECT("VPN Connect (TDG)", ""),

        INTRASELECTBRANCHCONNECT("Intraselect Branch Connect (TSI)", ""),

        CLASSICDESKTOPSERVICES("Classic Desktop Services", ""),

        MANAGEDPRINTSERVICES("Managed Print Services", ""),

        FEW("FEW", ""),

        ;
        private String valueString;
        private String optgroup;

        PortfolioElementType(String valueString, String optgroup)
        {
            this.valueString = valueString;
            this.optgroup = optgroup;
        }

        @Override
        public String toSelectString()
        {
            return valueString;
        }

        public String getOptgroupLabel()
        {
            return optgroup;
        }

        public String getStringValue() { return valueString; }

    }// end enum


    public BrowserContext addKlassifizierung(SalesVorhabenData data) {
        FieldInputUtils.select2IfNotNull(page, salesBoost, data.getSalesBoost().toDisplayString());
        FieldInputUtils.select2IfNotNull(page, profitcenter, data.getProfitcenter().toSelectString());
        FieldInputUtils.select2IfNotNull(page, vertriebssegment, data.getVertiebssegment().toSelectString());
        FieldInputUtils.select2IfNotNull(page, kundenregion, data.getKundenregion().toSelectString());
        FieldInputUtils.select2IfNotNull(page, portfolio, data.getPortfolio().toSelectString());
        FieldInputUtils.select2IfNotNull(page, gewinnen, data.getGewinnen().toSelectString());

        return page.context();
    }

    public SalesDashboardStammdatenPage doSpeichern() {
        speichernButton.click();
        return new SalesDashboardStammdatenPage(page);
    }

}
