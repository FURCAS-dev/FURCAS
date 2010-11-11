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
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class TupleLiteralExpTracer extends AbstractTracer<TupleLiteralExp> {
    public TupleLiteralExpTracer(TupleLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = null;
        if (isLookingForTuplePart()) {
            String partName = getTuplePartNameLookedFor();
            for (TupleLiteralPart<EClassifier, EStructuralFeature> part : getExpression().getPart()) {
                if (part.getName().equals(partName)) {
                    result = pathCache.getOrCreateNavigationPath((OCLExpression) part.getValue(), context, operationBodyToCallMapper,
                                getListOfTuplePartNamesWithFoundRemoved(), oclFactory);
                    break;
                }
            }
        }
        if (result == null) {
            result = super.traceback(context, pathCache, operationBodyToCallMapper); // create an empty step
        }
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }
}
