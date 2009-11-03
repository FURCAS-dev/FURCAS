package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import javax.jmi.reflect.RefBaseObject;
import javax.jmi.reflect.RefPackage;
import javax.jmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Aliases;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

@SuppressWarnings( { "unchecked", "nls" } )
public class RefBaseObjectFitting extends ComplianceFitting implements InvocationHandler {

    private final com.sap.tc.moin.repository.mmi.reflect.RefBaseObject orig;

    protected final int extentId;

    public RefBaseObjectFitting( com.sap.tc.moin.repository.mmi.reflect.RefBaseObject orig, int id ) {

        this.extentId = id;
        this.orig = orig;
    }

    protected Connection getOriginalConnection( ) {

        return ( (Partitionable) getOriginal( ) ).get___Connection( );
    }

    @Override
    public Object getOriginal( ) {

        return orig;
    }

    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        if ( "get___Original".equals( method.getName( ) ) ) {
            return getOriginal( );
        }
        if ( "get___ExtentId".equals( method.getName( ) ) ) {
            return this.extentId;
        }
        if ( "refImmediatePackage".equals( method.getName( ) ) && proxy instanceof RefPackage ) {
            return refImmediatePackageOfRefPackage( (RefPackage) proxy, method );
        }
        if ( "refOutermostPackage".equals( method.getName( ) ) ) {
            return refOutermostPackage( (RefBaseObject) proxy );
        }
        try {
            return invokeUnsafe( proxy, method, args );
        } catch ( Throwable t ) {
            if ( t instanceof InvocationTargetException ) {
                Throwable cause = ( (InvocationTargetException) t ).getCause( );
                if ( cause instanceof com.sap.tc.moin.repository.mmi.reflect.JmiException ) {
                    throw convertToJmiException( (com.sap.tc.moin.repository.mmi.reflect.JmiException) cause );
                }
                if ( cause instanceof com.sap.tc.moin.repository.mmi.reflect.RefException ) {
                    throw convertToRefException( (com.sap.tc.moin.repository.mmi.reflect.RefException) cause );
                }
                throw cause;
            }
            throw t;
        }
    }

    private Object refImmediatePackageOfRefPackage( RefPackage refPkg, Method method ) throws Throwable {

        RefPackage immediatePackage = (RefPackage) invokeUnsafe( refPkg, method, null );
        if ( immediatePackage == null ) {
            // In the 'null' case, we need to inspect clustered imports to 'refPkg'.
            Connection conn = getOriginalConnection( );
            Aliases aliases = conn.getAssociation( Aliases.ASSOCIATION_DESCRIPTOR );
            Namespace namepace = (Namespace) ( (com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) ( (OriginalContainer) refPkg ).get___Original( ) ).refMetaObject( );
            Collection<Import> importers = aliases.getImporter( namepace );
            if ( !importers.isEmpty( ) ) {
                for ( Import imp : importers ) {
                    if ( imp.isClustered( ) ) {
                        MofPackage mofPackage = (MofPackage) imp.getContainer( );
                        if ( mofPackage.getName( ).equals( "Jmitck" ) ) { // package created by MOIN; skip it
                            continue;
                        }
                        return convertToJmi( conn.getJmiHelper( ).getRefPackageForMofPackage( mofPackage ) );
                    }
                }
            }
        }
        return immediatePackage;
    }

    private Object refOutermostPackage( javax.jmi.reflect.RefBaseObject rbo ) {

        RefPackage rp = rbo.refImmediatePackage( );
        if ( rp == null && rbo instanceof RefPackage ) {
            return rbo;
        }
        if ( rp != null && !( rp.equals( rbo ) ) ) {
            RefPackage rpTemp = rp.refOutermostPackage( );
            if ( rpTemp != null ) {
                rp = rpTemp;
            }
        }
        return rp;
    }

    public Object invokeUnsafe( Object proxy, Method method, Object[] args ) throws Throwable {

        Object[] unwrappedArgs = null;
        Method m = null;

        if ( args != null ) {
            try {
                m = findMethod( orig, method.getName( ), convertArgTypesToMmi( method, args ) );
            } catch ( Exception e ) {
                throw e;
            }
            unwrappedArgs = convertArgsToMmi( args );
        } else {
            m = orig.getClass( ).getMethod( method.getName( ), (Class<?>[]) null );
        }

        Object ret = m.invoke( getOriginal( ), unwrappedArgs );
        ExtentHelper.setCurrentExtentId( extentId );
        return convertToJmi( ret );
    }

    protected Throwable refCreateStructExceptionHandling( Throwable e ) throws TypeMismatchException {

        //Bug in MOIN 711 only, not necessary in 720
        if ( e instanceof InvocationTargetException ) {
            InvocationTargetException ite = (InvocationTargetException) e;
            if ( ite.getCause( ) instanceof ClassCastException ) {
                throw new TypeMismatchException( null, null, null );
            }
        }
        if ( e instanceof ClassCastException ) {
            throw new TypeMismatchException( null, null, null );
        }
        return e;
    }
}