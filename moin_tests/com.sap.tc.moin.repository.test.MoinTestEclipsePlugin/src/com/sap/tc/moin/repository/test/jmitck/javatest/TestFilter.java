// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestFilter.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestDescription

public abstract class TestFilter {

    public static interface Observer {

        public abstract void rejected( TestDescription testdescription, TestFilter testfilter );
    }

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        public Fault( I18NResourceBundle i18nresourcebundle, String s ) {

            super( i18nresourcebundle.getString( s ) );
        }

        public Fault( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

            super( i18nresourcebundle.getString( s, obj ) );
        }

        public Fault( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

            super( i18nresourcebundle.getString( s, aobj ) );
        }
    }

    public TestFilter( ) {

    }

    public abstract String getName( );

    public abstract String getDescription( );

    public abstract String getReason( );

    public abstract boolean accepts( TestDescription testdescription ) throws Fault;

    public boolean accepts( TestDescription testdescription, Observer observer ) throws Fault {

        if ( accepts( testdescription ) ) {
            return true;
        } else {
            observer.rejected( testdescription, this );
            return false;
        }
    }
}
