package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * Wrapper for the dynamic RefClass implementation
 */
public class RefClassImplDynamicWrapper extends RefClassWrapperImpl<RefClass> implements RefClass {

    /**
     * @param actConnection
     * @param refFeatured
     * @param doSynchronized
     */
    public RefClassImplDynamicWrapper( CoreConnection actConnection, RefClassImplDynamic refFeatured, boolean doSynchronized ) {

        super( actConnection, refFeatured, doSynchronized );
    }

    @Override
    public RefClass unwrap( ) {

        return (RefClassImplDynamic) this.getWrappedObject( );
    }

    @Override
    public Object refInvokeOperation( CoreConnection conn, String operationName, List<? extends Object> args ) throws RefException {

        throw new InvalidNameException( operationName, JmiReflectMessages.OPERATIONNOTFOUND, operationName );
    }

    @Override
    public Object invoke___Operation( CoreConnection connection, int operationNumber, List<? extends Object> args ) throws RefException {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.NOTSUPPORTED_THEREISNOOPERATION );
    }

    @Override
    public Class get___JmiInterface( ) {

        return RefClass.class;
    }
}
