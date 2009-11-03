package com.sap.tc.moin.facility.primary.test.index;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexConstants;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexLinkRecord;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexModelElement;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexMofId;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexPri;
import com.sap.tc.moin.facility.primary.test.FacilityTestCase;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.PartitionChangeRecorder;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.serialization.PartitionReaderImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcases.case002.Case002Package;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcasesfoundation.TestcasesfoundationPackage;

// @RunWith( IndexRunner.class )
@SuppressWarnings( "nls" )
public class IndexTestCase extends FacilityTestCase {

    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, IndexTestCase.class );

    protected IndexImpl index = null;

    SpiFacilityQueryClientScope localQueryClientScope = null;

    ClientSpec[] localClientSpecs = null;

    SpiFacilityQueryClientScope metamodelQueryClientScope = null;

    ClientSpec[] metamodelClientSpecs = null;

    SpiFacilityQueryClientScope allQueryClientScope = null;

    ClientSpec[] allClientSpecs = null;

    private int count = 0;

    protected static String extsecond = "45ED922CBFAA84577948443E24C9D79ADAE0D435";

    protected static String first = "45F120A5B8DAF694CBC6421432B79EAE63271E89";

    protected static String firsttype = "45ED2E29372BCE32CB9241CD1FB9E2F08880B940";

    protected static String assoctype = "45ED2E297C6E4C4F64E543CC20E2ED5F34992C72";

    protected static String fakeMofId = "AFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";


    protected TestcasesPackage testcasesPackage;

    protected TestcasesfoundationPackage testcasesFoundation;

    protected MoinPackage moinPackage;

    protected Case002Package case002Package;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        try {
            super.beforeTestMethod( );

            this.testcasesPackage = (TestcasesPackage) this.getConnectionOne( ).getPackage( null, new String[] { "testcases" } );
            this.testcasesFoundation = (TestcasesfoundationPackage) this.getConnectionOne( ).getPackage( null, new String[] { "testcasesfoundation" } );
            this.moinPackage = (MoinPackage) this.getConnectionOne( ).getPackage( null, new String[] { "MOIN" } );

            this.case002Package = this.testcasesPackage.getCase002( );

            ModelPartition mp = this._testClient1.getOrCreatePartition( "IndexTestSetup" );

            for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
                mp.assignElement( element );
            }
            this.index = (IndexImpl) ( (SpiFacility) getTestHelper( ).getMoin( ).getFacilityById( "PF" ) ).getCoreQueryService( );

            this.localClientSpecs = new ClientSpec[] { this._testClient1.getClientSpec( ) };
            this.localQueryClientScope = new QueryClientScope( ) {

                public ClientSpec[] getQueryClientScope( ) {

                    return IndexTestCase.this.localClientSpecs;
                }
            };

            this.metamodelClientSpecs = new ClientSpec[] { ( (SpiFacility) getFacility( ) ).getMetamodelClientSpec( ) };
            this.metamodelQueryClientScope = new QueryClientScope( ) {

                public ClientSpec[] getQueryClientScope( ) {

                    return IndexTestCase.this.metamodelClientSpecs;
                }
            };

            this.allClientSpecs = new ClientSpec[] { this.localClientSpecs[0], this.metamodelClientSpecs[0] };
            this.allQueryClientScope = new QueryClientScope( ) {

                public ClientSpec[] getQueryClientScope( ) {

                    return IndexTestCase.this.allClientSpecs;
                }
            };
        } catch ( Throwable t ) {
            logger.trace( t, MoinSeverity.ERROR, "beforeTest method failed with exception" );
        }
    }

    private static abstract class QueryClientScope implements SpiFacilityQueryClientScope {

        public Set<PRI> getPartitionsScope( ) {

            return Collections.emptySet( );
        }

        public boolean isPartitionScopeInclusive( ) {

            return false;
        }

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

//      SH: if this check fails with an AssertionError, the connections of the test client remain open which leads
//      to locking exceptions in the core late on; afterTest should only do real clean-ups        
//        this.getMetamodelContainer( "testcases" );
        super.afterTestMethod( );
    }

    protected void deleteAllNonMetamodelsFromIndex( ) {

        saveConnectionOne( );

        // delete all non-metamodels from index
        ArrayList<IndexPri> nonMetaModelPris = new ArrayList<IndexPri>( );
        Collection<IndexPri> allPris = this.index.getPriToIndexPri( ).values( );
        for ( IndexPri pri : allPris ) {
            if ( !pri.isMetaModelPartition( ) ) {
                nonMetaModelPris.add( pri );
            }
        }

        Set<DataAreaDescriptor> dataAreas = new HashSet<DataAreaDescriptor>( );

        for ( IndexPri pri : nonMetaModelPris ) {
            ModelPartition partition = this.getConnectionOne( ).getPartition( pri.getCachedPri( ) );
            if ( partition != null ) {
                partition.delete( );
            } else {
                // inconsistency between index and persistence
                if ( logger.isLoggedOrTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, "Index-Persistence inconsistency detected: partition {0} not found in persistence. Removing it from index.", pri.getPriString( ) );
                }

                this.index.removePartition( pri.getCachedPri( ) );
            }

            dataAreas.add( pri.getCachedPri( ).getDataAreaDescriptor( ) );
        }
        saveConnectionOne( );

        for ( DataAreaDescriptor da : dataAreas ) {
            SyncReport report = this.index.synchronize( new PRI[0], new long[0], new SpiPartitionStreamProvider( ) {

                public InputStream getPartitionStream( PRI pri ) {

                    throw new UnsupportedOperationException( );
                }
            }, true, da );

            assertTrue( report.DELETED.isEmpty( ) );
        }
    }

    protected byte[] getPartitionByteArray( ModelPartition mp ) {

        CoreModelPartition cmp = ( (Wrapper<CoreModelPartition>) mp ).unwrap( );
        PartitionWriterImpl writer = new PartitionWriterImpl( );
        ByteArrayOutputStream os = new ByteArrayOutputStream( );
        try {
            writer.write( getTestHelper( ).getCoreConnection( this.getConnectionOne( ) ).getSession( ), os, cmp );
        } catch ( IOException e ) {
            errorAndStop( "Partition could not written to xmi.", e );
        }

        byte[] byteArray = os.toByteArray( );
        return byteArray;
    }

    private ModelPartition createDuplicatePartition( String partitionName, InputStream inputStream, TestClient client, boolean doSave ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mpCopy;
        if ( doSave ) {
            mpCopy = client.getOrCreatePartitionStable( partitionName );
            mpCopy.delete( );
            client.getConnection( ).save( );
        }

        SynchronizationManager synchronizationManager = getTestHelper( ).getCoreSession( client.getConnection( ).getSession( ) ).getWorkspaceSet( ).getSynchronizationManager( );

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            synchronizationManager.acquireMicroWriteLock( );
            try {


                // create second partition


                mpCopy = client.getOrCreatePartitionStable( partitionName );

                CoreModelPartition cmpCopy = ( (Wrapper<CoreModelPartition>) mpCopy ).unwrap( );

                PartitionReaderImpl reader = new PartitionReaderImpl( );

                try {
                    reader.read( getTestHelper( ).getCoreConnection( getConnectionOne( ) ).getSession( ), inputStream, cmpCopy );
                } catch ( Exception e ) {
                    errorAndStop( "Partition could not be restored from xmi.", e );
                }

                // TODO update partition change recorder
                CoreConnection coreConnection = getTestHelper( ).getCoreConnection( client.getConnection( ) );
                PartitionChangeRecorder changeRecorder = coreConnection.getPartitionChangeRecorder( );
                for ( Partitionable element : cmpCopy.getElements( ) ) {
                    changeRecorder.elementCreated( (CorePartitionable) element );
                }

                for ( SpiLink link : cmpCopy.getLinks( ) ) {
                    changeRecorder.linkAdded( (EndStorageLink) link );
                }


            } finally {
                synchronizationManager.releaseMicroWriteLock( );
            }

        }

        if ( doSave ) {
            client.getConnection( ).save( );
            CoreModelPartition corePartition = getTestHelper( ).getCoreModelPartition( mpCopy );
            assertTrue( corePartition.getWorkspace( ) instanceof CompoundClientSpecWorkspace );
        }

        return mpCopy;

    }


    /**
     * @param partitionName
     * @param byteArray
     * @return
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    protected ModelPartition createDuplicatePartition( String partitionName, byte[] byteArray, TestClient client ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        return createDuplicatePartition( partitionName, new ByteArrayInputStream( byteArray ), client, true );
    }

    protected C2 createC2( ) {

        return this._testClient1.getConnection( ).createElementInPartition( C2.class, null );
    }

    protected B2 createB2( ) {

        return this._testClient1.getConnection( ).createElementInPartition( B2.class, null );
    }


    protected MRI getFirst( ) {

        return this.index.getMofIdToElements( ).get( this.index.getMofIdFactory( ).getMofId( first ) ).getMri( );
    }

    protected MRI getFirstType( ) {

        return this.index.getMofIdToElements( ).get( this.index.getMofIdFactory( ).getMofId( firsttype ) ).getMri( );
    }

    protected MRI getExtSecond( ) {

        return this.index.getMofIdToElements( ).get( this.index.getMofIdFactory( ).getMofId( extsecond ) ).getMri( );
    }

    protected MRI getAssocType( ) {

        return this.index.getMofIdToElements( ).get( this.index.getMofIdFactory( ).getMofId( assoctype ) ).getMri( );
    }

    protected List<ModelPartition> loadMetamodelInLocalDataArea( String... containers ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MoinTestHelper th = getTestHelper( );

        List<ModelPartition> result = new ArrayList<ModelPartition>( );
        for ( String container : containers ) {

            Object[] idxPris = this.index.getDaToDcToIndexPris( ).getUnderlyingForRead( IndexConstants.MM_DA_NAME, container.intern( ) );
            assertNotNull( "No metamodel partitions found for " + container, idxPris );

            for ( Object iPri : idxPris ) {
                PRI pri = ( (IndexPri) iPri ).getCachedPri( );
                InputStream partitionStream = th.getPartitionStream( pri );
                assertNotNull( "Couldn't get stream for PRI " + pri, partitionStream );
                String partitionName = pri.getPartitionName( );
                ModelPartition mpCopy = _testClient1.getOrCreatePartitionStable( partitionName );
                mpCopy.delete( );
                result.add( createDuplicatePartition( partitionName + ".copy" + getUniqueNumber( ), partitionStream, _testClient1, true ) );

            }
        }
        _testClient1.getConnection( ).save( );
        return result;
    }

    private int getUniqueNumber( ) {

        return this.count++;
    }

    protected String getMetamodelContainer( String toplevelpackage ) {

        Map<MRI, String> topLevelPackageMrisToNames = this.index.getTopLevelPackages( );
        String mofId = null;
        for ( Entry<MRI, String> mapEntry : topLevelPackageMrisToNames.entrySet( ) ) {
            if ( mapEntry.getValue( ).equals( toplevelpackage ) ) {
                mofId = mapEntry.getKey( ).getMofId( );
            }
        }
        assertNotNull( toplevelpackage + " package mofid not found", mofId );

        IndexMofId idxMofId = this.index.getMofIdFactory( ).getMofId( mofId );
        assertNotNull( "index mof id not found", idxMofId );

        IndexModelElement indexModelElement = this.index.getMofIdToElements( ).get( idxMofId );
        assertNotNull( "index modelelement not found", indexModelElement );

        return indexModelElement.pri.getContainerName( );
    }

    protected boolean isPartitionIndexed( PRI pri ) {

        return this.index.isPartitionIndexed( pri );
    }

    protected List<IndexLinkRecord> getPriToLinkRecords( String pri ) {

        IndexPri idxPri = this.index.getPriToIndexPri( ).get( pri );
        if ( this.index.getPriToLinkRecords( ).getUnderlyingForRead( idxPri ) != null ) {
            Object[] lrs = this.index.getPriToLinkRecords( ).getUnderlyingForRead( idxPri );
            ArrayList<IndexLinkRecord> array = new ArrayList<IndexLinkRecord>( lrs.length );
            for ( int i = 0; i < lrs.length; i++ ) {
                array.add( (IndexLinkRecord) lrs[i] );
            }
            return array;
        }
        return null;
    }

    protected Object getMofIdToElements( String mofId ) {

        IndexMofId mId = this.index.getMofIdFactory( ).createMofId( mofId );
        if ( mId == null ) {
            return null;
        }
        return this.index.getMofIdToElements( ).getUnderlyingForRead( mId );
    }

    protected void createPartitions( int partitionNr ) {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.load.Partition" + partitionNr + "_1" );
        mp1.deleteElements( );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.load.Partition" + partitionNr + "_2" );
        mp2.deleteElements( );

        this.saveConnectionOne( );

        for ( int i = 0; i < 500; i++ ) {
            C2 c2 = this.createC2( );
            B2 b2 = this.createB2( );

            if ( i % 5 == 0 ) {
                c2.setB( b2 );
            }

            if ( i < 250 ) {
                mp1.assignElement( c2 );
                mp2.assignElement( b2 );
            } else {
                mp2.assignElement( c2 );
                mp1.assignElement( b2 );
            }
        }

        this.saveConnectionOne( );

        this.evictPartition( mp1 );
        this.evictPartition( mp2 );

    }

    protected void createPartitionsWithIntraLinks( int partitionNr ) {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.load.Partition" + partitionNr + "_1" );
        mp1.deleteElements( );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.load.Partition" + partitionNr + "_2" );
        mp2.deleteElements( );

        this.saveConnectionOne( );

        for ( int i = 0; i < 500; i++ ) {
            C2 c2 = this.createC2( );
            B2 b2 = this.createB2( );

            c2.setB( b2 );

            if ( i % 5 == 0 ) {
                if ( i < 250 ) {
                    mp1.assignElement( c2 );
                    mp2.assignElement( b2 );
                } else {
                    mp2.assignElement( c2 );
                    mp1.assignElement( b2 );
                }
            } else {

                if ( i < 250 ) {
                    mp1.assignElement( c2 );
                    mp1.assignElement( b2 );
                } else {
                    mp2.assignElement( c2 );
                    mp2.assignElement( b2 );
                }
            }
        }

        this.saveConnectionOne( );

        this.evictPartition( mp1 );
        this.evictPartition( mp2 );

    }

    protected ModelPartition[] createPartition( int elemCount ) {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.random.Partition_1" );
        mp1.deleteElements( );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.random.Partition_2" );
        mp2.deleteElements( );

        for ( int i = 0; i < elemCount; i++ ) {
            C2 c2 = this.createC2( );
            B2 b2 = this.createB2( );

            if ( i % 5 == 0 ) {
                c2.setB( b2 );
            }

            if ( i < ( elemCount / 2 ) ) {
                mp1.assignElement( c2 );
                mp2.assignElement( b2 );
            } else {
                mp2.assignElement( c2 );
                mp1.assignElement( b2 );
            }
        }

        this.saveConnectionOne( );

        return new ModelPartition[] { mp1, mp2 };
    }

    protected void outputExpectedExceptionMessage( Class exceptionClass ) {

        System.out.println( "#######################################################" );
        System.out.println( "EXPECTED EXCEPTION IN LOG: " + exceptionClass.getName( ) );
        System.out.println( "#######################################################" );
    }

    protected void fillWithSomeContent( ModelPartition mp ) {

        B4 b4 = mp.createElement( B4.class );
        b4.setOnePrimitive( "Hello Test" );
    }

    protected SpiPartitionStreamProvider getStreamProvider( final ModelPartition... mps ) {

        return new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                for ( ModelPartition mp : mps ) {
                    if ( pri.equals( mp.getPri( ) ) ) {
                        return new ByteArrayInputStream( getPartitionByteArray( mp ) );
                    }
                }
                return null;
            }

        };
    }

}
