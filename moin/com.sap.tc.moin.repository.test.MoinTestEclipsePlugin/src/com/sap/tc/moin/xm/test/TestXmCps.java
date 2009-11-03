package com.sap.tc.moin.xm.test;

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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.primary.facility.test.ide.FacilityIdeMoinTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.parser.XmParserHandler;
import com.sap.tc.moin.repository.xm.serializer.XmCustomSerializer;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.xm.test.ps.McParser;
import com.sap.tc.moin.xm.test.ps.McSerializer;
import com.sap.tc.moin.xm.test.ps.PersonParser;
import com.sap.tc.moin.xm.test.ps.PersonSerializer;
import com.sap.tc.moin.xm.test.ps.TestParser;
import com.sap.tc.moin.xm.test.ps.TestSerializer;
import com.sap.tc.moin.xm.test.ps.generated.RecursiveParser;
import com.sap.tc.moin.xm.test.ps.generated.RecursiveSerializer;
import com.sap.tc.moin.xm.test.xml.IOUtil;
import com.sap.tc.moin.xm.test.xml.XmlComparator;


/**
 * Tests for the integration of XM with CPS.
 */
@SuppressWarnings( "nls" )
public class TestXmCps extends FacilityIdeMoinTest {


    private static IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER;

    // Convenience:
    final boolean NEW_INSTANCE = true;


    @Before
    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );
    }



    /**
     * Tests the serializing of a partition with an XM Serializer running in the
     * CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testNonStringAtributesAndMultiAttributes( ) throws Exception {

        this.serialize( "com/sap/tc/moin/xm/test/ps/test.xml", "xmtest", new TestParser( ), "xmtests" );

    }

    /**
     * Tests the parsing of a partition with an XM Parser running in the CP/S
     * integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testParsingNonStringAtributesAndMultiAttributes( ) throws Exception {

        this.parse( "com/sap/tc/moin/xm/test/ps/test.xml", "xmtest", new TestSerializer( true ), "xmtestp" );
    }


    /**
     * Tests the serializing of a partition with an XM Serializer running in the
     * CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testCompanySerialization( ) throws Exception {

        this.serialize( "com/sap/tc/moin/xm/test/ps/testPerson.xml", "xmperson", new PersonParser( ), "xmpersons" );

    }

    /**
     * Tests the parsing of a partition with an XM Parser running in the CP/S
     * integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testParsingCompany( ) throws Exception {

        this.parse( "com/sap/tc/moin/xm/test/ps/testPerson.xml", "xmperson", new PersonSerializer( ), "xmpersonp" );
    }

    /**
     * Tests the serializing of a partition with an XM Serializer running in the
     * CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneratedRecursive( ) throws Exception {

        this.serialize( "com/sap/tc/moin/xm/test/ps/recursiveSource.xml", "xmrecursive", new RecursiveParser( ), "xmrecursives" );
    }



    /**
     * Tests the parsing of a partition with an XM Parser running in the CP/S
     * integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneatedParsingRecursive( ) throws Exception {

        this.parse( "com/sap/tc/moin/xm/test/ps/recursiveSource.xml", "xmrecursive", new RecursiveSerializer( ), "xmrecursivep" );
    }

    /**
     * Tests whether a different XML root element can be serialized with the
     * recursive serializer in the CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneratedRecursiveSourceStructure( ) throws Exception {

        this.serialize( "com/sap/tc/moin/xm/test/ps/recursiveSourceStructure.xml", "xmrecursive", new RecursiveParser( ), "xmrecursivestructures" );
    }

    /**
     * Tests the parsing of a partition with another XML root element with the
     * recursive XM Parser running in the CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneatedParsingRecursiveStructure( ) throws Exception {

        this.parse( "com/sap/tc/moin/xm/test/ps/recursiveSourceStructure.xml", "xmrecursive", new RecursiveSerializer( ), "xmrecursivestrucutrep" );
    }

    /**
     * Tests whether a different XML root element can be serialized with the
     * recursive serializer in the CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneratedRecursiveSourceField( ) throws Exception {

        this.serialize( "com/sap/tc/moin/xm/test/ps/recursiveSourceField.xml", "xmrecursive", new RecursiveParser( ), "xmrecursivefields" );
    }

    /**
     * Tests the parsing of a partition with another XML root element with the
     * recursive XM Parser running in the CP/S integration strategy.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneatedParsingRecursiveField( ) throws Exception {

        this.parse( "com/sap/tc/moin/xm/test/ps/recursiveSourceField.xml", "xmrecursive", new RecursiveSerializer( ), "xmrecursivefieldp" );
    }

    /**
     * Tests the Serializer API.
     * 
     * @throws Exception
     */
    @Test
    public void testSerializerApi( ) throws Exception {

        System.setProperty( "com.sap.tc.moin.xm.apitest.failure.importexport", "" );
        this.serialize( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml", "xmserializerapi", new McParser( ), "xmserializerapi", false );
        String errors = System.getProperty( "com.sap.tc.moin.xm.apitest.failure.importexport" );
        if ( errors != null ) {
            assertTrue( errors, errors.length( ) == 0 );
        }
    }


    /**
     * Tests the Parser Helper API.
     * 
     * @throws Exception
     */
    @Test
    public void testParserHelperApi( ) throws Exception {

        System.setProperty( "com.sap.tc.moin.xm.apitest.failure", "" );
        this.parse( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml", "xmapi", null, "xmapi" );
        String errors = System.getProperty( "com.sap.tc.moin.xm.apitest.failure" );
        if ( errors != null ) {
            assertTrue( errors, errors.length( ) == 0 );
        }
    }


    /**
     * Tests the exceptions of PModelElementHandle.
     * 
     * @throws Exception
     */
    @Test
    public void testPModelElementHandleTest( ) throws Exception {

        System.setProperty( "com.sap.tc.moin.xm.apitest.failure", "" );
        this.parse( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml", "xmpmodelelementhandle", null, "xmpmodelelementhandle" );
        String errors = System.getProperty( "com.sap.tc.moin.xm.apitest.failure" );
        if ( errors != null ) {
            assertTrue( errors, errors.length( ) == 0 );
        }
    }

    /**
     * Tests the inter-partition links.
     * 
     * @throws Exception
     */
    @Test
    public void testInterPartitionLink( ) throws Exception {

//        // parse referencing source
//        this.parse( "com/sap/tc/moin/xm/test/ps/mc_SourceInterPartitonLinkReferencing.xml", "xmmc", null );
//        // parse referenced source
//        this.parse( "com/sap/tc/moin/xm/test/ps/mc_SourceInterPartitonLinkReferenced.xml", "xmmc", null );
//        // check whether the referenced content can be correctly serialized

        IProject eclipseMMProject_01 = null;
        try {
            final String suffix = "xmmc";
            final Connection connection = getMoinConnection( );

            final String dcVendor = "test.sap.com"; //$NON-NLS-1$
            final String dcName_01 = "moin/pf/srcXmModelCustomParser" + suffix; //$NON-NLS-1$
            final String fullDcName_01 = dcVendor + "/" + dcName_01; //$NON-NLS-1$
            eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
//            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
//            CRI srcDc01Cri = diService.getContainer( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            final String referencingPartitionName = makePartitionName( "XmCustomPartitionReferencing" ); //$NON-NLS-1$
            final ModelPartition referencingPartition = createPartition( getClientSpec( eclipseMMProject_01 ), fullDcName_01, "src/moin/meta/" + referencingPartitionName ); //$NON-NLS-1$
            final PRI referencingPRI = referencingPartition.getPri( );

            final String referencedPartitionName = makePartitionName( "XmCustomPartitionReferenced" ); //$NON-NLS-1$
            final ModelPartition referencedPartition = createPartition( getClientSpec( eclipseMMProject_01 ), fullDcName_01, "src/moin/meta/" + referencedPartitionName ); //$NON-NLS-1$
            final PRI referencedPRI = referencedPartition.getPri( );


            connection.save( );

            // get file of existing partition
            final IFile fileHandle = getFileHandle( referencingPRI );
            final String targetDirPath = fileHandle.getParent( ).getRawLocation( ).toString( );

            // create custom file - copy from class path
            // referencing source
            String relativeSourcePath = "com/sap/tc/moin/xm/test/ps/mc_SourceInterPartitonLinkReferencing.xml";
            InputStream referencingSource = this.getClass( ).getClassLoader( ).getResourceAsStream( relativeSourcePath ); //$NON-NLS-1$
            referencingSource = new ByteArrayInputStream( IOUtil.read( referencingSource, true ) );
            File destFile = new File( targetDirPath + "/" + "XmCustomPartitionReferencing." + suffix ); //$NON-NLS-1$//$NON-NLS-2$
            copyFile( referencingSource, destFile, null );

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );


            final String referencingPriString = referencingPRI.toString( );
            final String newReferencingPriString = referencingPriString.replace( ".mointest", "." + suffix ); //$NON-NLS-1$
            final PRI referencingPri = getResourceIdentifierFactory( ).createPri( newReferencingPriString );

            // load referencing partition
            /** This call triggers the XM Parser in CPS mode. */
            final ModelPartition realReferencingPartition = connection.getPartition( referencingPri );

            verify( ( realReferencingPartition != null ) && !realReferencingPartition.getElements( ).isEmpty( ), "Partition was not correctly loaded." ); //$NON-NLS-1$

            // referenced source
            relativeSourcePath = "com/sap/tc/moin/xm/test/ps/mc_SourceInterPartitonLinkReferenced.xml";
            InputStream referencedSource = this.getClass( ).getClassLoader( ).getResourceAsStream( relativeSourcePath ); //$NON-NLS-1$
            referencedSource = new ByteArrayInputStream( IOUtil.read( referencedSource, true ) );
            destFile = new File( targetDirPath + "/" + "XmCustomPartitionReferenced." + suffix ); //$NON-NLS-1$//$NON-NLS-2$
            copyFile( referencedSource, destFile, null );

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );

            final String referencedPriString = referencedPRI.toString( );
            final String newReferencedPriString = referencedPriString.replace( ".mointest", "." + suffix ); //$NON-NLS-1$
            final PRI referencedPri = getResourceIdentifierFactory( ).createPri( newReferencedPriString );

            // load referenced partition
            /** This call triggers the XM Parser in CPS mode. */
            final ModelPartition realReferencedPartition = connection.getPartition( referencedPri );

            verify( ( realReferencedPartition != null ) && !realReferencedPartition.getElements( ).isEmpty( ), "Partition was not correctly loaded." ); //$NON-NLS-1$

            // export loaded partitions
            this.checkWithExport( referencingSource, new McSerializer( ), connection, referencingPri );

            this.checkWithExport( referencedSource, new McSerializer( ), connection, referencedPri );

            referencingSource.close( );
            referencedSource.close( );
        } catch ( final Exception e ) {

            e.printStackTrace( );
            throw e;

        } finally {
            if ( eclipseMMProject_01 != null ) {
                eclipseMMProject_01.delete( true, true, null );
                // refresh file system, is necessary otherwise the next test would fail,
                // because MOIN does not yet know that the model partitions are deleted!
                try {
                    getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );
                } catch ( final Exception e ) {
                    e.printStackTrace( );
                }
            }
        }
    }

    /**
     * Tries to execute the serialization although there is no serializer.
     */
    @Test
    public void testWithoutSerializer( ) throws Exception {

        boolean success = false;
        try {
            this.serialize( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml", "xmmcwithouts", new McParser( ), "xmmcwithouts", false );
        } catch ( IllegalStateException e ) {
            assertTrue( "wrong exception thrown: " + e.getMessage( ), e.getMessage( ).contains( "xmmcwithouts" ) );
            success = true;
        }
        assertTrue( "Expeceted IllegalStateException not thrown", success );
    }

    /**
     * Tests the serializing of a partition with an XM Serializer running in the
     * CP/S integration strategy.
     * 
     * @param relativeSourcePath path to the source XML file, for example:
     * "com/sap/tc/moin/xm/test/ps/test.xml"
     * @param suffix suffix registered in CPS for the serializer
     * @param parser parser
     * @param suffixForDcName
     * @throws Exception
     */
    private void serialize( final String relativeSourcePath, final String suffix, final XmParserHandler parser, final String suffixForDcName ) throws Exception {

        this.serialize( relativeSourcePath, suffix, parser, suffixForDcName, true );
    }


    /**
     * Tests the serializing of a partition with an XM Serializer running in the
     * CP/S integration strategy.
     * 
     * @param relativeSourcePath path to the source XML file, for example:
     * "com/sap/tc/moin/xm/test/ps/test.xml"
     * @param suffix suffix registered in CPS for the serializer
     * @param parser parser
     * @param suffixForDcName
     * @param compare
     * @throws Exception
     */
    private void serialize( final String relativeSourcePath, final String suffix, final XmParserHandler parser, final String suffixForDcName, boolean compare ) throws Exception {

        if ( relativeSourcePath == null ) {
            throw new NullPointerException( "relativeSourcePath is null" );
        }
        if ( suffix == null ) {
            throw new NullPointerException( "suffix is null" );
        }
        if ( parser == null ) {
            throw new NullPointerException( "parser is null" );
        }
        if ( suffixForDcName == null ) {
            throw new NullPointerException( "suffixForDcName is null" );
        }
        IProject eclipseMMProject_01 = null;
        try {
            final Connection connection = getMoinConnection( );

            final String dcVendor = "test.sap.com"; //$NON-NLS-1$
            final String dcName_01 = "moin/pf/srcXmModelCustomSerializer" + suffixForDcName; //$NON-NLS-1$
            final String fullDcName_01 = dcVendor + "/" + dcName_01; //$NON-NLS-1$
            eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
//            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
//            CRI srcDc01Cri = diService.getContainer( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            final ModelPartition customPartition = createPartition( getClientSpec( eclipseMMProject_01 ), fullDcName_01, "src/moin/meta/" + "XmCustomPartition." + suffix ); //$NON-NLS-1$//$NON-NLS-2$
            final PRI customPri = customPartition.getPri( );

            // fill partition with Model Importer 
            // get file of existing partition
            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( relativeSourcePath );
            // for reuse create byte array input stream
            srcStream = new ByteArrayInputStream( IOUtil.read( srcStream, true ) );

            final ModelImporter modelImporter = connection.createModelImporter( XmParserConfiguration.getInstance( parser, null, null ) ); //$NON-NLS-1$
            modelImporter.doImport( srcStream, customPri );


            /**
             * This does trigger the XM Serializer in CP/S integration strategy.
             */
            connection.save( );

            final IFile fileHandle = getFileHandle( customPri );
            // compare files 
            if ( compare ) {
                final StringBuilder differences = new StringBuilder( );
                srcStream.reset( );
                XmlComparator.compare( srcStream, fileHandle.getContents( ), differences );
                assertTrue( "The imported XML document is different from the serialized XML document: \n" + differences.toString( ), differences.length( ) == 0 ); //$NON-NLS-1$
            }
            srcStream.close( );
        } catch ( final Exception e ) {

            e.printStackTrace( );
            throw e;

        } finally {
            if ( eclipseMMProject_01 != null ) {
                try {
                    eclipseMMProject_01.delete( true, true, null );
                } catch ( final Exception e ) {
                    e.printStackTrace( );
                    eclipseMMProject_01.delete( false, false, null );
                }
                // refresh file system, is necessary otherwise the next test would fail,
                // because MOIN does not yet know that the model partitions are deleted!
                try {
                    getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );
                } catch ( final Exception e ) {
                    e.printStackTrace( );
                }
            }
        }
    }

    /**
     * Tests the loading of a partition with an XM Parser running in the CP/S
     * integration strategy.
     * 
     * @param relativeSourcePath path to the source XML file, for example:
     * "com/sap/tc/moin/xm/test/ps/test.xml"
     * @param suffix suffix registered in CPS for the serializer
     * @param serializer serializer, can be <code>null</code> check is not done
     * if the serializer is <code>null</code>
     * @param suffixForDcName
     * @throws Exception
     */
    public void parse( final String relativeSourcePath, final String suffix, final XmCustomSerializer serializer, final String suffixForDcName ) throws Exception {

        if ( relativeSourcePath == null ) {
            throw new NullPointerException( "relativeSourcePath is null" );
        }
        if ( suffix == null ) {
            throw new NullPointerException( "suffix is null" );
        }
        if ( suffixForDcName == null ) {
            throw new NullPointerException( "suffixForDcName is null" );
        }

        IProject eclipseMMProject_01 = null;
        try {
            final Connection connection = getMoinConnection( );

            final String dcVendor = "test.sap.com"; //$NON-NLS-1$
            final String dcName_01 = "moin/pf/srcXmModelCustomParser" + suffixForDcName; //$NON-NLS-1$
            final String fullDcName_01 = dcVendor + "/" + dcName_01; //$NON-NLS-1$
            eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName_01 );
//            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
//            CRI srcDc01Cri = diService.getContainer( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            final String dummyPartitionName = makePartitionName( "XmCustomPartition" ); //$NON-NLS-1$
            final ModelPartition dummyPartition = createPartition( getClientSpec( eclipseMMProject_01 ), fullDcName_01, "src/moin/meta/" + dummyPartitionName ); //$NON-NLS-1$
            final PRI dummyPRI = dummyPartition.getPri( );

            connection.save( );

            // get file of existing partition
            final IFile fileHandle = getFileHandle( dummyPRI );
            final String targetDirPath = fileHandle.getParent( ).getRawLocation( ).toString( );

            // create custom file - copy from class path
            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( relativeSourcePath ); //$NON-NLS-1$
            srcStream = new ByteArrayInputStream( IOUtil.read( srcStream, true ) );
            final File destFile = new File( targetDirPath + "/" + "XmCustomPartition." + suffix ); //$NON-NLS-1$//$NON-NLS-2$
            copyFile( srcStream, destFile, null );

            // refresh file system
            getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );

            // load custom partition
            final String priString = dummyPRI.toString( );
            final String newPriString = priString.replace( ".mointest", "." + suffix ); //$NON-NLS-1$
            final PRI customPri = getResourceIdentifierFactory( ).createPri( newPriString );

            /** This call triggers the XM Parser in CPS mode. */
            final ModelPartition partition = connection.getPartition( customPri );

            if ( serializer != null ) {
                verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." ); //$NON-NLS-1$


                // check with model exporter
                this.checkWithExport( srcStream, serializer, connection, customPri );
            }

            srcStream.close( );
        } catch ( final Exception e ) {

            e.printStackTrace( );
            throw e;

        } finally {
            if ( eclipseMMProject_01 != null ) {
                eclipseMMProject_01.delete( true, true, null );
                // refresh file system, is necessary otherwise the next test would fail,
                // because MOIN does not yet know that the model partitions are deleted!
                try {
                    getIdeFacilityDispatcher( ).refreshFromFileSystem( eclipseMMProject_01, true );
                } catch ( final Exception e ) {
                    e.printStackTrace( );
                }
            }
        }
    }

    private void checkWithExport( final InputStream originalSource, final XmCustomSerializer serializer, final Connection connection, final PRI customPri ) throws Exception {

        final ByteArrayOutputStream outputstream = new ByteArrayOutputStream( );
        final ModelExporter modelExporter = connection.createModelExporter( XmSerializerConfiguration.getInstance( serializer ) );
        modelExporter.doExport( outputstream, customPri );

        final StringBuilder differences = new StringBuilder( );
        originalSource.reset( );
        byte[] bytes = outputstream.toByteArray( );
        //String s = new String( bytes, "UTF-8" );
        XmlComparator.compare( originalSource, new ByteArrayInputStream( bytes ), differences );
        assertTrue( "The exported XML document is different from the loaded XML document: \n" + differences.toString( ), differences.length( ) == 0 ); //$NON-NLS-1$

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

}
