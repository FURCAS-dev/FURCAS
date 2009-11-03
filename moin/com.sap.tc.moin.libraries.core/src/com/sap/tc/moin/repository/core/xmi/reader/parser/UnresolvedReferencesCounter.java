package com.sap.tc.moin.repository.core.xmi.reader.parser;

/**
 * Interface for incrementing / decreasing the number of unresolved XMI references.
 */
public interface UnresolvedReferencesCounter {

    /**
     * Increments the counter for the number of unresolved references.
     */
    public void increaseUnresolvedRefs( );

    /**
     * Decrements the counter for the number of unresolved references.
     */
    public void decreaseUnresolvedRefs( );
}