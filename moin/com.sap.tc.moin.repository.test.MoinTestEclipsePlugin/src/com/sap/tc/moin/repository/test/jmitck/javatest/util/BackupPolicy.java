// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: BackupPolicy.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Vector;

@SuppressWarnings( "nls" )
public abstract class BackupPolicy {

    public BackupPolicy( ) {
    }

    public void backup( File file ) throws IOException, SecurityException {

        if ( !isBackupRequired( file ) ) {
            return;
        }
        if ( !file.exists( ) ) {
            return;
        }
        if ( file.isDirectory( ) ) {
            throw new IOException( "Cannot backup a directory" );
        }
        if ( !file.canWrite( ) ) {
            throw new IOException( "File is write-protected" );
        }
        File file1 = new File( file.getCanonicalPath( ) );
        String s = file1.getParent( );
        if ( s == null ) {
            throw new IOException( "Cannot determine parent directory of " + file );
        }
        File file2 = new File( s );
        String as[] = file2.list( );
        String s1 = file.getName( ) + "~";
        String s2 = "~";
        int i = 0;
        Vector<Integer> vector = new Vector<Integer>( );
        if ( as != null ) {
            label0: for ( int j = 0; j < as.length; j++ ) {
                String s3 = as[j];
                if ( s3.length( ) <= s1.length( ) + s2.length( ) || !s3.startsWith( s1 ) || !s3.endsWith( s2 ) ) {
                    continue;
                }
                String s4 = s3.substring( s1.length( ), s3.length( ) - s2.length( ) );
                for ( int l = 0; l < s4.length( ); l++ ) {
                    if ( !Character.isDigit( s4.charAt( l ) ) ) {
                        break label0;
                    }
                }

                int j1 = Integer.parseInt( s4 );
                if ( j1 > i ) {
                    i = j1;
                }
                vector.addElement( new Integer( j1 ) );
            }

        }
        File file3 = new File( file.getPath( ) + "~" + ++i + "~" );
        boolean flag = file.renameTo( file3 );
        if ( !flag ) {
            throw new IOException( "failed to backup file: " + file );
        }
        int k = getNumBackupsToKeep( file );
        for ( int i1 = 0; i1 < vector.size( ); i1++ ) {
            int k1 = vector.elementAt( i1 ).intValue( );
            if ( k1 <= i - k ) {
                File file4 = new File( file.getPath( ) + "~" + k1 + "~" );
                file4.delete( );
            }
        }

    }

    public void backupAndRename( File file, File file1 ) throws IOException, SecurityException {

        if ( !file.exists( ) ) {
            return;
        }
        if ( file.isDirectory( ) ) {
            throw new IOException( "Cannot backup a directory." );
        }
        if ( !file.canWrite( ) ) {
            throw new IOException( "Cannot rename, source file is write-protected " + file.getPath( ) );
        }
        if ( isBackupRequired( file1 ) ) {
            backup( file1 );
        } else if ( file1.exists( ) ) {
            file1.delete( );
        }
        boolean flag = file.renameTo( file1 );
        if ( !flag ) {
            throw new IOException( "Rename of " + file1.getPath( ) + " failed." );
        } else {
            return;
        }
    }

    public Writer backupAndOpenWriter( File file ) throws IOException, SecurityException {

        backup( file );
        return new BufferedWriter( new FileWriter( file ) );
    }

    public OutputStream backupAndOpenStream( File file ) throws IOException, SecurityException {

        backup( file );
        return new BufferedOutputStream( new FileOutputStream( file ) );
    }

    public abstract int getNumBackupsToKeep( File file );

    public abstract boolean isBackupRequired( File file );

    public static BackupPolicy noBackups( ) {

        return new BackupPolicy( ) {

            @Override
            public int getNumBackupsToKeep( File file ) {

                return 0;
            }

            @Override
            public boolean isBackupRequired( File file ) {

                return false;
            }

        };
    }
}
