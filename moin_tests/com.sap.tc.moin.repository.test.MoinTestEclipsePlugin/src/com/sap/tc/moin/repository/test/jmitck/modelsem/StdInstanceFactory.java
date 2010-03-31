package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;

/**
 * Sole instance of the InstanceFactory. Uses standard JMI interfaces.
 */
@SuppressWarnings( "nls" )
public class StdInstanceFactory implements InstanceFactory {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, StdInstanceFactory.class );

    private RefPackage root;

    public void init( RefPackage root ) {

        this.root = root;
    }

    public Object makeValue( Class<?> type, String value ) {

        log.trace( MoinSeverity.DEBUG, "Creating a value of type " + type.getName( ) + " using the string " + value );
        if ( ( value != null ) && value.equals( "null" ) ) {
            return null;
        }
        Object answer = null;

        if ( type == Void.TYPE ) {
            throw new TestErrorException( "Cannot specify a value of void type" );
        } else if ( ( type == Integer.TYPE ) || ( type == Integer.class ) ) {
            answer = new Integer( value );
        } else if ( ( type == Boolean.TYPE ) || ( type == Boolean.class ) ) {
            answer = new Boolean( value );
        } else if ( ( type == Byte.TYPE ) || ( type == Byte.class ) ) {
            answer = new Byte( value );
        } else if ( ( type == Character.TYPE ) || ( type == Character.class ) ) {
            answer = new Character( value.charAt( 0 ) );
        } else if ( ( type == Double.TYPE ) || ( type == Double.class ) ) {
            answer = new Double( value );
        } else if ( ( type == Float.TYPE ) || ( type == Float.class ) ) {
            answer = new Float( value );
        } else if ( ( type == Long.TYPE ) || ( type == Long.class ) ) {
            answer = new Long( value );
        } else if ( type == String.class ) {
            answer = value;
        } else if ( ( type == Short.TYPE ) || ( type == Short.class ) ) {
            answer = new Short( value );
        } else if ( RefEnum.class.isAssignableFrom( type ) ) {
            answer = makeEnumValue( type, value );
        } else if ( java.util.Collection.class.isAssignableFrom( type ) ) {
            answer = makeCollection( type, value );
        } else {
            // maybe try to make a refobject instance ??
            throw new RuntimeException( "Cannot create instance of " + type.getName( ) + " using the value " + value );
        }
        return answer;
    }

    public RefPackage getRepRoot( ) {

        return root;
    }

    private RefEnum makeEnumValue( Class<?> enumType, String value ) {

        String typeName = enumType.getName( );
        if ( !typeName.endsWith( "Enum" ) ) {
            typeName = typeName + "Enum";
            try {
                enumType = Class.forName( typeName );
            } catch ( ClassNotFoundException cnfe ) {
                log.trace( cnfe, MoinSeverity.ERROR, "" );
                throw new TestErrorException( "Could not find the class " + typeName + " needed to create an " + "enum instance" );
            }
        }
        String label = value.toUpperCase( Locale.ENGLISH );
        Field[] fields = enumType.getFields( );
        for ( int i = 0; i < fields.length; i++ ) {
            if ( fields[i].getName( ).equals( label ) ) {
                try {
                    return (RefEnum) fields[i].get( null );
                } catch ( ClassCastException cce ) {
                    log.trace( cce, MoinSeverity.ERROR, "" );
                    throw new TestErrorException( "Type " + enumType.getName( ) + "Enum has a field " + label + " but it is not a RefEnum value" );
                } catch ( Throwable th ) {
                    log.trace( th, MoinSeverity.ERROR, "" );
                    throw new TestErrorException( "Could not access the " + label + " value of the enum " + enumType.getName( ) );
                }
            }
        }
        throw new TestErrorException( "Value " + label + " is not a valid label for the " + "enumueration type " + enumType.getName( ) );
    }

    private Collection<Object> makeCollection( Class<?> coltype, String value ) {

        Collection<Object> c = null;
        if ( ( coltype == List.class ) || ( coltype == Collection.class ) ) {
            c = new ArrayList<Object>( );
        } else if ( coltype == Set.class ) {
            c = new HashSet<Object>( );
        } else {
            throw new TestErrorException( "Collection type " + coltype.getName( ) + " not supported" );
        }
        Class<?> elementType = null;
        if ( value.endsWith( ")" ) ) {
            int loc = value.indexOf( "(" );
            elementType = Util.getType( value.substring( 0, loc ) );
            value = value.substring( loc + 1, value.length( ) - 1 );
        } else {
            elementType = String.class;
        }
        Object[] values = parseCollValueList( value, elementType );
        c.addAll( Arrays.asList( values ) );

        return c;
    }

    private Object[] parseValueList( String valueList, Class<?>[] types ) {

        List<Object> values = new ArrayList<Object>( );
        if ( ( valueList != null ) && !valueList.equals( "" ) && ( types.length > 0 ) ) {
            StringTokenizer st = new StringTokenizer( valueList, "," );
            for ( int i = 0; ( i < types.length ) && st.hasMoreTokens( ); i++ ) {
                String str = st.nextToken( ).trim( );
                values.add( makeValue( types[i], str ) );
            }
        }
        return values.toArray( );
    }

    private Object[] parseCollValueList( String valueList, Class<?> type ) {

        List<Object> values = new ArrayList<Object>( );
        StringTokenizer st = new StringTokenizer( valueList, "|" );
        for ( int i = 0; st.hasMoreTokens( ); i++ ) {
            String str = st.nextToken( ).trim( );
            values.add( makeValue( type, str ) );
        }
        return values.toArray( );
    }

    private MethodAndObject findMethod( Object obj, Class<?> returnType, String methodName, int argcount ) {

        Method[] mlist = obj.getClass( ).getDeclaredMethods( );
        for ( int i = 0; i < mlist.length; i++ ) {
            Method m = mlist[i];
            Class<?> expectedType = m.getReturnType( );
            if ( ( returnType == expectedType ) && methodName.equals( m.getName( ) ) && argcount == m.getParameterTypes( ).length ) {
                return new MethodAndObject( m, obj );
            }
        }
        return null;
    }

    private void debugShowValue( String label, Object obj ) {

        if ( obj == null ) {
            log.trace( MoinSeverity.DEBUG, label + ": null" );
        } else {
            log.trace( MoinSeverity.DEBUG, label + ": " + obj + " type: " + obj.getClass( ).getName( ) );
            if ( obj instanceof Collection ) {
                Collection<?> c = (Collection<?>) obj;
                log.trace( MoinSeverity.DEBUG, "     Collection contains " + c.size( ) + " elements" );
                for ( Iterator<?> i = c.iterator( ); i.hasNext( ); ) {
                    debugShowValue( "      Element Value", i.next( ) );
                }
            }
        }
    }

    public Object makeRefObject( Class<?> type, String value ) {

        log.trace( MoinSeverity.DEBUG, "Creating a RefObject instance of type " + type.getName( ) + " using the string " + value );

        int paramCount = 0;
        if ( ( value != null ) && !value.equals( "" ) ) {
            int cursor = 0;
            while ( true ) {
                paramCount++;
                cursor = value.indexOf( ',', cursor );
                if ( cursor == -1 ) {
                    break;
                } else {
                    cursor++;
                }
            }
        }

        MethodAndObject mando = getRefObjectCreatorMethod( type, paramCount );
        if ( mando == null ) {
            throw new TestErrorException( "Could not find suitible create method " + "to create an instance of " + type.getName( ) + " using " + paramCount + " arguments, within " + getRepRoot( ).getClass( ).getName( ) );
        }
        Class<?>[] paramtypes = mando.method.getParameterTypes( );
        Object[] paramValues = parseValueList( value, paramtypes );

        try {
            if ( log.isTraced( MoinSeverity.DEBUG ) ) {
                log.trace( MoinSeverity.DEBUG, "Invoking method " + mando.method.getName( ) + " with " + paramValues.length + " params extracted from from " + value );
                for ( int i = 0; i < paramValues.length; i++ ) {
                    debugShowValue( "  Value", paramValues[i] );
                }
            }
            return mando.method.invoke( mando.object, paramValues );
        } catch ( IllegalAccessException iae ) {
            log.trace( iae, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Method  " + mando.method.getName( ) + " could not be accessed" );
        } catch ( InvocationTargetException tie ) {
            Throwable th = tie.getTargetException( );
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Exception executing method " + mando.method.getName( ) + ":" + th.getMessage( ) );
        }
    }

    public RefAssociation getAssociation( String assocName ) {

        return getAssociation( assocName, getRepRoot( ) );
    }

    private static RefAssociation getAssociation( String assocName, RefPackage rp ) {

        for ( Iterator<RefAssociation> i = rp.refAllAssociations( ).iterator( ); i.hasNext( ); ) {
            RefAssociation ra = i.next( );
            String name = ( (ModelElement) ra.refMetaObject( ) ).getName( );
            if ( assocName.equals( name ) ) {
                return ra;
            }
        }
        RefAssociation answer = null;
        for ( Iterator<RefPackage> i = rp.refAllPackages( ).iterator( ); i.hasNext( ); ) {
            answer = getAssociation( assocName, i.next( ) );
            if ( answer != null ) {
                break;
            }
        }
        return answer;
    }

    private MethodAndObject getRefObjectCreatorMethod( Class<?> type, int argcount ) {

        MethodAndObject answer = null;

        String simpleTypeName = Util.simpleNameOf( type.getName( ) );
        if ( simpleTypeName != null ) {
            String methodName = "create" + simpleTypeName;
            answer = getRefObjCreatorMethod( getRepRoot( ), type, methodName, argcount );
        }
        return answer;
    }

    private MethodAndObject getRefObjCreatorMethod( RefPackage rp, Class<?> type, String methodName, int argcount ) {

        MethodAndObject answer = findMethod( rp, type, methodName, argcount );
        String simpleTypeName = Util.simpleNameOf( type.getName( ) );
        if ( answer == null ) {
            for ( Iterator<RefClass> i = rp.refAllClasses( ).iterator( ); i.hasNext( ); ) {
                RefClass refClass = i.next( );
                answer = findMethod( refClass, type, methodName, argcount );
                if ( answer != null ) {
                    break;
                } else {
                    String name = refClass.refMetaObject( ).getName( );
                    name = name.replace( "_", "" );
                    if ( name.equalsIgnoreCase( simpleTypeName ) ) {
                        answer = findMethod( refClass, RefObject.class, "refCreateInstance", 0 );
                        if ( answer != null ) {
                            break;
                        }
                    }
                }
            }
        }
        if ( answer == null ) {
            for ( Iterator<RefPackage> i = rp.refAllPackages( ).iterator( ); i.hasNext( ); ) {
                answer = getRefObjCreatorMethod( i.next( ), type, methodName, argcount );
                if ( answer != null ) {
                    break;
                }
            }
        }
        return answer;
    }

}
