/*
 * Created on 17.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.mql.MQLColumnType;

/**
 * A SelectEntry is a way to refer to an alias or an attribute within the result
 * set computed from the particular alias.
 */
public abstract class SelectEntry {

    abstract public AliasName getTopAlias( );

    abstract public TypeReference getTypeReference( );

    abstract public MQLColumnType getColumnType( );

    abstract public LeafSelectEntry getLeafSelectEntry( );

    abstract public InternalQuery getOwningQuery( );

    /*
     * Pretty-printing
     */
    abstract public String toString( int indent, StringBuilder accumSb );

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }

}
