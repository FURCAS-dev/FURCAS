/**
 * 
 */
package com.sap.tc.moin.test.fw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Abstract base clase for a {@link com.sap.tc.moin.test.fw.TestClientFactory}.
 * <p>
 * The abstract class provides a skeleton implementation for the non-facility
 * specific functionality.
 * 
 * @author D032434
 */
@SuppressWarnings( "nls" )
public abstract class AbstractTestClientFactory implements TestClientFactory {

    protected static final String USERTEMPLATE = "test_user_";

    protected static final String USERPASSWORD = "abc123";

    protected static final String CLIENTSPECTEMPLATE = "client_spec_";

    protected static final String DEFAULTDATAAREA = "DefaultDataArea";

    //    // constant for the base name of the user property group
    //    public static final String BASENAME_USER = "User";
    //
    //    // user sub properties
    //    public static final String SUBPROPERTY_ID = "id";
    //
    //    public static final String SUBPROPERTY_PW = "pw";
    //
    //    // constant for the base name of the client-spec property group
    //    public static final String BASENAME_CLIENTSPEC = "ClientSpec";
    //
    //    // (additional) client-spec sub properties
    //    public static final String SUBPROPERTY_DATA_AREA = "data_area";
    //
    //    // the test client instances are kept in a 2-dimensional array (userIndex, clientSpecIndex)
    //    // the instantiation of the client instances has to be done by the concrete subclass 
    //    protected TestClient[][] _testClients = null;
    //
    //    // number of configured users
    //    private int _userSize;
    //
    //    // number of configured client specs
    //    private int _clientSpecSize;

    private Map<IndexPair, TestClient> testClients;

    public final class IndexPair {

        int userIndex;

        int clientSpecIndex;

        @Override
        public boolean equals( Object o ) {

            if ( o instanceof IndexPair ) {
                return ( ( this.userIndex == ( (IndexPair) o ).userIndex ) && ( this.clientSpecIndex == ( (IndexPair) o ).clientSpecIndex ) );
            } else {
                return false;
            }
        }

        @Override
        public int hashCode( ) {

            int result = 17;
            result = 37 * result + userIndex;
            result = 37 * result + clientSpecIndex;
            return result;
        }
    }

    /**
     * 
     */
    protected AbstractTestClientFactory( ) {

        super( );

        // we initialize the test clinet array according to the number of configured
        // users and clients
        //TestConfigurationImpl testConfiguration = MoinTestHelper.getInstance().getTestConfiguration();
        //List propGoupList =  testConfiguration.getPropertyGroupList( BASENAME_USER );
        //_userSize = propGoupList.size();
        //propGoupList = testConfiguration.getPropertyGroupList( BASENAME_CLIENTSPEC );
        //_clientSpecSize = propGoupList.size();

        //_testClients = new TestClient[_userSize][_clientSpecSize];
        this.testClients = new HashMap<IndexPair, TestClient>( );
    }

    /**
     * Concrete base classes have to implement this method and create a
     * {@link TestClient} instance for the specified user and client-spec index.
     * 
     * @param userIndex
     * @param clientSpecIndex
     * @return a {@link TestClient} instance
     */
    protected abstract TestClient createTestClient( int userIndex, int clientSpecIndex );

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.TestClientFactory#getTestClient(int, int,
     * boolean)
     */
    public synchronized TestClient getTestClient( int userIndex, int clientSpecIndex, boolean newInstance ) {

        IndexPair indexPair = new IndexPair( );
        indexPair.userIndex = userIndex;
        indexPair.clientSpecIndex = clientSpecIndex;

        TestClient testClient = null;
        if ( newInstance || !this.testClients.containsKey( indexPair ) ) {
            // create a new instance if forced or first call
            testClient = this.createTestClient( userIndex, clientSpecIndex );
        }

        if ( !this.testClients.containsKey( indexPair ) ) {
            this.testClients.put( indexPair, testClient );
        } else if ( !newInstance ) {
            testClient = this.testClients.get( indexPair );
        }

        return testClient;
    }

    public synchronized void removeTestClient( int userIndex, int clientSpecIndex ) {

        IndexPair indexPair = new IndexPair( );
        indexPair.userIndex = userIndex;
        indexPair.clientSpecIndex = clientSpecIndex;

        this.testClients.remove( indexPair );
    }

    //        
    //        TestClient testClient = null; 
    //        if ( newInstance || _testClients[userIndex][clientSpecIndex] == null) {
    //            // create a new instance if forced or first call
    //            testClient = this.createTestClient( userIndex, clientSpecIndex );            
    //        } 
    //        
    //        if ( _testClients[userIndex][clientSpecIndex] == null ) {
    //            // always initialize empty fields 
    //            _testClients[userIndex][clientSpecIndex] = testClient;
    //        } else if ( !newInstance ) {
    //            // use the instance of the array only if no new instance was requested
    //            testClient = _testClients[userIndex][clientSpecIndex];
    //        }
    //        
    //        return testClient;
    //    }       

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.TestClientFactory#clear()
     */
    public void clear( ) {

        // loop over the array and clear all clients
        for ( Iterator<Map.Entry<IndexPair, TestClient>> iterator = this.testClients.entrySet( ).iterator( ); iterator.hasNext( ); ) {
            TestClient client = iterator.next( ).getValue( );
            client.reset( );
        }

//        this.testClients = null;

        //        
        //        for (int userIndex = 0; userIndex < _testClients.length; userIndex++) {
        //            for (int clientSpecIndex = 0; clientSpecIndex < _testClients[userIndex].length; clientSpecIndex++) {
        //                if (_testClients[userIndex][clientSpecIndex] != null) {
        //                    _testClients[userIndex][clientSpecIndex].clear();
        //                    _testClients[userIndex][clientSpecIndex] = null;
        //                }
        //            }
        //        }
    }

    //    /*
    //     * (non-Javadoc)
    //     * 
    //     * @see com.sap.tc.moin.test.fw.TestClientFactory#getClientSpecSize()
    //     */
    //    public int getClientSpecSize() {
    //        return _clientSpecSize;
    //    }
    //
    //    /*
    //     * (non-Javadoc)
    //     * 
    //     * @see com.sap.tc.moin.test.fw.TestClientFactory#getUserSize()
    //     */
    //    public int getUserSize() {
    //        return _userSize;
    //    }

    //    protected TestConfigurationImpl getTestConfiguration() {
    //        return MoinTestHelper.getInstance().getTestConfiguration();
    //    }

}
