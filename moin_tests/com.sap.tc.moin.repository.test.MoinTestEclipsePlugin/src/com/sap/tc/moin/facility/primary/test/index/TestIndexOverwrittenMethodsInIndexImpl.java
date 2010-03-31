package com.sap.tc.moin.facility.primary.test.index;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.junit.Staged;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.facility.primary.metamodelmanager.MetaModelPartitionManagerImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexConstants;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.facility.primary.riservice.CheckedResourceIdentifierFactoryImpl;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DuplicateElementException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.core.MoinWrapper;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.core.SpiPartitionService;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsFacility;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.util.SpiDelegator;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;


/**
 * This class is to test the overwritten methods in the {@link IndexImpl} super
 * class used in the build scenario. Generally, the test framework for the index
 * should be parameterized, but this is to much effort for now.
 * 
 * @author D048997
 */
public class TestIndexOverwrittenMethodsInIndexImpl extends IndexTestCase {

    protected IndexImpl query;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        CheckedResourceIdentifierFactoryImpl riFac = (CheckedResourceIdentifierFactoryImpl) SpiDelegator.dismantle( getFacility( ).getRIFactory( ) );

        IndexImpl index = new IndexImpl( PrimaryFacility.FACILITY_ID, "myMoin", getTestHelper( ).getHousekeepingReferenceQueue( ) );
        index.bind( this.getPartitionSerializationManager( ) );
        index.bind( this.getMetamodelService( ) );
        index.initialize( );
        index.finalizeStartup( );
        this.query = index;
        this.deployMetamodels( );
    }

    private SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        // We need to pass 'null' for the 'moin' parameter, otherwise an InstanceAlreadyExistsException will be thrown.
        PartitionSerializationManagerImpl serializationManager = new PartitionSerializationManagerImpl( null /* moin */);
        SpiPartitionService partitionService = ( (MoinWrapper) getTestHelper( ).getMoin( ) ).unwrap( ).getCore( ).getPartitionService( );
        serializationManager.registerParserSerializer( SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION, SpiPartitionSerializationManager.DEFAULT_SUFFIXES, partitionService );
        return serializationManager;
    }

    private SpiMetamodelService getMetamodelService( ) {

        return ( (MoinWrapper) getTestHelper( ).getMoin( ) ).unwrap( ).getCore( ).getMetamodelService( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        ( this.query ).tearDown( );
        this.query = null;
        super.afterTestMethod( );
    }

    /**
     * Tests the getPriForLri() method of the Query interface.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    @IndexOnly
    public void testGetPriForLri( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getPriForLri.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "QueryTest.getPriForLri.Partition2" );
        mp1.deleteElements( );
        mp2.deleteElements( );

        C2 c1 = this.createC2( );
        C2 c2 = this.createC2( );
        C2 c3 = this.createC2( );
        mp1.assignElement( c1 );
        mp1.assignElement( c2 );
        mp2.assignElement( c3 );

        B2 b1 = this.createB2( );
        mp2.assignElement( b1 );

        LRI c1Lri = ( (Partitionable) c1 ).get___Mri( ).getLri( );
        LRI b1Lri = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        this.savePartition( mp1 );
        this.savePartition( mp2 );

        Collection<ClientSpec> clientSpecsAsCollection = getConnectionOne( ).getSession( ).getCompoundClientSpec( ).getClientSpecs( );
        ClientSpec[] clientSpecs = clientSpecsAsCollection.toArray( new ClientSpec[clientSpecsAsCollection.size( )] );

        PRI mp1Pri = this.query.getPriForLri( clientSpecs, c1Lri );
        PRI mp2Pri = this.query.getPriForLri( clientSpecs, b1Lri );

        assertTrue( "No PRI for element", mp1Pri != null );
        assertTrue( "No PRI for element", mp2Pri != null );
        assertTrue( "PRI does not match", mp1Pri.toString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "PRI does not match", mp2Pri.toString( ) == mp2.getPri( ).toString( ) );

        c1.refDelete( );
        this.savePartition( mp1 );

        mp1Pri = this.query.getPriForLri( clientSpecs, c1Lri );
        assertTrue( "PRI found for element", mp1Pri == null );

        ModelPartition mp2Copy = this.createDuplicatePartition( "getPriForLriCopy", this.getPartitionByteArray( mp2 ), this._testClient1 );
        this.savePartition( mp2Copy );

        try {
            this.query.getPriForLri( clientSpecs, b1Lri );
            fail( "Expected DuplicateElementException" );
        } catch ( DuplicateElementException e ) {
            List<PRI> pris = new ArrayList<PRI>( 2 );
            pris.add( mp2Copy.getPri( ) );
            pris.add( mp2.getPri( ) );
            assertTrue( "Wrong number of MRIs in exception (expected 2, was " + e.getMris( ).size( ) + ")", e.getMris( ).size( ) == 2 );
            for ( MRI mri : e.getMris( ) ) {
                assertTrue( "Unexpected MRI: " + mri.toString( ), pris.contains( mri.getPri( ) ) );
            }
        }

        mp1.delete( );
        mp2.delete( );
        mp2Copy.delete( );
        this.saveConnectionOne( );
    }

    @Test
    @IndexOnly
    @Staged
    public void testGetPriForLri_MetamodelEdited( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MRI firstMri = this.getFirst( );
        LRI firstLri = firstMri.getLri( );
        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );


        try {
            PRI pri = this.query.getPriForLri( this.metamodelClientSpecs, firstLri );
            assertTrue( "PRI wrong (expected " + firstMri.getPri( ).toString( ) + ", was " + pri.toString( ) + ")", pri == firstMri.getPri( ) );
        } catch ( DuplicateElementException e ) {
            fail( "Unexpected duplicate element: " + e.getMris( ).toString( ) );
        }

        // clientspec should be uninteresting
        try {
            PRI pri = this.query.getPriForLri( this.localClientSpecs, firstLri );
            assertTrue( "PRI wrong (expected " + firstMri.getPri( ).toString( ) + ", was " + pri.toString( ) + ")", pri == firstMri.getPri( ) );
        } catch ( DuplicateElementException e ) {
            fail( "Unexpected duplicate element: " + e.getMris( ).toString( ) );
        }
    }

    @Test
    @IndexOnly
    public void testIsPartitionExistent( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "QueryTest.ipe.Partition" );
        mp.deleteElements( );
        this.savePartition( mp );

        PRI pri = mp.getPri( );

        ClientSpec clientSpec = getConnectionOne( ).getSession( ).getCompoundClientSpec( ).getClientSpec( mp.getPri( ).getDataAreaDescriptor( ) );
        assertTrue( "Expected true", this.query.isPartitionExistent( clientSpec, pri ) );

        mp.delete( );
        this.removePartition( mp );

        assertFalse( "Expected false", this.query.isPartitionExistent( clientSpec, pri ) );
    }

    @IndexOnly
    @Test
    public void testGetPartitionsInDc( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getPartitionsInDc.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "QueryTest.getPartitionsInDc.Partition2" );

        this.savePartition( mp1 );
        this.savePartition( mp2 );

        String daName = mp1.getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        String dcName = mp1.getPri( ).getContainerName( );
        String wrongDaName = daName + "a";
        String wrongDcName = dcName + "b";

        Collection<PRI> pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], mp1.getPri( ).getCri( ) );
        assertTrue( "PRIs not found for DA=" + daName + ", DC=" + dcName, !pris.isEmpty( ) );
        assertTrue( "Wrong number of PRIs in container (exp: 2, is: " + pris.size( ), pris.size( ) == 2 );

        CRI rightDaRightDc = mp1.getPri( ).getCri( );
        CRI wrongDaRightDc = getTestHelper( ).getFacility( PrimaryFacility.FACILITY_ID ).getRIFactory( ).createCri( wrongDaName, dcName );
        CRI rightDaWrongDc = getTestHelper( ).getFacility( PrimaryFacility.FACILITY_ID ).getRIFactory( ).createCri( daName, wrongDcName );
        CRI wrongDaWrongDc = getTestHelper( ).getFacility( PrimaryFacility.FACILITY_ID ).getRIFactory( ).createCri( wrongDaName, wrongDcName );

        pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], wrongDaRightDc );
        assertTrue( "PRIs found for DA=" + wrongDaName + ", DC=" + dcName, pris.isEmpty( ) );

        pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], rightDaWrongDc );
        assertTrue( "PRIs found for DA=" + daName + ", DC=" + wrongDaName, pris.isEmpty( ) );

        pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], wrongDaWrongDc );
        assertTrue( "PRIs found for DA=" + wrongDaName + ", DC=" + wrongDcName, pris.isEmpty( ) );

        mp2.delete( );
        this.removePartition( mp2 );

        assertTrue( "Number of pris wrong", this.query.getPartitionsInContainer( this.localClientSpecs[0], rightDaRightDc ).size( ) == 1 );

        mp1.delete( );
        this.removePartition( mp1 );

        assertTrue( "Partition still in index", this.query.getPartitionsInContainer( this.localClientSpecs[0], rightDaRightDc ).isEmpty( ) );

    }

    @Test
    public void testGetPrisInScopeViaSynchronize( ) throws Exception {

        // Metamodels already deployed
        SyncReport report = this.query.synchronize( new PRI[0], new long[0], new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                fail( "Should not be called in this test scenario" );
                return null;
            }
        }, true, getFacility( ).getDataAreaByName( IndexConstants.MM_DA_NAME ).getDescriptor( ) );

        assertNotNull( report );
        assertTrue( report.ADDED.isEmpty( ) );
        assertFalse( report.DELETED.isEmpty( ) );
        assertTrue( report.EXCEPTION.isEmpty( ) );
        assertTrue( report.NOP.isEmpty( ) );
        assertTrue( report.UPDATED.isEmpty( ) );
    }

    // ############ PRIVATE METHODS ##############

    private SpiPartitionStreamProvider getStreamProvider( final ModelPartition mp ) {

        return new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                byte[] bytes = TestIndexOverwrittenMethodsInIndexImpl.this.getPartitionByteArray( mp );
                return new ByteArrayInputStream( bytes );
            }

        };
    }

    private void savePartition( ModelPartition mp ) {

        ( this.query ).indexPartition( mp.getPri( ), this.getStreamProvider( mp ), 1234, true );
    }

    private void removePartition( ModelPartition mp ) {

        ( this.query ).removePartition( mp.getPri( ) );
    }

    private void deployMetamodels( ) {

        IndexImpl index = ( this.query );
        MetaModelPartitionManagerImpl mmpm = ( (MetaModelPartitionManagerImpl) ( (SpiFsFacility) getFacility( ) ).getFsMetaModelManager( ) );

        try {
            Field metamodelsF = MetaModelPartitionManagerImpl.class.getDeclaredField( "metamodelPartitionToStreamProvider" );
            metamodelsF.setAccessible( true );
            Map<PRI, SpiPartitionStreamProvider> metamodels = (Map<PRI, SpiPartitionStreamProvider>) metamodelsF.get( mmpm );

            for ( Map.Entry<PRI, SpiPartitionStreamProvider> entry : metamodels.entrySet( ) ) {
                index.indexPartition( entry.getKey( ), entry.getValue( ), 1234, true );
            }
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }
}
