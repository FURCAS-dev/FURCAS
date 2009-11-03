package com.sap.tc.moin.repository.core.jmi.reflect;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Wrapper for the dynamic RefClass implementation
 */
public class RefPackageImplDynamicWrapper extends RefPackageWrapperImpl<RefPackage> implements RefPackage {

    /**
     * @param actConnection
     * @param refPackage
     * @param doSynchronized
     */
    public RefPackageImplDynamicWrapper( CoreConnection actConnection, RefPackageImplDynamic refPackage, boolean doSynchronized ) {

        super( actConnection, refPackage, doSynchronized );
    }

    public RefPackage unwrap( ) {

        return (RefPackageImplDynamic) this.getWrappedObject( );
    }

    public Class get___JmiInterface( ) {

        return RefPackage.class;
    }
}
