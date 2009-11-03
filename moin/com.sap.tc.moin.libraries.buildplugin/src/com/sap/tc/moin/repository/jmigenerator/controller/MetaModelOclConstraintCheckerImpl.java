package com.sap.tc.moin.repository.jmigenerator.controller;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.mof.OclMofConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;

/**
 * MM Constraint check
 */
public class MetaModelOclConstraintCheckerImpl implements MetaModelCheckerBuild {

    private TimerCallback timerCallback = null;

    private LogCallback logCallback = null;

    private CheckCallback checkCallback = null;

    /**
     * @param aTimerCallback
     * @param aLogCallback
     * @param aCheckCallback
     */
    public MetaModelOclConstraintCheckerImpl( TimerCallback aTimerCallback, LogCallback aLogCallback, CheckCallback aCheckCallback ) {

        this.timerCallback = aTimerCallback;
        this.logCallback = aLogCallback;
        this.checkCallback = aCheckCallback;
    }

    public void doCheck( Connection connection, Set<ModelPartition> partitions ) {

        this.logCallback.logInfo( JmiGeneratorTraces.STARTINGOCLCONSTRAINTCHECKS.format( ) );
        Set<PRI> checkPartitions = new HashSet<PRI>( );
        for ( ModelPartition partition : partitions ) {
            checkPartitions.add( partition.getPri( ) );
        }
        DeferredConstraintViolationStatus checkResult = null;
        OclRegistryService oclRegistryService = connection.getOclRegistryService( );
        if ( oclRegistryService != null ) {
            OclMofConstraintRegistry mofConstraintsRegisty;
            try {
                mofConstraintsRegisty = oclRegistryService.getMofConstraintRegistry( );
            } catch ( OclManagerException e ) {
                this.logCallback.logThrowable( e );
                throw new MoinLocalizedBaseRuntimeException( e );
            }
            if ( mofConstraintsRegisty != null ) {
                this.timerCallback.startTimer( );
                try {
                    checkResult = oclRegistryService.getMofConstraintRegistry( ).analyzeMetamodelPartitions( checkPartitions, OclRegistrationCategory.deferred, OclRegistrationCategory.immediate );
                } catch ( Throwable t ) {
                    this.logCallback.logThrowable( t );
                    throw new RuntimeException( t );
                }
                this.timerCallback.endTimer( JmiGeneratorTraces.OCLCONSTRAINTCHECKTIMER.format( ) );
                List<DeferredConstraintViolationStatusItem> results = checkResult.getAll( );
                if ( results != null && results.size( ) != 0 ) {
                    MessageFormat format;
                    for ( DeferredConstraintViolationStatusItem item : results ) {
                        RefBaseObject violatingObject = connection.getElement( item.getOffendingMRI( ) );
                        String message;
                        if ( violatingObject instanceof ModelElement ) {
                            format = new MessageFormat( JmiGeneratorTraces.MEVIOLATIONMESSAGEPATTERN.format( ) );
                            message = format.format( new Object[] { item.getConstraintViolationMessage( ), ( (ModelElement) violatingObject ).getQualifiedName( ).toString( ), item.getOffendingMRI( ).getMofId( ) } );
                        } else {
                            format = new MessageFormat( JmiGeneratorTraces.VIOLATIONMESSAGEPATTERN.format( ) );
                            message = format.format( new Object[] { item.getConstraintViolationMessage( ), item.getOffendingMRI( ).getMofId( ) } );
                        }
                        this.checkCallback.handleViolation( item, message );
                    }
                } else {
                    this.logCallback.logInfo( JmiGeneratorTraces.NOCONSTRAINTVIOLATIONSFOUND.format( ) );
                }
            } else {
                this.logCallback.logWarn( JmiGeneratorTraces.MOFCONSTRAINTREGISTRYNOTFOUND.format( ) );
            }
        } else {
            this.logCallback.logWarn( JmiGeneratorTraces.OCLREGISTRYSERVICENOTFOUND.format( ) );
        }
        this.logCallback.logInfo( JmiGeneratorTraces.OCLCONSTRAINTCHECKSFINISHED.format( ) );
    }
}
