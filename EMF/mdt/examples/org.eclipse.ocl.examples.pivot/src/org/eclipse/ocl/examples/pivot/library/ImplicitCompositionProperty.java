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
 * $Id: ImplicitCompositionProperty.java,v 1.1 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * The static instance of ImplicitCompositionProperty supports evaluation of
 * implicit properties for opposites of composition relationships.
 */
public class ImplicitCompositionProperty extends AbstractCallableImplementation
{
	public static final ImplicitCompositionProperty INSTANCE = new ImplicitCompositionProperty();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		EObject thisObject = (EObject) sourceValue.asObject();
		Object thatObject = thisObject.eContainer();
		if (thatObject != null) {
			return valueFactory.createObjectValue(thatObject);
		}
		else {
			return valueFactory.getNull();
		}
	}
}