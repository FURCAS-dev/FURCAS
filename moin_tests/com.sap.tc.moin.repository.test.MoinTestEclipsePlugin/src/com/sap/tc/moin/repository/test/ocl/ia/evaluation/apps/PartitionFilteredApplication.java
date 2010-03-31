package com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.data.EvaluationData;
import com.sap.tc.moin.repository.test.ocl.ia.performance.IAPerformanceGetInstances;

/**
 * This is a naive test application which does not use the Impact Analyzer and
 * hence has to check every constraint for all instances.
 * 
 * @author Thomas Hettel (D039141)
 */
public class PartitionFilteredApplication extends IAApplication {

    private final ImpactAnalyzer ia;

    private final MoinJmiCreator myJmiCreator;

    /**
     * Create a new naive application
     * 
     * @param statements
     * @param packageFinder
     * @param evaluate
     * @throws OclManagerException
     */
    public PartitionFilteredApplication( CoreConnection connection, Set<OclStatement> statements, boolean evaluate ) throws OclManagerException {

        super( connection, statements, evaluate );
        this.ia = new ImpactAnalyzer( true );
        this.myJmiCreator = new JmiCreator( connection, false, this.myTemporaryPartition );
    }

    /**
     * This method will be called by the ChangeEventProvider if a event occurs
     * that is matched by the restered event filter.
     * 
     * @param event the occurred event
     * @see ChangeListener#notify()
     */
    @Override
    public void notify( ChangeEvent event ) {

        // evaluate all statements for all instances
        long instanceTime = 0;
        long evalTime = 0;

        startClock( );
        Set<Classifier> classifiers = new HashSet<Classifier>( );
        Collection<Partitionable> partitionables = connection.getNullPartition( ).getElements( );
        for ( Partitionable partitionable : partitionables ) {
            if ( partitionable instanceof RefObject ) {
                RefObject meta = ( (RefObject) partitionable ).refMetaObject( );
                if ( meta instanceof Classifier ) {
                    classifiers.add( (Classifier) meta );
                }
            }
        }
        // long time = stopClock();
        // System.out.println("Getting the classifiers in the partition " + time + " ns");

        Set<RefFeatured> allInstances = new HashSet<RefFeatured>( );

        startClock( );
        Set<EvaluationUnit> units = this.ia.filterForClasses( classifiers );
        instanceTime += stopClock( );

        for ( EvaluationUnit unit : units ) {

            IAPerformanceGetInstances.LOGGER.trace( MoinSeverity.INFO, "Getting all instances: " + unit.toString( ) );
            startClock( );
            Set<RefObject> stmtInstances = this.evaluator.getAffectedRefObjects( connection, unit );
            // get the time used for evaluating
            instanceTime += stopClock( );
            allInstances.addAll( stmtInstances );
            if ( this.withEvaluation ) {
                // and evaluate for all instances
                startClock( );
                try {
                    this.evaluator.evaluate( connection, unit.getAffectedStatement( ).getExpression( ), stmtInstances );
                } catch ( RuntimeException e ) {
                    System.out.println( "Exception: " + e.getMessage( ) );
                }
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
     * 
     * @see com.sap.tc.moin.events.ChangeListener#notify(com.sap.tc.moin.events.EventChain)
     */
    @Override
    public void notify( @SuppressWarnings( "unused" )
    final EventChain arg0 ) {

        // TODO EventChain is not implmented yet ....

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.rcbne.ocl20.ia.evaluation.apps.IAApplication#initialize()
     */
    @Override
    public void initialize( ) throws Exception {

        this.dataSet.setName( "Partition filtered Application" );
        startClock( );
        this.ia.analyze( this.stmts, this.myJmiCreator );
        long initTime = stopClock( );
        this.dataSet.setInitTime( initTime );
    }

}
