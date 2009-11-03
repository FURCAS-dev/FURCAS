// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: PathClassLoader.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.repository.test.jmitck.mapping.CheckTypeTests;

@SuppressWarnings( "nls" )
public class PathClassLoader extends ClassLoader {

    public PathClassLoader( String s ) {

        classes = new Hashtable<String, Class<?>>( );
        zips = new Hashtable<File, ZipFile>( );
        path = split( s );
    }

    public PathClassLoader( File file, String s ) {

        classes = new Hashtable<String, Class<?>>( );
        zips = new Hashtable<File, ZipFile>( );
        path = split( s );
        for ( int i = 0; i < path.length; i++ ) {
            File file1 = path[i];
            if ( !file1.isAbsolute( ) ) {
                path[i] = new File( file, file1.getPath( ) );
            }
        }

    }

    public PathClassLoader( File afile[] ) {

        classes = new Hashtable<String, Class<?>>( );
        zips = new Hashtable<File, ZipFile>( );
        path = afile;
    }

    @Override
    protected Class<?> loadClass( String s, boolean flag ) throws ClassNotFoundException {

        Class<?> class1 = classes.get( s );
        if ( class1 == null ) {
            try {
                class1 = CheckTypeTests.class.getClassLoader( ).loadClass( s );
                //class1 = findSystemClass(s);
            } catch ( ClassNotFoundException classnotfoundexception ) {
                class1 = locateClass( s );
            }
        }
        if ( flag ) {
            resolveClass( class1 );
        }
        return class1;
    }

    private synchronized Class<?> locateClass( String s ) throws ClassNotFoundException {

        Class<?> class1 = classes.get( s );
        if ( class1 != null ) {
            return class1;
        }
        for ( int i = 0; i < path.length; i++ ) {
            Class<?> class2;
            if ( path[i].isDirectory( ) ) {
                class2 = locateClassInDir( s, path[i] );
            } else {
                class2 = locateClassInJar( s, path[i] );
            }
            if ( class2 != null ) {
                classes.put( s, class2 );
                return class2;
            }
        }

        throw new ClassNotFoundException( s );
    }

    private Class<?> locateClassInDir( String s, File file ) throws ClassNotFoundException {

        String s1 = s.replace( '.', '/' ) + ".class";
        try {
            File file1 = new File( file, s1 );
            return readClass( s, new FileInputStream( file1 ), (int) file1.length( ) );
        } catch ( IOException ioexception ) {
            return null;
        }
    }

    private Class<?> locateClassInJar( String s, File file ) throws ClassNotFoundException {

        String s1 = s.replace( '.', '/' ) + ".class";
        try {
            ZipFile zipfile = zips.get( file );
            if ( zipfile == null ) {
                zipfile = new ZipFile( file );
                zips.put( file, zipfile );
            }
            ZipEntry zipentry = zipfile.getEntry( s1 );
            if ( zipentry == null ) {
                return null;
            } else {
                return readClass( s, zipfile.getInputStream( zipentry ), (int) zipentry.getSize( ) );
            }
        } catch ( IOException ioexception ) {
            return null;
        }
    }

    private Class<?> readClass( String s, InputStream inputstream, int i ) throws IOException {

        byte abyte0[] = new byte[i];
        try {
            for ( int j = 0; j < i; j += inputstream.read( abyte0, j, i - j ) ) {
            }
        } finally {
            inputstream.close( );
        }
        return defineClass( s, abyte0, 0, abyte0.length );
    }

    private File[] split( String s ) {

        char c = File.pathSeparatorChar;
        Vector<File> vector = new Vector<File>( );
        int i = 0;
        for ( int j = s.indexOf( c ); j != -1; j = s.indexOf( c, i ) ) {
            add( s.substring( i, j ), vector );
            i = j + 1;
        }

        if ( i != s.length( ) ) {
            add( s.substring( i ), vector );
        }
        File afile[] = new File[vector.size( )];
        vector.copyInto( afile );
        return afile;
    }

    private void add( String s, Vector<File> vector ) {

        if ( s.length( ) != 0 ) {
            vector.addElement( new File( s ) );
        }
    }

    private File path[];

    private Hashtable<String, Class<?>> classes;

    private Hashtable<File, ZipFile> zips;
}
