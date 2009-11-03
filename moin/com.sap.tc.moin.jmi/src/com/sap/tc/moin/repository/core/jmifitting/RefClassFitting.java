package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.jmi.model.Attribute;
import javax.jmi.reflect.RefClass;
import javax.jmi.reflect.RefStruct;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl;
import com.sap.tc.moin.repository.messages.jmi.impl.JmiBase;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeImpl;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

@SuppressWarnings( { "unchecked", "nls" } )
public class RefClassFitting extends RefFeaturedFitting implements InvocationHandler {

    private final com.sap.tc.moin.repository.mmi.reflect.RefClass clazz;

    private Map<String, Object> staticAttributes;

    public RefClassFitting( com.sap.tc.moin.repository.mmi.reflect.RefClass clazz, int id ) {

        super( clazz, id );
        this.clazz = clazz;
    }

    public static RefClass getRefClass( com.sap.tc.moin.repository.mmi.reflect.RefClass mmiClass, int id ) {

        Class jmiInterface = MmiToJmiNameMapping.map( mmiClass );
        return (RefClass) Proxy.newProxyInstance( RefClassFitting.class.getClassLoader( ), new Class[] { jmiInterface, OriginalContainer.class }, new RefClassFitting( mmiClass, id ) );
    }

    private Collection getRefAllOfClass( Collection mmiRefObjects ) {

        Collection ret = new ArrayList( mmiRefObjects.size( ) );
        for ( Object o : mmiRefObjects ) {
            com.sap.tc.moin.repository.mmi.reflect.RefObject mmiRefObject = (com.sap.tc.moin.repository.mmi.reflect.RefObject) o;
            ret.add( RefObjectFitting.getRefObject( mmiRefObject, this.extentId ) );
        }
        return ret;
    }

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        if ( "get___Original".equals( method.getName( ) ) ) {
            return getOriginal( );
        }
        if ( "refAllOfClass".equals( method.getName( ) ) ) {
            return getRefAllOfClass( clazz.refAllOfClass( ) );
        }
        if ( "refCreateStruct".equals( method.getName( ) ) ) {
            return refCreateStruct( args );
        }
        if ( "refGetEnum".equals( method.getName( ) ) ) {
            return refGetEnum( args );
        }
        if ( "refGetValue".equals( method.getName( ) ) ) {
            Attribute attr = (Attribute) args[0];
            boolean multiValued = attr.getMultiplicity( ).getUpper( ) != 1;
            boolean isOrdered = attr.getMultiplicity( ).isOrdered( );
            return handleStaticAttribute( "get", attr.getName( ), multiValued, isOrdered, null /* returnType */, null );
        }
        if ( "refSetValue".equals( method.getName( ) ) ) {
            Attribute attr = (Attribute) args[0];
            boolean multiValued = attr.getMultiplicity( ).getUpper( ) != 1;
            boolean isOrdered = attr.getMultiplicity( ).isOrdered( );
            return handleStaticAttribute( "set", attr.getName( ), multiValued, isOrdered, null /* returnType */, args[1] );
        }
        if ( method.getName( ).startsWith( "get" ) || method.getName( ).startsWith( "set" ) ) {
            String action = method.getName( ).substring( 0, 3 );
            String attrName = method.getName( ).substring( 3 );
            Class<?> returnType = method.getReturnType( );
            boolean multiValued = false;
            boolean isOrdered = false;
            if ( List.class.isAssignableFrom( returnType ) ) {
                multiValued = true;
                isOrdered = true;
            } else if ( Collection.class.isAssignableFrom( returnType ) ) {
                multiValued = true;
                isOrdered = false;
            }
            return handleStaticAttribute( action, attrName, multiValued, isOrdered, returnType, args != null ? args[0] : null );
        }
        if ( method.getName( ).startsWith( "create" ) ) {
            if ( method.getName( ).equals( "createClassR" ) && args.length > 0 ) {
                Method creator = findMethod( getOriginal( ), "refCreateInstance", new Class<?>[0] ); // use parameter-less constructor
                Object refObj = super.invoke( getOriginal( ), creator, null );
                Method getter = refObj.getClass( ).getMethod( "getMultiZeroUnboundCollOfCollOfString", new Class[0] );
                Collection collection = (Collection) getter.invoke( refObj );
                Collection arg = (Collection) args[0];
                for ( Object coll : arg ) {
                    collection.addAll( (Collection) coll );
                }
                return refObj;
            }
            ExtentHelper.setCurrentExtentId( extentId );
            if ( RefStruct.class.isAssignableFrom( method.getReturnType( ) ) ) {
                String structName = method.getName( ).substring( 6 );
                return refCreateStruct( new Object[] { structName, new ArrayList( Arrays.asList( args ) ) } );
            }
            Method creator = findMethod( proxy, "refCreateInstance", new Class<?>[] { java.util.List.class } );
            return super.invoke( proxy, creator, args == null ? null : new Object[] { new ArrayList( Arrays.asList( args ) ) } );
        }
        return super.invoke( proxy, method, args );
    }

    private Object refCreateStruct( Object[] args ) {

        CoreConnection conn = ( (Wrapper<CoreConnection>) getOriginalConnection( ) ).unwrap( );
        SpiJmiHelper jmiHelper = conn.getCoreJmiHelper( );
        StructureType structureType = null;
        if ( args[0] instanceof OriginalContainer ) {
            structureType = ( (Wrapper<StructureType>) ( (OriginalContainer) args[0] ).get___Original( ) ).unwrap( );
        } else {
            ModelElement me;
            MofClass metaObject = ( (com.sap.tc.moin.repository.mmi.reflect.RefClass) ( (Wrapper) getOriginal( ) ).unwrap( ) ).refMetaObject( );
            try {
                me = jmiHelper.getAllContentMap( null /* session */, metaObject ).get( args[0] );
            } catch ( Exception e ) {
                throw new InvalidCallException( args[0], null, "refCreateStruct(String, List)" ); //$NON-NLS-1$
            }
            if ( me instanceof StructureType ) {
                structureType = (StructureTypeImpl) me;
            } else {
                throw new InvalidCallException( args[0], null, "refCreateStruct(String, List)" ); //$NON-NLS-1$
            }
        }
        String structImpl = jmiHelper.getJmiInterfaceName( conn, structureType );
        structImpl = structImpl.substring( 0, structImpl.lastIndexOf( '.' ) + 1 ) + "__impl." + structImpl.substring( structImpl.lastIndexOf( '.' ) + 1 ) + "Impl";
        RefStructImpl result;
        try {
            result = (RefStructImpl) Class.forName( structImpl ).newInstance( );
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
        List<StructureField> structureFields = jmiHelper.getStructureFields( conn.getSession( ), structureType, true /* includeSupertypes */);
        List params = (List) args[1];
        if ( structureFields.size( ) == params.size( ) ) {
            for ( int i = 0, n = structureFields.size( ); i < n; i++ ) {
                StructureField structureField = structureFields.get( i );
                Object parameterToSet = params.get( i );
                if ( parameterToSet != null && !jmiHelper.checkTypeCompatibility( conn, structureField.getType( ), parameterToSet ) ) {
                    throw new javax.jmi.reflect.TypeMismatchException( structureField.getType( ).getClass( ), null, null );
                }
                result.set___Value( structureField.getName( ), parameterToSet );
            }
        } else {
            throw new JmiException( JmiBase.JMI_BASE_0005, args[0], Integer.valueOf( params.size( ) ), Integer.valueOf( structureFields.size( ) ) );
        }
        return convertToJmi( result );
    }

    private Object refGetEnum( Object[] args ) {

        CoreConnection conn = ( (Wrapper<CoreConnection>) getOriginalConnection( ) ).unwrap( );
        SpiJmiHelper jmiHelper = conn.getCoreJmiHelper( );
        EnumerationType enumerationType = null;
        if ( args[0] instanceof OriginalContainer ) {
            enumerationType = ( (Wrapper<EnumerationType>) ( (OriginalContainer) args[0] ).get___Original( ) ).unwrap( );
        } else {
            ModelElement me;
            MofClass metaObject = ( (com.sap.tc.moin.repository.mmi.reflect.RefClass) ( (Wrapper) getOriginal( ) ).unwrap( ) ).refMetaObject( );
            try {
                me = jmiHelper.getAllContentMap( null /* session */, metaObject ).get( args[0] );
            } catch ( Exception e ) {
                throw new InvalidCallException( args[0], null, "refGetEnum(String, String)" ); //$NON-NLS-1$
            }
            if ( me instanceof EnumerationType ) {
                enumerationType = (EnumerationType) me;
            } else {
                throw new InvalidCallException( args[0], null, JmiBase.OBJECTNOTENUM, args[0] );
            }
        }
        if ( !( enumerationType.getLabels( ).contains( args[1] ) ) ) {
            throw new InvalidNameException( (String) args[1], JmiBase.LABELNOTINENUM, args[0], args[1] );
        }
        String enumImpl = jmiHelper.getJmiInterfaceName( conn, enumerationType ) + "Enum";
        try {
            Class cls = Class.forName( enumImpl );
            Field field = cls.getDeclaredField( ( (String) args[1] ).toUpperCase( Locale.ENGLISH ) );
            return convertToJmi( field.get( null ) );
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
    }

    private Object handleStaticAttribute( String action, String attrName, boolean multiValued, boolean isOrdered, Class returnType, Object value ) {

        Object result = null;
        if ( staticAttributes == null ) {
            staticAttributes = new HashMap<String, Object>( );
        }
        if ( action.equals( "set" ) ) {
            // can only be :1
            staticAttributes.put( attrName, value );
        } else {
            if ( staticAttributes.containsKey( attrName ) ) {
                result = staticAttributes.get( attrName );
            } else {
                if ( multiValued ) {
                    if ( isOrdered ) {
                        staticAttributes.put( attrName, result = new ArrayList( ) );
                    } else {
                        staticAttributes.put( attrName, result = new HashSet( ) );
                    }
                } else {
                    if ( returnType == Integer.TYPE ) {
                        result = 0;
                    }
                    staticAttributes.put( attrName, result );
                }
            }
        }
        return result;
    }
}