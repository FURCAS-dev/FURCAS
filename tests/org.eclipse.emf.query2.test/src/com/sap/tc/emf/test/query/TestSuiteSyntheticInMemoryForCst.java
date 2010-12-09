/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package com.sap.tc.emf.test.query;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class TestSuiteSyntheticInMemoryForCst extends BaseSyntheticQueryTest {

    public TestSuiteSyntheticInMemoryForCst( Integer ratio ) {

        this.dirtyPartitionsRatio = ratio.intValue( );
    }

    @BeforeClass
    static public void setTestSuiteParameters( ) throws Exception {

        // set the static parameters for the test
        mmSize = 10;
        attrSize = 9;
        instSize = 10;
        partSize = 10;

        partitionNameAppendix = "";
        partitionScope = null;
        partitionScopeInclusive = true;

        createDirtyData = true;
        createObjValAttrs = true;

        BaseSyntheticQueryTest.beforeQueryTests( true );
    }

    @Parameters
    public static LinkedList<Object> queryTestData( ) {

        LinkedList<Object> params = new LinkedList<Object>( );
        params.add( new Integer[] { 1 } );
        return params;
    }

    @AfterClass
    static public void afterQueryTests( ) throws Exception {

        BaseSyntheticQueryTest.afterQueryTests( true );
    }

    @Test
    public void test_basic_get_attributes_with_removal( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.basic_get_attributes_with_removal( ) );
    }

    @Test
    public void test_like_and_not_like_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.like_and_not_like_2( ) );
    }

    @Test
    public void test_where_not_like_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.where_not_like_2( ) );
    }

    @Test
    public void test_double_assoc_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.double_assoc_2( ) );
    }

    @Test
    public void test_double_assoc_3( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.double_assoc_3( ) );
    }

    @Test
    public void test_string_null_comparison_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.string_null_comparison_2( ) );
    }

    @Test
    public void test_string_not_null_comparison_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.string_not_null_comparison_2( ) );
    }

    @Test
    public void test_empty_string_comparison_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.empty_string_comparison_2( ) );
    }

    @Test
    public void test_nested_query_with_reference_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.nested_query_with_reference_2( ) );
    }

    @Test
    public void test_nested_query_with_reference_and_not_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.nested_query_with_reference_and_not_2( ) );
    }

    @Test
    public void test_nested_query_with_assoc_end_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.nested_query_with_assoc_end_2( ) );
    }


    @Test
    public void test_where_with_three_comparisons_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.where_with_three_comparisons_2( ) );
    }


    @Test
    public void test_double_assoc_variant( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.double_assoc_variant( ) );
    }


    @Test
    public void test_nested_query_with_reference_variant( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.nested_query_with_reference_variant( ) );
    }

    @Test
    public void test_assoc_with_two_comparisons_variant( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.assoc_with_two_comparisons_variant( ) );
    }

    @Test
    public void test_basic_get_attributes_with_reflect_element( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.basic_get_attributes_with_reflect_element( ) );
    }

    @Test
    public void test_reflect_element_compared_with_fixed_set_2( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.reflect_element_compared_with_fixed_set_2( ) );
    }

    @Test
    public void test_incompatible_types_return_empty_result( ) throws Exception {

        assertTrue( "ResultSet is not correct", super.incompatible_types_return_empty_result( ) );
    }

}
