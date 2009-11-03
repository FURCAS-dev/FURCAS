/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

/**
 * This interface stands for a type reference.
 */
public interface TypeReference {

    String toString( int indent, StringBuilder accumSb );

    AtomicEntry getAtomicEntry( );

    AtomicEntryReference getAtomicEntryReference( );
}
