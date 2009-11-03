package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface EndAndMetaObjectPool {

    public EndAndMetaObject getEndAndMetaObject( int end, RefObject metaObject );

    public EndAndMetaObject getEndAndMetaObject( int end, String mofIdMetaObject );
}