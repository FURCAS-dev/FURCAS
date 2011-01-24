/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: EnumerationAllInstancesOperation.java,v 1.2 2011/01/24 19:56:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.enumeration;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ocl.examples.library.AbstractOperation;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * EnumerationAllInstancesOperation realises the Enumeration::allInstances() library operation.
 * 
 * @since 3.1
 */
public class EnumerationAllInstancesOperation extends AbstractOperation
{
	public static final EnumerationAllInstancesOperation INSTANCE = new EnumerationAllInstancesOperation();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceVal, OperationCallExp operationCall) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		StandardLibrary stdlib = evaluationVisitor.getStandardLibrary();
		Type sourceType = sourceVal.getType(stdlib, null);
		// the instances are the literals
//		for (EnumerationLiteral oclLiteral : ((Enumeration)sourceType).getOwnedLiterals()) {
//			EObject metaModelElement = oclLiteral.getMetaModelElement();
//			result.add(metaModelElement != null ? metaModelElement : oclLiteral);
//		}
		Set<Value> results = new HashSet<Value>();
		for (EnumerationLiteral instance : ((Enumeration)sourceType).getOwnedLiterals()) {
			results.add(valueFactory.createObjectValue(instance));
		}
		return valueFactory.createSetValue(results);
	}
}
