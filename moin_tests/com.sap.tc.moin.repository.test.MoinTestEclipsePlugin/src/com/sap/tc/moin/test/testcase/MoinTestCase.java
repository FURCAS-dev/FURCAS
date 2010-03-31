package com.sap.tc.moin.test.testcase;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.test.control.MoinAssertVerifyLog;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.MoinTestHelperSelector;
import com.sap.tc.moin.test.fw.TestClient;

/**
 * The base class for all Moin testcases.
 */

@SuppressWarnings( "nls" )
public abstract class MoinTestCase extends MoinAssertVerifyLog {

    static private boolean reset = Boolean.getBoolean( "com.sap.tc.moin.testreset" );

    private static MoinLogger testLogger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, MoinTestCase.class );

//    public static String scenario = System.getProperty(IMoinTestHelper.TEST_SCENARIO_KEY);

    /**
     * Do Not use this constructor, use the static methods. This constructor is
     * only to be called by the Junit TestCase.
     */
    protected MoinTestCase( ) {

        // nothing to do
    }

    /**
     * Do Not use this constructor, use the static methods. This constructor is
     * only to be called the Junit TestCase.
     */
    protected MoinTestCase( String arg ) {

        super( arg );
    }

    @Before
    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        // don't initialize MOIN yet, as the subclass may override the default
        // configuration
    }

    /**
     * Resets the Moin instance and tears down the test case.
     */
    @After
    @Override
    public void afterTestMethod( ) throws Exception {

        // nullOutMemberVariables();
        super.afterTestMethod( );

        if ( reset ) {
            // reset the MOIN instance
            getTestHelper( ).reset( );
        }
    }

    /**
     * Implicitly initializes the MOIN instance.
     * 
     * @return Moin the MOIN instance
     */
    public static Moin getInstance( ) {

        return getTestHelper( ).getMoin( );
    }

    /**
     * Obtains the facility that is created by default in the
     * {@link #beforeTestMethod()} operation. This can be used, e.g., to
     * initialize {@link WorkspaceImpl} instances properly with a facility.
     */
    protected static Facility getFacility( ) {

        return getTestHelper( ).getDefaultFacility( );
    }

    /**
     * Creates a connection. Therefore it uses the
     * {@link #getTestClient(boolean)} method for creating a new instance of the
     * default {@link TestClient} and returns its connection. The new connection
     * is attached to the current thread and the corresponding
     * {@link TestClient} is authenticated (if necessary).
     * 
     * @return a newly created connection
     */
    public Connection createConnection( ) throws Exception {

        // create a new instance of the default test client and return it's
        // connection
        TestClient defaultTestClient = getTestHelper( ).getDefaultTestClient( true );
        defaultTestClient.setAsCurrentClient( );
        return defaultTestClient.getConnection( );
    }

    protected void verify( boolean condition, String message ) {

        assertTrue( message, condition );
    }

    protected void flop( String message ) {

        fail( message );
    }

    protected static String classDirectory( Class object ) {

        String className = object.getName( );
        String packageName = className.substring( 0, className.lastIndexOf( '.' ) );
        char sep = fileSeparator( );
        return packageName.replace( '.', sep );
    }

    private static char fileSeparator( ) {

        // jar file-sep is '/'
        return '/';
    }

    public String getName( ) {

        return this.getTestName( );
    }

    /**
     * Completes a given string that way that it is a valid partition name.<br>
     * <br>
     * Currently it appends the suffix for test partitions
     * 
     * @param partition
     * @return
     */
    protected String makePartitionName( String partition ) {

        return partition + MoinTestHelper.TEST_PARTITION_SUFFIX;
    }

    protected String makeMmPartitionName( String partition ) {

        return partition + MoinTestHelper.MM_PARTITION_SUFFIX;
    }

    protected void assertUnmodifiableCollection( Collection collection ) {

        if ( collection == null ) {
            return;
        }

        Object dummy = new Object( );
        Collection<Object> dummyCollection = Collections.singleton( dummy );

        try {
            collection.add( dummy );
            fail( "Expected Exception" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }

        try {
            collection.addAll( dummyCollection );
            fail( "Expected Exception" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }

        try {
            collection.clear( );
            fail( "Expected Exception" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }

        try {
            collection.remove( dummy );
            fail( "Expected Exception" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }

        Iterator iterator = collection.iterator( );
        if ( iterator.hasNext( ) ) {
            iterator.next( );
            try {
                iterator.remove( );
                fail( "Expected Exception" );
            } catch ( UnsupportedOperationException e ) {
                //expected
            }
        }

        try {
            collection.removeAll( dummyCollection );
            fail( "Expected Exception" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }

        try {
            collection.retainAll( dummyCollection );
            fail( "Expected Exception" );
        } catch ( UnsupportedOperationException e ) {
            //expected
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
    public static synchronized MoinTestHelper getTestHelper( ) {

        return MoinTestHelperSelector.getScenarioSpecificTestHelper( );
    }
//    public static IMoinTestHelper getTestHelper( ) {
//
//        return MoinTestHelper.getInstance( );
//    }

}
