package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sap.tc.moin.repository.mmi.reflect.RefEnum;

@SuppressWarnings( { "unchecked", "nls" } )
public class RefEnumFitting extends ComplianceFitting implements InvocationHandler {

    private final RefEnum orig;

    public RefEnumFitting( RefEnum orig ) {

        this.orig = orig;
    }

    @Override
    public Object getOriginal( ) {

        return orig;
    }

    public static javax.jmi.reflect.RefEnum getRefEnum( RefEnum t ) {

        Class jmiInterface = MmiToJmiNameMapping.map( t );
        return (javax.jmi.reflect.RefEnum) Proxy.newProxyInstance( RefEnumFitting.class.getClassLoader( ), new Class[] { jmiInterface, OriginalContainer.class }, new RefEnumFitting( t ) );
    }

    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        try {
            Method m = findMethod( orig, method.getName( ), convertArgTypesToMmi( method, args ) );
            return convertToJmi( m.invoke( orig, convertArgsToMmi( args ) ) );
        } catch ( Exception e ) {
            if ( e instanceof InvocationTargetException ) {
                throw ( (InvocationTargetException) e ).getCause( );
            }
            throw e;
        }
    }
}