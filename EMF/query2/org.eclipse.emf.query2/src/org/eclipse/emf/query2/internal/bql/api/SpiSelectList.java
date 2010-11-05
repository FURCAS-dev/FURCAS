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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;


/**
 * Select list containing the attributes which are to be selected for a model
 * element
 */
public final class SpiSelectList {

	private SpiModelElementExpression modelElementExpression;

	private List<SpiAttributeDefinition> attributeDefinitions = new ArrayList<SpiAttributeDefinition>();

	public SpiSelectList(SpiModelElementExpression modelElementExpression) {

		if (modelElementExpression == null) {
			throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
					BQLBugMessages.MODELELEMENTEXPRESSION_MUST_NOT_BE_NULL);
		}
		this.modelElementExpression = modelElementExpression;
	}

	public void addAttributeDefinition(String attributeId, SpiFqlPrimitiveType type, SpiMultiplicityType multiplicityType) {

		this.attributeDefinitions.add(new SpiAttributeDefinition(attributeId, type, multiplicityType));
	}

	/**
	 * @return Returns the modelElementExpression.
	 */
	public SpiModelElementExpression getModelElementExpression() {

		return modelElementExpression;
	}

	/**
	 * Gets the number of attribute definitions in the SelectList.
	 */
	public int getNumberOfAttributeDefinitions() {

		return this.attributeDefinitions.size();
	}

	/**
	 * Gets the number of the attribute definition for an attribute ID. If there
	 * is no attribute definition to this attribute ID then this method throws a
	 * BasicQueryRuntimeException
	 * 
	 * @param attributeId
	 * @return number of the attribute definition
	 * @throws BasicQueryRuntimeException
	 *             there is no attribute definition to this attribute ID
	 */
	public int getNumberOfAttributeDefinition(String attributeId) {

		int totalNum = this.getNumberOfAttributeDefinitions();
		for (int i = 0; i < totalNum; i++) {
			if (this.getAttributeId(i).equals(attributeId)) {
				return i;
			}
		}
		throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
				BQLBugMessages.NO_ATTRIBUTE_DEFINITION_FOR_ATTRIBUTE_ID);
	}

	/**
	 * Gets the attribute id of a selected attribute
	 * 
	 * @param attributeDefinition
	 *            position in attribute definition list
	 * @return attribute id
	 */
	public String getAttributeId(int attributeDefinition) {

		return this.attributeDefinitions.get(attributeDefinition).getAttributeId();
	}

	/**
	 * Gets the type of a selected attribute
	 * 
	 * @param attributeDefinition
	 *            position in attribute definition list
	 * @return simple type of attribute
	 */
	public SpiFqlPrimitiveType getType(int attributeDefinition) {

		return this.attributeDefinitions.get(attributeDefinition).getType();
	}

	/**
	 * Gets the multiplicity type of a selected attribute
	 * 
	 * @param attributeDefinition
	 *            position in attribute definition list
	 * @return multiplicity type
	 */
	public SpiMultiplicityType getMultiplicityType(int attributeDefinition) {

		return this.attributeDefinitions.get(attributeDefinition).getMultiplicityType();
	}

	/**
     *
     */
	@SuppressWarnings("nls")
	public void toString(StringBuffer sb, int ident, boolean newline) {

		SpiUtils.toStringNewLine(sb, ident);
		sb.append(SpiUtils.OPENING_PARENTHESES);
		sb.append(this.modelElementExpression.getAlias());
		sb.append(", ");
		int attributeDefinitionsSize = this.attributeDefinitions.size();
		if (attributeDefinitionsSize > 0) {
			sb.append(SpiUtils.ATTRIBUTES);
			sb.append(": ");
			for (int i = 0; i < attributeDefinitionsSize - 1; i++) {
				sb.append(((SpiAttributeDefinition) this.attributeDefinitions.get(i)).attributeId);
				sb.append(',');
			}
			sb.append(((SpiAttributeDefinition) this.attributeDefinitions.get(attributeDefinitionsSize - 1)).attributeId);
		}
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}

	private static final class SpiAttributeDefinition {

		private String attributeId;

		private SpiFqlPrimitiveType type;

		private SpiMultiplicityType multiplicityType;

		public SpiAttributeDefinition(String attributeId, SpiFqlPrimitiveType type, SpiMultiplicityType multiplicityType) {

			this.attributeId = attributeId;
			this.type = type;
			this.multiplicityType = multiplicityType;
		}

		public String getAttributeId() {

			return attributeId;
		}

		public SpiMultiplicityType getMultiplicityType() {

			return this.multiplicityType;
		}

		public SpiFqlPrimitiveType getType() {

			return type;
		}
	}

}
