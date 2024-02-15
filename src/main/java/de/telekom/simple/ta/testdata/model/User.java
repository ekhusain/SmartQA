package de.telekom.simple.ta.testdata.model;

import java.util.HashMap;
import java.util.Map;

/**
 * User model class
 *
 */
public class User
{
    private String benutzername;

    private String passwort;

    private String firstName;

    private String surename;

    private SimpleUserRole role;

    private Integer setNumber;

    private static Map<String, SimpleUserRole> stringRoleMap;

    static
    {
        stringRoleMap = new HashMap<>();
        SimpleUserRole[] valueArray = SimpleUserRole.values();
        for (SimpleUserRole simpleUserRole : valueArray) {
            stringRoleMap.put(simpleUserRole.toString(), simpleUserRole);
        }
    }

    public User()
    {

    }

    public String getBenutzername()
    {
        return benutzername;
    }

    public void setBenutzername(String userName)
    {
        this.benutzername = userName;
    }

    public String getPasswort()
    {
        return passwort;
    }

    public void setPasswort(String password)
    {
        this.passwort = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSurename()
    {
        return surename;
    }

    public void setSurename(String surename)
    {
        this.surename = surename;
    }

    public SimpleUserRole getRole()
    {
        return role;
    }

    public void setRole(SimpleUserRole role)
    {
        this.role = role;
    }

    public void setRole(String roleString)
    {
        this.role = stringRoleMap.get(roleString);
    }

    public Integer getSetNumber()
    {
        return setNumber;
    }

    public void setSetNumber(Integer setNumber)
    {
        this.setNumber = setNumber;
    }
}

