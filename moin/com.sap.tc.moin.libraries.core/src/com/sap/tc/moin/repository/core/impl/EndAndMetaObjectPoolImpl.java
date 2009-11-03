package com.sap.tc.moin.repository.core.impl;

import java.util.IdentityHashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndAndMetaObjectPool;
import com.sap.tc.moin.repository.shared.util.Tuple;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public final class EndAndMetaObjectPoolImpl implements EndAndMetaObjectPool {

    private Map<String/* metaObjectMofId */, Tuple.Pair<EndAndMetaObject, EndAndMetaObject>> endAndMetaObjects;

    public EndAndMetaObjectPoolImpl( ) {

        this.endAndMetaObjects = new IdentityHashMap<String, Pair<EndAndMetaObject, EndAndMetaObject>>( );
    }

    public synchronized EndAndMetaObject getEndAndMetaObject( int end, String mofIdMetaObject ) {

        Pair<EndAndMetaObject, EndAndMetaObject> pairOfEndAndMetaObjects = this.endAndMetaObjects.get( mofIdMetaObject );
        if ( pairOfEndAndMetaObjects == null ) {
            EndAndMetaObject objectForEnd0 = new EndAndMetaObjectImpl( (byte) 0, mofIdMetaObject );
            EndAndMetaObject objectForEnd1 = new EndAndMetaObjectImpl( (byte) 1, mofIdMetaObject );
            pairOfEndAndMetaObjects = new Tuple.Pair<EndAndMetaObject, EndAndMetaObject>( objectForEnd0, objectForEnd1 );
            this.endAndMetaObjects.put( mofIdMetaObject, pairOfEndAndMetaObjects );
        }
        if ( end == 0 ) {
            return pairOfEndAndMetaObjects.getA( );
        }
        return pairOfEndAndMetaObjects.getB( );
    }

    public EndAndMetaObject getEndAndMetaObject( int end, RefObject metaObject ) {

        return this.getEndAndMetaObject( end, metaObject.refMofId( ) );
    }
}