package com.sap.tc.moin.facility.primary.test;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.CheckResult;
import com.sap.tc.moin.repository.core.impl.MoinCoreConsistencyChecker;
import com.sap.tc.moin.repository.core.impl.MoinImpl;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class FacilityTestCase extends MoinTestCase {

    protected TestClient _testClient1;

    protected TestClient _testClient2;

    private ModelPartition _partitionOne;

    private ModelPartition _partitionTwo;

    private ModelPartition _partitionThree;


    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        _testClient1 = getTestHelper( ).getDefaultTestClient( true );
        _testClient2 = getTestHelper( ).getDefaultTestClient( true );

        _testClient1.setAsCurrentClient( );

        _partitionOne = _testClient1.getOrCreatePartition( "partition_1" );
        _partitionTwo = _testClient1.getOrCreatePartition( "partition_2" );
        _partitionThree = _testClient1.getOrCreatePartition( "partition_3" );

        boolean needsSaving = false;

        if ( !_partitionOne.getElements( ).isEmpty( ) ) {
            _partitionOne.deleteElements( );
            needsSaving = true;
        }

        if ( !_partitionTwo.getElements( ).isEmpty( ) ) {
            _partitionTwo.deleteElements( );
            needsSaving = true;
        }

        if ( !_partitionThree.getElements( ).isEmpty( ) ) {
            _partitionThree.deleteElements( );
            needsSaving = true;
        }

        if ( needsSaving ) {
            _testClient1.getConnection( ).save( );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( MoinImpl.MOIN_CORE_CONSISTENCY_CHECKS ) {
            MoinCoreConsistencyChecker checker = new MoinCoreConsistencyChecker( getTestHelper( ).getCoreMoin( ), false /* withoutLocks */);
            CheckResult checkResult = checker.performAllChecks( );
            assertTrue( checkResult.toString( ), checkResult.isEmpty( ) );
        }

        _partitionOne = null;
        _partitionTwo = null;
        _partitionThree = null;

        if ( _testClient1 != null ) {
            _testClient1.clear( );
            _testClient1 = null;
        }

        if ( _testClient2 != null ) {
            _testClient2.clear( );
            _testClient2 = null;
        }

        // clean handling of Moin reset.
        super.afterTestMethod( );
    }

    /**
     * this._testClient1.getConnection()
     * 
     * @return
     */
    public Connection getConnectionOne( ) {

        _testClient1.setAsCurrentClient( );
        return _testClient1.getConnection( );
    }

    /**
     * this._testClient2.getConnection()
     * 
     * @return
     */
    public Connection getConnectionTwo( ) {

        _testClient2.setAsCurrentClient( );
        return _testClient2.getConnection( );
    }

    public void saveConnectionOne( ) {

        try {
            this.getConnectionOne( ).save( );
        } catch ( Exception e ) {
            errorAndStop( "Connection could not be saved.", e );
        }
    }

    public void saveConnectionTwo( ) {

        try {
            this.getConnectionTwo( ).save( );
        } catch ( Exception e ) {
            errorAndStop( "Connection could not be saved.", e );
        }
    }

    public ModelPartition getPartitionOne( ) {

        return this._partitionOne;
    }

    public ModelPartition getPartitionTwo( ) {

        return this._partitionTwo;
    }

    public ModelPartition getPartitionThree( ) {

        return this._partitionThree;
    }

    protected Workspace getClientSpecificWorkspace( Connection connection ) {

        return getTestHelper( ).getCoreConnection( connection ).getSession( ).getWorkspace( );
    }

    private Workspace getCompoundClientSpecWorkspace( Connection connection ) {

        return getTestHelper( ).getCoreConnection( connection ).getSession( ).getCompoundClientSpecWorkspace( );
    }

    protected void evictPartition( ModelPartition mp ) {

        this.getClientSpecificWorkspace( this.getConnectionOne( ) ).getPartitionManager( ).evictPartitionForced( getTestHelper( ).getCoreModelPartition( mp ) );
        this.getCompoundClientSpecWorkspace( this.getConnectionOne( ) ).getPartitionManager( ).evictPartitionForced( getTestHelper( ).getCoreModelPartition( mp ) );
    }
}
