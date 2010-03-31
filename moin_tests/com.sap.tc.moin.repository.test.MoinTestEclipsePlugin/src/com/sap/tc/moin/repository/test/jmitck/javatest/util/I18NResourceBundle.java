// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: I18NResourceBundle.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@SuppressWarnings( "nls" )
public class I18NResourceBundle extends ResourceBundle {

    public static I18NResourceBundle getBundleForClass( Class<?> class1 ) {

        String s = class1.getName( );
        int i = s.lastIndexOf( '.' );
        String s1 = i != -1 ? s.substring( 0, i ) + ".i18n" : "i18n";
        boolean flag = logClassPrefix != null ? s.startsWith( logClassPrefix ) : false;
        return new I18NResourceBundle( s1, flag, class1.getClassLoader( ) );
    }

    public String getString( String s, Object obj ) {

        return getString( s, new Object[] { obj } );
    }

    public String getString( String s, Object aobj[] ) {

        try {
            return MessageFormat.format( getString( s ), aobj );
        } catch ( MissingResourceException missingresourceexception ) {
            System.err.println( "WARNING: missing resource: " + s + " for " + name );
        }
        StringBuffer stringbuffer = new StringBuffer( s );
        for ( int i = 0; i < aobj.length; i++ ) {
            stringbuffer.append( '\n' );
            stringbuffer.append( ( (Object) ( aobj ) ).toString( ) );
        }

        return stringbuffer.toString( );
    }

    public String getOptionalString( String s ) {

        if ( _flddelegate == null ) {
            _flddelegate = ResourceBundle.getBundle( name, Locale.getDefault( ), classLoader );
        }
        try {
            String s1 = (String) _flddelegate.getObject( s );
            if ( s1 != null && logging ) {
                System.out.println( "i18n: " + s );
            }
            return s1;
        } catch ( MissingResourceException missingresourceexception ) {
            return null;
        }
    }

    private I18NResourceBundle( String s, boolean flag, ClassLoader classloader ) {

        name = s;
        logging = flag;
        classLoader = classloader;
    }

    @Override
    protected Object handleGetObject( String s ) throws MissingResourceException {

        try {
            if ( logging ) {
                System.out.println( "i18n: " + s );
            }
            if ( _flddelegate == null ) {
                _flddelegate = ResourceBundle.getBundle( name, Locale.getDefault( ), classLoader );
            }
            return _flddelegate.getObject( s );
        } catch ( MissingResourceException missingresourceexception ) {
            System.err.println( "WARNING: missing resource: " + s + " for " + name );
        }
        return s;
    }

    @Override
    public Enumeration<String> getKeys( ) {

        if ( _flddelegate == null ) {
            _flddelegate = ResourceBundle.getBundle( name );
        }
        return _flddelegate.getKeys( );
    }

    private String name;

    private ResourceBundle _flddelegate;

    private boolean logging;

    private ClassLoader classLoader;

    private static final String logClassPrefix = System.getProperty( "javatest.i18n.log" );

}
