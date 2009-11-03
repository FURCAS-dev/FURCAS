package com.sap.tc.moin.repository.test.jmitck.mapping;

import java.io.PrintWriter;
import java.lang.reflect.Modifier;

import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

/**
 * Provides Tests to check characteristics of a Type (Interface or Class)
 */
@SuppressWarnings( "nls" )
public class CheckTypeTests extends MappingTests {

    private static final I18NResourceBundle i18n = I18NResourceBundle.getBundleForClass( CheckTypeTests.class );

    private boolean expected;

    private String typeName;

    private Class<?> typeUnderTest;

    @Override
    public void init( ClassLoader loader, TestDescription td, PrintWriter pw ) {

        super.init( loader, td, pw );
        this.typeName = getParam( "typeName", true );
        this.typeUnderTest = getTypeUnderTest( typeName );
        this.expected = getBooleanParam( "expected", false );
    }

    public Class<?> getTypeUnderTest( String typeName ) {

        Class<?> answer = null;
        try {
            answer = Class.forName( typeName, true, getClassLoader( ) );
            trOut.println( "Examining type " + typeName + " for this test" );
        } catch ( ClassNotFoundException cnfe ) {
            // typeUnderTest == null indicates this condition
            trOut.println( "No such type found: " + typeName );
        }
        return answer;
    }

    public Status typeExists( ) {

        String msg = null;
        int result = Status.NOT_RUN;
        boolean exists = false; // just for clarity
        trOut.println( "Test case expects this type to " + ( ( expected ) ? "" : "not " ) + "exist" );

        if ( typeUnderTest != null ) {
            exists = true;
            msg = "Type " + typeName + " exists";
        } else {
            exists = false;
            msg = "Type " + typeName + " does not exist";
        }
        if ( exists ^ ( !expected ) ) {
            result = Status.PASSED;
        } else {
            result = Status.FAILED;
        }
        return new Status( result, msg );
    }

    public Status typeIsInterface( ) {

        String msg = null;
        int result = Status.NOT_RUN;
        boolean isInterface = false; // just for clarity
        trOut.println( "Test case expects this type to " + ( ( expected ) ? "be " : "not be " ) + "an interface" );
        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine interface compliance; type " + typeName + " not found" );
        }
        int modifiers = typeUnderTest.getModifiers( );
        if ( Modifier.isInterface( modifiers ) ) {
            isInterface = true;
            msg = "Type " + typeName + " is an interface";
        } else {
            isInterface = false;
            msg = "Type " + typeName + " is not an interface";
        }

        if ( isInterface ^ ( !expected ) ) {
            result = Status.PASSED;
        } else {
            result = Status.FAILED;
        }
        return new Status( result, msg );
    }

    public Status typeIsPublic( ) {

        String msg = null;
        int result = Status.NOT_RUN;
        boolean isPublic = false; // just for clarity
        trOut.println( "Test case expects this type to " + ( ( expected ) ? "be " : "not be " ) + "public" );
        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine access compliance; type " + typeName + " not found" );
        }
        int modifiers = typeUnderTest.getModifiers( );
        if ( Modifier.isPublic( modifiers ) ) {
            isPublic = true;
            msg = "Type " + typeName + " is public";
        } else {
            isPublic = false;
            msg = "Type " + typeName + " is not public";
        }

        if ( isPublic ^ ( !expected ) ) {
            result = Status.PASSED;
        } else {
            result = Status.FAILED;
        }
        return new Status( result, msg );
    }

    public Status typeExtends( ) {

        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine extent compliance; type " + typeName + " not found" );
        }
        String expectedExtends = getParam( "extends", true );
        if ( ( expectedExtends == null ) || expectedExtends.equals( "" ) ) {
            expectedExtends = "no type";
        }
        trOut.println( "Test case expects this type to extend " + expectedExtends );
        String actualExtends = null;
        if ( typeUnderTest.isInterface( ) ) {
            actualExtends = asCSL( typeUnderTest.getInterfaces( ) );
        } else {
            Class<?> clsSuper = typeUnderTest.getSuperclass( );
            actualExtends = ( clsSuper == null ) ? "no type" : clsSuper.getName( );
        }
        if ( actualExtends.equals( expectedExtends ) ) {
            return Status.passed( "Type " + typeName + " extends " + expectedExtends );
        } else {
            return Status.failed( "Type " + typeName + " does not extend " + expectedExtends + " (it extends " + actualExtends + ")" );
        }
    }

    public Status typeIsAbstract( ) {

        String msg = null;
        int result = Status.NOT_RUN;
        boolean isAbstract = false;
        trOut.println( "Test case expects this type to " + ( ( expected ) ? "be " : "not be " ) + "abstract" );
        int modifiers = typeUnderTest.getModifiers( );
        if ( Modifier.isAbstract( modifiers ) ) {
            msg = i18n.getString( "isAbstract", typeName );
            isAbstract = true;
        } else {
            msg = i18n.getString( "notAbstract", typeName );
            isAbstract = false;
        }
        if ( isAbstract ^ ( !expected ) ) {
            result = Status.PASSED;
        } else {
            result = Status.FAILED;
        }
        return new Status( result, msg );
    }

    public Status typeImplements( ) {

        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine implements compliance; type " + typeName + " not found" );
        }
        String expectedImplements = getParam( "implements", true );
        trOut.println( "Test case expects this type to implement " + expectedImplements );
        if ( typeUnderTest.isInterface( ) ) {
            return Status.failed( "Type " + typeName + " is an interface; cannot implement Interfaces" );
        }
        String actualImplements = asCSL( typeUnderTest.getInterfaces( ) );
        if ( ( expectedImplements == null ) || expectedImplements.equals( "" ) ) {
            expectedImplements = "no type";
        }
        if ( actualImplements.equals( expectedImplements ) ) {
            return Status.passed( "Type " + typeName + " implements " + expectedImplements );
        } else {
            return Status.failed( "Type " + typeName + " does not extend " + expectedImplements + " (it implements " + actualImplements + ")" );
        }
    }

    public Status typeContainsTypesCount( ) {

        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine number of contained types compliance; type " + typeName + " not found" );
        }
        int expectedCount = getIntParam( "containedTypeCount", true );
        trOut.println( "Test case expects this type to contain " + expectedCount + " nested types" );
        int actualCount = typeUnderTest.getDeclaredClasses( ).length;
        if ( expectedCount == actualCount ) {
            return Status.passed( "Type " + typeName + " contains " + expectedCount + " nested types, as expected" );
        } else {
            return Status.passed( "Type " + typeName + " contains " + actualCount + " nested types; expected " + expectedCount + " nested types" );
        }
    }

    public Status typeContainsMethodsCount( ) {

        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine number of contained methods compliance; type " + typeName + " not found" );
        }
        int expectedCount = getIntParam( "containedMethodCount", true );
        trOut.println( "Test case expects this type to declare " + expectedCount + " methods" );
        int actualCount = typeUnderTest.getDeclaredMethods( ).length;
        if ( expectedCount == actualCount ) {
            return Status.passed( "Type " + typeName + " contains " + expectedCount + " methods, as expected" );
        } else {
            return Status.passed( "Type " + typeName + " contains " + actualCount + " methods; expected " + expectedCount + " methods" );
        }
    }

    public Status typeContainsCtorsCount( ) {

        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine number of contained constructors compliance; type " + typeName + " not found" );
        }
        int expectedCount = getIntParam( "containedCtorCount", true );
        trOut.println( "Test case expects this type to declare " + expectedCount + " constructors" );
        int actualCount = typeUnderTest.getConstructors( ).length;
        if ( expectedCount == actualCount ) {
            return Status.passed( "Type " + typeName + " contains " + expectedCount + " constructors, as expected" );
        } else {
            return Status.passed( "Type " + typeName + " contains " + actualCount + " constructors; expected " + expectedCount + " constructors" );
        }
    }

    public Status typeContainsFieldsCount( ) {

        if ( typeUnderTest == null ) {
            return Status.failed( "Cannot determine number of contained fields compliance; type " + typeName + " not found" );
        }
        int expectedCount = getIntParam( "containedFieldCount", true );
        trOut.println( "Test case expects this type to declare " + expectedCount + " fields" );
        int actualCount = typeUnderTest.getDeclaredFields( ).length;
        if ( expectedCount == actualCount ) {
            return Status.passed( "Type " + typeName + " contains " + expectedCount + " fields, as expected" );
        } else {
            return Status.passed( "Type " + typeName + " contains " + actualCount + " fields; expected " + expectedCount + " fields" );
        }
    }

    public static String asCSL( Class<?>[] types ) {

        String answer = null;
        if ( types.length > 0 ) {
            StringBuffer sb = new StringBuffer( );
            for ( int i = 0; i < types.length; i++ ) {
                if ( i > 0 ) {
                    sb.append( "," );
                }
                sb.append( types[i].getName( ) );
            }
            answer = sb.toString( );
        } else {
            answer = "no types";
        }
        return answer;
    }

}
