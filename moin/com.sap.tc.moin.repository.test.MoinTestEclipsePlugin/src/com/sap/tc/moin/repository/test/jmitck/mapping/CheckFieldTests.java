package com.sap.tc.moin.repository.test.jmitck.mapping;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;

/**
 * Provides Tests to check characteristics of a Field.
 */
@SuppressWarnings( "nls" )
public class CheckFieldTests extends MappingTests {

    private boolean expected;

    private String fullFieldName;

    private Class<?> type;

    private static Map<String, Object> typeAbbrevMap;

    static {
        staticInit( );
    }

    @Override
    public void init( ClassLoader loader, TestDescription td, PrintWriter pw ) {

        super.init( loader, td, pw );
        this.fullFieldName = getParam( "fieldName", true );
        this.expected = getBooleanParam( "expected", false );
    }

    public Status fieldExists( ) {

        int result = Status.NOT_RUN;
        String msg = null;
        boolean exists = false;
        Field f = getField( );

        trOut.println( "Test case expects this field to " + ( ( expected ) ? "" : "not " ) + "exist" );

        if ( f == null ) {
            exists = false;
            msg = "Field " + fullFieldName + " does not exist";
        } else {
            exists = true;
            msg = "Field " + fullFieldName + " exists";
        }
        if ( exists ^ ( !expected ) ) {
            result = Status.PASSED;
        } else {
            result = Status.FAILED;
        }
        return new Status( result, msg );
    }

    public Status typedAs( ) {

        Status answer = null;
        String expectedFieldType = getParam( "fieldType", true );
        Field f = getField( );
        trOut.println( "Test case expects this field to be of type " + expectedFieldType );
        if ( f == null ) {
            answer = Status.failed( "Cannot determine field compliance; field " + fullFieldName + " not found" );
        } else {
            if ( isType( f.getType( ), expectedFieldType ) ) {
                answer = Status.passed( "Field " + fullFieldName + " is defined as type " + expectedFieldType );
            } else {
                answer = Status.failed( "Field " + fullFieldName + " does is not defined as type " + expectedFieldType + "; but is defined as " + f.getType( ).getName( ) );
            }
        }
        return answer;
    }

    private Field getField( ) {

        Field f = null;
        String typeName = Util.extractTypeName( fullFieldName );
        String fieldName = Util.extractMemberName( fullFieldName );
        try {
            type = Class.forName( typeName, true, getClassLoader( ) );
        } catch ( ClassNotFoundException cnfe ) {
            // type == null indicates this condition
        }
        if ( type != null ) {
            try {
                f = type.getField( fieldName );
                trOut.println( "Examining field " + fieldName + " from " + type.getName( ) );
            } catch ( NoSuchFieldException nsme ) {
                trOut.println( "No such field found: " + fieldName + " from " + type.getName( ) );
                // let it return null
            }
        }
        return f;
    }

    private static void staticInit( ) {

        typeAbbrevMap = new HashMap<String, Object>( );
        typeAbbrevMap.put( "void", Void.TYPE );
        typeAbbrevMap.put( "", Void.TYPE );
        typeAbbrevMap.put( "&nbsp;", Void.TYPE );
        typeAbbrevMap.put( "int", Integer.TYPE );
        typeAbbrevMap.put( "boolean", Boolean.TYPE );
        typeAbbrevMap.put( "byte", Byte.TYPE );
        typeAbbrevMap.put( "char", Character.TYPE );
        typeAbbrevMap.put( "double", Double.TYPE );
        typeAbbrevMap.put( "float", Float.TYPE );
        typeAbbrevMap.put( "long", Long.TYPE );
        typeAbbrevMap.put( "String", String.class );
        typeAbbrevMap.put( "short", Short.TYPE );
    }

    private static boolean isType( Class<?> type, String name ) {

        boolean answer = false;
        if ( type.getName( ).equals( name ) ) {
            answer = true;
        } else {
            Class<?> cls = (Class<?>) typeAbbrevMap.get( name );
            // compare names, rather than instances, to avoid any
            // classloader issues
            if ( ( cls != null ) && cls.getName( ).equals( type.getName( ) ) ) {
                answer = true;
            }
        }
        return answer;
    }

    public Status isPublic( ) {

        Status answer = null;
        Field f = getField( );
        trOut.println( "Test case expects this field to " + ( ( expected ) ? "be " : "not be " ) + "public" );
        if ( f == null ) {
            answer = Status.failed( "Cannot determine field compliance; field " + fullFieldName + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isPublic = false;
            if ( Modifier.isPublic( f.getModifiers( ) ) ) {
                isPublic = true;
                msg = "Field " + fullFieldName + " is public";
            } else {
                isPublic = false;
                msg = "Field " + fullFieldName + " is not public";
            }
            if ( isPublic ^ ( !expected ) ) {
                result = Status.PASSED;
            } else {
                result = Status.FAILED;
            }
            answer = new Status( result, msg );
        }
        return answer;
    }

    public Status isStatic( ) {

        Status answer = null;
        Field f = getField( );
        trOut.println( "Test case expects this field to " + ( ( expected ) ? "be " : "not be " ) + "static" );
        if ( f == null ) {
            answer = Status.failed( "Cannot determine field compliance; field " + fullFieldName + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isStatic = false;
            if ( Modifier.isStatic( f.getModifiers( ) ) ) {
                isStatic = true;
                msg = "Field " + fullFieldName + " is static";
            } else {
                isStatic = false;
                msg = "Field " + fullFieldName + " is not static";
            }
            if ( isStatic ^ ( !expected ) ) {
                result = Status.PASSED;
            } else {
                result = Status.FAILED;
            }
            answer = new Status( result, msg );
        }
        return answer;
    }

    public Status isFinal( ) {

        Status answer = null;
        Field f = getField( );
        trOut.println( "Test case expects this field to " + ( ( expected ) ? "be " : "not be " ) + "final" );
        if ( f == null ) {
            answer = Status.failed( "Cannot determine field compliance; field " + fullFieldName + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isFinal = false;
            if ( Modifier.isFinal( f.getModifiers( ) ) ) {
                isFinal = true;
                msg = "Field " + fullFieldName + " is final";
            } else {
                isFinal = false;
                msg = "Field " + fullFieldName + " is not final";
            }
            if ( isFinal ^ ( !expected ) ) {
                result = Status.PASSED;
            } else {
                result = Status.FAILED;
            }
            answer = new Status( result, msg );
        }
        return answer;
    }

}
