// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: ShowTests.java

package com.sap.tc.moin.repository.test.jmitck.test.javatest.finder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder;

@SuppressWarnings( "nls" )
public class ShowTests {

    public class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        Fault( String s ) {

            super( s );
        }
    }

    public class BadArgs extends Exception {

        private static final long serialVersionUID = 1L;

        BadArgs( String s ) {

            super( s );
        }
    }

    public ShowTests( ) {

    }

    public static void main( String args[] ) {

        try {
            if ( args.length == 0 ) {
                usage( System.out );
            } else {
                ShowTests showtests = new ShowTests( );
                showtests.run( args );
            }
        } catch ( BadArgs badargs ) {
            System.err.println( "Bad Arguments: " + badargs.getMessage( ) );
            usage( System.err );
            System.exit( 1 );
        } catch ( Fault fault ) {
            System.err.println( "Error: " + fault.getMessage( ) );
            System.exit( 2 );
        } catch ( IOException ioexception ) {
            System.err.println( "Error: " + ioexception );
            System.exit( 3 );
        }
    }

    private static void usage( PrintStream printstream ) {

        String s = System.getProperty( "program", "java " + ( com.sap.tc.moin.repository.test.jmitck.test.javatest.finder.ShowTests.class ).getName( ) );
        printstream.println( "Usage:" );
        printstream.println( "  " + s + "[options]  test-suite" );
        printstream.println( "Options:" );
        printstream.println( "  -finder finderClass finderArgs... -end" );
        printstream.println( "                          specify the test finder to be used" );
        printstream.println( "  -initial initial-file   specify a starting point (optional)" );
        printstream.println( "  -o output-file          output file (default is standard output)" );
        printstream.println( "  -nodes                  show nodes in the tree" );
        printstream.println( "  -fulltests              show contents of tests" );
    }

    public void run( String as[] ) throws BadArgs, Fault, IOException {

        File file = null;
        String s = null;
        String as1[] = null;
        File file1 = null;
        File file2 = null;
        for ( int i = 0; i < as.length; i++ ) {
            if ( as[i].equalsIgnoreCase( "-finder" ) && i + 1 < as.length ) {
                s = as[++i];
                int j = ++i;
                for ( ; i < as.length - 1 && !as[i].equalsIgnoreCase( "-end" ); i++ ) {
                }
                as1 = new String[i - j];
                System.arraycopy( as, j, as1, 0, as1.length );
            } else if ( as[i].equalsIgnoreCase( "-initial" ) && i + 1 < as.length ) {
                file2 = new File( as[++i] );
            } else if ( as[i].equalsIgnoreCase( "-o" ) && i + 1 < as.length ) {
                file1 = new File( as[++i] );
            } else if ( as[i].equalsIgnoreCase( "-nodes" ) ) {
                nodes = true;
            } else if ( as[i].equalsIgnoreCase( "-fulltests" ) ) {
                fullTests = true;
            } else {
                if ( as[i].startsWith( "-" ) ) {
                    throw new BadArgs( as[i] );
                }
                file = new File( as[i] );
            }
        }

        if ( s == null ) {
            throw new BadArgs( "no test finder specified" );
        }
        if ( file == null ) {
            throw new BadArgs( "testsuite.html file not specified" );
        }
        testFinder = initializeTestFinder( s, as1, file );
        if ( file2 == null ) {
            file2 = testFinder.getRoot( );
        }
        if ( file1 == null ) {
            out = System.out;
        } else {
            out = new PrintStream( new BufferedOutputStream( new FileOutputStream( file1 ) ) );
        }
        list( file2 );
    }

    private TestFinder initializeTestFinder( String s, String as[], File file ) throws Fault {

        TestFinder testfinder;
        try {
            Class<?> class1 = Class.forName( s );
            testfinder = (TestFinder) class1.newInstance( );
            testfinder.init( as, file, null );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new Fault( "Error: Can't find class for TestFinder specified" );
        } catch ( InstantiationException instantiationexception ) {
            throw new Fault( "Error: Can't create new instance of TestFinder" );
        } catch ( IllegalAccessException illegalaccessexception ) {
            throw new Fault( "Error: Illegal Access Exception" );
        } catch ( com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.Fault fault ) {
            throw new Fault( "Error: Can't initialize test-finder: " + fault.getMessage( ) );
        }
        return testfinder;
    }

    private void list( File file ) {

        if ( nodes ) {
            out.println( file );
        }
        testFinder.read( file );
        TestDescription atestdescription[] = testFinder.getTests( );
        File afile[] = testFinder.getFiles( );
        if ( atestdescription != null ) {
            for ( int i = 0; i < atestdescription.length; i++ ) {
                TestDescription testdescription = atestdescription[i];
                out.println( "    " + testdescription.getRootRelativeURL( ) );
                if ( fullTests ) {
                    for ( Iterator<String> iterator = testdescription.getParameterKeys( ); iterator.hasNext( ); out.println( ) ) {
                        String s = iterator.next( );
                        String s1 = testdescription.getParameter( s );
                        out.print( "        " );
                        out.print( s );
                        pad( s, 15 );
                        out.print( s1 );
                    }

                }
            }

        }
        if ( afile != null ) {
            for ( int j = 0; j < afile.length; j++ ) {
                list( afile[j] );
            }

        }
    }

    void pad( String s, int i ) {

        for ( int j = s.length( ); j < i; j++ ) {
            out.write( 32 );
        }

        out.write( 32 );
    }

    private TestFinder testFinder;

    private PrintStream out;

    private boolean nodes;

    private boolean fullTests;
}
