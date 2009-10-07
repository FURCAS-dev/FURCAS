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
/*
 * Created on 16.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;
import org.eclipse.emf.query2.internal.fql.SpiFqlNumericConstraint;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.shared.AuxServices;

/**
 * Compares the attribute value with the operand value.
 */
final public class NumericComparison extends ConstantComparison implements SpiFqlNumericConstraint {

	private SpiFqlComparisonOperation operation;

	private Object operandValue;

	public NumericComparison(AtomicEntry _alias, String _attrName, SpiFqlPrimitiveType _attrType, boolean _isMultiValued,
			SpiFqlComparisonOperation _operation, Object _operand) {

		this.atomicEntry = _alias;
		this.attrName = _attrName;
		this.operation = _operation;
		this.operandValue = _operand;
		this.isMultiValued = _isMultiValued;
		this.attrType = _attrType;
	}

	public Object getOperandValue() {

		return this.operandValue;
	}

	public SpiFqlComparisonOperation getOperation() {

		return this.operation;
	}

	public void setOperandValue(Object operand) {

		this.operandValue = operand;
	}

	public void setOperation(SpiFqlComparisonOperation operation) {

		this.operation = operation;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		sb.append(this.attrName + AuxServices.OPENPAREN_T + this.attrType.toString() + AuxServices.CLOSEPAREN_T);

		if (this.isMultiValued) {
			sb.append(AuxServices.OPENPAREN_T + AuxServices.ISMULTIVALUED_T + AuxServices.CLOSEPAREN_T);
		}

		sb.append(AuxServices.SPACE_T);

		if (this.attrType.equals(SpiFqlPrimitiveType.BOOLEAN) && this.operandValue != null) {
			String booleanOperator = ((Boolean) this.operandValue ? "isTrue" : "isFalse"); //$NON-NLS-1$ //$NON-NLS-2$
			sb.append(booleanOperator);
		} else {

			switch (this.operation) {
			case EQUAL:
				sb.append(AuxServices.EQUAL_T);
				break;
			case GREATER:
				sb.append(AuxServices.GREATER_T);
				break;
			case GREATER_OR_EQUAL:
				sb.append(AuxServices.GREATEREQUAL_T);
				break;
			case LESS:
				sb.append(AuxServices.LESS_T);
				break;
			case LESS_OR_EQUAL:
				sb.append(AuxServices.LESSEQUAL_T);
				break;
			case NOT_EQUAL:
				sb.append(AuxServices.NOTEQUAL_T);
				break;
			}

			if (this.operandValue == null) {
				sb.append(AuxServices.SPACE_T + "null"); //$NON-NLS-1$
			} else if (this.operandValue instanceof String) {
				sb.append(AuxServices.OPENQUOTE_T + this.operandValue.toString() + AuxServices.CLOSEQUOTE_T);
			} else {
				sb.append(AuxServices.SPACE_T + this.operandValue.toString());
			}

		}

		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

}
