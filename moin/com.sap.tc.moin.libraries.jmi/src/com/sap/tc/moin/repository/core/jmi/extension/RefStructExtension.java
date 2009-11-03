package com.sap.tc.moin.repository.core.jmi.extension;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

public interface RefStructExtension extends RefStruct {

    public void set___Value( String fieldName, Object value );

    public RefObject get___MetaObject( );

    public void set___MetaObject( RefObject metaObject );
}