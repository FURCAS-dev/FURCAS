package com.sap.tc.moin.repository.test.query;

import java.util.LinkedList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class TestSuiteSmokeQueryTests extends BaseSyntheticQueryTests {

    public TestSuiteSmokeQueryTests( Integer ratio ) {

        dirtyPartitionsRatio = ratio.intValue( );
    }

    @BeforeClass
    static public void setTestSuiteParameters( ) throws Exception {

        mmSize = 10;
        attrSize = 3;
        instSize = 8;
        partSize = 8;

        partitionNameAppendix = "";
        partitionScope = null;
        partitionScopeInclusive = true;

        createDirtyData = false;
        createObjValAttrs = false;

        BaseSyntheticQueryTests.beforeQueryTests( true );
    }

    @AfterClass
    static public void afterQueryTests( ) throws Exception {

        BaseSyntheticQueryTests.afterQueryTests( true );
    }

    @Parameters
    public static List<Object> querySmokeTestData( ) {

        List<Object> testData = new LinkedList<Object>( );
        testData.add( new Integer[] { 0 } );
        testData.add( new Integer[] { 1 } );
        testData.add( new Integer[] { 2 } );
        testData.add( new Integer[] { 4 } );
        return testData;
    }

    @Test
    public void test_basic( ) throws Exception {

        boolean correct = super.basic_get_attributes_ast( );

        assertTrue( "ResultSet is not correct", correct );
    }

    @Test
    public void test_basic_only_mris( ) throws Exception {

        boolean correct = super.basic_get_mris_ast( );

        assertTrue( "ResultSet is of wrong size", correct );
    }

    @Test
    public void test_grid_associations( ) throws Exception {

        boolean correct = super.complex_assoc_grid_ast( );

        assertTrue( "ResultSet is not correct", correct );
    }
}
