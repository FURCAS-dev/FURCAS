// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestCases.java

package com.sap.tc.moin.repository.test.jmitck.javatest.lib;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.Test;

// Referenced classes of package com.sun.javatest.lib:
// MultiStatus

@SuppressWarnings( "nls" )
public class TestCases {

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        public Fault( String s ) {

            super( s );
        }
    }

    public TestCases( Test test1, PrintWriter printwriter ) {

        selectedCases = new Hashtable<String, Method>( );
        excludedCases = new Hashtable<String, Method>( );
        test = test1;
        log = printwriter;
        testClass = test1.getClass( );
    }

    public void select( String s ) throws Fault {

        select( split( s ) );
    }

    public void select( String as[] ) throws Fault {

        for ( int i = 0; i < as.length; i++ ) {
            String s = as[i];
            selectedCases.put( s, getTestCase( s ) );
        }

    }

    public void exclude( String s ) throws Fault {

        exclude( split( s ) );
    }

    public void exclude( String as[] ) throws Fault {

        for ( int i = 0; i < as.length; i++ ) {
            String s = as[i];
            excludedCases.put( s, getTestCase( s ) );
        }

    }

    public Enumeration<Method> enumerate( ) {

        Vector<Method> vector = new Vector<Method>( );
        if ( selectedCases.isEmpty( ) ) {
            Method amethod[] = testClass.getMethods( );
            for ( int i = 0; i < amethod.length; i++ ) {
                Method method1 = amethod[i];
                if ( excludedCases.get( method1.getName( ) ) == null ) {
                    Class<?> aclass[] = method1.getParameterTypes( );
                    Class<?> class1 = method1.getReturnType( );
                    if ( aclass.length == 0 && ( com.sap.tc.moin.repository.test.jmitck.javatest.Status.class ).isAssignableFrom( class1 ) ) {
                        vector.addElement( method1 );
                    }
                }
            }

        } else {
            for ( Enumeration<Method> enumeration = selectedCases.elements( ); enumeration.hasMoreElements( ); ) {
                Method method = enumeration.nextElement( );
                if ( excludedCases.get( method.getName( ) ) == null ) {
                    vector.addElement( method );
                }
            }

        }
        return vector.elements( );
    }

    public Status invokeTestCases( ) {

        Method method;
        try {
            method = testClass.getMethod( "invokeTestCase", new Class[] { java.lang.reflect.Method.class } );
            if ( !( com.sap.tc.moin.repository.test.jmitck.javatest.Status.class ).isAssignableFrom( method.getReturnType( ) ) ) {
                method = null;
            }
        } catch ( NoSuchMethodException nosuchmethodexception ) {
            method = null;
        }
        MultiStatus multistatus = new MultiStatus( log );
        Method method1;
        Status status;
        for ( Enumeration<Method> enumeration = enumerate( ); enumeration.hasMoreElements( ); multistatus.add( method1.getName( ), status ) ) {
            method1 = enumeration.nextElement( );
            try {
                if ( method != null ) {
                    status = (Status) method.invoke( test, new Object[] { method1 } );
                } else {
                    status = (Status) method1.invoke( test, noArgs );
                }
            } catch ( IllegalAccessException illegalaccessexception ) {
                status = Status.failed( "Could not access test case: " + method1.getName( ) );
            } catch ( InvocationTargetException invocationtargetexception ) {
                printStackTrace( invocationtargetexception.getTargetException( ) );
                status = Status.failed( "Exception from test case: " + invocationtargetexception.getTargetException( ).toString( ) );
            } catch ( ThreadDeath threaddeath ) {
                printStackTrace( threaddeath );
                throw threaddeath;
            } catch ( Throwable throwable ) {
                printStackTrace( throwable );
                status = Status.failed( "Unexpected Throwable: " + throwable );
            }
        }

        if ( multistatus.getTestCount( ) == 0 ) {
            return Status.error( "No test cases executed." );
        } else {
            return multistatus.getStatus( );
        }
    }

    protected void printStackTrace( Throwable throwable ) {

        if ( log != null ) {
            throwable.printStackTrace( log );
        }
    }

    private Method getTestCase( String s ) throws Fault {

        try {
            Method method = testClass.getMethod( s, noArgTypes );
            if ( !( com.sap.tc.moin.repository.test.jmitck.javatest.Status.class ).isAssignableFrom( method.getReturnType( ) ) ) {
                throw new Fault( "Method for test case '" + s + "' has wrong return type" );
            } else {
                return method;
            }
        } catch ( NoSuchMethodException nosuchmethodexception ) {
            throw new Fault( "Could not find test case: " + s );
        } catch ( SecurityException securityexception ) {
            throw new Fault( securityexception.toString( ) );
        }
    }

    private String[] split( String s ) {

        Vector<String> vector = new Vector<String>( );
        int i = 0;
        for ( int j = s.indexOf( ',' ); j != -1; j = s.indexOf( ',', i ) ) {
            vector.addElement( s.substring( i, j ) );
            i = j + 1;
        }

        if ( i != s.length( ) ) {
            vector.addElement( s.substring( i ) );
        }
        String as[] = new String[vector.size( )];
        vector.copyInto( as );
        return as;
    }

    private Object test;

    private Class<?> testClass;

    private Hashtable<String, Method> selectedCases;

    private Hashtable<String, Method> excludedCases;

    private PrintWriter log;

    private static final Object noArgs[] = new Object[0];

    private static final Class<?> noArgTypes[] = new Class[0];

}
