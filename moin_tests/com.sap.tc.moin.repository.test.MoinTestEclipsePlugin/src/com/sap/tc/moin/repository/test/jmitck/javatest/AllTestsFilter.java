// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: AllTestsFilter.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestFilter, TestDescription

@SuppressWarnings( "nls" )
public class AllTestsFilter extends TestFilter {

    public AllTestsFilter( ) {

    }

    @Override
    public String getName( ) {

        return i18n.getString( "allTestsFilter.name" );
    }

    @Override
    public String getDescription( ) {

        return i18n.getString( "allTestsFilter.description" );
    }

    @Override
    public String getReason( ) {

        return i18n.getString( "allTestsFilter.reason" );
    }

    @Override
    public boolean accepts( TestDescription testdescription ) throws TestFilter.Fault {

        return true;
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private static I18NResourceBundle i18n;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.AllTestsFilter.class );
    }
}
