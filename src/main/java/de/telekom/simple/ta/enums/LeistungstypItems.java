package de.telekom.simple.ta.enums;

public enum LeistungstypItems implements SimpleMenuItems
    {
        NONE
        {
            @Override
            public String toSelectString() { return "-"; }
        },
        CONSULTING
        {
            @Override
            public String toSelectString() { return "Consulting"; }
        },
        PLAN
        {
            @Override
            public String toSelectString() { return "Plan"; }
        },

        BEREITSTELLUNG_INSTALLATION
        {
            @Override
            public String toSelectString() { return "Bereitstellung/Installation"; }

            @Override
            public String toDisplayString() { return "Build - Bereitstellung/Installation"; }
        },

        DEMONTAGE_ENTSORGUNG
        {
            @Override
            public String toSelectString() { return "Demontage/Entsorgung"; }

            @Override
            public String toDisplayString() { return "Build - Demontage/Entsorgung"; }
        },

        PROJEKTMANAGEMENT
        {
            @Override
            public String toSelectString() { return "Projektmanagement"; }

            @Override
            public String toDisplayString() { return "Build - Projektmanagement"; }
        },

        EINWEISUNG_DOKUMENTATION_TRAINING
        {
            @Override
            public String toSelectString() { return "Einweisung/Dokumentation/Training"; }

            @Override
            public String toDisplayString() { return "Build - Einweisung/Dokumentation/Training"; }
        },

        ENTSTOERUNG_SPEZIAL
        {
            @Override
            public String toSelectString() { return "Entstörung < 4 Std. / Spezial"; }

            @Override
            public String toDisplayString() { return "Run - Entstörung < 4 Std. / Spezial"; }
        },

        ENTSTOERUNG_4_STUNDEN
        {
            @Override
            public String toSelectString() { return "Entstörung 4 Std."; }

            @Override
            public String toDisplayString() { return "Run - Entstörung 4 Std."; }
        },

        ENTSTOERUNG_8_STUNDEN
        {
            @Override
            public String toSelectString() { return "Entstörung 8 Std."; }

            @Override
            public String toDisplayString() { return "Run - Entstörung 8 Std."; }
        },

        ENTSTOERUNG_24_STUNDEN
        {
            @Override
            public String toSelectString() { return "Entstörung 24 Std."; }

            @Override
            public String toDisplayString() { return "Run - Entstörung 24 Std."; }
        },

        ENTSTOERUNG_72_STUNDEN
        {
            @Override
            public String toSelectString() { return "Entstörung 72 Std."; }

            @Override
            public String toDisplayString() { return "Run - Entstörung 72 Std."; }
        },

        BETRIEB_UND_PROAKTIVES_MANAGEMENT
        {
            @Override
            public String toSelectString() { return "Betrieb und proaktives Management"; }

            @Override
            public String toDisplayString() { return "Run - Betrieb und proaktives Management"; }
        },

        CHANGE_SUPPORT
        {
            @Override
            public String toSelectString() { return "Change Support"; }

            @Override
            public String toDisplayString() { return "Run - Change Support"; }
        },

        WARTUNG
        {
            @Override
            public String toSelectString() { return "Wartung"; }

            @Override
            public String toDisplayString() { return "Run - Wartung"; }
        },

        INSTANDSETZUNG
        {
            @Override
            public String toSelectString() { return "Instandsetzung"; }

            @Override
            public String toDisplayString() { return "Run - Instandsetzung"; }
        },

        OPTIMIZE
        {
            @Override
            public String toSelectString() { return "Optimize"; }
        }
    }

