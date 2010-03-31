// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestDescription.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.USER_DIR;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.PropertyArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.StringArray;

@SuppressWarnings( "nls" )
public class TestDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    public TestDescription( File file, File file1, Map<String, String> map ) throws IllegalArgumentException {

        if ( file.equals( cachedRoot ) ) {
            rootDir = cachedRootDir;
        } else {
            if ( file.exists( ) ? file.isFile( ) : file.getName( ).endsWith( ".html" ) ) {
                rootDir = file.getParent( );
            } else {
                rootDir = file.getPath( );
            }
            cachedRoot = file;
            cachedRootDir = rootDir;
        }
        String s = file1.getPath( );
        String s1;
        if ( file1.isAbsolute( ) ) {
            String s2 = rootDir;
            if ( !s.startsWith( s2 ) || s.charAt( s2.length( ) ) != File.separatorChar ) {
                throw new IllegalArgumentException( "file must be relative to root: " + file1 );
            }
            s1 = s.substring( s2.length( ) + 1 );
        } else {
            s1 = s;
        }
        rootRelativePath = s1.replace( File.separatorChar, '/' );
        Vector<String> vector = new Vector<String>( 0, map.size( ) * 2 );
        String s3;
        String s4;
        for ( Iterator<String> iterator = map.keySet( ).iterator( ); iterator.hasNext( ); insert( vector, s3, s4 ) ) {
            s3 = iterator.next( );
            s4 = map.get( s3 );
        }

        fields = new String[vector.size( )];
        vector.copyInto( fields );
    }

    public TestDescription( Map<String, String> map ) throws IllegalArgumentException {

        rootDir = "";
        rootRelativePath = "";
        Vector<String> vector = new Vector<String>( 0, map.size( ) * 2 );
        String s3;
        String s4;
        for ( Iterator<String> iterator = map.keySet( ).iterator( ); iterator.hasNext( ); insert( vector, s3, s4 ) ) {
            s3 = iterator.next( );
            s4 = map.get( s3 );
        }

        fields = new String[vector.size( )];
        vector.copyInto( fields );
    }

    private TestDescription( String s, String s1, String as[] ) {

        rootDir = s;
        char c = s1.charAt( s.length( ) );
        rootRelativePath = s1.substring( s.length( ) + 1 ).replace( c, '/' );
        Vector<String> vector = new Vector<String>( 0, as.length );
        for ( int i = 0; i < as.length; i += 2 ) {
            String s2 = as[i];
            if ( !s2.startsWith( "$" ) && !s2.equals( "testsuite" ) && !s2.equals( "file" ) ) {
                String s3 = as[i + 1];
                insert( vector, s2, s3 );
            }
        }

        fields = new String[vector.size( )];
        vector.copyInto( fields );
    }

    public File getDir( ) {

        return new File( getFile( ).getParent( ) );
    }

    public File getFile( ) {

        return new File( rootDir, rootRelativePath.replace( '/', File.separatorChar ) );
    }

    public String getId( ) {

        return getParameter( "id" );
    }

    public String getTitle( ) {

        String s = getParameter( "title" );
        if ( s == null ) {
            s = getName( );
        }
        return s;
    }

    public String getName( ) {

        int i = rootRelativePath.lastIndexOf( '/' );
        String s = i != -1 ? rootRelativePath.substring( i + 1 ) : rootRelativePath;
        int j = s.indexOf( '.' );
        if ( j != -1 ) {
            s = s.substring( 0, j );
        }
        String s1 = getParameter( "id" );
        if ( s1 != null ) {
            s = s + "_" + s1;
        }
        return s;
    }

    public String[] getKeywords( ) {

        return StringArray.split( getParameter( "keywords" ) );
    }

    public Set<String> getKeywordTable( ) {

        String as[] = StringArray.split( getParameter( "keywords" ) );
        TreeSet<String> treeset = new TreeSet<String>( );
        for ( int i = 0; i < as.length; i++ ) {
            String s = as[i].toLowerCase( Locale.ENGLISH );
            treeset.add( s );
        }

        return treeset;
    }

    public String[] getSources( ) {

        return StringArray.split( getParameter( "source" ) );
    }

    public File[] getSourceFiles( ) {

        String s = getFile( ).getParent( );
        String as[] = getSources( );
        File afile[] = new File[as.length];
        String s1 = System.getProperty( USER_DIR ) + File.separator;
        for ( int i = 0; i < as.length; i++ ) {
            File file = new File( s, as[i].replace( '/', File.separatorChar ) );
            String s2 = file.getPath( );
            if ( s2.startsWith( s1 ) ) {
                s2 = s2.substring( s1.length( ) );
                afile[i] = new File( s2 );
            } else {
                afile[i] = file;
            }
        }

        return afile;
    }

    /**
     * @deprecated Method getClassDir is deprecated
     */

    @Deprecated
    public String getClassDir( ) {

        return getParameter( "classDir" );
    }

    /**
     * @deprecated Method getExecuteClass is deprecated
     */

    @Deprecated
    public String getExecuteClass( ) {

        return getParameter( "executeClass" );
    }

    /**
     * @deprecated Method getExecuteArgs is deprecated
     */

    @Deprecated
    public String getExecuteArgs( ) {

        return getParameter( "executeArgs" );
    }

    /**
     * @deprecated Method getTimeout is deprecated
     */

    @Deprecated
    public int getTimeout( ) {

        String s = getParameter( "timeout" );
        if ( s == null ) {
            return 0;
        } else {
            return Integer.parseInt( s );
        }
    }

    /**
     * @deprecated Method getRoot is deprecated
     */

    @Deprecated
    public File getRoot( ) {

        return new File( rootDir, "testsuite.html" );
    }

    public String getRootDir( ) {

        return rootDir;
    }

    public String getRootRelativePath( ) {

        return rootRelativePath;
    }

    public File getRootRelativeFile( ) {

        return new File( rootRelativePath.replace( '/', File.separatorChar ) );
    }

    public String getRootRelativeURL( ) {

        String s = getParameter( "id" );
        return s != null ? rootRelativePath + "#" + s : rootRelativePath;
    }

    public File getRootRelativeDir( ) {

        String s = getRootRelativeFile( ).getParent( );
        return s != null ? new File( s ) : new File( "." );
    }

    public int getParameterCount( ) {

        return fields.length / 2;
    }

    public Iterator<String> getParameterKeys( ) {

        return new Iterator<String>( ) {

            public boolean hasNext( ) {

                return fields != null && fields.length != 0 && pos < fields.length;
            }

            public String next( ) {

                if ( fields == null || fields.length == 0 || pos == fields.length ) {
                    return null;
                } else {
                    String s = fields[pos];
                    pos += 2;
                    return s;
                }
            }

            public void remove( ) {

                throw new UnsupportedOperationException( );
            }

            int pos;

            {
                pos = 0;
            }
        };
    }

    public String getParameter( String s ) {

        int i = 0;
        int j = fields.length - 2;
        if ( j < 0 ) {
            return null;
        }
        String s1 = fields[j];
        int l = s.compareTo( s1 );
        if ( l > 0 ) {
            return null;
        }
        while ( i <= j ) {
            int k = i + ( ( j - i ) / 4 ) * 2;
            String s2 = fields[k];
            int i1 = s.compareTo( s2 );
            if ( i1 < 0 ) {
                j = k - 2;
            } else if ( i1 > 0 ) {
                i = k + 2;
            } else {
                return fields[k + 1];
            }
        }
        return null;
    }

    @Override
    public String toString( ) {

        return "TestDescription[" + getTitle( ) + "]";
    }

    void save( Map<String, String> map ) {

        saveField( map, "$root", rootDir );
        saveField( map, "$file", getFile( ).getPath( ) );
        for ( int i = 0; i < fields.length; i += 2 ) {
            saveField( map, fields[i], fields[i + 1] );
        }

    }

    private void saveField( Map<String, String> map, String s, String s1 ) {

        if ( s1 != null ) {
            map.put( s, s1 );
        }
    }

    static TestDescription load( String as[] ) {

        String s = PropertyArray.get( as, "$root" );
        if ( s == null ) {
            s = PropertyArray.get( as, "testsuite" );
        }
        String s1 = PropertyArray.get( as, "$file" );
        if ( s1 == null ) {
            s1 = PropertyArray.get( as, "file" );
        }
        return new TestDescription( s, s1, as );
    }

    private static void insert( Vector<String> vector, String s, String s1 ) {

        int i = 0;
        int j = vector.size( ) - 2;
        int k = 0;
        if ( j < 0 ) {
            vector.addElement( s );
            vector.addElement( s1 );
            return;
        }
        String s2 = vector.elementAt( j );
        int l = s.compareTo( s2 );
        if ( l > 0 ) {
            vector.addElement( s );
            vector.addElement( s1 );
            return;
        }
        while ( i <= j ) {
            k = i + ( ( j - i ) / 4 ) * 2;
            String s3 = vector.elementAt( k );
            l = s.compareTo( s3 );
            if ( l < 0 ) {
                j = k - 2;
            } else if ( l > 0 ) {
                i = k + 2;
            } else {
                throw new Error( "should not happen" );
            }
        }
        if ( l > 0 ) {
            k += 2;
        }
        vector.insertElementAt( s, k );
        vector.insertElementAt( s1, k + 1 );
    }

    private String rootDir;

    private String rootRelativePath;

    private String fields[];

    private static File cachedRoot;

    private static String cachedRootDir;

}
