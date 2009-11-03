package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.jmi.reflect.InvalidObjectException;
import javax.jmi.reflect.RefClass;
import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;

@SuppressWarnings( { "unchecked", "nls" } )
public class RefPackageFitting extends RefBaseObjectFitting implements InvocationHandler {

    private final com.sap.tc.moin.repository.mmi.reflect.RefPackage pkgPackage;

    private boolean deleted = false;

    public RefPackageFitting( com.sap.tc.moin.repository.mmi.reflect.RefPackage pkgPackage, int id ) {

        super( pkgPackage, id );
        this.pkgPackage = pkgPackage;
    }

    public static RefPackage getRefPackage( com.sap.tc.moin.repository.mmi.reflect.RefPackage mmiPackage, int extentId ) {

        Class jmiInterface = MmiToJmiNameMapping.map( mmiPackage );
        return (RefPackage) Proxy.newProxyInstance( RefPackageFitting.class.getClassLoader( ), new Class[] { jmiInterface, OriginalContainer.class }, new RefPackageFitting( mmiPackage, extentId ) );
    }

    private Collection getRefAllClasses( ) {

        Collection<com.sap.tc.moin.repository.mmi.reflect.RefClass> classes = pkgPackage.refAllClasses( );
        Collection ret = new ArrayList( classes.size( ) );
        for ( com.sap.tc.moin.repository.mmi.reflect.RefClass refClass : classes ) {
            // Due to a bug in MOIN, classes might be returned by the 'refAllClasses' call which
            // come from a super-package. Filter these out by checking the immediate package.
            com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage = refClass.refImmediatePackage( );
            if ( immediatePackage.equals( pkgPackage ) ) {
                ret.add( RefClassFitting.getRefClass( refClass, this.extentId ) );
            }
        }
        return ret;
    }

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        Method _method = method;
        Object[] _args = args;
        if ( deleted ) {
            throw new InvalidObjectException( null );
        }
        if ( "refAllClasses".equals( _method.getName( ) ) ) {
            return getRefAllClasses( );
        }
        if ( "refCreateStruct".equals( _method.getName( ) ) ) {
            try {
                return super.invoke( proxy, _method, _args );
            } catch ( Throwable e ) {
                throw refCreateStructExceptionHandling( e );
            }
        }
        if ( "refDelete".equals( _method.getName( ) ) ) {
            deleted = true;
            return null;
        }
        if ( javax.jmi.reflect.RefStruct.class.isAssignableFrom( method.getReturnType( ) ) ) {
            if ( "createVariStructure".equals( _method.getName( ) ) ) {
                _method = findMethod( getOriginal( ), "refCreateStruct", new Class[] { String.class, java.util.List.class } );
                Collection<String> arg0 = (Collection<String>) _args[0];
                String arg0_new = "";
                for ( Iterator<String> it = arg0.iterator( ); it.hasNext( ); ) {
                    arg0_new += it.next( );
                    if ( it.hasNext( ) ) {
                        arg0_new += "|";
                    }
                }
                _args[0] = arg0_new;
                Collection<RefObject> arg1 = (Collection<RefObject>) _args[1];
                String arg1_new = "";
                for ( Iterator<RefObject> it = arg1.iterator( ); it.hasNext( ); ) {
                    arg1_new += it.next( ).refMofId( );
                    if ( it.hasNext( ) ) {
                        arg1_new += "|";
                    }
                }
                _args[1] = arg1_new;
                RefObject arg2 = (RefObject) _args[2];
                String arg2_new = arg2.refMofId( );
                _args[2] = arg2_new;
                _args = new Object[] { "VariStructure", new ArrayList( Arrays.asList( convertArgsToMmi( _args ) ) ) };
            } else {
                // Must be a StructureType creator. Since we do not support StructureType creators any more,
                // redirect the method call to 'refCreateStruct'.
                _method = findMethod( proxy, "refCreateStruct", new Class[] { java.lang.String.class, java.util.List.class } );
                String structName = method.getName( ).substring( 6 );
                _args = new Object[] { structName, new ArrayList( Arrays.asList( args ) ) };
                return this.invoke( proxy, _method, _args );
            }
        }
        return super.invoke( proxy, _method, _args );
    }

    public Collection refAllPackages( ) {

        Collection<com.sap.tc.moin.repository.mmi.reflect.RefPackage> refAllPackages = pkgPackage.refAllPackages( );
        List ret = new ArrayList( refAllPackages.size( ) );
        for ( com.sap.tc.moin.repository.mmi.reflect.RefPackage pkg : refAllPackages ) {
            ret.add( new RefPackageFitting( pkg, extentId ) );
        }
        return ret;
    }

    public RefClass refClass( RefObject type ) {

        return wrapClass( pkgPackage.refClass( (com.sap.tc.moin.repository.mmi.reflect.RefObject) ( (ComplianceFitting) type ).getOriginal( ) ) );
    }

    public RefClass refClass( String typeName ) {

        return wrapClass( pkgPackage.refClass( typeName ) );
    }

    private RefClass wrapClass( com.sap.tc.moin.repository.mmi.reflect.RefClass clazz ) {

        if ( clazz == null ) {
            return null;
        }
        return RefClassFitting.getRefClass( clazz, this.extentId );
    }
}