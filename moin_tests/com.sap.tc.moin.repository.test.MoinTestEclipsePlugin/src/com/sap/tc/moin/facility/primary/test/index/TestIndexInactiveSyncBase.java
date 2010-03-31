package com.sap.tc.moin.facility.primary.test.index;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.IndexingAction;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncTicket;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.core.MoinWrapper;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassWrapperImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.PriPatternRegistry;
import com.sap.tc.moin.repository.spi.core.SpiPartitionService;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimIndexQueryService;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.C4;


public abstract class TestIndexInactiveSyncBase extends IndexTestCase {

    protected static final boolean FORCED = true;

    protected static final int ADD = 0;

    protected static final int UPDATE_BEFORE = 1;

    protected static final int UPDATE_AFTER = 2;

    protected static final int DELETE_FOR_BEFORE = 3;

    protected static final int DELETE_FOR_AFTER = 4;

    protected ModelPartition add;

    protected ModelPartition update;

    protected ModelPartition delete;

    protected ModelPartition invisible;

    private Connection transientConnection;

    private CompoundClientSpec transCompoundClientSpec;

    protected C4[] c4s;

    protected MRI[] c4mris;

    protected B4[] b4s;

    protected MRI[] b4mris;

    protected PRI[] pris;

    protected CRI transCri;

    protected ClientSpec[] transClientSpecs;

    protected ClientSpec transClientSpec;

    protected IndexImpl inactiveIndex;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        SpiPartitionService partitionService = ( (MoinWrapper) getTestHelper( ).getMoin( ) ).unwrap( ).getCore( ).getPartitionService( );
        PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
        serializationManager.registerParserSerializer( SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION, new String[] { ".volatile" }, partitionService ); //$NON-NLS-1$
        this.initializeIndex( );
        this.initialize( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.tearDown( );
        this.cleanupIndex( );
        PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
        Field declaredField = PartitionSerializationManagerImpl.class.getDeclaredField( "cpsPatternRegistry" ); //$NON-NLS-1$
        declaredField.setAccessible( true );
        ( (PriPatternRegistry) declaredField.get( serializationManager ) ).remove( "", ".volatile" ); //$NON-NLS-1$//$NON-NLS-2$
        declaredField.setAccessible( false );

        super.afterTestMethod( );
    }

    protected void initialize( ) {

        Moin moin = getTestHelper( ).getMoin( );
        Session transSession = moin.createSession( this.transCompoundClientSpec = getTestHelper( ).getMoin( ).getCompoundDataAreaManager( ).getCompoundClientSpecTransientOnly( ) );
        this.transientConnection = transSession.createConnection( );
        assertNotNull( this.transientConnection );

        this.add = this.createPartition( "inactiveSync_add" );
        this.update = this.createPartition( "inactiveSync_update" );
        this.delete = this.createPartition( "inactiveSync_delete" );
        this.invisible = this.createPartition( "inactiveSync_invisible" );

        this.inactiveIndex.removePartition( add.getPri( ) );
        this.inactiveIndex.removePartition( update.getPri( ) );
        this.inactiveIndex.removePartition( delete.getPri( ) );
        this.inactiveIndex.removePartition( invisible.getPri( ) );

        this.transCri = add.getPri( ).getCri( );
        transClientSpecs = this.transCompoundClientSpec.getClientSpecs( ).toArray( new ClientSpec[this.transCompoundClientSpec.getClientSpecs( ).size( )] );
        for ( ClientSpec cs : transClientSpecs ) {
            if ( cs.getDataArea( ).getDescriptor( ).equals( transCri.getDataAreaDescriptor( ) ) ) {
                transClientSpec = cs;
            }
        }
        assertNotNull( transClientSpec );

        int length = 5;
        PRI[] pris = new PRI[length];
        C4[] cs = new C4[length];
        MRI[] cmris = new MRI[length];
        B4[] bs = new B4[length];
        MRI[] bmris = new MRI[length];

        pris[ADD] = this.add.getPri( );
        pris[UPDATE_BEFORE] = this.update.getPri( );
        pris[UPDATE_AFTER] = this.update.getPri( );
        pris[DELETE_FOR_BEFORE] = this.delete.getPri( );
        pris[DELETE_FOR_AFTER] = this.delete.getPri( );

        bs[ADD] = this.add.createElement( B4.class );
        bs[UPDATE_BEFORE] = this.update.createElement( B4.class );
        bs[UPDATE_AFTER] = this.invisible.createElement( B4.class );
        bs[DELETE_FOR_BEFORE] = this.delete.createElement( B4.class );
        bs[DELETE_FOR_AFTER] = this.delete.createElement( B4.class );

        bmris[UPDATE_BEFORE] = bs[UPDATE_BEFORE].get___Mri( );
        bmris[DELETE_FOR_BEFORE] = bs[DELETE_FOR_BEFORE].get___Mri( );

        cs[ADD] = this.add.createElement( C4.class );
        cs[UPDATE_BEFORE] = this.update.createElement( C4.class );
        cs[UPDATE_AFTER] = this.invisible.createElement( C4.class );
        cs[DELETE_FOR_BEFORE] = this.delete.createElement( C4.class );
        cs[DELETE_FOR_AFTER] = this.delete.createElement( C4.class );

        cmris[UPDATE_BEFORE] = cs[UPDATE_BEFORE].get___Mri( );
        cmris[DELETE_FOR_BEFORE] = cs[DELETE_FOR_BEFORE].get___Mri( );

        cs[ADD].setPrimitive( "c4_add" );
        cs[UPDATE_BEFORE].setPrimitive( "c4_update_before" );
        cs[UPDATE_AFTER].setPrimitive( "c4_update_after" );
        cs[DELETE_FOR_BEFORE].setPrimitive( "c4_delete_before" );
        cs[DELETE_FOR_AFTER].setPrimitive( "c4_delete_after" );

        bs[ADD].setOnePrimitive( "b4_add" );
        bs[UPDATE_BEFORE].setOnePrimitive( "b4_update_before" );
        bs[UPDATE_AFTER].setOnePrimitive( "b4_update_after" );
        bs[DELETE_FOR_BEFORE].setOnePrimitive( "b4_delete_before" );
        bs[DELETE_FOR_AFTER].setOnePrimitive( "b4_delete_after" );

        this.pris = pris;
        this.c4s = cs;
        this.c4mris = cmris;
        this.b4s = bs;
        this.b4mris = bmris;

        // wiring
        cs[ADD].setComplex( bs[UPDATE_AFTER] );
        cs[UPDATE_BEFORE].setComplex( bs[DELETE_FOR_BEFORE] );
        cs[UPDATE_AFTER].setComplex( bs[DELETE_FOR_AFTER] );
        cs[DELETE_FOR_AFTER].setComplex( bs[ADD] );

        assertEquals( IndexingAction.ADDED, this.inactiveIndex.indexPartition( update.getPri( ), getStreamProvider( update ), 20, true ) );
        assertEquals( IndexingAction.ADDED, this.inactiveIndex.indexPartition( delete.getPri( ), getStreamProvider( delete ), 30, true ) );
    }

    protected void tearDown( ) {

        if ( add != null ) {
            this.inactiveIndex.removePartition( add.getPri( ) );
        }
        if ( update != null ) {
            this.inactiveIndex.removePartition( update.getPri( ) );
        }
        if ( delete != null ) {
            this.inactiveIndex.removePartition( delete.getPri( ) );
        }
        if ( invisible != null ) {
            this.inactiveIndex.removePartition( invisible.getPri( ) );
        }
    }

    protected abstract void initializeIndex( );

    protected abstract void cleanupIndex( );


    protected void performUpdate( ) {

        this.invisible.assignElement( c4s[UPDATE_BEFORE] );
        this.invisible.assignElement( b4s[UPDATE_BEFORE] );

        this.update.assignElement( c4s[UPDATE_AFTER] );
        this.update.assignElement( b4s[UPDATE_AFTER] );
    }

    protected void executeTestSyncInactiveDataArea( ) {

        PRI[] syncPris = new PRI[] { add.getPri( ), update.getPri( ) };
        long[] timestamps = new long[] { 11, 21 };

        this.testVisibilityInQueries( false );

        this.performUpdate( );

        SyncTicket ticket = this.inactiveIndex.synchronizeInactive( syncPris, timestamps, getStreamProvider( add, update ), FORCED, add.getPri( ).getDataAreaDescriptor( ) );
        this.testVisibilityInQueries( false );

        this.inactiveIndex.activate( ticket );
        this.testVisibilityInQueries( true );

        SyncReport syncReport = this.inactiveIndex.finalizeInactiveSync( ticket );
        this.testVisibilityInQueries( true );
        assertTrue( syncReport.ADDED.size( ) == 1 );
        assertTrue( syncReport.UPDATED.size( ) == 1 );
        assertTrue( syncReport.DELETED.size( ) == 1 );
        assertTrue( syncReport.EXCEPTION.size( ) == 0 );
        assertTrue( syncReport.NOP.size( ) == 0 );
        assertTrue( syncReport.ADDED.contains( add.getPri( ) ) );
        assertTrue( syncReport.UPDATED.contains( update.getPri( ) ) );
        assertTrue( syncReport.DELETED.contains( delete.getPri( ) ) );
    }

    protected void executeTestSyncInactiveWithoutActivation( ) {

        PRI[] syncPris = new PRI[] { add.getPri( ), update.getPri( ) };
        long[] timestamps = new long[] { 11, 21 };

        this.testVisibilityInQueries( false );

        this.performUpdate( );

        SyncTicket ticket = this.inactiveIndex.synchronizeInactive( syncPris, timestamps, getStreamProvider( add, update ), FORCED, add.getPri( ).getDataAreaDescriptor( ) );
        this.testVisibilityInQueries( false );

        SyncReport syncReport = this.inactiveIndex.finalizeInactiveSync( ticket );
        this.testVisibilityInQueries( false );
        assertTrue( syncReport.ADDED.size( ) == 0 );
        assertTrue( syncReport.UPDATED.size( ) == 0 );
        assertTrue( syncReport.DELETED.size( ) == 0 );
        assertTrue( syncReport.EXCEPTION.size( ) == 0 );
        assertTrue( syncReport.NOP.size( ) == 2 );
        assertTrue( syncReport.NOP.containsAll( Arrays.asList( syncPris ) ) );
    }

    protected void executeTestSyncInactiveActivatedAndDeactivated( ) {

        PRI[] syncPris = new PRI[] { add.getPri( ), update.getPri( ) };
        long[] timestamps = new long[] { 11, 21 };

        this.testVisibilityInQueries( false );

        this.performUpdate( );

        SyncTicket ticket = this.inactiveIndex.synchronizeInactive( syncPris, timestamps, getStreamProvider( add, update ), FORCED, add.getPri( ).getDataAreaDescriptor( ) );
        this.testVisibilityInQueries( false );

        this.inactiveIndex.activate( ticket );
        this.testVisibilityInQueries( true );

        this.inactiveIndex.deactivate( ticket );
        this.testVisibilityInQueries( false );

        SyncReport syncReport = this.inactiveIndex.finalizeInactiveSync( ticket );
        this.testVisibilityInQueries( false );
        assertTrue( syncReport.ADDED.size( ) == 0 );
        assertTrue( syncReport.UPDATED.size( ) == 0 );
        assertTrue( syncReport.DELETED.size( ) == 0 );
        assertTrue( syncReport.EXCEPTION.size( ) == 0 );
        assertTrue( syncReport.NOP.size( ) == 2 );
        assertTrue( syncReport.NOP.containsAll( Arrays.asList( syncPris ) ) );
    }

    protected void testVisibilityInQueries( boolean activated ) {

        SpiCoreQueryService coreQuery = this.inactiveIndex;

        // partitions in container
        Collection<PRI> partitionsInContainer = coreQuery.getPartitionsInContainer( transClientSpec, transCri );
        assertTrue( partitionsInContainer.size( ) == 2 );
        if ( activated ) {
            assertTrue( partitionsInContainer.containsAll( Arrays.asList( add.getPri( ), update.getPri( ) ) ) );
        } else {
            assertTrue( partitionsInContainer.containsAll( Arrays.asList( update.getPri( ), delete.getPri( ) ) ) );
        }

        // get pri for lri
        PRI priForLri;
        priForLri = coreQuery.getPriForLri( transClientSpecs, this.c4s[ADD].get___Mri( ).getLri( ) );
        if ( activated ) {
            assertTrue( priForLri == this.pris[ADD] );
        } else {
            assertNull( priForLri );
        }
        priForLri = coreQuery.getPriForLri( transClientSpecs, this.c4s[UPDATE_AFTER].get___Mri( ).getLri( ) );
        if ( activated ) {
            assertTrue( priForLri == this.pris[UPDATE_AFTER] );
        } else {
            assertNull( priForLri );
        }
        priForLri = coreQuery.getPriForLri( transClientSpecs, this.c4s[UPDATE_BEFORE].get___Mri( ).getLri( ) );
        if ( activated ) {
            assertNull( priForLri );
        } else {
            assertTrue( priForLri == this.pris[UPDATE_BEFORE] );
        }
        priForLri = coreQuery.getPriForLri( transClientSpecs, this.c4s[DELETE_FOR_BEFORE].get___Mri( ).getLri( ) );
        if ( activated ) {
            assertNull( priForLri );
        } else {
            assertTrue( priForLri == this.pris[DELETE_FOR_BEFORE] );
        }

        // get referring elements for end and metaobject
        MRI association;
        {
            RefClass refClass = this.transientConnection.getJmiHelper( ).getRefClassForMofClass( (MofClass) c4s[ADD].refMetaObject( ) );
            refClass = (RefClass) ( (RefClassWrapperImpl) refClass ).unwrap( );
            association = ( (RefClassImpl) refClass ).getAttribute( "complex" ).get___Mri( );
            Collection<MRI> updAfter = coreQuery.getReferringElementsForEndAndMetaobject( transClientSpecs, association, b4s[UPDATE_AFTER].get___Mri( ), 1 );
            Collection<MRI> updBefore = coreQuery.getReferringElementsForEndAndMetaobject( transClientSpecs, association, b4mris[UPDATE_BEFORE], 1 );
            Collection<MRI> delBefore = coreQuery.getReferringElementsForEndAndMetaobject( transClientSpecs, association, b4mris[DELETE_FOR_BEFORE], 1 );
            assertTrue( updBefore.size( ) == 0 );
            if ( activated ) {
                assertTrue( updAfter.size( ) == 1 );
                assertTrue( updAfter.contains( c4s[ADD].get___Mri( ) ) );
                assertTrue( delBefore.size( ) == 0 );
            } else {
                assertTrue( updAfter.size( ) == 0 );
                assertTrue( delBefore.size( ) == 1 );
                assertTrue( delBefore.contains( c4mris[UPDATE_BEFORE] ) );
            }
        }

        // get referring partitions
        {
            Collection<PRI> updBefore = coreQuery.getReferringPartitions( transClientSpecs, b4mris[UPDATE_BEFORE] );
            Collection<PRI> delBefore = coreQuery.getReferringPartitions( transClientSpecs, b4mris[DELETE_FOR_BEFORE] );
            Collection<PRI> updAfter = coreQuery.getReferringPartitions( transClientSpecs, this.b4s[UPDATE_AFTER].get___Mri( ) );
            assertTrue( updBefore.size( ) == 0 );
            if ( activated ) {
                assertTrue( delBefore.size( ) == 0 );
                assertTrue( updAfter.size( ) == 1 );
                assertTrue( updAfter.contains( pris[ADD] ) );
            } else {
                assertTrue( delBefore.size( ) == 1 );
                assertTrue( delBefore.contains( pris[UPDATE_BEFORE] ) );
                assertTrue( updAfter.size( ) == 0 );
            }
        }

        boolean linkAdd = coreQuery.hasCrossPartitionLink( transClientSpec, pris[ADD], b4s[UPDATE_AFTER].get___Mri( ).getLri( ) );
        boolean linkUpdateBefore = coreQuery.hasCrossPartitionLink( transClientSpec, pris[UPDATE_BEFORE], b4s[DELETE_FOR_BEFORE].get___Mri( ).getLri( ) );
        boolean linkUpdateAfter = coreQuery.hasCrossPartitionLink( transClientSpec, pris[UPDATE_AFTER], b4s[DELETE_FOR_AFTER].get___Mri( ).getLri( ) );
        assertTrue( linkAdd == activated );
        assertFalse( linkUpdateBefore == activated );
        assertTrue( linkUpdateAfter == activated );

        // has cross partition links between partitions
        assertTrue( coreQuery.hasCrossPartitionLinks( transClientSpec, pris[UPDATE_AFTER], transClientSpec, pris[ADD] ) == activated );
        assertTrue( coreQuery.hasCrossPartitionLinks( transClientSpec, pris[ADD], transClientSpec, pris[UPDATE_AFTER] ) == activated );
        assertFalse( coreQuery.hasCrossPartitionLinks( transClientSpec, pris[DELETE_FOR_BEFORE], transClientSpec, pris[UPDATE_BEFORE] ) == activated );
        assertFalse( coreQuery.hasCrossPartitionLinks( transClientSpec, pris[UPDATE_BEFORE], transClientSpec, pris[DELETE_FOR_BEFORE] ) == activated );
        assertFalse( coreQuery.hasCrossPartitionLinks( transClientSpec, pris[UPDATE_AFTER], transClientSpec, pris[DELETE_FOR_AFTER] ) == activated );
        assertFalse( coreQuery.hasCrossPartitionLinks( transClientSpec, pris[DELETE_FOR_AFTER], transClientSpec, pris[UPDATE_AFTER] ) == activated );

        // partition visibility check
        boolean availAdd = coreQuery.isPartitionExistent( transClientSpec, add.getPri( ) );
        boolean availUpdate = coreQuery.isPartitionExistent( transClientSpec, update.getPri( ) );
        boolean availDelete = coreQuery.isPartitionExistent( transClientSpec, delete.getPri( ) );
        assertTrue( availAdd == activated );
        assertTrue( availUpdate );
        assertFalse( availDelete == activated );

        /*
         * MQL query interface
         */
        SpiFacilitySlimIndexQueryService mqlQuery = this.inactiveIndex;

        MRI[] bMofClass = new MRI[] { b4s[ADD].refMetaObject( ).get___Mri( ) };
        MRI[] cMofClass = new MRI[] { c4s[ADD].refMetaObject( ).get___Mri( ) };
        SpiFacilityQueryClientScope queryClientScope = this.getQueryClientScope( );

        // get instances
        List<MRI> bInstances = mqlQuery.getInstances( queryClientScope, bMofClass );
        List<MRI> cInstances = mqlQuery.getInstances( queryClientScope, cMofClass );
        if ( activated ) {
            assertTrue( bInstances.size( ) == 2 );
            assertTrue( bInstances.containsAll( Arrays.asList( b4s[ADD].get___Mri( ), b4s[UPDATE_AFTER].get___Mri( ) ) ) );
            assertTrue( cInstances.size( ) == 2 );
            assertTrue( cInstances.containsAll( Arrays.asList( c4s[ADD].get___Mri( ), c4s[UPDATE_AFTER].get___Mri( ) ) ) );
        } else {
            assertTrue( bInstances.size( ) == 3 );
            assertTrue( bInstances.containsAll( Arrays.asList( b4mris[UPDATE_BEFORE], b4mris[DELETE_FOR_BEFORE], b4s[DELETE_FOR_AFTER].get___Mri( ) ) ) );
            assertTrue( cInstances.size( ) == 3 );
            assertTrue( cInstances.containsAll( Arrays.asList( c4mris[UPDATE_BEFORE], c4mris[DELETE_FOR_BEFORE], c4s[DELETE_FOR_AFTER].get___Mri( ) ) ) );
        }

        // partitions of instances
        Set<PRI> bPartitionsOfInstances = mqlQuery.getPartitionsOfInstances( queryClientScope, bMofClass );
        Set<PRI> cPartitionsOfInstances = mqlQuery.getPartitionsOfInstances( queryClientScope, cMofClass );
        assertTrue( bPartitionsOfInstances.size( ) == 2 );
        assertTrue( cPartitionsOfInstances.size( ) == 2 );
        if ( activated ) {
            assertTrue( bPartitionsOfInstances.containsAll( Arrays.asList( pris[ADD], pris[UPDATE_AFTER] ) ) );
            assertTrue( cPartitionsOfInstances.containsAll( Arrays.asList( pris[ADD], pris[UPDATE_AFTER] ) ) );
        } else {
            assertTrue( bPartitionsOfInstances.containsAll( Arrays.asList( pris[DELETE_FOR_BEFORE], pris[UPDATE_BEFORE] ) ) );
            assertTrue( cPartitionsOfInstances.containsAll( Arrays.asList( pris[DELETE_FOR_BEFORE], pris[UPDATE_BEFORE] ) ) );
        }

        // linked partitions
        Set<PRI> addLinkedPartitions = mqlQuery.getLinkedPartitions( queryClientScope, add.getPri( ), association );
        Set<PRI> updLinkedPartitions = mqlQuery.getLinkedPartitions( queryClientScope, update.getPri( ), association );
        Set<PRI> delLinkedPartitions = mqlQuery.getLinkedPartitions( queryClientScope, delete.getPri( ), association );
        if ( activated ) {
            assertTrue( addLinkedPartitions.size( ) == 1 );
            assertTrue( addLinkedPartitions.contains( update.getPri( ) ) );
            assertTrue( updLinkedPartitions.size( ) == 0 );
            assertTrue( delLinkedPartitions.size( ) == 0 );
        } else {
            assertTrue( addLinkedPartitions.size( ) == 0 );
            assertTrue( updLinkedPartitions.size( ) == 1 );
            assertTrue( updLinkedPartitions.contains( delete.getPri( ) ) );
            assertTrue( delLinkedPartitions.size( ) == 0 );
        }
    }

    protected SpiFacilityQueryClientScope getQueryClientScope( ) {

        return new SpiFacilityQueryClientScope( ) {

            public Set<PRI> getPartitionsScope( ) {

                return Collections.emptySet( );
            }

            public ClientSpec[] getQueryClientScope( ) {

                return transClientSpecs;
            }

            public boolean isPartitionScopeInclusive( ) {

                return false;
            }

        };
    }

    private ModelPartition createPartition( String name ) {

        return this.transientConnection.getOrCreateTransientPartition( name );
    }
}
