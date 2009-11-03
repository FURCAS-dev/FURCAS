/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

/**
 * A FromEntry is the abstraction of entries that can appear in the From-Clause.
 * Their main characteristic is that they define a set of model elements on
 * which additional constraints can be formulated. The alias name is a symbolic
 * reference for a FromEntry. However, internally, the references are based on
 * true pointers. The former is for documentational purposes, e.g. in logging.
 */
abstract public class FromEntry {

    protected AliasName aliasName;

    public AliasName getAliasName( ) {

        return this.aliasName;
    }

    /**
     * The identity of a from-entry is based on that of its alias name, not its
     * Java pointer
     */
    @Override
    public boolean equals( Object otherReference ) {

        if ( this == otherReference ) {
            return true;
        }

        boolean result = otherReference instanceof FromEntry;
        if ( result ) {
            FromEntry otherFromEntry = (FromEntry) otherReference;
            result = this.aliasName.equals( otherFromEntry.aliasName );
        }
        return result;
    }


    /**
     * The identity of a from-entry is based on that of its alias name, not its
     * Java pointer
     */
    @Override
    public int hashCode( ) {

        return this.aliasName.hashCode( );
    }

}
