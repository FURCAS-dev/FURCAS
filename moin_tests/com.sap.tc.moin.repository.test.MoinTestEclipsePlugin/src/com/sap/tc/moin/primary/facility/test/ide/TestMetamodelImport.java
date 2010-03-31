package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.mmimport.MetamodelImporter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys;
import com.sap.tc.moin.repository.xmi.XmiReader;
import com.sap.tc.moin.repository.xmi.XmiReferenceProvider;
import com.sap.tc.moin.repository.xmi.XmiWriter;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;

public class TestMetamodelImport extends FacilityIdeMoinTest {

    private static final String[] PACKAGES = new String[] { "MOIN", "Model", "OCL", "PrimitiveTypes", "CorbaIdlTypes", "Reflect" };

    private File temporaryDirectory = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.temporaryDirectory = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getTemporaryTestDirectory( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        ( (IdeRuntimeTestHelper) getTestHelper( ) ).cleanupTemporaryTestProject( );
        super.afterTestMethod( );
    }

    /***************************************************************************
     * Test the rose xmi import. The test directly uses the xmi reader. It does
     * not need a property file as it is usually needed when rose xmi are
     * converted to model partitions. The imported content is not saved.
     * 
     * @throws Exception
     */
    @Test
    public void testImportRoseMetamodel( ) throws Exception {

        String oldOclSettings = System.getProperty( MoinSystemPropertyKeys.MOIN_IMPORT_OCL_CONSTRAINTS );
        System.setProperty( MoinSystemPropertyKeys.MOIN_IMPORT_OCL_CONSTRAINTS, "false" );

        // copy resources to temporary directory
        String MAIN_XML_FILE = "Company.xml";
        String PRIMITIVE_TYPES_FILE = "PrimitiveTypes.xml";
        String SOURCE_PATH = "testmm/mmr/meta";
        String[] files = new String[] { MAIN_XML_FILE, PRIMITIVE_TYPES_FILE };

        File temp = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getTemporaryTestDirectory( );

        String targetDirPath = temp.getAbsolutePath( ) + "/" + SOURCE_PATH;
        File targetDir = new File( targetDirPath );
        targetDir.mkdirs( );

        for ( String sourceFileName : files ) {
            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/" + sourceFileName );
            File destFile = new File( targetDirPath + "/" + sourceFileName );

            copyFile( srcStream, destFile );
        }

        // create connection
        MoinTestHelper testHelper = getTestHelper( );
        Moin moin = testHelper.getMoin( );

        Connection connection = this.getMoinConnection( );

        // start reader
        File mainXmiDocument = new File( targetDirPath + "/" + MAIN_XML_FILE );

        XmiReader xmiReader = connection.getXmiReader( );

        RefPackage mofExtent = connection.getPackage( null, "MOIN" );

        Collection packs = xmiReader.read( mainXmiDocument.toURI( ).toString( ), mofExtent );

        MofPackage package1 = null;
        for ( Object object : packs ) {
            MofPackage pack = (MofPackage) object;
            if ( pack.getName( ).equals( "CompanyForImportTest" ) ) {
                package1 = pack;
                break;
            }
        }

        List<ModelElement> contents = package1.getContents( );

        String[] sampleClasses = new String[] { "Employee", "Department", "WorksIn", "Manages", "Directs", "Freelance" };
        List<String> classesToFindList = Arrays.asList( sampleClasses );
        Set<String> classesToFind = new HashSet<String>( classesToFindList );

        for ( ModelElement modelElement : contents ) {
            classesToFind.remove( modelElement.getName( ) );
        }

        verify( classesToFind.isEmpty( ), "Import failed." );

        // cleanup
        ( (IdeRuntimeTestHelper) getTestHelper( ) ).cleanupTemporaryTestProject( );
        if ( oldOclSettings != null ) {
            System.setProperty( MoinSystemPropertyKeys.MOIN_IMPORT_OCL_CONSTRAINTS, oldOclSettings );
        }
    }

    private static void copyFile( InputStream srcStream, File destFile ) throws IOException {

        int BUFFER_SIZE = 1000;

        OutputStream out = new FileOutputStream( destFile );

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        while ( ( bytesRead = srcStream.read( buffer ) ) >= 0 ) {

            out.write( buffer, 0, bytesRead );
        }
        out.close( );
        srcStream.close( );
    }

    @Test
    public void testImportOfMofMetamodel( ) throws Exception {

        System.setProperty( MoinSystemPropertyKeys.MOIN_IMPORT_OCL_CONSTRAINTS, "false" );
        final Connection connection = getMoinConnection( );
        XmiWriter xmiWriter = connection.getXmiWriter( );
        xmiWriter.setReferenceProvider( new XmiReferenceProvider( ) {

            public String getIdentifier( MRI mriOfModelElement ) {

                return mriOfModelElement.getMofId( );
            }

            public String getResourceLocation( MRI mriOfModelElement ) {

                String partitionName = mriOfModelElement.getPartitionName( );
                partitionName = partitionName.substring( partitionName.lastIndexOf( '/' ) + 1, partitionName.lastIndexOf( '.' ) );
                return partitionName + ".xml";
            }
        } );
        for ( String pkg : PACKAGES ) {
            RefPackage refPkg = connection.getPackage( TestMetaModels.MOIN_MOF_CN, new String[] { pkg } );
            ModelPartition partition = ( (Partitionable) refPkg.refMetaObject( ) ).get___Partition( );
            String fileName = temporaryDirectory.getAbsolutePath( ) + "\\" + pkg + ".xml";
            OutputStream os = null;
            try {
                os = new FileOutputStream( fileName );
                connection.getXmiWriter( ).write( os, partition.getElements( ), "1.2" );
            } finally {
                if ( os != null ) {
                    os.close( );
                }
            }
        }
        File mainXmi = new File( temporaryDirectory.getAbsolutePath( ) + "\\" + PACKAGES[0] + ".xml" );
        Properties configuration = new Properties( );
        for ( int i = 0; i < PACKAGES.length; i++ ) {
            configuration.put( PACKAGES[i] + ".xml", "PF.LocalDevelopment[local]:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/" + PACKAGES[i] + ".mointest,true" );
        }
        MetamodelImporter.run( connection.getSession( ).getMoin( ), connection, mainXmi, configuration, false /* mofMode */);
    }
}
