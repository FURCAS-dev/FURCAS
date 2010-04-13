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
 * <li>NAV_WITH_NULL_COMPARE_NOT_SUPPORTED_XMSG: A MRI-based association
 * navigation with a null comparison is currently not supported</li>
 * <li>NULL_CONTAINER_XMSG: A container in the query scope was null instead of
 * an instance of CRI</li>
 * <li>ASSOC_DISAMBIGUATION_FOUND_AT_ATTRIBUTE_COMPARISON_XMSG: A disambiguation
 * clause cannot be provided when comparing two attributes</li>
 * <li>ELEMENTS_CANNOT_BE_NEGATED_XMSG: A fixed element set cannot be excluded
 * with the &#039;not&#039; keyword</li>
 * <li>NULL_COMPARISON_NOT_POSSIBLE_FOR_STRUCT_XMSG: A null comparison for
 * attribute {0} of structure type {1} is not possible</li>
 * <li>PARTITION_NULL_IN_SCOPE_XMSG: A partition in the query scope was the null
 * object instead of an instance of PRI</li>
 * <li>TRAILING_BLANKS_NOT_ALLOWED_XMSG: A pattern or constant may not contain
 * trailing blanks: &#039;{0}&#039;</li>
 * <li>STRING_CONSTANT_TOO_LONG_XMSG: A string of more than 200 characters
 * cannot be used in a comparison condition: &#039;{0}&#039;</li>
 * <li>STRUCTURE_TYPE_SHOULD_NOT_HAVE_SCOPE_XMSG: A structure type has no
 * identity and should therefore not be explicitly scoped</li>
 * <li>ASSOC_PER_MRI_HAS_INVALID_ASSOC_END_XMSG: Association disambiguation with
 * a MRI expects 0 or 1 for the pointing association end, not {0}</li>
 * <li>UNDEFINED_ASSOCIATION_END_XMSG: Association end {1} is not defined for
 * association {0}</li>
 * <li>MUST_RESTRICT_SCOPE_FOR_ELEMENT_XMSG: Attempted to obtain all instances
 * of &#039;Reflect::Element&#039;! Reformulate your query to avoid this</li>
 * <li>SELATTR_JUST_ONCE_XMSG: Attribute {0} for alias {1} cannot be selected
 * more than once</li>
 * <li>COMPARISON_INFINITY_NOT_ALLOWED_XMSG: Comparison to positive or negative
 * infinity is not permitted.</li>
 * <li>EMPTY_QUALIFIED_NAMES_XMSG: Empty qualified names are not permitted</li>
 * <li>CONTAINER_QUAL_EXPECTS_QUALIFIED_NAME_XMSG: Expected qualified MOF name
 * instead of {0} after container qualification</li>
 * <li>IO_DURING_CSV_SERIALIZATION_XMSG: IO exception while trying to produce
 * CSV file for result set</li>
 * <li>EMPTY_FIXED_SET_XMSG: Illegal empty fixed element set for alias {0}</li>
 * <li>NO_QUERY_SERVICE_FOUND_XMSG: Illegal facility configuration: None of the
 * attached MOIN facilities has a query service</li>
 * <li>INVALID_FEATURE_NAME_XMSG: Invalid feature name {0} for classifier {1}</li>
 * <li>MRI_MISSING_ONE_FIXED_ELEMENT_XMSG: It is illegal to not provide a MRI
 * referring to a RefObject when providing just one fixed element</li>
 * <li>ALIAS_TWICE_IN_ASSOC_PREDICATE_XMSG: It is not possible to use the alias
 * {0} twice within one association predicate</li>
 * <li>MQL_PREPROCESSOR_PROBLEM_XMSG: MQL Preprocessor reported an Exception</li>
 * <li>UNRESOLVABLE_QUALIFIED_NAME_XMSG: Qualified name {0} cannot be resolved
 * in the provided scope</li>
 * <li>AMBIGUOUS_QUALIFIED_NAME_XMSG: Qualified name {0} is ambiguous in the
 * provided scope</li>
 * <li>EMPTY_QUERY_PART_XMSG: Query part {0} has not been constructed</li>
 * <li>QUERY_RESULT_OUT_OF_BOUNDS_XMSG: Query result record access out of bounds
 * </li>
 * <li>FIFQL_NOT_SUPPORTED_XMSG: The FIFQL SPI is currently not supported by MQL
 * </li>
 * <li>MRI_IN_PATH_XMSG: The MRI {0} cannot be prefixed with a path</li>
 * <li>PROVIDED_ELEMENT_OF_WRONG_TYPE_XMSG: The MRI {0} in the fixed element set
 * of alias {1} does not conform to type {2} or its subtypes</li>
 * <li>EMPTY_ALIAS_XMSG: The alias in the &#039;from-entry&#039; was not defined
 * </li>
 * <li>DUPLICATE_ALIAS_XMSG: The alias {0} cannot be defined more than once in
 * the same query</li>
 * <li>REPEATED_SELECT_ENTRY_XMSG: The alias {0} is already selected in the same
 * selection clause</li>
 * <li>UNDEFINED_ALIAS_AT_PEER_LEVEL_XMSG: The alias {0} is not defined in a
 * &#039;from-clause&#039; within the same query</li>
 * <li>UNDEFINED_ALIAS_XMSG: The alias {0} is not defined in the
 * &#039;from-clause&#039; of the query</li>
 * <li>CLASS_OR_STRUCTTYPE_EXPECTED_XMSG: The alias {0}, whose type is
 * represented by MRI {1}, is not referring to an instance of MofClass or
 * StructureType</li>
 * <li>COMPARE_INCOMPATIBLE_TYPES_XMSG: The aliases {0} and {1} are not type
 * compatible, leading to an empty result set</li>
 * <li>ASSOC_DISAMBIGUATION_INVALID_QUAL_NAME_XMSG: The association
 * disambiguation {0} is not a valid qualified MOF path</li>
 * <li>AMBIGUOUS_ASSOC_END_NAME_XMSG: The association end name {0} is ambiguous
 * for classifier {1}</li>
 * <li>ASSOCIATION_END_TYPE_MISMATCH_XMSG: The association end {0} of
 * association {1} expects a subtype of {2} and does not match the type {3}</li>
 * <li>NULL_COMPARISON_FORBIDDEN_FOR_ELEMENT_XMSG: The association end {0} of
 * association {1} refers to Reflect::Element, which forbids a comparison with
 * null</li>
 * <li>ILLEGAL_ASSOCIATION_ENDS_XMSG: The association ends {0} and {1} are
 * illegal</li>
 * <li>ATTRIBUTE_NOT_SELECTED_XMSG: The attribute name {0} for alias {0} was not
 * defined in the selection clause of the query</li>
 * <li>PRIMITIVE_OR_ENUM_EXPECTED_XMSG: The attribute or field {0} has to be
 * either of primitive or enumeration type</li>
 * <li>NULL_COMPARISON_PROBLEM_XMSG: The attribute {0} cannot be compared with
 * the null value via operation {1}</li>
 * <li>UNDEFINED_ATTRIBUTE_XMSG: The attribute {0} does not exist for type {1}</li>
 * <li>COMPARISON_INCOMPATIBLE_TYPE_CHECK_XMSG: The attribute {0} has type {1},
 * but is compared with a value of type {2}</li>
 * <li>DERIVE_ATTRIBUTES_NOT_ALLOWED_XMSG: The attribute {0} is derived and can
 * therefore not be used in an MQL query</li>
 * <li>EXCLUDED_TYPE_IS_NOT_SUBTYPE_XMSG: The excluded type {0} is not a subtype
 * of {1}</li>
 * <li>FEATURE_TO_CLASS_OR_STRUCTTYPE_XMSG: The feature {0} has to reference
 * either a class object or a structure type</li>
 * <li>UNEXPECTED_ASSOC_WITH_LITERAL_OP_COMPARE_XMSG: The feature {0} refers to
 * an association while trying to compare it with literal {1} via operation {2}</li>
 * <li>NO_STRUCTTYPE_FOR_FIXED_SET_XMSG: The fixed element set of alias {0}
 * cannot be typed with a structure type</li>
 * <li>INVALID_QUALIFIED_NAME_XMSG: The name {0} is not a fully qualified MOF
 * name</li>
 * <li>INVALID_NESTED_QUERY_SELECT_XMSG: The nested query is expected to select
 * exactly one alias of a class object</li>
 * <li>NULL_COMPARISON_ONLY_FOR_EQUALITY_XMSG: The operation {0} cannot be used
 * to compare attributes with null</li>
 * <li>INVALID_OPERATION_XMSG: The operation {0} is not possible on attributes
 * of type {1}</li>
 * <li>BOOLEAN_ONLY_ALLOW_EQUALITY_XMSG: The operator {0} is not allowed to
 * compare boolean-typed attributes</li>
 * <li>EMPTY_QUERY_XMSG: The parser produced an empty abstract syntax tree</li>
 * <li>ASSOCIATION_EXPECTED_XMSG: The provided MRI {0} is not referring to an
 * instance of a MOF association</li>
 * <li>ASSOC_QUALIFIER_NOT_AN_ASSOC_XMSG: The provided association qualifier {0}
 * does not refer to an association</li>
 * <li>INVALID_FIXED_ELEMENT_XMSG: The provided fixed element {0} is not a valid
 * MRI</li>
 * <li>INVALID_MRI_STRING_XMSG: The provided type element {0} is not a valid MRI
 * </li>
 * <li>TRYING_TO_EXCLUDE_NON_MOF_CLASS_XMSG: The qualified name {0} does not
 * refer to a MOF Classifier and cannot therefore not be added in a
 * withoutsubtypes set</li>
 * <li>RESULTSET_TOO_LARGE_XMSG: The query produces a (possibly intermediate)
 * result set, which is larger than provided threshold. To enlarge the
 * threshold, access the MQLProcessor API</li>
 * <li>SCOPE_ELEMENT_NOT_MRI_XMSG: The scope element {0} is not a valid MRI</li>
 * <li>SCOPE_ELEMENT_NOT_PRI_XMSG: The scope element {0} is not a valid PRI</li>
 * <li>STRUCTURE_FIELD_EXPECTED_XMSG: The selected alias {0} which refers to the
 * structure type {1} has to dereference a structure field</li>
 * <li>REFLECT_ELEMENT_SAFER_WITH_SCOPE_XMSG: The type
 * &#039;Reflect::Element&#039; is not given a scope, which may lead to
 * extremely large result sets</li>
 * <li>FROMENTRY_TYPE_IN_SUBTYPE_EXCLUSION_SET_XMSG: The type {0} is not a true
 * subtype of itself and cannot be contained in the subtype exclusion set</li>
 * <li>FEATURE_TYPE_INCOMPATIBILITY_XMSG: The types of the attributes {0}.{1}
 * and {2}.{3} have to identical when being compared</li>
 * <li>ILLEGAL_ASSOCIATION_END_XMSG: The {0} association end has to be {1}
 * instead of {2}</li>
 * <li>IGNOREDIRTY_NOT_SUPPORTED_XMSG: This method is currently not supported.
 * Contact your MQL team if you have questions</li>
 * <li>UNKNOWN_FACILITY_QUERY_LANGUAGE_XMSG: Unknown facility query language</li>
 * <li>FIXED_MRI_ELEMENT_WITH_CONTAINER_XMSG: You cannot qualify a fixed element
 * (represented by a MRI) with a container</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from MQLApiMessages.properties
 */

public enum ApiMessages implements LocalizedString {

	/**
	 * Message:
	 * "It is not possible to use the alias {0} twice within one association predicate"
	 */
	ALIAS_TWICE_IN_ASSOC_PREDICATE("ALIAS_TWICE_IN_ASSOC_PREDICATE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The association end name {0} is ambiguous for classifier {1}"
	 */
	AMBIGUOUS_ASSOC_END_NAME("AMBIGUOUS_ASSOC_END_NAME_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Qualified name {0} is ambiguous in the provided scope"
	 */
	AMBIGUOUS_QUALIFIED_NAME("AMBIGUOUS_QUALIFIED_NAME_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The association end {0} of association {1} expects a subtype of {2} and does not match the type {3}"
	 */
	ASSOCIATION_END_TYPE_MISMATCH("ASSOCIATION_END_TYPE_MISMATCH_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The provided MRI {0} is not referring to an instance of a MOF association"
	 */
	ASSOCIATION_EXPECTED("ASSOCIATION_EXPECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A disambiguation clause cannot be provided when comparing two attributes"
	 */
	ASSOC_DISAMBIGUATION_FOUND_AT_ATTRIBUTE_COMPARISON("ASSOC_DISAMBIGUATION_FOUND_AT_ATTRIBUTE_COMPARISON_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The association disambiguation {0} is not a valid qualified MOF path"
	 */
	ASSOC_DISAMBIGUATION_INVALID_QUAL_NAME("ASSOC_DISAMBIGUATION_INVALID_QUAL_NAME_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"Association disambiguation with a MRI expects 0 or 1 for the pointing association end, not {0}"
	 */
	ASSOC_PER_MRI_HAS_INVALID_ASSOC_END("ASSOC_PER_MRI_HAS_INVALID_ASSOC_END_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The provided association qualifier {0} does not refer to an association "
	 */
	ASSOC_QUALIFIER_NOT_AN_ASSOC("ASSOC_QUALIFIER_NOT_AN_ASSOC_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The attribute name {0} for alias {0} was not defined in the selection clause of the query"
	 */
	ATTRIBUTE_NOT_SELECTED("ATTRIBUTE_NOT_SELECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The operator {0} is not allowed to compare boolean-typed attributes"
	 */
	BOOLEAN_ONLY_ALLOW_EQUALITY("BOOLEAN_ONLY_ALLOW_EQUALITY_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The alias {0}, whose type is represented by MRI {1}, is not referring to an instance of MofClass or StructureType"
	 */
	CLASS_OR_STRUCTTYPE_EXPECTED("CLASS_OR_STRUCTTYPE_EXPECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The aliases {0} and {1} are not type compatible, leading to an empty result set"
	 */
	COMPARE_INCOMPATIBLE_TYPES("COMPARE_INCOMPATIBLE_TYPES_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The attribute {0} has type {1}, but is compared with a value of type {2}"
	 */
	COMPARISON_INCOMPATIBLE_TYPE_CHECK("COMPARISON_INCOMPATIBLE_TYPE_CHECK_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Comparison to positive or negative infinity is not permitted. "
	 */
	COMPARISON_INFINITY_NOT_ALLOWED("COMPARISON_INFINITY_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Expected qualified MOF name instead of {0} after container qualification"
	 */
	CONTAINER_QUAL_EXPECTS_QUALIFIED_NAME("CONTAINER_QUAL_EXPECTS_QUALIFIED_NAME_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The attribute {0} is derived and can therefore not be used in an MQL query"
	 */
	DERIVE_ATTRIBUTES_NOT_ALLOWED("DERIVE_ATTRIBUTES_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The alias {0} cannot be defined more than once in the same query"
	 */
	DUPLICATE_ALIAS("DUPLICATE_ALIAS_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A fixed element set cannot be excluded with the &#039;not&#039; keyword"
	 */
	ELEMENTS_CANNOT_BE_NEGATED("ELEMENTS_CANNOT_BE_NEGATED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The alias in the &#039;from-entry&#039; was not defined"
	 */
	EMPTY_ALIAS("EMPTY_ALIAS_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Illegal empty fixed element set for alias {0}"
	 */
	EMPTY_FIXED_SET("EMPTY_FIXED_SET_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Empty qualified names are not permitted"
	 */
	EMPTY_QUALIFIED_NAMES("EMPTY_QUALIFIED_NAMES_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Query part {0} has not been constructed"
	 */
	EMPTY_QUERY_PART("EMPTY_QUERY_PART_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The parser produced an empty abstract syntax tree"
	 */
	EMPTY_QUERY("EMPTY_QUERY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The excluded type {0} is not a subtype of {1}"
	 */
	EXCLUDED_TYPE_IS_NOT_SUBTYPE("EXCLUDED_TYPE_IS_NOT_SUBTYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The feature {0} has to reference either a class object or a structure type "
	 */
	FEATURE_TO_CLASS_OR_STRUCTTYPE("FEATURE_TO_CLASS_OR_STRUCTTYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The types of the attributes {0}.{1} and {2}.{3} have to identical when being compared"
	 */
	FEATURE_TYPE_INCOMPATIBILITY("FEATURE_TYPE_INCOMPATIBILITY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The FIFQL SPI is currently not supported by MQL "
	 */
	FIFQL_NOT_SUPPORTED("FIFQL_NOT_SUPPORTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "You cannot qualify a fixed element (represented by a MRI) with a container"
	 */
	FIXED_MRI_ELEMENT_WITH_CONTAINER("FIXED_MRI_ELEMENT_WITH_CONTAINER_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The type {0} is not a true subtype of itself and cannot be contained in the subtype exclusion set"
	 */
	FROMENTRY_TYPE_IN_SUBTYPE_EXCLUSION_SET("FROMENTRY_TYPE_IN_SUBTYPE_EXCLUSION_SET_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"This method is currently not supported. Contact your MQL team if you have questions"
	 */
	IGNOREDIRTY_NOT_SUPPORTED("IGNOREDIRTY_NOT_SUPPORTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The association ends {0} and {1} are illegal"
	 */
	ILLEGAL_ASSOCIATION_ENDS("ILLEGAL_ASSOCIATION_ENDS_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The {0} association end has to be {1} instead of {2}"
	 */
	ILLEGAL_ASSOCIATION_END("ILLEGAL_ASSOCIATION_END_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Invalid feature name {0} for classifier {1}"
	 */
	INVALID_FEATURE_NAME("INVALID_FEATURE_NAME_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The provided fixed element {0} is not a valid MRI"
	 */
	INVALID_FIXED_ELEMENT("INVALID_FIXED_ELEMENT_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The provided type element {0} is not a valid MRI"
	 */
	INVALID_MRI_STRING("INVALID_MRI_STRING_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The nested query is expected to select exactly one alias of a class object"
	 */
	INVALID_NESTED_QUERY_SELECT("INVALID_NESTED_QUERY_SELECT_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The operation {0} is not possible on attributes of type {1}"
	 */
	INVALID_OPERATION("INVALID_OPERATION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The name {0} is not a fully qualified MOF name"
	 */
	INVALID_QUALIFIED_NAME("INVALID_QUALIFIED_NAME_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "IO exception while trying to produce CSV file for result set"
	 */
	IO_DURING_CSV_SERIALIZATION("IO_DURING_CSV_SERIALIZATION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "MQL Preprocessor reported an Exception"
	 */
	MQL_PREPROCESSOR_PROBLEM("MQL_PREPROCESSOR_PROBLEM_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The MRI {0} cannot be prefixed with a path"
	 */
	MRI_IN_PATH("MRI_IN_PATH_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"It is illegal to not provide a MRI referring to a RefObject when providing just one fixed element"
	 */
	MRI_MISSING_ONE_FIXED_ELEMENT("MRI_MISSING_ONE_FIXED_ELEMENT_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"Attempted to obtain all instances of &#039;Reflect::Element&#039;! Reformulate your query to avoid this"
	 */
	MUST_RESTRICT_SCOPE_FOR_ELEMENT("MUST_RESTRICT_SCOPE_FOR_ELEMENT_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"A MRI-based association navigation with a null comparison is currently not supported"
	 */
	NAV_WITH_NULL_COMPARE_NOT_SUPPORTED("NAV_WITH_NULL_COMPARE_NOT_SUPPORTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"Illegal facility configuration: None of the attached MOIN facilities has a query service"
	 */
	NO_QUERY_SERVICE_FOUND("NO_QUERY_SERVICE_FOUND_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The fixed element set of alias {0} cannot be typed with a structure type"
	 */
	NO_STRUCTTYPE_FOR_FIXED_SET("NO_STRUCTTYPE_FOR_FIXED_SET_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The association end {0} of association {1} refers to Reflect::Element, which forbids a comparison with null"
	 */
	NULL_COMPARISON_FORBIDDEN_FOR_ELEMENT("NULL_COMPARISON_FORBIDDEN_FOR_ELEMENT_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A null comparison for attribute {0} of structure type {1} is not possible"
	 */
	NULL_COMPARISON_NOT_POSSIBLE_FOR_STRUCT("NULL_COMPARISON_NOT_POSSIBLE_FOR_STRUCT_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The operation {0} cannot be used to compare attributes with null "
	 */
	NULL_COMPARISON_ONLY_FOR_EQUALITY("NULL_COMPARISON_ONLY_FOR_EQUALITY_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The attribute {0} cannot be compared with the null value via operation {1}"
	 */
	NULL_COMPARISON_PROBLEM("NULL_COMPARISON_PROBLEM_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A container in the query scope was null instead of an instance of CRI"
	 */
	NULL_CONTAINER("NULL_CONTAINER_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"A partition in the query scope was the null object instead of an instance of PRI"
	 */
	PARTITION_NULL_IN_SCOPE("PARTITION_NULL_IN_SCOPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The attribute or field {0} has to be either of primitive or enumeration type"
	 */
	PRIMITIVE_OR_ENUM_EXPECTED("PRIMITIVE_OR_ENUM_EXPECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The MRI {0} in the fixed element set of alias {1} does not conform to type {2} or its subtypes"
	 */
	PROVIDED_ELEMENT_OF_WRONG_TYPE("PROVIDED_ELEMENT_OF_WRONG_TYPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Query result record access out of bounds"
	 */
	QUERY_RESULT_OUT_OF_BOUNDS("QUERY_RESULT_OUT_OF_BOUNDS_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The type &#039;Reflect::Element&#039; is not given a scope, which may lead to extremely large result sets "
	 */
	REFLECT_ELEMENT_SAFER_WITH_SCOPE("REFLECT_ELEMENT_SAFER_WITH_SCOPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The alias {0} is already selected in the same selection clause"
	 */
	REPEATED_SELECT_ENTRY("REPEATED_SELECT_ENTRY_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The query produces a (possibly intermediate) result set, which is larger than provided threshold. To enlarge the threshold, access the MQLProcessor API"
	 */
	RESULTSET_TOO_LARGE("RESULTSET_TOO_LARGE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The scope element {0} is not a valid MRI"
	 */
	SCOPE_ELEMENT_NOT_MRI("SCOPE_ELEMENT_NOT_MRI_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The scope element {0} is not a valid PRI"
	 */
	SCOPE_ELEMENT_NOT_PRI("SCOPE_ELEMENT_NOT_PRI_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Attribute {0} for alias {1} cannot be selected more than once"
	 */
	SELATTR_JUST_ONCE("SELATTR_JUST_ONCE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"A string of more than 200 characters cannot be used in a comparison condition: &#039;{0}&#039;"
	 */
	STRING_CONSTANT_TOO_LONG("STRING_CONSTANT_TOO_LONG_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The selected alias {0} which refers to the structure type {1} has to dereference a structure field"
	 */
	STRUCTURE_FIELD_EXPECTED("STRUCTURE_FIELD_EXPECTED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A structure type has no identity and should therefore not be explicitly scoped"
	 */
	STRUCTURE_TYPE_SHOULD_NOT_HAVE_SCOPE("STRUCTURE_TYPE_SHOULD_NOT_HAVE_SCOPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A pattern or constant may not contain trailing blanks: &#039;{0}&#039;"
	 */
	TRAILING_BLANKS_NOT_ALLOWED("TRAILING_BLANKS_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The qualified name {0} does not refer to a MOF Classifier and cannot therefore not be added in a withoutsubtypes set"
	 */
	TRYING_TO_EXCLUDE_NON_MOF_CLASS("TRYING_TO_EXCLUDE_NON_MOF_CLASS_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The alias {0} is not defined in a &#039;from-clause&#039; within the same query"
	 */
	UNDEFINED_ALIAS_AT_PEER_LEVEL("UNDEFINED_ALIAS_AT_PEER_LEVEL_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "The alias {0} is not defined in the &#039;from-clause&#039; of the query"
	 */
	UNDEFINED_ALIAS("UNDEFINED_ALIAS_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Association end {1} is not defined for association {0}"
	 */
	UNDEFINED_ASSOCIATION_END("UNDEFINED_ASSOCIATION_END_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The attribute {0} does not exist for type {1}"
	 */
	UNDEFINED_ATTRIBUTE("UNDEFINED_ATTRIBUTE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"The feature {0} refers to an association while trying to compare it with literal {1} via operation {2}"
	 */
	UNEXPECTED_ASSOC_WITH_LITERAL_OP_COMPARE("UNEXPECTED_ASSOC_WITH_LITERAL_OP_COMPARE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unknown facility query language"
	 */
	UNKNOWN_FACILITY_QUERY_LANGUAGE("UNKNOWN_FACILITY_QUERY_LANGUAGE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Qualified name {0} cannot be resolved in the provided scope"
	 */
	UNRESOLVABLE_QUALIFIED_NAME("UNRESOLVABLE_QUALIFIED_NAME_XMSG"); //$NON-NLS-1$

	private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor(ApiMessages.class);

	private final String myKey;

	private ApiMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);
	}

	public String getLocalizedMessage(Locale locale) {

		try {
			return ACCESSOR.getMessageText(locale, this.myKey);
		} catch (RuntimeException e) {
			// $JL-EXC$        
			return "Localization failed for ResourceBundle " + ApiMessages.class.getName() + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

}