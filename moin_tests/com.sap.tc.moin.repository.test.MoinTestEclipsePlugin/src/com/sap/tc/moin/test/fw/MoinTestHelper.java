package com.sap.tc.moin.test.fw;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.net.URL;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.management.ObjectName;

import org.junit.runner.notification.RunNotifier;

import com.sap.junit.RunnerProxy;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;

@SuppressWarnings( "nls" )
public interface MoinTestHelper {

    // system property for the test configuration filename
    public static final String SYS_PROP_TEST_CONF_FILENAME = "moin.test.configuration";

    public static final String PROP_DEFAULT_BOOTSTRAP_PROPERTIES = "com.sap.tc.moin.test.defaultBootstrap";

    // extension for properties files
    public static final String EXT_PROPERTIES = ".properties";

    // default partition suffix for tests
    public static final String TEST_PARTITION_SUFFIX = ".mointest";

    // partition suffix for meta model partitions
    public static final String MM_PARTITION_SUFFIX = ".moinmm";

    public static final String TEST_SCENARIO_KEY = "com.sap.tc.moin.scenario";

    public static final String TEST_SCENARIO_IDE = "IdeProductive";

    public abstract Moin getMoin( ) throws IllegalStateException;

    public abstract Facility getDefaultFacility( ) throws IllegalStateException;

    /**
     * @return the name of the default facility
     * @throws IllegalStateException, if no default facility name was specified
     * in the test configuration
     */
    public abstract String getDefaultFacilityId( );

    public abstract Facility getFacility( String name ) throws IllegalStateException;

    /**
     * Forces a re-initialization of the test framework and the MOIN instance. A
     * new MOIN instance will be created!
     * <p>
     * Note that this does not reinitialize the test configuration.
     */
    public abstract void reset( );

    /**
     * Gets the {@link TestClientFactory} for the specified facility name.
     * 
     * @param facilityName
     * @return the {@link TestClientFactory} for the specified facility name or
     * <code>null</code>, if no factory class is configured fro this kind of
     * facility
     */
    public abstract TestClientFactory getTestClientFactory( String facilityName );

    public abstract String getJarFileName( URL url ) throws IOException;

    /**
     * Tries to look up the specified resource in the classpath and get a URL
     * for it; throws an exception, if the resource canot be found
     * 
     * @param qualifiedResourceName
     * @return
     * @throws IOException, if the resource cannot be found
     */
    public abstract URL getResourceURL( String qualifiedResourceName ) throws IOException;

    /**
     * Gets a test client of the default facility for the specified user idnex
     * and client spec index.
     * <p>
     * This is just a convenience method. For getting test clients for a
     * specific facility, or getting several instances for one client, the
     * {@link TestClientFactory} has to be used.
     * 
     * @param userIndex the user index of the requested test client
     * @param clientSpecIndex the client-spec index of the requested test client
     * @param newInstance newInstance if <code>true</code>, a new instance of
     * this test client is created in any case, otherwise, an already existing
     * instance is returned in subsequent calls
     * @return a test client for the specified user index and client spec index
     */
    public abstract TestClient getDefaultTestClient( int userIndex, int clientSpecIndex, boolean newInstance );

    /**
     * Gets the default test client, i.e. a test client of the default facility
     * with user index 0 and client spec index 0.
     * 
     * @param newInstance if <code>true</code>, a new instance of this test
     * client is created in any case, otherwise, an already existing instance is
     * returned in subsequent calls
     * @return the default test client
     */
    public abstract TestClient getDefaultTestClient( boolean newInstance );

    public abstract void stopMoin( );

    public abstract CoreMoin getCoreMoin( );

    public abstract CoreSession getCoreSession( Session session );

    public abstract CoreConnection getCoreConnection( Connection connection );

    public abstract SpiJmiHelper getSpiJmiHelper( JmiHelper jmiHelper );

    public abstract CoreModelPartition getCoreModelPartition( ModelPartition partition );

    public abstract RefObject getCoreRefObject( RefObject refObject );

    public abstract CorePartitionable getCorePartitionable( Partitionable partitionable );

    @SuppressWarnings( "unchecked" )
    public abstract Collection getUnwrappedCollection( Collection collection );

    public abstract JmxRemoteConnection createJmxRemoteConnection( ObjectName objectName );

    public abstract ReferenceQueue getHousekeepingReferenceQueue( );

    public void setTestConfigurationFile( String filename );

    public SpiRuntimeContext getRuntimeContext( );

    public void setTestExecutionEnvironment( RunnerProxy runner, RunNotifier notifier );

    /**
     * Provides a partition XMI input stream for the specified PRI.
     * <p>
     * This is a utility method to allow low-level persistence tests, but
     * independently from the concrete persistence implementation. It can be
     * used for meta-model partitions as well as for model partitions. The
     * method can only be implemented for facilities which use partition streams
     * as primary partition persistence.
     * 
     * @param pri the identifier of the partition
     * @return a partition XMI input stream for the specified PRI
     * @throws UnsupportedOperationException if the facility cannot provide a
     * stream for the PRI
     */
    public InputStream getPartitionStream( PRI pri );
}