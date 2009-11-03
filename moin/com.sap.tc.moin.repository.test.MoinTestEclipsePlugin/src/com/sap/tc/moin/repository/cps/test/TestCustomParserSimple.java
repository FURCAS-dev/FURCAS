package com.sap.tc.moin.repository.cps.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.junit.Before;
import org.junit.Test;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.primary.facility.test.ide.FacilityIdeMoinTest;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerCustomCallback;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case025.B25;
import com.sap.tc.moin.testcases.case025.C25;
import com.sap.tc.moin.testcases.case025.D25;

public class TestCustomParserSimple extends FacilityIdeMoinTest {

    private static final String CUSTOM_PARTITION_NAME = "CustomPartition.cpstest";

    private static final String CUSTOM_PARTITION_NAME_RO = "CustomPartitionReadOnly.cpstestreadonly";

    private static final String PREFIX = "src/models/";

    private static final String PREFIX_EXTRA = "src/addon/modeldata/";

    private static final String PREFIX2 = "src/mymodels/";

    private static final String CPSTEST_SUFFIX = ".cpstest";

    private static final String CPSTEST_SUFFIX_RO = ".cpstestreadonly";

    private static final String CPSTEST_SUFFIX_2 = ".cpstest2";

    private static final String CPSTEST_SUFFIX_ONEONLY = ".cpsoneonly";

    private static final String MOINCRYPT_SUFFIX = ".mointestcrypt";

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    // Convenience:
    final boolean NEW_INSTANCE = true;

    /**
     * Test-SetUp:Perform the standard set-up procedure
     * <p>
     * The packageExtend for models of the used meta model is retrieved.
     * </p>
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // Retrieve the packageExtend for the MetaModel (which later is needed to create the respective model elements)
        String modelContainerName = null;
        String[] qualifiedName = new String[] { TestMetaModels.SERVICE_INTERACTIONS };
        _packageExtendForServiceInteractionsModels = (ServiceInteractionsPackage) ( getMoinConnection( ).getPackage( modelContainerName, qualifiedName ) );
        if ( _packageExtendForServiceInteractionsModels == null ) {
            throw new RuntimeException( "PackageExtend for ServiceInteraction models could not be retrieved." );
        }

    }

    private Properties getPartitionAsProperties( ModelPartition partition_01 ) {

        // TODO Auto-generated method stub
        return null;
    }

    private void copyFile( InputStream srcStream, File destFile, ContentModifier modifCallback ) throws IOException {

        int BUFFER_SIZE = 1000;

        OutputStream out = new FileOutputStream( destFile );

        BufferedReader reader = new BufferedReader( new InputStreamReader( srcStream ) );

        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( out ) );

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

    private B1 createB1( Connection conn ) {

        return conn.createElementInPartition( B1.class, null );
    }

    private A17 createA17( Connection conn ) {

        return conn.createElementInPartition( A17.class, null );
    }

    private C25 createC25( Connection conn ) {

        return conn.createElementInPartition( C25.class, null );
    }

    private B25 createB25( Connection conn ) {

        return conn.createElementInPartition( B25.class, null );
    }

    private D25 createD25( Connection conn ) {

        return conn.createElementInPartition( D25.class, null );
    }

    private T8 createT8( int field1, String field2, Connection conn ) {

        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );
        TestcasesPackage testcasesPackage = (TestcasesPackage) conn.getPackage( null, new String[] { "testcases" } );

        Case008Package case008Package = testcasesPackage.getCase008( );
        contT8.put( T8.DESCRIPTORS.FIELD1( ), field1 ).put( T8.DESCRIPTORS.FIELD2( ), field2 );
        T8 a = case008Package.createT8( contT8 );

        return a;
    }

    private A4 createA4( Connection conn ) {

        return conn.createElementInPartition( A4.class, null );
    }

    private A8 createA8( Connection conn ) {

        return conn.createElementInPartition( A8.class, null );
    }

    /**
     * Tests the dc type registration. The test uses a dummy dc type that is not
     * marked as moin relevant.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomParserWithDummyDc( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            // create java project
            String dcVendor = "test.sap.com";
            String dcName = "dummy/srcModelCustomParser";
            String fullDcName = dcVendor + "/" + dcName;

            IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalDummyDCProject( dcVendor, dcName );

            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseProject );

            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseProject, true );

            SpiClientSpec clientSpec = getClientSpec( eclipseProject );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index            
            String partitionName = PREFIX + CUSTOM_PARTITION_NAME;
            PRI customPri = getResourceIdentifierFactory( ).createPri( clientSpec.getDataArea( ).getName( ), fullDcName, partitionName );

            // get file of existing partition
            File file = eclipseProject.getFolder( PREFIX ).getRawLocation( ).toFile( );
            String targetDirPath = eclipseProject.getFolder( PREFIX ).getRawLocation( ).toString( );
            file.mkdirs( );

            // create custom file - copy from class path
            String[] files = new String[] { CUSTOM_PARTITION_NAME };
            String SOURCE_PATH = "cpstest";
            for ( String sourceFileName : files ) {
                InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/" + sourceFileName );
                File destFile = new File( targetDirPath + "/" + sourceFileName );

                copyFile( srcStream, destFile, null );
            }

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseProject, true );

            ModelPartition partition = connection.getPartition( customPri );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            boolean contentOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                } else if ( partitionable instanceof C25 ) {
                    C25 c25Instance = (C25) partitionable;
                    if ( c25Instance.getExternalId( ).equals( "1" ) ) {
                        if ( c25Instance.getToEnd( ) != null ) {
                            contentOk = true;
                        }
                    }
                }
            }

            verify( attributesOk, "Attributes not correctly set" );
            verify( contentOk, "C25 content not correctly set" );

            partition.delete( );
            connection.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;
        }

    }

    /**
     * Test the registration of dc types. This test covers the a second folder
     * registration for an already registered dc type.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomParserWithSecondDummyDc( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            // create java project
            String dcVendor = "test.sap.com";
            String dcName = "dummy/srcModelCustomParser";
            String fullDcName = dcVendor + "/" + dcName;

            IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalDummyDCProject( dcVendor, dcName );

            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseProject );

            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseProject, true );

            SpiClientSpec clientSpec = getClientSpec( eclipseProject );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index            
            String partitionName = PREFIX2 + CUSTOM_PARTITION_NAME;
            PRI customPri = getResourceIdentifierFactory( ).createPri( clientSpec.getDataArea( ).getName( ), fullDcName, partitionName );

            // get file of existing partition
            File file = eclipseProject.getFolder( PREFIX2 ).getRawLocation( ).toFile( );
            String targetDirPath = eclipseProject.getFolder( PREFIX2 ).getRawLocation( ).toString( );
            file.mkdirs( );

            // create custom file - copy from class path
            String[] files = new String[] { CUSTOM_PARTITION_NAME };
            String SOURCE_PATH = "cpstest";
            for ( String sourceFileName : files ) {
                InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/" + sourceFileName );
                File destFile = new File( targetDirPath + "/" + sourceFileName );

                copyFile( srcStream, destFile, null );
            }

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseProject, true );

            ModelPartition partition = connection.getPartition( customPri );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            boolean contentOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                } else if ( partitionable instanceof C25 ) {
                    C25 c25Instance = (C25) partitionable;
                    if ( c25Instance.getExternalId( ).equals( "1" ) ) {
                        if ( c25Instance.getToEnd( ) != null ) {
                            contentOk = true;
                        }
                    }
                }
            }

            verify( attributesOk, "Attributes not correctly set" );
            verify( contentOk, "C25 content not correctly set" );

            partition.delete( );
            connection.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;
        }

    }

    /**
     * Tests the integration of a simple custom error handler.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomErrorHandler( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );
//            IpiIdeNwdiService diService = getIdeDiService( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomErrorHandler";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomPartition" );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );

            // create some content
            A17 a = this.createA17( connection );
            A17 b = this.createA17( connection );
            a.getToEnd( ).add( b );
            final A4 c = this.createA4( connection );
            c.setOnePrimitive( "Value" );

            partition_01.assignElement( a );
            partition_01.assignElement( b );
            partition_01.assignElement( c );

            connection.save( );

            // get file of existing partition
            IFile fileHandle = getFileHandle( mmPri_01 );

            String targetDirPath = fileHandle.getParent( ).getRawLocation( ).toString( );
            File destFile = new File( targetDirPath + "/" + "CustomPartitionCopy.mointest" );

            InputStream contents = fileHandle.getContents( );

            // TODO create error in partition stream (replace type mof id)

            copyFile( contents, destFile, new ContentModifier( ) {

                public String getModifiedLine( String line ) {

                    // replace type of A4 with non existing id testcases.case004.A4
                    //return line.replace( c.refMetaObject( ).refMofId( ), "AAAA20A5262EE936B46A48E038C5DC113D1AAAA" );
                    String modifiedLine = line.replace( "testcases.case004.A4", "testcases.case004.AXX" );
                    return modifiedLine.replace( A4.CLASS_DESCRIPTOR.getMofId( ), "AAAAAAA5BFE73C9EE91342E2330BAC6ECFF5FD7B" );
                }

            } );

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );

            // remove original partition
            partition_01.delete( );
            connection.save( );

            String newPartitionName = mmPri_01.getPartitionName( ).replace( "CustomPartition", "CustomPartitionCopy" );

            PRI customPri = getResourceIdentifierFactory( ).createPri( mmPri_01.getDataAreaDescriptor( ).getDataAreaName( ), mmPri_01.getContainerName( ), newPartitionName );

            ModelPartition partition = connection.getPartition( customPri );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            // check content
            int A17Count = 0;
            Collection<Partitionable> elements = partition.getElements( );
            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A17 ) {
                    A17Count++;
                }
            }

            // The error handler has converted one element A4 into A17
            verify( A17Count == 3, "Unexpected partition content (expected 3, but was " + A17Count );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;
        }

    }

    /**
     * Tests the integration of a simple test custom parser, shipped with the
     * testcases metamodel. The test creates a regular dc with a MOIN partition
     * and copies a custom model file into the created directory structure. The
     * custom model file with suffix "cpstest" is then parsed by the test
     * parser.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomSerializer( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomParser";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomSerializerPartition" );
            partitionName_01 = partitionName_01.replace( MoinTestHelper.TEST_PARTITION_SUFFIX, CPSTEST_SUFFIX );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );

            createContentForPartition( connection, partition_01 );

            connection.save( );

            Connection connection2 = this.getSecondMOINConnection( );

            ModelPartition partition = connection2.getPartition( mmPri_01 );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            boolean contentOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                } else if ( partitionable instanceof C25 ) {
                    C25 c25Instance = (C25) partitionable;
                    if ( c25Instance.getExternalId( ).equals( "1" ) ) {
                        if ( c25Instance.getToEnd( ) != null ) {
                            contentOk = true;
                        }
                    }
                }
            }

            verify( attributesOk, "Attributes not correctly set" );
            verify( contentOk, "C25 content not correctly set" );

            // get file of existing partition
            IFile fileHandle = getFileHandle( mmPri_01 );

            String filePath = fileHandle.getRawLocation( ).toString( );

            FileInputStream file = new FileInputStream( filePath );

            Properties props = new Properties( );

            props.load( file );

            file.close( );

            String structureString = props.getProperty( "Structure|44|oneStructureT" );
            verify( ( structureString != null ) && ( structureString.equals( "field1:12|field2:Value" ) ), "Structure not correctly written." );

            String compositionString = props.getProperty( "Link|Composition|1|2" );
            verify( ( compositionString != null ), "Composition not correctly written." );

            partition_01.delete( );
            connection2.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Tests the integration of a simple test custom parser, shipped with the
     * testcases metamodel. The test creates a regular dc with a MOIN partition
     * and copies a custom model file into the created directory structure. The
     * custom model file with suffix "cpstest" is then parsed by the test
     * parser.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomParser( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomParser";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomPartition" );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );

            // create some content
            A17 a = this.createA17( connection );
            A17 b = this.createA17( connection );
            a.getToEnd( ).add( b );
            A4 c = this.createA4( connection );
            c.setOnePrimitive( "Value" );

            partition_01.assignElement( a );
            partition_01.assignElement( b );
            partition_01.assignElement( c );

            connection.save( );

            // get file of existing partition
            IFile fileHandle = getFileHandle( mmPri_01 );

            String targetDirPath = fileHandle.getParent( ).getRawLocation( ).toString( );

            // create custom file - copy from class path
            String[] files = new String[] { CUSTOM_PARTITION_NAME };
            String SOURCE_PATH = "cpstest";
            for ( String sourceFileName : files ) {
                InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/" + sourceFileName );
                File destFile = new File( targetDirPath + "/" + sourceFileName );

                copyFile( srcStream, destFile, null );
            }

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );

            // load custom partition
            String priString = mmPri_01.toString( );

            String newPriString = priString.replace( ".mointest", CPSTEST_SUFFIX );

            PRI customPri = getResourceIdentifierFactory( ).createPri( newPriString );

            ModelPartition partition = connection.getPartition( customPri );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            boolean contentOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                } else if ( partitionable instanceof C25 ) {
                    C25 c25Instance = (C25) partitionable;
                    if ( c25Instance.getExternalId( ).equals( "1" ) ) {
                        if ( c25Instance.getToEnd( ) != null ) {
                            contentOk = true;
                        }
                    }
                }
            }

            verify( attributesOk, "Attributes not correctly set" );
            verify( contentOk, "C25 content not correctly set" );

            partition_01.delete( );
            partition.delete( );
            connection.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;
        }

    }

    /**
     * Tests the registration of the textverticalization callback.
     */
    @Test
    public void testTextVerticalizationCallback( ) {

        // there is no better test yet, test it directly

        // register custom serializer
        SpiS2XSerializerCustomCallback serializerCallback = getPartitionSerializationManager( ).getCustomS2XSerializerCallback( "test.sap.com/tc/moin/metamodel/testcases" );

        verify( serializerCallback != null, "S2X callback not found." );

    }

    /**
     * Tests the integration of a simple test custom parser, shipped with the
     * testcases metamodel. The test creates a regular dc with a MOIN partition
     * and copies a custom model file into the created directory structure. The
     * custom model file with suffix "cpstest" is then parsed by the test
     * parser.
     * 
     * @throws Exception
     */
    @Test
    public void testDelegatingCustomParserSerializer( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomParser";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomPartitionDelegated" );
            partitionName_01 = partitionName_01.replace( MoinTestHelper.TEST_PARTITION_SUFFIX, MOINCRYPT_SUFFIX );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );

            createContentForPartition( connection, partition_01 );

            connection.save( );

            Connection connection2 = this.getSecondMOINConnection( );

            ModelPartition partition = connection2.getPartition( mmPri_01 );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                }
            }

            verify( attributesOk, "Attributes not correctly set" );

            partition.delete( );
            connection2.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }


    /**
     * Tests the undeployment of a custom parser/serializer.
     * 
     * @throws Exception
     */
    //@Test
    public void testSuffixTemp( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomParser";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomPartition44" );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );

            connection.save( );

            String SOURCE_PATH = "cpstest";

            // register custom serializer

            // load custom partition
            String priString = mmPri_01.toString( );

            String newPriString = priString.replace( ".mointest", ".tempreg" );

            boolean failed = false;
            try {
                getResourceIdentifierFactory( ).createPri( newPriString );
            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            }

            verify( !failed, "Custom parser/serializer not correctly deployed." );

            partition_01.delete( );
            connection.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Tests the registration of the content selection criteria.
     * 
     * @throws Exception
     */
    @Test
    public void testContentSelectionRegistration( ) throws Exception {

        String propertyString = "dcTypeName=com.sap.tc.moin.test.di.dctype.dummy.DummyTest\ndcTypeVendor=test.sap.com\nfolder=src/models\nfolder_0=moin/models";
        byte[] bytes = propertyString.getBytes( );
        ByteArrayInputStream inStream = new ByteArrayInputStream( bytes );

        Properties referenceForDeployed = new Properties( );
        referenceForDeployed.load( inStream );

        try {
            boolean regOk = false;

            // get registrations
            Collection<Properties> customRegistrationCollection = getPartitionSerializationManager( ).getCustomContentSelections( "DI" );

            if ( customRegistrationCollection != null ) {

                for ( Properties customRegistrations : customRegistrationCollection ) {

                    boolean found = false;
                    for ( Object key : referenceForDeployed.keySet( ) ) {
                        if ( customRegistrations.containsKey( key ) ) {
                            if ( customRegistrations.get( key ).equals( referenceForDeployed.get( key ) ) ) {
                                found = true;
                            } else {
                                found = false;
                                break;
                            }
                        } else {
                            found = false;
                            break;
                        }
                    }

                    if ( found ) {
                        regOk = true;
                        break;
                    }
                }
            }
            verify( regOk, "Deployed custom content selection criteria not correctly registered." );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Tests the integration of a simple test custom parser, shipped with the
     * testcases metamodel. The test creates a regular dc with a MOIN partition
     * and copies a custom model file into the created directory structure. The
     * custom model file with suffix "cpstest" is then parsed by the test
     * parser.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomSerializerWithPrefixRegistration( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomParser";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomSerializerPartition" );
            partitionName_01 = partitionName_01.replace( MoinTestHelper.TEST_PARTITION_SUFFIX, CPSTEST_SUFFIX_2 );
            String partitionName_02 = makePartitionName( "CustomSerializerPartitionWithPrefix" );
            partitionName_02 = partitionName_02.replace( MoinTestHelper.TEST_PARTITION_SUFFIX, CPSTEST_SUFFIX_2 );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/moin/folder1/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );

            ModelPartition partition_02 = createPartition( clientSpec, fullDcName_01, "src/moin/folder2/" + partitionName_02 );
            PRI mmPri_02 = partition_02.getPri( );

            boolean notAllowed = false;
            try {
                createPartition( clientSpec, fullDcName_01, "src/moin/folder3/" + partitionName_02 );
            } catch ( Exception ex ) {
                notAllowed = true;
            }

            verify( notAllowed, "PRI check for prefix succeeded but should fail." );

            createContentForPartition( connection, partition_01 );

            createContentForPartition( connection, partition_02 );

            connection.save( );

            Connection connection2 = this.getSecondMOINConnection( );

            ModelPartition partition = connection2.getPartition( mmPri_01 );
            ModelPartition partition2 = connection2.getPartition( mmPri_02 );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );
            verify( ( partition2 != null ) && !partition2.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                }
            }

            verify( attributesOk, "Attributes not correctly set" );

            // get file of existing partition
            IFile fileHandle = getFileHandle( mmPri_01 );

            String filePath = fileHandle.getRawLocation( ).toString( );

            FileInputStream file = new FileInputStream( filePath );

            Properties props = new Properties( );

            props.load( file );

            file.close( );

            String structureString = props.getProperty( "Structure|44|oneStructureT" );
            verify( ( structureString != null ) && ( structureString.equals( "field1:12|field2:Value" ) ), "Structure not correctly written." );

            // check content of partition file 2
            // get file of existing partition
            IFile fileHandle2 = getFileHandle( mmPri_02 );

            String filePath2 = fileHandle2.getRawLocation( ).toString( );

            RandomAccessFile file2 = new RandomAccessFile( new File( filePath2 ), "r" );
            String line = file2.readLine( );
            file2.close( );

            verify( line.contains( "<?xml version=" ), "File is not a MOIN partition format" );

            partition_01.delete( );
            partition_02.delete( );
            connection2.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    private void createContentForPartition( Connection connection, ModelPartition partition_01 ) {

        // create some content
        C25 a = this.createC25( connection );
        C25 b = this.createC25( connection );
        a.getToEnd( ).add( b );

        B25 c = this.createB25( connection );
        c.setOnePrimitive( "Value" );

        D25 d = this.createD25( connection );

        T8 structureValue = this.createT8( 12, "Value", connection );

        d.setOneStructureT( structureValue );

        a.setExternalId( "1" );
        partition_01.assignElement( a );
        b.setExternalId( "2" );
        partition_01.assignElement( b );
        c.setExternalId( "34" );
        partition_01.assignElement( c );
        d.setExternalId( "44" );
        partition_01.assignElement( d );
    }

    /**
     * Tests the integration of a simple test custom parser, shipped with the
     * testcases metamodel. The test creates a regular dc with a MOIN partition
     * and copies a custom model file into the created directory structure. The
     * custom model file with suffix "cpstest" is then parsed by the test
     * parser.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomSerializerWithPrefixRegistrationOneOnly( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomParser";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomSerializerPartition" );
            partitionName_01 = partitionName_01.replace( MoinTestHelper.TEST_PARTITION_SUFFIX, CPSTEST_SUFFIX_ONEONLY );
            String partitionName_02 = makePartitionName( "CustomSerializerPartitionWithPrefix" );
            partitionName_02 = partitionName_02.replace( MoinTestHelper.TEST_PARTITION_SUFFIX, CPSTEST_SUFFIX_ONEONLY );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/moin/oneOnly/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );

            boolean notAllowed = false;
            try {
                createPartition( clientSpec, fullDcName_01, "src/moin/" + partitionName_02 );
            } catch ( Exception ex ) {
                notAllowed = true;
            }

            verify( notAllowed, "PRI check for prefix succeeded but should fail." );

            createContentForPartition( connection, partition_01 );

            connection.save( );

            Connection connection2 = this.getSecondMOINConnection( );

            ModelPartition partition = connection2.getPartition( mmPri_01 );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                }
            }

            verify( attributesOk, "Attributes not correctly set" );

            partition_01.delete( );
            connection2.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Tests the dc type registration. This test covers the dc type
     * regsistration which is already marked as moin relevant.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomParserWithMoinDummyDc( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            // create java project
            String dcVendor = "test.sap.com";
            String dcName = "dummymoin/srcModelCustomParser";
            String fullDcName = dcVendor + "/" + dcName;

            IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalDummyMoinDCProject( dcVendor, dcName );

            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseProject );


            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseProject, true );

            SpiClientSpec clientSpec = getClientSpec( eclipseProject );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index            
            String partitionName = PREFIX_EXTRA + CUSTOM_PARTITION_NAME;
            PRI customPri = getResourceIdentifierFactory( ).createPri( clientSpec.getDataArea( ).getName( ), fullDcName, partitionName );

            // get file of existing partition
            File file = eclipseProject.getFolder( PREFIX_EXTRA ).getRawLocation( ).toFile( );
            String targetDirPath = eclipseProject.getFolder( PREFIX_EXTRA ).getRawLocation( ).toString( );
            file.mkdirs( );

            // create custom file - copy from class path
            String[] files = new String[] { CUSTOM_PARTITION_NAME };
            String SOURCE_PATH = "cpstest";
            for ( String sourceFileName : files ) {
                InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/" + sourceFileName );
                File destFile = new File( targetDirPath + "/" + sourceFileName );

                copyFile( srcStream, destFile, null );
            }

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseProject, true );

            ModelPartition partition = connection.getPartition( customPri );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            boolean contentOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                } else if ( partitionable instanceof C25 ) {
                    C25 c25Instance = (C25) partitionable;
                    if ( c25Instance.getExternalId( ).equals( "1" ) ) {
                        if ( c25Instance.getToEnd( ) != null ) {
                            contentOk = true;
                        }
                    }
                }
            }

            verify( attributesOk, "Attributes not correctly set" );
            verify( contentOk, "C25 content not correctly set" );

            partition.delete( );
            connection.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;
        }

    }

    /**
     * Tests the integration of a simple test custom parser, shipped with the
     * testcases metamodel. The test creates a regular dc with a MOIN partition
     * and copies a custom model file into the created directory structure. The
     * custom model file with suffix "cpstest" is then parsed by the test
     * parser.
     * 
     * @throws Exception
     */
    @Test
    public void testCustomParserWithoutSerializer( ) throws Exception {

        Connection connection = null;

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            connection = getMoinConnection( );

            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/srcModelCustomParserReadOnly";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "CustomPartitionReadOnly" );
            ModelPartition partition_01 = createPartition( clientSpec, fullDcName_01, "src/readonly/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );
            connection.save( );

            // get file of existing partition
            IFile fileHandle = getFileHandle( mmPri_01 );

            String targetDirPath = fileHandle.getParent( ).getRawLocation( ).toString( );

            // create custom file - copy from class path
            String[] files = new String[] { CUSTOM_PARTITION_NAME };
            String SOURCE_PATH = "cpstest";
            for ( String sourceFileName : files ) {
                InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/" + sourceFileName );
                String targetFileName = sourceFileName.replace( CUSTOM_PARTITION_NAME, CUSTOM_PARTITION_NAME_RO );
                File destFile = new File( targetDirPath + "/" + targetFileName );

                copyFile( srcStream, destFile, null );
            }

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );

            // load custom partition
            String priString = mmPri_01.toString( );

            String newPriString = priString.replace( ".mointest", CPSTEST_SUFFIX_RO );

            PRI customPri = getResourceIdentifierFactory( ).createPri( newPriString );

            // read it
            ModelPartition partition = connection.getPartition( customPri );

            verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

            boolean attributesOk = false;
            boolean contentOk = false;
            Collection<Partitionable> elements = partition.getElements( );

            for ( Partitionable partitionable : elements ) {
                if ( partitionable instanceof A8 ) {
                    A8 a8Instance = (A8) partitionable;
                    T8 oneStructureT = a8Instance.getOneStructureT( );
                    attributesOk = oneStructureT.getField1( ) > 0;
                    attributesOk &= ( oneStructureT.getField2( ) != null );
                } else if ( partitionable instanceof C25 ) {
                    C25 c25Instance = (C25) partitionable;
                    if ( c25Instance.getExternalId( ).equals( "1" ) ) {
                        if ( c25Instance.getToEnd( ) != null ) {
                            contentOk = true;
                        }
                    }
                }
            }

            verify( attributesOk, "Attributes not correctly set" );
            verify( contentOk, "C25 content not correctly set" );

            // try to modify partition
            boolean modificationFailed = false;
            A17 newElement = this.createA17( connection );
            try {
                partition.assignElement( newElement );
            } catch ( PartitionEditingNotPossibleException ex ) {
                modificationFailed = true;
            }
            verify( modificationFailed, "Modification was possible without a serializer" );

            newElement.refDelete( );

            // try to create new partition
            boolean createFailed = false;
            String modifiedPriString = newPriString.replace( "CustomPartitionReadOnly", "CustomPartitionReadOnly2" );
            PRI newCustomPri = getResourceIdentifierFactory( ).createPri( modifiedPriString );
            try {
                connection.createPartition( newCustomPri );
            } catch ( PartitionCreatingNotPossibleException ex ) {
                createFailed = true;
            }
            verify( createFailed, "Partition could be created without available serializer" );

            // try to create new partition
            boolean deleteFailed = false;
            try {
                partition.delete( );
            } catch ( PartitionEditingNotPossibleException ex ) {
                // it is no the PartitionDeletingNotPossibleException because, before deleting, the partition is modified - the elements are removed
                deleteFailed = true;
            }

            verify( deleteFailed, "Partition could be created without available serializer" );

            partition_01.delete( );

            connection.save( );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;
        }

    }

}
