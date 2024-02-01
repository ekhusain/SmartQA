package org.example.base;

public interface SimpleMenuItems {
    /**
     * Get the string which can be selected in menu or selection list
     *
     * @return
     */
    String toSelectString();

    /**
     * Get the string which is displayed in display forms and pages
     *
     * @return
     */
    default String toDisplayString()
    {
        return this.toSelectString();
    }
}
