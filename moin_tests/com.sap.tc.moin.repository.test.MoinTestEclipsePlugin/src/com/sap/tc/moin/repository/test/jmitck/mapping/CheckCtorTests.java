package com.sap.tc.moin.repository.test.jmitck.mapping;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

/**
 * Provides Tests to check characteristics of a Ctor.
 */
@SuppressWarnings( "nls" )
public class CheckCtorTests extends MappingTests {

    private static final I18NResourceBundle i18n = I18NResourceBundle.getBundleForClass( CheckCtorTests.class );

    private boolean expected;

    private String typeName = "[UNKNOWN]"; // in case used before set

    private Class<?> type;

    private String argTypes = "[UNKNOWN]"; // in case used before set

    private static Map<String, Object> typeAbbrevMap;

    static {
        staticInit( );
    }

    @Override
    public void init( ClassLoader loader, TestDescription td, PrintWriter pw ) {

        super.init( loader, td, pw );
        this.typeName = getParam( "typeName", true );
        this.expected = getBooleanParam( "expected", false );
    }

    public Status ctorExists( ) {

        int result = Status.NOT_RUN;
        String msg = null;
        boolean exists = false;
        Constructor<?> ctor = getCtor( );
        trOut.println( "Test case expects this constructor to " + ( ( expected ) ? "" : "not " ) + "exist" );

        if ( ctor == null ) {
            exists = false;
            msg = "Constructor" + ctorName( ) + " does not exist";
        } else {
            exists = true;
            msg = "Constructor" + ctorName( ) + " exists";
        }
        if ( exists ^ ( !expected ) ) {
            result = Status.PASSED;
        } else {
            result = Status.FAILED;
        }
        return new Status( result, msg );
    }

    private String ctorName( ) {

        return typeName + "(" + argTypes + ")";
    }

    private Constructor<?> getCtor( ) {

        Constructor<?> ctor = null;
        try {
            type = Class.forName( typeName, true, getClassLoader( ) );
        } catch ( ClassNotFoundException cnfe ) {
            // type == null indicates this condition
        }
        if ( type != null ) {
            List<String> argTypeNames = getParamList( "argTypes", true );
            Class<?>[] argTypeArray = getTypeList( argTypeNames );
            argTypes = CheckTypeTests.asCSL( argTypeArray );
            try {
                ctor = type.getConstructor( argTypeArray );
                trOut.println( "Examining constructor " + ctorName( ) );
            } catch ( NoSuchMethodException nsme ) {
                trOut.println( "Could not find constructor " + ctorName( ) );
                // let it return null
            }
        }
        return ctor;
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

    private Class<?>[] getTypeList( List<String> typeNames ) {

        Class<?>[] answer = new Class[typeNames.size( )];
        for ( int i = 0; i < typeNames.size( ); i++ ) {
            String typeName = typeNames.get( i );
            Class<?> cls = (Class<?>) typeAbbrevMap.get( typeName );
            if ( cls == null ) {
                try {
                    cls = Class.forName( typeName, true, getClassLoader( ) );
                } catch ( ClassNotFoundException cnfe ) {
                    throw new TestErrorException( i18n, "mapping.unknownType", typeName );
                }
            }
            answer[i] = cls;
        }
        return answer;
    }

    public Status throwsExceptions( ) {

        Status answer = null;
        String expectedExceptions = getParam( "exceptions", true );
        Constructor<?> ctor = getCtor( );
        trOut.println( "Test case expects this constructor to declare exceptions " + expectedExceptions );
        if ( ctor == null ) {
            answer = Status.failed( "Cannot determine constructor compliance; " + ctorName( ) + " not found" );
        } else {
            Class<?>[] exceptions = ctor.getExceptionTypes( );
            String actualExcList = CheckTypeTests.asCSL( exceptions );
            if ( ( expectedExceptions == null ) || expectedExceptions.trim( ).equals( "" ) ) {
                expectedExceptions = "no types";
            }
            if ( actualExcList.equals( expectedExceptions ) ) {
                answer = Status.passed( "Constructor " + ctorName( ) + " throws " + expectedExceptions + " as expected" );
            } else {
                answer = Status.failed( "Constructor " + ctorName( ) + " expected to thow " + expectedExceptions + " but instead throws " + actualExcList );
            }
        }
        return answer;
    }

    public Status isPublic( ) {

        Status answer = null;
        Constructor<?> ctor = getCtor( );
        trOut.println( "Test case expects this constructor to " + ( ( expected ) ? "be " : "not be " ) + "public" );
        if ( ctor == null ) {
            answer = Status.failed( "Cannot determine constructor compliance; ctor " + ctorName( ) + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isPublic = false;
            if ( Modifier.isPublic( ctor.getModifiers( ) ) ) {
                isPublic = true;
                msg = "Constructor " + ctorName( ) + " is public";
            } else {
                isPublic = false;
                msg = "Constructor " + ctorName( ) + " is not public";
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

}
