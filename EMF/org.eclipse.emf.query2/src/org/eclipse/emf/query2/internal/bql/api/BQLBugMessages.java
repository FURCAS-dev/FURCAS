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
package org.eclipse.emf.query2.internal.bql.api;

import java.util.Locale;

import org.eclipse.emf.query2.exception.LocalizedString;
import org.eclipse.emf.query2.internal.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>FqlDeprecated_XMSG: "The Facility query language is a deprecated BQL
 * processor - if necessary downcast and use its deprecated execution method</li>
 * <li>SelectExpression_must_have_at_least_one_SelectList_selectExpression_XMSG:
 * A SelectExpression must have at least one SelectList, selectExpression = {0}</li>
 * <li>Alias_of_model_element_expression_should_never_be_null_XMSG: Alias of
 * model element expression should never be null</li>
 * <li>Attribute_cannot_be_compared_to_an_attribute_in_another_cluster_attribute_expression_XMSG
 * : An attribute cannot be compared to an attribute in another cluster where
 * attribute expression = {0}</li>
 * <li>False_escape_character_setting_pattern_XMSG: False escape character
 * setting in pattern {0}</li>
 * <li>
 * Found_loop_in_the_hierarchy_of_the_model_element_cluster_expressions_XMSG:
 * Found loop in the hierarchy of the model element cluster expressions for
 * alias {0}</li>
 * <li>ModelElementExpression_inconsistency_Types_and_PartitionExpression_set_Not_allowed_in_case_elements_are_set_XMSG
 * : ModelElementExpression inconsistency: Types and PartitionExpression set.
 * Not allowed in case elements are set!</li>
 * <li>ModelElementExpression_must_not_be_null_XMSG: ModelElementExpression must
 * not be null</li>
 * <li>ModelElementExpressions_in_SelectLists_must_be_part_of_the_root_ModelElementClusterExpression_XMSG
 * : ModelElementExpressions in SelectLists must be part of the root
 * ModelElementClusterExpression</li>
 * <li>No_index_found_for_model_element_expression_XMSG: No index found for
 * model element expression</li>
 * <li>No_attribute_definition_for_attribute_id_XMSG: There is no attribute
 * definition for this attribute ID</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from BQLBugMessages.properties
 */

public enum BQLBugMessages implements LocalizedString {

	/**
	 * Message: "Alias of model element expression should never be null"
	 */
	ALIAS_OF_MODEL_ELEMENT_EXPRESSION_SHOULD_NEVER_BE_NULL("Alias_of_model_element_expression_should_never_be_null_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"An attribute cannot be compared to an attribute in another cluster where attribute expression = {0}"
	 */
	ATTRIBUTE_CANNOT_BE_COMPARED_TO_AN_ATTRIBUTE_IN_ANOTHER_CLUSTER_ATTRIBUTE_EXPRESSION(
			"Attribute_cannot_be_compared_to_an_attribute_in_another_cluster_attribute_expression_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "False escape character setting in pattern {0}"
	 */
	FALSE_ESCAPE_CHARACTER_SETTING_PATTERN("False_escape_character_setting_pattern_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"Found loop in the hierarchy of the model element cluster expressions for alias {0}"
	 */
	FOUND_LOOP_IN_THE_HIERARCHY_OF_THE_MODEL_ELEMENT_CLUSTER_EXPRESSIONS(
			"Found_loop_in_the_hierarchy_of_the_model_element_cluster_expressions_XMSG"), //$NON-NLS-1$

	/**
	 * Message: ""The Facility query language is a deprecated BQL processor - if
	 * necessary downcast and use its deprecated execution method"
	 */
	FQLDEPRECATED("FqlDeprecated_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"ModelElementExpression inconsistency: Types and PartitionExpression set. Not allowed in case elements are set!"
	 */
	MODELELEMENTEXPRESSION_INCONSISTENCY_TYPES_AND_PARTITIONEXPRESSION_SET_NOT_ALLOWED_IN_CASE_ELEMENTS_ARE_SET(
			"ModelElementExpression_inconsistency_Types_and_PartitionExpression_set_Not_allowed_in_case_elements_are_set_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "ModelElementExpression must not be null"
	 */
	MODELELEMENTEXPRESSION_MUST_NOT_BE_NULL("ModelElementExpression_must_not_be_null_XMSG"), //$NON-NLS-1$

	/**
	 * Message:"ModelElementExpressions in SelectLists must be part of the root ModelElementClusterExpression"
	 */
	MODELELEMENTEXPRESSIONS_IN_SELECTLISTS_MUST_BE_PART_OF_THE_ROOT_MODELELEMENTCLUSTEREXPRESSION(
			"ModelElementExpressions_in_SelectLists_must_be_part_of_the_root_ModelElementClusterExpression_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "There is no attribute definition for this attribute ID"
	 */
	NO_ATTRIBUTE_DEFINITION_FOR_ATTRIBUTE_ID("No_attribute_definition_for_attribute_id_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No index found for model element expression"
	 */
	NO_INDEX_FOUND_FOR_MODEL_ELEMENT_EXPRESSION("No_index_found_for_model_element_expression_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A SelectExpression must have at least one SelectList, selectExpression = {0}"
	 */
	SELECTEXPRESSION_MUST_HAVE_AT_LEAST_ONE_SELECTLIST_SELECTEXPRESSION(
			"SelectExpression_must_have_at_least_one_SelectList_selectExpression_XMSG"); //$NON-NLS-1$

	private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor(BQLBugMessages.class);

	private final String myKey;

	private BQLBugMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);
	}

	public String getLocalizedMessage(Locale locale) {

		try {
			return ACCESSOR.getMessageText(locale, this.myKey);
		} catch (RuntimeException e) {
			return "Localization failed for ResourceBundle " + BQLBugMessages.class.getName() + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

}