package com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.data.EvaluationData;

/**
 * @author Thomas Hettel (d039141)
 */
public class ClassScopeApplication extends IAApplication {

    /**
     * the impact analyzer
     */
    private final ImpactAnalyzer ia;

    private final MoinJmiCreator myJmiCreator;

    /**
     * @param statements
     * @param thePkgFinder
     * @param evaulate
     * @throws OclManagerException
     */
    public ClassScopeApplication( CoreConnection connection, Set<OclStatement> statements, boolean evaulate ) throws OclManagerException {

        super( connection, statements, evaulate );
        // create an impact analyzer which does not do instances scope analysis
        this.myJmiCreator = new JmiCreator( connection, false, this.myTemporaryPartition );
        this.ia = new ImpactAnalyzer( true );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.rcbne.ocl20.ia.evaluation.apps.IAApplication#initialize()
     */
    @Override
    public void initialize( ) throws Exception {

        this.dataSet.setName( "Class Scope Analysis" );
        startClock( );
        this.ia.analyze( this.stmts, this.myJmiCreator );
        long initTime = stopClock( );
        this.dataSet.setInitTime( initTime );
    }

    @Override
    public void notify( ChangeEvent event ) {

        long compInstTime = 0;
        long numberOfEvalCalls = 0;
        long evaluationTime = 0;
        long filterTime = 0;
        long numberOfInstances = 0;
        long numberOfStmts = 0;

        if ( event instanceof ModelChangeEvent ) {
            startClock( );

            Set<EvaluationUnit> evalSet = this.ia.filter( myJmiCreator.getConnection( ), (ModelChangeEvent) event );
            filterTime = stopClock( );

            numberOfStmts = evalSet.size( );

            for ( EvaluationUnit eu : evalSet ) {
                // measure time used to compute instances
                Set<RefObject> affectedContextInst;
                startClock( );
                affectedContextInst = this.evaluator.getAffectedRefObjects( connection, eu );
                compInstTime += stopClock( );
                numberOfInstances += affectedContextInst.size( );

                // determine the number of evaluator calls for evaluating the
                // revese paths
                numberOfEvalCalls += determineEvalCalls( eu );

                if ( this.withEvaluation ) {
                    // measure time used to evaluate
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
            data.setNumberOfInstances( numberOfInstances );
            data.setEvent( (ModelChangeEvent) event );
            this.dataSet.addData( data );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.rcbne.ocl20.ia.evaluation.apps.IAApplication#notify(com.sap.tc
     * .moin.events.EventChain)
     */
    @Override
    public void notify( @SuppressWarnings( "unused" ) EventChain arg0 ) {

        // TODO not implemented yet
    }

}
