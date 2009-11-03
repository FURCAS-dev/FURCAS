package com.sap.tc.moin.test.fw.build;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.test.testcase.MoinTestCase;

public class MoinBuildBaseTest extends MoinTestCase {

    // the singleton instance
    private static MoinBuildTestHelper _instance;

//    protected TestClient _testClient1;
//
//    private ModelPartition _partitionOne;
//
//    private ModelPartition _partitionTwo;
//
    /**
     * Makes the helper available. We have to distinguish here if we are running
     * in the IDE as plugin test or as standalone test.
     */
    public static MoinBuildTestHelper getTestHelper( ) {

        if ( _instance == null ) {
            _instance = MoinBuildTestHelper.getInstance( );
        }
        return _instance;
    }


    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
//        _testClient1 = getTestHelper( ).getDefaultTestClient( true );
//        _testClient1.setAsCurrentClient( );
//        _partitionOne = _testClient1.getOrCreatePartition( "partition_1" );
//        _partitionTwo = _testClient1.getOrCreatePartition( "partition_2" );
//        boolean needsSaving = false;
//        if ( !_partitionOne.getElements( ).isEmpty( ) ) {
//            _partitionOne.deleteElements( );
//            needsSaving = true;
//        }
//        if ( !_partitionTwo.getElements( ).isEmpty( ) ) {
//            _partitionTwo.deleteElements( );
//            needsSaving = true;
//        }
//        if ( needsSaving ) {
//            _testClient1.getConnection( ).save( );
//        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

//        _partitionOne = null;
//        _partitionTwo = null;
//        if ( _testClient1 != null ) {
//            _testClient1.clear( );
//            _testClient1 = null;
//        }
        // clean handling of Moin reset.
        super.afterTestMethod( );
    }

//    public Connection getMOINConnection( ) {
//
//        _testClient1.setAsCurrentClient( );
//        return _testClient1.getConnection( );
//    }
//
//    public ModelPartition getPartitionOne( ) {
//
//        return _partitionOne;
//    }
//
//    public ModelPartition getPartitionTwo( ) {
//
//        return _partitionTwo;
//    }

}
