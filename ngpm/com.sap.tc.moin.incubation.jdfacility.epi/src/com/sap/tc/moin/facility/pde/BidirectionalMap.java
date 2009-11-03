package com.sap.tc.moin.facility.pde;

import java.util.HashMap;


public class BidirectionalMap<K1, K2> {

    private final HashMap<K1, K2> k1TOk2 = new HashMap<K1, K2>( );

    private final HashMap<K2, K1> k2TOk1 = new HashMap<K2, K1>( );

    public synchronized void clear( ) {

        k1TOk2.clear( );
        k2TOk1.clear( );
    }

    public synchronized void removeK1( K1 key1 ) {

        k2TOk1.remove( k1TOk2.remove( key1 ) );
    }

    public synchronized void removeK2( K2 key2 ) {

        k1TOk2.remove( k2TOk1.remove( key2 ) );
    }

    public synchronized void put( K1 key1, K2 key2 ) {

        removeK1( key1 );
        removeK2( key2 );

        k1TOk2.put( key1, key2 );
        k2TOk1.put( key2, key1 );
    }

    public synchronized K2 getK1( K1 key1 ) {

        return k1TOk2.get( key1 );
    }

    public synchronized K1 getK2( K2 key2 ) {

        return k2TOk1.get( key2 );
    }

}
