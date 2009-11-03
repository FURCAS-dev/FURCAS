package com.sap.tc.moin.repository.core.consistency.impl;

import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

public class ResolvedConsistencyViolationEvent extends ConsistencyViolationEventImpl {

    protected ConsistencyViolationImpl violation;

    public ResolvedConsistencyViolationEvent( ConsistencyViolationImpl violation, ConsistencyViolationRegistryImpl registry ) {

        super( registry );
        this.violation = violation;
    }

    public ConsistencyViolation getViolation( ) {

        return violation;
    }

    @Override
    public void notifyExternalListeners( ) {

        this.registry.notifyResolvedViolationsExtern( new ConsistencyViolation[] { this.violation } );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Inconsistency notification triggered [{0}]", this.toString( ) ); //$NON-NLS-1$
        }
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof ResolvedConsistencyViolationEvent ) {
            ResolvedConsistencyViolationEvent event = (ResolvedConsistencyViolationEvent) obj;
            return this.violation.equals( event.getViolation( ) );

        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return this.violation.hashCode( );
    }

    @Override
    public String toString( ) {

        return "Resolved violation " + this.violation.getId( ); //$NON-NLS-1$
    }

}
