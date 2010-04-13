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

import java.util.Locale;

import org.eclipse.emf.query2.exception.LocalizedString;
import org.eclipse.emf.query2.internal.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>RESULT_UNION_EXPECTS_AT_LEAST_TWO_OPERANDS_XMSG: A Result Union expects
 * at least two operands</li>
 * <li>SCOPE_CLAUSE_TYPE_WRONG_XMSG: A scope clause has to be a string or list
 * of IdentifierAndNodes</li>
 * <li>ALIAS_IN_REMNANT_GRAPH_WITHOUT_DOMINANCE_XMSG: Alias in remnant query has
 * to be either dominant or subdominant</li>
 * <li>TOP_LEVEL_WITHOUT_ENTRY_IN_POSITION_MAP_XMSG: All top-level select
 * entries have to have an entry in the position map at this point</li>
 * <li>ASSOC_BASED_COMPARISON_IN_NESTED_FOR_CLAUSE_XMSG: An association-based
 * comparison cannot occur nested in a for-clause</li>
 * <li>ATOMIC_ENTRY_ALREADY_IN_NODE_MAP_XMSG: Atomic entry already registered in
 * node map</li>
 * <li>ATOMIC_ETNRY_NOT_FOUND_IN_NODE_MAP_XMSG: AtomicEntry not found in nodeMap
 * </li>
 * <li>MORE_THAN_ONE_FQL_PER_FACILITY_XMSG: Attempt to register more than one
 * FQL processor for one and the same facility</li>
 * <li>BQL_EXECUTION_RETURNS_NULL_RESULT_SET_XMSG: BasicQueryResultSet returned
 * from leaf query execution returned null.</li>
 * <li>CLUSTER_EXTERNAL_LINK_WORK_ONLY_WITH_REFOBJECTS_XMSG: Cluster external
 * links work only with RefObjects, type: {0}</li>
 * <li>COMPARISON_WITH_ENTRY_OF_PAIR_FAILED_XMSG: ComparisonWithEntry of cluster
 * pair failed in crossComparisonWith entries</li>
 * <li>COULD_NOT_OBTAIN_CLASS_BASED_NODE_IN_REMNANT_GRAPH_XMSG: Could not obtain
 * a class-based node in the remnant graph</li>
 * <li>EXPECT_FOUNDMRI_NOMRI_XMSG: Expected FoundMri or NoMri</li>
 * <li>MISSING_EDGE_IN_REMANT_QUERY_XMSG: Expected at least one edge between the
 * two (non-structure-typed) nodes of a remnant query</li>
 * <li>EXPECTED_AT_LEAST_ONE_OPERAND_IN_RESULT_UNION_XMSG: Expected at least one
 * operand for ResultUnion</li>
 * <li>NO_CONNECTING_ASSOC_PREDICATE_IN_WITH_ENTRIES_XMSG: Expected found
 * connecting assoc predicate in with entries</li>
 * <li>ENTRY_OR_LIST_OF_ENTRY_EXPECTED_XMSG: Expected instance (or list) of
 * "{0}"</li>
 * <li>UNASSIGNED_GRAPH_TYPE_XMSG: Expected the first node of a leaf query to
 * have graphType assigned at this point</li>
 * <li>NON_RESTRICTED_SCOPE_FOR_FQL_QUERY_XMSG: FQL for slim index: unexpected
 * non-restricted scope for FQL query</li>
 * <li>FQL_EXECUTION_RETURNS_NULL_RESULT_SET_XMSG: FacilityQueryResultSet
 * returned from leaf query execution returned null</li>
 * <li>ATTR_VALUES_SHOULD_NOT_BE_MRIS_XMSG: FacilityQueryResultSet: Attribute
 * values must not be MRIs, but value was {0}</li>
 * <li>NUMBER_OF_ATTRS_IN_SELECT_LIST_NEGATIVE_XMSG: FacilityQueryResultSet:
 * numberOfAttributeInSelectList must not be negative, but was {0}</li>
 * <li>FIXED_ELEMENT_SET_IN_CLONING_CONSTRUCTOR_HAS_TO_BE_HASHSET_XMSG: Fixed
 * element set in cloning constructor has to be hash set</li>
 * <li>PARSING_OF_REAL_FAILED_XMSG: Float-like numeral was not parseable: {0}</li>
 * <li>NESTED_SELECT_WAS_NOT_RESET_XMSG: Found a nested select which was not
 * reset and is not a leaf query</li>
 * <li>NO_FQL_IN_POOL_XMSG: Impossible to have no FQL registered in the pool at
 * this point</li>
 * <li>EXPECTING_TWO_NON_STRUCTURE_TYPED_NODES_XMSG: In the case of remnant
 * queries, we expect exactly two (non-structure-typed) nodes</li>
 * <li>INCOMPATIBLE_FQL_IN_LEAF_QUERIES_XMSG: Incompatible FQL processors in
 * leaf query: {0} is not equal to {1}</li>
 * <li>PARSING_OF_INT_FAILED_XMSG: Integer-like numeral was not parseable: {0}</li>
 * <li>INVALID_LITERAL_TYPE_IN_OPERATION_XMSG: Invalid literal type in operation
 * </li>
 * <li>LIKE_COMPARISON_WITH_TYPES_OTHER_THAN_STRING_AND_LABELS_NOT_ALLOWED_XMSG:
 * Like comparison with types other than String and RefEnum not allowed!</li>
 * <li>MISSALIGNED_EMPTY_QUERY_IN_UNION_XMSG: Misalligned empty query in
 * ResultUnion</li>
 * <li>NO_DIRTY_DOMINANT_SCENARIO_IN_REMNANT_SITUATIONS_XMSG: No DIRTY dominant
 * scenario permitted in remnant situations</li>
 * <li>CROSS_CLUSTER_COMPARISON_WITHENTRIES_IN_ONE_CLUSTER_XMSG: No
 * cross-cluster comparisonWithEntries possible with one cluster</li>
 * <li>NO_FROM_ENTRIES_XMSG: No from entries while pretty printing</li>
 * <li>NO_QUERY_FOUND_DURING_SPREADING_OF_REMNANT_GRAPH_XMSG: No query found
 * during spreading of remnant graph</li>
 * <li>NO_SELECT_ENTRIES_XMSG: No select entries while pretty printing</li>
 * <li>NO_SUCH_ATTRIBUTE_EXPRESSION_TYPE_XMSG: No such attribute expression
 * type: {0}</li>
 * <li>NO_SUCH_LEAF_EXPRESSION_TYPE_XMSG: No such leaf expression type: {0}</li>
 * <li>NO_SUCH_LINK_CATEGORY_XMSG: No such link category</li>
 * <li>NO_SUCH_MULTINARY_ATTRIBUTE_EXPRESSION_TYPE_XMSG: No such multinary
 * attribute expression type: {0}</li>
 * <li>NO_SUCH_NAVIGATION_STEP_SOURCE_XMSG: No such navigation step source: {0}</li>
 * <li>NO_SUCH_OBJECT_TYPE_XMSG: No such object type: {0}</li>
 * <li>EXPECTED_TYPE_CLAUSE_OR_PARSED_ID_XMSG: Only TypeClause or
 * ParsedIdentifier allowed at this point</li>
 * <li>EXPECT_QUALNAMETYPE_MRIELEMENT_PARSEDIDENTIFIER_XMSG: Only expect
 * QualNameType, MriElement, or ParsedIdentifier</li>
 * <li>EQUAL_OR_NOT_EQUAL_EXPECTED_XMSG: Only expected EQUAL or NONEQUAL at this
 * point instead of {0}</li>
 * <li>UNKNOWN_OPERATOR_XMSG: Operator {0} is unknown</li>
 * <li>PROVIDED_NODE_WAS_NOT_PARTICIPATING_IN_EDGE_XMSG: Provided node was not
 * participating in the edge</li>
 * <li>RESULT_SET_OF_DIFFERENT_ROW_SIZES_XMSG: Result sets of different row
 * sizes can not be combined</li>
 * <li>SETSELECTIONS_ORDERING_WRONG_XMSG: SetSelections() has to be invoked
 * before selections can be obtained</li>
 * <li>SINGULAR_QUERY_WITH_ONLY_STRUCTURE_TYPED_ATOMIC_ENTRIES_XMSG: Singular
 * query with only structure-typed atomic entries</li>
 * <li>SOURCEOBJECT_MUST_BE_REFOBJECT_TYPE_XMSG: SourceObject must be RefObject,
 * type: {0}</li>
 * <li>MRI_IS_NOT_MOF_CLASS_XMSG: The MRI for the type of the element is not a
 * MOF Classifier</li>
 * <li>MEMORY_FQL_USED_AS_REGULAR_FQL_XMSG: The Memory Facility Query Processor
 * cannot directly be used in a facility. It has to be wrapped in another FQL
 * which determines a finite scope</li>
 * <li>PRI_DOES_NOT_EXIST_XMSG: The PRI {0} does not exist</li>
 * <li>UNEXPECTED_ASSOCIATION_END_NUMBER_XMSG: The assoc end number was {0},
 * where valid association end numbers are either 0 or 1"</li>
 * <li>LINK_TYPE_NOT_JMI_OBJECT_XMSG: The linkType {0} could not be resolved to
 * a JMI object</li>
 * <li>LINK_TYPE_NOT_ATTRIBUTE_OR_ASSOCIATION_XMSG: The linkType {0} is neither
 * of type Attribute nor of type Association"</li>
 * <li>NULL_COMPARISON_WITH_ILLEGAL_OPERATOR_XMSG: The operation {0} in a
 * WhereString cannot occur when compairing with null</li>
 * <li>UNKNOWN_PRIMITIVE_TYPE_XMSG: The primitive type {0} is not recognized</li>
 * <li>IMPOSSIBLE_TO_CREATE_CLUSTER_NAVIGATION_PLAN_XMSG: The query had no
 * cluster navigation plan</li>
 * <li>SOURCE_AE_FIXED_BUT_NOT_TARGET_AE_XMSG: The source atomic entry should
 * not be a fixed set if the target is not one</li>
 * <li>NO_CLUSTER_AVAILABLE_XMSG: There is always at least one cluster</li>
 * <li>TOP_ALIAS_NOT_SET_FOR_NODESELECTENTRY_XMSG: Top alias is not set for
 * NodeSelectEntry</li>
 * <li>TYPE_COMPARISON_NOT_SUPPORTED_XMSG: TypeComparison is currently not
 * supported. This should not pass the type checker</li>
 * <li>NON_SIMPLIFIED_NODE_IN_CLUSTER_OF_NONDIRTY_NODES_XMSG: Un-expected
 * non-simplified node in a cluster of NONDIRTY nodes</li>
 * <li>UNKNOWN_ATOMIC_ENTRY_CATEGORY_XMSG: Unexpected Atomic Entry Category: {0}
 * </li>
 * <li>UNEXPECTED_SIMPLE_COMPARISON_OPERATOR_XMSG: Unexpected
 * SimpleComparisonOperator</li>
 * <li>UNEXPECTED_TYPE_REF_AS_ARG_OF_TYPEREFERENCE_XMSG: Unexpected
 * TypeReference as argument of setTypeReference</li>
 * <li>UNEXPECTED_WHERE_NESTED_FEATURE_XMSG: Unexpected WhereNestedFeature
 * without a nested query. This might probably should be a WhereNestedAssoc</li>
 * <li>FOUND_ASSOC_PREDICATE_IN_REMNANT_GRAPH_XMSG: Unexpected assoc predicate
 * in remnant query</li>
 * <li>UNEXPECTED_COMPARATOR_STRING_BOOL_XMSG: Unexpected comparison operator
 * {0} for booleans or strings</li>
 * <li>UNEXPECTED_DIFFERENT_VALUE_TYPES_XMSG: Unexpected different value types
 * {0} and {1}</li>
 * <li>DIFFERENT_CONNECTED_NODE_IN_REMNANT_GRAPH_XMSG: Unexpected differently
 * connected node in remnant graph</li>
 * <li>UNEXPECTED_EMPTY_SCOPE_FOR_LEAF_QUERY_DURING_EXECUTION_XMSG: Unexpected
 * empty scope for leaf query during execution</li>
 * <li>UNEXPECTED_EXCLUSIVE_SCOPE_FOR_SCHEDULED_MEMORY_EXECUTION_XMSG:
 * Unexpected exclusive scope for scheduled memory execution</li>
 * <li>UNEXPECTED_NODE_CATEGORY_XMSG: Unexpected node category: {0}</li>
 * <li>ONLY_NON_LEAF_QUERIES_IN_FQL_XMSG: Unexpected non leaf query in FQL</li>
 * <li>NON_ASSIGNED_NODES_WHILE_SPREADING_XMSG: Unexpected non-assigned nodes
 * while spreading remnant query</li>
 * <li>UNEXPECTED_NON_INCLUSIVE_SCOPE_FOR_MEMORY_SCENARIO_XMSG: Unexpected
 * non-inclusive scope for memory scenario</li>
 * <li>UNEXPECTED_NON_VIRTUAL_REF_REFERRING_SELECT_ENTRY_XMSG: Unexpected
 * non-virtual type reference while redirecting select entries</li>
 * <li>UNEXPECTED_NULL_MRI_XMSG: Unexpected null MRI in FacilityQueryResultSet</li>
 * <li>UNEXPECTED_NULL_RESULT_SET_XMSG: Unexpected null result set as a result
 * from query execution</li>
 * <li>UNEXPECTED_OBJECT_TYPE_IN_PARSE_RESULT_XMSG: Unexpected object type in
 * parse result, type _XMSG= {0}</li>
 * <li>UNEXPECTED_PARSE_OBJECT_XMSG: Unexpected parse-object at this point</li>
 * <li>PARSE_POINT_UNEXPECTED_XMSG: Unexpected point reached after parsing</li>
 * <li>UNEXPECTED_SUBTYPE_XMSG: Unexpected subtype {0} for {1}</li>
 * <li>UNEXPECTED_TRUE_DIRTY_SCOPE_SIZE_XMSG: Unexpected trueDirtyScopeSize</li>
 * <li>UNEXPECTED_TYPE_IN_MRISETLINKEXPRESSION_XMSG: Unexpected type in
 * MriSetLinkExpression: {0}</li>
 * <li>UNEXPECTED_TYPE_OF_LINKEDOBJECT_CLASS_NAME_XMSG: Unexpected type of
 * linkedObject, class name= {0}</li>
 * <li>UNEXPECTED_STEP_XMSG: Unexpected type of navigation step</li>
 * <li>UNEXPECTED_UNEVALUATED_NESTED_QUERY_XMSG: Unexpected unevaluated nested
 * query. Expect LeafQuery</li>
 * <li>SPI_FACILITY_QUERY_SERVICE_EXCEPTION_XMSG: Unspecified SPI facility query
 * service exception</li>
 * <li>VIRTUAL_ATTOMIC_ATTR_REF_SHOULD_REFER_TO_TYPE_ATTR_REF_XMSG:
 * VirtualAtomicAttrReference has to refer to a TypeAttrReference</li>
 * <li>VIRTUAL_ATOMIC_ENTRY_REF_HAS_TO_REFER_TO_TYPE_REF_XMSG:
 * VirtualAtomicEntryReference has to refer to a TypeReference</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from MQLBugMessages.properties
 */

public enum BugMessages implements LocalizedString {

	/**
	 * Message:
	 * "Alias in remnant query has to be either dominant or subdominant"
	 */
	ALIAS_IN_REMNANT_GRAPH_WITHOUT_DOMINANCE("ALIAS_IN_REMNANT_GRAPH_WITHOUT_DOMINANCE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "An association-based comparison cannot occur nested in a for-clause"
	 */
	ASSOC_BASED_COMPARISON_IN_NESTED_FOR_CLAUSE("ASSOC_BASED_COMPARISON_IN_NESTED_FOR_CLAUSE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Atomic entry already registered in node map"
	 */
	ATOMIC_ENTRY_ALREADY_IN_NODE_MAP("ATOMIC_ENTRY_ALREADY_IN_NODE_MAP_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "AtomicEntry not found in nodeMap"
	 */
	ATOMIC_ETNRY_NOT_FOUND_IN_NODE_MAP("ATOMIC_ETNRY_NOT_FOUND_IN_NODE_MAP_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "FacilityQueryResultSet: Attribute values must not be MRIs, but value was {0}"
	 */
	ATTR_VALUES_SHOULD_NOT_BE_MRIS("ATTR_VALUES_SHOULD_NOT_BE_MRIS_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "BasicQueryResultSet returned from leaf query execution returned null."
	 */
	BQL_EXECUTION_RETURNS_NULL_RESULT_SET("BQL_EXECUTION_RETURNS_NULL_RESULT_SET_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Cluster external links work only with RefObjects, type: {0}"
	 */
	CLUSTER_EXTERNAL_LINK_WORK_ONLY_WITH_REFOBJECTS("CLUSTER_EXTERNAL_LINK_WORK_ONLY_WITH_REFOBJECTS_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "ComparisonWithEntry of cluster pair failed in crossComparisonWith entries"
	 */
	COMPARISON_WITH_ENTRY_OF_PAIR_FAILED("COMPARISON_WITH_ENTRY_OF_PAIR_FAILED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Could not obtain a class-based node in the remnant graph"
	 */
	COULD_NOT_OBTAIN_CLASS_BASED_NODE_IN_REMNANT_GRAPH("COULD_NOT_OBTAIN_CLASS_BASED_NODE_IN_REMNANT_GRAPH_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "No cross-cluster comparisonWithEntries possible with one cluster"
	 */
	CROSS_CLUSTER_COMPARISON_WITHENTRIES_IN_ONE_CLUSTER("CROSS_CLUSTER_COMPARISON_WITHENTRIES_IN_ONE_CLUSTER_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected differently connected node in remnant graph"
	 */
	DIFFERENT_CONNECTED_NODE_IN_REMNANT_GRAPH("DIFFERENT_CONNECTED_NODE_IN_REMNANT_GRAPH_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Expected instance (or list) of "{0}""
	 */
	ENTRY_OR_LIST_OF_ENTRY_EXPECTED("ENTRY_OR_LIST_OF_ENTRY_EXPECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Only expected EQUAL or NONEQUAL at this point instead of {0}"
	 */
	EQUAL_OR_NOT_EQUAL_EXPECTED("EQUAL_OR_NOT_EQUAL_EXPECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Expected at least one operand for ResultUnion"
	 */
	EXPECTED_AT_LEAST_ONE_OPERAND_IN_RESULT_UNION("EXPECTED_AT_LEAST_ONE_OPERAND_IN_RESULT_UNION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Only TypeClause or ParsedIdentifier allowed at this point"
	 */
	EXPECTED_TYPE_CLAUSE_OR_PARSED_ID("EXPECTED_TYPE_CLAUSE_OR_PARSED_ID_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"In the case of remnant queries, we expect exactly two (non-structure-typed) nodes"
	 */
	EXPECTING_TWO_NON_STRUCTURE_TYPED_NODES("EXPECTING_TWO_NON_STRUCTURE_TYPED_NODES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Expected FoundMri or NoMri"
	 */
	EXPECT_FOUNDMRI_NOMRI("EXPECT_FOUNDMRI_NOMRI_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Only expect QualNameType, MriElement, or ParsedIdentifier"
	 */
	EXPECT_QUALNAMETYPE_MRIELEMENT_PARSEDIDENTIFIER("EXPECT_QUALNAMETYPE_MRIELEMENT_PARSEDIDENTIFIER_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Fixed element set in cloning constructor has to be hash set"
	 */
	FIXED_ELEMENT_SET_IN_CLONING_CONSTRUCTOR_HAS_TO_BE_HASHSET("FIXED_ELEMENT_SET_IN_CLONING_CONSTRUCTOR_HAS_TO_BE_HASHSET_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected assoc predicate in remnant query"
	 */
	FOUND_ASSOC_PREDICATE_IN_REMNANT_GRAPH("FOUND_ASSOC_PREDICATE_IN_REMNANT_GRAPH_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected non leaf query in FQL"
	 */
	FOUND_NON_LEAF_QUERY_IN_FQL("FOUND_NON_LEAF_QUERY_IN_FQL_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "FacilityQueryResultSet returned from leaf query execution returned null"
	 */
	FQL_EXECUTION_RETURNS_NULL_RESULT_SET("FQL_EXECUTION_RETURNS_NULL_RESULT_SET_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The query had no cluster navigation plan"
	 */
	IMPOSSIBLE_TO_CREATE_CLUSTER_NAVIGATION_PLAN("IMPOSSIBLE_TO_CREATE_CLUSTER_NAVIGATION_PLAN_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Incompatible FQL processors in leaf query: {0} is not equal to {1}"
	 */
	INCOMPATIBLE_FQL_IN_LEAF_QUERIES("INCOMPATIBLE_FQL_IN_LEAF_QUERIES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Invalid literal type in operation"
	 */
	INVALID_LITERAL_TYPE_IN_OPERATION("INVALID_LITERAL_TYPE_IN_OPERATION_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Like comparison with types other than String and RefEnum not allowed!"
	 */
	LIKE_COMPARISON_WITH_TYPES_OTHER_THAN_STRING_AND_LABELS_NOT_ALLOWED(
			"LIKE_COMPARISON_WITH_TYPES_OTHER_THAN_STRING_AND_LABELS_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The linkType {0} is neither of type Attribute nor of type Association""
	 */
	LINK_TYPE_NOT_ATTRIBUTE_OR_ASSOCIATION("LINK_TYPE_NOT_ATTRIBUTE_OR_ASSOCIATION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The linkType {0} could not be resolved to a JMI object"
	 */
	LINK_TYPE_NOT_JMI_OBJECT("LINK_TYPE_NOT_JMI_OBJECT_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The Memory Facility Query Processor cannot directly be used in a facility. It has to be wrapped in another FQL which determines a finite scope"
	 */
	MEMORY_FQL_USED_AS_REGULAR_FQL("MEMORY_FQL_USED_AS_REGULAR_FQL_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The Memory Facility Query Processor cannot directly be used in a facility. It has to be wrapped in another FQL which determines a finite scope"
	 */
	MEMORY_FQL_USED_IN_FACILITY("MEMORY_FQL_USED_IN_FACILITY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Misalligned empty query in ResultUnion"
	 */
	MISSALIGNED_EMPTY_QUERY_IN_UNION("MISSALIGNED_EMPTY_QUERY_IN_UNION_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"Expected at least one edge between the two (non-structure-typed) nodes of a remnant query"
	 */
	MISSING_EDGE_IN_REMANT_QUERY("MISSING_EDGE_IN_REMANT_QUERY_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Attempt to register more than one FQL processor for one and the same facility"
	 */
	MORE_THAN_ONE_FQL_PER_FACILITY("MORE_THAN_ONE_FQL_PER_FACILITY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The MRI for the type of the element is not a MOF Classifier"
	 */
	MRI_IS_NOT_MOF_CLASS("MRI_IS_NOT_MOF_CLASS_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Found a nested select which was not reset and is not a leaf query"
	 */
	NESTED_SELECT_WAS_NOT_RESET("NESTED_SELECT_WAS_NOT_RESET_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected non-assigned nodes while spreading remnant query"
	 */
	NON_ASSIGNED_NODES_WHILE_SPREADING("NON_ASSIGNED_NODES_WHILE_SPREADING_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "FQL for slim index: unexpected non-restricted scope for FQL query"
	 */
	NON_RESTRICTED_SCOPE_FOR_FQL_QUERY("NON_RESTRICTED_SCOPE_FOR_FQL_QUERY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Un-expected non-simplified node in a cluster of NONDIRTY nodes"
	 */
	NON_SIMPLIFIED_NODE_IN_CLUSTER_OF_NONDIRTY_NODES("NON_SIMPLIFIED_NODE_IN_CLUSTER_OF_NONDIRTY_NODES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "There is always at least one cluster"
	 */
	NO_CLUSTER_AVAILABLE("NO_CLUSTER_AVAILABLE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Expected found connecting assoc predicate in with entries"
	 */
	NO_CONNECTING_ASSOC_PREDICATE_IN_WITH_ENTRIES("NO_CONNECTING_ASSOC_PREDICATE_IN_WITH_ENTRIES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No DIRTY dominant scenario permitted in remnant situations"
	 */
	NO_DIRTY_DOMINANT_SCENARIO_IN_REMNANT_SITUATIONS("NO_DIRTY_DOMINANT_SCENARIO_IN_REMNANT_SITUATIONS_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Impossible to have no FQL registered in the pool at this point"
	 */
	NO_FQL_IN_POOL("NO_FQL_IN_POOL_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No from entries while pretty printing"
	 */
	NO_FROM_ENTRIES("NO_FROM_ENTRIES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No query found during spreading of remnant graph"
	 */
	NO_QUERY_FOUND_DURING_SPREADING_OF_REMNANT_GRAPH("NO_QUERY_FOUND_DURING_SPREADING_OF_REMNANT_GRAPH_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No select entries while pretty printing"
	 */
	NO_SELECT_ENTRIES("NO_SELECT_ENTRIES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No such attribute expression type: {0}"
	 */
	NO_SUCH_ATTRIBUTE_EXPRESSION_TYPE("NO_SUCH_ATTRIBUTE_EXPRESSION_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No such leaf expression type: {0}"
	 */
	NO_SUCH_LEAF_EXPRESSION_TYPE("NO_SUCH_LEAF_EXPRESSION_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No such link category"
	 */
	NO_SUCH_LINK_CATEGORY("NO_SUCH_LINK_CATEGORY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No such multinary attribute expression type: {0}"
	 */
	NO_SUCH_MULTINARY_ATTRIBUTE_EXPRESSION_TYPE("NO_SUCH_MULTINARY_ATTRIBUTE_EXPRESSION_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No such navigation step source: {0}"
	 */
	NO_SUCH_NAVIGATION_STEP_SOURCE("NO_SUCH_NAVIGATION_STEP_SOURCE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No such object type: {0}"
	 */
	NO_SUCH_OBJECT_TYPE("NO_SUCH_OBJECT_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The operation {0} in a WhereString cannot occur when compairing with null"
	 */
	NULL_COMPARISON_WITH_ILLEGAL_OPERATOR("NULL_COMPARISON_WITH_ILLEGAL_OPERATOR_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"FacilityQueryResultSet: numberOfAttributeInSelectList must not be negative, but was {0}"
	 */
	NUMBER_OF_ATTRS_IN_SELECT_LIST_NEGATIVE("NUMBER_OF_ATTRS_IN_SELECT_LIST_NEGATIVE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected non leaf query in FQL"
	 */
	ONLY_NON_LEAF_QUERIES_IN_FQL("ONLY_NON_LEAF_QUERIES_IN_FQL_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected point reached after parsing"
	 */
	PARSE_POINT_UNEXPECTED("PARSE_POINT_UNEXPECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Integer-like numeral was not parseable: {0}"
	 */
	PARSING_OF_INT_FAILED("PARSING_OF_INT_FAILED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Float-like numeral was not parseable: {0}"
	 */
	PARSING_OF_REAL_FAILED("PARSING_OF_REAL_FAILED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The PRI {0} does not exist"
	 */
	PRI_DOES_NOT_EXIST("PRI_DOES_NOT_EXIST_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Provided node was not participating in the edge"
	 */
	PROVIDED_NODE_WAS_NOT_PARTICIPATING_IN_EDGE("PROVIDED_NODE_WAS_NOT_PARTICIPATING_IN_EDGE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Result sets of different row sizes can not be combined"
	 */
	RESULT_SET_OF_DIFFERENT_ROW_SIZES("RESULT_SET_OF_DIFFERENT_ROW_SIZES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "A Result Union expects at least two operands"
	 */
	RESULT_UNION_EXPECTS_AT_LEAST_TWO_OPERANDS("RESULT_UNION_EXPECTS_AT_LEAST_TWO_OPERANDS_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A scope clause has to be a string or list of IdentifierAndNodes"
	 */
	SCOPE_CLAUSE_TYPE_WRONG("SCOPE_CLAUSE_TYPE_WRONG_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "SetSelections() has to be invoked before selections can be obtained"
	 */
	SETSELECTIONS_ORDERING_WRONG("SETSELECTIONS_ORDERING_WRONG_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Singular query with only structure-typed atomic entries"
	 */
	SINGULAR_QUERY_WITH_ONLY_STRUCTURE_TYPED_ATOMIC_ENTRIES("SINGULAR_QUERY_WITH_ONLY_STRUCTURE_TYPED_ATOMIC_ENTRIES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "SourceObject must be RefObject, type: {0}"
	 */
	SOURCEOBJECT_MUST_BE_REFOBJECT_TYPE("SOURCEOBJECT_MUST_BE_REFOBJECT_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The source atomic entry should not be a fixed set if the target is not one"
	 */
	SOURCE_AE_FIXED_BUT_NOT_TARGET_AE("SOURCE_AE_FIXED_BUT_NOT_TARGET_AE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unspecified SPI facility query service exception"
	 */
	SPI_FACILITY_QUERY_SERVICE_EXCEPTION("SPI_FACILITY_QUERY_SERVICE_EXCEPTION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Top alias is not set for NodeSelectEntry"
	 */
	TOP_ALIAS_NOT_SET_FOR_NODESELECTENTRY("TOP_ALIAS_NOT_SET_FOR_NODESELECTENTRY_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"All top-level select entries have to have an entry in the position map at this point"
	 */
	TOP_LEVEL_WITHOUT_ENTRY_IN_POSITION_MAP("TOP_LEVEL_WITHOUT_ENTRY_IN_POSITION_MAP_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"TypeComparison is currently not supported. This should not pass the type checker"
	 */
	TYPE_COMPARISON_NOT_SUPPORTED("TYPE_COMPARISON_NOT_SUPPORTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"Expected the first node of a leaf query to have graphType assigned at this point"
	 */
	UNASSIGNED_GRAPH_TYPE("UNASSIGNED_GRAPH_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The assoc end number was {0}, where valid association end numbers are either 0 or 1"
	 * "
	 */
	UNEXPECTED_ASSOCIATION_END_NUMBER("UNEXPECTED_ASSOCIATION_END_NUMBER_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected comparison operator {0} for booleans or strings"
	 */
	UNEXPECTED_COMPARATOR_STRING_BOOL("UNEXPECTED_COMPARATOR_STRING_BOOL_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected different value types {0} and {1}"
	 */
	UNEXPECTED_DIFFERENT_VALUE_TYPES("UNEXPECTED_DIFFERENT_VALUE_TYPES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected empty scope for leaf query during execution"
	 */
	UNEXPECTED_EMPTY_SCOPE_FOR_LEAF_QUERY_DURING_EXECUTION("UNEXPECTED_EMPTY_SCOPE_FOR_LEAF_QUERY_DURING_EXECUTION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected exclusive scope for scheduled memory execution"
	 */
	UNEXPECTED_EXCLUSIVE_SCOPE_FOR_SCHEDULED_MEMORY_EXECUTION("UNEXPECTED_EXCLUSIVE_SCOPE_FOR_SCHEDULED_MEMORY_EXECUTION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected node category: {0}"
	 */
	UNEXPECTED_NODE_CATEGORY("UNEXPECTED_NODE_CATEGORY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected non-inclusive scope for memory scenario"
	 */
	UNEXPECTED_NON_INCLUSIVE_SCOPE_FOR_MEMORY_SCENARIO("UNEXPECTED_NON_INCLUSIVE_SCOPE_FOR_MEMORY_SCENARIO_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Unexpected non-virtual type reference while redirecting select entries"
	 */
	UNEXPECTED_NON_VIRTUAL_REF_REFERRING_SELECT_ENTRY("UNEXPECTED_NON_VIRTUAL_REF_REFERRING_SELECT_ENTRY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected null MRI in FacilityQueryResultSet"
	 */
	UNEXPECTED_NULL_MRI("UNEXPECTED_NULL_MRI_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected null result set as a result from query execution"
	 */
	UNEXPECTED_NULL_RESULT_SET("UNEXPECTED_NULL_RESULT_SET_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected object type in parse result, type _XMSG= {0}"
	 */
	UNEXPECTED_OBJECT_TYPE_IN_PARSE_RESULT("UNEXPECTED_OBJECT_TYPE_IN_PARSE_RESULT_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected parse-object at this point"
	 */
	UNEXPECTED_PARSE_OBJECT("UNEXPECTED_PARSE_OBJECT_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected SimpleComparisonOperator"
	 */
	UNEXPECTED_SIMPLE_COMPARISON_OPERATOR("UNEXPECTED_SIMPLE_COMPARISON_OPERATOR_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected type of navigation step"
	 */
	UNEXPECTED_STEP("UNEXPECTED_STEP_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected subtype {0} for {1}"
	 */
	UNEXPECTED_SUBTYPE("UNEXPECTED_SUBTYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected trueDirtyScopeSize"
	 */
	UNEXPECTED_TRUE_DIRTY_SCOPE_SIZE("UNEXPECTED_TRUE_DIRTY_SCOPE_SIZE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected type in MriSetLinkExpression: {0}"
	 */
	UNEXPECTED_TYPE_IN_MRISETLINKEXPRESSION("UNEXPECTED_TYPE_IN_MRISETLINKEXPRESSION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected type of linkedObject, class name= {0}"
	 */
	UNEXPECTED_TYPE_OF_LINKEDOBJECT_CLASS_NAME("UNEXPECTED_TYPE_OF_LINKEDOBJECT_CLASS_NAME_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected TypeReference as argument of setTypeReference"
	 */
	UNEXPECTED_TYPE_REF_AS_ARG_OF_TYPEREFERENCE("UNEXPECTED_TYPE_REF_AS_ARG_OF_TYPEREFERENCE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected unevaluated nested query. Expect LeafQuery"
	 */
	UNEXPECTED_UNEVALUATED_NESTED_QUERY("UNEXPECTED_UNEVALUATED_NESTED_QUERY_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"Unexpected WhereNestedFeature without a nested query. This might probably should be a WhereNestedAssoc"
	 */
	UNEXPECTED_WHERE_NESTED_FEATURE("UNEXPECTED_WHERE_NESTED_FEATURE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected Atomic Entry Category: {0}"
	 */
	UNKNOWN_ATOMIC_ENTRY_CATEGORY("UNKNOWN_ATOMIC_ENTRY_CATEGORY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Operator {0} is unknown"
	 */
	UNKNOWN_OPERATOR("UNKNOWN_OPERATOR_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The primitive type {0} is not recognized"
	 */
	UNKNOWN_PRIMITIVE_TYPE("UNKNOWN_PRIMITIVE_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "VirtualAtomicEntryReference has to refer to a TypeReference"
	 */
	VIRTUAL_ATOMIC_ENTRY_REF_HAS_TO_REFER_TO_TYPE_REF("VIRTUAL_ATOMIC_ENTRY_REF_HAS_TO_REFER_TO_TYPE_REF_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "VirtualAtomicAttrReference has to refer to a TypeAttrReference"
	 */
	VIRTUAL_ATTOMIC_ATTR_REF_SHOULD_REFER_TO_TYPE_ATTR_REF("VIRTUAL_ATTOMIC_ATTR_REF_SHOULD_REFER_TO_TYPE_ATTR_REF_XMSG"); //$NON-NLS-1$

	private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor(BugMessages.class);

	private final String myKey;

	private BugMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);
	}

	public String getLocalizedMessage(Locale locale) {

		try {
			return ACCESSOR.getMessageText(locale, this.myKey);
		} catch (RuntimeException e) {
			return "Localization failed for ResourceBundle " + BugMessages.class.getName() + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

}