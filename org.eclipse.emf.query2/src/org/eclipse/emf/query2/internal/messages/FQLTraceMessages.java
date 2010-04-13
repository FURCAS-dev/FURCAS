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
package org.eclipse.emf.query2.internal.messages;

import org.eclipse.emf.query2.exception.ExternalizedString;
import org.eclipse.emf.query2.internal.localization.ExternalizedResourceBundleAccessor;

/**
 * <p>
 * <p>
 * Externalized Messages in alphabetical order:
 * <ol>
 * <li>MQL_Processor_BQL_memory_execution_done_XMSG: MQL Processor: ... BQL
 * memory execution done!</li>
 * <li>MQL_Processor_first_part_of_node_query_is_empty_XMSG: MQL Processor: ...
 * first part of node query is empty.</li>
 * <li>MQL_Processor_second_part_of_node_query_is_empty_XMSG: MQL Processor: ...
 * second part of node query is empty.</li>
 * <li>MQL_Processor_Aborted_execution_of_query_XMSG: MQL Processor: Aborted
 * execution of query: {0} {1}</li>
 * <li>MQL_Processor_BQL_estimation_finished_in_XMSG: MQL Processor: BQL
 * estimation finished in {0} ms.</li>
 * <li>MQL_Processor_BQL_estimation_produced_following_query_XMSG: MQL
 * Processor: BQL estimation produced following query: \n {0}</li>
 * <li>MQL_Processor_BQL_in_memory_execution_finished_XMSG: MQL Processor: BQL
 * in-memory execution finished in {0} ms.</li>
 * <li>MQL_Processor_BQL_memory_engine_constructs_cluster_XMSG: MQL Processor:
 * BQL memory engine constructs cluster...</li>
 * <li>MQL_Processor_BQL_memory_engine_evaluates_cluster_XMSG: MQL Processor:
 * BQL memory engine evaluates cluster...</li>
 * <li>MQL_Processor_BQL_query_of_nature_refAllOfType_refAllOfClass_fast_slim_index_execution_possible_XMSG
 * : MQL Processor: BQL query of nature refAllOfType/refAllOfClass (fast slim
 * index execution possible).</li>
 * <li>MQL_Processor_BQL_translation_produced_query_XMSG: MQL Processor: BQL
 * translation produced query: {0}</li>
 * <li>MQL_Processor_BQL_verification_finished_XMSG: MQL Processor: BQL
 * verification finished in {0} ms.</li>
 * <li>MQL_Processor_Collection_estimation_XMSG: MQL Processor: Collection
 * estimation in {0} ms.</li>
 * <li>MQL_Processor_Compare_elements_in_sets_XMSG: MQL Processor: Compare {0}
 * of the element {1} from First Set with element {2} from Second Set for {3}</li>
 * <li>MQL_Processor_Cross_link_estimation_XMSG: MQL Processor: Cross-link
 * estimation in {0} ms.</li>
 * <li>MQL_Processor_Executed_leaf_query_in_service_XMSG: MQL Processor:
 * Executed leaf query in {0} ms in {1} service</li>
 * <li>MQL_Processor_Executed_node_query_XMSG: MQL Processor: Executed node
 * query in {0} ms.</li>
 * <li>MQL_Processor_Executed_union_query_XMSG: MQL Processor: Executed union
 * query in {0} ms.</li>
 * <li>MQL_Processor_Executing_first_part_of_node_query_XMSG: MQL Processor:
 * Executing first part of node query...</li>
 * <li>MQL_Processor_Executing_following_leaf_query_in_service_XMSG: MQL
 * Processor: Executing following leaf query in {0} service: {1} {2}</li>
 * <li>MQL_Processor_Executing_following_node_query_XMSG: MQL Processor:
 * Executing following node query: {0} {1}</li>
 * <li>MQL_Processor_Executing_following_union_query_XMSG: MQL Processor:
 * Executing following union query: {0} {1}</li>
 * <li>MQL_Processor_Executing_second_part_of_node_query_XMSG: MQL Processor:
 * Executing second part of node query...</li>
 * <li>MQL_Processor_Execution_START_XMSG: MQL Processor: Execution START.</li>
 * <li>MQL_Processor_Execution_STOP_XMSG: MQL Processor: Execution STOP.</li>
 * <li>MQL_Processor_First_Result_Set_of_size_XMSG: MQL Processor: First Result
 * Set of size {0} \: {1} {2}</li>
 * <li>
 * MQL_Processor_Found_warnings_during_preparation_of_the_following_query_XMSG:
 * MQL Processor: Found warnings during preparation of the following query: {0}
 * {1}</li>
 * <li>MQL_Processor_Further_pre_processing_of_internal_query_XMSG: MQL
 * Processor: Further pre-processing of internal query: {0} {1}</li>
 * <li>MQL_Processor_Instance_estimation_in_XMSG: MQL Processor: Instance
 * estimation in {0} ms.</li>
 * <li>MQL_Processor_Internal_query_after_adjusting_structure_type_scope_XMSG:
 * MQL Processor: Internal query after adjusting structure type scope: {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_breaking_up_according_to_graph_XMSG:
 * MQL Processor: Internal query after breaking up according to graph: {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_compressing_node_queries_XMSG: MQL
 * Processor: Internal query after compressing node queries : {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_expansions_XMSG: MQL Processor:
 * Internal query after expansions: {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_facility_assignment_XMSG: MQL
 * Processor: Internal query after facility assignment: {0} {1}</li>
 * <li>
 * MQL_Processor_Internal_query_after_optimizing_non_dirty_partition_scope_XMSG:
 * MQL Processor: Internal query after optimizing non-dirty partition scope: {0}
 * {1}</li>
 * <li>MQL_Processor_Internal_query_after_query_spreading_XMSG: MQL Processor:
 * Internal query after query spreading: {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_removing_empty_parts_XMSG: MQL
 * Processor: Internal query after removing empty parts: {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_removing_transient_partitions_XMSG:
 * MQL Processor: Internal query after removing transient partitions: {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_removing_type_comparisons_XMSG: MQL
 * Processor: Internal query after removing type comparisons : {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_splitting_XMSG: MQL Processor:
 * Internal query after splitting: {0} {1}</li>
 * <li>
 * MQL_Processor_Internal_query_after_steering_appart_multiple_associations_XMSG
 * : MQL Processor: Internal query after steering appart multiple associations:
 * {0} {1}</li>
 * <li>MQL_Processor_Internal_query_after_translating_and_verifying_scope_XMSG:
 * MQL Processor: Internal query after translating and verifying scope: {0} {1}</li>
 * <li>MQL_Processor_Interpreting_query_XMSG: MQL Processor: Interpreting query:
 * {0} {1}</li>
 * <li>MQL_Processor_Joining_Result_Sets_XMSG: MQL Processor: Joining Result
 * Sets:</li>
 * <li>MQL_Processor_Loading_partition_time_XMSG: MQL Processor: Loading
 * partition {0} in {1} ms.</li>
 * <li>MQL_Processor_No_optimization_of_relevant_partition_scope_because_the_number_of_relevant_partitions_exceeds_threshold_XMSG
 * : MQL Processor: No optimization of relevant partition scope because the
 * number of relevant partitions ({0}) is larger than the threshold ({1})</li>
 * <li>MQL_Processor_Number_of_elements_in_partition_exceeds_threshold_XMSG: MQL
 * Processor: Number of elements ({0}) in relevant partition {1} exceeds the
 * threshold ({2})</li>
 * <li>MQL_Processor_Obtained_for_connection_XMSG: MQL Processor: Obtained for
 * connection {0}</li>
 * <li>MQL_Processor_Optimization_of_relevant_partition_scope_because_the_number_of_relevant_partitions_smaller_than_threshold_XMSG
 * : MQL Processor: Optimization of relevant partition scope because the number
 * of relevant partitions ({0}) is smaller than the threshold ({1})</li>
 * <li>MQL_Processor_Preparation_START_ast_XMSG: MQL Processor: Preparation
 * START - ast.</li>
 * <li>MQL_Processor_Preparation_START_cst_XMSG: MQL Processor: Preparation
 * START - cst.</li>
 * <li>MQL_Processor_Preparation_STOP_XMSG: MQL Processor: Preparation STOP.</li>
 * <li>MQL_Processor_Preparation_finished_XMSG: MQL Processor: Preparation
 * finished in {0} ms and produced {1} {2}</li>
 * <li>MQL_Processor_Putting_fix_order_on_result_set_XMSG: MQL Processor:
 * Putting fix order on result set in {0} ms.</li>
 * <li>MQL_Processor_Query_execution_finished_XMSG: MQL Processor: Query
 * execution finished in {0} ms.</li>
 * <li>MQL_Processor_Query_preparation_aborted_XMSG: MQL Processor: Query
 * preparation aborted: {0} {1}</li>
 * <li>MQL_Processor_Query_produced_result_set_XMSG: MQL Processor: Query {0}
 * {1} {2}... produced the following result set ...{3} {4}</li>
 * <li>MQL_Processor_Registering_MqlQueryService_based_on_the_Facility_Query_Language_for_facility_XMSG
 * : MQL Processor: Registering MqlQueryService based on the Facility Query
 * Language for facility {0} and for connection {1}</li>
 * <li>MQL_Processor_Registering_MqlQueryService_based_on_the_Full_Index_for_facility_XMSG
 * : MQL Processor: Registering MqlQueryService based on the Full Index for
 * facility {0} and for connection {1}</li>
 * <li>MQL_Processor_Registering_MqlQueryService_based_on_the_Slim_Index_for_facility_XMSG
 * : MQL Processor: Registering MqlQueryService based on the Slim Index for
 * facility {0} and for connection {1}</li>
 * <li>MQL_Processor_Registering_MqlQueryService_based_on_the_Slim_Variant_Index_for_facility_XMSG
 * : MQL Processor: Registering MqlQueryService based on the Slim Variant Index
 * for facility {0} and for connection {1}</li>
 * <li>MQL_Processor_Scheduling_query_XMSG: MQL Processor: Scheduling query: {0}
 * {1}</li>
 * <li>MQL_Processor_Second_Result_Set_of_size_XMSG: MQL Processor: Second
 * Result Set of size {0} \: {1} {2}</li>
 * <li>MQL_Processor_Selecting_position_from_set_XMSG: MQL Processor: Selecting
 * position {0} from Set {1} into {2}</li>
 * <li>MQL_Processor_Syntactic_parsing_of_cst_query_XMSG: MQL Processor:
 * Syntactic parsing of cst query: {0} {1}</li>
 * <li>MQL_Processor_Target_Result_Set_XMSG: MQL Processor: Target Result Set:
 * {0} {1}</li>
 * <li>MQL_Processor_The_following_query_has_type_errors_XMSG: MQL Processor:
 * The following query has type errors: {0} {1}</li>
 * <li>MQL_Processor_The_relevant_partitions_for_scheduling_are_upgraded_from_the_dirty_partitions_to_the_loaded_partitions_XMSG
 * : MQL Processor: The relevant partitions for scheduling are upgraded from the
 * dirty partitions to the loaded partitions</li>
 * <li>MQL_Processor_Type_and_format_checking_of_ast_query_XMSG: MQL Processor:
 * Type and format checking of ast query: {0} {1}</li>
 * <li>MQL_Processor_User_provided_global_execution_scope_is_inclusive_and_defined_over_XMSG
 * : MQL Processor: User-provided global execution scope is inclusive and
 * defined over</li>
 * <li>MQL_Processor_User_provided_global_execution_scope_is_not_inclusive_and_defined_over_XMSG
 * : MQL Processor: User-provided global execution scope is not inclusive and
 * defined over</li>
 * <li>MQL_Processor_current_dirty_and_non_empty_transient_partitions_XMSG: MQL
 * Processor: current dirty and non-empty transient partitions:</li>
 * <li>MQL_Processor_current_dirty_partitions_XMSG: MQL Processor: current dirty
 * partitions:</li>
 * <li>MQL_Processor_current_loaded_partitions_XMSG: MQL Processor: current
 * loaded partitions:</li>
 * <li>MQL_Processor_query_does_not_parse_XMSG: MQL Processor: {0} {1} {2} does
 * not parse</li>
 * <li>MQL_parser_parses_XMSG: MQL parser parses: {0} {1}</li>
 * <li>MQL_Parse_time_XMSG: Parse time : {0} ms.</li>
 * <li>MQL_Processor_dirty_partition_XMSG: Partition {0} is dirty</li>
 * <li>MQL_Processor_dirty_or_not_empty_transient_partition_XMSG: Partition {0}
 * is dirty or not-empty transient</li>
 * <li>MQL_Processor_loaded_partition_XMSG: Partition {0} is loaded</li>
 * <li>Unable_to_resolve_object_linked_by_via_association_XMSG: Unable to
 * resolve object {0} linked by {1} via association {2}</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from FQLTraceMessages.properties
 */

public enum FQLTraceMessages implements ExternalizedString {

	/**
	 * Message: "Parse time : {0} ms."
	 */
	MQL_PARSE_TIME("MQL_Parse_time_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Aborted execution of query: {0} {1}"
	 */
	MQL_PROCESSOR_ABORTED_EXECUTION_OF_QUERY("MQL_Processor_Aborted_execution_of_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: BQL estimation finished in {0} ms. "
	 */
	MQL_PROCESSOR_BQL_ESTIMATION_FINISHED_IN("MQL_Processor_BQL_estimation_finished_in_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: BQL estimation produced following query: \n {0}"
	 */
	MQL_PROCESSOR_BQL_ESTIMATION_PRODUCED_FOLLOWING_QUERY("MQL_Processor_BQL_estimation_produced_following_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: BQL in-memory execution finished in {0} ms."
	 */
	MQL_PROCESSOR_BQL_IN_MEMORY_EXECUTION_FINISHED("MQL_Processor_BQL_in_memory_execution_finished_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: BQL memory engine constructs cluster..."
	 */
	MQL_PROCESSOR_BQL_MEMORY_ENGINE_CONSTRUCTS_CLUSTER("MQL_Processor_BQL_memory_engine_constructs_cluster_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: BQL memory engine evaluates cluster..."
	 */
	MQL_PROCESSOR_BQL_MEMORY_ENGINE_EVALUATES_CLUSTER("MQL_Processor_BQL_memory_engine_evaluates_cluster_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: ... BQL memory execution done!"
	 */
	MQL_PROCESSOR_BQL_MEMORY_EXECUTION_DONE("MQL_Processor_BQL_memory_execution_done_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: BQL query of nature refAllOfType/refAllOfClass (fast slim index execution possible)."
	 */
	MQL_PROCESSOR_BQL_QUERY_OF_NATURE_REFALLOFTYPE_REFALLOFCLASS_FAST_SLIM_INDEX_EXECUTION_POSSIBLE(
			"MQL_Processor_BQL_query_of_nature_refAllOfType_refAllOfClass_fast_slim_index_execution_possible_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: BQL translation produced query: {0}"
	 */
	MQL_PROCESSOR_BQL_TRANSLATION_PRODUCED_QUERY("MQL_Processor_BQL_translation_produced_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: BQL verification finished in {0} ms."
	 */
	MQL_PROCESSOR_BQL_VERIFICATION_FINISHED("MQL_Processor_BQL_verification_finished_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Collection estimation in {0} ms."
	 */
	MQL_PROCESSOR_COLLECTION_ESTIMATION("MQL_Processor_Collection_estimation_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Compare {0} of the element {1} from First Set with element {2} from Second Set for {3}"
	 */
	MQL_PROCESSOR_COMPARE_ELEMENTS_IN_SETS("MQL_Processor_Compare_elements_in_sets_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Cross-link estimation in {0} ms."
	 */
	MQL_PROCESSOR_CROSS_LINK_ESTIMATION("MQL_Processor_Cross_link_estimation_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Executed leaf query in {0} ms in {1} service"
	 */
	MQL_PROCESSOR_EXECUTED_LEAF_QUERY_IN_SERVICE("MQL_Processor_Executed_leaf_query_in_service_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Executed node query in {0} ms."
	 */
	MQL_PROCESSOR_EXECUTED_NODE_QUERY("MQL_Processor_Executed_node_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Executed union query in {0} ms."
	 */
	MQL_PROCESSOR_EXECUTED_UNION_QUERY("MQL_Processor_Executed_union_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Executing first part of node query..."
	 */
	MQL_PROCESSOR_EXECUTING_FIRST_PART_OF_NODE_QUERY("MQL_Processor_Executing_first_part_of_node_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Executing following leaf query in {0} service: {1} {2}"
	 */
	MQL_PROCESSOR_EXECUTING_FOLLOWING_LEAF_QUERY_IN_SERVICE("MQL_Processor_Executing_following_leaf_query_in_service_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Executing following node query: {0} {1}"
	 */
	MQL_PROCESSOR_EXECUTING_FOLLOWING_NODE_QUERY("MQL_Processor_Executing_following_node_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Executing following union query: {0} {1}"
	 */
	MQL_PROCESSOR_EXECUTING_FOLLOWING_UNION_QUERY("MQL_Processor_Executing_following_union_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Executing second part of node query..."
	 */
	MQL_PROCESSOR_EXECUTING_SECOND_PART_OF_NODE_QUERY("MQL_Processor_Executing_second_part_of_node_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Execution START."
	 */
	MQL_PROCESSOR_EXECUTION_START("MQL_Processor_Execution_START_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Execution STOP."
	 */
	MQL_PROCESSOR_EXECUTION_STOP("MQL_Processor_Execution_STOP_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: First Result Set of size {0} \: {1} {2}"
	 */
	MQL_PROCESSOR_FIRST_RESULT_SET_OF_SIZE("MQL_Processor_First_Result_Set_of_size_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Found warnings during preparation of the following query: {0} {1}"
	 */
	MQL_PROCESSOR_FOUND_WARNINGS_DURING_PREPARATION_OF_THE_FOLLOWING_QUERY(
			"MQL_Processor_Found_warnings_during_preparation_of_the_following_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Further pre-processing of internal query: {0} {1}"
	 */
	MQL_PROCESSOR_FURTHER_PRE_PROCESSING_OF_INTERNAL_QUERY("MQL_Processor_Further_pre_processing_of_internal_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Instance estimation in {0} ms."
	 */
	MQL_PROCESSOR_INSTANCE_ESTIMATION_IN("MQL_Processor_Instance_estimation_in_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after adjusting structure type scope: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_ADJUSTING_STRUCTURE_TYPE_SCOPE(
			"MQL_Processor_Internal_query_after_adjusting_structure_type_scope_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after breaking up according to graph: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_BREAKING_UP_ACCORDING_TO_GRAPH(
			"MQL_Processor_Internal_query_after_breaking_up_according_to_graph_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after compressing node queries : {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_COMPRESSING_NODE_QUERIES("MQL_Processor_Internal_query_after_compressing_node_queries_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Internal query after expansions: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_EXPANSIONS("MQL_Processor_Internal_query_after_expansions_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after facility assignment: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_FACILITY_ASSIGNMENT("MQL_Processor_Internal_query_after_facility_assignment_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Internal query after optimizing non-dirty partition scope: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_OPTIMIZING_NON_DIRTY_PARTITION_SCOPE(
			"MQL_Processor_Internal_query_after_optimizing_non_dirty_partition_scope_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Internal query after query spreading: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_QUERY_SPREADING("MQL_Processor_Internal_query_after_query_spreading_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after removing empty parts: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_REMOVING_EMPTY_PARTS("MQL_Processor_Internal_query_after_removing_empty_parts_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after removing transient partitions: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_REMOVING_TRANSIENT_PARTITIONS(
			"MQL_Processor_Internal_query_after_removing_transient_partitions_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after removing type comparisons : {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_REMOVING_TYPE_COMPARISONS("MQL_Processor_Internal_query_after_removing_type_comparisons_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Internal query after splitting: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_SPLITTING("MQL_Processor_Internal_query_after_splitting_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Internal query after steering appart multiple associations: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_STEERING_APPART_MULTIPLE_ASSOCIATIONS(
			"MQL_Processor_Internal_query_after_steering_appart_multiple_associations_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Internal query after translating and verifying scope: {0} {1}"
	 */
	MQL_PROCESSOR_INTERNAL_QUERY_AFTER_TRANSLATING_AND_VERIFYING_SCOPE(
			"MQL_Processor_Internal_query_after_translating_and_verifying_scope_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Interpreting query: {0} {1}"
	 */
	MQL_PROCESSOR_INTERPRETING_QUERY("MQL_Processor_Interpreting_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Joining Result Sets:"
	 */
	MQL_PROCESSOR_JOINING_RESULT_SETS("MQL_Processor_Joining_Result_Sets_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Loading partition {0} in {1} ms."
	 */
	MQL_PROCESSOR_LOADING_PARTITION_TIME("MQL_Processor_Loading_partition_time_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: No optimization of relevant partition scope because the number of relevant partitions ({0}) is larger than the threshold ({1})"
	 */
	MQL_PROCESSOR_NO_OPTIMIZATION_OF_RELEVANT_PARTITION_SCOPE_BECAUSE_THE_NUMBER_OF_RELEVANT_PARTITIONS_EXCEEDS_THRESHOLD(
			"MQL_Processor_No_optimization_of_relevant_partition_scope_because_the_number_of_relevant_partitions_exceeds_threshold_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Number of elements ({0}) in relevant partition {1} exceeds the threshold ({2})"
	 */
	MQL_PROCESSOR_NUMBER_OF_ELEMENTS_IN_PARTITION_EXCEEDS_THRESHOLD("MQL_Processor_Number_of_elements_in_partition_exceeds_threshold_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Obtained for connection {0}"
	 */
	MQL_PROCESSOR_OBTAINED_FOR_CONNECTION("MQL_Processor_Obtained_for_connection_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Optimization of relevant partition scope because the number of relevant partitions ({0}) is smaller than the threshold ({1})"
	 */
	MQL_PROCESSOR_OPTIMIZATION_OF_RELEVANT_PARTITION_SCOPE_BECAUSE_THE_NUMBER_OF_RELEVANT_PARTITIONS_SMALLER_THAN_THRESHOLD(
			"MQL_Processor_Optimization_of_relevant_partition_scope_because_the_number_of_relevant_partitions_smaller_than_threshold_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Preparation START - ast."
	 */
	MQL_PROCESSOR_PREPARATION_START_AST("MQL_Processor_Preparation_START_ast_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Preparation START - cst."
	 */
	MQL_PROCESSOR_PREPARATION_START_CST("MQL_Processor_Preparation_START_cst_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Preparation STOP."
	 */
	MQL_PROCESSOR_PREPARATION_STOP("MQL_Processor_Preparation_STOP_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: Preparation finished in {0} ms and produced {1} {2}"
	 */
	MQL_PROCESSOR_PREPARATION_FINISHED("MQL_Processor_Preparation_finished_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Putting fix order on result set in {0} ms."
	 */
	MQL_PROCESSOR_PUTTING_FIX_ORDER_ON_RESULT_SET("MQL_Processor_Putting_fix_order_on_result_set_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Query execution finished in {0} ms."
	 */
	MQL_PROCESSOR_QUERY_EXECUTION_FINISHED("MQL_Processor_Query_execution_finished_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Query preparation aborted: {0} {1}"
	 */
	MQL_PROCESSOR_QUERY_PREPARATION_ABORTED("MQL_Processor_Query_preparation_aborted_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Query {0} {1} {2}... produced the following result set ...{3} {4}"
	 */
	MQL_PROCESSOR_QUERY_PRODUCED_RESULT_SET("MQL_Processor_Query_produced_result_set_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Registering MqlQueryService based on the Facility Query Language for facility {0} and for connection {1}"
	 */
	MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_FACILITY_QUERY_LANGUAGE_FOR_FACILITY(
			"MQL_Processor_Registering_MqlQueryService_based_on_the_Facility_Query_Language_for_facility_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Registering MqlQueryService based on the Full Index for facility {0} and for connection {1}"
	 */
	MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_FULL_INDEX_FOR_FACILITY(
			"MQL_Processor_Registering_MqlQueryService_based_on_the_Full_Index_for_facility_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Registering MqlQueryService based on the Slim Index for facility {0} and for connection {1}"
	 */
	MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_SLIM_INDEX_FOR_FACILITY(
			"MQL_Processor_Registering_MqlQueryService_based_on_the_Slim_Index_for_facility_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: Registering MqlQueryService based on the Slim Variant Index for facility {0} and for connection {1}"
	 */
	MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_SLIM_VARIANT_INDEX_FOR_FACILITY(
			"MQL_Processor_Registering_MqlQueryService_based_on_the_Slim_Variant_Index_for_facility_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Scheduling query: {0} {1}"
	 */
	MQL_PROCESSOR_SCHEDULING_QUERY("MQL_Processor_Scheduling_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Second Result Set of size {0} \: {1} {2}"
	 */
	MQL_PROCESSOR_SECOND_RESULT_SET_OF_SIZE("MQL_Processor_Second_Result_Set_of_size_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Selecting position {0} from Set {1} into {2}"
	 */
	MQL_PROCESSOR_SELECTING_POSITION_FROM_SET("MQL_Processor_Selecting_position_from_set_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Syntactic parsing of cst query: {0} {1}"
	 */
	MQL_PROCESSOR_SYNTACTIC_PARSING_OF_CST_QUERY("MQL_Processor_Syntactic_parsing_of_cst_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Target Result Set: {0} {1}"
	 */
	MQL_PROCESSOR_TARGET_RESULT_SET("MQL_Processor_Target_Result_Set_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: The following query has type errors: {0} {1}"
	 */
	MQL_PROCESSOR_THE_FOLLOWING_QUERY_HAS_TYPE_ERRORS("MQL_Processor_The_following_query_has_type_errors_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: The relevant partitions for scheduling are upgraded from the dirty partitions to the loaded partitions"
	 */
	MQL_PROCESSOR_THE_RELEVANT_PARTITIONS_FOR_SCHEDULING_ARE_UPGRADED_FROM_THE_DIRTY_PARTITIONS_TO_THE_LOADED_PARTITIONS(
			"MQL_Processor_The_relevant_partitions_for_scheduling_are_upgraded_from_the_dirty_partitions_to_the_loaded_partitions_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: Type and format checking of ast query: {0} {1}"
	 */
	MQL_PROCESSOR_TYPE_AND_FORMAT_CHECKING_OF_AST_QUERY("MQL_Processor_Type_and_format_checking_of_ast_query_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: User-provided global execution scope is inclusive and defined over"
	 */
	MQL_PROCESSOR_USER_PROVIDED_GLOBAL_EXECUTION_SCOPE_IS_INCLUSIVE_AND_DEFINED_OVER(
			"MQL_Processor_User_provided_global_execution_scope_is_inclusive_and_defined_over_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"MQL Processor: User-provided global execution scope is not inclusive and defined over"
	 */
	MQL_PROCESSOR_USER_PROVIDED_GLOBAL_EXECUTION_SCOPE_IS_NOT_INCLUSIVE_AND_DEFINED_OVER(
			"MQL_Processor_User_provided_global_execution_scope_is_not_inclusive_and_defined_over_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "MQL Processor: current dirty and non-empty transient partitions:"
	 */
	MQL_PROCESSOR_CURRENT_DIRTY_AND_NON_EMPTY_TRANSIENT_PARTITIONS("MQL_Processor_current_dirty_and_non_empty_transient_partitions_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: current dirty partitions:"
	 */
	MQL_PROCESSOR_CURRENT_DIRTY_PARTITIONS("MQL_Processor_current_dirty_partitions_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: current loaded partitions:"
	 */
	MQL_PROCESSOR_CURRENT_LOADED_PARTITIONS("MQL_Processor_current_loaded_partitions_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Partition {0} is dirty or not-empty transient"
	 */
	MQL_PROCESSOR_DIRTY_OR_NOT_EMPTY_TRANSIENT_PARTITION("MQL_Processor_dirty_or_not_empty_transient_partition_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Partition {0} is dirty"
	 */
	MQL_PROCESSOR_DIRTY_PARTITION("MQL_Processor_dirty_partition_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: ... first part of node query is empty."
	 */
	MQL_PROCESSOR_FIRST_PART_OF_NODE_QUERY_IS_EMPTY("MQL_Processor_first_part_of_node_query_is_empty_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Partition {0} is loaded"
	 */
	MQL_PROCESSOR_LOADED_PARTITION("MQL_Processor_loaded_partition_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: {0} {1} {2} does not parse"
	 */
	MQL_PROCESSOR_QUERY_DOES_NOT_PARSE("MQL_Processor_query_does_not_parse_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Processor: ... second part of node query is empty."
	 */
	MQL_PROCESSOR_SECOND_PART_OF_NODE_QUERY_IS_EMPTY("MQL_Processor_second_part_of_node_query_is_empty_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL parser parses: {0} {1}"
	 */
	MQL_PARSER_PARSES("MQL_parser_parses_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unable to resolve object {0} linked by {1} via association {2}"
	 */
	UNABLE_TO_RESOLVE_OBJECT_LINKED_BY_VIA_ASSOCIATION("Unable_to_resolve_object_linked_by_via_association_XMSG"); //$NON-NLS-1$

	private final static ExternalizedResourceBundleAccessor ACCESSOR = new ExternalizedResourceBundleAccessor(FQLTraceMessages.class);

	private final String myKey;

	private FQLTraceMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);

	}

}