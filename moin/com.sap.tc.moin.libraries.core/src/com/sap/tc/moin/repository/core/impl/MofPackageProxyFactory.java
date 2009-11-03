package com.sap.tc.moin.repository.core.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

/**
 * Creates Java proxies for MofPackages in order to initialize the real object
 * as late as possible
 * 
 * @author d024227
 */
public class MofPackageProxyFactory {

    private Class proxyClass;

    public MofPackageProxyFactory( ) {

        proxyClass = Proxy.getProxyClass( getClass( ).getClassLoader( ), new Class[] { MofPackage.class, MofPackageProvider.class, SpiPartitionable.class } );
    }

    private static class MofPackageProxyInvocationHandler implements InvocationHandler {

        private MofPackage mofPackage;

        private Map<String, Object> methodsAndReturnValues;

        private MofPackageProvider mofPackageProvider;

        MofPackageProxyInvocationHandler( String name, MRI mri, MofPackageProvider mofPackageProvider ) {

            this.mofPackage = null;
            this.methodsAndReturnValues = new HashMap<String, Object>( );
            this.mofPackageProvider = mofPackageProvider;
            this.methodsAndReturnValues.put( "getName", name ); //$NON-NLS-1$
            this.methodsAndReturnValues.put( "get___Mri", mri ); //$NON-NLS-1$
            this.methodsAndReturnValues.put( "toString", toString( ) ); //$NON-NLS-1$
            this.methodsAndReturnValues.put( "refMofId", mri.getMofId( ) ); //$NON-NLS-1$
        }

        /**
         * Resolves the reference and delegated the invocation to the resolved
         * element
         */
        public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

            Object result = this.methodsAndReturnValues.get( method.getName( ) );
            if ( result == null ) {
                if ( this.mofPackage == null ) {
                    this.mofPackage = this.mofPackageProvider.resolveMofPackage( );
                }
                if ( "resolveMofPackage".equals( method.getName( ) ) ) { //$NON-NLS-1$
                    result = this.mofPackage;
                } else if ( "hashCode".equals( method.getName( ) ) ) { //$NON-NLS-1$
                    result = Integer.valueOf( this.hashCode( ) );
                } else if ( "equals".equals( method.getName( ) ) ) { //$NON-NLS-1$
                    result = Boolean.valueOf( proxy == args[0] );
                } else {
                    result = method.invoke( this.mofPackage, args );
                }
            }
            return result;
        }

        @Override
        public String toString( ) {

            StringBuffer result = new StringBuffer( );
            result.append( "[MofPackage$Proxy " ); //$NON-NLS-1$
            result.append( " " ); //$NON-NLS-1$
            result.append( "\"" ); //$NON-NLS-1$
            result.append( methodsAndReturnValues.get( "getName" ) ); //$NON-NLS-1$
            result.append( "\"" ); //$NON-NLS-1$
            result.append( "]" ); //$NON-NLS-1$
            return result.toString( );
        }

    }

    /**
     * Creates Java proxies for MofPackages in order to initialize the real
     * object as late as possible
     * 
     * @param name the name of the MofPackage
     * @param mri the MRI of the MofPackage
     * @param mofPackageProvider the provider which can retrieve a real
     * MofPackage
     * @return the created MofPackage Java proxy
     */
    public MofPackage create( String name, MRI mri, MofPackageProvider mofPackageProvider ) {

        MofPackage result;
        try {
            MofPackageProxyInvocationHandler handler = new MofPackageProxyInvocationHandler( name, mri, mofPackageProvider );
            result = (MofPackage) proxyClass.getConstructor( new Class[] { InvocationHandler.class } ).newInstance( new Object[] { handler } );
        } catch ( Exception e ) {
            // Caught exceptions are unexpected to occur due to the proper
            // construction of the proxyClass and the way in which the
            // constructor is obtained and invoked.
            throw new RuntimeException( e );
        }
        return result;
    }

}
