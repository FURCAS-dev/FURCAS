/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * In an MQL query, a select-entry defines what alias or alias-feature should be
 * returned as a column in an {@link MQLResultSet}.
 */
abstract public class SelectEntry extends MQLElement {

    /*
     * All select entries refer to an alias name defined in a from clause
     */
    protected String aliasName;

    /**
     * Return the alias name where this select-entry is referring to.
     * 
     * @return the alias name of the selection
     */
    public String getAliasName( ) {

        return this.aliasName;
    }

    protected abstract void toString( StringBuilder sb, int ident );
}
