// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: JavaTestError.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.PrintStream;
import java.io.PrintWriter;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

@SuppressWarnings( "nls" )
public class JavaTestError extends Error {

    private static final long serialVersionUID = 1L;

    public JavaTestError( String s ) {

        super( s );
    }

    public JavaTestError( String s, Throwable throwable ) {

        super( s );
        original = throwable;
    }

    public JavaTestError( I18NResourceBundle i18nresourcebundle, String s ) {

        super( i18nresourcebundle.getString( s ) );
    }

    public JavaTestError( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

        super( i18nresourcebundle.getString( s, obj ) );
    }

    public JavaTestError( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

        super( i18nresourcebundle.getString( s, aobj ) );
    }

    public JavaTestError( I18NResourceBundle i18nresourcebundle, String s, Throwable throwable ) {

        super( i18nresourcebundle.getString( s, throwable ) );
        original = throwable;
    }

    public JavaTestError( I18NResourceBundle i18nresourcebundle, String s, Object obj, Throwable throwable ) {

        super( i18nresourcebundle.getString( s, new Object[] { obj, throwable } ) );
        original = throwable;
    }

    public JavaTestError( I18NResourceBundle i18nresourcebundle, String s, Object aobj[], Throwable throwable ) {

        super( i18nresourcebundle.getString( s, join( aobj, throwable ) ) );
        original = throwable;
    }

    @Override
    public void printStackTrace( ) {

        printStackTrace( System.err );
    }

    @Override
    public void printStackTrace( PrintStream printstream ) {

        printstream.println( "**  " + GENERIC_START + "  **" );
        super.printStackTrace( printstream );
        if ( original != null ) {
            printstream.println( "--> " + ROOT_CAUSE );
            original.printStackTrace( printstream );
        }
        printstream.println( "**  " + GENERIC_END + "  **" );
    }

    @Override
    public void printStackTrace( PrintWriter printwriter ) {

        printwriter.println( "**  " + GENERIC_START + "  **" );
        super.printStackTrace( printwriter );
        if ( original != null ) {
            printwriter.println( "--> " + ROOT_CAUSE );
            original.printStackTrace( printwriter );
        }
        printwriter.println( "**  " + GENERIC_END + "  **" );
    }

    public Throwable getOriginalFault( ) {

        return original;
    }

    private static Object[] join( Object aobj[], Object obj ) {

        Object aobj1[] = new Object[aobj.length + 1];
        System.arraycopy( aobj, 0, aobj1, 0, aobj.length );
        aobj1[aobj.length] = obj;
        return aobj1;
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    protected Throwable original;

    private static I18NResourceBundle i18n;

    private static final String GENERIC_START;

    private static final String GENERIC_END;

    private static final String ROOT_CAUSE;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.JavaTestError.class );
        GENERIC_START = i18n.getString( "fault.genericMsgStart" );
        GENERIC_END = i18n.getString( "fault.genericMsgEnd" );
        ROOT_CAUSE = i18n.getString( "fault.origin" );
    }
}
