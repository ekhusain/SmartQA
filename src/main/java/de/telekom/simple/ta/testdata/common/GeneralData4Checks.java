package de.telekom.simple.ta.testdata.common;

public class GeneralData4Checks {

    public GeneralData4Checks()
    { }

    public String getDatabaseName()
    {
        return databaseName;
    }
    public void setDatabaseName(String databaseName)
    {
        this.databaseName = databaseName;
    }
    public String getDatabaseServer()
    {
        return databaseServer;
    }
    public void setDatabaseServer(String databaseServer)
    {
        this.databaseServer = databaseServer;
    }

    private String databaseName = null;
    private String databaseServer = null;
}
