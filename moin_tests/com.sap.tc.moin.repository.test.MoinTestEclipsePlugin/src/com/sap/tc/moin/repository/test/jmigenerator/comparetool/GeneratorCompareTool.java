package com.sap.tc.moin.repository.test.jmigenerator.comparetool;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.impl.ConnectionImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerator;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class GeneratorCompareTool extends MoinTestCase {

    class StreamGobbler extends Thread {

        public List<String> lines = new ArrayList<String>( );

        InputStream is;

        String type;

        StreamGobbler( InputStream is, String type ) {

            this.is = is;
            this.type = type;
        }

        @Override
        public void run( ) {

            try {
                InputStreamReader isr = new InputStreamReader( is );
                BufferedReader br = new BufferedReader( isr );
                String line = null;
                while ( ( line = br.readLine( ) ) != null ) {
                    lines.add( line );
                }
            } catch ( IOException ioe ) {
                ioe.printStackTrace( );
            }
        }
    }

    private long fileNano = 0l;

    private long templateNano = 0l;

    private Map<String, File> directories = new HashMap<String, File>( );

    private CompareToolMain myDialog;

    public final static String[] MMNAMES = new String[] { TestMetaModels.COMPANY, TestMetaModels.GFW, TestMetaModels.JMI_TCK, TestMetaModels.SERVICE_INTERACTIONS, TestMetaModels.TESTCASES, TestMetaModels.TEXT_VERTICALIZATION };

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

    }

    @Test
    public void testGenerator( ) throws Exception {

        this.myDialog = new CompareToolMain( this );
        this.myDialog.setSize( new Dimension( 500, 600 ) );
        this.myDialog.setModal( true );
        this.myDialog.setVisible( true );
    }

    public void generate( boolean all ) throws Exception {

        Properties props = this.myDialog.myProperties;

        String newPath = props.getProperty( CompareToolMain.PROP_NEWPATH, "" ) + File.separator + "src";
        String oldPath = props.getProperty( CompareToolMain.PROP_OLDPATH, "" ) + File.separator + "src";

        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
        ConnectionImpl connImpl = (ConnectionImpl) ( (Wrapper) createConnection( ) ).unwrap( );
        Connection conn = createConnection( );
        if ( all ) {
            try {
                RefPackage[] tlp = connImpl.getTopLevelPackages( );
                for ( int i = 0; i < tlp.length; i++ ) {
                    String name = (String) tlp[i].refMetaObject( ).refGetValue( "name" );
                    System.out.println( "Package: " + name );
                    RefPackage pkg = conn.getPackage( null, name );
                    ModelPartition p = ( (Partitionable) pkg.refMetaObject( ) ).get___Partition( );
                    partitions.add( p );
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
            }

        } else {
            RefPackage pkg = conn.getPackage( null, props.getProperty( CompareToolMain.PROP_PKGNAME ) );
            ModelPartition p = ( (Partitionable) pkg.refMetaObject( ) ).get___Partition( );
            partitions.add( p );
        }

        this.directories.clear( );

        boolean cleanup = Boolean.valueOf( props.getProperty( CompareToolMain.PROP_CLEANUP, "false" ) );
        if ( cleanup ) {
            System.out.println( "Target folders will be cleaned up before generation" );
        } else {
            System.out.println( "Target folders will not be cleaned up before generation" );
        }

        boolean generateInterface = Boolean.valueOf( props.getProperty( CompareToolMain.PROP_GENINTERFACE, "false" ) );
        boolean generateImpl = Boolean.valueOf( props.getProperty( CompareToolMain.PROP_GENIMPL, "false" ) );
        boolean generateWrapper = Boolean.valueOf( props.getProperty( CompareToolMain.PROP_GENWRAPPER, "false" ) );

        if ( generateInterface ) {
            System.out.println( "Interfaces will be generated" );
        } else {
            System.out.println( "Interfaces will not be generated" );
        }

        if ( generateImpl ) {
            System.out.println( "Implementations will be generated" );
        } else {
            System.out.println( "Implementations will not be generated" );
        }

        if ( generateWrapper ) {
            System.out.println( "Wrappers will be generated" );
        } else {
            System.out.println( "Wrappers will not be generated" );
        }

        if ( cleanup ) {
            cleanup( oldPath, newPath );
        }

        long start = System.nanoTime( );

        JmiGenerator newGen = new JmiGenerator( connImpl );
        List<JmiGeneratorModelElementWrapper> wrappers = newGen.createObjectList( null, partitions );

        List<JmiGeneratorPathCodePair> allGenerated = new ArrayList<JmiGeneratorPathCodePair>( );
        if ( generateInterface ) {
            for ( JmiGeneratorModelElementWrapper wrapper : wrappers ) {
                allGenerated.addAll( wrapper.createCode( JmiGenerationKind.interfaceFilter( ) ) );
            }
        }
        if ( generateImpl ) {
            for ( JmiGeneratorModelElementWrapper wrapper : wrappers ) {
                allGenerated.addAll( wrapper.createCode( JmiGenerationKind.implementationFilter( ) ) );
            }
        }
        if ( generateWrapper ) {
            for ( JmiGeneratorModelElementWrapper wrapper : wrappers ) {
                allGenerated.addAll( wrapper.createCode( JmiGenerationKind.wrapperFilter( ) ) );
            }
        }

        for ( JmiGeneratorPathCodePair pair : allGenerated ) {
            writeFile( pair, newPath );
        }

        long ms = ( System.nanoTime( ) - start ) / 1000000;
        System.out.println( "Template based generator took " + ms + " ms" );
        start = System.nanoTime( );

        Set elements = new HashSet( );
        for ( ModelPartition p : partitions ) {
            elements.addAll( p.getElements( ) );
        }

        ms = ( System.nanoTime( ) - start ) / 1000000;
        System.out.println( "MMR based generator took " + ms + " ms" );
    }

    public void compareFiles( ) {

        System.out.println( "Start compare" );
        Properties props = this.myDialog.myProperties;

        String newPath = props.getProperty( CompareToolMain.PROP_NEWPATH, "" ) + File.separator + "bin";
        String oldPath = props.getProperty( CompareToolMain.PROP_OLDPATH, "" ) + File.separator + "bin";

        List<String> messages = new ArrayList<String>( );

        compareDirectory( new File( oldPath ), oldPath, new File( newPath ), newPath, messages );

        System.out.println( "" );

        for ( String message : messages ) {
            System.out.println( message );
        }
        System.out.println( "End compare" );
    }

    private void compareDirectory( File oldPath, String oldRoot, File newPath, String newRoot, List<String> messages ) {

        File[] oldChildren = oldPath.listFiles( );
        File[] newChildren = newPath.listFiles( );
        System.out.print( '.' );
        if ( oldChildren == null && newChildren == null ) {
            return;
        }

        if ( oldChildren != null && newChildren != null ) {
            if ( oldChildren.length != newChildren.length ) {
                messages.add( oldPath.getPath( ) + " has " + oldChildren.length + " children, " + newPath.getPath( ) + " has " + newChildren.length );
                return;
            }
            for ( int i = 0; i < oldChildren.length; i++ ) {
                if ( oldChildren[i].isDirectory( ) && newChildren[i].isDirectory( ) ) {
                    compareDirectory( oldChildren[i], oldRoot, newChildren[i], newRoot, messages );
                } else if ( oldChildren[i].isFile( ) && newChildren[i].isFile( ) ) {
                    compareFile( oldChildren[i], newChildren[i], messages );
                } else {
                    messages.add( "File/Directory mismatch" );
                }
            }
        }

        if ( oldChildren == null ) {
            messages.add( "No children under" + oldPath.getPath( ) + ", but under " + newPath.getPath( ) );
            return;
        }

        if ( newChildren == null ) {
            messages.add( "No children under" + newPath.getPath( ) + ", but under " + oldPath.getPath( ) );
            return;
        }

    }

    private void compareFile( File oldFile, File newFile, List<String> messages ) {

        try {
            List<String> oldLines = getJavapLines( oldFile );
            List<String> newLines = getJavapLines( newFile );

            if ( oldLines.size( ) == newLines.size( ) ) {
                System.out.print( '+' );
            } else {
                messages.add( "Line numbers differ: " + oldFile.getName( ) );
                List<String> test = new ArrayList<String>( );

                test.addAll( oldLines );
                test.removeAll( newLines );
                if ( !test.isEmpty( ) ) {
                    messages.add( "Extra old lines" );
                    messages.addAll( test );
                }

                test.clear( );
                test.addAll( newLines );
                test.removeAll( oldLines );
                if ( !test.isEmpty( ) ) {
                    messages.add( "Extra new lines" );
                    messages.addAll( test );
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace( );
            messages.add( "Exception from javap: " + e.getMessage( ) );
        }
    }

    private List<String> getJavapLines( File file ) throws IOException {

        try {
            String pathName = file.getCanonicalPath( ).substring( 0, file.getCanonicalPath( ).lastIndexOf( '.' ) );
            String dirname = pathName.substring( 0, pathName.lastIndexOf( '\\' ) );
            String className = pathName.substring( pathName.lastIndexOf( '\\' ) + 1 );

            // String[] commands = new String[] { "cmd.exe", "/C", "dir \"" +
            // className + "\"" };
            String[] commands = new String[] { "javap", "-private", className };

            Process proc = Runtime.getRuntime( ).exec( commands, new String[0], new File( dirname ) );
            // any error message?
            StreamGobbler errorGobbler = new StreamGobbler( proc.getErrorStream( ), "ERROR" );

            // any output?
            StreamGobbler outputGobbler = new StreamGobbler( proc.getInputStream( ), "OUTPUT" );

            // kick them off
            errorGobbler.start( );
            outputGobbler.start( );

            // any error???
            int exitVal = proc.waitFor( );
            if ( exitVal != 0 ) {
                throw new RuntimeException( "javap process returned exit value " + exitVal + " " + file.getPath( ) );
            }

            return outputGobbler.lines;
        } catch ( RuntimeException e ) {
            e.printStackTrace( );
            throw e;
        } catch ( InterruptedException e ) {
            System.err.println( "Interrupted" );
        }
        return new ArrayList<String>( );

    }

    private void writeFile( JmiGeneratorPathCodePair pair, String targetPath ) throws IOException {

        if ( null != targetPath && targetPath.length( ) > 0 ) {
            long start = System.nanoTime( );
            String code = pair.getCode( );
            this.templateNano += ( System.nanoTime( ) - start );
            StringBuilder fullpath = new StringBuilder( targetPath );
            for ( String comp : pair.getRelativePath( ) ) {
                fullpath.append( File.separator );
                fullpath.append( comp );
            }

            File directory = this.directories.get( fullpath.toString( ) );
            if ( directory == null ) {
                directory = new File( targetPath );
                for ( String dir : pair.getRelativePath( ) ) {
                    String[] subdirs = directory.list( );
                    if ( subdirs == null ) {
                        File childDirectory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                        childDirectory.mkdirs( );
                        directory = childDirectory;
                        continue;
                    }
                    boolean found = false;
                    for ( int i = 0; i < subdirs.length; i++ ) {
                        if ( subdirs[i].equals( dir ) ) {
                            directory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                            found = true;
                            continue;
                        }
                    }
                    if ( !found ) {
                        File childDirectory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                        childDirectory.mkdirs( );
                        directory = childDirectory;
                        continue;
                    }

                }

                this.directories.put( fullpath.toString( ), directory );

            }

            String filepath = directory.getPath( ) + File.separator + pair.getFileName( ) + ".java";
            File prog = new File( filepath );
            prog.createNewFile( );

            start = System.nanoTime( );

            FileWriter w = new FileWriter( prog );
            BufferedWriter bw = new BufferedWriter( w );
            bw.write( code );

            this.fileNano += ( System.nanoTime( ) - start );
            bw.close( );
            w.close( );

        } else {
            System.out.println( pair.getCode( ).toString( ) );
        }
    }

    public String[] getPackageNames( ) {

        try {
            ConnectionImpl conn = (ConnectionImpl) ( (Wrapper) createConnection( ) ).unwrap( );
            RefPackage[] pkgs = conn.getTopLevelPackages( );
            String[] pkgnames = new String[pkgs.length];
            for ( int i = 0; i < pkgs.length; i++ ) {
                pkgnames[i] = (String) pkgs[i].refMetaObject( ).refGetValue( "name" );
            }
            return pkgnames;
        } catch ( Exception e ) {
            e.printStackTrace( );
            return null;
        }
    }

    private void cleanup( String oldPath, String newPath ) {

        if ( oldPath.length( ) > 0 ) {
            System.out.println( "Deleting files from " + oldPath + " ..." );
            File directory = new File( oldPath );
            if ( directory.exists( ) ) {
                File[] children = directory.listFiles( );
                if ( children != null ) {
                    for ( int i = 0; i < children.length; i++ ) {
                        deleteChildren( children[i] );
                    }
                }
            }
        }
        if ( newPath.length( ) > 0 ) {
            System.out.println( "Deleting files from " + newPath + " ..." );
            File directory = new File( newPath );
            if ( directory.exists( ) ) {
                File[] children = directory.listFiles( );
                if ( children != null ) {
                    for ( int i = 0; i < children.length; i++ ) {
                        deleteChildren( children[i] );
                    }
                }
            }
        }
    }

    private void deleteChildren( File directoryOrFile ) {

        if ( directoryOrFile.isDirectory( ) ) {
            File[] children = directoryOrFile.listFiles( );
            if ( children != null ) {
                for ( int i = 0; i < children.length; i++ ) {
                    deleteChildren( children[i] );
                }
            }
        }
        directoryOrFile.delete( );

    }
}
