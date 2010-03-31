package com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps;

import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.ocl.service.impl.EvaluationHelper;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.data.EvaluationDataSet;

/**
 * This is a test application that uses the IA to guide evaluation of the OCL
 * expression in which it is interested in.
 * 
 * @author Thomas Hettel (D039141)
 */
public abstract class IAApplication implements ChangeListener {

    /**
     * a set of OclStatements this application is interested in
     */
    Set<OclStatement> stmts;

    final EvaluationDataSet dataSet = new EvaluationDataSet( );

    final EvaluationHelper evaluator;

    final boolean withEvaluation;

    private long startTimeNano = 0;

    protected final ModelPartition myTemporaryPartition;

    protected final CoreConnection connection;

    /**
     * Creates a new IAApplication
     * 
     * @param statements The set of OclStatements in which this application is
     * interested
     * @param evaluate
     */
    public IAApplication( CoreConnection connection, Set<OclStatement> statements, boolean evaluate ) {

        super( );
        this.stmts = statements;
        this.evaluator = new EvaluationHelper( );
        this.withEvaluation = evaluate;
        this.myTemporaryPartition = connection.getOrCreateTransientPartitionNonTransactional( "OclTransientPartition" );
        this.connection = connection;
    }

    /**
     * @throws Exception
     */
    public abstract void initialize( ) throws Exception;

    /**
     * This method will be called by the ChangeEventProvider if a event occurs
     * that is matched by the restered event filter.
     * 
     * @param event the occurred event
     * @see ChangeListener#notify(ChangeEvent)
     */
    public abstract void notify( ChangeEvent event );

    /**
     * similar to {@link ChangeListener#notify(ChangeEvent)}
     * 
     * @param eventChain the event chain
     */
    public abstract void notify( EventChain eventChain );

    /**
     * @return the data evaluation set
     */
    public EvaluationDataSet getEvaluationDataSet( ) {

        return this.dataSet;
    }

    /**
     * Starts measuring time
     */
    protected void startClock( ) {

        this.startTimeNano = System.nanoTime( );
    }

    /**
     * Stops measuring time (nanoseconds)
     * 
     * @return returns the time passed between startClock() and the call of this
     * method
     */
    protected long stopClock( ) {

        return System.nanoTime( ) - this.startTimeNano;
    }

    /**
     * Determines the number of evaluator calles needed to evaluate the reverse
     * pathes in EvaluationUnit eu.
     * 
     * @param eu
     * @return number of evaluator calls
     */
    protected long determineEvalCalls( EvaluationUnit eu ) {

        int calls = 0;
        for ( Iterator<InstanceSet> i = eu.getInstanceSets( ).iterator( ); i.hasNext( ); ) {
            InstanceSet is = i.next( );
            calls += is.getStartingPoints( ).size( );
        }
        return calls;
    }

}
