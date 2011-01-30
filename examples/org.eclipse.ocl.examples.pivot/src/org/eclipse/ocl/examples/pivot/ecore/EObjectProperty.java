/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EObjectProperty.java,v 1.1 2011/01/30 11:17:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;

/** 
 * An EObjectProperty provides the standard CallableImplementation to implement a
 * PropertyCallExp. When constructed with a null specification, the call just accesses
 * the property field in a source object. When constructed with a non-null specification,
 * the specification defines the access algorithm, which if provided as an OpaqueExpression
 * is lazily compiled from OCL source text.
 */
public class EObjectProperty implements CallableImplementation
{
	protected final EStructuralFeature eFeature;
	protected ValueSpecification specification;

	public EObjectProperty(EStructuralFeature eFeature, ValueSpecification specification) {
		this.eFeature = eFeature;
		this.specification = specification;
	}

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		Object object = sourceValue.asObject();
		if (!(object instanceof EObject)) {
			return sourceValue.toInvalidValue();
		}
		Object eValue = ((EObject)object).eGet(eFeature);
		return evaluationVisitor.getValueFactory().valueOf(eValue, eFeature);
	}

	public Diagnostic validate(TypeManager typeManager, CallExp callExp) {
		return null;
	}
}