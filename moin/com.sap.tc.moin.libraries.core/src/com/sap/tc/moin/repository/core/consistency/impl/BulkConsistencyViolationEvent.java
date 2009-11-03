package com.sap.tc.moin.repository.core.consistency.impl;

import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.ConsistencyViolationEvent;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Collection of consistency violation events.
 * 
 * @author d026715
 */
@SuppressWarnings( "nls" )
public class BulkConsistencyViolationEvent extends ConsistencyViolationEventImpl {

    private final ConsistencyViolationBuffer violations;

    public BulkConsistencyViolationEvent( ConsistencyViolationRegistryImpl registry, ConsistencyViolationBuffer violations ) {

        super( registry );
        this.violations = violations;
    }

    @Override
    public void notifyExternalListeners( ) {

        // notify new violations
        if ( this.violations.containsNewViolations( ) ) {
            ConsistencyViolation[] newViolationEvents = new ConsistencyViolation[this.violations.getBufferedNewViolations( ).size( )];
            this.violations.getBufferedNewViolations( ).values( ).toArray( newViolationEvents );

            this.registry.notifyNewViolationsExtern( newViolationEvents );
        }

        if ( this.violations.containsResolvedViolations( ) ) {
            // notify resolved violations
            ConsistencyViolation[] resolvedViolationEvents = new ConsistencyViolation[this.violations.getBufferedResolvedViolations( ).size( )];
            this.violations.getBufferedResolvedViolations( ).values( ).toArray( resolvedViolationEvents );

            this.registry.notifyResolvedViolationsExtern( resolvedViolationEvents );
        }

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Inconsistency notification triggered [{0}]", this.toString( ) );
        }
    }

    public void addViolationEvent( ConsistencyViolationEvent event ) {

        if ( event instanceof BulkConsistencyViolationEvent ) {
            this.addOtherBulkEvent( (BulkConsistencyViolationEvent) event );
        } else if ( event instanceof NewConsistencyViolationEvent ) {
            this.violations.addNewViolation( ( (NewConsistencyViolationEvent) event ).getViolation( ) );
        } else if ( event instanceof ResolvedConsistencyViolationEvent ) {
            this.violations.addResolvedViolation( ( (ResolvedConsistencyViolationEvent) event ).getViolation( ) );
        }
    }

    private void addOtherBulkEvent( BulkConsistencyViolationEvent event ) {

        this.violations.addOtherViolationBuffer( event.getViolationBuffer( ) );
    }

    private ConsistencyViolationBuffer getViolationBuffer( ) {

        return this.violations;
    }

    public boolean isEmpty( ) {

        return this.getViolationBuffer( ).isEmpty( );
    }

    @Override
    public String toString( ) {

        return "Bulk notification message: " + this.violations.getBufferedNewViolations( ).size( ) + " new, " + this.violations.getBufferedResolvedViolations( ).size( ) + " resolved. ";
    }

}
