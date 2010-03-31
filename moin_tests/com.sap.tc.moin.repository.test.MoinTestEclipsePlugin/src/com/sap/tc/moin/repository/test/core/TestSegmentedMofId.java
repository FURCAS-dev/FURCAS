package com.sap.tc.moin.repository.test.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.testcases.case004.B4;


public class TestSegmentedMofId extends CoreMoinTest {

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        // TODO Auto-generated method stub
        super.afterTestMethod( );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        // TODO Auto-generated method stub
        super.beforeTestMethod( );
    }

    @Test
    public void testMofIdInPartition( ) throws Exception {

        ModelPartition mp = this._testClient1.createPartition( "MofIdCreationPartition" ); //$NON-NLS-1$

        byte[] prefix = getTestHelper( ).getCoreModelPartition( mp ).getPrefixForSegmentedMofIds( );
        assertNotNull( prefix );

        B4 b4 = mp.createElement( B4.class );
        String mofId = b4.get___Mri( ).getMofId( );
        assertTrue( mofId.startsWith( Utilities.CalculatedMofIdAppl.SEGMENTED.getIdString( ) ) );

        String prefixAsString = Utilities.getUtilities( ).byteArrayToString( prefix );
        assertTrue( mofId.startsWith( prefixAsString.substring( 2 ) ) );
    }

}
