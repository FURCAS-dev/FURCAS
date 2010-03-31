package com.sap.tc.moin.repository.test.jmitck.mapping;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

/**
 * Provides Tests to check characteristics of a Method.
 */
@SuppressWarnings( "nls" )
public class CheckMethodTests extends MappingTests {

    private static final I18NResourceBundle i18n = I18NResourceBundle.getBundleForClass( CheckMethodTests.class );

    private boolean expected;

    private String fullMethodName;

    private Class<?> type;

    private static Map<String, Object> typeAbbrevMap;

    static {
        staticInit( );
    }

    @Override
    public void init( ClassLoader loader, TestDescription td, PrintWriter pw ) {

        super.init( loader, td, pw );
        this.fullMethodName = getParam( "methodName", true );
        this.expected = getBooleanParam( "expected", false );
    }

    public Status methodExists( ) {

        int result = Status.NOT_RUN;
        String msg = null;
        boolean exists = false;
        Method m = getMethod( );

        trOut.println( "Test case expects this method to " + ( ( expected ) ? "" : "not " ) + "exist" );

        if ( m == null ) {
            exists = false;
            msg = "Method " + fullMethodName + " does not exist";
        } else {
            exists = true;
            msg = "Method " + fullMethodName + " exists";
        }
        if ( exists ^ ( !expected ) ) {
            result = Status.PASSED;
        } else {
            result = Status.FAILED;
        }
        return new Status( result, msg );
    }

    public Status returnsType( ) {

        Status answer = null;
        String expectedReturnType = getParam( "returnType", true );
        Method m = getMethod( );
        trOut.println( "Test case expects this method to have a return type of " + expectedReturnType );
        if ( m == null ) {
            answer = Status.failed( "Cannot determine method compliance; method " + fullMethodName + " not found" );
        } else {
            if ( isType( m.getReturnType( ), expectedReturnType ) ) {
                answer = Status.passed( "Method " + fullMethodName + " returns type " + expectedReturnType );
            } else {
                answer = Status.failed( "Method " + fullMethodName + " does not return  type " + expectedReturnType + "; but returns type " + m.getReturnType( ).getName( ) );
            }
        }
        return answer;
    }

    private Method getMethod( ) {

        Method m = null;
        String typeName = Util.extractTypeName( fullMethodName );
        String methodName = Util.extractMemberName( fullMethodName );
        try {
            type = Class.forName( typeName, true, getClassLoader( ) );
        } catch ( ClassNotFoundException cnfe ) {
            // type == null indicates this condition
        }
        if ( type != null ) {
            List<String> argTypeNames = getParamList( "argTypes", true );
            Class<?>[] argTypes = getTypeList( argTypeNames );
            try {
                m = type.getMethod( methodName, argTypes );
                trOut.println( "Examining method " + methodName + " from " + type.getName( ) + " with argments " + CheckTypeTests.asCSL( argTypes ) );
            } catch ( NoSuchMethodException nsme ) {
                trOut.println( "No such method: " + methodName + " from " + type.getName( ) + " with argments " + CheckTypeTests.asCSL( argTypes ) );
                // let it return null
            }
        }
        return m;
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

    public Status throwsExceptions( ) {

        Status answer = null;
        String expectedExceptions = getParam( "exceptions", true );
        Method m = getMethod( );
        trOut.println( "Test case expects this method to declare exceptions " + expectedExceptions );
        if ( m == null ) {
            answer = Status.failed( "Cannot determine method compliance; method " + fullMethodName + " not found" );
        } else {
            Class<?>[] exceptions = m.getExceptionTypes( );
            List<Class<?>> checkExc = new ArrayList<Class<?>>( );
            for ( int i = 0; i < exceptions.length; i++ ) {
                if ( !java.lang.RuntimeException.class.isAssignableFrom( exceptions[i] ) ) {
                    checkExc.add( exceptions[i] );
                }
            }
            String actualExcList = CheckTypeTests.asCSL( checkExc.toArray( new Class[] {} ) );
            if ( ( expectedExceptions == null ) || expectedExceptions.trim( ).equals( "" ) ) {
                expectedExceptions = "no types";
            }
            if ( actualExcList.equals( expectedExceptions ) ) {
                answer = Status.passed( "Method " + fullMethodName + " throws " + expectedExceptions + " as expected" );
            } else {
                answer = Status.failed( "Method " + fullMethodName + " expected to thow " + expectedExceptions + " but instead throws " + actualExcList );
            }
        }
        return answer;
    }

    // only makes sense for Class methods (not interface methods)
    public Status isPublic( ) {

        Status answer = null;
        Method m = getMethod( );
        trOut.println( "Test case expects this method to " + ( ( expected ) ? "be " : "not be " ) + "public" );
        if ( m == null ) {
            answer = Status.failed( "Cannot determine method compliance; method " + fullMethodName + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isPublic = false;
            if ( Modifier.isPublic( m.getModifiers( ) ) ) {
                isPublic = true;
                msg = "Method " + fullMethodName + " is public";
            } else {
                isPublic = false;
                msg = "Method " + fullMethodName + " is not public";
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

    // only makes sense for Class methods (not interface methods)
    public Status isStatic( ) {

        Status answer = null;
        Method m = getMethod( );
        trOut.println( "Test case expects this method to " + ( ( expected ) ? "be " : "not be " ) + "static" );
        if ( m == null ) {
            answer = Status.failed( "Cannot determine method compliance; method " + fullMethodName + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isStatic = false;
            if ( Modifier.isStatic( m.getModifiers( ) ) ) {
                isStatic = true;
                msg = "Method " + fullMethodName + " is static";
            } else {
                isStatic = false;
                msg = "Method " + fullMethodName + " is not static";
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

    // only makes sense for Class methods (not interface methods)
    public Status isFinal( ) {

        Status answer = null;
        Method m = getMethod( );
        trOut.println( "Test case expects this method to " + ( ( expected ) ? "be " : "not be " ) + "final" );
        if ( m == null ) {
            answer = Status.failed( "Cannot determine method compliance; method " + fullMethodName + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isFinal = false;
            if ( Modifier.isFinal( m.getModifiers( ) ) ) {
                isFinal = true;
                msg = "Method " + fullMethodName + " is final";
            } else {
                isFinal = false;
                msg = "Method " + fullMethodName + " is not final";
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

    // only makes sense for Class methods (not interface methods)
    public Status isAbstract( ) {

        Status answer = null;
        Method m = getMethod( );
        trOut.println( "Test case expects this method to " + ( ( expected ) ? "be " : "not be " ) + "abstract" );
        if ( m == null ) {
            answer = Status.failed( "Cannot determine method compliance; method " + fullMethodName + " not found" );
        } else {
            String msg = null;
            int result = Status.NOT_RUN;
            boolean isAbstract = false;
            if ( Modifier.isAbstract( m.getModifiers( ) ) ) {
                isAbstract = true;
                msg = "Method " + fullMethodName + " is abstract";
            } else {
                isAbstract = false;
                msg = "Method " + fullMethodName + " is not abstract";
            }
            if ( isAbstract ^ ( !expected ) ) {
                result = Status.PASSED;
            } else {
                result = Status.FAILED;
            }
            answer = new Status( result, msg );
        }
        return answer;
    }

}
