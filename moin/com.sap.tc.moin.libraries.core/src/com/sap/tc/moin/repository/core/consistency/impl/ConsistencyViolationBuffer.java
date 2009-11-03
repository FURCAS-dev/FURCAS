package com.sap.tc.moin.repository.core.consistency.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.ConsistencyViolationEvent;

/**
 * Collects all new and resolved consistency violations. It also merges the new
 * with the resolved violations meaning that those violations that are resolved
 * are removed from the table of new violations.
 * 
 * @author d026715
 */
public class ConsistencyViolationBuffer {

    private Map<String, ConsistencyViolation> bufferedNewViolations = null;

    private Map<String, ConsistencyViolation> bufferedResolvedViolations = null;

    public void addNewViolation( ConsistencyViolation violation ) {

        if ( this.containsResolvedViolations( ) && ( this.getBufferedResolvedViolations( ).containsKey( violation.getId( ) ) ) ) {
            this.getBufferedResolvedViolations( ).remove( violation.getId( ) );
        }
        this.getBufferedNewViolations( ).put( violation.getId( ), violation );
    }

    public void addResolvedViolation( ConsistencyViolation violation ) {

        if ( this.containsNewViolations( ) && ( this.getBufferedNewViolations( ).containsKey( violation.getId( ) ) ) ) {
            this.getBufferedNewViolations( ).remove( violation.getId( ) );
        }
        // Always add resolved violations: new violation are sometimes triggered multiple times
        this.getBufferedResolvedViolations( ).put( violation.getId( ), violation );
    }

    public ConsistencyViolationEvent getBulkViolationEvent( ConsistencyViolationRegistryImpl registry ) {

        if ( !this.isEmpty( ) ) {
            return new BulkConsistencyViolationEvent( registry, this );
        } else {
            return null;
        }
    }

    public boolean isEmpty( ) {

        return ( ( this.bufferedNewViolations == null ) || this.bufferedNewViolations.isEmpty( ) ) && ( ( this.bufferedResolvedViolations == null ) || this.bufferedResolvedViolations.isEmpty( ) );
    }

    public Map<String, ConsistencyViolation> getBufferedNewViolations( ) {

        if ( this.bufferedNewViolations == null ) {
            this.bufferedNewViolations = new LinkedHashMap<String, ConsistencyViolation>( );
        }
        return bufferedNewViolations;
    }

    public Map<String, ConsistencyViolation> getBufferedResolvedViolations( ) {

        if ( this.bufferedResolvedViolations == null ) {
            this.bufferedResolvedViolations = new LinkedHashMap<String, ConsistencyViolation>( );
        }
        return bufferedResolvedViolations;
    }

    public boolean containsNewViolations( ) {

        return ( this.bufferedNewViolations != null ) && ( !this.bufferedNewViolations.isEmpty( ) );
    }

    public boolean containsResolvedViolations( ) {

        return ( this.bufferedResolvedViolations != null ) && ( !this.bufferedResolvedViolations.isEmpty( ) );
    }

    public void addOtherViolationBuffer( ConsistencyViolationBuffer violationBuffer ) {

        if ( violationBuffer.bufferedNewViolations != null ) {
            for ( ConsistencyViolation violation : violationBuffer.bufferedNewViolations.values( ) ) {
                this.addNewViolation( violation );
            }
        }
        if ( violationBuffer.bufferedResolvedViolations != null ) {
            for ( ConsistencyViolation violation : violationBuffer.bufferedResolvedViolations.values( ) ) {
                this.addResolvedViolation( violation );
            }
        }
    }

}
