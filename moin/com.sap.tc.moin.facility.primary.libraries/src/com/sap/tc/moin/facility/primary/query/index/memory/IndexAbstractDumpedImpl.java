package com.sap.tc.moin.facility.primary.query.index.memory;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.ObjectName;

import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.jmx.IndexDumpedMBean;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Extends the IndexImpl with the possibility to dump the state. Therefore a
 * life cycle is defined that ensures that all information returned by query
 * methods is already synchronized with the file system. In other words, it
 * ensures that a data area is already synced before any information contained
 * in it is exposed.
 * <p>
 * Not all query methods are overwritten inhere. All methods with ClientSpec
 * scope parameters are not overwritten because the DI service ensures that a
 * data area is synchronized during ClientSpec initialization. Exceptions for
 * that are {@link #isPartitionExistent(ClientSpec, PRI)} and
 * {@link #getPriForLri(ClientSpec, LRI)}. The ClientSpec parameter is ignored
 * since it does not provide a DataArea scope for the query and this index
 * implementation has no knowledge about Stages.
 * 
 * @author D048997
 */
public abstract class IndexAbstractDumpedImpl extends IndexImpl {

    // ############# Logging Variables ###############
    private final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_INDEX, IndexImpl.class );

    protected IndexDumpHandler dumpHandler = null;

    protected boolean dumpFailed = false;

    /**
     * Required in {@link IndexDumpHandler}
     */
    protected ResourceIdentifierFactory riFactory;

    /**
     * @param facilityId
     * @param moinId
     * @param refQueue
     * @param fnIndexFile The full path to the index dump file
     */
    public IndexAbstractDumpedImpl( String facilityId, String moinId, ReferenceQueue refQueue ) {

        super( facilityId, moinId, refQueue );
    }

    public void bind( ResourceIdentifierFactory riFactory ) {

        this.riFactory = riFactory;
    }

    @Override
    protected void initializeScenarioSpecific( ) {

        // in all scenarios with dump: make sure the dump handler can be set properly and try to load the index

        this.dumpHandler = this.createDumpHandler( );
        assert this.dumpHandler != null : IndexAbstractDumpedConstants.DUMPHANDLER_NOT_CREATED;

        this.loadIndexInternal( );
    }

    abstract protected IndexDumpHandler createDumpHandler( );

    @Override
    protected JmxAdapter createJmxAdapter( ) {

        return new JmxDumpedAdapter( this, this.getObjectName( ), this.moinGarbageRefQueue );
    }

    @Override
    public void tearDown( ) {

        super.tearDown( );
        this.riFactory = null;
    }


    protected boolean saveIndexInternal( ) {

        boolean result = false;

        /*
         * We aquire the write lock because the cleanup of empty weak references
         * on the mofIdToElements table changes the table. Gathering the write
         * lock here also guarantees that no two threads dump the index
         * concurrently.
         */
        this.rwLock.writeLock( ).lock( );
        try {
            this.mofIdToElements.cleanup( );
            // downgrade to readlock only if cleanup was successfull
            this.rwLock.readLock( ).lock( );
        } finally {
            this.rwLock.writeLock( ).unlock( );
        }

        try {
            if ( this.isIndexChanged ) {
                if ( result = this.performDump( ) ) {
                    this.isIndexChanged = false;
                    this.markDumpFailed( false );
                } else {
                    this.markDumpFailed( true );
                }
            }
        } catch ( Exception e ) {
            this.markDumpFailed( true );
            this.trace( e, MoinSeverity.ERROR, IndexAbstractDumpedTraceMessages.ERROR_DURING_INDEX_DUMP );
            result = false;
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
        return result;
    }

    private void markDumpFailed( boolean value ) {

        this.dumpFailed = true;
    }

    protected boolean performDump( ) {

        return this.dumpHandler.dump( );
    }

    /**
     * Use in test methods only!
     * 
     * @return
     */
    public boolean dumpIndex( ) {

        return this.saveIndexInternal( );
    }

    public final boolean loadIndex( ) {

        this.rwLock.writeLock( ).lock( );
        try {
            return this.loadIndexInternal( );
        } finally {
            this.rwLock.writeLock( ).unlock( );
        }
    }

    protected boolean loadIndexInternal( ) {

        boolean result = this.performLoad( );
        this.markDumpFailed( false );
        return result;
    }

    abstract protected boolean performLoad( );

    /**
     * Removes the content of all DataAreas in the given parameter list from
     * index.
     * <p>
     * For performance reasons this bulk operation removes entries from the hash
     * tables not via their APIs.
     * 
     * @param dataAreasToRemove
     */
    public void removeDataAreas( Set<String> dataAreasToRemove ) {

        this.rwLock.writeLock( ).lock( );
        try {
            this.removeDataAreasInternal( dataAreasToRemove );
        } finally {
            this.rwLock.writeLock( ).unlock( );
        }
    }

    protected void removeDataAreasInternal( Set<String> dataAreasToRemove ) {

        if ( dataAreasToRemove == null || dataAreasToRemove.size( ) == 0 ) {
            return;
        }

        this.removeFromMofIdToElements( dataAreasToRemove );
        this.removeFromPriToIndexPri( dataAreasToRemove );
        this.removeFromPriToElements( dataAreasToRemove );
        this.removeFromPriToLinkRecords( dataAreasToRemove );
        this.typeToInstances.condense( );
        this.removeFromTypeToInstances( dataAreasToRemove );
        this.removeFromLocOrExtLR( dataAreasToRemove, this.localMofIdToLinkRecords );
        this.removeFromLocOrExtLR( dataAreasToRemove, this.extMofIdToLinkRecords );
        this.removeFromDaToIndexPri( dataAreasToRemove );
        this.removeFromTopLevelPkg( dataAreasToRemove );

        this.isIndexChanged = true;
    }

    private void removeFromMofIdToElements( Set<String> dataAreasToRemove ) {

        Object[] table = this.mofIdToElements.table;
        Object item = null;
        Object[] imes = null;
        String daName = null;
        IndexModelElement ime = null;
        IndexMofId mofId = null;
        ReferenceQueue<IndexMofId> queue = this.mofIdToElements.getReferenceQueue( );
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                item = table[i];
                if ( item instanceof IndexModelElement ) {
                    ime = ( (IndexModelElement) item );
                    daName = ime.getDataAreaName( );
                    if ( dataAreasToRemove.contains( daName ) ) {
                        table[i] = new IndexWeakHashReference<IndexMofId>( ime.mofId, queue, i );
                    }
                } else if ( item instanceof Object[] ) {
                    int counter = 0;
                    imes = (Object[]) item;
                    mofId = ( (IndexModelElement) imes[0] ).mofId;
                    for ( int j = 0; j < imes.length; j++ ) {
                        daName = ( (IndexModelElement) imes[j] ).getDataAreaName( );
                        if ( dataAreasToRemove.contains( daName ) ) {
                            imes[j] = null;
                            counter++;
                        } else {
                            ime = ( (IndexModelElement) imes[j] );
                        }
                    }

                    if ( counter == 0 ) {
                        continue;
                    } else if ( counter == imes.length ) {
                        table[i] = new IndexWeakHashReference<IndexMofId>( mofId, queue, i );
                        continue;
                    } else if ( counter == imes.length - 1 ) {
                        table[i] = ime;
                        continue;
                    } else {
                        int last = imes.length;
                        while ( imes[--last] == null ) {
                            ;
                        }
                        for ( int j = 0; j < last; j++ ) {
                            if ( imes[j] == null ) {
                                imes[j] = imes[last];
                                while ( imes[--last] == null ) {
                                    ;
                                }
                            }
                        }
                        Object[] newImes = new IndexHashSetElement[++last];
                        System.arraycopy( imes, 0, newImes, 0, last );
                        table[i] = newImes;
                    }
                }
            }
        }
        this.mofIdToElements.rehash( );
    }

    private void removeFromPriToIndexPri( Set<String> dataAreasToRemove ) {

        Object[] table = this.priToIndexPri.table;
        String daName = null;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                daName = ( (IndexPri) table[i] ).getDataAreaName( );
                if ( dataAreasToRemove.contains( daName ) ) {
                    table[i] = null;
                }
            }
        }
        this.priToIndexPri.rehash( );
    }

    private void removeFromPriToElements( Set<String> dataAreasToRemove ) {

        Object[] table = this.priToElements.table;
        String daName = null;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                daName = ( (IndexModelElement) ( (Object[]) table[i] )[0] ).getDataAreaName( );
                if ( dataAreasToRemove.contains( daName ) ) {
                    table[i] = null;
                }
            }
        }
        this.priToElements.rehash( );
    }

    private void removeFromPriToLinkRecords( Set<String> dataAreasToRemove ) {

        Object[] table = this.priToLinkRecords.table;
        String daName = null;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                daName = ( (IndexLinkRecord) ( (Object[]) table[i] )[0] ).idxPri.getDataAreaName( );
                if ( dataAreasToRemove.contains( daName ) ) {
                    table[i] = null;
                }
            }
        }
        this.priToLinkRecords.rehash( );
    }

    private void removeFromTypeToInstances( Set<String> dataAreasToRemove ) {

        Object[] table = this.typeToInstances.table;
        String daName = null;
        final int X_MASK = IndexHashSetFastLists.X_MASK;
        final int X_SHIFT = IndexHashSetFastLists.X_SHIFT;
        Object[][] item = null;
        int size;
        for ( int i = 0; i < table.length; i++ ) {
            int counter = 0;
            if ( table[i] != null ) {
                item = (Object[][]) table[i];
                size = IndexHashSetFastLists.calcSize( item );

                for ( int j = 0; j < size; j++ ) {
                    daName = ( (IndexModelElement) item[j >> X_SHIFT][j & X_MASK] ).getDataAreaName( );
                    if ( dataAreasToRemove.contains( daName ) ) {
                        item[j >> X_SHIFT][j & X_MASK] = null;
                        counter++;
                    }
                }

                if ( counter == 0 ) {
                    continue;
                } else if ( counter == size ) {
                    table[i] = null;
                    continue;
                } else {
                    int last = size;
                    while ( item[--last >> X_SHIFT][last & X_MASK] == null ) {
                        ;
                    }
                    for ( int j = 0; j < last; j++ ) {
                        if ( item[j >> X_SHIFT][j & X_MASK] == null ) {
                            item[j >> X_SHIFT][j & X_MASK] = item[last >> X_SHIFT][last & X_MASK];
                            while ( item[--last >> X_SHIFT][last & X_MASK] == null ) {
                                ;
                            }
                        }
                    }
                    Object[][] newTab = new IndexHashSetElement[( last >> X_SHIFT ) + 1][];
                    System.arraycopy( item, 0, newTab, 0, last >> X_SHIFT );
                    Object[] nTab = new IndexHashSetElement[( last & X_MASK ) + 1];
                    System.arraycopy( item[last >> X_SHIFT], 0, nTab, 0, nTab.length );
                    newTab[last >> X_SHIFT] = nTab;
                    table[i] = newTab;
                }
            }
        }
        this.typeToInstances.rehash( );
    }

    private void removeFromLocOrExtLR( Set<String> dataAreasToRemove, IndexHashSetTwoKey<IndexLinkRecord> tab ) {

        Object[] table = tab.table;
        String daName = null;
        Object[][] item = null;
        Object[] subItem = null;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                item = (Object[][]) table[i];
                int counter1 = 0;
                for ( int j = 0; j < item.length; j++ ) {
                    subItem = item[j];
                    int counter2 = 0;
                    for ( int j2 = 0; j2 < subItem.length; j2++ ) {
                        daName = ( (IndexLinkRecord) subItem[j2] ).idxPri.getDataAreaName( );
                        if ( dataAreasToRemove.contains( daName ) ) {
                            subItem[j2] = null;
                            counter2++;
                        }
                    }
                    if ( counter2 == 0 ) {
                        continue;
                    } else if ( counter2 == subItem.length ) {
                        item[j] = null;
                        counter1++;
                        continue;
                    } else {
                        int last = subItem.length;
                        while ( subItem[--last] == null ) {
                            ;
                        }
                        for ( int k = 0; k < last; k++ ) {
                            if ( subItem[k] == null ) {
                                subItem[k] = subItem[last];
                                while ( subItem[--last] == null ) {
                                    ;
                                }
                            }
                        }
                        Object[] newSubItem = new IndexHashSetElement[++last];
                        System.arraycopy( subItem, 0, newSubItem, 0, last );
                        item[j] = newSubItem;
                    }
                }

                if ( counter1 == 0 ) {
                    continue;
                } else if ( counter1 == item.length ) {
                    table[i] = null;
                    continue;
                } else {
                    int last = item.length;
                    while ( item[--last] == null ) {
                        ;
                    }
                    for ( int k = 0; k < last; k++ ) {
                        if ( item[k] == null ) {
                            item[k] = item[last];
                            while ( item[--last] == null ) {
                                ;
                            }
                        }
                    }
                    Object[][] newItem = new IndexHashSetElement[++last][];
                    System.arraycopy( item, 0, newItem, 0, last );
                    table[i] = newItem;
                }
            }
        }
        tab.rehash( );
    }

    private void removeFromDaToIndexPri( Set<String> dataAreasToRemove ) {

        Object[] table = this.daToDcsToIndexPris.table;
        String daName = null;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                daName = ( (IndexPri) ( (Object[][]) table[i] )[0][0] ).getDataAreaName( );
                if ( dataAreasToRemove.contains( daName ) ) {
                    table[i] = null;
                }
            }
        }
        this.daToDcsToIndexPris.rehash( );
    }

    private void removeFromTopLevelPkg( Set<String> dataAreasToRemove ) {

        Object[] table = this.topLevelPackages.table;
        String daName = null;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                daName = ( (IndexModelElement) table[i] ).getDataAreaName( );
                if ( dataAreasToRemove.contains( daName ) ) {
                    table[i] = null;
                }
            }
        }
        this.topLevelPackages.rehash( );
    }

    /* ############### Private method ############# */

    public void removePartitionsUsingMetamodelsInternal( Map<String, Object> mmContainer ) {

        Object[] idxPris = this.priToIndexPri.table;
        IndexPri idxPri;
        List<IndexPri> prisToDelete = new ArrayList<IndexPri>( );
        for ( int i = 0; i < idxPris.length; i++ ) {
            if ( idxPris[i] != null ) {
                idxPri = (IndexPri) idxPris[i];
                if ( idxPri.getDataAreaName( ) == IndexConstants.MM_DA_NAME ) { //$JL-STRING$
                    continue;
                }
                List<String> priMMs = this.calculateUsedMetamodels( idxPri );
                if ( priMMs != null ) {
                    if ( priMMs.isEmpty( ) ) {
                        prisToDelete.add( idxPri );
                    }
                }
                if ( priMMs != null && !priMMs.isEmpty( ) ) {
                    for ( String mm : priMMs ) {
                        if ( mmContainer.containsKey( mm ) ) {
                            prisToDelete.add( idxPri );
                            break;
                        }
                    }
                }
            }
        }
        idxPris = null;
        for ( IndexPri delIdxPri : prisToDelete ) {
            this.removePartitionInternal( delIdxPri );
        }
    }

    /**
     * @param idxPri
     * @return A list of metamodel containers used in the partition, an empty
     * list if the metamodel for a contained element is not found, or
     * <code>null</code> if the partition is empty
     */
    private List<String> calculateUsedMetamodels( IndexPri idxPri ) {

        Map<String, Object> metamodels = new IdentityHashMap<String, Object>( );

        Object[] list = this.priToElements.getUnderlyingForRead( idxPri );
        if ( list != null ) {
            for ( int i = 0; i < list.length; i++ ) {
                IndexModelElement ime = (IndexModelElement) list[i];
                String cnName = this.getMetamodelContainer( ime.typeMofId );
                if ( cnName != null ) {
                    metamodels.put( cnName, null );
                } else {
                    return Collections.emptyList( );
                }
            }
        }
        list = this.priToLinkRecords.getUnderlyingForRead( idxPri );
        if ( list != null ) {
            for ( int i = 0; i < list.length; i++ ) {
                IndexLinkRecord ilr = (IndexLinkRecord) list[i];
                String cnName = this.getMetamodelContainer( ilr.typeMofId );
                if ( cnName != null ) {
                    metamodels.put( cnName, null );
                } else {
                    return Collections.emptyList( );
                }
            }
        }

        if ( metamodels.keySet( ).size( ) != 0 ) {
            return new ArrayList<String>( metamodels.keySet( ) );
        } else {
            return null;
        }
    }

    /**
     * @param idxMofId
     * @return Container of the metamodel that contains the idxMofId,
     * <code>null</code> if no metamodel was found.
     */
    private String getMetamodelContainer( IndexMofId idxMofId ) {

        Object ilrType = this.mofIdToElements.getUnderlyingForRead( idxMofId );
        if ( ilrType == null ) {
            return null;
        }
        if ( ilrType instanceof IndexModelElement ) {
            IndexModelElement type = (IndexModelElement) ilrType;
            if ( type.getDataAreaName( ) == IndexConstants.MM_DA_NAME ) { //$JL-STRING$
                return type.pri.getContainerName( );
            } else {
                return null;
            }
        } else { // array
            Object[] typeCand = (Object[]) ilrType;
            for ( int j = 0; j < typeCand.length; j++ ) {
                IndexModelElement type = (IndexModelElement) typeCand[j];
                if ( type.getDataAreaName( ) == IndexConstants.MM_DA_NAME ) { //$JL-STRING$
                    return type.pri.getContainerName( );
                }
            }
        }
        return null;
    }

    private void trace( Throwable t, MoinSeverity severity, MoinExternalizedString message, Object... args ) {

        if ( this.LOGGER.isTraced( severity ) ) {
            this.LOGGER.trace( t, severity, message, args );
        }
    }

    // ##################### JMX ADAPTER ################

    /**
     * Extends the JMX adapter of the super class with dumping functionality
     */
    protected static class JmxDumpedAdapter extends JmxAdapter implements IndexDumpedMBean {

        protected JmxDumpedAdapter( IndexImpl index, ObjectName objectName, ReferenceQueue refQueue ) {

            super( index, objectName, refQueue, false );
            registerBroadcastingMBean( this, IndexDumpedMBean.class, objectName );
        }

        public boolean forceDump( ) throws IOException {

            IndexAbstractDumpedImpl index = this.getIndex( );
            if ( index != null ) {
                return index.dumpIndex( );
            }
            return false;
        }

        public boolean forceLoad( ) throws IOException {

            IndexAbstractDumpedImpl index = this.getIndex( );
            if ( index != null ) {
                return index.loadIndex( );
            }
            return false;
        }

        private IndexAbstractDumpedImpl getIndex( ) {

            return (IndexAbstractDumpedImpl) this.indexRef.get( );
        }

        public boolean isDumpFailed( ) {

            return this.getIndex( ).dumpFailed;
        }
    }
}
