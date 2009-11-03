package com.sap.tc.moin.repository.test.ocl.base;

import static com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys.OCL_SHOW_JMI_TREE;

import java.awt.Rectangle;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.__impl.MoinPackageImpl;
import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.treeviewer.JmiTreeViewer;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Base class for all OCL tests except the metamodel import stuff
 * 
 * @author d022737
 */
public abstract class BaseOclIntegrationTest extends MoinTestCase {

    /**
     * constants for the meta-models used by the tests
     */
    public static final String[] TEST_METAMODELS = { TestMetaModels.SERVICE_INTERACTIONS, TestMetaModels.COMPANY };

    protected MoinPackageImpl mofPkg;

    protected IOclParser parser;

    protected ModelPackage modelPackage;

    private boolean showJmiTree = false;


    private Connection connection;

    protected Object syncObjectForWrite;

    /**
     * See the base class
     * 
     * @param name the name
     */
    public BaseOclIntegrationTest( String name ) {

        super( name );
    }

    /**
     * See the base class
     */
    public BaseOclIntegrationTest( ) {

        super( );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        this.beforeTestMethod( false );
    }

    /**
     * Allows to force the reimport
     * 
     * @param forceReimport
     * @throws Exception
     */
    public void beforeTestMethod( boolean forceReimport ) throws Exception {

        //MoinTestHelper.setTestConfigurationFile( "nwdiTestConfiguration.properties" );
        super.beforeTestMethod( );

        // make sure that the meta-models used by the tests are available
        //        if (forceReimport) {
        //            MoinTestHelper.getInstance().deleteAndImportMetaModels(TEST_METAMODELS);
        //        }

        this.connection = createConnection( );
        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( connection );
        this.mofPkg = (MoinPackageImpl) coreConnection.getPackage( MoinPackage.PACKAGE_DESCRIPTOR );
        this.modelPackage = this.mofPkg.getModel( coreConnection );
        this.showJmiTree = "true".equalsIgnoreCase( System.getProperty( OCL_SHOW_JMI_TREE ) );

        this.syncObjectForWrite = coreConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( );
    }

    protected void showJmiTree( RefObject root ) {

        if ( this.showJmiTree ) {
            CoreConnection cconn;
            if ( connection instanceof Wrapper ) {
                cconn = (CoreConnection) ( (Wrapper) connection ).unwrap( );
            } else {
                cconn = (CoreConnection) connection;
            }
            JmiTreeViewer viewer = new JmiTreeViewer( root, cconn );
            viewer.setModal( true );
            viewer.setBounds( new Rectangle( 100, 100, 400, 500 ) );
            viewer.setVisible( true );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.mofPkg = null;
        this.parser = null;
        this.modelPackage = null;
        this.syncObjectForWrite = null;
        super.afterTestMethod( );
    }

}