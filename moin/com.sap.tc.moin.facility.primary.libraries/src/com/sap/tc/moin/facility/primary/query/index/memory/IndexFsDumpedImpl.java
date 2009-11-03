package com.sap.tc.moin.facility.primary.query.index.memory;

import java.io.File;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;


public class IndexFsDumpedImpl extends IndexAbstractDumpedImpl {

    private final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_INDEX, IndexFsDumpedImpl.class );


    // ######## Life Cycle ################

    /**
     * The life cycle states for DataAreas (DA) are introduced to exclude
     * unsynchronized data from query results. This interface is just a
     * container for Integers that represent the synchronization state of
     * content per DataArea read from index dump.
     * <p>
     * Values are ordinal to allow range operations.
     */
    private static interface DataAreaLCState {

        /**
         * Marks a DataArea as to be removed from the index. A DA becomes
         * candidate for deletion if a new DA is synched into the index that was
         * not in the dump.
         */
        public static final Integer DEL_CANDIDATE = 0;

        /**
         * Initial state for DataAreas read from dump (except metamodel DA).
         * Unused DataAreas are not synchronized yet
         */
        public static final Integer UNUSED = 1;

        /**
         * State of a synchronized DataArea. Standard for MM DataArea.
         */
        public static final Integer USED = 2;

        /**
         * Defines the state level of which the content of a DataArea is removed
         * from the index at sync (see
         * {@link IndexDumpedImpl#updateDataAreasInSync(String)}).
         * <p>
         * DELETE_LEVEL = UNUSED deletes all unsynched DataAreas from index as
         * soon as a new unknown DataArea gets synced.<br>
         * DELETE_LEVEL = DEL_CANDIDATE gives them a second chance
         * <p>
         * The delete level does not influence the DataArea removal during
         * shutdown (see {@link IndexDumpedImpl#updateDataAreasInShutdown()}!
         */
        public static final Integer DELETE_LEVEL = DEL_CANDIDATE;
    }

    /**
     * The life cycle state map for DataAreas.
     */
    protected Map<String, Integer> dataAreaLC = null;

    private DumperThread dumperThread;

    /**
     * File name for the dump
     */
    private final String fnIndexFile;

    /**
     * File name of the dump verification flag. This file is used to verify if
     * the last index dump has been finished. It is deleted before the dump is
     * performed and recreated afterwards.
     */
    private final String fnIndexSignFile;

    /*
     * #######################################################################
     * ####### Constructor Section######
     * #######################################################################
     */
    public IndexFsDumpedImpl( String facilityId, String moinId, ReferenceQueue refQueue, String indexFilePath ) {

        super( facilityId, moinId, refQueue );
        this.fnIndexFile = indexFilePath;
        this.fnIndexSignFile = fnIndexFile + IndexConstants.DUMP_FILE_SIGN_EXT;
    }

    /*
     * #######################################################################
     * ####### Life Cycle Section ######
     * #######################################################################
     */
    @Override
    protected void initializeScenarioSpecific( ) {

        super.initializeScenarioSpecific( );
        this.dumperThread = new DumperThread( this );
    }

    @Override
    protected IndexDumpHandler createDumpHandler( ) {

        return new IndexFsDumpHandler( riFactory, fnIndexFile, this );
    }

    @Override
    protected void resetIndex( ) {

        super.resetIndex( );
        this.dataAreaLC = new IdentityHashMap<String, Integer>( IndexConstants.INITIAL_DA_LC );
    }

    @Override
    public void clear( ) {

        this.deleteIndexFiles( );
        super.clear( );
    }

    @Override
    public void tearDown( ) {

        this.rwLock.writeLock( ).lock( );
        try {
            this.updateDataAreasInShutdown( );
        } finally {
            this.rwLock.writeLock( ).unlock( );
        }

        super.tearDown( );
        this.shutdownThread( );
    }

    private void shutdownThread( ) {

        try {
            this.dumperThread.requestStop( );
            this.dumperThread.join( );

            this.trace( MoinSeverity.DEBUG, IndexFsDumpedConstants.DUMPER_THREAD_ENDING, IndexConstants.DUMPER_THREAD_NAME );
        } catch ( Exception ie ) {
            this.trace( ie, MoinSeverity.WARNING, IndexFsDumpedConstants.ERROR_IN_DUMPER_THREAD_SHUTDOWN );
            this.deleteIndexFiles( );
        }
    }

    private void deleteIndexFiles( ) {

        this.deleteIndexFile( );
        this.deleteIndexSignFile( );
    }

    public void deleteIndexFile( ) {

        File idxFile = new File( this.fnIndexFile );
        if ( idxFile.exists( ) ) {
            boolean result = idxFile.delete( );
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) && result == false ) {
                LOGGER.trace( MoinSeverity.WARNING, IndexFsDumpedConstants.ERROR_DELETE_DUMP, this.fnIndexFile );
            }
        }
    }

    private void deleteIndexSignFile( ) {

        File signFile = new File( this.fnIndexSignFile );
        if ( signFile.exists( ) ) {
            boolean result = signFile.delete( );
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) && result == false ) {
                LOGGER.trace( MoinSeverity.WARNING, IndexFsDumpedConstants.ERROR_DELETE_SIGN_FILE, this.fnIndexSignFile );
            }
        }
    }

    protected boolean isDumpCorrect( ) {

        File signFile = new File( this.fnIndexSignFile );
        if ( signFile.exists( ) ) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean performDump( ) {

        // to ensure correct dump we must delete the sign file
        this.deleteIndexSignFile( );
        boolean result = this.dumpHandler.dump( );
        File signFile = new File( this.fnIndexSignFile );
        try {
            signFile.createNewFile( );
        } catch ( IOException ioe ) {
            throw new RuntimeException( ioe );
        }
        return result;
    }

    @Override
    protected boolean saveIndexInternal( ) {

        boolean result;

        try {
            result = super.saveIndexInternal( );
            if ( !result ) {
                this.trace( MoinSeverity.DEBUG, IndexFsDumpedConstants.COULD_NOT_DUMP_INDEX_TO_FILE, this.fnIndexFile );
            } else {
                this.trace( MoinSeverity.DEBUG, IndexFsDumpedConstants.INDEX_DUMPED, this.fnIndexFile );
            }
        } catch ( Exception e ) {
            // Exceptions are swallowed because failed index dump should not influence other functionality
            this.deleteIndexFiles( );
            result = false;
        }
        return result;
    }

    @Override
    protected boolean performLoad( ) {

        boolean result;

        try {
            if ( this.isDumpCorrect( ) ) { // TODO check might go to dump handler
                if ( this.dumpHandler.load( ) ) {
                    // load successful
                    this.init( );
                    this.dataAreaLC = this.initDataAreaLifeCycleTable( );
                    result = true;
                } else {
                    // load not possible because no dump available
                    this.trace( MoinSeverity.DEBUG, IndexFsDumpedConstants.DUMPFILE_NOT_AVAILABLE, this.fnIndexFile );
                    result = false;
                }
            } else {
                this.trace( MoinSeverity.WARNING, IndexFsDumpedConstants.SIGN_FILE_MISSING );
                result = false;
            }
        } catch ( Exception e ) { // bugs
            this.trace( e, MoinSeverity.DEBUG, IndexFsDumpedConstants.COULD_NOT_LOAD_DUMP_FROM_FILE, this.fnIndexFile );
            result = false;
        }

        if ( result ) {
            this.trace( MoinSeverity.DEBUG, IndexFsDumpedConstants.LOADED_DUMP_FROM_FILE, this.fnIndexFile );
        } else {
            this.resetIndex( );
            this.deleteIndexFiles( );
        }

        return result;
    }

    /**
     * Updates the DataArea life cycle map during the
     * {@link #synchronizeInternal(com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncKind, PRI[], long[], SpiPartitionStreamProvider, String, String, boolean)
     * synchronizeInternal(...)} method.
     * <p>
     * If the given DataArea is already in the life cycle map (i.e. is contained
     * in the dump or already synchronized), its state is set to
     * {@link DataAreaLCState#USED}. Otherwise it is added to the map in state
     * {@link DataAreaLCState#USED} and all DataAreas with state <=
     * {@link DataAreaLCState#DELETE_LEVEL} are removed from index or
     * {@link DataAreaLCState#UNUSED} are set to
     * {@link DataAreaLCState#DEL_CANDIDATE}.
     * 
     * @param dataAreaName The name of the DataArea (which was synchronized)
     */
    private void updateDataAreasInSync( String dataAreaName ) {

        if ( !this.dataAreaLC.containsKey( dataAreaName ) ) {
            this.dataAreaLC.put( dataAreaName, DataAreaLCState.USED );
            Set<String> dataAreasToRemove = null;
            Map.Entry<String, Integer> entry = null;
            for ( Iterator<Map.Entry<String, Integer>> it = this.dataAreaLC.entrySet( ).iterator( ); it.hasNext( ); ) {
                entry = it.next( );
                if ( entry.getValue( ) <= DataAreaLCState.DELETE_LEVEL ) {
                    if ( dataAreasToRemove == null ) {
                        dataAreasToRemove = new HashSet<String>( this.dataAreaLC.size( ) );
                    }
                    dataAreasToRemove.add( entry.getKey( ) );
                } else if ( entry.getValue( ) == DataAreaLCState.UNUSED ) {
                    entry.setValue( DataAreaLCState.DEL_CANDIDATE );
                }
            }
            this.removeDataAreasInternal( dataAreasToRemove );
        } else {
            this.dataAreaLC.put( dataAreaName, DataAreaLCState.USED );
        }
    }

    /**
     * Removes all DataAreas that are not used during this session from index
     * (i.e. they will not be in the dump).
     */
    private void updateDataAreasInShutdown( ) {

        Set<String> dataAreasToRemove = null;
        Map.Entry<String, Integer> entry = null;
        for ( Iterator<Map.Entry<String, Integer>> it = this.dataAreaLC.entrySet( ).iterator( ); it.hasNext( ); ) {
            entry = it.next( );
            if ( entry.getValue( ) < DataAreaLCState.USED ) {
                if ( dataAreasToRemove == null ) {
                    dataAreasToRemove = new HashSet<String>( this.dataAreaLC.size( ) );
                }
                dataAreasToRemove.add( entry.getKey( ) );
            }
        }
        this.removeDataAreasInternal( dataAreasToRemove );
    }

    /**
     * Creates a initial DataArea life cycle map by use of the information
     * loaded from dump. All DataAreas are set to {@link DataAreaLCState#UNUSED}
     * except the metamodel DataArea which is set to
     * {@link DataAreaLCState#USED}.
     * 
     * @return
     */
    protected Map<String, Integer> initDataAreaLifeCycleTable( ) {

        Object[] table = this.daToDcsToIndexPris.table;
        LinkedHashMap<String, Integer> ret = new LinkedHashMap<String, Integer>( IndexConstants.INITIAL_DA_LC );
        String daName = null;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                daName = ( (IndexPri) ( (Object[][]) table[i] )[0][0] ).getDataAreaName( );
                if ( daName == IndexConstants.MM_DA_NAME ) { //$JL-STRING$
                    ret.put( daName, DataAreaLCState.USED );
                } else {
                    ret.put( daName, DataAreaLCState.UNUSED );
                }
            }
        }
        return ret;
    }

    /**
     * Checks if the DataArea is already synchronized. Aquires not read lock. It
     * must be called in a method that has read lock.
     * 
     * @param dataAreaName
     * @return
     */
    private boolean isDataAreaSyncedYet( String dataAreaName ) {

        Integer daState = this.dataAreaLC.get( dataAreaName );
        if ( daState == null || daState < DataAreaLCState.USED ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected Collection<IndexPri> getIndexPrisInScope( String dataAreaName, String containerName, boolean syncedOnly ) {

        if ( dataAreaName == null ) {
            if ( syncedOnly ) {
                throw new IndexBugException( IndexFsDumpedMessages.DATA_AREA_SCOPE_MISSING );
            }
        } else {
            if ( syncedOnly && !this.isDataAreaSyncedYet( dataAreaName ) ) {
                return null;
            }
        }

        return super.getIndexPrisInScope( dataAreaName, containerName, syncedOnly );
    }

    /**
     * Adds dump life cycle capabilities and model-metamodel synchronization to
     * the superior synchronizeInternal() method.
     * <p>
     * If there are metamodels that could not be deployed or are undeployed from
     * index, all model partitions referring these metamodels are removed from
     * index too. Furthermore it marks the data area as in-sync with the file
     * system. A data area must be in-sync to contribute to query results.
     * Otherwise, all content in this data area will be ignored.
     */
    @Override
    protected SyncReport synchronizeInternal( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, String dataAreaName, String containerName, PRI[] toDelete, SyncContext syncContext ) {

        assert syncContext == null : IndexFsDumpedConstants.INACTIVE_SYNC_NOT_ALLOWED;

        SyncReport sr = null;

        sr = super.synchronizeInternal( toIndex, timestamps, streamProvider, forced, dataAreaName, containerName, toDelete, syncContext );

        // remove all model partitions using deleted or changed metamodels
        if ( syncContext == null ) {
            if ( dataAreaName == IndexConstants.MM_DA_NAME ) { //$JL-STRING$
                this.adaptContentToDeletedMetamodels( sr );
            }

            // Release the data area for queries. There are two possibilities:
            // 1. new data area: The data area is registered as synchronized
            // 2. known data area: The data are is released for queries. The 
            //    DiService takes care that a container cannot be synchronized
            //    without a client spec. When initializing the client spec,
            //    the corresponding data area is synchronized completely.
            //    Therefore it is not possible to that a data area is released
            //    just because one container is synchronized.
            this.updateDataAreasInSync( dataAreaName );
        }

        return sr;
    }

    private void adaptContentToDeletedMetamodels( SyncReport sr ) {

        // do not remove models for updated metamodels because:
        // unchanged model partitions would be reindexed since metamodel is still available
        // and changed model partitions would be reindexed during sync (timestamp)
        if ( !sr.DELETED.isEmpty( ) || !sr.EXCEPTION.isEmpty( ) ) {

            // find affected metamodel containers
            // use IdentityHashMap to test only for identity
            IdentityHashMap<String, Object> mmContainer = null;

            for ( PRI pri : sr.DELETED ) {
                // MOFROM is part of sr.Delete, i.e. is deleted in sync, and will be injected afterwards
                // but we don't want to delete all models of MOF (i.e. all metamodels)
                if ( pri.getContainerName( ) != IndexConstants.MOF_CONTAINER_NAME ) { //$JL-STRING$
                    if ( mmContainer == null ) {
                        mmContainer = new IdentityHashMap<String, Object>( sr.DELETED.size( ) + sr.EXCEPTION.size( ) );
                    }

                    mmContainer.put( pri.getContainerName( ), null );
                }
            }

            for ( PRI pri : sr.EXCEPTION ) {
                // corrupt metamodels
                if ( mmContainer == null ) {
                    mmContainer = new IdentityHashMap<String, Object>( sr.EXCEPTION.size( ) );
                }
                mmContainer.put( pri.getContainerName( ), null );
            }

            if ( mmContainer != null ) {
                this.removePartitionsUsingMetamodelsInternal( mmContainer );
            }
        }
    }

    @Override
    public PRI getPriForLri( ClientSpec[] clientSpecs, LRI lri ) {

        assert lri != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        PRI ret = null;
        // obtain read lock
        this.rwLock.readLock( ).lock( );
        try {
            String lriDaName = lri.getDataAreaDescriptor( ).getDataAreaName( );
            if ( this.isDataAreaSyncedYet( lriDaName ) ) {
                ret = super.getPriForLriInternal( lri );
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
        return ret;
    }

    @Override
    public boolean isPartitionExistent( ClientSpec clientSpec, PRI pri ) {

        assert pri != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        this.rwLock.readLock( ).lock( );
        try {
            if ( !this.isDataAreaSyncedYet( pri.getDataAreaDescriptor( ).getDataAreaName( ) ) ) {
                return false;
            }
            return this.priToIndexPri.containsKey( pri.toString( ) );
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
    }

    @Override
    public boolean hasCrossPartitionLinks( ClientSpec clientSpecOne, PRI onePartition, ClientSpec clientSpecTwo, PRI twoPartition ) {

        DataAreaDescriptor daOne = onePartition.getDataAreaDescriptor( );
        DataAreaDescriptor daTwo = twoPartition.getDataAreaDescriptor( );
        if ( this.isDataAreaSyncedYet( daOne.getDataAreaName( ) ) && // only test second data area name if it is different from first one
             ( daOne == daTwo ) ? true : this.isDataAreaSyncedYet( daTwo.getDataAreaName( ) ) ) {
            return super.hasCrossPartitionLinks( clientSpecOne, onePartition, clientSpecTwo, twoPartition );
        }
        return false;
    }

    @Override
    public boolean hasCrossPartitionLink( ClientSpec clientSpecsFrom, PRI partitionFrom, LRI elementTo ) {

        DataAreaDescriptor daOne = partitionFrom.getDataAreaDescriptor( );
        DataAreaDescriptor daTwo = elementTo.getDataAreaDescriptor( );
        if ( this.isDataAreaSyncedYet( daOne.getDataAreaName( ) ) && // only test second data area name if it is different from first one
             ( daOne == daTwo ) ? true : this.isDataAreaSyncedYet( daTwo.getDataAreaName( ) ) ) {
            return super.hasCrossPartitionLink( clientSpecsFrom, partitionFrom, elementTo );
        }
        return false;
    }

    /*
     * #######################################################################
     * ####### Testing ######
     * #######################################################################
     */
    /**
     * Use in test methods only. Dump is only to be triggered in DumperThread!
     * 
     * @return
     */
    @Override
    public boolean dumpIndex( ) {

        /*
         * We need a write lock here, since this method can be triggered from
         * eclipse UI thread. We use I/O in the save where eclipse might do a
         * job switch (ModalContext) in between. saveIndexToFileSystemInternal()
         * only needs a read lock for dumping the index, but a job switch might
         * cause the UI thread to gather a write lock e.g. with
         * indexPartition(). That would be a lock upgrade since the UI thread
         * already has the read lock from saveIndexToFileSystemInternal() in
         * another eclipse job. Furthermore it synchronizes the dump calls
         * coming from DumperThread and UI thread concurrently.
         */
        this.rwLock.writeLock( ).lock( );
        try {
            return this.saveIndexInternal( );
        } finally {
            this.rwLock.writeLock( ).unlock( );
        }
    }

    /*
     * #######################################################################
     * ####### Logging ######
     * #######################################################################
     */
    private void trace( Throwable t, MoinSeverity severity, String message, Object... args ) {

        if ( this.LOGGER.isTraced( severity ) ) {
            this.LOGGER.trace( t, severity, message, args );
        }
    }

    private void trace( MoinSeverity severity, String message, Object... args ) {

        if ( this.LOGGER.isTraced( severity ) ) {
            this.LOGGER.trace( severity, message, args );
        }
    }

    /*
     * #######################################################################
     * ####### Dumper Thread ######
     * #######################################################################
     */
    /**
     * A deamon thread that dumps the index periodically to disc by triggering
     * the {@link IndexDumpedImpl#saveIndexToFileSystemInternal()}. The sleep
     * time is defined in {@link IndexConstants#DUMP_THREAD_SLEEP_TIME}.
     * <p>
     * When the thread is shut-downed it triggers a final dump.
     * 
     * @author D048997
     */
    private static class DumperThread extends Thread {

        private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_INDEX, DumperThread.class );

        private IndexAbstractDumpedImpl index = null;

        private boolean stopThread = false;

        public DumperThread( IndexAbstractDumpedImpl index ) {

            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, IndexFsDumpedConstants.DUMPER_THREAD_STARTING, IndexConstants.DUMPER_THREAD_NAME );
            }

            this.setName( IndexConstants.DUMPER_THREAD_NAME + "-" + index.moinId ); //$NON-NLS-1$
            this.index = index;
            this.setPriority( Thread.MIN_PRIORITY );
            this.setDaemon( true );
            this.start( );
        }

        @Override
        public void run( ) {

            while ( true ) {
                synchronized ( this ) {
                    if ( this.stopThread == true ) {
                        this.index.saveIndexInternal( );
                        break;
                    }
                    try {
                        this.wait( IndexConstants.DUMP_THREAD_SLEEP_TIME );
                    } catch ( InterruptedException ie ) {
                        // $JL-EXC$ ignore
                    }
                }

                this.index.saveIndexInternal( );
            }
        }

        /**
         * This method sets the state of the thread to 'shutdown'. The call of
         * the <code>interrupt()</code>-method wakes up the thread if it is put
         * to sleep in the <code>run()</code>-method and therefore causes a
         * final dumping before the thread ends.
         */
        public synchronized void requestStop( ) {

            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, IndexFsDumpedConstants.DUMPER_THREAD_STOP_REQUESTED, IndexConstants.DUMPER_THREAD_NAME );
            }

            this.stopThread = true;
            this.notify( );
        }

    }

    /*
     * ######################################################################
     * ######## METHODS FOR USE IN TESTS ONLY !!!!!!!!!!!!!! ################
     */

    public String getIndexDumpFilePath( ) {

        return this.fnIndexFile;
    }


}
