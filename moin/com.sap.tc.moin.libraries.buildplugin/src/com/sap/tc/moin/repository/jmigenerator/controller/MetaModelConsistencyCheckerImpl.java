package com.sap.tc.moin.repository.jmigenerator.controller;

import java.util.Collection;
import java.util.Set;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;

/**
 * Checks provided meta-model partitions for dangling links. If a dangling link
 * should be found, an error will be reported to the generation callback.
 * 
 * @author D046220
 */
public class MetaModelConsistencyCheckerImpl implements MetaModelCheckerBuild {

    private TimerCallback timerCallback = null;

    private LogCallback logCallback = null;

    private CheckCallback checkCallback = null;

    /**
     * @param aTimerCallback
     * @param aLogCallback
     * @param aCheckCallback
     */
    public MetaModelConsistencyCheckerImpl( TimerCallback aTimerCallback, LogCallback aLogCallback, CheckCallback aCheckCallback ) {

        this.timerCallback = aTimerCallback;
        this.logCallback = aLogCallback;
        this.checkCallback = aCheckCallback;
    }

    public void doCheck( Connection connection, Set<ModelPartition> partitions ) {

        this.logCallback.logInfo( JmiGeneratorTraces.STARTINGCONSISTENCYCHECKS.format( ) );
        this.timerCallback.startTimer( );
        try {
            for ( ModelPartition partition : partitions ) {
                connection.getConsistencyViolationListenerRegistry( ).performConsistencyCheck( partition.getPri( ) );
            }
        } catch ( Throwable t ) {
            this.logCallback.logThrowable( t );
            throw new RuntimeException( t );
        }
        this.timerCallback.endTimer( JmiGeneratorTraces.CONSISTENCYCHECKTIMER.format( ) );
        Collection<ConsistencyViolation> results = connection.getConsistencyViolationListenerRegistry( ).getAllConsistencyViolations( );
        if ( results != null && results.size( ) != 0 ) {
            for ( ConsistencyViolation violation : results ) {
                this.checkCallback.handleViolation( violation, violation.getDescription( connection ) );
            }
        } else {
            this.logCallback.logInfo( JmiGeneratorTraces.NOCONSISTENCYVIOLATIONSFOUND.format( ) );
        }
        this.logCallback.logInfo( JmiGeneratorTraces.CONSISTENCYCHECKSFINISHED.format( ) );
    }
}
