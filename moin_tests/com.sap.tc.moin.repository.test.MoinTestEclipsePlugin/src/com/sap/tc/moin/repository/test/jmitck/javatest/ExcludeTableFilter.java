// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: ExcludeTableFilter.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestFilter, ExcludeTable, TestDescription

@SuppressWarnings( "nls" )
public class ExcludeTableFilter extends TestFilter {

    public ExcludeTableFilter( ExcludeTable excludetable ) {

        table = excludetable;
    }

    public ExcludeTable getExcludeTable( ) {

        return table;
    }

    @Override
    public String getName( ) {

        return i18n.getString( "excludeFilter.name" );
    }

    @Override
    public String getDescription( ) {

        return i18n.getString( "excludeFilter.description" );
    }

    @Override
    public String getReason( ) {

        return i18n.getString( "excludeFilter.reason" );
    }

    @Override
    public boolean accepts( TestDescription testdescription ) {

        return !table.excludesAllOf( testdescription );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( !( obj instanceof ExcludeTableFilter ) ) {
            return false;
        } else {
            ExcludeTableFilter excludetablefilter = (ExcludeTableFilter) obj;
            return table.equals( excludetablefilter.table );
        }
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private ExcludeTable table;

    private static I18NResourceBundle i18n;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.ExcludeTableFilter.class );
    }
}
