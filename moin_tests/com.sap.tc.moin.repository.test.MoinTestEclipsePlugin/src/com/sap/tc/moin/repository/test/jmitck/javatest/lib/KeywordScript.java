// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: KeywordScript.java

package com.sap.tc.moin.repository.test.jmitck.javatest.lib;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.Script;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestResult;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.StringArray;

@SuppressWarnings( "nls" )
public class KeywordScript extends Script {

    public KeywordScript( ) {

    }

    @Override
    public void run( ) {

        PrintWriter printwriter = getTestResult( ).getTestCommentWriter( );
        TestDescription testdescription = getTestDescription( );
        for ( int i = 0; i < super.scriptArgs.length; i++ ) {
            if ( super.scriptArgs[i].equals( "-debug" ) ) {
                debug = true;
            } else {
                setStatus( Status.error( "bad args for script: " + super.scriptArgs[i] ) );
                return;
            }
        }

        String s = "script.";
        Set<String> set = testdescription.getKeywordTable( );
        Vector<String> vector = new Vector<String>( );
        Vector<String> vector1 = new Vector<String>( );
        int j = 0;
        Iterator<String> iterator = super.env.keys( ).iterator( );
        label0: while ( iterator.hasNext( ) ) {
            String s1 = iterator.next( );
            if ( !s1.startsWith( s ) ) {
                continue;
            }
            if ( debug ) {
                printwriter.println( "CHECKING " + s1 );
            }
            String s3 = s1.substring( s.length( ) ).replace( '_', ' ' ).toLowerCase( Locale.ENGLISH );
            String as[] = StringArray.split( s3 );
            vector.addElement( s3 );
            if ( debug ) {
                printwriter.println( "keys: " + StringArray.join( as ) );
            }
            if ( as == null || as.length < j ) {
                continue;
            }
            for ( int k = 0; k < as.length; k++ ) {
                if ( set.contains( as[k] ) ) {
                    continue;
                }
                if ( debug ) {
                    printwriter.println( "discarding, because of " + as[k] );
                }
                continue label0;
            }

            if ( as.length > j ) {
                if ( debug ) {
                    printwriter.println( "new best match, " + as.length + " keys" );
                }
                vector1 = new Vector<String>( );
                j = as.length;
            }
            vector1.addElement( s1 );
        }
        String s2 = super.env.getName( );
        String s4 = s2.length( ) != 0 ? "Environment `" + super.env.getName( ) + "'" : "The anonymous environment";
        if ( vector1.size( ) == 0 ) {
            if ( vector.size( ) == 0 ) {
                String s5 = s4 + " has no `script' entries";
                printwriter.println( s5 );
                setStatus( Status.error( s5 ) );
                return;
            }
            String s6 = s4 + " has no suitable `script' entry";
            printwriter.println( s6 );
            printwriter.println( "The keyword combinations for scripts in this environment are: " );
            for ( int l = 0; l < vector.size( ); l++ ) {
                printwriter.println( vector.elementAt( l ) );
            }

            setStatus( Status.error( s6 ) );
            return;
        }
        if ( vector1.size( ) > 1 ) {
            String s7 = s4 + " has ambiguous `script' entries";
            printwriter.println( s7 );
            for ( int i1 = 0; i1 < vector1.size( ); i1++ ) {
                printwriter.println( i1 + ": " + vector1.elementAt( i1 ) );
            }

            setStatus( Status.error( s7 ) );
            return;
        }
        String s8 = vector1.elementAt( 0 );
        try {
            String as1[] = super.env.lookup( s8 );
            if ( as1.length == 0 ) {
                String s9 = "INTERNAL ERROR: failed to lookup key: " + s8;
                printwriter.println( s9 );
                setStatus( Status.error( s9 ) );
                return;
            }
            printwriter.println( "test: " + testdescription.getRootRelativeURL( ) );
            printwriter.println( "script: " + getClass( ).getName( ) + " " + StringArray.join( super.scriptArgs ) );
            String as2[] = { "Based on these keywords:    " + s8.substring( s.length( ) ).replace( '_', ' ' ).toLowerCase( Locale.ENGLISH ), "this script has now been selected:    " + StringArray.join( as1 ) };
            printStrArr( printwriter, as2 );
            try {
                Class<?> class1 = Class.forName( as1[0] );
                Script script = (Script) class1.newInstance( );
                String as3[] = new String[as1.length - 1];
                System.arraycopy( as1, 1, as3, 0, as3.length );
                initDelegate( script, as3 );
                script.run( );
            } catch ( ClassNotFoundException classnotfoundexception ) {
                setStatus( Status.error( "Can't find class `" + as1[0] + "' for `" + super.env.getName( ) + "'" ) );
            } catch ( IllegalAccessException illegalaccessexception ) {
                setStatus( Status.error( "Illegal access to class `" + as1[0] + "' for `" + super.env.getName( ) + "'" ) );
            } catch ( InstantiationException instantiationexception ) {
                setStatus( Status.error( "Can't instantiate class`" + as1[0] + "' for `" + super.env.getName( ) + "'" ) );
            }
        } catch ( com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment.Fault fault ) {
            setStatus( Status.error( "environment `" + super.env.getName( ) + "' has bad `script' entry for `" + s8 + "'" ) );
        }
    }

    @Override
    public Status run( String as[], TestDescription testdescription, TestEnvironment testenvironment ) {

        throw new Error( "Method not applicable." );
    }

    private static void printStrArr( PrintWriter printwriter, String as[] ) {

        if ( as == null ) {
            return;
        }
        for ( int i = 0; i < as.length; i++ ) {
            printwriter.println( as[i] );
        }

    }

    private void setStatus( Status status ) {

        TestResult testresult = getTestResult( );
        testresult.setEnvironment( super.env );
        testresult.setStatus( status );
        try {
            testresult.writeResults( super.workDir, super.backupPolicy );
        } catch ( IOException ioexception ) {
            ioexception.printStackTrace( );
        }
    }

    private static boolean debug = false;

}
