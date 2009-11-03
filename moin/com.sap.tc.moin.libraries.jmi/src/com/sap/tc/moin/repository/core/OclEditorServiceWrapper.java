package com.sap.tc.moin.repository.core;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.omg.ocl.attaching.OclConstraint;

import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.friends.ocl.editor.IncrementalProcessReport;
import com.sap.tc.moin.friends.ocl.editor.OclEditorService;
import com.sap.tc.moin.friends.ocl.editor.RegionWrappedMRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.spi.core.Wrapper;


/**
 * The {@link OclEditorService} wrapper
 */
public class OclEditorServiceWrapper extends AbstractConnectionAwareWrapper<CoreOclEditorService> implements OclEditorService {

    private final CoreOclEditorService oclEditorService;

    /**
     * @param editorService the {@link CoreOclEditorService}
     * @param actConnection the connection
     */
    public OclEditorServiceWrapper( CoreOclEditorService editorService, CoreConnection actConnection ) {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclEditorService = editorService;
    }

    public CoreOclEditorService unwrap( ) {

        return this.oclEditorService;
    }

    public List<IOclProposal> computeProposals( OclConstraint oc, String constraint, int offset, Set<ModelPartition> partitions ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            this.synchronizationManager.acquireMicroWriteLock( );
            try {
                attachConnectionIfRequired( );
                OclConstraint oclConstraintInt = ( (Wrapper<OclConstraint>) oc ).unwrap( );
                Set<CoreModelPartition> corePartitions = new HashSet<CoreModelPartition>( partitions.size( ) );
                for ( ModelPartition modelPartition : partitions ) {
                    corePartitions.add( (CoreModelPartition) ( (Wrapper) modelPartition ).unwrap( ) );
                }
                return this.oclEditorService.computeProposals( this.connection, corePartitions, oclConstraintInt, constraint, offset );

            } finally {
                this.synchronizationManager.releaseMicroWriteLock( );
            }
        }
    }

    public ProcessReport parseOclConstraint( OclConstraint oc, String constraint, Set<ModelPartition> partitions ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            this.synchronizationManager.acquireMicroWriteLock( );
            try {
                attachConnectionIfRequired( );
                OclConstraint oclConstraintInt = ( (Wrapper<OclConstraint>) oc ).unwrap( );
                Set<CoreModelPartition> corePartitions = new HashSet<CoreModelPartition>( partitions.size( ) );
                for ( ModelPartition modelPartition : partitions ) {
                    corePartitions.add( (CoreModelPartition) ( (Wrapper) modelPartition ).unwrap( ) );
                }
                return this.oclEditorService.parseOclConstraints( this.connection, corePartitions, oclConstraintInt, constraint );

            } catch ( IllegalStateException e ) {
                e.printStackTrace( );
                return null;
            } finally {
                this.synchronizationManager.releaseMicroWriteLock( );
            }
        }
    }

    public String format( String constraint ) {

        return this.oclEditorService.format( constraint );
    }

    public String getInformationAtOffset( OclConstraint oc, String constraint, int offset, Set<ModelPartition> partitions, Locale locale ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            this.synchronizationManager.acquireMicroWriteLock( );
            try {
                attachConnectionIfRequired( );
                OclConstraint oclConstraintInt = ( (Wrapper<OclConstraint>) oc ).unwrap( );
                Set<CoreModelPartition> corePartitions = new HashSet<CoreModelPartition>( partitions.size( ) );
                for ( ModelPartition modelPartition : partitions ) {
                    corePartitions.add( (CoreModelPartition) ( (Wrapper) modelPartition ).unwrap( ) );
                }
                return this.oclEditorService.getInformationAtOffset( this.connection, corePartitions, oclConstraintInt, constraint, offset, locale );

            } finally {
                this.synchronizationManager.releaseMicroWriteLock( );
            }
        }
    }

    public RegionWrappedMRI getMRIAtOffset( OclConstraint oc, String constraint, int offset, Set<ModelPartition> partitions ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            this.synchronizationManager.acquireMicroWriteLock( );
            try {
                attachConnectionIfRequired( );
                OclConstraint oclConstraintInt = ( (Wrapper<OclConstraint>) oc ).unwrap( );
                Set<CoreModelPartition> corePartitions = new HashSet<CoreModelPartition>( partitions.size( ) );
                for ( ModelPartition modelPartition : partitions ) {
                    corePartitions.add( (CoreModelPartition) ( (Wrapper) modelPartition ).unwrap( ) );
                }
                return this.oclEditorService.getMRIAtOffset( this.connection, corePartitions, oclConstraintInt, constraint, offset );

            } finally {
                this.synchronizationManager.releaseMicroWriteLock( );
            }
        }
    }

    public IncrementalProcessReport parseOclConstraint( OclConstraint oc, String constraint, Set<ModelPartition> partitions, int offset, int length, boolean isRemove ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            this.synchronizationManager.acquireMicroWriteLock( );
            try {
                attachConnectionIfRequired( );
                OclConstraint oclConstraintInt = ( (Wrapper<OclConstraint>) oc ).unwrap( );
                Set<CoreModelPartition> corePartitions = new HashSet<CoreModelPartition>( partitions.size( ) );
                for ( ModelPartition modelPartition : partitions ) {
                    corePartitions.add( (CoreModelPartition) ( (Wrapper) modelPartition ).unwrap( ) );
                }
                return this.oclEditorService.parseOclConstraints( this.connection, corePartitions, oclConstraintInt, constraint, offset, length, isRemove );

            } catch ( IllegalStateException e ) {
                e.printStackTrace( );
                return null;
            } finally {
                this.synchronizationManager.releaseMicroWriteLock( );
            }
        }
    }

    public List<IOclProposal> computeErrorFix( OclConstraint oc, String constraint, int errorOffset, int errorLength, Set<ModelPartition> partitions ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            this.synchronizationManager.acquireMicroWriteLock( );
            try {
                attachConnectionIfRequired( );
                OclConstraint oclConstraintInt = ( (Wrapper<OclConstraint>) oc ).unwrap( );
                Set<CoreModelPartition> corePartitions = new HashSet<CoreModelPartition>( partitions.size( ) );
                for ( ModelPartition modelPartition : partitions ) {
                    corePartitions.add( (CoreModelPartition) ( (Wrapper) modelPartition ).unwrap( ) );

                }
                return this.oclEditorService.computeErrorFix( this.connection, corePartitions, oclConstraintInt, constraint, errorOffset, errorLength );

            } catch ( IllegalStateException e ) {
                e.printStackTrace( );
                return null;
            } finally {
                this.synchronizationManager.releaseMicroWriteLock( );
            }
        }

    }
}
