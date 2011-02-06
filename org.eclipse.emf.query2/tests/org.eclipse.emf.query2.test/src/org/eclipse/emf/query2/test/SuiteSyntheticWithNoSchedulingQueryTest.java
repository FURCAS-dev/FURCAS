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
package org.eclipse.emf.query2.test;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class SuiteSyntheticWithNoSchedulingQueryTest extends BaseSyntheticQueryTest {

	public SuiteSyntheticWithNoSchedulingQueryTest(Integer ratio) {

		this.dirtyPartitionsRatio = ratio.intValue();
	}

	@BeforeClass
	static public void setTestSuiteParameters() throws Exception {

		// set the static parameters for the test
		mmSize = 10;
		attrSize = 9;
		instSize = 10;
		partSize = 10;

		partitionNameAppendix = ""; //$NON-NLS-1$
		partitionScope = null;
		partitionScopeInclusive = true;

		createDirtyData = true;
		createObjValAttrs = true;

		BaseSyntheticQueryTest.beforeQueryTests(true);
	}

	@Parameters
	public static LinkedList<Object> queryTestData() {

		LinkedList<Object> params = new LinkedList<Object>();
		params.add(new Integer[] { 0 });
		params.add(new Integer[] { 1 });
		return params;
	}

	@AfterClass
	static public void afterQueryTests() throws Exception {

		BaseSyntheticQueryTest.afterQueryTests(true);
	}

	@Test
	public void test_basic_get_attributes_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_basic_get_attributes() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes()); //$NON-NLS-1$
	}

	@Test
	public void test_basic_get_attributes_limited() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes_limited()); //$NON-NLS-1$
	}

	@Test
	public void test_basic_get_attributes_with_comparison() throws Exception {

		assertTrue("ResultSet is not correct", super.basic_get_attributes_with_comparison()); //$NON-NLS-1$
	}

	@Test
	public void test_basic_get_mris_ast() throws Exception {

		assertTrue("ResultSet is of wrong size", super.basic_get_mris_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_basic_get_mris() throws Exception {

		assertTrue("ResultSet is of wrong size", super.basic_get_mris()); //$NON-NLS-1$
	}

	@Test
	public void test_like_and_not_like_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.like_and_not_like_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_like_and_not_like() throws Exception {

		assertTrue("ResultSet is not correct", super.like_and_not_like()); //$NON-NLS-1$
	}

	@Test
	public void test_where_not_like() throws Exception {

		assertTrue("ResultSet is not correct", super.where_not_like()); //$NON-NLS-1$
	}

	@Test
	public void test_where_not_like_and_not_null_check() throws Exception {

		assertTrue("ResultSet is not correct", super.where_not_like_and_not_null_check()); //$NON-NLS-1$
	}

	@Test
	public void test_double_assoc_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.double_assoc_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_double_assoc() throws Exception {

		assertTrue("ResultSet is not correct", super.double_assoc()); //$NON-NLS-1$
	}

	@Test
	public void test_double_assoc_with_comparison() throws Exception {

		assertTrue("ResultSet is not correct", super.double_assoc_with_comparison()); //$NON-NLS-1$
	}

	@Test
	public void test_double_paired_assocs() throws Exception {

		assertTrue("ResultSet is not correct", super.double_paired_assocs()); //$NON-NLS-1$
	}

	@Test
	public void test_string_null_comparison_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.string_null_comparison_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_string_null_comparison() throws Exception {

		assertTrue("ResultSet is not correct", super.string_null_comparison()); //$NON-NLS-1$
	}

	@Test
	public void test_string_not_null_comparison_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.string_not_null_comparison_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_string_not_null_comparison() throws Exception {

		assertTrue("ResultSet is not correct", super.string_not_null_comparison()); //$NON-NLS-1$
	}

	@Test
	public void test_empty_string_comparison_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.empty_string_comparison_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_empty_string_comparison() throws Exception {

		assertTrue("ResultSet is not correct", super.empty_string_comparison()); //$NON-NLS-1$
	}

	@Test
	public void test_nested_query_with_reference_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_nested_query_with_reference() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference()); //$NON-NLS-1$
	}

	@Test
	@Ignore("Unnecessary")
	public void test_nested_query_with_reference_in_other_direction() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference_in_other_direction()); //$NON-NLS-1$
	}

	@Test
	public void test_nested_query_with_reference_and_not() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_reference_and_not()); //$NON-NLS-1$
	}

	@Test
	public void test_nested_query_with_assoc_end_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_assoc_end_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_nested_query_with_assoc_end() throws Exception {

		assertTrue("ResultSet is not correct", super.nested_query_with_assoc_end()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_assoc_linear_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_linear_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_assoc_linear() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_linear()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_assoc_grid_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_grid_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_assoc_grid() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_grid()); //$NON-NLS-1$
	}

	@Test
	public void test_where_with_three_comparisons_limited() throws Exception {

		assertTrue("ResultSet is not correct", super.where_with_three_comparisons_limited()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_assoc_grid_with_attr_comparisons() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_grid_with_attr_comparisons()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_assoc_grid_with_structureTypes() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_grid_with_structureTypes()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_grid_assoc_with_string_comparisons() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_grid_assoc_with_string_comparisons()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_grid_assoc_with_fixed_set_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_grid_assoc_with_fixed_set_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_grid_assoc_with_fixed_set() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_grid_assoc_with_fixed_set()); //$NON-NLS-1$
	}

	@Test
	public void test_select_multivalued_attributes_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.select_multivalued_attributes_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_select_multivalued_attributes() throws Exception {

		assertTrue("ResultSet is not correct", super.select_multivalued_attributes()); //$NON-NLS-1$
	}

	@Test
	public void test_select_enum_attribute_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.select_enum_attribute_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_select_enum_attribute() throws Exception {

		assertTrue("ResultSet is not correct", super.select_enum_attribute()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_struct_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_struct_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_struct() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_struct()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_nested_struct_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_nested_struct_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_nested_struct() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_nested_struct()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_class_typed_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_class_typed_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_class_typed() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_class_typed()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_dirty_partition_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_dirty_partition_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_dirty_partition() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_dirty_partition()); //$NON-NLS-1$
	}

	@Test
	@Ignore("Unnecessary")
	public void test_assoc_with_dirty_partition_in_other_direction() throws Exception {

		//        assertTrue( "ResultSet is not correct", super.assoc_with_dirty_partition_in_other_direction( ) );
	}

	@Test
	public void test_complex_assoc_linear_with_many_selections_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_linear_with_many_selections_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_complex_assoc_linear_with_many_selections() throws Exception {

		assertTrue("ResultSet is not correct", super.complex_assoc_linear_with_many_selections()); //$NON-NLS-1$
	}

	@Test
	public void test_partition_scope_in_query_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.partition_scope_in_query_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_two_comparisons_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_two_comparisons_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_two_comparisons() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_two_comparisons()); //$NON-NLS-1$
	}

	@Test
	public void test_where_with_three_comparisons_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.where_with_three_comparisons_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_where_with_three_comparisons() throws Exception {

		assertTrue("ResultSet is not correct", super.where_with_three_comparisons()); //$NON-NLS-1$
	}

	@Test
	public void test_where_with_three_comparisons_and_or_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.where_with_three_comparisons_and_or_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_where_with_three_comparisons_and_or() throws Exception {

		assertTrue("ResultSet is not correct", super.where_with_three_comparisons_and_or()); //$NON-NLS-1$
	}

	@Test
	@Ignore("Ignored because of the exclusive/inclusive scope discussion.")
	public void test_execute_with_exclusive_scope_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.execute_with_exclusive_scope_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_reflect_element() throws Exception {

		assertTrue("ResultSet is not correct", super.reflect_element()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_to_subclass_of_reflect_element_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_to_subclass_of_reflect_element_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_to_subclass_of_reflect_element() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_to_subclass_of_reflect_element()); //$NON-NLS-1$
	}

	@Test
	public void test_reflect_element_with_fixed_set() throws Exception {

		assertTrue("ResultSet is not correct", super.reflect_element_with_fixed_set()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_to_reflect_element() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_to_reflect_element()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_multiple_selection_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_multiple_selection_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_assoc_with_multiple_selection() throws Exception {

		assertTrue("ResultSet is not correct", super.assoc_with_multiple_selection()); //$NON-NLS-1$
	}

	@Test
	public void test_enum_comparisons_ast() throws Exception {

		assertTrue("ResultSet is not correct", super.enum_comparisons_ast()); //$NON-NLS-1$
	}

	@Test
	public void test_enum_comparisons() throws Exception {

		assertTrue("ResultSet is not correct", super.enum_comparisons()); //$NON-NLS-1$
	}
}
