// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: MultiStatus.java

package com.sap.tc.moin.repository.test.jmitck.javatest.lib;

import java.io.PrintWriter;

import com.sap.tc.moin.repository.test.jmitck.javatest.Status;

@SuppressWarnings( "nls" )
public class MultiStatus {

    public MultiStatus( ) {

        iTests = 0;
        iPassed = 0;
        iFail = 0;
        iBad = 0;
        firstTest = "";
        out = null;
    }

    public MultiStatus( PrintWriter printwriter ) {

        iTests = 0;
        iPassed = 0;
        iFail = 0;
        iBad = 0;
        firstTest = "";
        out = null;
        out = printwriter;
    }

    public int getTestCount( ) {

        return iTests;
    }

    public void add( String s, Status status ) {

        if ( out != null ) {
            out.println( s + ": " + status );
        }
        iTests++;
        if ( status != null ) {
            switch ( status.getType( ) ) {
                case 0: // '\0'
                    iPassed++;
                    return;

                case 1: // '\001'
                    if ( iFail == 0 && iBad == 0 ) {
                        firstTest = s;
                    }
                    iFail++;
                    return;
            }
        }
        if ( iBad == 0 ) {
            firstTest = s;
        }
        iBad++;
    }

    public Status getStatus( ) {

        if ( out != null ) {
            out.flush( );
        }
        String s = "tests: " + iTests;
        if ( iPassed > 0 ) {
            s = s + "; passed: " + iPassed;
        }
        if ( iFail > 0 ) {
            s = s + "; failed: " + iFail;
        }
        if ( iBad > 0 ) {
            s = s + "; bad status: " + iBad;
        }
        if ( iBad > 0 ) {
            return Status.failed( s + "; first bad test case found: " + firstTest );
        }
        if ( iFail > 0 ) {
            return Status.failed( s + "; first test case failure: " + firstTest );
        } else {
            return Status.passed( s );
        }
    }

    public static Status overallStatus( String as[], Status astatus[], PrintWriter printwriter ) {

        if ( as.length != astatus.length ) {
            return Status.failed( "mismatched array sizes; tests: " + as.length + " statuses: " + astatus.length );
        }
        MultiStatus multistatus = new MultiStatus( printwriter );
        for ( int i = 0; i < astatus.length; i++ ) {
            multistatus.add( as[i], astatus[i] );
        }

        return multistatus.getStatus( );
    }

    public static Status overallStatus( String as[], Status astatus[] ) {

        return overallStatus( as, astatus, null );
    }

    private int iTests;

    private int iPassed;

    private int iFail;

    private int iBad;

    private String firstTest;

    private PrintWriter out;
}
