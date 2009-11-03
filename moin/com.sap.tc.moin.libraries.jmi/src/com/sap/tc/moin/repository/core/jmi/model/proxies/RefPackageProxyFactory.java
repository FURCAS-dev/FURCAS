package com.sap.tc.moin.repository.core.jmi.model.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * Creates Java proxies for RefPackages in order to initialize the real object
 * as late as possible
 * 
 * @author d024227
 */
public class RefPackageProxyFactory {

    private Class proxyClass;

    public RefPackageProxyFactory( ) {

        proxyClass = Proxy.getProxyClass( getClass( ).getClassLoader( ), new Class[] { RefPackage.class, Extent.class } );
    }

    private static class RefPackageProxyInvocationHandler implements InvocationHandler {

        private Map methodsAndReturnValues;

        RefPackageProxyInvocationHandler( MofPackage metaObject ) {

            this.methodsAndReturnValues = new HashMap( );
            this.methodsAndReturnValues.put( "refMetaObject", metaObject ); //$NON-NLS-1$
            this.methodsAndReturnValues.put( "toString", toString( metaObject ) ); //$NON-NLS-1$
        }

        /**
         * Resolves the reference and delegated the invocation to the resolved
         * element
         */
        public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

            Object result = this.methodsAndReturnValues.get( method.getName( ) );
            if ( result == null ) {
                if ( "hashCode".equals( method.getName( ) ) ) { //$NON-NLS-1$
                    result = Integer.valueOf( this.hashCode( ) );
                } else if ( "equals".equals( method.getName( ) ) ) { //$NON-NLS-1$
                    result = Boolean.valueOf( proxy == args[0] );
                } else {
                    throw new MoinUnsupportedOperationException( method.getName( ) );
                }
            }
            return result;
        }

        private String toString( MofPackage metaObject ) {

            StringBuffer result = new StringBuffer( );
            result.append( "[RefPackage$Proxy " ); //$NON-NLS-1$
            result.append( " " ); //$NON-NLS-1$
            result.append( "\"" ); //$NON-NLS-1$
            if ( metaObject != null ) {
                result.append( metaObject.getName( ) );
            } else {
                result.append( "<?>" ); //$NON-NLS-1$
            }
            result.append( "\"" ); //$NON-NLS-1$
            result.append( "]" ); //$NON-NLS-1$
            return result.toString( );
        }

    }

    /**
     * Creates Java proxies for RefPackages in order to initialize the real
     * object as late as possible
     * 
     * @param metaObject the metaObject, the MofPackage of the RefPackage
     * @param refPackageProvider the provider which can retrieve a real
     * RefPackage
     * @return the created RefPackage Java proxy
     */
    public RefPackage create( MofPackage metaObject ) {

        RefPackage result;
        try {
            RefPackageProxyInvocationHandler handler = new RefPackageProxyInvocationHandler( metaObject );
            result = (RefPackage) proxyClass.getConstructor( new Class[] { InvocationHandler.class } ).newInstance( new Object[] { handler } );
        } catch ( Exception e ) {
            // Caught exceptions are unexpected to occur due to the proper
            // construction of the proxyClass and the way in which the
            // constructor is obtained and invoked.
            throw new RuntimeException( e );
        }
        return result;
    }
}
