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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class SuiteSyntheticWithSchedulingQueryTest extends BaseSyntheticQueryTest {

	public SuiteSyntheticWithSchedulingQueryTest(Integer ratio) {

		// if the ratio is negative, it means that the scheduling optimizer should be turned off
		int ratioInt = ratio.intValue();

		if (ratioInt < 0) {
			this.withOptimization = false;
			this.dirtyPartitionsRatio = -ratioInt;
		} else {
			this.withOptimization = true;
			this.dirtyPartitionsRatio = ratioInt;
		}
	}

	@BeforeClass
	static public void setTestSuiteParameters() throws Exception {

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

		BaseSyntheticQueryTest.beforeQueryTests(true);
	}

	@AfterClass
	static public void afterQueryTests() throws Exception {

		BaseSyntheticQueryTest.afterQueryTests(true);
	}

	@Parameters
	public static LinkedList<Object> queryTestData() {

		LinkedList<Object> params = new LinkedList<Object>();
		params.add(new Integer[] { 8 });
		params.add(new Integer[] { 5 });
		params.add(new Integer[] { 4 });
		params.add(new Integer[] { -4 });
		params.add(new Integer[] { 3 });
		params.add(new Integer[] { 2 });

		return params;
	}

	@Test
	public void test_basic_get_attributes_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes_ast());
	}

	@Test
	public void test_basic_get_attributes_limited() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes_limited());
	}

	@Test
	public void test_basic_get_attributes_with_comparison() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes_with_comparison());
	}

	@Test
	public void test_basic_get_attributes_with_reflect_element() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes_with_reflect_element());
	}

	@Test
	public void test_where_not_like() throws Exception {

		assertTrue("ResultSet is not correct", super.where_not_like());
	}

	@Test
	public void test_where_not_like_and_not_null_check() throws Exception {

		assertTrue("ResultSet is not correct", super.where_not_like_and_not_null_check());
	}

	@Test
	public void test_double_assoc_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.double_assoc_ast());
	}

	@Test
	public void test_double_assoc_with_comparison() throws Exception {

		assertTrue("ResultSet is not correct", super.double_assoc_with_comparison());
	}

	@Test
	public void test_double_assoc_variant() throws Exception {

		assertTrue("ResultSet is not correct", super.double_assoc_variant());
	}

	@Test
	public void test_double_paired_assocs() throws Exception {

		assertTrue("ResultSet is not correct", super.double_paired_assocs());
	}

	@Test
	public void test_nested_query_with_reference_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference_ast());
	}

	@Test
	@Ignore("Unnecessary")
	public void test_nested_query_with_reference_in_other_direction() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference_in_other_direction());
	}

	@Test
	public void test_nested_query_with_reference_variant() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference_variant());
	}

	@Test
	public void test_nested_query_with_reference_and_not() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference_and_not());
	}

	@Test
	public void test_complex_assoc_linear_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_linear_ast());
	}

	@Test
	public void test_complex_assoc_grid_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_grid_ast());
	}

	@Test
	public void test_where_with_three_comparisons_limited() throws Exception {

		assertTrue("ResultSet is not correct", super.where_with_three_comparisons_limited());
	}

	@Test
	public void test_complex_assoc_grid_with_attr_comparisons() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_grid_with_attr_comparisons());
	}

	@Test
	public void test_complex_grid_assoc_with_string_comparisons() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_grid_assoc_with_string_comparisons());
	}

	@Test
	public void test_complex_assoc_linear_with_many_selections_limited() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_linear_with_many_selections_limited());
	}

	@Test
	public void test_complex_assoc_grid_with_structureTypes() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_grid_with_structureTypes());
	}

	@Test
	public void test_complex_grid_assoc_with_fixed_set_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_grid_assoc_with_fixed_set_ast());
	}

	@Test
	public void test_select_multivalued_attributes_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.select_multivalued_attributes_ast());
	}

	@Test
	public void test_assoc_with_struct_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_struct_ast());
	}

	@Test
	public void test_assoc_with_nested_struct_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_nested_struct_ast());
	}

	@Test
	public void test_assoc_with_class_typed_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_class_typed_ast());
	}

	@Test
	public void test_assoc_with_dirty_partition_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_dirty_partition_ast());
	}

	@Test
	@Ignore("Unnecessary")
	public void test_assoc_with_dirty_partition_in_other_direction() throws Exception {

		//        assertTrue( "ResultSet is not correct", super.assoc_with_dirty_partition_in_other_direction( ) );
	}

	@Test
	public void test_complex_assoc_linear_with_many_selections_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_linear_with_many_selections_ast());
	}

	@Test
	public void test_partition_scope_in_query_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.partition_scope_in_query_ast());
	}

	@Test
	public void test_assoc_with_two_comparisons_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_two_comparisons_ast());
	}

	@Test
	public void test_assoc_with_two_comparisons_variant() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_two_comparisons_variant());
	}

	@Test
	@Ignore("Ignored because of the exclusive/inclusive scope discussion.")
	public void test_execute_with_exclusive_scope_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.execute_with_exclusive_scope_ast());
	}

	@Test
	public void test_assoc_to_subclass_of_reflect_element_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_to_subclass_of_reflect_element_ast());
	}

	@Test
	public void test_assoc_to_reflect_element() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_to_reflect_element());
	}

	@Test
	public void test_assoc_with_multiple_selection_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_multiple_selection_ast());
	}

	@Test
	public void test_enum_comparisons_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.enum_comparisons_ast());
	}

	@Test
	public void test_dirty_dominant_simple_scheduling() throws Exception {

		assertTrue("ResultSet is not correct", super.enforced_simple_scheduling());
	}

	@Test
	public void test_dirty_dominant_simple_scheduling_2() throws Exception {

		assertTrue("ResultSet is not correct", super.enforced_simple_scheduling_2());
	}

	@Test
	public void test_dirty_dominant_simple_scheduling_3() throws Exception {

		assertTrue("ResultSet is not correct", super.enforced_simple_scheduling_3());
	}

	@Test
	public void test_dirty_dominant_scheduling() throws Exception {

		assertTrue("ResultSet is not correct", super.enforced_scheduling());
	}

	@Test
	public void test_dirty_dominant_scheduling_2() throws Exception {

		assertTrue("ResultSet is not correct", super.enforced_scheduling_2());
	}

	@Test
	public void test_dirty_dominant_scheduling_3() throws Exception {

		assertTrue("ResultSet is not correct", super.enforced_scheduling_3());
	}

	@Test
	public void test_reflect_element_compared_with_fixed_set() throws Exception {

		assertTrue("ResultSet is not correct", super.reflect_element_compared_with_fixed_set());
	}
}
