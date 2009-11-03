package com.sap.tc.moin.repository.core.jmifitting;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;
import com.sap.tc.moin.repository.spi.core.Wrapper;

@SuppressWarnings( { "unchecked", "nls" } )
public class MmiToJmiNameMapping {

    private static Map<String, String> jmiToMmi = new HashMap<String, String>( );

    private static Map<String, String> mmiToJmi = new HashMap<String, String>( );

    // init
    static {
        jmiToMmi.put( "com.tst", "com.sap.tc.moin.repository.test.jmitck.tst" );
        jmiToMmi.put( "javax.jmi.model", "com.sap.tc.moin.repository.mmi.model" );

        loadMap( "cop.sap.tc.moin.jmi2mmi", jmiToMmi );

        mmiToJmi.put( "com.sap.tc.moin.repository.test.jmitck.tst", "com.tst" );
        mmiToJmi.put( "com.sap.tc.moin.repository.mmi.model", "javax.jmi.model" );
        mmiToJmi.put( "com.sap.tc.moin.repository.mmi.reflect", "javax.jmi.reflect" );

        loadMap( "cop.sap.tc.moin.mmi2jmi", mmiToJmi );

    }

    private static void loadMap( String propertyName, Map<String, String> map ) {

        String fileNameProp = System.getProperty( propertyName );

        if ( fileNameProp != null ) {
            Properties p = new Properties( );

            try {
                p.load( new FileInputStream( fileNameProp ) );
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }

            for ( Entry<Object, Object> e : p.entrySet( ) ) {
                map.put( (String) e.getKey( ), (String) e.getValue( ) );
            }
        }
    }

    private static Class map( String mmiClassName ) {

        String className = convertNameToJmi( mmiClassName );
        try {
            return Class.forName( className );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    public static String convertNameToJmi( String mmiClassName ) {


        for ( Entry<String, String> e : mmiToJmi.entrySet( ) ) {

            if ( mmiClassName.startsWith( e.getKey( ) ) ) {
                return mmiClassName.replaceAll( e.getKey( ), e.getValue( ) );
            }
        }

        throw new IllegalStateException( "Unknown class: " + mmiClassName );
    }

    public static String convertNameToMmi( String jmiName ) {

        for ( Entry<String, String> e : jmiToMmi.entrySet( ) ) {

            if ( jmiName.startsWith( e.getKey( ) ) ) {
                return jmiName.replaceAll( e.getKey( ), e.getValue( ) );
            }
        }

        throw new IllegalStateException( "Unknown class: " + jmiName );
    }

    public static Class map( RefAssociation assoc ) {

        return map( ( (Partitionable) assoc ).get___JmiInterface( ).getCanonicalName( ) );
    }

    public static Class map( RefClass clazz ) {

        String className = clazz.refImmediatePackage( ).get___JmiInterface( ).getCanonicalName( );
        CoreConnection conn = ( (Wrapper<CoreConnection>) clazz.get___Connection( ) ).unwrap( );
        String jmiInterfaceName = conn.getCoreJmiHelper( ).getJmiInterfaceName( conn, ( (Wrapper<RefClassImpl>) clazz ).unwrap( ).refMetaObject( ) );
        String name = jmiInterfaceName.substring( jmiInterfaceName.lastIndexOf( '.' ) + 1 );
        className = className.substring( 0, className.lastIndexOf( '.' ) + 1 ) + name + "Class";
        return map( className );
    }

    public static Class map( RefPackage refPackage ) {

        return map( ( (Partitionable) refPackage ).get___JmiInterface( ).getCanonicalName( ) );
    }

    public static Class map( RefEnum refEnum ) {

        return map( ( (Partitionable) refEnum ).get___JmiInterface( ).getCanonicalName( ) );
    }

    public static Class map( RefStruct refStruct ) {

        Class<?> intFace = refStruct.getClass( ).getInterfaces( )[0];
        return map( intFace.getCanonicalName( ) );
    }

    public static Class map( com.sap.tc.moin.repository.mmi.reflect.RefObject object ) {

        return map( ( (Partitionable) object ).get___JmiInterface( ).getCanonicalName( ) );
    }
}