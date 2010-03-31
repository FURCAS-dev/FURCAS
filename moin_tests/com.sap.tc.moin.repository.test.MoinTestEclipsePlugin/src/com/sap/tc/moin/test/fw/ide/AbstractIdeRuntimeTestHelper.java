package com.sap.tc.moin.test.fw.ide;


import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.junit.runner.notification.RunNotifier;

import com.sap.junit.RunnerProxy;
import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.admin.ide.IdeRuntimeHost;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsFacility;
import com.sap.tc.moin.test.fw.AbstractMoinTestHelper;
import com.sap.tc.moin.test.fw.TestClientFactory;
import com.sap.tc.moin.test.testcase.MoinTestCase;

@SuppressWarnings( "nls" )
public abstract class AbstractIdeRuntimeTestHelper extends AbstractMoinTestHelper implements IdeRuntimeTestHelper {



    /** *********** Construction ******************************************** */

    /**
     * constructor sets name of testcase<br>
     * Needs to be public, because MoinTestHelper instantiates this class
     */
    public AbstractIdeRuntimeTestHelper( ) {

        super( );
    }

    @Override
    protected Moin resetInternal( ) {

        return (Moin) this.executeOnIdeRuntimeHostImpl( "resetMoin" );
    }

    public static synchronized IdeRuntimeTestHelper getInstance( ) {

        IdeRuntimeTestHelper instance = null;
        try {
            instance = (IdeRuntimeTestHelper) MoinTestCase.getInstance( );
        } catch ( ClassCastException cce ) {
            throw new RuntimeException( "Problem while getting MoinIdeTestHelper. Check if the class is available.", cce );
        }
        return instance;

//        if ( _instance == null ) {
//            _instance = new MoinIdeTestHelper( );
//        }
//        return _instance;
    }

    /** ************ NEEDS TO OVERWRITE ****************************** */
    @Override
    protected Moin getMoinScenarioSpecific( ) {

        return (Moin) this.executeOnIdeRuntimeHostImpl( "getMoinInstance" );
    }

    @Override
    protected void stopMoinScenarioSpecific( ) {

        this.executeOnIdeRuntimeHostImpl( "stopMoin" );
    }

    private Object executeOnIdeRuntimeHostImpl( String methodName ) {

        String rth = System.getProperty( "com.sap.tc.moin.rthplugin" );
        if ( rth == null || rth.length( ) == 0 ) {
            rth = IdeRuntimeHost.PLUGIN_ID;
        }
        Plugin plugin = Platform.getPlugin( rth );

        if ( plugin != null ) {
            Class ideRuntimeHostImpl = plugin.getClass( );
            try {
                Method moinInstanceMethod = ideRuntimeHostImpl.getMethod( methodName );
                return moinInstanceMethod.invoke( plugin );
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }

        }
        throw new RuntimeException( "Unable to get IdeRuntimeHost Plugin." );
    }

    @Override
    public TestClientFactory getTestClientFactory( String facilityName ) {

        if ( facilityName == null ) {
            throw new IllegalArgumentException( "Parameter facilityName must not be null." );
        }

        // check if we already have such an test client factory
        TestClientFactory testClientFactory = this._testClientFactoryMap.get( facilityName );
        if ( testClientFactory == null ) {
            // get test client factory 
            testClientFactory = new IdeNwdiTestClientFactoryImpl( );

            // add it into our map
            this._testClientFactoryMap.put( facilityName, testClientFactory );
        }

        return testClientFactory;
    }

    /** ***************** Others ******************************************** */

    public String getFullDCName( String dcVendor, String dcName ) {

        return dcVendor + "/" + dcName;
    }

    /**
     * Sets whether the workspace performs autobuilds. When autobuild is on, any
     * changes made to a project and its resources automatically triggers an
     * incremental build of the workspace.
     * 
     * @param value <code>true</code> to turn on autobuilding, and
     * <code>false</code> to turn it off
     */
    public boolean setAutoBuilding( boolean value ) {

        IWorkspace ws = ResourcesPlugin.getWorkspace( );
        IWorkspaceDescription wsDescription = ws.getDescription( );
        boolean lastValue = wsDescription.isAutoBuilding( );
        if ( lastValue != value ) {
            wsDescription.setAutoBuilding( value );
            try {
                ws.setDescription( wsDescription );
            } catch ( CoreException e ) {
                throw new RuntimeException( e );
            }
        }
        return lastValue;
    }

    /* Grant access to a temporary test directory */

    /**
     * Creates and returns an empty temporary directory a test can use for file
     * system operations.<br>
     * The directory is created in a folder named MOIN_TEMP which is located in
     * a project MOIN_TEMP_PROJECT (which itself is located in the workspace
     * root directory).
     */
    public File getTemporaryTestDirectory( ) {

        IFolder createdTmpDirectory = null;

        synchronized ( TMP_DIR_CREATION_MONITOR ) {
            IProject project = ResourcesPlugin.getWorkspace( ).getRoot( ).getProject( "MOIN_TEMP_PROJECT" );
            IFolder tmpBaseDirectory = null;

            try {
                // create temporary project and base directory
                if ( !project.exists( ) ) {
                    project.create( null );
                }
                project.open( null );

                tmpBaseDirectory = project.getFolder( "MOIN_TEMP" );

                if ( !tmpBaseDirectory.exists( ) ) {
                    tmpBaseDirectory.create( true, true, null );
                }

                // create a new tmp directory
                createdTmpDirectory = tmpBaseDirectory.getFolder( "tmp" + tmpDirectoryCounter + "_" + System.currentTimeMillis( ) + "_" + Thread.currentThread( ).getId( ) );
                createdTmpDirectory.create( true, true, null );

            } catch ( CoreException e ) {
                throw new RuntimeException( "Temporary directory could not be created.", e );
            } finally {
                tmpDirectoryCounter++;
            }

            if ( !tmpBaseDirectory.exists( ) ) {
                throw new RuntimeException( "Temporary directory could not be created." );
            }

        }

        return createdTmpDirectory.getLocation( ).makeAbsolute( ).toFile( );
    }

    private static Object TMP_DIR_CREATION_MONITOR = new Object( );

    private static int tmpDirectoryCounter = 0;

    public void cleanupTemporaryTestProject( ) {

        IProject project = ResourcesPlugin.getWorkspace( ).getRoot( ).getProject( "MOIN_TEMP_PROJECT" );
        try {
            project.delete( true, null );
        } catch ( CoreException e ) {
            // nothing we can do about this
        }
    }

    @Override
    public void setTestExecutionEnvironment( RunnerProxy runner, RunNotifier notifier ) {

        MoinThreadSwitchHelper.ensureExecutionInNonUIThread( runner, notifier );
    }

    /**
     * IDE-specific implementation of getPartitonStream
     * <p>
     * If the requested partition belongs to the primary facility and a
     * meta-model data area, it delegates to the facility's MetaModelManager for
     * resolving the stream. In all other cases, an
     * UnsupportedOperationException is thrown.
     * 
     * @see com.sap.tc.moin.test.fw.AbstractMoinTestHelper#getPartitionStream(com.sap.tc.moin.repository.PRI)
     */
    @Override
    public InputStream getPartitionStream( PRI pri ) {

        Facility facility = getMoin( ).getFacilityById( pri.getDataAreaDescriptor( ).getFacilityId( ) );
        if ( facility instanceof SpiFsFacility ) {
            SpiFsFacility fsFacility = (SpiFsFacility) facility;

            if ( pri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
                try {
                    SpiPartitionStreamProvider streamProvider = (SpiPartitionStreamProvider) fsFacility.getFsMetaModelManager( );
                    return streamProvider.getPartitionStream( pri );
                } catch ( ClassCastException e ) {
                    // facility implementation does not fit
                    throw new UnsupportedOperationException( "Cannot provide partiton stream for " + pri + ": facility's meta-model manager does not implement interface " + SpiPartitionStreamProvider.class );
                }
            } else {
                IpiFsResourceManagement resourceManagement = ( (IpiFsFacilityForTest) fsFacility ).getResourceManagement( );
                IpiStorage storage = resourceManagement.getStorageResponsibleForPRI( pri );
                return storage.getInputStreamForPartitionLoad( pri );
            }
        } else if ( facility instanceof IpiFsFacilityForTest ) {
            if ( pri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
                throw new UnsupportedOperationException( "metamodel stream provision is not supported until now" );
            } else {
                IpiFsResourceManagement resourceManagement = ( (IpiFsFacilityForTest) facility ).getResourceManagement( );
                IpiStorage storage = resourceManagement.getStorageResponsibleForPRI( pri );
                return storage.getInputStreamForPartitionLoad( pri );
            }
        } else {
            throw new UnsupportedOperationException( "Cannot provide partiton stream for " + pri + " (not implemented)" );
        }
    }
}
