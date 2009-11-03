package com.sap.tc.moin.repository.test.jmitck;

import java.io.File;
import java.util.Properties;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.PathClassLoader;
import com.sap.tc.moin.repository.test.jmitck.vendorwrapper.Generator;

/**
 * Load up classes generated from metamodels, by creating new Classloaders for
 * each metamodel. This is a singleton class, with early initialization
 */
@SuppressWarnings( "nls" )
public class MetamodelLoader {

    // Keys for extracting from the TestEnvironment
    public static final String GENERATOR_CLASSPATH_KEY = "generator.genClasspath";

    public static final String GENERATOR_IMPL_KEY = "generator.genclass";

    public static final String GENERATOR_TARGET_CP_KEY = "generator.genBuildTargetLoc";

    public static final String GENERATOR_PROPS_KEY = "generator.genPropFile";

    // added in order to avoid jti file
    public static final String GENERATOR_BUILD_TARGET_LOC = "classes";

    private static final I18NResourceBundle i18n = I18NResourceBundle.getBundleForClass( MetamodelLoader.class );

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, MetamodelLoader.class );

    private static MetamodelLoader instance;

    private String currentMetamodel = "[NONE]";

    private ClassLoader currentClassLoader;

    private File rootDir;

    private TestEnvironment env;

    private Generator generator;

    /*
     * Returns the Singleton instance. Since it will be used, it is created at
     * initialization time, rather than lazily.
     */
    public static MetamodelLoader getInstance( ) {

        return instance;
    }

    /**
     * Initialize the instance
     * 
     * @param te the <code>TestEnvironment</code> instance for the test run
     * @param rootDirectory the root directory of the jmitck test environment
     */
    public static void init( TestEnvironment te, File rootDirectory ) {

        instance = new MetamodelLoader( te, rootDirectory );
    }

    private MetamodelLoader( TestEnvironment env, File rootDirectory ) {

        this.env = env;
        this.rootDir = rootDirectory;
    }

    /**
     * Determines, based on the input metamodel, whether a new metamodel needs
     * to be loaded and processed. If the metamodel specified by the input is
     * different that the metamodel required of the last test case, the XMI is
     * loaded up and the interfaces (and possibly implemetations) are generated.
     * 
     * @param metamodel the metamodel required for this test.
     * @param interfaceOnly set to true, if only the interfaces are required
     * (but not the implementation).
     * @return the ClassLoader for the test.
     */
    public ClassLoader loadIfNecessary( String metamodel ) {

        if ( currentMetamodel.equals( metamodel ) ) {
            return currentClassLoader;
        }
        currentMetamodel = metamodel;
        currentClassLoader = new PathClassLoader( rootDir, GENERATOR_BUILD_TARGET_LOC );
        return currentClassLoader;
    }

    /**
     * Returns the current ClassLoader in use
     * 
     * @return a <code>ClassLoader</code> value
     */
    public ClassLoader getCurrentLoader( ) {

        return currentClassLoader;
    }

    /**
     * Returns the vendor-specific implementation of the Generator interface
     * 
     * @return a <code>Generator</code> value
     */
    public Generator getVendorGenerator( ) {

        if ( generator != null ) {
            return generator;
        }
        try {
            generator = JmiGenerator.class.newInstance( );
        } catch ( InstantiationException ie ) {
            log.trace( ie, MoinSeverity.ERROR, "" );
            throw new TestErrorException( i18n, "mm.genNotInit", "com.sap.tc.moin.repository.test_jmitck.JmiGenerator" );
        } catch ( IllegalAccessException iae ) {
            log.trace( iae, MoinSeverity.ERROR, "" );
            throw new TestErrorException( i18n, "mm.genInitNoAccess", "com.sap.tc.moin.repository.test_jmitck.JmiGenerator" );
        }
        Properties vendorProps = null;
        generator.init( vendorProps, rootDir );
        return generator;
    }

    /**
     * Returns the property held by the TestEnvironment corresponding to the
     * input key.
     * <p>
     * The TestEnvironment uses (key, String[]) pairs, but we're never
     * interested in arrays of Strings. This method adds convenience, and deals
     * with the rather unexpected throwing of an exception when a property isn't
     * found.
     * 
     * @param key the property key
     * @return the property, or null if not found
     */
    public String getProperty( String key ) {

        try {
            String answer = null;
            String[] valueSet = env.lookup( key );
            if ( ( valueSet != null ) && ( valueSet.length > 0 ) ) {
                answer = valueSet[0];
            }
            return answer;
        } catch ( TestEnvironment.Fault tef ) {
            log.trace( tef, MoinSeverity.ERROR, "" );
            return null;
        }
    }
}
