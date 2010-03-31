package com.sap.tc.moin.repository.test.performance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.test.performance.PerformanceMeter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.testcases.mc.logicalsystem.LogicalSystem;
import com.sap.tc.moin.xm.test.ps.McParser;
import com.sap.tc.moin.xm.test.ps.McSerializer;


/**
 * Performance tests for XM.
 */
@SuppressWarnings( "nls" )
public class TestPerfXm extends TestPerfBase {

    public TestPerfXm( ) {

        super( );
    }

    private IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER;

    private TestClient _testClient1;

    private ByteArrayInputStream xmlInstance;

    // Convenience:
    final boolean NEW_INSTANCE = true;


    @Before
    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );
        _testClient1 = MOIN_IDE_TEST_HELPER.getDefaultTestClient( true );
        _testClient1.setAsCurrentClient( );
        putClient1( );
        this.xmlInstance = this.getXmlInstance( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( _testClient1 != null ) {
            _testClient1.clear( );
            _testClient1 = null;
        }
        // clean handling of Moin reset.
        super.afterTestMethod( );


    }

    /**
     * Tests the performance in the import/export integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testImportExport( ) throws Exception {

        PerformanceMeter importMeter = createPerformanceMeter( "XM Import", false, "Imports an XML document to MOIN with the XM technique" );
        PerformanceMeter exportMeter = createPerformanceMeter( "XM Export", false, "Exports a MOIN model to an XML document with the XM techique" );


        Connection conn = this.getMoinConnection( );

        ModelPartition partition = _testClient1.getOrCreatePartition( "TestImportExportPerformance" );
        ModelImporter importer = conn.createModelImporter( XmParserConfiguration.getInstance( new McParser( ), null, null ) );
        ModelExporter exporter = conn.createModelExporter( XmSerializerConfiguration.getInstance( new McSerializer( ) ) );
        // save partition, so that it can be reused
        conn.save( );
        try {
            // average over 10 runs
            // first run is dry run
            for ( int i = 0; i < 11; i++ ) {

                try {
                    this.measureImport( i, importer, partition, importMeter );
                    this.measureExport( i, exporter, partition, exportMeter );
                } finally {
                    // revert
                    conn.revert( );
                }
            }
            endPerformanceMeasurement( importMeter, true );
            endPerformanceMeasurement( exportMeter, true );
        } finally {
            if ( importMeter != null ) {
                importMeter.dispose( );
            }
            if ( exportMeter != null ) {
                exportMeter.dispose( );
            }
            // revert all changes
            if ( conn != null ) {
                conn.revert( );
            }
            // delete the partitions
            if ( partition != null && !partition.isAlive( ) ) {
                partition.delete( );
            }
            if ( conn != null ) {
                conn.save( );
            }
        }
    }

    private void measureImport( int i, ModelImporter importer, ModelPartition partition, PerformanceMeter importMeter ) throws Exception {


        this.xmlInstance.reset( );
        // first is dry run
        if ( i > 0 ) {
            importMeter.start( );
        }
        // do import
        importer.doImport( this.xmlInstance, partition.getPri( ) );

        // first is dry run
        if ( i > 0 ) {
            importMeter.stop( );
        }
    }

    private void measureExport( int i, ModelExporter exporter, ModelPartition partition, PerformanceMeter exportMeter ) throws Exception {

        final OutputStream out = new ByteArrayOutputStream( );
        try {
            // first is dry run
            if ( i > 0 ) {
                exportMeter.start( );
            }
            // do export
            exporter.doExport( out, partition.getPri( ) );

            // first is dry run
            if ( i > 0 ) {
                exportMeter.stop( );
            }
        } finally {
            out.close( );
        }
    }


    /**
     * Tests the loading and writing of a partition with an XM Parser/Serializer
     * running in the CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testParsingAndSerializing( ) throws Exception {

        final PerformanceMeter parserMeter = createPerformanceMeter( "XM CPS Parser", false, "Transforms an XML document to a MOIN model with the XM-CPS technique" );

        final PerformanceMeter serializerMeter = createPerformanceMeter( "XM CPS Serializer", false, "Transforms a MOIN model to an XML document with the XM-CPS technique" );

        final String suffix = "xmmc";
        final String suffixForDcName = "xmmcp";

        IProject eclipseMMProject = null;
        try {
            final Connection connection = getMoinConnection( );

            final String dcVendor = "test.sap.com"; //$NON-NLS-1$
            final String dcName = "moin/pf/srcXmModelCustomParser" + suffixForDcName; //$NON-NLS-1$
            final String fullDcName = dcVendor + "/" + dcName; //$NON-NLS-1$
            eclipseMMProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            final String dummyPartitionName = makePartitionName( "XmPerformance" ); //$NON-NLS-1$
            final ModelPartition dummyPartition = createPartition( getClientSpec( eclipseMMProject ), fullDcName, "src/moin/meta/" + dummyPartitionName ); //$NON-NLS-1$
            final PRI dummyPRI = dummyPartition.getPri( );

            // create PRI of destination partition
            final String priString = dummyPRI.toString( );
            final String newPriString = priString.replace( ".mointest", "." + suffix ); //$NON-NLS-1$
            final PRI customPri = getResourceIdentifierFactory( ).createPri( newPriString );

            connection.save( );

            // get file of existing partition
            final IFile fileHandle = getFileHandle( dummyPRI );
            final String targetDirPath = fileHandle.getParent( ).getRawLocation( ).toString( );

            // file of destination partition
            final File destFile = new File( targetDirPath + "/" + "XmPerformance." + suffix ); //$NON-NLS-1$//$NON-NLS-2$

            for ( int i = 0; i < 11; i++ ) {
                // delete file if existing
                verify( !destFile.exists( ), "Partition does already exist" );

                // create custom file 
                this.xmlInstance.reset( );
                copyFile( this.xmlInstance, destFile, null );

                // refresh file system
                getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject, true );


                // first is dry run
                if ( i > 0 ) {
                    parserMeter.start( );
                }

                /** This call triggers the XM Parser in CPS mode. */
                final ModelPartition partition = connection.getPartition( customPri );

                // first is dry run
                if ( i > 0 ) {
                    parserMeter.stop( );
                }

                verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." ); //$NON-NLS-1$

                this.changePartition( partition );

                verify( partition.isDirty( ), "Partition is not dirty" );

                //System.out.println( "number of model elements: " + partition.getElements( ).size( ) );
                // first is dry run
                if ( i > 0 ) {
                    serializerMeter.start( );
                }
                /** Triggers the serialization. */
                connection.save( );

                // first is dry run
                if ( i > 0 ) {
                    serializerMeter.stop( );
                }
                // reset
                partition.delete( );
                connection.save( );
            }

            endPerformanceMeasurement( parserMeter, true );
            endPerformanceMeasurement( serializerMeter, true );

        } catch ( final Exception e ) {
            e.printStackTrace( );
            throw e;
        } finally {

            if ( parserMeter != null ) {
                parserMeter.dispose( );
            }
            if ( parserMeter != null ) {
                serializerMeter.dispose( );
            }
            if ( eclipseMMProject != null ) {
                eclipseMMProject.delete( true, true, null );
                // refresh file system, is necessary otherwise the next test would fail,
                // because MOIN does not yet know that the model partitions are deleted!
                try {
                    getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject, true );
                } catch ( final Exception e ) {
                    e.printStackTrace( );
                }
            }
        }
    }

    private void changePartition( ModelPartition partition ) {

        for ( Partitionable element : partition.getElements( ) ) {
            if ( element instanceof LogicalSystem ) {
                ( (LogicalSystem) element ).setDescription( "newValue" );
                return;
            }
        }
    }

    private Map<ClientSpec, Connection> _connectionMap = new HashMap<ClientSpec, Connection>( );

    private ClientSpec _testClientSpec1 = null;



    private synchronized void putClient1( ) {

        _testClientSpec1 = _testClient1.getClientSpec( );
        Connection connection = _testClient1.getConnection( );
        connection.setLabel( new Date( System.currentTimeMillis( ) ).toString( ) );
        _connectionMap.put( _testClientSpec1, connection );
    }


    /** **************** Retrieval of connections *************************** */
    /**
     * This implementation is not general, but it is related to the test clients
     * and internal maps. For general implementation see in a respective Utility
     * in the respective TestHelper.
     */
    public Connection getMoinConnection( ) {

        _testClient1.setAsCurrentClient( );
        return getMoinConnection( _testClientSpec1 );
    }


    public synchronized Connection getMoinConnection( ClientSpec clientSpec ) {

        Connection connection = _connectionMap.get( clientSpec );
        if ( connection == null || !connection.isAlive( ) ) {

            connection = createConnection( clientSpec );
            connection.setLabel( new Date( System.currentTimeMillis( ) ).toString( ) );
            _connectionMap.put( clientSpec, connection );
        }
//        else {
//            // hot_todo: [21.08.2008, sj, mk, uh]
//            // This should be removed, because the attaching to thread is normally done automatically by the ConnectionWrapper.
//            // In cases where the CoreConnection is used to perform special calls, the test case which performs this special internal
//            // handling should take care by itself that the CoreConnection is attached to thread.
//            ( (ConnectionWrapper) connection ).unwrap( ).attachToThread( );
//        }
        return connection;
    }

    /**
     * The method creates and returns the connection to MOIN which allows to
     * access the data in the given project.
     */
    private Connection createConnection( ClientSpec clientSpec ) {

        return createSession( clientSpec ).createConnection( );
    }


    /**
     * The method creates and returns a session to MOIN which allows to access
     * the data.
     */
    private Session createSession( ClientSpec clientSpec ) {

        // (1) Check preconditions:
        if ( clientSpec == null ) {
            throw new IllegalArgumentException( "NULL clientSpec in method: createSession" );
        }

        // (2) Get the CompoundClientSpec covering the given clientSpec
        CompoundClientSpec compoundClientSpec = ( (IdeCompoundDataAreaManager) getTestHelper( ).getMoin( ).getCompoundDataAreaManager( ) ).getDefaultCompoundClientSpec( clientSpec );

        // (3) Create the session for the given clientSpec
        Session session = getTestHelper( ).getMoin( ).createSession( compoundClientSpec );

        return session;
    }

    private IFile getFileHandle( PRI pri ) {

        IpiStorage storage = getResourceManagement( ).getStorageResponsibleForPRI( pri );
        if ( storage == null ) {
            return null;
        }
        IpiLogicalResource rh = storage.getPartitionResourceHandle( pri );
        return rh != null ? rh.getUnderlyingResource( IFile.class ) : null;
    }

    private IpiFsResourceManagement getResourceManagement( ) {

        return ( (IpiFsFacilityForTest) getFacility( ) ).getResourceManagement( );
    }

//    private IFile getFile( PRI pri ) {
//
//        IFile file = getFileHandle( pri );
//        return file != null && file.exists( ) ? file : null;
//    }



    /**
     * analogous to IdeNwdiTestClientImpl#getOrCreatePartition(String testName,
     * boolean useCounter), but:
     * 
     * @param clientSpec
     * @param fullDcName concatenation of vendor and DCName, separated by "/"
     * @param partitionPath is the partition path including resource folder and
     * partition suffix
     * @return
     */
    protected ModelPartition createPartition( ClientSpec clientSpec, String fullDcName, String partitionPath ) {

        DataArea dataArea = clientSpec.getDataArea( );
        PRI pri = getResourceIdentifierFactory( ).createPri( dataArea.getName( ), fullDcName, partitionPath );
        try {
            ModelPartition modelPartition = getMoinConnection( clientSpec ).getPartition( pri );
            if ( modelPartition != null ) {
                modelPartition.delete( );
                getMoinConnection( clientSpec ).save( );
            }
            modelPartition = getMoinConnection( clientSpec ).createPartition( pri );
            return modelPartition;
        } catch ( Exception e ) {
            // don't deal with checked exceptions in test cases
            throw new IllegalStateException( "'createPartition' failed because an exception was thrown:" + pri, e );
        }
    }


    private IdeCompoundDataAreaManager getIdeFacilityDispatcher( ) {

        return (IdeCompoundDataAreaManager) MOIN_IDE_TEST_HELPER.getCoreMoin( ).getCompoundDataAreaManager( );
    }


    private SpiClientSpec getClientSpec( IProject project ) {

        return (SpiClientSpec) getIdeFacilityDispatcher( ).getClientSpec( project );
    }



    //
    // Please do not cast the result to IdeResourceIdentifierFactory !!!
    // This functionality has to be provided by the IdeFacilityDispatcher interface. 
    // 
    private ResourceIdentifierFactory getResourceIdentifierFactory( ) {

        return getFacility( ).getRIFactory( );
    }


    private void copyFile( final InputStream srcStream, final File destFile, final ContentModifier modifCallback ) throws IOException {


        final OutputStream out = new FileOutputStream( destFile );

        final BufferedReader reader = new BufferedReader( new InputStreamReader( srcStream ) );

        final BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( out ) );

        String line = null;
        do {
            line = reader.readLine( );
            if ( line != null ) {

                if ( modifCallback != null ) {
                    // corrupt line
                    line = modifCallback.getModifiedLine( line );
                }

                writer.write( line );
                writer.newLine( );
            }
        } while ( line != null );

        writer.flush( );
        writer.close( );

        out.close( );

        reader.close( );
        srcStream.close( );
    }

    interface ContentModifier {

        public String getModifiedLine( String line );
    }



    private ByteArrayInputStream getXmlInstance( ) {

        StringBuilder sb = new StringBuilder( this.getgetLogicalSystemsStart( ) );
        String ls = this.getLogicalSystem( );
        sb.append( ls );
        sb.append( this.getLogicalSystemsClose( ) );

        sb.append( this.getServiceRefStart( ) );
        String sr = this.getServiceRefs( );
        sb.append( sr );
        sb.append( this.getServiceRefClose( ) );
        try {
            byte[] bytes = sb.toString( ).getBytes( "UTF-8" ); //$NON-NLS-1$
            return new ByteArrayInputStream( bytes );
        } catch ( UnsupportedEncodingException e ) {
            // cannot happen
            throw new IllegalStateException( e );
        }
    }

    private String getLogicalSystem( ) {

        StringBuilder sb = new StringBuilder( );
        for ( int i = 1; i <= 1200; i++ ) {
            sb.append( this.getLogicalSystem( Integer.toString( i ) ) );
        }
        return sb.toString( );
    }

    private String getServiceRefs( ) {

        StringBuilder sb = new StringBuilder( );
        for ( int i = 1; i <= 1200; i++ ) {
            sb.append( this.getServiceRef( Integer.toString( i ) ) );
        }
        return sb.toString( );
    }

    private String getgetLogicalSystemsStart( ) {

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<ns0:mass-configuration xmlns:ns0=\"http://www.sap.com/webas/2007/03/esoa/config/mc\" " + "xmlns:ns1=\"http://www.sap.com/webas/2007/03/esoa/config/system\" " + "xmlns:ns2=\"http://www.sap.com/webas/2007/03/esoa/config\" > "
               + "<ns0:logical-systems> ";
    }

    private String getLogicalSystem( String counter ) {

        return "<ns0:logical-system> " + "<ns1:name >LS" + counter + "</ns1:name> " + "<ns1:description >desc LS" + counter + "</ns1:description>" + "<ns1:origin>originLS" + counter + "</ns1:origin>" + "<ns1:value>" + "<ns1:key>classificationLS" + counter + "</ns1:key>"
               + "<ns1:value>valueClassificationLS" + counter + "</ns1:value>" + "</ns1:value>" + "<ns1:context-restriction >" + "<ns1:key>contextRestriction1LS" + counter + "</ns1:key>" + "<ns1:value>contextRestriction1ValueLS" + counter + "</ns1:value>" + "</ns1:context-restriction>"
               + "<ns1:context-restriction >" + "<ns1:key>contextRestriction2LS" + counter + "</ns1:key>" + "<ns1:value>contextRestriction2ValueLS" + counter + "</ns1:value>" + "</ns1:context-restriction>" + "</ns0:logical-system>";
    }

    private String getLogicalSystemsClose( ) {

        return "</ns0:logical-systems> ";
    }

    private String getServiceRefStart( ) {

        return "<ns2:service-references>";
    }

    private String getServiceRef( String counter ) {

        return "<ns2:reference type=\"WS SRef1\">" + "<ns2:name>SRef" + counter + "</ns2:name>" + "<ns2:namespace>com.sap1</ns2:namespace>" + "<ns2:logical-system-name>LS" + counter + "</ns2:logical-system-name>" + "</ns2:reference>";

    }

    private String getServiceRefClose( ) {

        return "</ns2:service-references>" + "</ns0:mass-configuration>";
    }

    static Schema getSchema( List<InputStream> inputStreams ) throws SAXException {

        if ( inputStreams == null ) {
            throw new NullPointerException( "inputStreams is null" );
        }
        Source[] docs = new Source[inputStreams.size( )];
        int counter = 0;
        for ( InputStream is : inputStreams ) {
            docs[counter] = new StreamSource( is );
            counter++;
        }
        SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        return schemaFactory.newSchema( docs );
    }



}
