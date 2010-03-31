package com.sap.tc.moin.repository.test.performance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerator;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class MassGeneratorTest extends MoinTestCase {

    private long fileNano = 0l;

    private long templateNano = 0l;

    private Map<String, File> directories = new HashMap<String, File>( );

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

        String pkgName = System.getProperty( "jmiConvertPackageName" );
        String mdlName = System.getProperty( "jmiConvertMetamodelName" );
        if ( pkgName == null ) {
            System.out.println( "No package name in System parameter \"jmiConvertPackageName\", using default (\"Model\")" );
            pkgName = "Model";
        }
        if ( mdlName == null ) {
            System.out.println( "No metamodel name in System parameter \"jmiConvertMetamodelName\", using default (\"sap.com/tc/moin/mof_1.4\")" );
            mdlName = "sap.com/tc/moin/mof_1.4";
        }
        System.out.println( "Converting package \"" + pkgName + "\" of metamodel " + mdlName );

        String apiPath = System.getProperty( "targetPathApi" );
        if ( apiPath == null ) {
            System.out.println( "No directory specified in System parameter \"targetPathApi\", writing output to console only" );
        } else {
            System.out.println( "Writing API files to path " + apiPath );
        }

        String corePath = System.getProperty( "targetPathCore" );
        if ( corePath == null ) {
            System.out.println( "No directory specified in System parameter \"targetPathCore\", writing output to console only" );
        } else {
            System.out.println( "Writing Core files to path " + corePath );
        }

        ModelPartition partition = ( (Partitionable) this.createConnection( ).getPackage( null, pkgName ).refMetaObject( ) ).get___Partition( );
        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
        partitions.add( partition );

        long start = System.nanoTime( );

        // Generator oldgen = new Generator();
        // oldgen.generateJmi("c:\\tmp\\gen", partition.getElements(), true,
        // GenerationKind.INTERFACE, System.out);

        JmiGenerator gen = new JmiGenerator( getTestHelper( ).getCoreConnection( createConnection( ) ) );
        List<JmiGeneratorModelElementWrapper> pkgs = gen.createObjectList( mdlName, partitions );
        List<JmiGeneratorPathCodePair> allGenerated = new ArrayList<JmiGeneratorPathCodePair>( );

        for ( JmiGeneratorModelElementWrapper root : pkgs ) {
            allGenerated.addAll( root.createCode( JmiGenerationKind.interfaceFilter( ) ) );
        }

        for ( JmiGeneratorPathCodePair pair : allGenerated ) {
            writeFile( pair, apiPath );
        }
        System.out.println( "Interfaces Generated: " + allGenerated.size( ) );
        allGenerated.clear( );

        for ( JmiGeneratorModelElementWrapper root : pkgs ) {
            allGenerated.addAll( root.createCode( JmiGenerationKind.implementationFilter( ) ) );
        }

        for ( JmiGeneratorPathCodePair pair : allGenerated ) {
            writeFile( pair, corePath );
        }
        long time = System.nanoTime( ) - start;

        System.out.println( "Implementations Generated: " + allGenerated.size( ) );
        System.out.println( "Total time: " + time / 1000000 + " ms" );
        System.out.println( "Template calculation time: " + this.templateNano / 1000000 + " ms" );
        System.out.println( "FileWriter time: " + this.fileNano / 1000000 + " ms" );

    }

    // private void collectGeneration(List<JmiGeneratorPathCodePair> results,
    // JmiGeneratorModelElementWrapper node,
    // JmiGenerationKind[] genKinds) {
    //
    // results.addAll(node.createCode(genKinds));
    //
    // Enumeration<TreeNode> childnodes = node.children();
    // while (childnodes.hasMoreElements()) {
    // TreeNode child = childnodes.nextElement();
    // if (child instanceof JmiGeneratorModelElementWrapper) {
    // ModelElement childElement = ((JmiGeneratorModelElementWrapper)
    // child).getModelElement();
    // if (childElement instanceof MofPackage) {
    // MofPackage pkg = (MofPackage) childElement;
    // if (pkg.refImmediateComposite() == null) {
    // continue;
    // }
    // }
    // collectGeneration(results, (JmiGeneratorModelElementWrapper) child,
    // genKinds);
    // }
    // }
    // }

    private void writeFile( JmiGeneratorPathCodePair pair, String targetPath ) throws IOException {

        if ( null != targetPath ) {
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
}
