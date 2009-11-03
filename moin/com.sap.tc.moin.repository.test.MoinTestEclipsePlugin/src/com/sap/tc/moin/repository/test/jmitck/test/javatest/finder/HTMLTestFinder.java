// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: HTMLTestFinder.java

package com.sap.tc.moin.repository.test.jmitck.test.javatest.finder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Hashtable;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

@SuppressWarnings( "nls" )
public class HTMLTestFinder extends TestFinder {

    public HTMLTestFinder( ) {

        namesInFile = new Hashtable<String, Integer>( );
        mode = 2;
        ignoreErrors = false;
        excludeTable = new Hashtable<String, String>( excludeNames.length );
        for ( int i = 0; i < excludeNames.length; i++ ) {
            excludeTable.put( excludeNames[i], excludeNames[i] );
        }

        extensionTable = new Hashtable<String, String>( extensions.length );
        for ( int j = 0; j < extensions.length; j++ ) {
            extensionTable.put( extensions[j], extensions[j] );
        }

    }

    @Override
    protected int decodeArg( String as[], int i ) throws com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.Fault {

        if ( as[i].equalsIgnoreCase( "-webWalk" ) ) {
            mode = 1;
            return 1;
        }
        if ( as[i].equalsIgnoreCase( "-dirWalk" ) ) {
            mode = 2;
            return 1;
        }
        if ( as[i].equalsIgnoreCase( "-IGNORE-ERRORS" ) ) {
            ignoreErrors = true;
            return 1;
        } else {
            return super.decodeArg( as, i );
        }
    }

    @Override
    public File getRoot( ) {

        File file = super.getRoot( );
        if ( mode == 2 && file.isFile( ) ) {
            validatedRoot = new File( file.getParent( ) );
        } else {
            if ( mode == 1 && file.isDirectory( ) ) {
                throw new IllegalStateException( i18n.getString( "html.badRootForWebWalk", file.getPath( ) ) );
            }
            validatedRoot = new File( file.getPath( ) );
        }
        return validatedRoot;
    }

    @Override
    protected void localizedError( String s ) {

        if ( !ignoreErrors ) {
            super.localizedError( s );
        }
    }

    public void setMode( int i ) {

        switch ( i ) {
            case 1: // '\001'
            case 2: // '\002'
                mode = i;
                break;

            default:
                throw new IllegalArgumentException( );
        }
    }

    public int getMode( ) {

        return mode;
    }

    @Override
    protected void scan( File file ) {

        if ( file.isDirectory( ) ) {
            scanDirectory( file );
        } else {
            scanFile( file );
        }
    }

    private void scanDirectory( File file ) {

        if ( mode == 1 ) {
            return;
        }
        String as[] = file.list( );
        for ( int i = 0; i < as.length; i++ ) {
            String s = as[i];
            if ( !excludeTable.containsKey( s ) ) {
                File file1 = new File( file, s );
                if ( file1.isDirectory( ) ) {
                    foundFile( file1 );
                } else {
                    int j = s.indexOf( '.' );
                    if ( j != -1 ) {
                        String s1 = s.substring( j );
                        if ( extensionTable.containsKey( s1 ) ) {
                            foundFile( file1 );
                        }
                    }
                }
            }
        }

    }

    @Override
    protected void scanResource( InputStream is ) {

        input = null;
        lastName = null;
        namesInFile.clear( );
        try {
            input = new BufferedReader( new InputStreamReader( is ) );
            //currFile = file;
            line = 1;
            nextCh( );
            while ( c >= 0 ) {
                switch ( c ) {
                    case 60: // '<'
                        nextCh( );
                        skipSpace( );
                        switch ( c ) {
                            case 33: // '!'
                                nextCh( );
                                if ( c == 45 ) {
                                    nextCh( );
                                    if ( c == 45 ) {
                                        nextCh( );
                                        skipComment( );
                                    }
                                }
                                break;

                            case 47: // '/'
                                nextCh( );
                                String s = scanIdentifier( );
                                if ( s.equals( "dl" ) ) {
                                    endDefList( );
                                } else if ( s.equals( "td" ) || s.equals( "th" ) ) {
                                    endTableData( );
                                } else if ( s.equals( "tr" ) || s.equals( "table" ) ) {
                                    endTableRow( );
                                }
                                skipTag( );
                                if ( inTestDescription( ) && s.equals( endTestDescriptionTag ) ) {
                                    foundTestDescription( params, line );
                                    params = null;
                                }
                                break;

                            default:
                                String s1 = scanIdentifier( );
                                if ( s1.equals( "a" ) ) {
                                    scanLink( );
                                } else if ( s1.equals( "table" ) ) {
                                    scanTable( );
                                } else if ( s1.equals( "tr" ) ) {
                                    scanTableRow( );
                                } else if ( s1.equals( "td" ) || s1.equals( "th" ) ) {
                                    scanTableData( );
                                } else if ( s1.equals( "dl" ) ) {
                                    scanDefList( );
                                } else if ( s1.equals( "dt" ) ) {
                                    scanDefTerm( );
                                } else if ( s1.equals( "dd" ) ) {
                                    scanDefData( );
                                } else {
                                    skipTag( );
                                }
                                break;
                        }
                        break;

                    case 9: // '\t'
                    case 10: // '\n'
                    case 12: // '\f'
                    case 13: // '\r'
                    case 32: // ' '
                        if ( text != null && text.length( ) > 0 && text.charAt( text.length( ) - 1 ) != ' ' ) {
                            text.append( ' ' );
                        }
                        nextCh( );
                        break;

                    case 38: // '&'
                        String s3 = null;
                        nextCh( );
                        String s2;
                        if ( c == 35 ) {
                            int i = 0;
                            nextCh( );
                            s2 = "#";
                            while ( 48 <= c && c <= 57 ) {
                                s2 = s2 + (char) c;
                                i = i * 10 + ( c - 48 );
                                nextCh( );
                            }
                            s3 = "" + (char) i;
                        } else {
                            s2 = scanIdentifier( );
                            if ( s2.equals( "lt" ) ) {
                                s3 = "<";
                            } else if ( s2.equals( "gt" ) ) {
                                s3 = ">";
                            } else if ( s2.equals( "amp" ) ) {
                                s3 = "&";
                            } else if ( s2.equals( "copy" ) ) {
                                s3 = "\251";
                            }
                            if ( s3 == null ) {
                                s3 = "&" + s2 + (char) c;
                            }
                        }
                        if ( c != 59 ) {
                            if ( !Character.isWhitespace( (char) c ) ) {
                                s2 = s2 + (char) c;
                            }
                            error( i18n, "html.badEscape", new Object[] { s2 } );
                        }
                        if ( text != null ) {
                            text.append( s3 );
                        }
                        nextCh( );
                        break;

                    default:
                        if ( text != null ) {
                            text.append( (char) c );
                        }
                        nextCh( );
                        break;
                }
            }
        } catch ( FileNotFoundException filenotfoundexception ) {
            error( i18n, "html.cantFindFile" );
        } catch ( IOException ioexception ) {
            error( i18n, "html.ioError", new Object[] { new Integer( line ), ioexception } );
        } finally {
            if ( input != null ) {
                try {
                    input.close( );
                } catch ( IOException ioexception1 ) {
                }
                input = null;
            }
        }
    }

    private void scanFile( File file ) {

        input = null;
        lastName = null;
        namesInFile.clear( );
        try {
            input = new BufferedReader( new FileReader( file ) );
            currFile = file;
            line = 1;
            nextCh( );
            while ( c >= 0 ) {
                switch ( c ) {
                    case 60: // '<'
                        nextCh( );
                        skipSpace( );
                        switch ( c ) {
                            case 33: // '!'
                                nextCh( );
                                if ( c == 45 ) {
                                    nextCh( );
                                    if ( c == 45 ) {
                                        nextCh( );
                                        skipComment( );
                                    }
                                }
                                break;

                            case 47: // '/'
                                nextCh( );
                                String s = scanIdentifier( );
                                if ( s.equals( "dl" ) ) {
                                    endDefList( );
                                } else if ( s.equals( "td" ) || s.equals( "th" ) ) {
                                    endTableData( );
                                } else if ( s.equals( "tr" ) || s.equals( "table" ) ) {
                                    endTableRow( );
                                }
                                skipTag( );
                                if ( inTestDescription( ) && s.equals( endTestDescriptionTag ) ) {
                                    foundTestDescription( params, file, line );
                                    params = null;
                                }
                                break;

                            default:
                                String s1 = scanIdentifier( );
                                if ( s1.equals( "a" ) ) {
                                    scanLink( file );
                                } else if ( s1.equals( "table" ) ) {
                                    scanTable( );
                                } else if ( s1.equals( "tr" ) ) {
                                    scanTableRow( );
                                } else if ( s1.equals( "td" ) || s1.equals( "th" ) ) {
                                    scanTableData( );
                                } else if ( s1.equals( "dl" ) ) {
                                    scanDefList( );
                                } else if ( s1.equals( "dt" ) ) {
                                    scanDefTerm( );
                                } else if ( s1.equals( "dd" ) ) {
                                    scanDefData( );
                                } else {
                                    skipTag( );
                                }
                                break;
                        }
                        break;

                    case 9: // '\t'
                    case 10: // '\n'
                    case 12: // '\f'
                    case 13: // '\r'
                    case 32: // ' '
                        if ( text != null && text.length( ) > 0 && text.charAt( text.length( ) - 1 ) != ' ' ) {
                            text.append( ' ' );
                        }
                        nextCh( );
                        break;

                    case 38: // '&'
                        String s3 = null;
                        nextCh( );
                        String s2;
                        if ( c == 35 ) {
                            int i = 0;
                            nextCh( );
                            s2 = "#";
                            while ( 48 <= c && c <= 57 ) {
                                s2 = s2 + (char) c;
                                i = i * 10 + ( c - 48 );
                                nextCh( );
                            }
                            s3 = "" + (char) i;
                        } else {
                            s2 = scanIdentifier( );
                            if ( s2.equals( "lt" ) ) {
                                s3 = "<";
                            } else if ( s2.equals( "gt" ) ) {
                                s3 = ">";
                            } else if ( s2.equals( "amp" ) ) {
                                s3 = "&";
                            } else if ( s2.equals( "copy" ) ) {
                                s3 = "\251";
                            }
                            if ( s3 == null ) {
                                s3 = "&" + s2 + (char) c;
                            }
                        }
                        if ( c != 59 ) {
                            if ( !Character.isWhitespace( (char) c ) ) {
                                s2 = s2 + (char) c;
                            }
                            error( i18n, "html.badEscape", new Object[] { s2, file } );
                        }
                        if ( text != null ) {
                            text.append( s3 );
                        }
                        nextCh( );
                        break;

                    default:
                        if ( text != null ) {
                            text.append( (char) c );
                        }
                        nextCh( );
                        break;
                }
            }
        } catch ( FileNotFoundException filenotfoundexception ) {
            error( i18n, "html.cantFindFile", file );
        } catch ( IOException ioexception ) {
            error( i18n, "html.ioError", new Object[] { file, new Integer( line ), ioexception } );
        } finally {
            if ( input != null ) {
                try {
                    input.close( );
                } catch ( IOException ioexception1 ) {
                }
                input = null;
            }
        }
    }

    protected File getCurrentFile( ) {

        return currFile;
    }

    private void nextCh( ) throws IOException {

        c = input.read( );
        if ( c == 10 ) {
            line++;
        }
    }

    private boolean inTestDescription( ) {

        return params != null;
    }

    private void scanTable( ) throws IOException {

        if ( TestFinder.debug ) {
            System.err.println( "scanning table starting in line " + line );
        }
        String s = lastName;
        skipSpace( );
        while ( c != 62 ) {
            String s1 = scanIdentifier( );
            String s2 = scanValue( );
            skipSpace( );
            if ( s1.equals( "class" ) && "TestDescription".equals( s2 ) ) {
                params = new Hashtable<String, String>( );
                endTestDescriptionTag = "table";
            } else if ( s1.equals( "id" ) ) {
                s = s2;
            }
        }
        nextCh( );
        if ( params != null && s != null ) {
            processEntry( params, "id", s );
        }
    }

    private void scanTableRow( ) throws IOException {

        skipTag( );
        if ( params != null ) {
            endTableRow( );
            tableRow = new Vector<String>( );
        }
    }

    private void endTableRow( ) throws IOException {

        if ( params != null && tableRow != null ) {
            endTableData( );
            if ( tableRow.size( ) == 2 ) {
                processEntry( params, tableRow.elementAt( 0 ), tableRow.elementAt( 1 ) );
            }
            tableRow = null;
        }
    }

    private void scanTableData( ) throws IOException {

        skipTag( );
        if ( params != null && tableRow != null ) {
            endTableData( );
            text = new StringBuffer( );
        }
    }

    private void endTableData( ) throws IOException {

        if ( params != null && tableRow != null && text != null ) {
            for ( ; text.length( ) > 0 && text.charAt( text.length( ) - 1 ) == ' '; text.setLength( text.length( ) - 1 ) ) {
            }
            tableRow.addElement( new String( text ) );
            text = null;
        }
    }

    private void scanDefList( ) throws IOException {

        String s = lastName;
        skipSpace( );
        while ( c != 62 ) {
            String s1 = scanIdentifier( );
            String s2 = scanValue( );
            skipSpace( );
            if ( s1.equals( "class" ) && "TestDescription".equals( s2 ) ) {
                params = new Hashtable<String, String>( );
                endTestDescriptionTag = "dl";
            } else if ( s1.equals( "id" ) ) {
                s = s2;
            }
        }
        nextCh( );
        if ( params != null && s != null ) {
            processEntry( params, "id", s );
        }
    }

    private void scanDefTerm( ) throws IOException {

        skipTag( );
        if ( params != null ) {
            if ( defTerm != null && text != null ) {
                for ( ; text.length( ) > 0 && text.charAt( text.length( ) - 1 ) == ' '; text.setLength( text.length( ) - 1 ) ) {
                }
                String s = new String( text );
                processEntry( params, defTerm, s );
            }
            defTerm = null;
            text = new StringBuffer( );
        }
    }

    private void scanDefData( ) throws IOException {

        skipTag( );
        if ( params != null && text != null ) {
            for ( ; text.length( ) > 0 && text.charAt( text.length( ) - 1 ) == ' '; text.setLength( text.length( ) - 1 ) ) {
            }
            defTerm = new String( text );
            text = new StringBuffer( );
        }
    }

    private void endDefList( ) throws IOException {

        if ( params != null ) {
            if ( defTerm != null && text != null ) {
                for ( ; text.length( ) > 0 && text.charAt( text.length( ) - 1 ) == ' '; text.setLength( text.length( ) - 1 ) ) {
                }
                String s = new String( text );
                processEntry( params, defTerm, s );
            }
            defTerm = null;
            text = null;
        }
    }

    private String scanIdentifier( ) throws IOException {

        StringBuffer stringbuffer = new StringBuffer( );
        do {
            while ( c >= 97 && c <= 122 ) {
                stringbuffer.append( (char) c );
                nextCh( );
            }
            if ( c >= 65 && c <= 90 ) {
                stringbuffer.append( (char) ( 97 + ( c - 65 ) ) );
                nextCh( );
                continue;
            }
            if ( c >= 48 && c <= 57 ) {
                stringbuffer.append( (char) c );
                nextCh( );
                continue;
            }
            if ( c != 45 ) {
                break;
            }
            stringbuffer.append( (char) c );
            nextCh( );
        } while ( true );
        if ( stringbuffer.length( ) == 0 ) {
            throw new IOException( "Identifier expected" );
        } else {
            return stringbuffer.toString( );
        }
    }

    private void scanLink( File file ) throws IOException {

        skipSpace( );
        while ( c != 62 ) {
            String s = scanIdentifier( );
            String s1 = scanValue( );
            skipSpace( );
            if ( mode == 1 && s.equals( "href" ) && s1.indexOf( ':' ) == -1 && !s1.startsWith( "/" ) && !s1.startsWith( "../" ) ) {
                int i = s1.lastIndexOf( '#' );
                if ( i != -1 ) {
                    s1 = s1.substring( 0, i );
                }
                s1 = s1.trim( );
                File file1 = new File( file.getParent( ), s1.replace( '/', File.separatorChar ) );
                String s2 = file1.getPath( );
                if ( s2.endsWith( ".html" ) || s2.endsWith( ".htm" ) ) {
                    foundFile( file1 );
                }
            }
            if ( s.equals( "name" ) ) {
                lastName = s1;
                Integer integer = new Integer( line );
                Integer integer1 = namesInFile.put( s1, integer );
                if ( integer1 != null ) {
                    error( i18n, "html.multipleName", new Object[] { s1, file, integer, integer1 } );
                }
            }
        }
        nextCh( );
    }

    private void scanLink( ) throws IOException {

        skipSpace( );
        while ( c != 62 ) {
            String s = scanIdentifier( );
            String s1 = scanValue( );
            skipSpace( );
            //        if(mode == 1 && s.equals("href") && s1.indexOf(':') == -1 && !s1.startsWith("/") && !s1.startsWith("../"))
            //        {
            //            int i = s1.lastIndexOf('#');
            //            if(i != -1)
            //                s1 = s1.substring(0, i);
            //            s1 = s1.trim();
            //            File file1 = new File(file.getParent(), s1.replace('/', File.separatorChar));
            //            String s2 = file1.getPath();
            //            if(s2.endsWith(".html") || s2.endsWith(".htm"))
            //                foundFile(file1);
            //        }
            if ( s.equals( "name" ) ) {
                lastName = s1;
                Integer integer = new Integer( line );
                Integer integer1 = namesInFile.put( s1, integer );
                if ( integer1 != null ) {
                    error( i18n, "html.multipleName", new Object[] { s1, integer, integer1 } );
                }
            }
        }
        nextCh( );
    }

    private String scanValue( ) throws IOException {

        skipSpace( );
        if ( c != 61 ) {
            return "";
        }
        int i = -1;
        nextCh( );
        skipSpace( );
        if ( c == 39 || c == 34 ) {
            i = c;
            nextCh( );
            skipSpace( );
        }
        StringBuffer stringbuffer = new StringBuffer( );
        while ( i < 0 && c != 32 && c != 9 && c != 10 && c != 13 && c != 62 || i >= 0 && c != i ) {
            if ( c == -1 || c == 10 || c == 13 ) {
                error( i18n, "html.quoteMismatch", new Object[] { currFile, new Integer( line ) } );
                break;
            }
            stringbuffer.append( (char) c );
            nextCh( );
        }
        if ( c == i ) {
            nextCh( );
        }
        skipSpace( );
        return stringbuffer.toString( );
    }

    private void skipComment( ) throws IOException {

        for ( int i = 0; c != -1 && ( i < 2 || c != 62 ); ) {
            if ( c == 45 ) {
                i++;
            } else {
                i = 0;
            }
            nextCh( );
        }

        nextCh( );
    }

    private void skipSpace( ) throws IOException {

        while ( c == 32 || c == 9 || c == 10 || c == 13 ) {
            nextCh( );
        }
    }

    private void skipTag( ) throws IOException {

        skipSpace( );
        while ( c != 62 ) {
            String s = scanIdentifier( );
            if ( s == "" ) {
                throw new IOException( "error parsing HTML input" );
            }
            skipSpace( );
        }
        nextCh( );
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private Hashtable<String, Integer> namesInFile;

    private Hashtable<String, String> excludeTable;

    private static final String excludeNames[] = { "SCCS", "deleted_files" };

    private Hashtable<String, String> extensionTable;

    private static final String extensions[] = { ".html", ".htm" };

    public static final int WEB_WALK = 1;

    public static final int DIR_WALK = 2;

    private int mode;

    private boolean ignoreErrors;

    private File validatedRoot;

    private File currFile;

    private Reader input;

    private int c;

    private int line;

    private StringBuffer text;

    private String endTestDescriptionTag;

    private Hashtable<String, String> params;

    private String defTerm;

    private Vector<String> tableRow;

    private String lastName;

    private static I18NResourceBundle i18n;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.test.javatest.finder.HTMLTestFinder.class );
    }
}
