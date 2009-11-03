package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.jmi.reflect.RefStruct;

@SuppressWarnings( { "unchecked", "nls" } )
public class RefStructFitting extends ComplianceFitting implements InvocationHandler {

    private final com.sap.tc.moin.repository.mmi.reflect.RefStruct orig;

    public RefStructFitting( com.sap.tc.moin.repository.mmi.reflect.RefStruct orig ) {

        this.orig = orig;
    }

    @Override
    public Object getOriginal( ) {

        return orig;
    }

    public static RefStruct getRefStruct( com.sap.tc.moin.repository.mmi.reflect.RefStruct t ) {

        Class jmiInterface = MmiToJmiNameMapping.map( t );
        return (RefStruct) Proxy.newProxyInstance( RefStructFitting.class.getClassLoader( ), new Class[] { jmiInterface, OriginalContainer.class }, new RefStructFitting( t ) );
    }


    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        if ( "get___Original".equals( method.getName( ) ) ) {
            return getOriginal( );
        }
        try {
            Method m = findMethod( orig, method.getName( ), convertArgTypesToMmi( method, args ) );
            return convertToJmi( m.invoke( orig, convertArgsToMmi( args ) ) );
        } catch ( Exception e ) {
            if ( e instanceof InvocationTargetException ) {
                Throwable cause = ( (InvocationTargetException) e ).getCause( );
                if ( cause instanceof com.sap.tc.moin.repository.mmi.reflect.JmiException ) {
                    throw convertToJmiException( (com.sap.tc.moin.repository.mmi.reflect.JmiException) cause );
                }
                throw cause;
            }
            throw e;
        }
    }
}