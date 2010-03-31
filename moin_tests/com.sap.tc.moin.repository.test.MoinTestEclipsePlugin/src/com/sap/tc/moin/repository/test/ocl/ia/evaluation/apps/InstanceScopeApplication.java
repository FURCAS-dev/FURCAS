package com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps;

import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclSerializationException;
import com.sap.tc.moin.ocl.utils.impl.OclSerializer;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.data.EvaluationData;
import com.sap.tc.moin.repository.test.ocl.ia.performance.IAPerformanceGetInstances;

/**
 * Instance scope application
 */
public class InstanceScopeApplication extends IAApplication {

    /**
     * the impact analyzer
     */
    private final ImpactAnalyzer ia;

    private final MoinJmiCreator myJmiCreator;

    /**
     * @param statements
     * @param packageFinder
     * @param evaluate
     * @throws OclManagerException
     */
    public InstanceScopeApplication( CoreConnection connection, Set<OclStatement> statements, boolean evaluate ) throws OclManagerException {

        super( connection, statements, evaluate );
        // create an impact analyzer which does instances scope analysis
        this.ia = new ImpactAnalyzer( false );
        this.myJmiCreator = new JmiCreator( connection, false, this.myTemporaryPartition );
    }

    @Override
    public void initialize( ) throws Exception {

        this.dataSet.setName( "Instance Scope Analysis" );
        startClock( );
        this.ia.analyze( this.stmts, this.myJmiCreator );
        long initTime = stopClock( );
        this.dataSet.setInitTime( initTime );
    }

    @Override
    public void notify( ChangeEvent event ) {

        long compInstTime = 0;
        long evaluationTime = 0;
        long filterTime = 0;
        long numberOfEvalCalls = 0;
        long numberOfStmts = 0;

        if ( event instanceof ModelChangeEvent ) {

            startClock( );
            Set<EvaluationUnit> evalSet = filter( myJmiCreator.getConnection( ), event );
            filterTime = stopClock( );

            numberOfStmts = evalSet.size( );
            for ( Iterator<EvaluationUnit> i = evalSet.iterator( ); i.hasNext( ); ) {
                EvaluationUnit eu = i.next( );
                printEvaluationUnit( eu );
                // measure time used to compute instances
                startClock( );
                Set<RefObject> affectedContextInst = this.evaluator.getAffectedRefObjects( connection, eu );
                compInstTime += stopClock( );

                numberOfEvalCalls += affectedContextInst.size( );
                // measure time used to evaluate
                if ( this.withEvaluation ) {
                    startClock( );
                    this.evaluator.evaluate( connection, eu.getAffectedStatement( ).getExpression( ), affectedContextInst );
                    evaluationTime += stopClock( );
                }
            }

            // collect data for evaluation
            EvaluationData data = new EvaluationData( );
            data.setEvaluationTime( evaluationTime );
            data.setInstanceComputationTime( compInstTime );
            data.setFilterTime( filterTime );
            data.setNumberOfAffectedStmts( numberOfStmts );
            data.setNumberOfInstances( numberOfEvalCalls );
            data.setEvent( (ModelChangeEvent) event );
            this.dataSet.addData( data );
        }
    }

    /**
     * @param event
     * @return the evaluation set
     */
    private Set<EvaluationUnit> filter( CoreConnection connection, ChangeEvent event ) {

        return this.ia.filter( connection, (ModelChangeEvent) event );
    }

    @Override
    public void notify( @SuppressWarnings( "unused" ) EventChain arg0 ) {

        // TODO not implemented yet
    }

    private void printEvaluationUnit( EvaluationUnit unit ) {

        if ( IAPerformanceGetInstances.LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            OclSerializer ocl2txt = com.sap.tc.moin.ocl.utils.impl.OclSerializer.getInstance( connection );
            IAPerformanceGetInstances.LOGGER.trace( MoinSeverity.DEBUG, "Affected Stmt:" );
            try {
                IAPerformanceGetInstances.LOGGER.trace( MoinSeverity.DEBUG, ocl2txt.serialize( unit.getAffectedStatement( ) ) );
            } catch ( OclSerializationException e ) {
                IAPerformanceGetInstances.LOGGER.trace( e, MoinSeverity.ERROR, "Exception serializing  the statement" );
            }

            for ( Iterator<InstanceSet> j = unit.getInstanceSets( ).iterator( ); j.hasNext( ); ) {
                InstanceSet iSet = j.next( );
                IAPerformanceGetInstances.LOGGER.trace( MoinSeverity.DEBUG, "Instances:" );
                for ( Iterator<RefObject> it = iSet.getStartingPoints( ).iterator( ); it.hasNext( ); ) {
                    RefObject inst = it.next( );
                    System.out.println( "    " + inst + "" );
                }
                try {
                    IAPerformanceGetInstances.LOGGER.trace( MoinSeverity.DEBUG, ocl2txt.serialize( iSet.getNavigationStatement( ) ) );
                } catch ( OclSerializationException e ) {
                    IAPerformanceGetInstances.LOGGER.trace( e, MoinSeverity.ERROR, "Exception serializing  the statement" );
                }

            }
        }
    }
}
