package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;

import javax.jmi.reflect.ClosureViolationException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.JmiListWrapper;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

@SuppressWarnings( { "unchecked", "nls" } )
public class JmiListFitting extends ComplianceFitting implements InvocationHandler {

    private final JmiListWrapper orig;

    private int extentId;

    public JmiListFitting( JmiListWrapper orig, int extentId ) {

        this.extentId = extentId;
        this.orig = orig;
    }

    @Override
    public JmiListWrapper getOriginal( ) {

        return orig;
    }

    public static Collection getJmiList( JmiListWrapper t, int extentId ) {

        return (Collection) Proxy.newProxyInstance( JmiListFitting.class.getClassLoader( ), new Class[] { List.class, OriginalContainer.class }, new JmiListFitting( t, extentId ) );
    }

    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        ExtentHelper.setCurrentExtentId( extentId );
        try {
            if ( method.getName( ).equals( "iterator" ) ) {
                return new WrappingIterator( orig.iterator( ), false /* readOnly */);
            }
            if ( method.getName( ).equals( "add" ) || method.getName( ).equals( "addAll" ) ) {
                RefObject metaObject = getMetaObject( );
                if ( metaObject instanceof Association ) {
                    CoreConnection conn = ExtentHelper.getCurrentConnection( );
                    SpiJmiHelper jmiHelper = conn.getCoreJmiHelper( );
                    if ( jmiHelper.getCompositeAssociationEnd( conn, (Association) metaObject ) != null ) {
                        if ( args[0] instanceof Collection ) {
                            for ( Object obj : (Collection) args[0] ) {
                                checkCompositionClosure( (javax.jmi.reflect.RefObject) obj );
                            }
                        } else {
                            checkCompositionClosure( (javax.jmi.reflect.RefObject) args[0] );
                        }
                    }
                }
            }
            Method m = findMethod( orig, method.getName( ), convertArgTypesToMmi( method, args ) );
            return convertToJmi( m.invoke( orig, convertArgsToMmi( args ) ) );
        } catch ( Exception e ) {
            if ( e instanceof InvocationTargetException ) {
                Throwable cause = ( (InvocationTargetException) e ).getCause( );
                if ( cause instanceof com.sap.tc.moin.repository.mmi.reflect.InvalidCallException ) {
                    if ( isModificationToUnchangeableMetaObject( ) ) {
                        return false;
                    }
                }
                if ( cause instanceof com.sap.tc.moin.repository.mmi.reflect.JmiException ) {
                    throw convertToJmiException( (com.sap.tc.moin.repository.mmi.reflect.JmiException) cause );
                }
                throw cause;
            }
            throw e;
        }
    }

    private void checkCompositionClosure( javax.jmi.reflect.RefObject second ) {

        int extentIdFirst = extentId;
        int extentIdSecond = ( (OriginalContainer) second.refOutermostPackage( ) ).get___ExtentId( );
        if ( extentIdFirst != extentIdSecond ) {
            throw new ClosureViolationException( null, second );
        }
    }

    private RefObject getMetaObject( ) {

        CoreConnection conn = ExtentHelper.getCurrentConnection( );
        JmiList jmiList = (JmiList) ( (Wrapper) orig ).unwrap( );
        MoinReference metaObjectRef = jmiList.getEndAndMetaObject( ).getMetaObject( conn.getSession( ).getMoin( ) );
        return (RefObject) metaObjectRef.get( conn.getSession( ) );
    }

    private boolean isModificationToUnchangeableMetaObject( ) {

        RefObject metaObject = getMetaObject( );
        if ( metaObject instanceof Attribute ) {
            return !( (Attribute) metaObject ).isChangeable( );
        }
        Association assoc = (Association) metaObject;
        JmiList jmiList = (JmiList) ( (Wrapper) orig ).unwrap( );
        CoreConnection connection = ExtentHelper.getCurrentConnection( );
        AssociationEnd end = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), assoc ).get( jmiList.getEndAndMetaObject( ).getToEnd( ) );
        return !end.isChangeable( );
    }
}
