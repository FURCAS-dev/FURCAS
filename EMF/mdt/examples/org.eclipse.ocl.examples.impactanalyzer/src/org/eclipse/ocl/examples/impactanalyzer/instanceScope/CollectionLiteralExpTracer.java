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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.expressions.CollectionLiteralPart;


public class CollectionLiteralExpTracer extends AbstractTracer<CollectionLiteralExp> {
    public CollectionLiteralExpTracer(CollectionLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        EList<CollectionLiteralPart<EClassifier>> parts = (EList<CollectionLiteralPart<EClassifier>>) getExpression().getPart();
        List<NavigationStep> steps = new ArrayList<NavigationStep>();
        NavigationStep result;
        
        for (Iterator<CollectionLiteralPart<EClassifier>> i = parts.iterator(); i.hasNext();) {
            CollectionLiteralPart<EClassifier> part = i.next();
            if (part instanceof CollectionItem) {
                steps.add(pathCache.getOrCreateNavigationPath((OCLExpression) ((CollectionItem) part)
                        .getItem(), context, operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor(), oclFactory));
            }
        }
        if (getExpression().getPart().size() > 0){
            EClass innermostType = getInnermostElementType(getExpression().getType());
            result = pathCache.navigationStepForBranch(innermostType, context, getExpression(),
                    getTupleLiteralPartNamesToLookFor(), steps.toArray(new NavigationStep[0]));
        } else {
            //the collection was empty, like "Set{}"
            result = new EmptyResultNavigationStep(getExpression());
        }
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

}
