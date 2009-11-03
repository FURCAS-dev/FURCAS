// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: ExcludeTable.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.DynamicArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestDescription

@SuppressWarnings( "nls" )
public class ExcludeTable {

    public static final class Entry implements Comparable<Object> {

        public int compareTo( Object obj ) {

            Entry entry = (Entry) obj;
            int i = relativeURL.compareTo( entry.relativeURL );
            if ( i == 0 ) {
                if ( testCase == null && entry.testCase == null ) {
                    return 0;
                }
                if ( testCase == null ) {
                    return -1;
                }
                if ( entry.testCase == null ) {
                    return 1;
                } else {
                    return testCase.compareTo( entry.testCase );
                }
            } else {
                return i;
            }
        }

        public String getRelativeURL( ) {

            return relativeURL;
        }

        public String getTestCases( ) {

            return testCase;
        }

        public String[] getTestCaseList( ) {

            if ( testCase == null ) {
                return null;
            }
            Vector<String> vector = new Vector<String>( );
            int i = -1;
            for ( int j = 0; j < testCase.length( ); j++ ) {
                if ( testCase.charAt( j ) == ',' ) {
                    if ( i != -1 ) {
                        vector.addElement( testCase.substring( i, j ) );
                    }
                    i = -1;
                } else if ( i == -1 ) {
                    i = j;
                }
            }

            if ( i != -1 ) {
                vector.addElement( testCase.substring( i ) );
            }
            if ( vector.size( ) == 0 ) {
                return null;
            } else {
                String as[] = new String[vector.size( )];
                vector.copyInto( as );
                return as;
            }
        }

        public int[] getBugIds( ) {

            return bugIds;
        }

        public String[] getPlatforms( ) {

            return platforms;
        }

        public String getSynopsis( ) {

            return synopsis;
        }

        public static Entry read( String s ) throws Fault {

            try {
                return ( new Parser( new StringReader( s ) ) ).readEntry( );
            } catch ( IOException ioexception ) {
                throw new Fault( ExcludeTable.i18n, "excl.badEntry", ioexception );
            }
        }

        @Override
        public boolean equals( Object obj ) {

            if ( obj instanceof Entry ) {
                Entry entry = (Entry) obj;
                return equals( relativeURL, entry.relativeURL ) && equals( testCase, entry.testCase ) && equals( bugIds, entry.bugIds ) && equals( platforms, entry.platforms ) && equals( synopsis, entry.synopsis );
            } else {
                return false;
            }
        }

        @Override
        public int hashCode( ) {

            return relativeURL.hashCode( );
        }

        @Override
        public String toString( ) {

            StringBuffer stringbuffer = new StringBuffer( 64 );
            stringbuffer.append( relativeURL );
            if ( testCase != null ) {
                stringbuffer.append( '[' );
                stringbuffer.append( testCase );
                stringbuffer.append( ']' );
            }
            if ( bugIds != null ) {
                for ( int i = 0; i < bugIds.length; i++ ) {
                    stringbuffer.append( i != 0 ? ',' : ' ' );
                    stringbuffer.append( bugIds[i] );
                }

            }
            if ( platforms != null ) {
                for ( int j = 0; j < platforms.length; j++ ) {
                    stringbuffer.append( j != 0 ? ',' : ' ' );
                    stringbuffer.append( platforms[j] );
                }

            }
            if ( synopsis != null ) {
                stringbuffer.append( ' ' );
                stringbuffer.append( synopsis );
            }
            return new String( stringbuffer );
        }

        long computeChecksum( ) {

            long l = computeChecksum( relativeURL );
            if ( testCase != null ) {
                l = l * 37L + computeChecksum( testCase );
            }
            for ( int i = 0; i < bugIds.length; i++ ) {
                l = l * 37L + bugIds[i];
            }

            for ( int j = 0; j < platforms.length; j++ ) {
                l = l * 37L + computeChecksum( platforms[j] );
            }

            l = l * 37L + computeChecksum( synopsis );
            return l;
        }

        private long computeChecksum( String s ) {

            long l = 0L;
            for ( int i = 0; i < s.length( ); i++ ) {
                l = l * 37L + s.charAt( i );
            }

            return l;
        }

        private static boolean equals( int ai[], int ai1[] ) {

            if ( ai == null || ai1 == null ) {
                return ai == null && ai1 == null;
            }
            if ( ai.length != ai1.length ) {
                return false;
            }
            for ( int i = 0; i < ai.length; i++ ) {
                if ( ai[i] != ai1[i] ) {
                    return false;
                }
            }

            return true;
        }

        private static boolean equals( String as[], String as1[] ) {

            if ( as == null || as1 == null ) {
                return as == null && as1 == null;
            }
            if ( as.length != as1.length ) {
                return false;
            }
            for ( int i = 0; i < as.length; i++ ) {
                if ( !equals( as[i], as1[i] ) ) {
                    return false;
                }
            }

            return true;
        }

        private static boolean equals( String s, String s1 ) {

            return s == null && s1 == null || s != null && s1 != null && s.equals( s1 );
        }

        private String relativeURL;

        private String testCase;

        private int bugIds[];

        private String platforms[];

        private String synopsis;

        public Entry( String s, String s1, int ai[], String as[], String s2 ) {

            if ( ai == null || as == null ) {
                throw new NullPointerException( );
            }
            if ( ai.length == 0 && as.length > 0 ) {
                throw new IllegalArgumentException( );
            } else {
                relativeURL = s;
                testCase = s1;
                bugIds = ai;
                platforms = as;
                synopsis = s2;
                return;
            }
        }
    }

    private static class Key {

        @Override
        public int hashCode( ) {

            int i = hash;
            if ( i == 0 ) {
                int j = relativeURL.length( );
                for ( int k = 0; k < j; k++ ) {
                    char c = Character.toLowerCase( relativeURL.charAt( k ) );
                    if ( c == sep ) {
                        c = '/';
                    }
                    i = 31 * i + c;
                }

                hash = i;
            }
            return i;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( obj == null || !( obj instanceof Key ) ) {
                return false;
            }
            String s = relativeURL;
            String s1 = ( (Key) obj ).relativeURL;
            int i = s.length( );
            if ( i != s1.length( ) ) {
                return false;
            }
            for ( int j = 0; j < i; j++ ) {
                char c = Character.toLowerCase( s.charAt( j ) );
                if ( c == sep ) {
                    c = '/';
                }
                char c1 = Character.toLowerCase( s1.charAt( j ) );
                if ( c1 == sep ) {
                    c1 = '/';
                }
                if ( c != c1 ) {
                    return false;
                }
            }

            return true;
        }

        private static final char sep;

        private String relativeURL;

        private int hash;

        static {
            sep = File.separatorChar;
        }

        Key( String s ) {

            relativeURL = s;
        }
    }

    private static final class Parser {

        long getChecksum( ) {

            return checksum;
        }

        String getTitle( ) {

            return title;
        }

        Entry readEntry( ) throws IOException, Fault {

            String s = readURL( );
            if ( s == null ) {
                return null;
            }
            String s1 = null;
            if ( s.endsWith( "]" ) ) {
                int i = s.lastIndexOf( "[" );
                if ( i != -1 ) {
                    s1 = s.substring( i + 1, s.length( ) - 1 );
                    s = s.substring( 0, i );
                }
            }
            int ai[] = readBugIds( );
            String as[] = readPlatforms( );
            String s2 = readRest( );
            return new Entry( s, s1, ai, as, s2 );
        }

        private boolean isEndOfLine( int i ) {

            return i == -1 || i == 10 || i == 13;
        }

        private boolean isWhitespace( int i ) {

            return i == 32 || i == 9;
        }

        private String readURL( ) throws IOException, Fault {

            do {
                skipWhite( );
                switch ( ch ) {
                    case -1:
                        return null;

                    case 35: // '#'
                        skipComment( );
                        break;

                    case 10: // '\n'
                    case 13: // '\r'
                        ch = in.read( );
                        break;

                    default:
                        return readWord( );
                }
            } while ( true );
        }

        private int[] readBugIds( ) throws IOException {

            skipWhite( );
            TreeSet<Integer> treeset = new TreeSet<Integer>( );
            int i = 0;
            for ( ; !isEndOfLine( ch ) && !isWhitespace( ch ); ch = in.read( ) ) {
                if ( Character.isDigit( (char) ch ) ) {
                    i = i * 10 + Character.digit( (char) ch, 10 );
                } else if ( ch == 44 ) {
                    treeset.add( new Integer( i ) );
                    i = 0;
                }
            }

            treeset.add( new Integer( i ) );
            if ( treeset.size( ) == 0 ) {
                treeset.add( new Integer( 0 ) );
            }
            int ai[] = new int[treeset.size( )];
            int j = 0;
            for ( Iterator<Integer> iterator = treeset.iterator( ); iterator.hasNext( ); ) {
                ai[j++] = iterator.next( ).intValue( );
            }

            return ai;
        }

        private String[] readPlatforms( ) throws IOException {

            skipWhite( );
            String s = readWord( );
            String as[] = platformCache.get( s );
            if ( as == null ) {
                int i = 0;
                for ( int j = 0; j < s.length( ); j++ ) {
                    if ( s.charAt( j ) == ',' ) {
                        i++;
                    }
                }

                TreeSet<String> treeset = new TreeSet<String>( );
                int k = 0;
                for ( int l = s.indexOf( ',' ); l != -1; l = s.indexOf( ',', k ) ) {
                    treeset.add( s.substring( k, l ) );
                    k = l + 1;
                }

                treeset.add( s.substring( k ) );
                as = treeset.toArray( new String[treeset.size( )] );
                platformCache.put( s, as );
            }
            return as;
        }

        private String readRest( ) throws IOException {

            skipWhite( );
            StringBuffer stringbuffer = new StringBuffer( 80 );
            for ( ; !isEndOfLine( ch ); ch = in.read( ) ) {
                stringbuffer.append( (char) ch );
            }

            ch = in.read( );
            return stringbuffer.toString( );
        }

        private void readCheckSum( ) throws IOException {

            skipWhite( );
            String s = readWord( );
            try {
                checksum = Long.parseLong( s, 16 );
                skipWhite( );
                if ( !isEndOfLine( ch ) ) {
                    throw new IOException( "extra text after checksum in exclude list" );
                }
            } catch ( NumberFormatException numberformatexception ) {
                throw new IOException( "badly-formed checksum in exclude list: " + s );
            }
        }

        private String readWord( ) throws IOException {

            StringBuffer stringbuffer = new StringBuffer( 32 );
            for ( ; !isEndOfLine( ch ) && !isWhitespace( ch ); ch = in.read( ) ) {
                stringbuffer.append( (char) ch );
            }

            return stringbuffer.toString( );
        }

        private void skipComment( ) throws IOException, Fault {

            ch = in.read( );
            if ( ch == 35 ) {
                ch = in.read( );
                if ( ch == 35 ) {
                    ch = in.read( );
                    skipWhite( );
                    String s = readWord( );
                    if ( s.equalsIgnoreCase( "checksum" ) ) {
                        readCheckSum( );
                        return;
                    }
                    if ( s.equals( "title" ) ) {
                        skipWhite( );
                        title = readRest( );
                        return;
                    }
                }
            }
            for ( ; !isEndOfLine( ch ); ch = in.read( ) ) {
            }
        }

        private void skipWhite( ) throws IOException {

            for ( ; ch != -1 && isWhitespace( ch ); ch = in.read( ) ) {
            }
        }

        private Reader in;

        private int ch;

        private Map<String, String[]> platformCache;

        private long checksum;

        private String title;

        Parser( Reader reader ) throws IOException {

            platformCache = new HashMap<String, String[]>( );
            in = reader;
            ch = reader.read( );
        }
    }

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        Fault( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

            super( i18nresourcebundle.getString( s, obj ) );
        }
    }

    public static boolean isExcludeFile( File file ) {

        return file.getPath( ).endsWith( ".jtx" );
    }

    public ExcludeTable( ) {

        table = new HashMap<Key, Object>( );
        checksumState = 2;
    }

    public ExcludeTable( File file ) throws FileNotFoundException, IOException, Fault {

        table = new HashMap<Key, Object>( );
        if ( file != null ) {
            BufferedReader bufferedreader = new BufferedReader( new FileReader( file ) );
            Parser parser = new Parser( bufferedreader );
            Entry entry;
            try {
                while ( ( entry = parser.readEntry( ) ) != null ) {
                    addEntry( entry );
                }
            } finally {
                bufferedreader.close( );
            }
            long l = parser.getChecksum( );
            if ( l == 0L ) {
                checksumState = 0;
            } else {
                long l1 = computeChecksum( );
                checksumState = l != l1 ? 1 : 2;
            }
            title = parser.getTitle( );
        }
    }

    public ExcludeTable( File afile[] ) throws FileNotFoundException, IOException, Fault {

        table = new HashMap<Key, Object>( );
        checksumState = 2;
        for ( int i = 0; i < afile.length; i++ ) {
            ExcludeTable excludetable = new ExcludeTable( afile[i] );
            merge( excludetable );
        }

    }

    public boolean excludesAllOf( TestDescription testdescription ) {

        return excludesAllOf( testdescription.getRootRelativeURL( ) );
    }

    public boolean excludesAllOf( String s ) {

        Object obj = table.get( new Key( s ) );
        return obj != null && ( obj instanceof Entry ) && ( (Entry) obj ).testCase == null;
    }

    public boolean excludesAnyOf( TestDescription testdescription ) {

        return excludesAnyOf( testdescription.getRootRelativeURL( ) );
    }

    public boolean excludesAnyOf( String s ) {

        Object obj = table.get( new Key( s ) );
        return obj != null;
    }

    public String[] getTestCases( TestDescription testdescription ) {

        Key key = new Key( testdescription.getRootRelativeURL( ) );
        String as4[];
        synchronized ( table ) {
            Object obj = table.get( key );
            if ( obj == null ) {
                String as[] = null;
                return as;
            }
            if ( obj instanceof Entry ) {
                Entry entry = (Entry) obj;
                if ( entry.testCase == null ) {
                    String as1[] = null;
                    return as1;
                }
                String as3[] = { entry.testCase };
                return as3;
            }
            Entry aentry[] = (Entry[]) obj;
            String as2[] = new String[aentry.length];
            for ( int i = 0; i < aentry.length; i++ ) {
                as2[i] = aentry[i].testCase;
            }

            as4 = as2;
        }
        return as4;
    }

    public void addEntry( Entry entry ) throws Fault {

        synchronized ( table ) {
            Key key = new Key( entry.relativeURL );
            Object obj = table.get( key );
            if ( obj == null ) {
                table.put( key, entry );
            } else if ( obj instanceof Entry ) {
                Entry entry1 = (Entry) obj;
                if ( entry1.testCase == null ) {
                    if ( entry.testCase == null ) {
                        table.put( key, entry );
                    } else {
                        throw new Fault( i18n, "excl.cantExcludeCase", entry.relativeURL );
                    }
                } else {
                    if ( entry.testCase == null ) {
                        throw new Fault( i18n, "excl.cantExcludeTest", entry.relativeURL );
                    }
                    if ( entry1.testCase.equals( entry.testCase ) ) {
                        table.put( key, entry );
                    } else {
                        table.put( key, new Entry[] { entry1, entry } );
                    }
                }
            } else {
                if ( entry.testCase == null ) {
                    throw new Fault( i18n, "excl.cantExcludeTest", entry.relativeURL );
                }
                Entry aentry[] = (Entry[]) obj;
                for ( int i = 0; i < aentry.length; i++ ) {
                    if ( aentry[i].testCase.equals( entry.testCase ) ) {
                        aentry[i] = entry;
                        return;
                    }
                }

                table.put( key, DynamicArray.append( aentry, entry ) );
            }
            checksumState = 0;
        }
    }

    public Entry getEntry( String s ) {

        String s1 = null;
        if ( s.endsWith( "]" ) ) {
            int i = s.lastIndexOf( "[" );
            if ( i != -1 ) {
                s1 = s.substring( i + 1, s.length( ) - 1 );
                s = s.substring( 0, i );
            }
        }
        return getEntry( s, s1 );
    }

    public Entry getEntry( String s, String s1 ) {

        Key key = new Key( s );
        Object obj = table.get( key );
        if ( obj == null ) {
            return null;
        }
        if ( obj instanceof Entry ) {
            Entry entry = (Entry) obj;
            if ( s1 == null ) {
                return entry;
            } else {
                return isInList( entry.testCase, s1 ) ? entry : null;
            }
        }
        Entry aentry[] = (Entry[]) obj;
        for ( int i = 0; i < aentry.length; i++ ) {
            Entry entry1 = aentry[i];
            if ( isInList( entry1.testCase, s1 ) ) {
                return entry1;
            }
        }

        return null;
    }

    public void merge( ExcludeTable excludetable ) {

        synchronized ( table ) {
            for ( Iterator<Object> iterator = excludetable.getIterator( false ); iterator.hasNext( ); ) {
                Entry entry = (Entry) iterator.next( );
                Key key = new Key( entry.relativeURL );
                Object obj = table.get( key );
                if ( obj == null ) {
                    table.put( key, entry );
                } else if ( obj instanceof Entry ) {
                    Entry entry1 = (Entry) obj;
                    if ( entry1.testCase == null || entry.testCase == null ) {
                        table.put( key, new Entry( entry1.relativeURL, null, mergeBugIds( entry1.bugIds, entry.bugIds ), mergePlatforms( entry1.platforms, entry.platforms ), mergeSynopsis( entry1.synopsis, entry.synopsis ) ) );
                    } else {
                        table.put( key, new Entry[] { entry1, entry } );
                    }
                } else if ( entry.testCase == null ) {
                    int ai[] = entry.bugIds;
                    String as[] = entry.platforms;
                    String s = entry.synopsis;
                    Entry aentry[] = (Entry[]) obj;
                    for ( int i = 0; i < aentry.length; i++ ) {
                        ai = mergeBugIds( ai, aentry[i].bugIds );
                        as = mergePlatforms( as, aentry[i].platforms );
                        s = mergeSynopsis( s, aentry[i].synopsis );
                    }

                    table.put( key, new Entry( entry.relativeURL, null, ai, as, s ) );
                } else {
                    table.put( key, DynamicArray.append( (Entry[]) obj, entry ) );
                }
            }

        }
        checksumState = Math.min( checksumState, excludetable.getChecksumState( ) );
    }

    private static int[] mergeBugIds( int ai[], int ai1[] ) {

        TreeSet<Integer> treeset = new TreeSet<Integer>( );
        for ( int i = 0; i < ai.length; i++ ) {
            treeset.add( new Integer( ai[i] ) );
        }

        for ( int j = 0; j < ai1.length; j++ ) {
            treeset.add( new Integer( ai1[j] ) );
        }

        int ai2[] = new int[treeset.size( )];
        int k = 0;
        for ( Iterator<Integer> iterator = treeset.iterator( ); iterator.hasNext( ); ) {
            ai2[k++] = iterator.next( ).intValue( );
        }

        return ai2;
    }

    private static String[] mergePlatforms( String as[], String as1[] ) {

        TreeSet<String> treeset = new TreeSet<String>( );
        for ( int i = 0; i < as.length; i++ ) {
            treeset.add( as[i] );
        }

        for ( int j = 0; j < as1.length; j++ ) {
            treeset.add( as1[j] );
        }

        return treeset.toArray( new String[treeset.size( )] );
    }

    private static String mergeSynopsis( String s, String s1 ) {

        if ( s == null || s.trim( ).length( ) == 0 ) {
            return s1;
        }
        if ( s1 == null || s1.trim( ).length( ) == 0 ) {
            return s;
        }
        if ( s.indexOf( s1 ) != -1 ) {
            return s;
        }
        if ( s1.indexOf( s ) != -1 ) {
            return s1;
        } else {
            return s + "; " + s1;
        }
    }

    public void removeEntry( Entry entry ) {

        synchronized ( table ) {
            Key key = new Key( entry.relativeURL );
            Object obj = table.get( key );
            if ( obj == null ) {
                return;
            }
            if ( obj instanceof Entry ) {
                if ( obj == entry ) {
                    table.remove( key );
                }
            } else {
                Entry aentry[] = (Entry[]) DynamicArray.remove( (Entry[]) obj, entry );
                if ( aentry == obj ) {
                    return;
                }
                if ( aentry.length == 1 ) {
                    table.put( key, aentry[0] );
                } else {
                    table.put( key, aentry );
                }
            }
        }
    }

    public boolean isEmpty( ) {

        return table.isEmpty( );
    }

    public int size( ) {

        int i = 0;
        for ( Iterator<Object> iterator = table.values( ).iterator( ); iterator.hasNext( ); ) {
            Object obj = iterator.next( );
            if ( obj instanceof Entry[] ) {
                i += ( (Entry[]) obj ).length;
            } else {
                i++;
            }
        }

        return i;
    }

    public Iterator<Object> getIterator( boolean flag ) {

        if ( flag ) {
            return table.values( ).iterator( );
        }
        Vector<Object> vector = new Vector<Object>( table.size( ) );
        for ( Iterator<Object> iterator = table.values( ).iterator( ); iterator.hasNext( ); ) {
            Object obj = iterator.next( );
            if ( obj instanceof Entry ) {
                vector.addElement( obj );
            } else {
                Entry aentry[] = (Entry[]) obj;
                for ( int i = 0; i < aentry.length; i++ ) {
                    vector.addElement( aentry[i] );
                }

            }
        }

        return vector.iterator( );
    }

    public int getChecksumState( ) {

        return checksumState;
    }

    public String getTitle( ) {

        return title;
    }

    public void setTitle( String s ) {

        title = s;
    }

    public void write( File file ) throws IOException {

        int i = 0;
        int j = 0;
        int k = 0;
        TreeSet<Entry> treeset = new TreeSet<Entry>( );
        for ( Iterator<Object> iterator = getIterator( false ); iterator.hasNext( ); ) {
            Entry entry = (Entry) iterator.next( );
            treeset.add( entry );
            if ( entry.testCase == null ) {
                i = Math.max( entry.relativeURL.length( ), i );
            } else {
                i = Math.max( entry.relativeURL.length( ) + entry.testCase.length( ) + 2, i );
            }
            j = Math.max( bugIdsToString( entry ).length( ), j );
            k = Math.max( platformsToString( entry ).length( ), k );
        }

        BufferedWriter bufferedwriter = new BufferedWriter( new FileWriter( file ) );
        bufferedwriter.write( "# Exclude List" );
        bufferedwriter.newLine( );
        bufferedwriter.write( "# SCCS %W% %E%" );
        bufferedwriter.newLine( );
        if ( title != null ) {
            bufferedwriter.write( "### title " + title );
            bufferedwriter.newLine( );
        }
        bufferedwriter.write( "### checksum " );
        long l = computeChecksum( );
        if ( l < 0L ) {
            bufferedwriter.write( "-" );
        }
        bufferedwriter.write( Long.toHexString( Math.abs( l ) ) );
        bufferedwriter.newLine( );
        for ( Iterator<Entry> iterator1 = treeset.iterator( ); iterator1.hasNext( ); bufferedwriter.newLine( ) ) {
            Entry entry1 = iterator1.next( );
            if ( entry1.testCase == null ) {
                write( bufferedwriter, entry1.relativeURL, i + 2 );
            } else {
                write( bufferedwriter, entry1.relativeURL + "[" + entry1.testCase + "]", i + 2 );
            }
            write( bufferedwriter, bugIdsToString( entry1 ), j + 2 );
            write( bufferedwriter, platformsToString( entry1 ), k + 2 );
            bufferedwriter.write( entry1.synopsis );
        }

        bufferedwriter.close( );
    }

    private long computeChecksum( ) {

        long l = 0L;
        for ( Iterator<Object> iterator = table.values( ).iterator( ); iterator.hasNext( ); ) {
            Object obj = iterator.next( );
            if ( obj instanceof Entry ) {
                l += ( (Entry) obj ).computeChecksum( );
            } else {
                Entry aentry[] = (Entry[]) obj;
                for ( int i = 0; i < aentry.length; i++ ) {
                    l += aentry[i].computeChecksum( );
                }

            }
        }

        if ( l == 0L ) {
            l = 1L;
        }
        return Math.abs( l );
    }

    private void write( Writer writer, String s, int i ) throws IOException {

        writer.write( s );
        for ( int j = s.length( ); j < i; j++ ) {
            writer.write( 32 );
        }

    }

    private String bugIdsToString( Entry entry ) {

        StringBuffer stringbuffer = new StringBuffer( entry.bugIds.length * 10 );
        stringbuffer.append( entry.bugIds[0] );
        for ( int i = 1; i < entry.bugIds.length; i++ ) {
            stringbuffer.append( ',' );
            stringbuffer.append( entry.bugIds[i] );
        }

        return stringbuffer.toString( );
    }

    private String platformsToString( Entry entry ) {

        StringBuffer stringbuffer = new StringBuffer( entry.bugIds.length * 10 );
        stringbuffer.append( entry.platforms[0] );
        for ( int i = 1; i < entry.platforms.length; i++ ) {
            stringbuffer.append( ',' );
            stringbuffer.append( entry.platforms[i] );
        }

        return stringbuffer.toString( );
    }

    private static boolean isInList( String s, String s1 ) {

        if ( s == null || s1 == null ) {
            return false;
        }
        for ( int i = s.indexOf( s1 ); i != -1; i = s.indexOf( s1, i + 1 ) ) {
            if ( ( i == 0 || s.charAt( i - 1 ) == ',' ) && ( i + s1.length( ) == s.length( ) || s.charAt( i + s1.length( ) ) == ',' ) ) {
                return true;
            }
        }

        return false;
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    public static final int NO_CHECKSUM = 0;

    public static final int BAD_CHECKSUM = 1;

    public static final int GOOD_CHECKSUM = 2;

    private Map<Key, Object> table;

    private int checksumState;

    private String title;

    private static I18NResourceBundle i18n;

    public static final String EXCLUDEFILE_EXTN = ".jtx";

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.ExcludeTable.class );
    }

}
