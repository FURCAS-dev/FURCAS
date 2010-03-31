package com.sap.tc.moin.test.fw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * This Class initialises the MOIN_DB_Stylesheets. Process: - Delete old
 * stylesheets - unzip archive to folder - execute Batchfile
 */
@SuppressWarnings( "nls" )
public class DbSchemaHelper {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, DbSchemaHelper.class );

    private StringBuilder szPathToZip;

    private StringBuilder szextractPath;

    private StringBuilder szBatchCommand;

    /**
     * Creates the DB Schema required for running MOIN. It takes the respective
     * schema zip from pathToZip parameter, extracts the content to extractPath
     * and executes the batch file named batchCommand
     * 
     * @param pathToZip path to schema zip
     * @param extractPath path to target directory
     * @param batchCommand batch command to be executed
     */
    public DbSchemaHelper( String pathToZip, String extractPath, String batchCommand ) {

        if ( pathToZip == null || "".equals( pathToZip ) ) {
            String msg = "No path to db schema zipfile has been passed in";
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, msg );
            }
            throw new IllegalArgumentException( msg );
        }

        if ( pathToZip == null || "".equals( extractPath ) ) {
            String msg = "No target directory for extraction has been passed in";
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, msg );
            }
            throw new IllegalArgumentException( msg );
        }
        if ( pathToZip == null || "".equals( batchCommand ) ) {
            String msg = "No batch command has been passed in";
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, msg );
            }
            throw new IllegalArgumentException( msg );
        }

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "DB Schema ZIP" + pathToZip );
            logger.trace( MoinSeverity.DEBUG, "Extract Directory" + extractPath );
            logger.trace( MoinSeverity.DEBUG, "BatchCommand: " + batchCommand );
        }

        szPathToZip = new StringBuilder( pathToZip );
        szextractPath = new StringBuilder( extractPath );
        szBatchCommand = new StringBuilder( batchCommand );
    }

    public void executeSetup( ) throws Exception {

        this.deleteAll( );
        this.extractArchive( );
        this.executeBatch( );
    }

    /**
     * This function executes a batchfile which was delivered as parameter while
     * construction
     */
    protected void executeBatch( ) throws Exception {

        /**
         * retrieving runtime environment, necessary for exec command
         */
        Runtime rt = Runtime.getRuntime( );
        String[] cmdarray = new String[2];
        StringBuffer command = new StringBuffer( "/c " + szBatchCommand.toString( ) );
        // command.append(szextractPath);
        cmdarray[0] = new String( "cmd.exe" );
        cmdarray[1] = new String( command.toString( ) );

        /**
         * Exec command, here the batchfile is going to be executed
         */
        Process proc = rt.exec( cmdarray, null, new File( szextractPath.toString( ) ) );
        /**
         * The folowing passage might be unnecessary complicated but works ...
         * We recieve the Programm Output from the standard Error Stream and
         * Standart Input Stream These are stored in ArrayList Objects so we can
         * print them Line by Line if nec whished
         */
        InputStream stderr = proc.getErrorStream( );
        InputStream stdin = proc.getInputStream( );
        InputStreamReader isre = new InputStreamReader( stderr );
        InputStreamReader isri = new InputStreamReader( stdin );
        BufferedReader bre = new BufferedReader( isre );
        BufferedReader bri = new BufferedReader( isri );
        String line = null;

        ArrayList<String> input = new ArrayList<String>( );
        while ( ( line = bri.readLine( ) ) != null ) {
            input.add( line );
        }

        int length;
        length = input.size( );
        int x = 0;
        while ( x <= length - 1 ) {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, input.get( x ).toString( ) );
            }
            x++;
        }

        line = null;

        ArrayList<String> error = new ArrayList<String>( );
        while ( ( line = bre.readLine( ) ) != null ) {
            error.add( line );
        }
        length = 0;
        length = error.size( );
        x = 0;
        while ( x <= length - 1 ) {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, error.get( x ).toString( ) );
            }
            x++;
        }

        int exitVal = proc.waitFor( );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Process exitValue: " + exitVal );
        }
    }

    /**
     * initial method to unzip the archive file
     * 
     * @return =0 Unzipped without errors; !=0
     */
    protected void extractArchive( ) throws Exception {

        ZipFile zf = new ZipFile( szPathToZip.toString( ) );
        String extractPath = new String( szextractPath.toString( ) );
        Enumeration zipEnum = zf.entries( );
        String dir = new String( "." );

        dir = extractPath.replace( '\\', '/' );
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, dir );
        }
        if ( dir.charAt( dir.length( ) - 1 ) != '/' ) {
            dir += "/";
        }
        File directory = new File( dir );
        directory.mkdir( );

        while ( zipEnum.hasMoreElements( ) ) {
            ZipEntry item = (ZipEntry) zipEnum.nextElement( );

            if ( item.isDirectory( ) ) // Directory
            {
                File newdir = new File( dir + item.getName( ) );
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Creating directory " + newdir + ".." );
                }
                newdir.mkdir( );
            } else // File
            {
                String newfile = dir + item.getName( );
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Writing " + newfile + ".." );
                }

                InputStream is = zf.getInputStream( item );
                FileOutputStream fos = new FileOutputStream( newfile );

                int ch;

                while ( ( ch = is.read( ) ) != -1 ) {
                    fos.write( ch );
                }

                is.close( );
                fos.close( );
            }
        }

        zf.close( );
    }

    /**
     * This method iterates above all files in the given extractionpath and
     * deletes them, afterwards the given folder is deleted as well
     */
    protected void deleteAll( ) {

        String tempstring = new String( szextractPath.toString( ) );
        tempstring.replace( "\\", "/" );
        File extractroot = new File( tempstring );
        if ( extractroot.isDirectory( ) ) {
            File[] array = extractroot.listFiles( );
            int x = 0;
            while ( x <= ( array.length ) - 1 ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, array[x].getName( ) + " found, now deleting!" );
                }
                this.delete( array[x] );
                x++;
            }

        }
    }

    /**
     * called by deleteall(), this is the iterating delet function
     * 
     * @param file absolute path to the file that you want to delete
     */
    private void delete( File file ) {

        if ( file.isDirectory( ) ) {
            File[] array = file.listFiles( );
            int x = 0;
            while ( x <= ( array.length ) - 1 ) {
                String filename = new String( array[x].getName( ) );
                // System.out.println(filename);
                if ( array[x].isDirectory( ) ) {
                    this.delete( array[x] );
                    if ( array[x].delete( ) == false ) {
                        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                            logger.trace( MoinSeverity.DEBUG, "Directory " + filename + " could not be deleted!" );
                        }
                    } else {
                        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                            logger.trace( MoinSeverity.DEBUG, "Directory " + filename + " successfully deleted!" );
                        }
                    }
                } else {
                    if ( array[x].delete( ) == false ) {
                        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                            logger.trace( MoinSeverity.DEBUG, "File " + filename + " could not be deleted!" );
                        }
                    } else {
                        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                            logger.trace( MoinSeverity.DEBUG, "File " + filename + " successfully deleted!" );
                        }
                    }
                }
                x++;
            }
            String filename = new String( file.getName( ) );
            if ( file.delete( ) == false ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Directory " + filename + " could not be deleted!" );
                }
            } else {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Directory " + filename + " successfully deleted!" );
                }
            }
        } else {
            String filename = new String( file.getName( ) );
            if ( file.delete( ) == false ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "File " + filename + " could not be deleted!" );
                }
            } else {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "File " + filename + " successfully deleted!" );
                }
            }
        }
    }
}
