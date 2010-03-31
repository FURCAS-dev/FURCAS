/*
 * Created on 30.01.2006
 */
package com.sap.tc.moin.repository.test.graphicsfw;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.JAVA_IO_TMPDIR;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Hashtable;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.moin.mm.gfw.pictograms.PictogramsPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.xmi.XmiReferenceProvider;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Implements the {@link RepositoryFacade} interface for the graphics framework
 * tests based on MOIN as MOF repository.
 * 
 * @author d046074
 */
public class MoinRepositoyFacadeImpl implements RepositoryFacade {

    protected static final String TEMP_OUTPUT_DIR = System.getProperty( JAVA_IO_TMPDIR ) + File.separator + "moin_milestone2" + File.separator;

    private static final ClassLoader[] DEFAULT_REF_PACKAGE_CLASS_LOADERS = new ClassLoader[] { PictogramsPackage.class.getClassLoader( ) };

    private static final String PARTITION_MRI_TESTMODEL = "PF.DefaultDataArea:DCs/sap.com/tc/moin/repository/test/graphicsfw/_comp/gfwtestmodel";

    private ModelPartition gfwTestModelPartition = null;

    protected Connection moinConnection;

    public void save( ) throws RepositoryException {

        try {
            CoreModelPartition tp = MoinTestCase.getTestHelper( ).getCoreModelPartition( moinConnection.getNullPartition( ) );
            CoreModelPartition unwrappedGfwPartition = MoinTestCase.getTestHelper( ).getCoreModelPartition( gfwTestModelPartition );
            Object[] rootElementArray = tp.getElements( ).toArray( );
            CoreConnection conn = MoinTestCase.getTestHelper( ).getCoreConnection( moinConnection );
            synchronized ( conn.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
                for ( int i = 0; i < rootElementArray.length; i++ ) {
                    CorePartitionable rootElement = (CorePartitionable) rootElementArray[i];
                    rootElement.assign___Partition( conn, unwrappedGfwPartition );
                }
            }
            moinConnection.save( );
        } catch ( Exception e ) {
            throw new RepositoryException( e );
        }
    }

    public void revert( ) throws RepositoryException {

        try {
            moinConnection.revert( );
        } catch ( RuntimeException e ) {
            throw new RepositoryException( e );
        }
    }

    /**
     * Default constructor. Ensures that the GFW meta-model is available.
     */
    public MoinRepositoyFacadeImpl( ) {

    }

    public void closeConnection( ) throws RepositoryException {

        try {
            if ( moinConnection != null ) {
                moinConnection.close( );
                moinConnection = null;
            }
        } catch ( RuntimeException e ) {
            throw new RepositoryException( e.toString( ) );
        }
    }

    public void writeToFile( Collection elements, String relativeFileName ) throws java.io.IOException {

        relativeFileName = TEMP_OUTPUT_DIR.concat( relativeFileName );

        // create tmp directory if required
        File dir = new File( TEMP_OUTPUT_DIR );
        if ( !dir.exists( ) ) {
            dir.mkdirs( );
        }
        File f = new File( relativeFileName );
        f.createNewFile( );
        FileOutputStream fos = new FileOutputStream( f );

        writeToStream( elements, fos );

        fos.close( );
    }

    public RefPackage selectRefPackage( String containerName, String refPackageName ) {

        return (RefPackage) moinConnection.getPackage( containerName, new String[] { refPackageName } );
    }

    public void getConnection( ) throws RepositoryException {

        try {
            if ( moinConnection == null ) {

                //MoinTestFactory.setConfigurationFileNames(NwdiMoinTest.class.getName(),"test.bootstrap.properties");

                // get the default test client
                TestClient defaultTestClient = MoinTestCase.getTestHelper( ).getDefaultTestClient( true );
                defaultTestClient.setAsCurrentClient( );
                moinConnection = defaultTestClient.getConnection( );

                /*
                 * PRI testModelPri =
                 * MoinImpl.getMoinInstance().createPri(PARTITION_MRI_TESTMODEL);
                 * gfwTestModelPartition = moinConnection.getPartition(testModelPri); if
                 * (gfwTestModelPartition == null) { gfwTestModelPartition =
                 * moinConnection.createPartition(testModelPri); }
                 */
                gfwTestModelPartition = defaultTestClient.getOrCreatePartition( "gfwtestmodel" );
            }
        } catch ( Exception e ) {
            throw new RepositoryException( e );
        }
    }

    private static ClassLoader[] getDefaultRefPackageClassLoaders( ) {

        return DEFAULT_REF_PACKAGE_CLASS_LOADERS;
    }

    public OutputStream writeToStream( Collection elements ) throws IOException {

        OutputStream os = new ByteArrayOutputStream( );
        writeToStream( elements, os );
        return os;
    }

    protected OutputStream writeToStream( Collection elements, OutputStream os ) throws IOException {

        XmiReferenceProvider actualXmiReferenceProvider = moinConnection.getXmiWriter( ).getReferenceProvider( );
        moinConnection.getXmiWriter( ).setReferenceProvider( new XmiReferenceProvider( ) {

            private int counter = 0;

            private Hashtable mofIdToXMIId = new Hashtable( );

            public String getResourceLocation( MRI mriOfModelElement ) {

                try {
                    return mriOfModelElement.getPri( ).toString( );
                } catch ( Exception ex ) {
                    throw new RuntimeException( ex );
                }
            }

            public String getIdentifier( MRI mriOfModelElement ) {

                return getXmiIdFromMofId( mriOfModelElement.getMofId( ) );
            }

            private String getXmiIdFromMofId( String mofId ) {

                if ( mofIdToXMIId.containsKey( mofId ) ) {
                    return (String) mofIdToXMIId.get( mofId );
                } else {
                    String xmiId = "a" + ( counter++ );
                    mofIdToXMIId.put( mofId, xmiId );
                    return xmiId;
                }
            }

        } );
        moinConnection.getXmiWriter( ).write( os, elements, "1.2" );
        moinConnection.getXmiWriter( ).setReferenceProvider( actualXmiReferenceProvider );
        return os;
    }
}
