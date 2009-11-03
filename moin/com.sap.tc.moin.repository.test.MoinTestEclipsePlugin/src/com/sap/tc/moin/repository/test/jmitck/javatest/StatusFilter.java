// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: StatusFilter.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestFilter, TestResultTable, TestDescription, TestResult,
// Status

@SuppressWarnings( "nls" )
public class StatusFilter extends TestFilter {

    public StatusFilter( boolean aflag[], TestResultTable testresulttable ) {

        if ( aflag == null || testresulttable == null ) {
            throw new NullPointerException( );
        }
        if ( aflag.length != 4 ) {
            throw new IllegalArgumentException( );
        } else {
            statusTests = aflag;
            trt = testresulttable;
            return;
        }
    }

    public boolean[] getStatusTests( ) {

        return statusTests;
    }

    public TestResultTable getTestResultTable( ) {

        return trt;
    }

    @Override
    public String getName( ) {

        return i18n.getString( "statusFilter.name" );
    }

    @Override
    public String getDescription( ) {

        return i18n.getString( "statusFilter.description" );
    }

    @Override
    public String getReason( ) {

        return i18n.getString( "statusFilter.reason" );
    }

    @Override
    public boolean accepts( TestDescription testdescription ) throws TestFilter.Fault {

        TestResult testresult = trt.lookup( testdescription );
        if ( testresult == null ) {
            throw new TestFilter.Fault( i18n, "statusFilter.cantFindTest", testdescription.getRootRelativeURL( ) );
        }
        Status status = testresult.getStatus( );
        if ( status == null ) {
            throw new TestFilter.Fault( i18n, "statusFilter.noStatus", testdescription.getRootRelativeURL( ) );
        } else {
            return statusTests[status.getType( )];
        }
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( !( obj instanceof TestFilter ) ) {
            return false;
        }
        StatusFilter statusfilter = (StatusFilter) obj;
        for ( int i = 0; i < 4; i++ ) {
            if ( statusTests[i] != statusfilter.statusTests[i] ) {
                return false;
            }
        }

        return trt == statusfilter.trt;
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private boolean statusTests[];

    private TestResultTable trt;

    private static I18NResourceBundle i18n;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.ExcludeTableFilter.class );
    }
}
