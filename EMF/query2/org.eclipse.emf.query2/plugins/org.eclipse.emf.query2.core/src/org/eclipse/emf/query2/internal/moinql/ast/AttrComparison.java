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

import org.eclipse.emf.query2.internal.fql.SpiFqlAttributeComparisonConstraint;
import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryEntry;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;

/**
 * An AttrComparison expresses a join constraint which compares two attribute
 * references. The involved attributes have to be of primitive type, but can be
 * multi-valued. In that case, the constraint is true whenever one pair exists
 * which fulfils the constraint.
 */
final public class AttrComparison extends ComparisonWithEntry implements SpiFqlAttributeComparisonConstraint {

	private SpiFqlComparisonOperation operation;

	private TypeAttrReference leftAttr;

	private TypeAttrReference rightAttr;

	public AttrComparison(SpiFqlComparisonOperation _operation, TypeAttrReference _leftAttr, TypeAttrReference _rightAttr) {

		this.operation = _operation;
		this.leftAttr = _leftAttr;
		this.rightAttr = _rightAttr;
	}

	public TypeAttrReference getLeftAttr() {

		return this.leftAttr;
	}

	public SpiFqlComparisonOperation getOperation() {

		return this.operation;
	}

	public TypeAttrReference getRightAttr() {

		return this.rightAttr;
	}

	@Override
	public TypeReference getLeftTypeReference() {

		return getLeftAttr();
	}

	@Override
	public TypeReference getRightTypeReference() {

		return getRightAttr();
	}

	@Override
	public AtomicEntry getLeftAtomicEntry() {

		return this.getLeftAttr().getAtomicEntry();
	}

	@Override
	public AtomicEntry getRightAtomicEntry() {

		return this.getRightAttr().getAtomicEntry();
	}

	@Override
	public void setLeftType(TypeReference leftAttr) {

		if (leftAttr instanceof TypeAttrReference) {
			this.leftAttr = (TypeAttrReference) leftAttr;
		} else {
			throw new BugException(BugMessages.UNEXPECTED_TYPE_REF_AS_ARG_OF_TYPEREFERENCE);
		}
	}

	public void setOperation(SpiFqlComparisonOperation operation) {

		this.operation = operation;
	}

	@Override
	public void setRightType(TypeReference rightAttr) {

		if (rightAttr instanceof TypeAttrReference) {
			this.rightAttr = (TypeAttrReference) rightAttr;
		} else {
			throw new BugException(BugMessages.UNEXPECTED_TYPE_REF_AS_ARG_OF_TYPEREFERENCE);
		}
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		this.leftAttr.toString(indent, sb);

		if (this.leftAttr.isMultiValued()) {
			sb.append(AuxServices.OPENPAREN_T + AuxServices.ISMULTIVALUED_T + AuxServices.CLOSEPAREN_T);
		}

		sb.append(AuxServices.SPACE_T);

		switch (this.operation) {
		case NOT_EQUAL:
			sb.append(AuxServices.NOTEQUAL_T);
			break;
		case GREATER_OR_EQUAL:
			sb.append(AuxServices.GREATEREQUAL_T);
			break;
		case LESS_OR_EQUAL:
			sb.append(AuxServices.LESSEQUAL_T);
			break;
		case EQUAL:
			sb.append(AuxServices.EQUAL_T);
			break;
		case GREATER:
			sb.append(AuxServices.GREATER_T);
			break;
		case LESS:
			sb.append(AuxServices.LESS_T);
			break;
		default:
			sb.append(">>MQL Internal Format Error: INVALID OPERATOR<<"); //$NON-NLS-1$
			break;
		}

		sb.append(AuxServices.SPACE_T);
		this.rightAttr.toString(indent, sb);

		if (this.rightAttr.isMultiValued()) {
			sb.append(AuxServices.OPENPAREN_T + AuxServices.ISMULTIVALUED_T + AuxServices.CLOSEPAREN_T);
		}

		// finalize
		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

	/*
	 * FQL
	 */

	public String getLeftAttributeName() {

		return this.getLeftAttr().getAttrName();
	}

	public SpiFqlPrimitiveType getPrimitiveTypeOfLeftAttribute() {

		return this.getLeftAttr().getAttrType();
	}

	public boolean isLeftAttributeMultiValued() {

		return this.getLeftAttr().isMultiValued();
	}

	public SpiFqlQueryEntry getLeftQueryEntry() {

		return this.getLeftAtomicEntry();
	}

	public String getRightAttributeName() {

		return this.getRightAttr().getAttrName();
	}

	public SpiFqlPrimitiveType getPrimitiveTypeOfRightAttribute() {

		return this.getRightAttr().getAttrType();
	}

	public boolean isRightAttributeMultiValued() {

		return this.getRightAttr().isMultiValued();
	}

	public SpiFqlQueryEntry getRightQueryEntry() {

		return this.getRightAtomicEntry();
	}

}
