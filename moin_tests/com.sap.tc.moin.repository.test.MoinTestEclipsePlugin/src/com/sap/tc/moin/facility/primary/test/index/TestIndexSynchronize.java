package com.sap.tc.moin.facility.primary.test.index;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiDefaultParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.test.fw.TestMetaModels;


public class TestIndexSynchronize extends IndexTestCase {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testSyncReportWithErrorHandler( ) throws Exception {

        PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
        SpiParserErrorHandler parserErrorHandler = serializationManager.getParserErrorHandler( TestMetaModels.TESTCASES_CN, null );
        serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_CN, new TestErrorHandler( ) );

        IndexImpl i = new IndexImpl( IpiPrimaryFacility.FACILITY_ID, "myFakeMoin" + System.currentTimeMillis( ), null );
        i.bind( ( (SpiMoin) getTestHelper( ).getCoreMoin( ) ).getCore( ).getMetamodelService( ) );
        i.bind( ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( ) );
        i.initialize( );
        i.finalizeStartup( );

        try {
            ModelPartition _mp = this._testClient1.createPartition( "mp" );
            final PRI mp = _mp.getPri( );
            _mp.delete( );
            ModelPartition _mp_eh = this._testClient1.createPartition( "mp_eh" );
            final PRI mp_eh = _mp_eh.getPri( );
            _mp_eh.delete( );
            ModelPartition _mp_ex = this._testClient1.createPartition( "mp_ex" );
            final PRI mp_ex = _mp_ex.getPri( );
            _mp_ex.delete( );

            SpiPartitionStreamProvider psp = new SpiPartitionStreamProvider( ) {

                public InputStream getPartitionStream( PRI pri ) {

                    if ( pri.equals( mp ) ) {
                        return getContentTestPartition( );
                    } else if ( pri.equals( mp_eh ) ) {
                        return getContentOfErrorHandleTestPartition( );
                    } else if ( pri.equals( mp_ex ) ) {
                        return getContentCorruptTestPartition( );
                    } else {
                        throw new IllegalArgumentException( "Unexpected PRI " + pri );
                    }
                }
            };

            DataAreaDescriptor daDesc = mp.getDataAreaDescriptor( );
            PRI[] toIndex = new PRI[] { mp, mp_eh };
            long[] timestamps = new long[] { 1, 1 };

            // add test
            SyncReport syncReport = i.synchronize( toIndex, timestamps, psp, true, daDesc, new PRI[0] );

            assertFalse( syncReport.ADDED.isEmpty( ) );
            assertFalse( syncReport.ADDED_EH.isEmpty( ) );
            assertTrue( syncReport.UPDATED.isEmpty( ) );
            assertTrue( syncReport.UPDATED_EH.isEmpty( ) );
            assertTrue( syncReport.NOP.isEmpty( ) );
            assertTrue( syncReport.DELETED.isEmpty( ) );
            assertTrue( syncReport.EXCEPTION.isEmpty( ) );

            assertTrue( syncReport.ADDED.containsAll( Arrays.asList( mp, mp_eh ) ) );
            assertTrue( syncReport.ADDED_EH.containsAll( Arrays.asList( mp_eh ) ) );

            // update test
            syncReport = i.synchronize( toIndex, timestamps, psp, true, daDesc, new PRI[0] );

            assertTrue( syncReport.ADDED.isEmpty( ) );
            assertTrue( syncReport.ADDED_EH.isEmpty( ) );
            assertFalse( syncReport.UPDATED.isEmpty( ) );
            assertFalse( syncReport.UPDATED_EH.isEmpty( ) );
            assertTrue( syncReport.NOP.isEmpty( ) );
            assertTrue( syncReport.DELETED.isEmpty( ) );
            assertTrue( syncReport.EXCEPTION.isEmpty( ) );

            assertTrue( syncReport.UPDATED.containsAll( Arrays.asList( mp, mp_eh ) ) );
            assertTrue( syncReport.UPDATED_EH.containsAll( Arrays.asList( mp_eh ) ) );

            // NOP test
            syncReport = i.synchronize( toIndex, timestamps, psp, false, daDesc, new PRI[0] );

            assertTrue( syncReport.ADDED.isEmpty( ) );
            assertTrue( syncReport.ADDED_EH.isEmpty( ) );
            assertTrue( syncReport.UPDATED.isEmpty( ) );
            assertTrue( syncReport.UPDATED_EH.isEmpty( ) );
            assertFalse( syncReport.NOP.isEmpty( ) );
            assertTrue( syncReport.DELETED.isEmpty( ) );
            assertTrue( syncReport.EXCEPTION.isEmpty( ) );

            assertTrue( syncReport.NOP.containsAll( Arrays.asList( mp, mp_eh ) ) );

            // deletion test
            syncReport = i.synchronize( new PRI[0], new long[0], psp, false, daDesc, toIndex );

            assertTrue( syncReport.ADDED.isEmpty( ) );
            assertTrue( syncReport.ADDED_EH.isEmpty( ) );
            assertTrue( syncReport.UPDATED.isEmpty( ) );
            assertTrue( syncReport.UPDATED_EH.isEmpty( ) );
            assertTrue( syncReport.NOP.isEmpty( ) );
            assertFalse( syncReport.DELETED.isEmpty( ) );
            assertTrue( syncReport.EXCEPTION.isEmpty( ) );

            assertTrue( syncReport.DELETED.containsAll( Arrays.asList( mp, mp_eh ) ) );

            // exception test
            syncReport = i.synchronize( new PRI[] { mp_ex }, new long[] { 1 }, psp, true, daDesc, new PRI[0] );

            assertTrue( syncReport.ADDED.isEmpty( ) );
            assertTrue( syncReport.ADDED_EH.isEmpty( ) );
            assertTrue( syncReport.UPDATED.isEmpty( ) );
            assertTrue( syncReport.UPDATED_EH.isEmpty( ) );
            assertTrue( syncReport.NOP.isEmpty( ) );
            assertTrue( syncReport.DELETED.isEmpty( ) );
            assertFalse( syncReport.EXCEPTION.isEmpty( ) );

            assertTrue( syncReport.EXCEPTION.containsAll( Arrays.asList( mp_ex ) ) );

            // shutdown the temporary index
            i.tearDown( );
        } finally {
            serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_CN, parserErrorHandler );
        }

    }

    private final class TestErrorHandler extends SpiDefaultParserErrorHandler {

        @Override
        public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

            if ( dotSeparatedQualifiedName.equals( "testcases.case004.B4old" ) ) {
                return callback.getType( "45F120A5CE8778345E6E45142026DF2289212782", TestMetaModels.TESTCASES_CN, "testcases.case004.B4" );
            } else {
                throw new IllegalStateException( "unexpected qualified name " + dotSeparatedQualifiedName );
            }
        }

        @Override
        public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

            throw new UnsupportedOperationException( "unexpected call" );
        }
    }

    private ByteArrayInputStream getContentOfErrorHandleTestPartition( ) {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases' i='1' v=''/>" );
        buf.append( "<M c='1' q='testcases.case004.B4old' i='45F120A5CE8778345E6E45142026DF2289212783'/>" ); // was 45F120A5CE8778345E6E45142026DF2289212782
        buf.append( "<testcases.case004.B4old m:c='1' m:i='45ED2E29050B855406AE42C81E9EA97E02EFA276'/>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    private ByteArrayInputStream getContentTestPartition( ) {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases' i='1' v=''/>" );
        buf.append( "<M c='1' q='testcases.case004.B4' i='45F120A5CE8778345E6E45142026DF2289212782'/>" );
        buf.append( "<testcases.case004.B4 m:c='1' m:i='45ED2E29050B855406AE42C81E9EA97E02EFA277'/>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    private ByteArrayInputStream getContentCorruptTestPartition( ) {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases' i='1' v=''/>" );
        buf.append( "<M c='1' q='testcases.case004.B4' i='45F120A5CE8778345E6E45142026DF2289212782'/>" );
        buf.append( "<testcases.case004." );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

}
