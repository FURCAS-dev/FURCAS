package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

import javax.jmi.model.MofClass;
import javax.jmi.model.NameNotFoundException;
import javax.jmi.model.Reference;
import javax.jmi.reflect.ClosureViolationException;
import javax.jmi.reflect.RefObject;

@SuppressWarnings( { "unchecked", "nls" } )
public class RefObjectFitting extends RefFeaturedFitting implements InvocationHandler {

    public RefObjectFitting( com.sap.tc.moin.repository.mmi.reflect.RefObject orig, int extentId ) {

        super( orig, extentId );
    }

    public static RefObject getRefObject( com.sap.tc.moin.repository.mmi.reflect.RefObject refObject, int extentId ) {

        Class jmiInterface = MmiToJmiNameMapping.map( refObject );
        try {
            return (RefObject) Proxy.newProxyInstance( RefClassFitting.class.getClassLoader( ), new Class[] { jmiInterface, OriginalContainer.class }, new RefObjectFitting( refObject, extentId ) );
        } catch ( Throwable t ) {
            throw (RuntimeException) t;
        }
    }

    private Collection multiZeroUnboundCollOfString = null;

    private Collection multiZeroUnboundCollOfCollOfString = null;

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        if ( method.getName( ).equals( "refSetValue" ) && args != null && args[1] != null ) {
            RefObject metaObject;
            if ( args[0] instanceof String ) {
                MofClass mofClass = (MofClass) ( (RefObject) proxy ).refMetaObject( );
                metaObject = mofClass.lookupElementExtended( (String) args[0] );
            } else {
                metaObject = (RefObject) args[0];
            }
            if ( metaObject instanceof Reference ) {
                if ( ( (Reference) metaObject ).getReferencedEnd( ).getAggregation( ) == javax.jmi.model.AggregationKindEnum.COMPOSITE || ( (Reference) metaObject ).getReferencedEnd( ).otherEnd( ).getAggregation( ) == javax.jmi.model.AggregationKindEnum.COMPOSITE ) {
                    checkCompositionClosure( (RefObject) proxy, (RefObject) args[1] );
                }
            }
        }
        if ( method.getName( ).startsWith( "set" ) && args != null && args[0] instanceof RefObject ) {
            String referenceOrAttributeName = method.getName( ).substring( 3 );
            referenceOrAttributeName = referenceOrAttributeName.substring( 0, 1 ).toLowerCase( Locale.ENGLISH ) + referenceOrAttributeName.substring( 1 );
            MofClass mofClass = (MofClass) ( (RefObject) proxy ).refMetaObject( );
            try {
                RefObject modelElement = mofClass.lookupElementExtended( referenceOrAttributeName );
                if ( modelElement instanceof Reference ) {
                    if ( ( (Reference) modelElement ).getReferencedEnd( ).getAggregation( ) == javax.jmi.model.AggregationKindEnum.COMPOSITE || ( (Reference) modelElement ).getReferencedEnd( ).otherEnd( ).getAggregation( ) == javax.jmi.model.AggregationKindEnum.COMPOSITE ) {
                        checkCompositionClosure( (RefObject) proxy, (RefObject) args[0] );
                    }
                }
            } catch ( NameNotFoundException e ) {
                e.printStackTrace( );
                //just go on, doesn't matter
            }
        }
        if ( method.getName( ).equals( "getMultiZeroUnboundCollOfString" ) ) {
            if ( multiZeroUnboundCollOfString == null ) {
                multiZeroUnboundCollOfString = new HashSet( );
            }
            return multiZeroUnboundCollOfString;
        }
        if ( method.getName( ).equals( "getMultiZeroUnboundCollOfCollOfString" ) ) {
            if ( multiZeroUnboundCollOfCollOfString == null ) {
                multiZeroUnboundCollOfCollOfString = new HashSet( );
            }
            return multiZeroUnboundCollOfCollOfString;
        }
        return super.invoke( proxy, method, args );
    }

    private void checkCompositionClosure( javax.jmi.reflect.RefObject first, javax.jmi.reflect.RefObject second ) {

        int extentIdFirst = ( (OriginalContainer) first.refOutermostPackage( ) ).get___ExtentId( );
        int extentIdSecond = ( (OriginalContainer) second.refOutermostPackage( ) ).get___ExtentId( );
        if ( extentIdFirst != extentIdSecond ) {
            throw new ClosureViolationException( null, first );
        }
    }
}