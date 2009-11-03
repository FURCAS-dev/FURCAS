package com.sap.tc.moin.repository.jmigenerator.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.checks.ModelElementNameAnalyzer;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Name checker
 */
public class MetaModelNameCheckerImpl implements MetaModelCheckerBuild {

    private TimerCallback timerCallback = null;

    private LogCallback logCallback = null;

    private CheckCallback checkCallback = null;

    /**
     * @param aTimerCallback
     * @param aLogCallback
     * @param aCheckCallback
     */
    public MetaModelNameCheckerImpl( TimerCallback aTimerCallback, LogCallback aLogCallback, CheckCallback aCheckCallback ) {

        this.timerCallback = aTimerCallback;
        this.logCallback = aLogCallback;
        this.checkCallback = aCheckCallback;
    }

    public void doCheck( Connection connection, Set<ModelPartition> originalPartitions ) {

        CoreConnection coreConnection = connection instanceof CoreConnection ? (CoreConnection) connection : ( (Wrapper<CoreConnection>) connection ).unwrap( );
        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
        for ( ModelPartition modelPartition : originalPartitions ) {
            CoreModelPartition corePartition = null;
            if ( modelPartition instanceof CoreModelPartition ) {
                corePartition = (CoreModelPartition) modelPartition;
            } else {
                corePartition = ( (Wrapper<CoreModelPartition>) modelPartition ).unwrap( );
            }
            partitions.add( corePartition );
        }
        this.logCallback.logInfo( JmiGeneratorTraces.STARTINGNAMECHECKS.format( ) );
        this.timerCallback.startTimer( );
        Set<PRI> pris = new HashSet<PRI>( partitions.size( ) );
        for ( ModelPartition partition : partitions ) {
            pris.add( partition.getPri( ) );
        }
        for ( ModelPartition partition : partitions ) {
            Collection<Partitionable> elements = partition.getElements( );
            for ( Partitionable element : elements ) {
                if ( !( element instanceof ModelElement ) ) {
                    continue;
                }
                ModelElement modelElement = (ModelElement) element;
                NameViolation nameViolation = null;
                // check name correctness
                nameViolation = ModelElementNameAnalyzer.analyzeModelElementNameCorrectness( connection, modelElement );
                if ( nameViolation != null ) {
                    this.checkCallback.handleViolation( nameViolation, nameViolation.getDescription( ) );
                }
                if ( modelElement instanceof EnumerationType ) {
                    nameViolation = ModelElementNameAnalyzer.analyzeEnumerationLabelNameCorrectness( connection, (EnumerationType) modelElement );
                    if ( nameViolation != null ) {
                        this.checkCallback.handleViolation( nameViolation, nameViolation.getDescription( ) );
                    }
                }
                // check name uniqueness
                // note that the container is an optional reference
                Namespace namespace = ( (ModelElementInternal) modelElement ).getContainer( coreConnection );
                if ( namespace != null ) {
                    nameViolation = ModelElementNameAnalyzer.analyzeModelElementNameUniquenessInNamespace( connection, namespace, modelElement, null );
                    if ( nameViolation != null ) {
                        this.checkCallback.handleViolation( nameViolation, nameViolation.getDescription( ) );
                    }
                }
                // additionally check name uniqueness of toplevel packages in their container
                if ( modelElement instanceof MofPackage && namespace == null ) {
                    nameViolation = ModelElementNameAnalyzer.analyzeToplevelPackageNameUniqueness( connection, pris, (MofPackage) modelElement );
                    if ( nameViolation != null ) {
                        this.checkCallback.handleViolation( nameViolation, nameViolation.getDescription( ) );
                    }
                }
            }
        }
        this.timerCallback.endTimer( JmiGeneratorTraces.NAMECHECKTIMER.format( ) );
        this.logCallback.logInfo( JmiGeneratorTraces.NAMECHECKSFINISHED.format( ) );
    }
}
