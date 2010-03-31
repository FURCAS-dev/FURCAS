package com.sap.tc.moin.repository.test.jmigenerator.standalone;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.sap.junit.MoinParameterizedRunner;
import com.sap.junit.MoinParameterizedRunner.ParametersDescription;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.repository.jmigenerator.controller.DoNothingTimerCallback;
import com.sap.tc.moin.repository.jmigenerator.controller.LogCallback;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * This class generates and compiles an arbitrary metamodel via the JDK 6 Java
 * Compiler API.
 * <p>
 * The tests and the code herein (see comment lines beginning with "// enable
 * this line when JDK 6 is available") can be enabled as soon as JDK 6 is
 * centrally available.
 * <p>
 * TODO Currently the classpath for the Java compiler is hard coded and runs
 * only on one single workstation. This has to be changed in the way that the
 * classpath is determined from the current class loader, e.g. from the Eclipse
 * project when running in Eclipse.
 */
@RunWith( MoinParameterizedRunner.class )
public class TestGenerateMoinMetamodelsStandalone extends CoreMoinTest implements LogCallback {

//    private static final String PATH_MOIN_API = "C:\\japro\\MOIN\\moin\\moin.api\\CoreDev_stream\\gen\\dbg\\java\\packaged\\public\\_tc.moin.libraries.api\\tc.moin.libraries.api.jar";
//
//    private static final String PATH_MOIN_SPI = "C:\\japro\\MOIN\\moin\\moin.spi\\CoreDev_stream\\gen\\dbg\\java\\packaged\\public\\_tc.moin.libraries.spi\\tc.moin.libraries.spi.jar";
//
//    private static final String PATH_MOIN_JMI = "C:\\japro\\MOIN\\moin\\moin.jmicore\\CoreDev_stream\\gen\\dbg\\java\\packaged\\public\\_tc.moin.libraries.jmi\\tc.moin.libraries.jmi.jar";
//
//    // necessary for metamodel testcases foundation
//    private static final String PATH_MOIN_METAMODEL_TEXTVERTICALIZATION = "C:\\japro\\MOIN\\moin\\moin.metamodels\\CoreDev_stream\\gen\\dbg\\java\\packaged\\public\\_tc~moin~textverticalization\\tc~moin~textverticalization_public.jar";
//
//    // necessary for metamodel testcases
//    private static final String PATH_MOIN_METAMODEL_TESTCASES_FOUNDATION = "C:\\japro\\MOIN\\moin\\moin.test\\CoreDev_stream\\gen\\dbg\\java\\packaged\\public\\_tc~moin~testcases~foundation1.0\\tc~moin~testcases~foundation1.0~testcasesfoundation_public.jar";

    private String rootFolder = "";

    private MetamodelGenerator generator = null;

    private String metamodelContainerName = "";

    public TestGenerateMoinMetamodelsStandalone( String aMetamodelContainerName ) throws IllegalArgumentException {

        if ( aMetamodelContainerName == null || aMetamodelContainerName.length( ) == 0 ) {
            throw new IllegalArgumentException( "The metamodel container name can not be null or empty" );
        }
        String rootFolderProp = System.getProperty( "com.sap.tc.moin.jmigenerator.rootFolder" );
        if ( rootFolderProp != null ) {
            rootFolder = rootFolderProp;
        } else {
            rootFolder = System.getProperty( "java.io.tmpdir" ) + File.separator + "moin";
        }
        generator = new MetamodelGenerator( rootFolder, new DoNothingTimerCallback( ), this );
        metamodelContainerName = aMetamodelContainerName;
    }

    @Test
    public void testGenerationAndCompilation( ) throws Exception {

        CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        String sourcepath = generator.getTargetSourcePath( metamodelContainerName );
        info( "Generating JMI classes for metamodel: " + metamodelContainerName + " into folder " + sourcepath );
        List<JmiGeneratorPathCodePair> pathCodePairs = generator.generate( conn, metamodelContainerName, JmiGenerationKind.values( ) );
        List<String> sources = new ArrayList<String>( );
        for ( JmiGeneratorPathCodePair pathCodePair : pathCodePairs ) {
            if ( pathCodePair.getFileExtension( ).equals( "java" ) ) {
                // only Java source files have to be compiled
                String filePath = sourcepath + File.separator + toString( pathCodePair.getRelativePath( ), File.separator );
                sources.add( filePath + File.separator + pathCodePair.getFileName( ) + "." + pathCodePair.getFileExtension( ) );
            }
        }
        info( "Compilation of JMI classes is currently disabled" );

// TODO enable this test as soon as JDK 6 is available

//        info( "Compiling JMI classes" );
//        if ( sources.size( ) != 0 ) {
//            int resultCode = 0;
//            // enable this line when JDK 6 is available
//            //            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//            List<String> arguments = new ArrayList<String>( );
//            String[] classpath = new String[] { PATH_MOIN_API, PATH_MOIN_SPI, PATH_MOIN_JMI, PATH_MOIN_METAMODEL_TEXTVERTICALIZATION, PATH_MOIN_METAMODEL_TESTCASES_FOUNDATION };
//            //            arguments.add("-verbose");
//            arguments.add( "-classpath" );
//            arguments.add( toString( classpath, ";" ) );
//            arguments.add( "-sourcepath" );
//            arguments.add( sourcepath );
//            arguments.addAll( sources );
//            info( "Calling Java compiler with command line: " + toString( arguments, " " ) );
//            // enable this line when JDK 6 is available
//            //            resultCode = compiler.run(null, null, null, arguments.toArray(new String[0]));
//            if ( resultCode != 0 ) {
//                errorAndStop( "Compilation failed" );
//            } else {
//                info( "Compilation finished successfully" );
//            }
//        } else {
//            warn( "No JMI classes generated, compilation not necessary" );
//        }
    }

    @Parameters
    public static List<String[]> getMetamodelContainerNames( ) throws Exception {

        List<String[]> metamodelContainerNames = new ArrayList<String[]>( );
        Set<String> names = new HashSet<String>( Arrays.asList( getAllAvailableMetamodelContainerNames( ) ) );
        for ( Iterator<String> iterator = names.iterator( ); iterator.hasNext( ); ) {
            metamodelContainerNames.add( new String[] { iterator.next( ) } );
        }
        return metamodelContainerNames;
    }

    @ParametersDescription
    public static List<String> getMetamodelContainerNameDescriptions( ) throws Exception {

        Set<String> names = new HashSet<String>( Arrays.asList( getAllAvailableMetamodelContainerNames( ) ) );
        return new ArrayList<String>( names );
    }

    private static String[] getAllAvailableMetamodelContainerNames( ) throws Exception {

        Collection<MetaModelInfo> availableMetaModels = getTestHelper( ).getCoreMoin( ).getMetamodelCatalog( ).getMetaModelList( );
        String[] metamodelContainerNames = new String[availableMetaModels.size( ) + 1];
        int i = 0;
        // add mof manually as runtime host doesn't have it in its catalog
        metamodelContainerNames[i++] = TestMetaModels.MOIN_MOF_CN;
        for ( MetaModelInfo metaModelInfo : availableMetaModels ) {
            metamodelContainerNames[i++] = metaModelInfo.getContainerName( );
        }
        return metamodelContainerNames;
    }

    private String toString( String[] strings, String separator ) {

        String string = "";
        for ( int i = 0; i < strings.length; i++ ) {
            string += strings[i];
            if ( i != strings.length - 1 ) {
                string += separator;
            }
        }
        return string;
    }

    private String toString( List<String> strings, String separator ) {

        return toString( strings.<String> toArray( new String[0] ), separator );
    }

    public void log( String message ) {

        info( message );
    }

    public void logThrowable( Throwable throwable ) {

        log( throwable.getMessage( ) );
    }

    public void logWarn( String message ) {

        log( message );
    }

    public void logInfo( String message ) {

        log( message );
    }

    public void logError( String message ) {

        log( message );
    }
}
