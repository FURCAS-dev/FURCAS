/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ClassifierAllInstancesOperation.java,v 1.4 2011/04/25 09:48:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.classifier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * ClassifierAllInstancesOperation realises the Classifier::allInstances() library operation.
 * 
 * @since 3.1
 */
public class ClassifierAllInstancesOperation extends AbstractOperation
{
	public static final ClassifierAllInstancesOperation INSTANCE = new ClassifierAllInstancesOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) throws InvalidValueException {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		TypeValue typeVal = sourceVal.asTypeValue();
		ModelManager modelManager = evaluationVisitor.getModelManager();
		Set<Value> results = new HashSet<Value>();
		Set<?> instances = modelManager.get(typeVal.getInstanceType());
		if (instances == null) {
			return valueFactory.getEmptySetValue();
		}
		for (Object instance : instances) {
			results.add(valueFactory.createObjectValue(instance));	// FIXME Move to model manager
		}
		return valueFactory.createSetValue(results);
	}
}
