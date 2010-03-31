package com.sap.tc.moin.friends.test;

import org.junit.Test;

import com.sap.tc.moin.friends.factory.UtilitiesFactory;


public class SingletonTest extends MoinFriendsBaseTest {

    @Test
    public void testUtilitiesAreSingletons( ) {

        assertSame( UtilitiesFactory.getMetaModelChecker( ), UtilitiesFactory.getMetaModelChecker( ) );
        assertSame( UtilitiesFactory.getConnectionUtil( ), UtilitiesFactory.getConnectionUtil( ) );
        assertSame( UtilitiesFactory.getRefObjectUtil( ), UtilitiesFactory.getRefObjectUtil( ) );
        assertSame( UtilitiesFactory.getMoinUtil( ), UtilitiesFactory.getMoinUtil( ) );
    }
}
