package com.sap.tc.moin.repository.test.jmitck;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;
import com.sap.tc.moin.repository.test.jmitck.vendorwrapper.Generator;

/**
 * Accesses
 */
@SuppressWarnings( "nls" )
public class RepositoryLoader {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, RepositoryLoader.class );

    private static RepositoryLoader instance;

    //    private Map repositoryMap = new HashMap();
    private String key;

    private RefPackage rp;

    private Generator generator;

    /*
     * Returns the Singleton instance. Since it will be used, it is created at
     * initialization time, rather than lazily.
     */
    public static RepositoryLoader getInstance( ) {

        return instance;
    }

    public static void init( ) {

        instance = new RepositoryLoader( );
    }

    private RefPackage createIfNecessary( String repository, String metamodel, String prefix ) {

        log.trace( MoinSeverity.DEBUG, "Test requires repository identified as " + repository + " from metamodel " + metamodel + " with prefix " + prefix );
        String newKey = metamodel + "/" + repository;
        if ( newKey.equals( key ) ) {
            log.trace( MoinSeverity.DEBUG, "Repository already present, returning an instance of " + rp.getClass( ).getName( ) + ", a RefPackage subtype implementation" );
        } else {
            if ( rp != null ) {
                getVendorGenerator( ).retire( rp );
            }
            log.trace( MoinSeverity.DEBUG, "Requires the vendor-specific wrapper code to return a " + "RefPackage subytpe implementation" );
            String packageName = Util.simpleNameOf( metamodel );
            rp = getVendorGenerator( ).createRefPackage( packageName, prefix );
            key = newKey;
            log.trace( MoinSeverity.DEBUG, "Returning the provided  " + rp.getClass( ).getName( ) + "instance" );
        }
        return rp;
    }

    /**
     * Returns a requested top-level RefPackage instance, corresponding to the
     * inputs. The returned RefPackage must correspond to the input metamodel,
     * generated using the input package prefix String. If the repository String
     * is ewqual to the repository String of the previous test (and the
     * metamodel and prefix are the same as the previous test), the RefPackage
     * used in the last test will be returned. Otherwise, a fresh RefPackage of
     * the correct type will be obtained, via the Generator interface.
     * <p>
     * Note that providing a previously used RefPackage is only for efficiency:
     * a test must never count on the results of a previous test. To be more
     * efficient, a TestFinder could be developed which grouped tests by
     * metamodel and repository id, to minimize code generation and RefPackage
     * (extent) setup. If test execution efficiency is no issue, the
     * implementation of this method could ignore the repository input an always
     * return a new RefPackage.
     * 
     * @param repository a <code>String</code> value
     * @param metamodel a <code>String</code> value
     * @param prefix a <code>String</code> value
     * @return a <code>RefPackage</code> value
     */
    public RefPackage getRep( String repository, String metamodel, String prefix ) {

        return createIfNecessary( repository, metamodel, prefix );
    }

    /**
     * Returns the Generator implementation for the test run.
     * 
     * @return the <code>Generator</code> interface implementation.
     */
    public Generator getVendorGenerator( ) {

        if ( generator == null ) {
            generator = MetamodelLoader.getInstance( ).getVendorGenerator( );
        }
        return generator;
    }

}
