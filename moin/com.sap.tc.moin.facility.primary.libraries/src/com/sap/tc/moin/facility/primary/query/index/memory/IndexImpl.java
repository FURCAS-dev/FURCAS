package com.sap.tc.moin.facility.primary.query.index.memory;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.unregisterMBean;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiQuery;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.DuplicateElementException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.jmx.IndexMBean;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimIndexQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService.SpiMofRomPartitionContent;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * Subclassed for persisting index state by {@link IndexDumpedImpl}
 * 
 * @author D048997
 */
public class IndexImpl implements IpiIndexManagement, IpiQuery, SpiFacilitySlimIndexQueryService, SpiCoreQueryService, IpiFacilityComponent {

    // ############# Logging Variables ###############

    private final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_INDEX, IndexImpl.class );

    // ############# Environment Member Variables ###############

    protected SpiPartitionSerializationManager partitionSerializationManager;

    protected IndexMofIdFactory mofIdFactory;

    protected volatile boolean isIndexChanged;

    protected ReentrantReadWriteLock rwLock;

    // ############# JMX Member Variables ###############
    /**
     * The name identifying this session in JMX.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer. We need it
     * for the emission of JMX notifications.
     */
    protected JmxAdapter jmxAdapter;

    /**
     * Whether the emission of JMX notifications is currently enabled.
     */
    protected volatile boolean jmxNotificationsEnabled;

    // ############# Hash Table Member Variables ###############

    protected IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = null;

    protected IndexHashSetLists<IndexModelElement> priToElements = null;

    protected IndexHashSetFastLists<IndexModelElement> typeToInstances = null;

    protected IndexHashSetSingle<IndexPri> priToIndexPri = null;

    protected IndexHashSetLists<IndexLinkRecord> priToLinkRecords = null;

    protected IndexHashSetTwoKey<IndexLinkRecord> localMofIdToLinkRecords = null;

    protected IndexHashSetTwoKey<IndexLinkRecord> extMofIdToLinkRecords = null;

    protected IndexHashSetTwoKey<IndexPri> daToDcsToIndexPris = null;

    protected IndexHashSetSingle<IndexNamedModelElement> topLevelPackages = null;

    protected final String facilityId;

    protected final String moinId;

    protected ReferenceQueue moinGarbageRefQueue = null;

    // ############# LifeCycle #####################

    public IndexImpl( String facilityId, String moinId, ReferenceQueue refQueue ) {

        this.facilityId = facilityId;
        this.moinId = moinId;
        this.rwLock = new ReentrantReadWriteLock( );
    }

    public final void initialize( ) {

        this.isIndexChanged = false;
        if ( JMX_ENABLED ) {
            this.jmxAdapter = this.createJmxAdapter( );
        }

        this.initializeScenarioSpecific( );
    }

    protected void initializeScenarioSpecific( ) {

        // in memory scenario: just create an empty index
        this.trace( MoinSeverity.DEBUG, IndexConstants.INDEX_INITIALIZATION );
        this.resetIndex( );
    }

    protected JmxAdapter createJmxAdapter( ) {

        return new JmxAdapter( this, this.getObjectName( ), this.moinGarbageRefQueue );
    }

    public void tearDown( ) {

        if ( JMX_ENABLED ) {
            unregisterMBean( this.getObjectName( ) );
            this.objectName = null;
        }
        this.trace( MoinSeverity.DEBUG, IndexConstants.INDEX_TEARDOWN );

        this.partitionSerializationManager = null;
        this.metamodelService = null;
    }

    public void finalizeStartup( ) {

    }

    public void bind( SpiPartitionSerializationManager serializationManager ) {

        this.partitionSerializationManager = serializationManager;
    }

    public void bind( SpiMetamodelService service ) {

        this.metamodelService = service;
    }

    protected void init( ) {

        this.mofIdFactory = new IndexMofIdFactory( this.mofIdToElements );

        this.elementPackageMofId = this.mofIdFactory.createAndCacheMofId( IndexConstants.ELEMENT_PACKAGE_MOF_ID );
        this.assocContainsMofId = this.mofIdFactory.createAndCacheMofId( IndexConstants.ASSOC_CONTAINS_MOF_ID );
    }

    protected void resetIndex( ) {

        this.mofIdToElements = new IndexHashSetDuplicates<IndexModelElement, IndexMofId>( IndexModelElement.MOF_ID, IndexConstants.INITIAL_TOTAL_LRI );

        this.priToElements = new IndexHashSetLists<IndexModelElement>( IndexModelElement.PRI, IndexConstants.INITIAL_PRI );

        this.typeToInstances = new IndexHashSetFastLists<IndexModelElement>( IndexModelElement.TYPE_MOF_ID, IndexConstants.INITIAL_MC );

        this.priToIndexPri = new IndexHashSetSingle<IndexPri>( IndexPri.PRI, IndexConstants.INITIAL_PRI );

        this.priToLinkRecords = new IndexHashSetLists<IndexLinkRecord>( IndexLinkRecord.PRI, IndexConstants.INITIAL_PRI );

        this.localMofIdToLinkRecords = new IndexHashSetTwoKey<IndexLinkRecord>( IndexLinkRecord.LOCAL_MOF_ID, IndexLinkRecord.TYPE_MOF_ID, IndexConstants.INITIAL_TOTAL_LRI );

        this.extMofIdToLinkRecords = new IndexHashSetTwoKey<IndexLinkRecord>( IndexLinkRecord.EXT_MOF_ID, IndexLinkRecord.TYPE_MOF_ID, IndexConstants.INITIAL_TOTAL_LRI );

        this.daToDcsToIndexPris = new IndexHashSetTwoKey<IndexPri>( IndexPri.DA, IndexPri.DC, IndexConstants.INITIAL_DA );

        this.topLevelPackages = new IndexHashSetSingle<IndexNamedModelElement>( IndexNamedModelElement.MOF_ID );

        this.isIndexChanged = true;

        this.init( );
    }

    public void clear( ) {

        this.resetIndex( );
    }

    public String getFacilityId( ) {

        return this.facilityId;
    }

    // ################### Sanity Checks #####################

    public boolean doSanityCheck( int sanityLevel ) {

        this.rwLock.readLock( ).lock( );
        try {
            if ( IndexConstants.SANITY_CHECK_DISABLED && ( sanityLevel & IndexConstants.SANITY_CHECK_DISABLED_IGNORE ) == 0 ) {
                return false;
            }
            if ( ( sanityLevel & IndexConstants.SANITY_MOFID_CONSISTENCY ) > 0 ) {
                this.sanityCheckMofIdReferenceConsistency( );
            }
            if ( ( sanityLevel & IndexConstants.SANITY_DEV_COMP ) > 0 ) {
                this.sanityCheckDCs( );
            }
            if ( ( sanityLevel & IndexConstants.SANITY_ELEMENTS ) > 0 ) {
                this.sanityCheckElements( );
            }
            if ( ( sanityLevel & IndexConstants.SANITY_LINKS_FAST ) > 0 ) {
                this.sanityCheckLinksFast( );
            }
            if ( ( sanityLevel & IndexConstants.SANITY_LINKS_COMPLETE ) > 0 ) {
                this.santiyCheckLinksComplete( );
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
        return true;
    }

    private void sanityCheckElements( ) {

        // all moinentities
        Object[] mes = this.mofIdToElements.keys( );
        for ( int j = 0; j < mes.length; ++j ) {
            IndexMofId lri = (IndexMofId) mes[j];
            Object obj = this.mofIdToElements.getUnderlyingForRead( lri );
            if ( obj == null ) {
                throw new IllegalStateException( "No elements found for key " + lri.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
            }
            if ( obj instanceof IndexModelElement ) {
                IndexModelElement me = (IndexModelElement) obj;
                this.sanityCheckElement( me );
            }
            if ( obj instanceof Object[] ) {
                Object[] lst = (Object[]) obj;
                for ( int i = 0; i < lst.length; ++i ) {
                    IndexModelElement me = (IndexModelElement) lst[i];
                    if ( me.mofId != lri ) {
                        throw new IllegalStateException( "Model Element in wrong bucket ! " + me ); //$NON-NLS-1$ // sanity check, for debug only
                    }
                    this.sanityCheckElement( me );
                }
            }
        }
        { // all mmriToEntities
            Object[] keys = this.typeToInstances.keys( );
            for ( int j = 0; j < keys.length; j++ ) {
                IndexMofId key = (IndexMofId) keys[j];
                IndexArrayFastList<IndexModelElement> lst = this.typeToInstances.getUnderlyingForRead( key );
                for ( int i = 0; i < lst.size( ); ++i ) {
                    IndexModelElement me = lst.get( i );
                    if ( me == null ) {
                        throw new IllegalStateException( "mmriToEntities list contains null  for key !? " + key ); //$NON-NLS-1$ // sanity check, for debug only
                    }
                    this.sanityCheckElement( me );
                }
            }
        }
        { // all priToEntities
            Object[] keys = this.priToElements.keys( );
            for ( int j = 0; j < keys.length; ++j ) {
                IndexPri key = (IndexPri) keys[j];
                IndexPri mpri = this.priToIndexPri.get( key.getPriString( ) );
                if ( mpri == null ) {
                    throw new IllegalStateException( "unknown pri in  priToEntities " + key ); //$NON-NLS-1$ // sanity check, for debug only
                }
                Object[] lst = this.priToElements.getUnderlyingForRead( mpri );
                for ( int i = 0; i < lst.length; ++i ) {
                    IndexModelElement me = (IndexModelElement) lst[i];
                    if ( me == null ) {
                        throw new IllegalStateException( "priToEntities list contains null  for key !? " + key ); //$NON-NLS-1$ // sanity check, for debug only
                    }
                    this.sanityCheckElement( me );
                }
            }
        }
    }

    private void sanityCheckDCs( ) {

        { // all DAs and DCs
            Object[] keys = this.priToIndexPri.keys( );
            for ( int i = 0; i < keys.length; i++ ) {
                String key = (String) keys[i];
                IndexPri idxPri = this.priToIndexPri.get( key );
                String daName = idxPri.getCachedPri( ).getDataAreaDescriptor( ).getDataAreaName( );
                String dcName = idxPri.getCachedPri( ).getContainerName( );

                Object[] pris = this.daToDcsToIndexPris.getUnderlyingForRead( daName, dcName );
                if ( pris == null ) {
                    throw new IllegalStateException( "No pris indexed for container " + dcName ); //$NON-NLS-1$ // sanity check, for debug only
                }

                boolean found = false;
                for ( int j = 0; j < pris.length; j++ ) {
                    if ( pris[j] == idxPri ) {
                        found = true;
                    }
                }
                if ( found == false ) {
                    throw new IllegalStateException( "daToDcsToIndexPris lists is missing IndexPri " + idxPri.getPriString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }
            }
        }

    }

    private void sanityCheckElement( IndexModelElement metest ) {

        {
            Object[] res = this.priToElements.getUnderlyingForRead( metest.pri );
            if ( res == null ) {
                throw new IllegalStateException( "Expected element list for PRI=" + metest.pri.getPriString( ) ); //$NON-NLS-1$ // sanity check, for debug only
            }
            int k = 0;
            for ( int i = 0; i < res.length; ++i ) {
                if ( ( res[i] == metest ) ) {
                    ++k;
                }
            }
            if ( k != 1 ) {
                throw new IllegalStateException( "Expected exactly one entry in this.priToEntities for " + metest ); //$NON-NLS-1$ // sanity check, for debug only
            }
        }

        // check present in t
        Object obj = this.mofIdToElements.getUnderlyingForRead( metest.mofId );
        if ( obj == null ) {
            throw new IllegalStateException( "Missing model element" ); //$NON-NLS-1$ // sanity check, for debug only
        }
        if ( obj instanceof IndexModelElement ) {
            IndexModelElement me = (IndexModelElement) obj;
            if ( metest != me ) {
                throw new IllegalStateException( "Model Entity me missing in moinEntitires" ); //$NON-NLS-1$ // sanity check, for debug only
            }
        }
        if ( obj instanceof Object[] ) {
            Object[] lst = ( (Object[]) obj );
            int k = 0;
            for ( int i = 0; i < lst.length; ++i ) {
                IndexModelElement me = (IndexModelElement) lst[i];
                if ( me == null ) {
                    throw new IllegalStateException( "mofIdToElements contains null values" ); //$NON-NLS-1$ // sanity check, for debug only
                }
                if ( me == metest ) {
                    ++k;
                }
            }
            if ( k != 1 ) {
                throw new IllegalStateException( "Entity me " + metest + " missing/double in moinEntities " ); //$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
            }
        }
        // check the pri is known and valid.

        if ( !this.priToIndexPri.containsKey( metest.pri.getPriString( ) ) ) {
            throw new IllegalStateException( "Unknown pri object in " + metest.pri + " not in list" );//$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
        }
        if ( this.priToIndexPri.get( metest.pri.getPriString( ) ) != metest.pri ) {
            throw new IllegalStateException( "Unknown pri object in " + metest.pri + " not in priToIndexPri. Smells like douplicate!" );//$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
        }
        {
            IndexArrayFastList<IndexModelElement> res = this.typeToInstances.getUnderlyingForRead( metest.typeMofId );
            int k = 0;
            for ( int i = 0; i < res.size( ); ++i ) {
                if ( res.get( i ) == null ) {
                    throw new IllegalStateException( "TypesToInstances contains null" ); //$NON-NLS-1$ // sanity check, for debug only
                }
                if ( ( res.get( i ) == metest ) ) {
                    ++k;
                }
            }
            if ( k != 1 ) {
                throw new IllegalStateException( "Expected exactly one entry in this.mmriToEntites for " + metest ); //$NON-NLS-1$ // sanity check, for debug only
            }
        }
    }

    private void sanityCheckLinksFast( ) {

        int locSize = this.localMofIdToLinkRecords.totalSize( );
        int extSize = this.extMofIdToLinkRecords.totalSize( );
        if ( locSize != extSize ) {
            this.trace( MoinSeverity.ERROR, IndexConstants.LINK_TABLES_INCONSISTENT, locSize, extSize );
        }
    }

    private void santiyCheckLinksComplete( ) {

        // 1. compare size of both link hashes
        int ts1 = this.localMofIdToLinkRecords.totalSize( );
        int ts2 = this.extMofIdToLinkRecords.totalSize( );
        if ( ts1 != ts2 ) {
            throw new IllegalStateException( "LRI hash tables vary in size! locMofIdToLR " + ts1 + "/ extMofIdToLR " + ts2 ); //$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
        }

        // 2. compare numbers of all links in all pri with numbers of links in
        // LRI hash tables
        int ts3 = this.priToLinkRecords.totalSize( );
        if ( ts1 != ts3 ) {
            throw new IllegalStateException( "Number of links in PRIs != number of links in lriToLR hash tables! priToLr " + ts3 + "/ locMofIdToLR " + ts1 ); //$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
        }

        // 3. check every link in all PRIs
        Object[] ptlrKeys = this.priToLinkRecords.keys( );
        for ( int k = 0; k < ptlrKeys.length; k++ ) {
            IndexPri ptlrKey = (IndexPri) ptlrKeys[k];
            // 3.0 check that key is valid (in moinPRIs mPRIs)
            if ( !this.priToIndexPri.containsKey( ptlrKey.getPriString( ) ) ) {
                throw new IllegalStateException( "key pri " + ptlrKey + " missing in mPRIs!" ); //$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
            }

            Object[] lrs = this.priToLinkRecords.getUnderlyingForRead( ptlrKey );
            if ( lrs == null ) {
                throw new IllegalStateException( "orphaned pri " + ptlrKey ); //$NON-NLS-1$ // sanity check, for debug only
            }

            for ( int l = 0; l < lrs.length; l++ ) {
                IndexLinkRecord lr = (IndexLinkRecord) lrs[l];
                if ( lr == null ) {
                    throw new IllegalStateException( "PriToLinkRecords contains null value" ); //$NON-NLS-1$ // sanity check, for debug only
                }
                // 3.1 check if lri1 and lri2 are in moinEntities (does not need
                // to be!)
                Object me1 = this.mofIdToElements.getUnderlyingForRead( lr.mofIdOfLocalEnd );
                if ( me1 != null ) {
                    if ( me1 instanceof IndexModelElement ) {
                        if ( ( (IndexModelElement) me1 ).mofId != lr.mofIdOfLocalEnd ) {
                            throw new IllegalStateException( "link lri1 (" + lr.mofIdOfLocalEnd + ") and entity lri (" + ( (IndexModelElement) me1 ).mofId + ") do not match!" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ // sanity check, for debug only
                        }
                    } else if ( me1 instanceof Object[] ) {
                        boolean found = false;
                        Object[] me1_1 = (Object[]) me1;
                        for ( int i = 0; i < me1_1.length; i++ ) {
                            if ( ( (IndexModelElement) me1_1[i] ).mofId == lr.mofIdOfLocalEnd ) {
                                found = true;
                                break;
                            }
                        }
                        if ( !found ) {
                            throw new IllegalStateException( "link lri1 (" + lr.mofIdOfLocalEnd + ") not found in list of (inconsistent?) elements!" ); //$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
                        }
                    }
                }
                Object me2 = this.mofIdToElements.getUnderlyingForRead( lr.mofIdOfExternalEnd );
                if ( me2 != null ) {
                    if ( me2 instanceof IndexModelElement ) {
                        if ( ( (IndexModelElement) me2 ).mofId != lr.mofIdOfExternalEnd ) {
                            throw new IllegalStateException( "link lri2 (" + lr.mofIdOfExternalEnd + ") and entity lri (" + ( (IndexModelElement) me2 ).mofId + ") do not match!" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ // sanity check, for debug only
                        }
                    } else if ( me2 instanceof Object[] ) {
                        boolean found = false;
                        Object[] me2_1 = (Object[]) me2;
                        for ( int i = 0; i < me2_1.length; i++ ) {
                            if ( ( (IndexModelElement) me2_1[i] ).mofId == lr.mofIdOfExternalEnd ) {
                                found = true;
                                break;
                            }
                        }
                        if ( !found ) {
                            throw new IllegalStateException( "link lri2 (" + lr.mofIdOfExternalEnd + ") not found in list of (inconsistent?) elements!" ); //$NON-NLS-1$ //$NON-NLS-2$ // sanity check, for debug only
                        }
                    }
                }

                // 3.2 check lr.pri is equal to key.pri
                if ( lr.idxPri != ptlrKey ) {
                    throw new IllegalStateException( "link record pri does not match priToLinkRecord pri! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }

                // 3.3 check validity of link pri
                if ( !this.priToIndexPri.containsKey( lr.idxPri.getPriString( ) ) ) {
                    throw new IllegalStateException( "pri missing in priToIndexPri! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }

                // 3.4 check existence of lri1 in hash table
                if ( !this.localMofIdToLinkRecords.containsKey( lr.mofIdOfLocalEnd ) ) {
                    throw new IllegalStateException( "lri1 not present in locLinkTable! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }
                if ( !this.extMofIdToLinkRecords.containsKey( lr.mofIdOfExternalEnd ) ) {
                    throw new IllegalStateException( "lri2 not present in extLinkTable! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }

                // 3.5 check consistency of mmri betwenn link and lri1 and lri2
                // hash
                // by checking presence of link record in mmri lists
                Object[] lrs1 = this.localMofIdToLinkRecords.getUnderlyingForRead( lr.mofIdOfLocalEnd, lr.typeMofId );
                if ( lrs1 == null ) {
                    throw new IllegalStateException( "Expected non-empty list of link records for lri1->mmri! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }
                Object[] lrs2 = this.extMofIdToLinkRecords.getUnderlyingForRead( lr.mofIdOfExternalEnd, lr.typeMofId );
                if ( lrs2 == null ) {
                    throw new IllegalStateException( "Expected non-empty list of link records for lri2->mmri! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }

                // 3.5.1 check only existence of link record in lri1->mmri list
                int count = 0;
                for ( int i = 0; i < lrs1.length; ++i ) {
                    if ( lrs1[i].equals( lr ) ) {
                        ++count;
                    }
                }
                if ( count != 1 ) {
                    throw new IllegalStateException( "Missing/duplicated link record in lri1->mmri! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }

                // 3.5.2 check only existence of link record in lri2->mmri list
                count = 0;
                for ( int i = 0; i < lrs2.length; ++i ) {
                    if ( lrs2[i].equals( lr ) ) {
                        ++count;
                    }
                }
                if ( count != 1 ) {
                    throw new IllegalStateException( "Missing/duplicated link record in lri2->mmri! link record: " + lr.toString( ) ); //$NON-NLS-1$ // sanity check, for debug only
                }
            }
        }

    }

    private boolean sanityCheckMofIdReferenceConsistency( ) {

        this.mofIdToElements.checkSize( );
        this.priToElements.checkSize( );
        this.priToIndexPri.checkSize( );
        this.priToLinkRecords.checkSize( );
        this.topLevelPackages.checkSize( );
        this.localMofIdToLinkRecords.checkSize( );
        this.extMofIdToLinkRecords.checkSize( );
        this.daToDcsToIndexPris.checkSize( );
        this.typeToInstances.checkSize( );

        Object[] mteTable = this.mofIdToElements.table;
        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIds = this.mofIdToElements;

        IndexModelElement me = null;
        int pos = 0;
        for ( int i = 0; i < mteTable.length; i++ ) {
            if ( mteTable[i] != null ) {
                if ( mteTable[i] instanceof IndexModelElement ) {
                    me = (IndexModelElement) mteTable[i];
                    pos = mofIds.getPositionInTable( me.typeMofId );
                } else if ( mteTable[i] instanceof Object[] ) {
                    for ( int j = 0; j < ( (Object[]) mteTable[i] ).length; j++ ) {
                        me = (IndexModelElement) ( (Object[]) mteTable[i] )[j];
                        pos = mofIds.getPositionInTable( me.typeMofId );
                    }
                } else if ( mteTable[i] instanceof IndexWeakHashReference ) {
                } else {
                    return false;
                }
                if ( pos == -1 ) {
                    return false;
                }
            }
        }
        return true;
    }

    // ############### Private index update methods #############

    private void addElements( IndexPri pri, Collection<SpiLink> partitionLinks, Collection<Partitionable> created, Collection<Partitionable> assigned, int sizeAddPerPRIHint ) {

        if ( sizeAddPerPRIHint <= 0 ) {
            return;
        }

        IndexModelElement me = null;
        IndexArrayList<IndexModelElement> priLst = this.priToElements.getUnderlyingForChangeOrCreate( pri );
        IndexMofId mmri = null;
        IndexMofId mofId = null;

        Collection<Partitionable> toProcess = created;

        for ( int i = 0; i < 2; i++ ) {
            for ( Partitionable en : toProcess ) {
                if ( en instanceof RefObject ) {
                    RefObject refen = (RefObject) en;
                    mmri = this.mofIdFactory.createAndCacheMofId( refen.refMetaObject( ).refMofId( ) );
                    mofId = this.mofIdFactory.createMofId( en.refMofId( ) );
                    me = this.addElement( pri, partitionLinks, mmri, mofId );
                    if ( me == null ) {
                        continue;
                    }
                    priLst.add( me );
                }
            }
            toProcess = assigned;
        }

        priLst.store( );

        this.doSanityCheck( IndexConstants.SANITY_AFTER_ELEMENT_ADD );
    }

    private IndexModelElement addElement( IndexPri idxPri, Collection<SpiLink> partitionLinks, IndexMofId mmri, IndexMofId mofId ) {

        IndexModelElement me = null; // create later

        // delete possible unnecessary cross links
        if ( this.extMofIdToLinkRecords.containsKey( mofId ) ) {
            String partDaName = idxPri.getDataAreaName( );
            for ( SpiLink link : partitionLinks ) {
                LRI refLri = link.getOtherEndLri( );
                IndexMofId refMofId = this.mofIdFactory.createAndCacheMofId( refLri.getMofId( ) );
                if ( refMofId == mofId && refLri.getDataAreaDescriptor( ).getDataAreaName( ) == partDaName ) { //$JL-STRING$

                    IndexMofId linkMmri = this.mofIdFactory.createAndCacheMofId( link.getMetaObjectMri( ).getMofId( ) );
                    IndexMofId storeEndMofId = this.mofIdFactory.createAndCacheMofId( link.getStorageEndMri( ).getMofId( ) );
                    IndexArrayTwoKey<IndexLinkRecord> ilrs2 = this.extMofIdToLinkRecords.getUnderlyingForChange( mofId, linkMmri );
                    if ( ilrs2 != null ) {
                        IndexLinkRecord ilr2;
                        for ( int i = 0; i < ilrs2.size( ); ) {
                            ilr2 = ilrs2.get( i );
                            if ( ilr2 != null ) {
                                if ( ilr2.mofIdOfLocalEnd == storeEndMofId && ilr2.idxPri == idxPri ) {
                                    this.localMofIdToLinkRecords.removeElement( ilr2 );
                                    ilrs2.remove( i ); // remove from extMofIdToLinkRecords
                                    this.priToLinkRecords.removeElement( ilr2 );
                                    break;
                                } else {
                                    ++i;
                                }
                            } else {
                                break;
                            }
                        }
                        ilrs2.store( );
                    }
                }
            }
        }

        Object obj = this.mofIdToElements.getUnderlyingForChange( mofId );
        if ( obj instanceof IndexArrayDuplicates ) {
            IndexArrayDuplicates<IndexModelElement> lst = (IndexArrayDuplicates<IndexModelElement>) obj;
            for ( int i = 0; i < lst.arraySize( ); i++ ) {
                IndexModelElement me_old = lst.get( i );
                if ( me_old.mofId == mofId && me_old.typeMofId == mmri && me_old.pri == idxPri ) {
                    return null; // no need to add!
                }
            }
            me = new IndexModelElement( mofId, mmri, idxPri );
            lst.add( me );
            lst.store( );
        } else if ( obj instanceof IndexModelElement ) {
            IndexModelElement me_old = (IndexModelElement) obj;
            if ( me_old.mofId == mofId && me_old.typeMofId == mmri && me_old.pri == idxPri ) {
                return null; // no need to add!
            }
            me = new IndexModelElement( mofId, mmri, idxPri );
            this.mofIdToElements.put( me );
        } else {
            me = new IndexModelElement( mofId, mmri, idxPri );
            this.mofIdToElements.put( me );
        }
        this.typeToInstances.put( me );
        return me;

    }

    protected IndexPri createIndexPri( PRI pri, long timestamp ) {

//        if ( this.priToIndexPri.get( pri.toString( ) ) != null ) {
//            throw new IndexBugException( IndexConstants.PARTITION_EXISTS_ALREADY_ACTIVE, pri );
//        }
        IndexPri idxPri = new IndexPri( pri, timestamp );
        this.daToDcsToIndexPris.put( idxPri );
        return idxPri;
    }

    protected void addIndexPriToTables( IndexPri idxPri ) {

        this.priToIndexPri.put( idxPri );
    }

    protected void removeIndexPriFromTables( IndexPri idxPri ) {

        this.priToIndexPri.removeElement( idxPri );
    }

    /**
     * 
     */
    private void removeElements( IndexPri pri, SpiModelPartition partition, Collection<MRI> deleted, Set<Partitionable> unassigned ) {

        IndexModelElement me = null;
        IndexArrayList<IndexModelElement> priLst = this.priToElements.getUnderlyingForChange( pri );
        if ( priLst == null ) {
            return;
        }

        for ( MRI en : deleted ) {
            me = this.removeElement( pri, new SpiLinkList( partition.getLinks( ) ), this.mofIdFactory.createAndCacheMofId( en.getMofId( ) ), false );
            priLst.remove( me );
        }

        for ( Partitionable en : unassigned ) {
            me = this.removeElement( pri, new SpiLinkList( partition.getLinks( ) ), this.mofIdFactory.createAndCacheMofId( en.refMofId( ) ), true );
            priLst.remove( me );
        }

        priLst.store( );

        this.doSanityCheck( IndexConstants.SANITY_AFTER_ELEMENT_REMOVE );
    }

    /**
     * remove an entity (from all hashes), do not remove any links pointing/ to
     * at this, except they become intra-partitions links
     * 
     * @param aPRI
     * @param mofId
     */
    protected IndexModelElement removeElement( IndexPri pri, LinkList linksInPartition, IndexMofId mofId, boolean isReassigned ) {

        // do not remove a duplicate !
        Object res = this.mofIdToElements.getUnderlyingForRead( mofId );
        IndexModelElement removed = null;
        if ( res instanceof IndexModelElement ) {
            removed = (IndexModelElement) res;
            this.mofIdToElements.removeElement( removed );
        } else if ( res != null ) { // it's an array !
            Object[] lst = (Object[]) res;
            boolean linksAlreadyConverted = false;
            for ( int i = 0; i < lst.length; ++i ) {
                IndexModelElement element = (IndexModelElement) lst[i];

                // test for same data area for intra/cross link conversion in
                // case of inconsistency
                if ( !isReassigned && !linksAlreadyConverted ) {
                    if ( element.pri != pri && element.getDataAreaName( ) == pri.getDataAreaName( ) ) { //$JL-STRING$

                        this.convertIntraToCrossLinks( linksInPartition, pri, element );
                        linksAlreadyConverted = true;
                    }
                }

                if ( element.pri == pri ) {
                    removed = element;
                    this.mofIdToElements.removeElement( element );
                }
            }
        }
        if ( removed != null ) {
            // create crosslinks for intra partition links
            // Note: the target of the link will be unresolved until other
            // partition is stored
            if ( isReassigned ) {
                this.convertIntraToCrossLinks( linksInPartition, pri, removed );
            }
            this.typeToInstances.removeElement( removed );
        }
        return removed;

    }

    /*
     * Called in removeElement(). Indexes all intra-partition links in the
     * partition that become cross links because of element deletion
     * (inconsistency or element move).
     */
    private void convertIntraToCrossLinks( LinkList linksInPartition, IndexPri priOfLinks, IndexModelElement otherEndElement ) {

        while ( linksInPartition.next( ) ) {
            // check for existence of the link to be created is not necessary, since if an intra-partition
            // link existed an equivalent cross-partition link is not stored in index (see #addLinks())
            String linkOtherMofId = linksInPartition.getSecondMofId( );

            if ( this.mofIdFactory.getMofId( linkOtherMofId ) != otherEndElement.mofId ) {
                continue;
            }

            IndexMofId linkMofId = this.mofIdFactory.createAndCacheMofId( linksInPartition.getTypeMofId( ) );
            int storageEnd = linksInPartition.getStorageEnd( );

            IndexLinkRecord ilr = new IndexLinkRecord( priOfLinks, this.mofIdFactory.createAndCacheMofId( linksInPartition.getFirstMofId( ) ), linkMofId, (byte) storageEnd, otherEndElement.mofId, otherEndElement.getDataAreaName( ) );

            this.localMofIdToLinkRecords.put( ilr );
            this.extMofIdToLinkRecords.put( ilr );
            this.priToLinkRecords.put( ilr );
        }
    }

    /**
     * It is unclear how the linkset is prepared, thus we have to guess at an
     * efficient removal strategy.
     */
    private void removeLinks( IndexPri idxPri, Collection<SpiLink> removedLinks ) {

        int size = removedLinks.size( );
        if ( size <= 0 ) {
            return;
        }
        ArrayList<IndexLinkRecord> toBeRemoved = new ArrayList<IndexLinkRecord>( size );

        // here we need no special treatment for storage at child (without
        // reference )

        for ( SpiLink en : removedLinks ) {
            IndexMofId mmassoc = this.mofIdFactory.createAndCacheMofId( en.getMetaObjectMri( ).getMofId( ) );
            MRI storageObj = en.getStorageEndMri( );
            IndexMofId storageMofId = this.mofIdFactory.createAndCacheMofId( storageObj.getMofId( ) );
            IndexArrayTwoKey<IndexLinkRecord> r1 = this.localMofIdToLinkRecords.getUnderlyingForChange( storageMofId, mmassoc );
            if ( r1 != null ) {
                LRI otherObj = en.getOtherEndLri( );
                IndexMofId otherMofId = this.mofIdFactory.createAndCacheMofId( otherObj.getMofId( ) );
                String otherDaName = otherObj.getDataAreaDescriptor( ).getDataAreaName( );

                for ( int i = 0; i < r1.size( ); ) {
                    IndexLinkRecord link = r1.get( i );
                    if ( link != null ) {
                        if ( ( link.mofIdOfExternalEnd == otherMofId ) && ( link.idxPri == idxPri ) && ( link.dataAreaOfExternalEnd == otherDaName ) ) { //$JL-STRING$
                            if ( IndexConstants.ALWAYS_REMOVE_LINK || ( link.numOfAssocEndOfLocalEnd == en.getEndNumberOfStorageEnd( ) ) ) {
                                r1.remove( i );
                                toBeRemoved.add( link );
                            }
                        } else {
                            ++i;
                        }
                    } else {
                        break;
                    }
                }
                r1.store( );
            }
//            else {
//                 // not present (intra partition link)!
//            }
        }
        IndexArrayList<IndexLinkRecord> lst = this.priToLinkRecords.getUnderlyingForChange( idxPri );
        int numOfDelLinksInPri = 0;

        // delete whole entry if we have to remove all links
        if ( ( lst != null ) && ( lst.arraySize( ) == toBeRemoved.size( ) ) ) {
            this.priToLinkRecords.removeAllElements( idxPri );
            numOfDelLinksInPri = lst.arraySize( );
            lst = null;
        }

        for ( IndexLinkRecord link : toBeRemoved ) {
            if ( lst != null ) {
                if ( lst.remove( link ) ) {
                    ++numOfDelLinksInPri;
                }
            }
            this.extMofIdToLinkRecords.removeElement( link );
        }
        if ( lst != null ) {
            lst.store( );
        }

        if ( numOfDelLinksInPri != toBeRemoved.size( ) ) {
            throw new IndexBugException( IndexMessages.NUM_OF_INDEXED_LINKS_DIFFER, toBeRemoved.size( ), numOfDelLinksInPri );
        }

        this.doSanityCheck( IndexConstants.SANITY_AFTER_LINK_REMOVE );
    }

    /**
     * It is unclear how the linkset is prepared, thus we have to guess at an
     * efficient removal strategy.
     */
    protected void addLinks( IndexPri idxPri, Collection<SpiLink> addedLinks ) {

        IndexHashSetTwoKey<IndexLinkRecord> locMofId2Links = this.localMofIdToLinkRecords;
        IndexHashSetTwoKey<IndexLinkRecord> extMofId2Links = this.extMofIdToLinkRecords;

        if ( addedLinks.size( ) == 0 ) {
            return;
        }
        // added to hash table
        IndexArrayList<IndexLinkRecord> lst = this.priToLinkRecords.getUnderlyingForChangeOrCreate( idxPri );

        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = this.mofIdToElements;
        Object[] singleElem = new Object[1];

        Object lri1elems = null;
        for ( SpiLink en : addedLinks ) {
            IndexMofId storageMofId = this.mofIdFactory.createAndCacheMofId( en.getStorageEndMri( ).getMofId( ) );
            LRI otherObj = en.getOtherEndLri( );
            IndexMofId otherMofId = this.mofIdFactory.createAndCacheMofId( otherObj.getMofId( ) );

            // create the cross partition link for all inconsistency elements
            lri1elems = mofIdToElements.getUnderlyingForRead( storageMofId );
            if ( lri1elems != null ) {
                Object[] sourceElems = null;
                if ( lri1elems instanceof IndexModelElement ) {
                    sourceElems = singleElem;
                    sourceElems[0] = lri1elems;
                } else {
                    sourceElems = (Object[]) lri1elems;
                }

                IndexPri idxPri1 = null;
                IndexPri idxPri2 = null;
                for ( int i = 0; i < sourceElems.length; i++ ) {
                    if ( ( idxPri1 = ( (IndexModelElement) sourceElems[i] ).pri ) == idxPri ) {
                        String otherDaName = otherObj.getDataAreaDescriptor( ).getDataAreaName( );

                        // ... but skip intra-partition links
                        idxPri2 = null;
                        Object lri2elems = mofIdToElements.getUnderlyingForRead( otherMofId );
                        if ( lri2elems != null ) {
                            if ( lri2elems instanceof IndexModelElement ) {
                                idxPri2 = ( (IndexModelElement) lri2elems ).pri;
                                if ( idxPri2 == idxPri1 || ( idxPri1.getDataAreaName( ) != idxPri.getDataAreaName( ) ) ) { //$JL-STRING$
                                    continue;
                                }
                            } else { // it's an array
                                boolean doContinue = false;
                                Object[] lri2els = (Object[]) lri2elems;
                                for ( int j = 0; j < lri2els.length; j++ ) {
                                    idxPri2 = ( (IndexModelElement) lri2els[j] ).pri;
                                    if ( idxPri2 == idxPri1 || ( idxPri1.getDataAreaName( ) != idxPri.getDataAreaName( ) ) ) { //$JL-STRING$
                                        doContinue = true;
                                    }
                                }
                                if ( doContinue ) {
                                    continue;
                                }
                            }
                        }

                        // if link is cross partition link, get rest of necessary
                        // information
                        byte storageEnd = (byte) en.getEndNumberOfStorageEnd( );
                        IndexMofId mmassoc = this.mofIdFactory.createAndCacheMofId( en.getMetaObjectMri( ).getMofId( ) );

                        if ( !this.isLinkRecordAlreadyExistent( storageMofId, otherMofId, idxPri1, mmassoc, storageEnd, otherDaName ) ) {

                            IndexLinkRecord lr = new IndexLinkRecord( idxPri1, storageMofId, mmassoc, storageEnd, otherMofId, otherDaName );
                            if ( idxPri == idxPri1 ) {
                                lst.add( lr );
                            } else {
                                this.priToLinkRecords.put( lr );
                            }
                            locMofId2Links.put( lr );
                            extMofId2Links.put( lr );
                        }
                    }
                }
            }
        }

        // quit here if no cross links are found
        if ( lst.size( ) == 0 ) {
            return;
        }

        lst.store( );

        this.doSanityCheck( IndexConstants.SANITY_AFTER_LINK_ADD );

    }

    /**
     * Subtracts the set of new partitions from the set of old partitions
     * already contained in the index.
     * 
     * @param oldPartitionList
     * @param newPartitionList
     * @return
     */
    private Collection<IndexPri> calcPartitionsToRemove( Collection<IndexPri> oldPartitionList, PRI[] newPartitionList ) {

        if ( oldPartitionList == null ) {
            return null;
        }
        ArrayList<IndexPri> result = null;
        boolean deleteCurrent;
        for ( IndexPri idxPri : oldPartitionList ) {
            deleteCurrent = true;
            for ( int i = 0; i < newPartitionList.length; i++ ) {
                if ( idxPri.getPriString( ) == newPartitionList[i].toString( ) ) { //$JL-STRING$
                    deleteCurrent = false;
                    break;
                }
            }
            if ( deleteCurrent ) {
                if ( result == null ) {
                    result = new ArrayList<IndexPri>( );
                }
                result.add( idxPri );
            }
        }
        return result;
    }

    /**
     * Returns all available IndexPris in a data area and container.<br>
     * <br>
     * Note: These are no copies. Do not alter the lists!
     * 
     * @param dataAreaName
     * @param containerName
     * @param reserved For use in IndexDumpedImpl
     * @return List of {@link IndexPri} or null
     */
    protected Collection<IndexPri> getIndexPrisInScope( String dataAreaName, String containerName, boolean reserved ) {

        if ( dataAreaName == null ) {
            return this.priToIndexPri.values( );
        }
        if ( containerName == null ) {
            // return all pris in a data area
            Object[][] containers = this.daToDcsToIndexPris.getUnderlyingForRead( dataAreaName );
            if ( containers == null ) {
                return null;
            }
            ArrayList<IndexPri> result = new ArrayList<IndexPri>( containers.length << 4 );
            IndexPri idxPri;
            for ( int i = 0; i < containers.length; ++i ) {
                for ( int j = 0; j < containers[i].length; ++j ) {
                    if ( ( idxPri = (IndexPri) containers[i][j] ).isActive( ) ) {
                        result.add( idxPri );
                    }
                }
            }
            return result;
        }
        // return all pris in a container of a data area
        Object[] idxPris = this.daToDcsToIndexPris.getUnderlyingForRead( dataAreaName, containerName );
        if ( idxPris != null ) {
            IndexPri idxPri;
            ArrayList<IndexPri> pris = new ArrayList<IndexPri>( idxPris.length );
            for ( int i = 0; i < idxPris.length; ++i ) {
                if ( ( idxPri = (IndexPri) idxPris[i] ).isActive( ) ) {
                    pris.add( idxPri );
                }
            }
            return pris;
        }
        return null;
    }

    private List<MRI> otherEndIndexMEPresentExt( ClientSpec[] clientSpecs, IndexMofId mofId, String dataAreaName, IndexMofId mriassoc, byte b ) {

        List<MRI> res = null;
        Object[] resLst = this.extMofIdToLinkRecords.getUnderlyingForRead( mofId, mriassoc );
        String daName = null;
        if ( resLst != null ) {
            for ( int i = 0; i < resLst.length; ++i ) {
                IndexLinkRecord lr = (IndexLinkRecord) resLst[i];
                if ( lr != null ) {
                    if ( lr.numOfAssocEndOfLocalEnd == b && lr.dataAreaOfExternalEnd == dataAreaName ) { //$JL-STRING$
                        daName = lr.idxPri.getDataAreaName( );
                        for ( int j = 0; j < clientSpecs.length; j++ ) {
                            if ( daName == clientSpecs[j].getDataArea( ).getDescriptor( ).getDataAreaName( ) ) { //$JL-STRING$
                                if ( res == null ) {
                                    res = new ArrayList<MRI>( );
                                }
                                res.add( lr.idxPri.createMri( lr.mofIdOfLocalEnd ) );
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private void closeStream( InputStream is ) {

        if ( is != null ) {
            try {
                is.close( );
            } catch ( IOException e ) {
            }
        }
    }

    private boolean isLinkRecordAlreadyExistent( IndexMofId locMofId, IndexMofId extMofId, IndexPri lnkPri, IndexMofId assocType, byte storageEnd, String daName ) {

        Object[] loc = this.localMofIdToLinkRecords.getUnderlyingForRead( locMofId, assocType );
        if ( loc == null ) {
            return false;
        }
        for ( int i = 0; i < loc.length; i++ ) {
            IndexLinkRecord lr = (IndexLinkRecord) loc[i];
            if ( lr.dataAreaOfExternalEnd == daName && lr.idxPri == lnkPri && lr.numOfAssocEndOfLocalEnd == storageEnd && lr.mofIdOfExternalEnd == extMofId ) { //$JL-STRING$
                return true;
            }
        }

        return false;
    }

    private boolean isInScope( SpiFacilityQueryClientScope clientScope, IndexPri partition ) {

        return partition.isActive( ) && this.isInScope( clientScope, partition.getCachedPri( ) );
    }

    /**
     * Checks if the given partition is completely in scope of the given client
     * scope. I.e. it tests the client spec scope and the partition scope.
     * 
     * @param clientScope
     * @param partition
     * @return
     */
    private boolean isInScope( SpiFacilityQueryClientScope clientScope, PRI partition ) {

        final ClientSpec[] clientSpecs = clientScope.getQueryClientScope( );

        // TODO: consider set of client specs
        boolean hasClientSpecScope = this.isInClientSpecScope( clientSpecs, partition.getDataAreaDescriptor( ).getDataAreaName( ) );
        boolean hasPartitionScope = this.isInPartitionScope( clientScope, partition );

        return hasClientSpecScope && hasPartitionScope;
    }

    private boolean isInClientSpecScope( ClientSpec[] clientSpecs, String dataAreaName ) {

        for ( int i = 0; i < clientSpecs.length; i++ ) {
            if ( clientSpecs[i].getDataArea( ).getDescriptor( ).getDataAreaName( ) == dataAreaName ) { //$JL-STRING$
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given partition is in the PartitionScopt of the given
     * client scope
     * 
     * @param clientScope
     * @param partition
     * @return
     */
    private boolean isInPartitionScope( SpiFacilityQueryClientScope clientScope, PRI partition ) {

        return clientScope.getPartitionsScope( ).contains( partition ) == clientScope.isPartitionScopeInclusive( );
    }

    private List<MRI> getElementsInPartitions( ClientSpec[] clientScope, Collection<PRI> partitions ) {

        // reduce Garbage production:
        int partitionCount = partitions.size( );
        int allSize = 0;
        Object[][] all = new Object[partitionCount][];
        for ( PRI pri : partitions ) {
            if ( !this.isInClientSpecScope( clientScope, pri.getDataAreaDescriptor( ).getDataAreaName( ) ) ) {
                continue;
            }
            Object[] obj = this.priToElements.getUnderlyingForRead( this.priToIndexPri.get( pri.toString( ) ) );
            if ( obj != null ) {
                all[--partitionCount] = obj;
                allSize += obj.length;
            }
        }
        if ( allSize == 0 ) {
            return Collections.emptyList( );
        } else {
            List<MRI> result = new ArrayList<MRI>( allSize );
            for ( int i = 0; i < all.length; i++ ) {
                if ( all[i] != null ) {
                    for ( int j = 0; j < all[i].length; j++ ) {
                        result.add( ( (IndexModelElement) all[i][j] ).getMri( ) );
                    }
                }
            }
            return result;
        }
    }

    /* ******************************************************************** */
    /* ******************************************************************** */
    /* ******************************************************************** */
    /* Interface Implementations */
    /* ******************************************************************** */
    /* ******************************************************************** */
    /* ******************************************************************** */

    // ################ PartitionReaderCallback Interface #################
    protected IndexPri currentPri = null;

    protected boolean isCurrentPartitionMetamodel = false;

    protected IndexArrayList<IndexModelElement> currentPriMEs = null;

    private IndexArrayList<IndexLinkRecord> currentPriLRs = null;

    private IndexMofId assocContainsMofId = null;

    private IndexMofId elementPackageMofId = null;

    protected SpiMetamodelService metamodelService = null;

    private List<IndexQueueEntry> queuedMofPartitionsToIndex = null;

    public void addIntraPartitionLink( String mofIdOfFirstElement, String mofIdOfSecondElement, String mofIdOfMetaObject, int storageEnd ) {

        // Check if the link is a link of the "Contains" association, but only if the current partition is a metamodel partition.
        if ( this.isCurrentPartitionMetamodel && this.mofIdFactory.createAndCacheMofId( mofIdOfMetaObject ) == this.assocContainsMofId ) {
            IndexMofId extMofId = this.mofIdFactory.createAndCacheMofId( mofIdOfSecondElement );
            this.topLevelPackages.remove( extMofId );
        }
    }

    public void addCrossPartitionLink( String mofIdOfFirstElement, LRI lriOfSecondElement, String mofIdOfMetaObject ) {

        addLink( mofIdOfFirstElement, lriOfSecondElement, mofIdOfMetaObject, (byte) 0 /* storageEnd */);
    }

    public void addCrossPartitionLink( LRI lriOfFirstElement, String mofIdOfSecondElement, String mofIdOfMetaObject ) {

        addLink( mofIdOfSecondElement, lriOfFirstElement, mofIdOfMetaObject, (byte) 1 /* storageEnd */);
    }

    private void addLink( String mofIdOfLocalElement, LRI lriOfExternalElement, String mofIdOfMetaObject, byte storageEnd ) {

        IndexMofId localMofId = this.mofIdFactory.createAndCacheMofId( mofIdOfLocalElement );
        IndexMofId extMofId = this.mofIdFactory.createAndCacheMofId( lriOfExternalElement.getMofId( ) );
        IndexMofId assocMmri = this.mofIdFactory.createAndCacheMofId( mofIdOfMetaObject );
        /*
         * FIXME Remove when core has introduced implicit linking in
         * inconsistency case, reason: the serializer sometimes saves "local:#"
         * for MofIds that are in the same partition
         */
        Object underlyingForRead = this.mofIdToElements.getUnderlyingForRead( extMofId );
        if ( underlyingForRead instanceof IndexModelElement ) {
            if ( ( (IndexModelElement) underlyingForRead ).pri == this.currentPri ) {
                return;
            }
        } else if ( underlyingForRead instanceof Object[] ) {
            Object[] list = (Object[]) underlyingForRead;
            for ( Object entry : list ) {
                if ( ( (IndexModelElement) entry ).pri == this.currentPri ) {
                    return;
                }
            }
        }

        // extract data area name for extMofId
        String extDataArea = null;
        if ( lriOfExternalElement.getDataAreaDescriptor( ).getDataAreaName( ).equals( IndexConstants.MM_DA_NAME ) ) {
            extDataArea = IndexConstants.MM_DA_NAME;
        } else {
            // get real data area name of the partition to index
            extDataArea = this.currentPri.getRealDataAreaName( );
        }

        IndexLinkRecord lr = new IndexLinkRecord( this.currentPri, localMofId, assocMmri, storageEnd, extMofId, extDataArea );

        // add link to index tables
        this.localMofIdToLinkRecords.put( lr );
        this.extMofIdToLinkRecords.put( lr );
        this.currentPriLRs.add( lr );
    }

    public IndexModelElement addElement( IndexParserElementImpl element ) {

        IndexMofId idMof = this.mofIdFactory.createMofId( element.get___MofId( ) );
        IndexMofId mmMofId = this.mofIdFactory.createAndCacheMofId( element.get___Type( ).get___MofId( ) );

        IndexModelElement me = this.addElementInternal( idMof, mmMofId );
        return me;
    }

    protected IndexModelElement addElementInternal( IndexMofId idMof, IndexMofId mmMofId ) {

        IndexModelElement me = null;

        if ( mmMofId == this.elementPackageMofId && this.isCurrentPartitionMetamodel ) {
            me = new IndexNamedModelElement( idMof, mmMofId, this.currentPri, null /* packageName */);
            this.topLevelPackages.put( (IndexNamedModelElement) me );
        } else {
            me = new IndexModelElement( idMof, mmMofId, this.currentPri );
        }

        this.mofIdToElements.put( me );
        this.typeToInstances.put( me );
        this.currentPriMEs.add( me );

        return me;
    }

    public void addAttribute( IndexParserElementImpl element, String attributeName, Object value ) {

        // do nothing for standard index
    }

    /* #################### IndexManagement Interface ################# */

    public synchronized IndexingAction indexPartition( PRI pri, SpiPartitionStreamProvider streamProvider, long timestamp, boolean forced ) {

        this.aquireWriteLock( );
        try {
            return this.indexPartitionMofRomAware( pri, streamProvider, timestamp, forced, null );
        } finally {
            try {
                // do this here and not in indexPartitionInternal to avoid condense after each partition in synchronize()
                this.typeToInstances.condense( );
            } finally {
                this.releaseWriteLock( );
            }
        }
    }

    protected IndexParserCallbackImpl createParserCallback( PRI pri ) {

        return new IndexParserCallbackImpl( this.partitionSerializationManager, this, this.metamodelService, pri, true /* indexMode */);
    }

    protected void rollbackIndexPartitionInternal( IndexPri idxPri ) {

        // its necessary to flush the cache since removePartition() relies on consistent index tables
        this.flushCurrentIndexBuffers( );

        // be sure all current states are reseted before we remove the partition
        this.currentPri = null;
        this.currentPriMEs = null;
        this.isCurrentPartitionMetamodel = false;

        this.removePartitionInternal( idxPri );
    }

    protected void flushCurrentIndexBuffers( ) {

        if ( this.currentPriMEs != null ) {
            this.currentPriMEs.store( );
        }
        if ( this.currentPriLRs != null ) {
            this.currentPriLRs.store( );
        }
    }

    protected IndexingAction indexPartitionMofRomAware( PRI pri, SpiPartitionStreamProvider streamProvider, long timestamp, boolean force, SyncContext syncContext ) {

        IndexingAction result;

        this.aquireWriteLock( );
        try {
            IndexPri idxPri = this.priToIndexPri.get( pri.toString( ) );

            switch ( result = this.determineOperationOnTimestamp( idxPri, timestamp, force ) ) {
                case UPDATED:
                    if ( syncContext != null ) { // idxPri == null check done during operation determination
                        syncContext.addToDeactivate( idxPri );
                    } else {
                        if ( this.removePartitionInternal( idxPri ) == IndexingAction.EXCEPTION ) {
                            result = IndexingAction.EXCEPTION;
                            break;
                        }
                    }
                case ADDED:
                    InputStream is = this.getStream( streamProvider, pri );
                    if ( is == null ) {
                        result = IndexingAction.EXCEPTION;
                        break;
                    }
                    idxPri = this.createIndexPri( pri, timestamp );
                    if ( syncContext != null ) {
                        idxPri.deactivate( );
                    }

                    long t = System.nanoTime( );
                    if ( !this.addPartitionInternal( idxPri, is ) ) {
                        result = IndexingAction.EXCEPTION;
                        break;
                    }
                    if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                        t = ( System.nanoTime( ) - t ) / 1000000;
                        switch ( result ) {
                            case UPDATED_EH:
                                // TODO extent jmx interface for eh
                            case UPDATED:
                                this.jmxAdapter.indexUpdate( pri, t );
                                break;
                            case ADDED_EH:
                                // TODO extent jmx interface for eh
                            case ADDED:
                                this.jmxAdapter.indexAdd( pri, t );
                                break;
                            default:
                        }
                    }

                    // change result if error handler was active
                    if ( idxPri.isDifferentFromPersistence( ) ) {
                        switch ( result ) {
                            case ADDED:
                                result = IndexingAction.ADDED_EH;
                                break;
                            case UPDATED:
                                result = IndexingAction.UPDATED_EH;
                                break;
                            default:
                                throw new IndexBugException( IndexMessages.UNEXPECTED_INDEXING_ACTION, result );
                        }
                    }

                    if ( syncContext != null ) {
                        syncContext.addToActivate( idxPri );
                    } else {
                        this.addIndexPriToTables( idxPri );
                    }
                    break;
                case NOP:
                    break;
                default:
                    throw new IndexBugException( IndexMessages.UNEXPECTED_INDEXING_ACTION, result );
            }

            // check if mofrom has been injected during indexing
            // do not catch exceptions since failures are critical errors
            this.processQueuedMofRomInjection( );

        } finally {
            this.releaseWriteLock( );
        }
        return result;
    }

    private InputStream getStream( SpiPartitionStreamProvider streamProvider, PRI pri ) {

        InputStream is = null;
        try { // FIXME getPartitionStream has to return EITHER null OR throw an exception if it cannot return a stream
            is = streamProvider.getPartitionStream( pri );
            if ( is == null ) {
                this.trace( MoinSeverity.WARNING, IndexConstants.STREAM_UNAVAILABLE, pri.toString( ) );
            }
        } catch ( Exception e ) {
            this.trace( e, MoinSeverity.WARNING, IndexConstants.STREAM_UNAVAILABLE, pri.toString( ) );
        }
        return is;
    }

    protected void processQueuedMofRomInjection( ) {

        if ( this.queuedMofPartitionsToIndex != null ) {
            for ( IndexQueueEntry entry : this.queuedMofPartitionsToIndex ) {
                try {
                    this.indexMofRomPartitionInternal( entry.content, entry.timestamp );
                } catch ( Exception e ) {
                    e.printStackTrace( );
                }
            }
            this.queuedMofPartitionsToIndex = null;
        }
    }

    protected boolean addPartitionInternal( IndexPri idxPri, InputStream partitionStream ) {

        assert idxPri != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert partitionStream != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        boolean succeeded = false;

        // remember partition type for partition reader callbacks
        this.isCurrentPartitionMetamodel = idxPri.isMetaModelPartition( );

        // remember current pri for partition reader callbacks
        this.currentPri = idxPri;

        // start parsing the partition file
        try {
            this.currentPriMEs = this.priToElements.getUnderlyingForChangeOrCreate( this.currentPri );
            this.currentPriLRs = this.priToLinkRecords.getUnderlyingForChangeOrCreate( this.currentPri );

            IndexParserCallbackImpl callback = this.createParserCallback( idxPri.getCachedPri( ) );
            this.partitionSerializationManager.parse( idxPri.getCachedPri( ), partitionStream, callback, -1 );
            if ( callback.isErrorHandled( ) ) {
                idxPri.setDiffersFromPersistence( );
            }

            this.flushCurrentIndexBuffers( );

            succeeded = true;
        } catch ( IOException e ) {
            this.trace( e, MoinSeverity.WARNING, IndexConstants.PARSING_ERROR, idxPri.getPriString( ) );

            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                this.jmxAdapter.indexError( idxPri.getCachedPri( ), e );
            }

            this.rollbackIndexPartitionInternal( this.currentPri );
        } finally {
            this.closeStream( partitionStream );

            this.currentPri = null;
            this.currentPriMEs = null;
            this.currentPriLRs = null;
            this.isCurrentPartitionMetamodel = false;

            this.isIndexChanged = true;
        }

        return succeeded;
    }

    protected void aquireWriteLock( ) {

        this.rwLock.writeLock( ).lock( );
    }

    protected void releaseWriteLock( ) {

        this.rwLock.writeLock( ).unlock( );
    }

    private IndexingAction determineOperationOnTimestamp( IndexPri idxPri, long timestamp, boolean forced ) {

        IndexingAction result = IndexingAction.ADDED;

        if ( idxPri != null ) {
            if ( idxPri.getTimestamp( ) != timestamp || forced ) {
                result = IndexingAction.UPDATED;
            } else {
                result = IndexingAction.NOP;
            }
        }

        return result;
    }

    public void indexMofRomPartition( SpiMofRomPartitionContent mofRomContent, long timestamp ) {

        this.aquireWriteLock( );
        try {
            // check if we are currently indexing a partition from file. This may be the case
            // if OCL is required during indexing the file and needs to be injected.
            if ( this.currentPri != null ) {
                // no synchronization necessary since only accessible in same thread (due to index lock)
                IndexQueueEntry entry = new IndexQueueEntry( mofRomContent, timestamp );
                if ( this.queuedMofPartitionsToIndex == null ) {
                    this.queuedMofPartitionsToIndex = new ArrayList<IndexQueueEntry>( );
                }
                this.queuedMofPartitionsToIndex.add( entry );
            } else {
                this.indexMofRomPartitionInternal( mofRomContent, timestamp );
            }
        } finally {
            this.releaseWriteLock( );
        }
    }

    protected void indexMofRomPartitionInternal( SpiMofRomPartitionContent content, long timestamp ) {

        PRI pri = content.getPri( );
        this.checkNestedIndexing( pri );

        IndexPri idxPri = this.priToIndexPri.get( pri.toString( ) );

        switch ( this.determineOperationOnTimestamp( idxPri, timestamp, false ) ) {
            case UPDATED:
                this.removePartitionInternal( idxPri );
            case ADDED:
                idxPri = this.createIndexPri( pri, timestamp );
                this.addIndexPriToTables( idxPri );
                this.addMofRomPartitionInternal( idxPri, content );
                break;
            default:
                // nothing
        }
    }

    protected void addMofRomPartitionInternal( IndexPri idxPri, SpiMofRomPartitionContent content ) {

        try {
            long t = 0;
            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                t = System.nanoTime( );
            }

            this.addElements( idxPri, content.getLinks( ), content.getElements( ), Collections.EMPTY_LIST, content.getElements( ).size( ) );
            this.addLinks( idxPri, content.getLinks( ) );

            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                t = ( System.nanoTime( ) - t ) / 1000000;
                this.jmxAdapter.indexAdd( idxPri.getCachedPri( ), t );
            }

            this.isIndexChanged = true;
        } catch ( RuntimeException re ) {
            this.rollbackIndexPartitionInternal( idxPri );
            throw re;
        } finally {
            this.typeToInstances.condense( );
        }
    }

    public final synchronized IndexingAction indexPartition( PRI pri, SpiPartitionDelta delta, long timestamp ) {

        this.aquireWriteLock( );
        try {
            return this.indexPartitionInternal( pri, delta, timestamp );
        } finally {
            this.releaseWriteLock( );
        }
    }

    protected IndexingAction indexPartitionInternal( PRI pri, SpiPartitionDelta delta, long timestamp ) {

        this.checkNestedIndexing( pri );

        assert pri != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        IndexingAction resAction;
        IndexPri idxPri = null;
        try {
            if ( ( idxPri = this.priToIndexPri.get( pri.toString( ) ) ) != null ) {
                resAction = IndexingAction.UPDATED;
                idxPri.setTimestamp( timestamp );
            } else {
                resAction = IndexingAction.ADDED;
                idxPri = this.createIndexPri( pri, timestamp );
                this.addIndexPriToTables( idxPri );
            }
            this.trace( MoinSeverity.DEBUG, IndexConstants.INDEXING_STATS, resAction, pri, null );

            long t = 0;
            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                t = System.nanoTime( );
            }

            this.removeLinks( idxPri, delta.getRemovedLinks( ) );
            Set<Partitionable> assignedElements = delta.getAssignedElements( ).keySet( );
            Collection<Partitionable> createdElements = delta.getCreatedElements( );
            int sizeAdd = createdElements.size( ) + assignedElements.size( );
            this.addElements( idxPri, delta.getPartition( ).getLinks( ), createdElements, assignedElements, sizeAdd );
            this.addLinks( idxPri, delta.getAddedLinks( ) );
            this.addLinks( idxPri, delta.getAssignedLinks( ).keySet( ) );
            // element changes
            this.removeElements( idxPri, delta.getPartition( ), delta.getDeletedElements( ), delta.getUnassignedElements( ).keySet( ) );

            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                t = ( System.nanoTime( ) - t ) / 1000000;
                if ( resAction == IndexingAction.UPDATED ) {
                    this.jmxAdapter.indexUpdate( idxPri.getCachedPri( ), t );
                } else {
                    this.jmxAdapter.indexAdd( idxPri.getCachedPri( ), t );
                }
            }

            this.isIndexChanged = true;

        } finally {
            this.typeToInstances.condense( );
        }

        return resAction;
    }

    public boolean isPartitionIndexed( PRI pri ) {

        // input check
        assert pri != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        this.rwLock.readLock( ).lock( );
        try {
            return this.priToIndexPri.containsKey( pri.toString( ) );
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
    }

    public final SyncTicket synchronizeInactive( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor deletionScope ) {

        return this.synchronizeInactiveLocked( toIndex, timestamps, streamProvider, forced, deletionScope.getDataAreaName( ), null, null );
    }

    public final SyncTicket synchronizeInactive( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, CRI deletionScope ) {

        return this.synchronizeInactiveLocked( toIndex, timestamps, streamProvider, forced, deletionScope.getDataAreaDescriptor( ).getDataAreaName( ), deletionScope.getContainerName( ), null );
    }

    public final SyncTicket synchronizeInactive( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor dataArea, PRI[] toDelete ) {

        return this.synchronizeInactiveLocked( toIndex, timestamps, streamProvider, forced, dataArea.getDataAreaName( ), null, toDelete );
    }

    public final synchronized void activate( SyncTicket ticket ) {

        this.aquireWriteLock( );
        try {
            this.activateInternal( ticket );
        } finally {
            this.releaseWriteLock( );
        }
    }

    protected void activateInternal( SyncTicket ticket ) {

        getContext( ticket ).activate( );
    }

    public final synchronized void deactivate( SyncTicket ticket ) {

        this.aquireWriteLock( );
        try {
            this.deactivateInternal( ticket );
        } finally {
            this.releaseWriteLock( );
        }
    }

    protected void deactivateInternal( SyncTicket ticket ) {

        getContext( ticket ).deactivate( );
    }

    public synchronized SyncReport finalizeInactiveSync( SyncTicket ticket ) {

        return this.cleanupInactivePartitions( ticket );
    }

    protected SyncReport cleanupInactivePartitions( SyncTicket ticket ) {

        SyncContext syncContext = getContext( ticket );
        SyncReport syncReport = syncContext.getSyncReport( );

        IndexingAction delOp;
        for ( IndexPri idxPri : syncContext.getInactive( ) ) {
            this.aquireWriteLock( );
            try {
                delOp = this.removePartitionInternal( idxPri );
            } finally {
                this.releaseWriteLock( );
            }
            if ( delOp == IndexingAction.EXCEPTION ) {
                // FIXME signal someone that some things are still inactive!
            }
        }
        if ( !syncContext.isActivated( ) ) {
            ArrayList<PRI> nop = new ArrayList<PRI>( syncContext.toIndex.length + syncContext.toDelete.length );
            for ( PRI pri : syncContext.toIndex ) {
                nop.add( pri );
            }
            for ( PRI pri : syncContext.toDelete ) {
                nop.add( pri );
            }
            syncReport = new SyncReport( null, null, null, null, nop, null, null );
        }
        syncContext.invalidate( );

        return syncReport;
    }

    private static SyncContext getContext( SyncTicket ticket ) {

        SyncContext context;
        if ( ticket instanceof SyncContext ) { // TODO really necessary?
            if ( !( context = (SyncContext) ticket ).isValid( ) ) {
                throw new MoinIllegalArgumentException( IndexMessages.TICKET_INVALID );
            }
        } else {
            throw new MoinIllegalArgumentException( IndexMessages.NO_INDEX_TICKET );
        }
        return context;
    }

    public final SyncReport synchronize( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor deletionScope ) {

        return this.synchronizeLocked( toIndex, timestamps, streamProvider, forced, deletionScope.getDataAreaName( ), null, null );
    }

    public final SyncReport synchronize( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, CRI deletionScope ) {

        return this.synchronizeLocked( toIndex, timestamps, streamProvider, forced, deletionScope.getDataAreaDescriptor( ).getDataAreaName( ), deletionScope.getContainerName( ), null );
    }

    public final SyncReport synchronize( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor dataArea, PRI[] toDelete ) {

        return this.synchronizeLocked( toIndex, timestamps, streamProvider, forced, dataArea.getDataAreaName( ), null, toDelete );
    }

    protected synchronized SyncReport synchronizeLocked( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, String dataAreaName, String containerName, PRI[] toDelete ) {

        this.rwLock.writeLock( ).lock( );
        try {
            return this.synchronizeInternal( toIndex, timestamps, streamProvider, forced, dataAreaName, containerName, toDelete, null );
        } finally {
            this.rwLock.writeLock( ).unlock( );
        }
    }

    private static final PRI[] NO_PRIS = new PRI[0];

    private final synchronized SyncTicket synchronizeInactiveLocked( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, String dataAreaName, String containerName, PRI[] toDelete ) {

        SyncContext syncContext = new SyncContext( toIndex, toDelete == null ? NO_PRIS : toDelete );
        SyncReport syncReport = this.synchronizeInternal( toIndex, timestamps, streamProvider, forced, dataAreaName, containerName, toDelete == null ? NO_PRIS : toDelete, syncContext );
        syncContext.setSyncReport( syncReport );
        return syncContext;
    }

    protected SyncReport synchronizeInternal( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, String dataAreaName, String containerName, PRI[] toDelete, SyncContext syncContext ) {

        // input checks
        assert toIndex != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert timestamps != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert streamProvider != null || toIndex.length == 0 : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert dataAreaName != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert toIndex.length == timestamps.length : format( IndexConstants.UNEQUAL_LENGTH_PRI_AND_TIMESTAMPS, toIndex.length, timestamps.length );

        this.trace( MoinSeverity.DEBUG, IndexConstants.SYNCHRONIZE_INDEX_STATS, toIndex.length, dataAreaName, containerName );

        List<PRI> added = null;
        List<PRI> added_eh = null;
        List<PRI> updated = null;
        List<PRI> updated_eh = null;
        List<PRI> deleted = null;
        List<PRI> nop = null;
        List<PRI> error = null;

        try {

            // first delete all obsolete partitions ...
            Collection<IndexPri> delIdxPris = null;

            // determine what partitions to delete
            if ( toDelete == null || toDelete == NO_PRIS ) {
                Collection<IndexPri> availIdxPris = this.getIndexPrisInScope( dataAreaName, containerName, false );
                delIdxPris = this.calcPartitionsToRemove( availIdxPris, toIndex );
            } else {
                if ( toDelete.length != 0 ) {
                    delIdxPris = new ArrayList<IndexPri>( toDelete.length );
                    for ( PRI delPri : toDelete ) {
                        IndexPri delIdxPri = this.priToIndexPri.get( delPri.toString( ) );
                        if ( delIdxPri != null ) {
                            delIdxPris.add( delIdxPri );
                        } else {
                            if ( nop == null ) {
                                nop = new ArrayList<PRI>( );
                            }
                            nop.add( delPri );
                        }
                    }
                }
            }

            // delete the partitions
            if ( delIdxPris != null ) {
                if ( syncContext != null ) { // inactive sync: mark partitions to be deleted
                    deleted = new ArrayList<PRI>( delIdxPris.size( ) );
                    for ( IndexPri idxPri : delIdxPris ) {
                        this.removePartitionInactive( idxPri, syncContext );
                        deleted.add( idxPri.getCachedPri( ) );
                    }
                } else { // active sync
                    for ( IndexPri idxPri : delIdxPris ) {
                        IndexingAction action;
                        switch ( action = this.removePartitionInternal( idxPri ) ) {
                            case NOP: {
                                if ( nop == null ) {
                                    nop = new ArrayList<PRI>( );
                                }
                                nop.add( idxPri.getCachedPri( ) );
                                break;
                            }
                            case DELETED: {
                                if ( deleted == null ) {
                                    deleted = new ArrayList<PRI>( delIdxPris.size( ) );
                                }
                                deleted.add( idxPri.getCachedPri( ) );
                                break;
                            }
                            case EXCEPTION: {
                                if ( error == null ) {
                                    error = new ArrayList<PRI>( );
                                }
                                error.add( idxPri.getCachedPri( ) );
                                break;
                            }
                            default:
                                throw new IndexBugException( IndexMessages.UNEXPECTED_REMOVE_RESULT, action );
                        }
                    }
                }
            }

            // ... then update and index the current partitions in file system
            PRI pri = null;
            IndexingAction res;
            for ( int i = 0; i < toIndex.length; i++ ) {
                pri = toIndex[i];
                assert pri != null : IndexConstants.PRIS_CONTAIN_NULL;

                // do the indexing
                res = this.indexPartitionMofRomAware( pri, streamProvider, timestamps[i], forced, syncContext );

                switch ( res ) {
                    case ADDED_EH: {
                        if ( added_eh == null ) {
                            added_eh = new ArrayList<PRI>( );
                        }
                        added_eh.add( pri );
                        // no break
                    }
                    case ADDED: {
                        if ( added == null ) {
                            added = new ArrayList<PRI>( );
                        }
                        added.add( pri );
                        break;
                    }
                    case UPDATED_EH: {
                        if ( updated_eh == null ) {
                            updated_eh = new ArrayList<PRI>( );
                        }
                        updated_eh.add( pri );
                        // no break
                    }
                    case UPDATED: {
                        if ( updated == null ) {
                            updated = new ArrayList<PRI>( );
                        }
                        updated.add( pri );
                        break;
                    }
                    case NOP: {
                        if ( nop == null ) {
                            nop = new ArrayList<PRI>( );
                        }
                        nop.add( pri );
                        break;
                    }
                    case EXCEPTION: {
                        if ( error == null ) {
                            error = new ArrayList<PRI>( );
                        }
                        error.add( pri );
                        break;
                    }
                    default:
                        throw new IndexBugException( IndexMessages.UNEXPECTED_INDEXING_RESULT, res );
                }
            }

            if ( deleted != null || ( nop != null && nop.size( ) != toIndex.length ) ) {
                this.isIndexChanged = true;
            }

        } finally {
            this.typeToInstances.condense( );
        }

        return new SyncReport( added, added_eh, updated, updated_eh, nop, deleted, error );
    }

    protected void removePartitionInactive( IndexPri idxPri, SyncContext context ) {

        context.addToDeactivate( idxPri );
    }

    public long getPartitionTimestamp( PRI pri ) {

        this.rwLock.readLock( ).lock( );
        try {
            IndexPri idxPri = this.priToIndexPri.get( pri.toString( ) );
            if ( idxPri != null ) {
                long ts = idxPri.getTimestamp( );
                return ts;
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
        return -1;
    }

    public final IndexingAction removePartition( PRI thePri ) {

        return this.removePartitionLocked( thePri );
    }

    protected synchronized IndexingAction removePartitionLocked( PRI thePri ) {

        this.aquireWriteLock( );
        try {
            return this.removePartitionInternal( this.priToIndexPri.get( thePri.toString( ) ) );
        } finally {
            this.releaseWriteLock( );
        }
    }

    /**
     * Remove all entities associated with the pri pri from the cache;
     * 
     * @param pri
     */
    protected IndexingAction removePartitionInternal( IndexPri idxPri ) {

        long t = 0;
        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            t = System.nanoTime( );
        }
        IndexingAction result = IndexingAction.NOP;
        if ( idxPri != null ) {
            // check whether we are already indexing a partition
            this.checkNestedIndexing( idxPri.getCachedPri( ) );

            result = IndexingAction.DELETED;
            this.trace( MoinSeverity.DEBUG, IndexConstants.INDEXING_STATS, result, idxPri, null );
            this.doSanityCheck( IndexConstants.SANITY_BEFORE_PARTITION_REMOVE );
            // remove all model elements of this pri.
            Object[] entitiesInPRI = this.priToElements.getUnderlyingForRead( idxPri );
            if ( entitiesInPRI != null ) {
                IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofId2Elements = this.mofIdToElements;
                IdentityHashMap<IndexMofId, Object> treatedTypes = new IdentityHashMap<IndexMofId, Object>( 100 );
                for ( int j = 0; j < entitiesInPRI.length; j++ ) {
                    IndexModelElement me = (IndexModelElement) entitiesInPRI[j];
                    // remove from lri->pri hash
                    Object ml = mofId2Elements.getUnderlyingForChange( me.mofId );
                    if ( ml == null ) {
                        /* not present ? */
                    } else if ( ml instanceof IndexArrayDuplicates ) {
                        IndexArrayDuplicates<IndexModelElement> lst = ( (IndexArrayDuplicates<IndexModelElement>) ml );
                        for ( int i = 0; i < lst.arraySize( ); ++i ) {
                            if ( ( lst.get( i ) ).pri == idxPri ) {
                                mofId2Elements.removeElement( lst.get( i ) );
                            }
                        }
                    } else {
                        IndexModelElement mes = (IndexModelElement) ml;
                        if ( mes.pri == idxPri ) {
                            mofId2Elements.removeElement( mes );
                        }
                    }
                    if ( !treatedTypes.containsKey( me.typeMofId ) ) {
                        treatedTypes.put( me.typeMofId, null );
                        // remove entries in refAllOfClass index
                        IndexArrayFastList<IndexModelElement> mesoftype = this.typeToInstances.getUnderlyingForChange( me.typeMofId );
                        if ( mesoftype != null ) {
                            int len = mesoftype.size( );
                            for ( int i = 0; i < len; ) {
                                IndexModelElement meoftype = mesoftype.get( i );
                                if ( meoftype != null ) {
                                    if ( meoftype.pri == idxPri ) {
                                        mesoftype.remove( i );
                                    } else {
                                        ++i;
                                    }
                                } else {
                                    break;
                                }
                            }
                            mesoftype.store( );
                        }
                    }
                }
            }

            Object[] lirecs = this.priToLinkRecords.getUnderlyingForRead( idxPri );
            if ( lirecs != null ) {
                IndexHashSetTwoKey<IndexLinkRecord> locMofId2Link = this.localMofIdToLinkRecords;
                IndexHashSetTwoKey<IndexLinkRecord> extMofId2Link = this.extMofIdToLinkRecords;

                for ( int j = 0; j < lirecs.length; j++ ) { // O(linksOfPRI)
                    IndexLinkRecord lirec = (IndexLinkRecord) lirecs[j];
                    // cleanup first map
                    IndexArrayTwoKey<IndexLinkRecord> mplr1 = locMofId2Link.getUnderlyingForChange( lirec.mofIdOfLocalEnd, lirec.typeMofId );
                    if ( mplr1 != null ) {
                        for ( int i = 0; i < mplr1.size( ); ) {
                            IndexLinkRecord lr = mplr1.get( i );
                            if ( lr != null ) {
                                if ( lr.idxPri == idxPri ) {
                                    mplr1.remove( i );
                                } else {
                                    ++i;
                                }
                            } else {
                                throw new IndexBugException( IndexMessages.NULL_VALUE_IN_LOC_TABLE );
                            }
                        }
                        mplr1.store( );
                    }
                    IndexArrayTwoKey<IndexLinkRecord> mplr2 = extMofId2Link.getUnderlyingForChange( lirec.mofIdOfExternalEnd, lirec.typeMofId );
                    if ( mplr2 != null ) {
                        for ( int i = 0; i < mplr2.size( ); ) {
                            IndexLinkRecord lr = mplr2.get( i );
                            if ( lr != null ) {
                                if ( lr.idxPri == idxPri ) {
                                    mplr2.remove( i );
                                } else {
                                    ++i;
                                }
                            } else {
                                throw new IndexBugException( IndexMessages.NULL_VALUE_IN_EXT_TABLE );
                            }
                        }
                        mplr2.store( );
                    }
                }
            }
            this.priToLinkRecords.removeAllElements( idxPri );
            this.priToElements.removeAllElements( idxPri );

            // check if there is a top level package (in case of metamodel)
            if ( idxPri.isMetaModelPartition( ) ) {
                for ( Iterator<IndexNamedModelElement> it = this.topLevelPackages.values( ).iterator( ); it.hasNext( ); ) {
                    IndexNamedModelElement value = it.next( );
                    if ( value.pri == idxPri ) {
                        this.topLevelPackages.removeElement( value );
                    }
                }
            }

            this.daToDcsToIndexPris.removeElement( idxPri );
            this.removeIndexPriFromTables( idxPri );
            this.doSanityCheck( IndexConstants.SANITY_AFTER_PARTITION_REMOVE );

            this.isIndexChanged = true;
        }
        if ( JMX_ENABLED && this.jmxNotificationsEnabled && idxPri != null ) {
            t = ( System.nanoTime( ) - t ) / 1000000;
            this.jmxAdapter.indexDelete( idxPri, t );
        }
        return result;

    }

    /* ############### Private logging method ############# */

    private static String format( String message, Object... args ) {

        return MessageFormat.format( message, args );
    }

    private void trace( MoinSeverity severity, String message, Object... args ) {

        if ( this.LOGGER.isTraced( severity ) ) {
            this.LOGGER.trace( severity, message, args );
        }
    }

    private void trace( Throwable t, MoinSeverity severity, String message, Object... args ) {

        if ( this.LOGGER.isTraced( severity ) ) {
            this.LOGGER.trace( t, severity, message, args );
        }
    }

    /* ################# IndexBasicQueryInternal Interface ############ */
    public Set<PRI> getLinkedPartitions( SpiFacilityQueryClientScope queryClientScope, PRI fromPRI, MRI association ) {

        // input check
        assert queryClientScope != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert association != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        IndexMofId assocMofId = this.mofIdFactory.getMofId( association.getMofId( ) );
        if ( assocMofId == null || !this.isInScope( queryClientScope, fromPRI ) ) {
            return Collections.emptySet( );
        }

        Set<PRI> result = null;
        // obtain read lock
        this.rwLock.readLock( ).lock( );
        try {
            IndexPri fromIdxPri = this.priToIndexPri.get( fromPRI.toString( ) );
            Object[] lrs = this.priToLinkRecords.getUnderlyingForRead( fromIdxPri );
            boolean found = false;
            if ( lrs != null ) {
                for ( int i = 0; i < lrs.length; ++i ) {
                    IndexLinkRecord lr = (IndexLinkRecord) lrs[i];
                    if ( lr.typeMofId == assocMofId ) {
                        if ( this.isInClientSpecScope( queryClientScope.getQueryClientScope( ), lr.dataAreaOfExternalEnd ) ) {
                            IndexMofId extMofId = lr.mofIdOfExternalEnd;
                            found = false;
                            Object resEntitys = this.mofIdToElements.getUnderlyingForRead( extMofId );
                            if ( resEntitys instanceof IndexModelElement ) {
                                IndexModelElement resEntity = (IndexModelElement) resEntitys;
                                if ( !( resEntity.pri == fromIdxPri ) ) {
                                    IndexPri idxPri = resEntity.pri;
                                    if ( idxPri.getDataAreaName( ) == lr.dataAreaOfExternalEnd && this.isInPartitionScope( queryClientScope, idxPri.getCachedPri( ) ) ) { //$JL-STRING$
                                        if ( result == null ) {
                                            result = new HashSet<PRI>( this.priToIndexPri.size( ) >> 2 );
                                        }
                                        result.add( idxPri.getCachedPri( ) );
                                        found = true;
                                    }
                                }
                            } else if ( resEntitys instanceof Object[] ) { // array
                                Object[] resEntities = (Object[]) resEntitys;
                                for ( int k = 0; k < resEntities.length; k++ ) {
                                    IndexModelElement resEntity = (IndexModelElement) resEntities[k];
                                    if ( resEntity != null && ( !( resEntity.pri == fromIdxPri ) ) ) {
                                        IndexPri idxPri = resEntity.pri;
                                        if ( idxPri.getDataAreaName( ) == lr.dataAreaOfExternalEnd && this.isInPartitionScope( queryClientScope, idxPri.getCachedPri( ) ) ) { //$JL-STRING$
                                            if ( result == null ) {
                                                result = new HashSet<PRI>( this.priToIndexPri.size( ) >> 2 );
                                            }
                                            result.add( idxPri.getCachedPri( ) );
                                            found = true;
                                        }
                                    }
                                }
                            }
                            if ( !found ) {
                                this.trace( MoinSeverity.WARNING, IndexConstants.FOUND_DANGLING_LINK_IN_PARTITION, lr );
                            }
                        }
                    }
                }
            }
        } finally {
            // release read lock
            this.rwLock.readLock( ).unlock( );
        }

        if ( result == null ) {
            return Collections.emptySet( );
        }
        return result;

    }

    public Set<PRI> getPartitionsOfInstances( SpiFacilityQueryClientScope queryClientScope, MRI[] mofClasses ) {

        // input check
        assert queryClientScope != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert mofClasses != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        Set<PRI> res = null;

        // obtain read lock
        this.rwLock.readLock( ).lock( );
        try {
            // return all partitions in scope if type scope is empty
            if ( mofClasses.length == 0 ) {
                if ( !queryClientScope.isPartitionScopeInclusive( ) ) {
                    // obtain all PRIs and remove the ones from the partition scope
                    res = new HashSet<PRI>( );
                    Set<PRI> partitionScope = queryClientScope.getPartitionsScope( );
                    for ( IndexPri idxPri : this.priToIndexPri.values( ) ) {
                        PRI pri = idxPri.getCachedPri( );
                        if ( !partitionScope.contains( pri ) ) {
                            res.add( pri );
                        }
                    }
                } else {
                    res = queryClientScope.getPartitionsScope( );
                }
            } else {
                res = new HashSet<PRI>( );
                for ( int i = 0; i < mofClasses.length; ++i ) {
                    IndexMofId mmri = this.mofIdFactory.getMofId( mofClasses[i].getMofId( ) );
                    IndexArrayFastList<IndexModelElement> instances = this.typeToInstances.getUnderlyingForRead( mmri );
                    if ( instances != null ) {
                        for ( int j = 0; j < instances.size( ); j++ ) {
                            IndexPri imp = instances.get( j ).pri;
                            if ( this.isInScope( queryClientScope, imp ) ) {
                                res.add( imp.getCachedPri( ) );
                            }
                        }
                    }
                }
            }

        } finally {
            this.rwLock.readLock( ).unlock( );
        }

        return res;
    }

    public List<MRI> getInstances( SpiFacilityQueryClientScope queryClientScope, MRI[] mofClasses ) {

        // input check
        assert mofClasses != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert queryClientScope != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        List<MRI> res;

        // obtain read lock
        this.rwLock.readLock( ).lock( );
        try {
            // return all instances of all partitions in scope if type scope is empty
            if ( mofClasses.length == 0 ) {
                // ... but throw exception if query client scope is exclusive (prevent returning the whole repository)
                if ( !queryClientScope.isPartitionScopeInclusive( ) ) {
                    throw new MoinIllegalArgumentException( IndexMessages.EXCLUSIVE_SCOPE_NOT_ALLOWED );
                } else {
                    res = this.getElementsInPartitions( queryClientScope.getQueryClientScope( ), queryClientScope.getPartitionsScope( ) );
                }
            } else {
                res = new ArrayList<MRI>( );
                for ( int i = 0; i < mofClasses.length; ++i ) {
                    IndexMofId mmri = this.mofIdFactory.getMofId( mofClasses[i].getMofId( ) );
                    IndexArrayFastList<IndexModelElement> instances = this.typeToInstances.getUnderlyingForRead( mmri );
                    if ( instances != null ) {
                        for ( int j = 0; j < instances.size( ); j++ ) {
                            IndexModelElement ime = instances.get( j );
                            if ( this.isInScope( queryClientScope, ime.pri ) ) {
                                res.add( ime.getMri( ) );
                            }
                        }
                    }
                }
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }

        return res;
    }

    /* ################## Query Interfaces ################# */

    public Collection<PRI> getPartitionsInContainer( ClientSpec clientSpecs, CRI cri ) {

        return this.getPartitionsInContainer( cri );
    }

    public Collection<PRI> getPartitionsInContainer( CRI cri ) {

        ArrayList<PRI> result = null;
        // obtain read lock
        this.rwLock.readLock( ).lock( );
        try {

            Collection<IndexPri> idxPris = this.getIndexPrisInScope( cri.getDataAreaDescriptor( ).getDataAreaName( ), cri.getContainerName( ), true );
            if ( idxPris == null ) {
                return Collections.emptyList( );
            }

            result = new ArrayList<PRI>( idxPris.size( ) );
            for ( IndexPri idxPri : idxPris ) {
                result.add( idxPri.getCachedPri( ) );
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }

        return result;
    }

    public Collection<MRI> getReferringElementsForEndAndMetaobject( ClientSpec[] clientSpecs, MRI association, MRI fromElement, int fromEnd ) {

        // input check
        assert association != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert fromElement != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert fromEnd >= 0 && fromEnd <= 1 : format( IndexConstants.FROM_END_OUT_OF_RANGE, fromEnd );
        assert clientSpecs != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        IndexMofId fromMofId = this.mofIdFactory.getMofId( fromElement.getMofId( ) );
        if ( fromMofId == null ) {
            return Collections.emptyList( );
        }
        IndexMofId assocMofId = this.mofIdFactory.getMofId( association.getMofId( ) );
        if ( assocMofId == null ) {
            return Collections.emptyList( );
        }

        List<MRI> resExt = null;

        // obtain read lock
        this.rwLock.readLock( ).lock( );
        try {
            String fromDaName = fromElement.getDataAreaDescriptor( ).getDataAreaName( );
            if ( fromEnd == 0 ) { // was 1, 0 ( historically ! )
                resExt = this.otherEndIndexMEPresentExt( clientSpecs, fromMofId, fromDaName, assocMofId, (byte) 1 ); // LRI2
            }
            if ( fromEnd == 1 ) {
                resExt = this.otherEndIndexMEPresentExt( clientSpecs, fromMofId, fromDaName, assocMofId, (byte) 0 ); // LRI2
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }

        Collection<MRI> result = null;
        if ( resExt == null ) {
            result = Collections.emptyList( );
        } else {
            result = resExt;
        }

        return result;
    }

    public PRI getPriForLri( ClientSpec[] clientSpecs, LRI lri ) {

        // input check
        assert lri != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        // obtain read lock
        this.rwLock.readLock( ).lock( );
        try {
            return this.getPriForLriInternal( lri );
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
    }

    protected PRI getPriForLriInternal( LRI lri ) {

        PRI ret = null;

        String lriDaName = lri.getDataAreaDescriptor( ).getDataAreaName( );
        Object res = this.mofIdToElements.getUnderlyingForRead( this.mofIdFactory.getMofId( lri.getMofId( ) ) );
        if ( res != null ) {
            if ( res instanceof IndexModelElement ) {
                IndexModelElement ime = (IndexModelElement) res;
                if ( ime.getDataAreaName( ) == lriDaName ) { //$JL-STRING$
                    ret = ime.pri.getCachedPri( );
                }
            } else { // array
                Object[] imes = (Object[]) res;
                List<IndexModelElement> returns = new ArrayList<IndexModelElement>( 2 );
                IndexModelElement ime = null;
                for ( int i = 0; i < imes.length; i++ ) {
                    ime = (IndexModelElement) imes[i];
                    if ( ime.getDataAreaName( ) == lriDaName ) { //$JL-STRING$
                        returns.add( ime );
                    }
                }

                if ( returns.size( ) == 1 ) {
                    ret = returns.get( 0 ).pri.getCachedPri( );
                } else if ( returns.size( ) > 1 ) {
                    ArrayList<MRI> mris = new ArrayList<MRI>( returns.size( ) );
                    for ( IndexModelElement me : returns ) {
                        mris.add( me.getMri( ) );
                    }
                    throw new DuplicateElementException( mris );
                }
            }
        }
        return ret;
    }

    public Collection<PRI> getReferringPartitions( ClientSpec[] clientSpecs, MRI element ) {

        // input checks
        assert element != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;
        assert clientSpecs != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        IndexMofId mofId = this.mofIdFactory.getMofId( element.getMofId( ) );
        if ( mofId == null ) {
            return Collections.emptySet( );
        }

        Set<PRI> result = null;

        this.rwLock.readLock( ).lock( );

        try {
            Set<PRI> resExt = null;
            Object[][] resLst = this.extMofIdToLinkRecords.getUnderlyingForRead( mofId );
            if ( resLst != null ) {
                for ( int i = 0; i < resLst.length; ++i ) {
                    for ( int j = 0; j < resLst[i].length; ++j ) {
                        IndexLinkRecord lr = (IndexLinkRecord) resLst[i][j];
                        for ( int k = 0; k < clientSpecs.length; k++ ) {
                            if ( lr.idxPri.getDataAreaName( ) == clientSpecs[k].getDataArea( ).getDescriptor( ).getDataAreaName( ) ) { //$JL-STRING$
                                Object r1Obj = this.mofIdToElements.getUnderlyingForRead( lr.mofIdOfLocalEnd );
                                if ( r1Obj != null ) {
                                    if ( r1Obj instanceof IndexModelElement ) {
                                        IndexModelElement r1 = (IndexModelElement) r1Obj;
                                        if ( r1.pri == lr.idxPri ) {
                                            if ( resExt == null ) {
                                                resExt = new HashSet<PRI>( 4 );
                                            }
                                            resExt.add( r1.pri.getCachedPri( ) );
                                        }
                                    } else { // ArrayList
                                        Object[] r1l = (Object[]) r1Obj;
                                        for ( int k2 = 0; k2 < r1l.length; k2++ ) {
                                            IndexModelElement r1 = (IndexModelElement) r1l[k2];
                                            if ( r1.pri == lr.idxPri ) {
                                                if ( resExt == null ) {
                                                    resExt = new HashSet<PRI>( 4 );
                                                }
                                                resExt.add( r1.pri.getCachedPri( ) );
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }

            if ( resExt == null ) {
                result = Collections.emptySet( );
            } else {
                result = resExt;
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }

        return result;
    }

    public Map<MRI, String> getTopLevelPackages( ) {

        Map<MRI, String> result = null;

        this.rwLock.readLock( ).lock( );
        try {
            int size = this.topLevelPackages.size( );
            if ( size <= 0 ) {
                result = Collections.emptyMap( );
            } else {
                result = new HashMap<MRI, String>( this.topLevelPackages.size( ) );

                for ( IndexNamedModelElement me : this.topLevelPackages.values( ) ) {
                    if ( this.extMofIdToLinkRecords.getUnderlyingForRead( me.mofId, this.assocContainsMofId ) == null ) {
                        result.put( me.getMri( ), me.name );
                    }
                }
            }
        } finally {
            this.rwLock.readLock( ).unlock( );
        }

        return result;
    }

    public boolean isPartitionExistent( ClientSpec clientSpec, PRI pri ) {

        return this.isPartitionIndexed( pri );
    }

    public boolean hasCrossPartitionLinks( ClientSpec clientSpecOne, PRI onePartition, ClientSpec clientSpecTwo, PRI twoPartition ) {

        if ( onePartition == twoPartition ) {
            return false;
        }

        this.rwLock.readLock( ).lock( );
        try {
            IndexPri source = this.priToIndexPri.get( onePartition.toString( ) );
            IndexPri target = this.priToIndexPri.get( twoPartition.toString( ) );
            if ( source == null || target == null ) {
                return false;
            }
            return this.hasCrossPartitionLinksDirectedInternal( source, target ) || this.hasCrossPartitionLinksDirectedInternal( target, source );
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
    }

    public boolean hasCrossPartitionLink( ClientSpec clientSpecsFrom, PRI partitionFrom, LRI elementTo ) {

        this.rwLock.readLock( ).lock( );
        try {
            /*
             * Iterate over all links in the sourcePartition and check if there
             * is any element with the externalMofId that is located in the
             * targetPartition.
             */
            IndexMofId idxMofId = this.mofIdFactory.getMofId( elementTo.getMofId( ) );
            Object[] links = this.priToLinkRecords.getUnderlyingForRead( this.priToIndexPri.get( partitionFrom.toString( ) ) );
            if ( links != null ) {
                for ( int i = 0; i < links.length; i++ ) {
                    IndexLinkRecord ilr = (IndexLinkRecord) links[i];
                    if ( idxMofId == ilr.mofIdOfExternalEnd && ilr.dataAreaOfExternalEnd == elementTo.getDataAreaDescriptor( ).getDataAreaName( ) ) { //$JL-STRING$
                        return true;
                    }
                }
            }
            return false;
        } finally {
            this.rwLock.readLock( ).unlock( );
        }
    }


    /**
     * Determines if the <code>sourcePartition</code> stores a cross partition
     * link to the <code>targetPartition</code>.
     * 
     * @param sourcePartition
     * @param targetPartition
     * @return
     */
    private boolean hasCrossPartitionLinksDirectedInternal( IndexPri sourcePartition, IndexPri targetPartition ) {

        /*
         * Iterate over all links in the sourcePartition and check if there is
         * any element with the externalMofId that is located in the
         * targetPartition.
         */
        Object[] links = this.priToLinkRecords.getUnderlyingForRead( sourcePartition );
        if ( links != null ) {
            for ( int i = 0; i < links.length; i++ ) {
                IndexLinkRecord ilr = (IndexLinkRecord) links[i];
                IndexMofId mofId = ilr.mofIdOfExternalEnd;
                Object elements = this.mofIdToElements.getUnderlyingForRead( mofId );
                if ( elements != null ) {
                    if ( elements instanceof IndexModelElement ) {
                        if ( ( (IndexModelElement) elements ).pri == targetPartition ) {
                            return true;
                        }
                    } else { // Array
                        Object[] list = (Object[]) elements;
                        for ( int j = 0; j < list.length; j++ ) {
                            if ( ( (IndexModelElement) list[j] ).pri == targetPartition ) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    protected void checkNestedIndexing( PRI partitionToIndex ) {

        if ( this.currentPri != null ) {
            throw new MoinIllegalStateException( IndexMessages.NESTED_INDEXING_NOT_ALLOWED, this.currentPri, partitionToIndex );
        }
    }

    /*
     * ######################################################################
     * ######## METHODS FOR USE IN TESTS ONLY !!!!!!!!!!!!!! ################
     */

    public IndexHashSetTwoKey<IndexPri> getDaToDcToIndexPris( ) {

        return this.daToDcsToIndexPris;
    }

    public IndexHashSetTwoKey<IndexLinkRecord> getExtMofIdToLinkRecords( ) {

        return this.extMofIdToLinkRecords;
    }

    public IndexHashSetTwoKey<IndexLinkRecord> getLocalMofIdToLinkRecords( ) {

        return this.localMofIdToLinkRecords;
    }

    public IndexHashSetDuplicates<IndexModelElement, IndexMofId> getMofIdToElements( ) {

        return this.mofIdToElements;
    }

    public IndexHashSetLists<IndexModelElement> getPriToElements( ) {

        return this.priToElements;
    }

    public IndexHashSetSingle<IndexPri> getPriToIndexPri( ) {

        return this.priToIndexPri;
    }

    public IndexHashSetLists<IndexLinkRecord> getPriToLinkRecords( ) {

        return this.priToLinkRecords;
    }

    public IndexHashSetSingle<IndexNamedModelElement> getTopLevelPackages_( ) {

        return this.topLevelPackages;
    }

    public IndexHashSetFastLists<IndexModelElement> getTypeToInstances( ) {

        return this.typeToInstances;
    }

    public IndexMofIdFactory getMofIdFactory( ) {

        return this.mofIdFactory;
    }

    /*
     * #################################################################
     * ######################### JMX support ###########################
     */

    public ObjectName getObjectName( ) {

        if ( this.objectName == null ) {
            try {
                this.objectName = new ObjectName( MOIN_DOMAIN + "type=Index,moin=" + this.moinId ); //$NON-NLS-1$
            } catch ( MalformedObjectNameException e ) {
                throw new RuntimeException( e );
            } catch ( NullPointerException e ) {
                throw new RuntimeException( e );
            }
        }
        return this.objectName;
    }

    protected static class JmxAdapter extends NotificationBroadcasterSupport implements IndexMBean {

        private static final CompositeType compositeTypeForIndexedPartition;

        static {
            try {
                compositeTypeForIndexedPartition = new CompositeType( "IndexedPartitionInfo", "IndexedPartitionInfo", new String[] { "1: Indexed Elements", "2: Indexed Links" }, new String[] { "1: Indexed Elements", "2: Indexed Links" }, new OpenType[] { SimpleType.INTEGER, SimpleType.INTEGER } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e ); // not expected to occur
            }
        }

        protected final WeakReferenceWithObjectName<IndexImpl> indexRef;

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        protected final ObjectName objectName;

        protected JmxAdapter( IndexImpl index, ObjectName objectName, ReferenceQueue refQueue, boolean notEvaluated ) {

            this.objectName = objectName;
            this.indexRef = new WeakReferenceWithObjectName<IndexImpl>( index, objectName, refQueue );
        }

        JmxAdapter( IndexImpl index, ObjectName objectName, ReferenceQueue refQueue ) {

            this( index, objectName, refQueue, false );
            registerBroadcastingMBean( this, IndexMBean.class, objectName );
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( IndexMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by an Index MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public void startNotifications( ) throws IOException {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                index.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                return index.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                index.jmxNotificationsEnabled = false;
            }
        }

        private void sendIndexNotification( String notificationType, String message, Object userData ) {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                Notification notification = new Notification( notificationType, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void indexError( PRI pri, Exception ex ) {

            this.sendIndexNotification( IndexMBean.INDEX_ERROR, pri.toString( ), SpiJmxHelper.getExceptionAsString( ex ) );
        }

        public void indexAdd( PRI pri, long duration ) {

            this.sendIndexNotification( IndexMBean.INDEX_ADD, pri.toString( ), "Time=" + duration + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        public void indexDelete( IndexPri pri, long duration ) {

            this.sendIndexNotification( IndexMBean.INDEX_DELETE, pri.toString( ), "Time=" + duration + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        public void indexUpdate( PRI pri, long duration ) {

            this.sendIndexNotification( IndexMBean.INDEX_UPDATE, pri.toString( ), "Time=" + duration + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        public String[] getIndexedPartitions( ) throws IOException {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                Object[] keys = index.priToIndexPri.keys( );
                String[] result = new String[keys.length];
                System.arraycopy( keys, 0, result, 0, keys.length );
                Arrays.sort( result );
                return result;
            }
            return null;
        }

        public int getNumberOfIndexedModelElements( ) {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                return index.getPriToElements( ).totalSize( );
            }
            return -1;

        }

        public int getNumberOfIndexedLinkRecords( ) {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                return index.getPriToLinkRecords( ).totalSize( );
            }
            return -1;

        }

        @SuppressWarnings( "unchecked" )
        public CompositeData getIndexedPartitionDetails( String priString ) throws IOException {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                String internedPri = priString.intern( );
                IndexPri idxPri = null;
                if ( ( idxPri = index.priToIndexPri.get( internedPri ) ) != null ) {
                    Map map = new HashMap( 4 );
                    Object[] elements = index.priToElements.getUnderlyingForRead( idxPri );
                    map.put( "1: Indexed Elements", ( elements != null ? elements.length : 0 ) ); //$NON-NLS-1$
                    Object[] links = index.priToLinkRecords.getUnderlyingForRead( idxPri );
                    map.put( "2: Indexed Links", ( links != null ? links.length : 0 ) ); //$NON-NLS-1$
                    try {
                        return new CompositeDataSupport( compositeTypeForIndexedPartition, map );
                    } catch ( OpenDataException e ) {
                        return null;
                    }
                }
            }
            return null;
        }

        public String[] getIndexedModelElements( String priString ) throws IOException {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                IndexPri idxPri = index.priToIndexPri.get( priString.intern( ) );
                if ( idxPri != null ) {
                    Object[] elements = index.priToElements.getUnderlyingForRead( idxPri );
                    if ( elements != null ) {
                        String[] result = new String[elements.length];
                        for ( int i = 0, n = elements.length; i < n; i++ ) {
                            IndexModelElement indexModelElement = (IndexModelElement) elements[i];
                            result[i] = indexModelElement.getMri( ).toString( );
                        }
                        Arrays.sort( result );
                        return result;
                    }
                }
            }
            return null;
        }

        public String[] getIndexedLinks( String priString ) throws IOException {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                Object[] links = index.priToLinkRecords.getUnderlyingForRead( index.priToIndexPri.get( priString.intern( ) ) );
                if ( links != null ) {
                    String[] result = new String[links.length];
                    for ( int i = 0, n = links.length; i < n; i++ ) {
                        IndexLinkRecord indexLinkRecord = (IndexLinkRecord) links[i];
                        result[i] = indexLinkRecord.toString( );
                    }
                    Arrays.sort( result );
                    return result;
                }
            }
            return null;
        }

        public boolean doSanityCheck( ) {

            IndexImpl index = this.indexRef.get( );
            if ( index != null ) {
                return index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
            }
            return false;
        }
    }

    /*
     * private classes
     */
    protected static interface LinkList {

        public boolean next( );

        public String getFirstMofId( );

        public String getSecondMofId( );

        public String getTypeMofId( );

        public int getStorageEnd( );
    }

    private static class SpiLinkList implements LinkList {

        private final Collection<SpiLink> linkList;

        private Iterator<SpiLink> iterator = null;

        private SpiLink link = null;

        public SpiLinkList( Collection<SpiLink> links ) {

            this.linkList = links;
        }

        public String getFirstMofId( ) {

            return this.link.getStorageEndMri( ).getMofId( );
        }

        public String getSecondMofId( ) {

            return this.link.getOtherEndLri( ).getMofId( );
        }

        public int getStorageEnd( ) {

            return this.link.getEndNumberOfStorageEnd( );
        }

        public String getTypeMofId( ) {

            return this.link.getMetaObjectMri( ).getMofId( );
        }

        public boolean next( ) {

            if ( iterator == null ) {
                iterator = this.linkList.iterator( );
            }
            if ( iterator.hasNext( ) ) {
                this.link = iterator.next( );
                return true;
            } else {
                return false;
            }
        }
    }

    private static class IndexQueueEntry {

        final SpiMofRomPartitionContent content;

        final long timestamp;

        public IndexQueueEntry( SpiMofRomPartitionContent _content, long timestamp ) {

            this.content = _content;
            this.timestamp = timestamp;
        }
    }

    protected class SyncContext implements SyncTicket {

        private boolean isValid = true;

        private boolean isActivated = false;

        private List<IndexPri> toActivate;

        private List<IndexPri> toDeactivate;

        private SyncReport syncReport;

        private PRI[] toDelete;

        private PRI[] toIndex;

        public SyncContext( PRI[] toIndex, PRI[] toDelete ) {

            this.toIndex = toIndex;
            this.toDelete = toDelete;
        }

        public void addToActivate( IndexPri idxPri ) {

            if ( this.toActivate == null ) {
                this.toActivate = new ArrayList<IndexPri>( );
            }
            this.toActivate.add( idxPri );
        }

        public void addToDeactivate( IndexPri idxPri ) {

            if ( this.toDeactivate == null ) {
                this.toDeactivate = new ArrayList<IndexPri>( );
            }
            this.toDeactivate.add( idxPri );
        }

        public void setSyncReport( SyncReport value ) {

            this.syncReport = value;
        }

        public SyncReport getSyncReport( ) {

            return this.syncReport;
        }

        public void activate( ) {

            if ( !isActivated ) {
                this.flipActive( this.toActivate, this.toDeactivate );
                this.isActivated = true;
            }
        }

        public void deactivate( ) {

            if ( isActivated ) {
                this.flipActive( this.toDeactivate, this.toActivate );
                this.isActivated = false;
            }
        }

        private void flipActive( List<IndexPri> toActivate, List<IndexPri> toDeactivate ) {

            // lists are created lazy, so check for null here
            if ( toDeactivate != null ) {
                for ( IndexPri idxPri : toDeactivate ) {
                    idxPri.deactivate( );
                    IndexImpl.this.removeIndexPriFromTables( idxPri );
                }
            }

            if ( toActivate != null ) {
                for ( IndexPri idxPri : toActivate ) {
                    idxPri.activate( );
                    IndexImpl.this.addIndexPriToTables( idxPri );
                }
            }
        }

        @SuppressWarnings( "unchecked" )
        public List<IndexPri> getInactive( ) {

            if ( isActivated ) {
                return ( this.toDeactivate == null ) ? Collections.EMPTY_LIST : this.toDeactivate;
            } else {
                return ( this.toActivate == null ) ? Collections.EMPTY_LIST : this.toActivate;
            }
        }

        @SuppressWarnings( "unchecked" )
        public List<IndexPri> getActive( ) {

            if ( isActivated ) {
                return ( this.toActivate == null ) ? Collections.EMPTY_LIST : this.toActivate;
            } else {
                return ( this.toDeactivate == null ) ? Collections.EMPTY_LIST : this.toDeactivate;
            }
        }

        public boolean isActivated( ) {

            return this.isActivated;
        }

        public boolean isValid( ) {

            return this.isValid;
        }

        public void invalidate( ) {

            this.isValid = false;
        }
    }
}
