/*
 * Created on 01.02.2006
 */
package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * A
 * 
 * @author d024227
 */
public class RefClassImplDynamic extends RefClassImpl implements RefClass {

    /***************************************************************************
     * constructors
     **************************************************************************/

    public RefClassImplDynamic( ) {

        super( );
    }

    public RefClassImplDynamic( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject ) {

        super( workspace, mofId, immediatePackage, metaObject );
    }

    /***************************************************************************
     * ref methods
     **************************************************************************/

    @Override
    public Object refGetValue( String featureName ) {

        throw new InvalidNameException( featureName, JmiReflectMessages.FEATURENOTFOUND, featureName );
    }

    @Override
    public void refSetValue( String featureName, Object arg1 ) {

        throw new InvalidNameException( featureName, JmiReflectMessages.FEATURENOTFOUND, featureName );
    }

    @Override
    public Object refInvokeOperation( CoreConnection conn, String operationName, List<? extends Object> args ) throws RefException {

        throw new InvalidNameException( operationName, JmiReflectMessages.OPERATIONNOTFOUND, operationName );
    }

    /***************************************************************************
     * other methods
     **************************************************************************/

    @Override
    public Object invoke___Operation( CoreConnection connection, int operationNumber, List<? extends Object> args ) throws RefException {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.NOTSUPPORTED_THEREISNOOPERATION );
    }

    @Override
    public Class get___JmiInterface( ) {

        return RefClass.class;
    }

    /***************************************************************************
     * private methods
     **************************************************************************/
    @Override
    public RefObject get___Instance( ) throws JmiException {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.NOTPOSSIBLETOCREATEINSTANCESOFTHISCLASS );
    }

    @Override
    public Wrapper<? extends RefBaseObject> createWrapper( CoreConnection conn, boolean synchronize ) {

        return new RefClassImplDynamicWrapper( conn, this, synchronize );
    }

}