package com.sap.tc.moin.repository.test.s2x;

import java.io.File;

import com.sap.tc.moin.repository.ModelPartition;

/**
 * Tis class contains tests that test the correct editing, creation, deletion
 * and versioning state of the generated S2X file per partition.
 * <p>
 * It is subclassed by test classes that test the above mentioned file handling
 * for the use cases partition edit, create and delete.
 * <p>
 * The initial state of each test in the sub classes is that no partition file
 * and no S2X file exist (see {@link #afterTestMethod()}).
 */
public abstract class TestS2XSerializerExistenceAndVersioning extends TestS2XSerializerAbstract {

    protected ModelPartition partition = null;

    protected File s2xFile = null;

    @Override
    public void afterTestMethod( ) throws Exception {
        // build the initial state for each test
        // clean up the partition and the S2X file
        if ( partition != null && partition.isAlive( ) ) {
            partition.delete( );
            getMoinConnection( ).save( );
        }
        partition = null;
        if ( s2xFile != null ) {
            // to be sure :)
            s2xFile.delete( );
        }
        s2xFile = null;
        super.afterTestMethod( );
    }
}
