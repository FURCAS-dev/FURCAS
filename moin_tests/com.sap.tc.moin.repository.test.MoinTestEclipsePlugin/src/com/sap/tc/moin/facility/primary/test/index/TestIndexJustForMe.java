package com.sap.tc.moin.facility.primary.test.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexConstants;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexFsDumpedImpl;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

public class TestIndexJustForMe extends IndexTestCase {

    protected IndexFsDumpedImpl index = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.index = (IndexFsDumpedImpl) ( (SpiFacility) getTestHelper( ).getMoin( ).getFacilityById( "PF" ) ).getCoreQueryService( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    /**
     * Tests the shrink of mofIdToElements table, and typeToInstances and
     * priToElement entries.
     */
    @IndexOnly
    public void testPartitionShrinkFOR_ME( ) {

        final int count = 129;
        C2[] c2s = new C2[count];

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "Index.partitionShrink.Partition" );

        C2 c2 = null;
        for ( int i = 0; i < count; i++ ) {
            c2 = this.createC2( );
            mp1.assignElement( c2 );
            c2s[i] = c2;
            this.saveConnectionOne( );
            System.out.println( i + "/" + count );
            this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
            assertTrue( this.index.dumpIndex( ) );
            assertTrue( this.index.loadIndex( ) );
            this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
        }

        // delete each element
        for ( int i = 0; i < count; i++ ) {
            c2s[i].refDelete( );
            this.saveConnectionOne( );
            System.out.println( i + "/" + count );
            this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
            assertTrue( this.index.dumpIndex( ) );
            assertTrue( this.index.loadIndex( ) );
            this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
        }

        mp1.delete( );
        this.saveConnectionOne( );
    }

    @IndexOnly
    public void testIndexLoadSpeed( ) {

        long time = System.currentTimeMillis( );
        this.index.loadIndex( );
        time = System.currentTimeMillis( ) - time;
        System.out.println( time );
    }

    @IndexOnly
    public void testAddElementToManyElements( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "IndexPartitionAdd.Partition" );

        int count = 10000;
        for ( int i = 0; i < count; i++ ) {
            C2 c2 = this.createC2( );
            B2 b2 = this.createB2( );
            mp.assignElement( c2 );
            mp.assignElement( b2 );
            c2.setB( b2 );
        }
        saveConnectionOne( );

        int count2 = 1000;
        for ( int i = 0; i < count2; i++ ) {
            C2 c2 = this.createC2( );
            B2 b2 = this.createB2( );
            mp.assignElement( c2 );
            mp.assignElement( b2 );
            c2.setB( b2 );
        }

        saveConnectionOne( );

        mp.delete( );
        saveConnectionOne( );
    }

    @IndexOnly
    public void testMofRomDeployment( ) {

        String daName = ( (SpiFacility) getFacility( ) ).getMetamodelDataArea( ).getDescriptor( ).getDataAreaName( );
        String cnName = MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME;
        CRI mofCri = getFacility( ).getRIFactory( ).createCri( daName, cnName );

        Collection<PRI> mofPris = this.getConnectionOne( ).getSession( ).getInnerPartitions( mofCri );
        assertTrue( "Wrong number of partitions of MofRom: expected 6/was " + mofPris.size( ), mofPris.size( ) == 6 );
        List<SpiModelPartition> mofPartitions = new ArrayList<SpiModelPartition>( mofPris.size( ) );
        for ( PRI mofPri : mofPris ) {
            SpiModelPartition mp = getTestHelper( ).getCoreConnection( this.getConnectionOne( ) ).getPartition( mofPri );
            mofPartitions.add( mp );
        }
        SpiMofRomInjectionService mmpm = ( (SpiFacility) getFacility( ) ).getMofRomInjectionService( );
//        List<PRI> injectMofMetamodels = mmpm.injectMofRomPartitions( mofPartitions );
//        assertTrue( "Some mof metamodels could not be indexed: " + injectMofMetamodels.toString( ), injectMofMetamodels.size( ) == 0 );

        // check if mof rom is successfully indexed
        int indexedLinks = 0;
        for ( SpiModelPartition mofPartition : mofPartitions ) {
            PRI pri = mofPartition.getPri( );
            assertTrue( "Mof Partition " + pri.toString( ) + " not indexed!", this.index.isPartitionIndexed( pri ) );
            Object[] elements = this.index.getPriToElements( ).getUnderlyingForRead( this.index.getPriToIndexPri( ).get( pri.toString( ) ) );
            assertNotNull( "No elements indexed for PRI: " + pri.toString( ), elements );
            int indexedSize = elements.length;
            int partitionSize = mofPartition.getElements( ).size( );
            assertTrue( "Number of indexed Elements wrong. indexed: " + indexedSize + ", real: " + partitionSize + ", PRI: " + pri.toString( ), indexedSize == partitionSize );
            Object[] links = this.index.getPriToLinkRecords( ).getUnderlyingForRead( this.index.getPriToIndexPri( ).get( pri.toString( ) ) );
            if ( links != null ) {
                indexedLinks += links.length;
            }
        }

        assertTrue( "No indexed links found.", indexedLinks != 0 );

        // remove mof rom from index
        for ( PRI mofPri : mofPris ) {
            this.index.removePartition( mofPri );
        }
    }

    @IndexOnly
    public void testMaxIndexLoad( ) {

        int overallCount = 1000;

        int partitionNr = 0;
        for ( int i = 0; i < overallCount; i++ ) {
            try {
                this.createPartitionsWithIntraLinks( partitionNr++ );
                System.out.println( "Count: " + i );
            } catch ( OutOfMemoryError e ) {
                System.out.println( "OutOfMemory after " + ( ( i - 1 ) * 1000 ) + " Elements." );
            }
        }

        long time = System.currentTimeMillis( );
        this.index.dumpIndex( );
        time = System.currentTimeMillis( ) - time;
        System.out.println( "Index Save: " + time );

        time = System.currentTimeMillis( );
        this.index.loadIndex( );
        time = System.currentTimeMillis( ) - time;
        System.out.println( "Index Load: " + time );

    }

    @IndexOnly
    public void testRandomCreateDeleteDumpReload( ) {

        final int partCount = 50;
        final int maxElemsPerPart = 100;
        int partCounter = 0;
        ModelPartition[][] partitions = new ModelPartition[partCount][];

        long elapseTime = 1000 * 60 * 60 * 2;
        long startTime = System.currentTimeMillis( );

        Random rand = new Random( System.currentTimeMillis( ) );

        System.out.println( "Time\tPart.\tAction" );

        int created = 0;
        int deleted = 0;
        int dumped = 0;
        int checked = 0;

        int action;
        long time;
        while ( ( time = ( System.currentTimeMillis( ) - startTime ) ) < elapseTime ) {
            action = rand.nextInt( 100 );

            if ( action < 45 ) { // create
                ++created;
                int numOfPart = rand.nextInt( partCount );
                if ( numOfPart + partCounter >= partCount ) {
                    numOfPart = partCount - partCounter;
                }
                System.out.print( time + "\t" + partCounter + "\tCreate " + numOfPart + "\t\t" );
                System.out.println( created + " " + deleted + " " + dumped + " " + checked );
                for ( int i = 0; i < numOfPart; i++ ) {
                    partitions[partCounter++] = this.createPartition( rand.nextInt( maxElemsPerPart ) );
                }
            } else if ( action >= 45 && action < 90 ) { // delete
                ++deleted;
                int numOfPart = rand.nextInt( partCount );
                if ( partCounter - numOfPart < 0 ) {
                    numOfPart = partCounter;
                }
                System.out.print( time + "\t" + partCounter + "\tDelete " + numOfPart + "\t\t" );
                System.out.println( created + " " + deleted + " " + dumped + " " + checked );
                int pos;
                for ( int i = 0; i < numOfPart; i++ ) {
                    pos = rand.nextInt( partCounter-- );
                    partitions[pos][0].delete( );
                    partitions[pos][1].delete( );
                    this.saveConnectionOne( );
                    partitions[pos] = partitions[partCounter];
                }
            } else if ( action >= 90 && action < 98 ) { // dump and reload
                ++dumped;
                System.out.print( time + "\t" + partCounter + "\tDumpNLoad\t\t" );
                System.out.println( created + " " + deleted + " " + dumped + " " + checked );
                assertTrue( this.index.dumpIndex( ) );
                assertTrue( this.index.loadIndex( ) );
            } else if ( action >= 98 ) {
                ++checked;
                System.out.print( time + "\t" + partCounter + "\tSanity\t\t" );
                System.out.println( created + " " + deleted + " " + dumped + " " + checked );
                this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
            }

        }
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        // cleanup
        for ( int i = 0; i < partCounter; i++ ) {
            partitions[i][0].delete( );
            partitions[i][1].delete( );
        }
        this.saveConnectionOne( );
    }

    @IndexOnly
    public void testPerformanceGetPriForLri( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "getPri4LriPerf" );

        B2 b2 = this.createB2( );
        mp.assignElement( b2 );
        LRI b2Lri = ( (Partitionable) b2 ).get___Mri( ).getLri( );

        for ( int i = 0; i < 100000; i++ ) {
            PRI pri = this.index.getPriForLri( this.localClientSpecs, b2Lri );
        }

        mp.delete( );
    }

//    @Test
//    @Ignore
//    public void testMqlErrorFoundDuringSearchOfBugReportedByJuergen( ) throws Exception {
//
//        ModelPartition mp1 = this._testClient1.getOrCreatePartitionStable( "beforejuergen1" );
//        ModelPartition mp2 = this._testClient1.getOrCreatePartitionStable( "beforejuergen2" );
//        ModelPartition mp3 = this._testClient1.getOrCreatePartitionStable( "beforejuergen3" );
//        ModelPartition mp4 = this._testClient1.getOrCreatePartitionStable( "beforejuergen4" );
//
//        mp1.deleteElements( );
//        mp2.deleteElements( );
//        mp3.deleteElements( );
//        mp4.deleteElements( );
//
//        BusinessObject bo = mp1.createElement( BusinessObject.class );
//        BusinessObjectNode rNode = mp2.createElement( BusinessObjectNode.class );
//        BusinessObjectNode cNode = mp3.createElement( BusinessObjectNode.class );
//        NodeAssociation nodeAssoc = mp4.createElement( NodeAssociation.class );
//
//        bo.setName( "ourBo" );
//        cNode.setName( "ourCNode" );
//        rNode.setName( "ourRNode" );
//
//        bo.setRootNode( rNode );
//        rNode.getAssociations( ).add( nodeAssoc );
//        nodeAssoc.setTarget( cNode );
////        nodeAssoc.setPrefix( null );
//        nodeAssoc.setAggregation( NodeAggregationKindEnumEnum.COMPOSITE );
//
//
//        this._testClient1.getConnection( ).save( );
//
//        PRI partitionToDelete = mp2.getPri( );
//
//        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );
//
//        MQLResultSet rs = mql.execute( "select bo.name, rNode.name, cNode.name, nodeAssoc " //
//                                       + "from ESMP::BusinessObject::BusinessObject as bo, " //
//                                       + "ESMP::BusinessObject::BusinessObjectNode as rNode, " // 
//                                       + "ESMP::BusinessObject::BusinessObjectNode as cNode, " // 
//                                       + "ESMP::BusinessObject::NodeAssociation as nodeAssoc " // 
//                                       + "where bo.rootNode = rNode " // 
//                                       + "where rNode.associations[ESMP::BusinessObject::AssociationsOfNode] = nodeAssoc " //
//                                       + "where nodeAssoc.target[ESMP::BusinessObject::TargetOfAssociation] = cNode " //
//                                       + "where nodeAssoc.prefix[ESMP::BusinessObject::PrefixOfDependentObject] = null " ); //
////                                       + "where nodeAssoc.aggregation = 'COMPOSITE'" ); //$NON-NLS-1$
//
//        RefObject o = rs.getRefObject( 0, "nodeAssoc" );
//        System.out.println( rs.toString( ) );
//
//        assertTrue( rs.getSize( ) > 0 );
//
//        mp1.delete( );
//        mp2.delete( );
//        mp3.delete( );
//        mp4.delete( );
//
//        this._testClient1.getConnection( ).save( );
//    }
//
//    @Test
//    @Ignore
//    public void testMqlErrorReportedByJuergen( ) throws Exception {
//
//        ModelPartition mp1 = this._testClient1.getOrCreatePartitionStable( "juergen1" );
//        ModelPartition mp2 = this._testClient1.getOrCreatePartitionStable( "juergen2" );
//        ModelPartition mp3 = this._testClient1.getOrCreatePartitionStable( "juergen3" );
//
//        mp1.deleteElements( );
//        mp2.deleteElements( );
//        mp3.deleteElements( );
//
//        // first chain        
//        BusinessObject bo = mp1.createElement( BusinessObject.class );
//        BusinessObjectNode rNode = mp3.createElement( BusinessObjectNode.class );
//        BusinessObjectNode cNode = mp1.createElement( BusinessObjectNode.class );
//        NodeAssociation nodeAssoc = mp1.createElement( NodeAssociation.class );
//
//        bo.setName( "ourBo1" );
//        cNode.setName( "ourCNode1" );
//        rNode.setName( "ourRNode1" );
//
//        bo.setRootNode( rNode );
//        rNode.getAssociations( ).add( nodeAssoc );
//        nodeAssoc.setTarget( cNode );
//        nodeAssoc.setAggregation( NodeAggregationKindEnumEnum.COMPOSITE );
//
//
//        // second chain        
//        bo = mp1.createElement( BusinessObject.class );
//        rNode = mp2.createElement( BusinessObjectNode.class );
//        cNode = mp1.createElement( BusinessObjectNode.class );
//        nodeAssoc = mp1.createElement( NodeAssociation.class );
//
//        bo.setName( "ourBo2" );
//        cNode.setName( "ourCNode2" );
//        rNode.setName( "ourRNode2" );
//
//        bo.setRootNode( rNode );
//        rNode.getAssociations( ).add( nodeAssoc );
//        nodeAssoc.setTarget( cNode );
//        nodeAssoc.setAggregation( NodeAggregationKindEnumEnum.COMPOSITE );
//
//        this._testClient1.getConnection( ).save( );
//
//        // create inconsistency by deleting the partition file 3 manually from disk 
//        PRI partitionToDelete = mp3.getPri( );
//        IFile file = ( (IdePrimaryFacility) getFacility( ) ).getFile( partitionToDelete );
//        file.delete( true, null );
//
//        // wait until complete MOIN is updated
//        while ( this._testClient1.getConnection( ).getPartition( partitionToDelete ) != null ) {
//            ;
//        }
//
//        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );
//
//        MQLResultSet rs = mql.execute( "select bo.name, rNode.name, cNode.name, nodeAssoc " //
//                                       + "from ESMP::BusinessObject::BusinessObject as bo, " //
//                                       + "ESMP::BusinessObject::NodeAssociation as nodeAssoc, " // 
//                                       + "ESMP::BusinessObject::BusinessObjectNode as rNode, " // 
//                                       + "ESMP::BusinessObject::BusinessObjectNode as cNode " // 
//                                       + "where bo.rootNode = rNode " // 
//                                       + "where rNode.associations[ESMP::BusinessObject::AssociationsOfNode] = nodeAssoc " //
//                                       + "where nodeAssoc.target[ESMP::BusinessObject::TargetOfAssociation] = cNode " //
//                                       + "where nodeAssoc.prefix[ESMP::BusinessObject::PrefixOfDependentObject] = null " //
//                                       + "where nodeAssoc.aggregation = 'COMPOSITE'" ); //$NON-NLS-1$
//
//        System.out.println( rs.toString( ) );
//
//        assertTrue( rs.getSize( ) == 1 );
//
//        mp1.delete( );
//        mp2.delete( );
//
//        this._testClient1.getConnection( ).save( );
//    }

}
