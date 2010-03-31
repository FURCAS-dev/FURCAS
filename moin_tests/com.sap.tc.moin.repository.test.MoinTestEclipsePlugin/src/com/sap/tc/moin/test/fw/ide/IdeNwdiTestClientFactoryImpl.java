package com.sap.tc.moin.test.fw.ide;


import com.sap.tc.moin.test.fw.NwdiTestClientFactoryImpl;
import com.sap.tc.moin.test.fw.TestClient;

/**
 * Eclipse specific implementation of the {@link TestClientFactory}.
 * 
 * @author d045397
 */
public class IdeNwdiTestClientFactoryImpl extends NwdiTestClientFactoryImpl {

    /**
     * 
     */
    public IdeNwdiTestClientFactoryImpl( ) {

        // TODO Auto-generated constructor stub

        super( );
    }

    //@Override
    @Override
    protected TestClient createTestClient( int userIndex, int clientSpecIndex ) {

        return new IdeNwdiTestClientImpl( USERPASSWORD, this, userIndex, clientSpecIndex );
    }

}
