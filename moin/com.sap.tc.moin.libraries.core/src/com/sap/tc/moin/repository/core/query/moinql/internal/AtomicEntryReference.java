/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

/**
 * This reference only refers to an atomic entry.
 */
public class AtomicEntryReference implements TypeReference {

    protected AtomicEntry atomicEntry;

    public AtomicEntryReference( AtomicEntry _atomicEntry ) {

        this.atomicEntry = _atomicEntry;
    }

    public AtomicEntry getAtomicEntry( ) {

        return this.atomicEntry;
    }

    public AtomicEntryReference getAtomicEntryReference( ) {

        return this;
    }

    public void setAtomicEntry( AtomicEntry atomicEntry ) {

        this.atomicEntry = atomicEntry;
    }

    /**
     * Redefine identity based on the atomic entry
     */
    @Override
    public boolean equals( Object otherReference ) {

        boolean result = !( otherReference instanceof TypeAttrReference ) && ( otherReference instanceof TypeReference );
        if ( result ) {
            TypeReference otherTypeReference = (TypeReference) otherReference;
            result = getAtomicEntry( ).equals( otherTypeReference.getAtomicEntry( ) );
        }
        return result;
    }

    /**
     * Identity based on atomic entry
     */
    @Override
    public int hashCode( ) {

        return getAtomicEntry( ).hashCode( );
    }

    /*
     * Pretty-printing
     */
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        sb.append( this.atomicEntry.getAliasName( ) );

        accumSb.append( sb );

        return sb.toString( );
    }

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }

}
