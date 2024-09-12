package de.telekom.simple.ta.testdata.common;

public enum SimpleUserRole
{
    SALES_SERVICE_CONSULTANT_STANDARD
    {
        @Override
        public String toString()
        {
            return "Sales - Service Consultant - Standard";
        }
    },
    SALES_SERVICE_CONSULTANT_MASTER
    {
        @Override
        public String toString()
        {
            return "Sales - Service Consultant - Master";
        }
    },
    SALES_EINGANGSTOR_CCS_AM_PB
    {
        @Override
        public String toString()
        {
            return "Sales - Eingangstor CCS AM - PB";
        }
    },
    SALES_ANGEBOTSERSTELLER
    {
        @Override
        public String toString()
        {
            return "Sales - Angebotsersteller";
        }
    },
    OFFER_ENTRY_GATE_KVM_PB
    {
        @Override
        public String toString()
        {
            return "Offer - Entry Gate KVM - PB";
        }
    },
    CCF_PSP_MAINTENANCE
    {
        @Override
        public String toString()
        {
            return "CCF - PSP Maintenance";
        }
    },
    CCF_CBI_MAINTENANCE {
        @Override
        public String toString() {
            return "CCF - CBI Maintenance";
        }
    },
    OFFER_AUFTRAGSMANAGEMENT_SCHREIBEN_ERWEITERT_FC
    {
        @Override
        public String toString()
        {
            return "Offer - Auftragsmanagement - Schreiben/Erweitert/FC";
        }
    },
    OFFER_AUFTRAGSMANAGEMENT_SCHREIBEN
    {
        @Override
        public String toString()
        {
            return "Offer - Auftragsmanagement - Schreiben";
        }
    },
    OFFER_AUFTRAGSMANAGEMENT_LESEN
    {
        @Override
        public String toString()
        {
            return "Offer - Auftragsmanagement - Lesen";
        }
    },
    OFFER_AUFTRAGSMANAGEMENT_SCHREIBEN_ERWEITERT
    {
        @Override
        public String toString()
        {
            return "Offer - Auftragsmanagement - Schreiben/Erweitert";
        }
    },
    OFFER_AUFTRAGSMANAGEMENT_LESEN_ERWEITERT
    {
        @Override
        public String toString()
        {
            return "Offer - Auftragsmanagement - Lesen/Erweitert";
        }
    },
    OFFER_AUFTRAGSMANAGEMENT_LESEN_ERWEITERT_PB
    {
        @Override
        public String toString()
        {
            return "Offer - Auftragsmanagement - Lesen/Erweitert/PB";
        }
    },
    PROJECTS_PROJEKTBEZOGEN_STANDARD
    {
        @Override
        public String toString()
        {
            return "Projects - Projektbezogen - Standard";
        }
    },
    PROJECTS_PROJEKTUEBERGREIFEND_MPM
    {
        @Override
        public String toString()
        {
            return "Projects - Projektübergreifend - MPM";
        }
    },
    RM_STANDARD
    {
        @Override
        public String toString()
        {
            return "RM - Standard";
        }
    },
    ADMIN_KLASSIFIZIERUNG_STANDARD_ADMIN
    {
        @Override
        public String toString()
        {
            return "Admin - Admin-Klassifizierung - Standard";
        }
    },
    ADMIN_KATALOG_ADMIN
    {
        @Override
        public String toString()
        {
            return "Admin - Katalog-Admin";
        }
    },
    ADMIN_KLASSIFIZIERUNG_FC_ADMIN
    {
        @Override
        public String toString()
        {
            return "Admin - Admin-Klassifizierung-FC - FC";
        }
    },
    ADMINISTRATOR
    {
        @Override
        public String toString()
        {
            return "Administrator";
        }
    }
}
