package com.sap.tc.moin.test.fw;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.JAVA_CLASS_PATH;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.management.ObjectName;

import org.junit.runner.notification.RunNotifier;

import com.sap.junit.RunnerProxy;
import com.sap.tc.moin.facility.primary.AbstractPrimaryFacility;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
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
import com.sap.tc.moin.repository.core.MoinWrapper;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;

@SuppressWarnings( "nls" )
public abstract class AbstractMoinTestHelper implements MoinTestHelper {

    private Moin moin = null;

    static private String scenario = System.getProperty( "com.sap.tc.moin.scenario" );

    // system property for the test configuration filename
    public static final String SYS_PROP_TEST_CONF_FILENAME = "moin.test.configuration";

    public static final String PROP_DEFAULT_BOOTSTRAP_PROPERTIES = "com.sap.tc.moin.test.defaultBootstrap";

    // extension for properties files
    public static final String EXT_PROPERTIES = ".properties";

    // default partition suffix for tests
    public static final String TEST_PARTITION_SUFFIX = ".mointest";

    // partition suffix for meta model partitions
    public static final String MM_PARTITION_SUFFIX = ".moinmm";

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, MoinTestHelper.class );

    // the configuration filename used
    //private static String testConfFileName;

    // the singleton instance
    private static MoinTestHelper _instance;

    // the test configuration
    //private TestConfigurationImpl testConfiguration;

    private final Properties properties = new Properties( );

    // keep the test client factories per facility inside a map
    protected Map<String, TestClientFactory> _testClientFactoryMap = new HashMap<String, TestClientFactory>( );

    // Eclipse runtime conf file name
    private static final String ECLIPSE_TEST_CONF_FILE = "eclipseRuntimeTestConfiguration.properties";

    private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock( );

    /**
     * Set the default test configuration file.
     * <p>
     * This is relative to the conf folder in the project. If nothing is set,
     * the "defaultTestConfiguration.properties" will be used. This must be
     * called before the call to {@link #getInstance()}. This call has only
     * effect, if the test helper has not been initialized before. It can be
     * used for having a default test configuration set by the test case itself.
     * For running test suites, the configuration should be passed via the
     * system property. If the system property is set, it is always used,
     * regardless of the call of this method.
     * 
     * @param filename the filename
     * @throws IllegalStateException if called after initialzation of MOIN or if
     * the file can not be found.
     */
    public void setTestConfigurationFile( String filename ) {

        //testConfFileName = filename;
    }

    protected AbstractMoinTestHelper( ) {

        this.readProperties( ECLIPSE_TEST_CONF_FILE );

    }

    private void readProperties( String name ) {

        String fullname = "conf/" + name;
        URL resourceUrl = Thread.currentThread( ).getContextClassLoader( ).getResource( fullname );
        if ( resourceUrl == null ) {
            MoinTestHelper.class.getClassLoader( ).getResource( fullname );
        }
        if ( resourceUrl == null ) {
            throw new IllegalStateException( "Can not get test configuration " + fullname );
        }

        // now try to read the resource
        InputStream in = null;
        try {
            in = resourceUrl.openStream( );
            properties.load( in );
        } catch ( IOException e ) {
            throw new IllegalStateException( "Loading test configuration failed for resource " + fullname, e );
        } finally {
            if ( in != null ) {
                try {
                    in.close( );
                } catch ( IOException e2 ) {
                    // TODO: only log a warning

                }
            }
        }
    }

    /**
     * Gets the instance of the MoinTestHelper singleton. The first call of this
     * method will trigger the initialization of the test helper, i.e. loads the
     * test configuration (and depending on the deplyoment environment loads the
     * MOIN configuration and will initialize the MOIN repository).
     * 
     * @return the singleton instance
     */
    public static synchronized MoinTestHelper getInstance( ) {

        if ( _instance == null ) {
            /*
             * THE RIGTH TEST HELPER MIGHT BE DETERMINED BY A SYSTEM PARAMETER
             */
            Class helper = null;
            System.out.println( "Scenario: " + scenario );
//            if(scenario.equals( "BUILD" )){
//                try {
//                    helper = Class.forName( "com.sap.tc.moin.test.fw.build.MoinBuildTestHelper" );
//                    _instance = (MoinTestHelper) helper.newInstance( );
//                    return _instance;
//                } catch ( Exception e ) {                 
//                    e.printStackTrace();
//                }
//                
//            }
            try {
                helper = Class.forName( "com.sap.tc.moin.test.fw.ide.MoinIdeTestHelper" );
            } catch ( ClassNotFoundException e ) {
                try {
                    helper = Class.forName( "com.sap.tc.moin.test.fw.MoinTestHelper" );
                } catch ( ClassNotFoundException e1 ) {
                    logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                    throw new RuntimeException( e );
                }
            }
            try {
                _instance = (MoinTestHelper) helper.newInstance( );
//                return (MoinTestHelper) helper.getMethod( "getInstance", new Class[0] ).invoke( helper, new Object[0] );
            } catch ( IllegalAccessException e ) {
                logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
            } catch ( IllegalArgumentException e ) {
                logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
            } catch ( SecurityException e ) {
                logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
//            } catch ( InvocationTargetException e ) {
//                logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
//                throw new RuntimeException( e );
//            } catch ( NoSuchMethodException e ) {
//                logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
//                throw new RuntimeException( e );
            } catch ( InstantiationException e ) {
                logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
            }

//            _instance = new MoinTestHelper( );
        }
        return _instance;
    }

    public Moin getMoin( ) throws IllegalStateException {

        // use the factory for geting the moin instance; for different
        // enviornments, different implementations of
        // this class might be used
        this.reentrantLock.readLock( ).lock( );
        try {
            if ( this.moin == null ) {
                this.moin = this.getMoinScenarioSpecific( );
            }
        } finally {
            this.reentrantLock.readLock( ).unlock( );
        }
        return this.moin;
    }

    protected Moin getMoinScenarioSpecific( ) {

        // TO BE OVERWRITTEN IN SUB CLASSES
        throw new UnsupportedOperationException( "Method not implemented in MoinTestHelper. Should be overwritten in sub classes, or implement it here." );
    }

    public Facility getDefaultFacility( ) throws IllegalStateException {

        String facilityName = getDefaultFacilityId( );
        return getMoin( ).getFacilityById( facilityName );
    }

    /**
     * @return the name of the default facility
     * @throws IllegalStateException, if no default facility name was specified
     * in the test configuration
     */
    public String getDefaultFacilityId( ) {

        return PrimaryFacility.FACILITY_ID;

        //        String facilityName = getTestConfiguration().getDefaultFacilityId();
        //        if (facilityName == null) {
        //            throw new IllegalStateException("No default facility name specified in test configuration "
        //                + this.getTestConfiguration().getName());
        //        }
        //        return facilityName;
    }

    public Facility getFacility( String name ) throws IllegalStateException {

        if ( name == null ) {
            return this.getDefaultFacility( );
        } else {
            Facility result = getMoin( ).getFacilityById( name );
            if ( result == null ) {
                throw new IllegalStateException( "Facility with name " + name + " is unknown" );
            }
            return result;
        }
    }

    /**
     * Forces a re-initialization of the test framework and the MOIN instance. A
     * new MOIN instance will be created!
     * <p>
     * Note that this does not reinitialize the test configuration.
     */
    public void reset( ) {

        this.reentrantLock.writeLock( ).lock( );
        try {
            this.moin = this.resetInternal( );

            // reset all test clients (closes open connections, etc)
            for ( String facilityName : this._testClientFactoryMap.keySet( ) ) {
                TestClientFactory testClientFactory = this._testClientFactoryMap.get( facilityName );
                testClientFactory.clear( );
            }
//          this._testClientFactoryMap.clear( );

        } finally {
            this.reentrantLock.writeLock( ).unlock( );
        }
    }

    protected Moin resetInternal( ) {

        // reset the moin instance
        // MoinImpl.reset();
        this.stopMoin( );
        return this.getMoin( );
    }

    //    public TestConfigurationImpl getTestConfiguration() {
    //        return this.testConfiguration;
    //    }

    /**
     * Gets the {@link TestClientFactory} for the specified facility name.
     * 
     * @param facilityName
     * @return the {@link TestClientFactory} for the specified facility name or
     * <code>null</code>, if no factory class is configured fro this kind of
     * facility
     */
    public abstract TestClientFactory getTestClientFactory( String facilityName );

    public String getJarFileName( URL url ) throws IOException {

        String urlProtocol = url.getProtocol( );

        if ( "jar".equals( urlProtocol ) ) {
            String path = new URL( url.getPath( ) ).getPath( );
            String[] tokens = path.split( "!/" );

            return tokens[0];
        } else {
            throw new IllegalArgumentException( "Invalid file format of XMI import file " + url );
        }
    }

    /**
     * Tries to look up the specified resource in the classpath and get a URL
     * for it; throws an exception, if the resource canot be found
     * 
     * @param qualifiedResourceName
     * @return
     * @throws IOException, if the resource cannot be found
     */
    public URL getResourceURL( String qualifiedResourceName ) throws IOException {

        URL url = getClass( ).getClassLoader( ).getResource( qualifiedResourceName );

        if ( url == null ) {
            throw new FileNotFoundException( "Resource \"" + qualifiedResourceName + "\" not found in classpath: " + java.lang.System.getProperty( JAVA_CLASS_PATH ) );
        }

        return url;
    }

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
    public TestClient getDefaultTestClient( int userIndex, int clientSpecIndex, boolean newInstance ) {

        return getDefaultTestClientFactory( ).getTestClient( userIndex, clientSpecIndex, newInstance );
    }

    /**
     * @return the {@link TestClientFactory} for the default facility
     */
    private TestClientFactory getDefaultTestClientFactory( ) {

        return getTestClientFactory( this.getDefaultFacilityId( ) );
    }

    /**
     * Gets the default test client, i.e. a test client of the default facility
     * with user index 0 and client spec index 0.
     * 
     * @param newInstance if <code>true</code>, a new instance of this test
     * client is created in any case, otherwise, an already existing instance is
     * returned in subsequent calls
     * @return the default test client
     */
    public TestClient getDefaultTestClient( boolean newInstance ) {

        return this.getDefaultTestClient( 0, 0, newInstance );
    }

    public void stopMoin( ) {

        this.stopMoinScenarioSpecific( );
        this.moin = null;
//        String moinFactoryImpl = this.properties.getProperty( "moin.factory.class" );
//        Class moinFactoryClass = null;
//        this.moin = null;
//        try {
//            moinFactoryClass = Class.forName( moinFactoryImpl );
//        } catch ( ClassNotFoundException e ) {
//            logger.trace( MoinSeverity.ERROR, e.getMessage( ) );
//            throw new RuntimeException( e );
//        }
//        try {
//            Method moinInstanceMethod = moinFactoryClass.getMethod( "stopMoin", new Class[0] );
//            moinInstanceMethod.invoke( moinFactoryClass.getClass( ), new Object[0] );
//        } catch ( Exception e ) {
//            throw new RuntimeException( e );
//        }
    }

    protected void stopMoinScenarioSpecific( ) {

        throw new UnsupportedOperationException( "Method not implemented in MoinTestHelper. Should be overwritten in sub classes." );
    }

    public CoreMoin getCoreMoin( ) {

        if ( this.getMoin( ) instanceof Wrapper ) {
            return ( (Wrapper<CoreMoin>) this.getMoin( ) ).unwrap( );
        } else {
            return (CoreMoin) this.getMoin( );
        }
    }

    public CoreSession getCoreSession( Session session ) {

        if ( session instanceof Wrapper ) {
            return ( (Wrapper<CoreSession>) session ).unwrap( );
        } else {
            return (CoreSession) session;
        }
    }

    public CoreConnection getCoreConnection( Connection connection ) {

        if ( connection instanceof Wrapper ) {
            return ( (Wrapper<CoreConnection>) connection ).unwrap( );
        } else {
            return (CoreConnection) connection;
        }
    }

    public SpiJmiHelper getSpiJmiHelper( JmiHelper jmiHelper ) {

        if ( jmiHelper instanceof Wrapper ) {
            return ( (Wrapper<SpiJmiHelper>) jmiHelper ).unwrap( );
        } else {
            return (SpiJmiHelper) jmiHelper;
        }
    }

    public CoreModelPartition getCoreModelPartition( ModelPartition partition ) {

        if ( partition instanceof Wrapper ) {
            return ( (Wrapper<CoreModelPartition>) partition ).unwrap( );
        } else {
            return (CoreModelPartition) partition;
        }
    }

    public RefObject getCoreRefObject( RefObject refObject ) {

        if ( refObject instanceof Wrapper ) {
            return ( (Wrapper<RefObject>) refObject ).unwrap( );
        } else {
            return refObject;
        }
    }

    public CorePartitionable getCorePartitionable( Partitionable partitionable ) {

        if ( partitionable instanceof Wrapper ) {
            return (CorePartitionable) ( (Wrapper<Partitionable>) partitionable ).unwrap( );
        } else {
            return (CorePartitionable) partitionable;
        }
    }

    @SuppressWarnings( "unchecked" )
    public Collection getUnwrappedCollection( Collection collection ) {

        List result = new ArrayList( collection.size( ) );
        boolean needNewCollection = false;
        for ( Iterator it = collection.iterator( ); it.hasNext( ); ) {
            Object obj = it.next( );
            if ( obj instanceof Wrapper ) {
                result.add( ( (Wrapper) obj ).unwrap( ) );
                needNewCollection = true;
            } else {
                result.add( obj );
            }
        }
        if ( needNewCollection ) {
            return result;
        } else {
            return collection;
        }
    }

    public JmxRemoteConnection createJmxRemoteConnection( ObjectName objectName ) {

        return new JmxRemoteConnection( objectName );
    }

    public ReferenceQueue getHousekeepingReferenceQueue( ) {

        return ( (MoinWrapper) moin ).unwrap( ).getReferenceQueue( );
    }

    /**
     * Because the RTH has to inject a SpiRuntimeContext by contract into the
     * facility in <b>every</b> scenario, this getter is placed in the
     * AbstractMoinTestHelper, that is available in <b>every</b> scenario test.<br>
     * <br>
     * Note: Depending on the scenario the result can be <code>null</code>
     */
    public SpiRuntimeContext getRuntimeContext( ) {

        AbstractPrimaryFacility facility = (AbstractPrimaryFacility) this.getDefaultFacility( );
        return facility.getRuntimeContext( );
    }

    /**
     * This method is for setting the environment for the test. It is introduced
     * for the IDE scenarios where tests must be executed outside UI thread.
     */
    public void setTestExecutionEnvironment( RunnerProxy runner, RunNotifier notifier ) {

        // Standard: do nothing
        runner.realRun( notifier );
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.test.fw.MoinTestHelper#getPartitionStream(com.sap.tc.moin.repository.PRI)
     */
    public InputStream getPartitionStream( PRI pri ) {

        // might not be implemented for all scenarios
        throw new UnsupportedOperationException( "getPartitionStream() not supported by this TestHelper: " + this );
    }

}
