// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: ProductInfo.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SuppressWarnings( "nls" )
public class ProductInfo {

    public ProductInfo( ) {

    }

    public static String getName( ) {

        return "JavaTest";
    }

    public static String getVersion( ) {

        return getProperty( "version" );
    }

    public static String getMilestone( ) {

        return getProperty( "milestone" );
    }

    public static String getBuildNumber( ) {

        return getProperty( "build" );
    }

    public static String getBuildJavaVersion( ) {

        return getProperty( "java" );
    }

    public static String getBuildDate( ) {

        return getProperty( "date" );
    }

    private static String getProperty( String s ) {

        if ( info == null ) {
            info = new Properties( );
            try {
                InputStream inputstream = ( com.sap.tc.moin.repository.test.jmitck.javatest.ProductInfo.class ).getResourceAsStream( "/buildInfo.txt" );
                if ( inputstream != null ) {
                    info.load( inputstream );
                    inputstream.close( );
                }
            } catch ( IOException ioexception ) {
            }
        }
        return info.getProperty( s, "unset" );
    }

    private static Properties info;
}
