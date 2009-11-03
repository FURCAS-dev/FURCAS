package com.sap.tc.moin.repository.mql;

/**
 * A where-entry allows to constraint one or more aliases defined in a
 * from-entry.
 */
public abstract class WhereEntry extends MQLElement {

    /*
     * The alias name to which the where condition refers to.
     */
    protected String leftAlias;

    /**
     * Obtain the alias name to which this where entry refers.
     * 
     * @return the alias name to which this where entry refers.
     */
    public String getLeftAlias( ) {

        return this.leftAlias;
    }

    abstract protected void toString( StringBuilder sb, int indent );

}
