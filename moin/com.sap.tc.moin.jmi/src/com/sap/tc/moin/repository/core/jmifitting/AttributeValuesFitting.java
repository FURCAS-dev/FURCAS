package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.core.AttributeValuesWrapper;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.spi.core.Wrapper;

@SuppressWarnings( { "unchecked", "nls" } )
public class AttributeValuesFitting extends ComplianceFitting implements InvocationHandler {

    private final AttributeValuesWrapper orig;

    public AttributeValuesFitting( AttributeValuesWrapper orig ) {

        this.orig = orig;
    }

    @Override
    public Object getOriginal( ) {

        return orig;
    }

    public static Collection getAttributeValues( AttributeValuesWrapper t ) {

        return (Collection) Proxy.newProxyInstance( AttributeValuesFitting.class.getClassLoader( ), new Class[] { List.class, OriginalContainer.class }, new AttributeValuesFitting( t ) );
    }

    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        try {
            Method m = findMethod( orig, method.getName( ), convertArgTypesToMmi( method, args ) );
            if ( m.getName( ).equals( "iterator" ) ) {
                return new WrappingIterator( orig.iterator( ), isUnchangeableAttribute( ) );
            }
            if ( isUnchangeableAttribute( ) ) {
                String mutators = "|add|addAll|clear|remove|removeAll|retainAll|set|subList|";
                if ( mutators.indexOf( "|" + method.getName( ) + "|" ) != -1 ) {
                    throw new UnsupportedOperationException( );
                }
            }
            return convertToJmi( m.invoke( orig, convertArgsToMmi( args ) ) );
        } catch ( Exception e ) {
            if ( e instanceof InvocationTargetException ) {
                Throwable cause = ( (InvocationTargetException) e ).getCause( );
                if ( cause instanceof com.sap.tc.moin.repository.mmi.reflect.DuplicateException && method.getName( ).equals( "add" ) ) {
                    return false;
                } else if ( cause instanceof com.sap.tc.moin.repository.mmi.reflect.JmiException ) {
                    throw convertToJmiException( (com.sap.tc.moin.repository.mmi.reflect.JmiException) cause );
                }
                throw cause;
            }
            throw e;
        }
    }

    private boolean isUnchangeableAttribute( ) {

        MultiValuedAttributesList attributeValuesList = (MultiValuedAttributesList) ( (Wrapper) orig ).unwrap( );
        Field field;
        try {
            field = attributeValuesList.getClass( ).getDeclaredField( "attribute" );
            Method method = field.getClass( ).getMethod( "setAccessible", new Class<?>[] { Boolean.TYPE } );
            method.invoke( field, new Object[] { Boolean.TRUE } );
            Attribute attribute = (Attribute) field.get( attributeValuesList );
            return !attribute.isChangeable( );
        } catch ( SecurityException e ) {
            e.printStackTrace( );
        } catch ( NoSuchFieldException e ) {
            e.printStackTrace( );
        } catch ( IllegalArgumentException e ) {
            e.printStackTrace( );
        } catch ( IllegalAccessException e ) {
            e.printStackTrace( );
        } catch ( NoSuchMethodException e ) {
            e.printStackTrace( );
        } catch ( InvocationTargetException e ) {
            e.printStackTrace( );
        }
        return false;
    }
}