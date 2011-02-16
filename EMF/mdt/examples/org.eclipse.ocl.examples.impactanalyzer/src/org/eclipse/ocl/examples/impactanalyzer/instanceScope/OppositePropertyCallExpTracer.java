/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;



public class OppositePropertyCallExpTracer extends  AbstractTracer<OppositePropertyCallExp> {

    protected OppositePropertyCallExpTracer(OppositePropertyCallExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        // reverse traversal of a reverted reference is traversing the original reference itself
        NavigationStep result = new AssociationNavigationStep(
                getInnermostElementType(getExpression().getType()),
                getInnermostElementType(getExpression().getSource().getType()),
                (EReference)getExpression().getReferredOppositeProperty(),
                getExpression());
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

}
