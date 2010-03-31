package com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.data.EvaluationData;

/**
 * This is a naive test application which does not use the Impact Analyzer and
 * hence has to check every constraint for all instances.
 * 
 * @author Thomas Hettel (D039141)
 */
public class NaiveApplication extends IAApplication {

    /**
     * Create a new naive application
     * 
     * @param statements
     * @param evaluate
     */
    public NaiveApplication( CoreConnection connection, Set<OclStatement> statements, boolean evaluate ) {

        super( connection, statements, evaluate );
    }

    /**
     * This method will be called by the ChangeEventProvider if a event occurs
     * that is matched by the event filter.
     * 
     * @param event the occurred event
     * @see ChangeListener#notify()
     */
    @Override
    public void notify( ChangeEvent event ) {

        // evaluate all statements for all instances
        long instanceTime = 0;
        long evalTime = 0;

        Set<RefObject> allInstances = new HashSet<RefObject>( );


        for ( Iterator<OclStatement> i = this.stmts.iterator( ); i.hasNext( ); ) {
            OclStatement stmt = i.next( );
            // measure the time used for getting all instances
            startClock( );
            Set<RefObject> stmtInstances = this.evaluator.getAllInstances( connection, (Classifier) stmt.getContext( ) );
            // get the time used for evaluating
            instanceTime += stopClock( );
            allInstances.addAll( stmtInstances );
            if ( this.withEvaluation ) {
                // and evaluate for all instances
                startClock( );
                this.evaluator.evaluate( connection, stmt.getExpression( ), stmtInstances );
                evalTime += stopClock( );
            }
        }

        // collect data for evaluation
        EvaluationData data = new EvaluationData( );
        data.setEvent( (ModelChangeEvent) event );
        data.setInstanceComputationTime( instanceTime );
        data.setEvaluationTime( evalTime );
        data.setNumberOfAffectedStmts( this.stmts.size( ) );
        data.setNumberOfInstances( allInstances.size( ) );
        this.dataSet.addData( data );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.events.ChangeListener#notify(com.sap.tc.moin.events.
     * EventChain)
     */
    @Override
    public void notify( @SuppressWarnings( "unused" ) final EventChain arg0 ) {

        // TODO EventChain is not implmented yet ....

    }

    /*
     * (non-Javadoc)
     * @see com.sap.rcbne.ocl20.ia.evaluation.apps.IAApplication#initialize()
     */
    @Override
    public void initialize( ) throws Exception {

        this.dataSet.setName( "Naive Application" );
    }

}
