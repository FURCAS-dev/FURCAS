package com.sap.tc.moin.repository.core.generator.jmi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;

@SuppressWarnings( { "unchecked", "nls" } )
public class JavaSourceWriter {

    public final static String CHARSET_UTF8 = "utf-8";

    public static boolean writeToDirectory( String directory, JavaSource javaSource ) {

        boolean result = false;
        if ( javaSource == null || javaSource.getQualifiedName( ) == null ) {
            return false;
        }
        // get full path of source file
        String javaSourceFilePath = directory.replace( '\\', '/' );
        if ( javaSourceFilePath.lastIndexOf( '/' ) != javaSourceFilePath.length( ) - 1 ) {
            javaSourceFilePath += '/'; //$NON-NLS-1$
        }
        javaSourceFilePath += javaSource.getQualifiedName( ).replace( '.', '/' ) + "." + javaSource.getExtension( ); //$NON-NLS-1$
        // create the directories
        if ( !createDirsOfPath( javaSourceFilePath ) ) {
            return false;
        }
        result = writeCodeToFile( javaSource.getCode( ), new File( javaSourceFilePath ) );
        return result;
    }

    private static boolean createDirsOfPath( String path ) {

        String p = path;
        // check the whole path first
        int n = p.lastIndexOf( '/' );
        File file = new File( p.substring( 0, n ) );
        if ( file.exists( ) ) {
            return true;
        }
        String dir = ""; //$NON-NLS-1$
        String dirTmp;
        n = 0;
        int m = 0;
        while ( n >= 0 && n < p.length( ) ) {
            m = p.indexOf( '/', n );
            if ( m >= 0 ) {
                dirTmp = p.substring( n, m );
                dir = dir + dirTmp + "/"; //$NON-NLS-1$
                file = new File( dir );
                if ( !( file.exists( ) ) ) {
                    file.mkdir( );
                }
                n = m + 1;
            } else {
                break;
            }
        }
        return true;
    }

    private static boolean writeCodeToFile( String aCode, File aFile ) {

        boolean result = false;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            if ( aFile.exists( ) && ( !( aFile.canWrite( ) ) ) ) {
                return false;
            }
            fos = new FileOutputStream( aFile );
            if ( fos == null ) {
                return false;
            }
            osw = new OutputStreamWriter( fos, CHARSET_UTF8 );
            osw.write( aCode );
            result = true;
        } catch ( java.io.IOException e ) {
            return false;
        } finally {
            try {
                if ( osw != null ) {
                    osw.close( );
                }
                if ( fos != null ) {
                    fos.close( );
                }
            } catch ( IOException e1 ) {
                return false;
            }
        }
        return result;
    }
}