package de.telekom.simple.ta.enums;

public interface SimpleMenuItems {
    /**
     * Get the string which can be selected in menu or selection list
     */
    String toSelectString();

    /**
     * Get the string which is displayed in display forms and pages
     */
    default String toDisplayString()
    {
        return this.toSelectString();
    }
}
