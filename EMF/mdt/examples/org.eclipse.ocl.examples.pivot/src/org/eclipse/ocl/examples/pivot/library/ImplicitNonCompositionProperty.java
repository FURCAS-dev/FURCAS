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
 * $Id: ImplicitNonCompositionProperty.java,v 1.1 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * The static instance of ImplicitNonCompositionProperty supports evaluation of
 * implicit properties for opposites of non-composition relationships.
 */
public class ImplicitNonCompositionProperty extends AbstractCallableImplementation
{
	public static final ImplicitNonCompositionProperty INSTANCE = new ImplicitNonCompositionProperty();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		ModelManager modelManager = evaluationVisitor.getModelManager();
		PropertyCallExp propertyCall = (PropertyCallExp) callExp;
		Property thisProperty = propertyCall.getReferredProperty();
		Property thatProperty = thisProperty.getOpposite();
		Type thatType = thisProperty.getType();		
		List<Value> results = new ArrayList<Value>();
		for (EObject eObject : modelManager.get(thatType)) {	// FIXME Use a cache
			EClass eClass = eObject.eClass();
			EStructuralFeature eFeature = eClass.getEStructuralFeature(thatProperty.getName());
			Object eGet = eObject.eGet(eFeature);
			if (eGet == sourceValue) {
				results.add(valueFactory.createObjectValue(eObject));
			}
		}
		return valueFactory.createBagValue(results);
	}
}