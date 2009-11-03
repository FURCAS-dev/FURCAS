package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jmi.reflect.ClosureViolationException;
import javax.jmi.reflect.RefAssociationLink;

import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

@SuppressWarnings( { "unchecked", "nls" } )
public class RefAssociationFitting extends RefBaseObjectFitting {

    private boolean isComposition = false;

    public RefAssociationFitting( com.sap.tc.moin.repository.mmi.reflect.RefAssociation orig, int extentId ) {

        super( orig, extentId );
        isComposition = getOriginalConnection( ).getJmiHelper( ).getCompositeAssociationEnd( (Association) orig.refMetaObject( ) ) != null;
    }

    public static Object getRefAssociation( com.sap.tc.moin.repository.mmi.reflect.RefAssociation mmiRefAssociation, int id ) {

        Class jmiInterface = MmiToJmiNameMapping.map( mmiRefAssociation );
        try {
            return Proxy.newProxyInstance( RefAssociationFitting.class.getClassLoader( ), new Class[] { jmiInterface, OriginalContainer.class }, new RefAssociationFitting( mmiRefAssociation, id ) );
        } catch ( RuntimeException e ) {
            throw e;
        }
    }

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        if ( "refAllLinks".equals( method.getName( ) ) ) {
            com.sap.tc.moin.repository.mmi.reflect.RefAssociation original = (com.sap.tc.moin.repository.mmi.reflect.RefAssociation) getOriginal( );
            Association assoc = (Association) original.refMetaObject( );
            if ( assoc.isDerived( ) ) {
                return super.invoke( proxy, method, args );
            }
            return getRefAllLinks( assoc, original );
        }
        if ( "refQuery".equals( method.getName( ) ) ) {
            try {
                super.invoke( proxy, method, args );
            } catch ( javax.jmi.reflect.InvalidCallException e ) {
                if ( e.getObjectInError( ) instanceof javax.jmi.model.AssociationEnd ) {
                    throw e;
                }
                throw new javax.jmi.reflect.InvalidNameException( "" );
            }
        }
        if ( "add".equals( method.getName( ) ) || "refAddLink".equals( method.getName( ) ) ) {
            checkCompositionClosure( (javax.jmi.reflect.RefObject) args[0], (javax.jmi.reflect.RefObject) args[1] );
        }
        if ( "refRemoveLink".equals( method.getName( ) ) ) {
            if ( (Boolean) super.invoke( proxy, method, args ) ) {
                return true;
            }
            return super.invoke( proxy, method, new Object[] { args[1], args[0] } );
        }
        return super.invoke( proxy, method, args );
    }

    private void checkCompositionClosure( javax.jmi.reflect.RefObject first, javax.jmi.reflect.RefObject second ) {

        if ( isComposition ) {
            int extentIdFirst = ( (OriginalContainer) first.refOutermostPackage( ) ).get___ExtentId( );
            int extentIdSecond = ( (OriginalContainer) second.refOutermostPackage( ) ).get___ExtentId( );
            if ( extentIdFirst != extentIdSecond ) {
                throw new ClosureViolationException( null, first );
            }
        }
    }

    private Object getRefAllLinks( Association assoc, com.sap.tc.moin.repository.mmi.reflect.RefAssociation refAssoc ) {

        JmiHelper helper = getOriginalConnection( ).getJmiHelper( );
        List<AssociationEnd> associationEnds = helper.getAssociationEnds( assoc );
        AssociationEnd end1 = associationEnds.get( 0 );
        MofClass type = (MofClass) end1.getType( );
        Collection<RefObject> elements1 = helper.getRefClassForMofClass( type ).refAllOfType( );
        List ret = new ArrayList( );
        ExtentHelper.setCurrentExtentId( extentId );
        for ( RefObject o : elements1 ) {
            Collection<RefObject> otherObjects = refAssoc.refQuery( end1, o );
            for ( RefObject o2 : otherObjects ) {
                final javax.jmi.reflect.RefObject r1 = (javax.jmi.reflect.RefObject) convertToJmi( o );
                final javax.jmi.reflect.RefObject r2 = (javax.jmi.reflect.RefObject) convertToJmi( o2 );
                RefAssociationLink link = new RefAssociationLink( ) {

                    public javax.jmi.reflect.RefObject refFirstEnd( ) {

                        return r1;
                    }

                    public javax.jmi.reflect.RefObject refSecondEnd( ) {

                        return r2;
                    }
                };
                ret.add( link );
            }
        }
        return ret;
    }
}