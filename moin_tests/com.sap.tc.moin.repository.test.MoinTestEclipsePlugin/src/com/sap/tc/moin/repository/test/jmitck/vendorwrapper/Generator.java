package com.sap.tc.moin.repository.test.jmitck.vendorwrapper;

import java.io.File;
import java.util.Properties;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.XmiReader;

/**
 * Interface for interacting with the code generation features of different
 * vendors' implementations of JMI.
 * <p>
 * These methods are necessary for the TCK to gain access to objects, for which
 * JMI has not specified the means of access.
 */
public interface Generator {

    /**
     * Perform any required iniialization of the generator.
     * 
     * @param p properties loaded from a properties file, if provided by the
     * vendor (may be null)
     * @param rootDir the root directory for the Javatest execution
     */
    public void init( Properties p, File rootDir );

    /**
     * Returns a top-level RefPackage, as idenitified by the argument. The
     * top-level RefPackage corresponds to a top-level Model.Package in a
     * metamodel. The identifier may be implementation-specific, but must
     * uniquely identify the RefPackage. If the RefPackage does not exist, the
     * implementation may either return null, or create a new instance and
     * return it.
     * 
     * @param id uniquely identifies a RefPackage
     * @return a <code>RefPackage</code> instance
     */

    /**
     * Returns a new RefPackage, returning a unique identifier, which can be
     * used to access the new RefPackage.
     * 
     * @param packageName the name of the Model.Package defining the RefPackage
     * @param prefix the package prefix used in code generation (as defined by a
     * tag in the metamodel)
     * @return a unique identifier, which can be used to retrieve the new
     * RefPackage.
     */
    public RefPackage createRefPackage( String packageName, String prefix );

    /**
     * Return an object which implements the XmiReader interface.
     * 
     * @return a <code>XmiReader</code> value
     */
    public XmiReader createXmiReader( );

    /**
     * Clean-up after a list of RefPackage instances, after completion of a
     * test. An implementation is given the oportunity to remove objects created
     * in the extents as the result of the test, or perform any other useful
     * cleanup. No action is necessary; however, cleanup activities may avoid
     * issues such as running out of memory, failing subsequent tests due to a
     * previous test failure that corrupts an extent, etc.
     * 
     * @param refPackages a list of the RefPackages that were created for a
     * test.
     */
    public void retire( RefPackage refPackage );

}
