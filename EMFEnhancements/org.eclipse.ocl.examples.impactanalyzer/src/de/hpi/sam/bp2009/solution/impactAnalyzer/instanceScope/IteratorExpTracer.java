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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class IteratorExpTracer extends AbstractTracer<IteratorExp> {
    public IteratorExpTracer(IteratorExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result;
        String name = getExpression().getName();
        int opCode = OCLStandardLibraryUtil.getOperationCode(name);
        if (opCode == PredefinedType.SELECT || opCode == PredefinedType.REJECT || opCode == PredefinedType.SORTED_BY
                || opCode == PredefinedType.ANY) {
            result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getSource(), context, operationBodyToCallMapper,
                    getTupleLiteralPartNamesToLookFor(), oclFactory);
            if (opCode == PredefinedType.SELECT || opCode == PredefinedType.REJECT || opCode == PredefinedType.ANY) {
                // evaluate predicate before checking how it goes on
                org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> varDecl = getExpression().getIterator().get(0);
                EClass iteratorType = getInnermostElementType(varDecl.getType());
                result = pathCache.navigationStepFromSequence(getExpression(), getTupleLiteralPartNamesToLookFor(),
                        new PredicateCheckNavigationStep(getInnermostElementType(getExpression().getType()), iteratorType,
                                getExpression(), pathCache, oclFactory), result);
            }
        } else if (opCode == PredefinedType.COLLECT || opCode == PredefinedType.COLLECT_NESTED) {
            result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getBody(), context, operationBodyToCallMapper,
                    getTupleLiteralPartNamesToLookFor(), oclFactory);
        } else {
            // boolean or other non-class-type-result iterator
            result = new EmptyResultNavigationStep(getExpression());
        }
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }
    
    @Override
    protected Set<Variable> calculateEnteringScope(OperationBodyToCallMapper operationBodyToCallMapper) {
        Set<Variable> result;
        // which scope is entered depends on the specific operation
        int opCode = OCLStandardLibraryUtil.getOperationCode(getExpression().getName());
        if (opCode == PredefinedType.COLLECT || opCode == PredefinedType.COLLECT_NESTED){
            // collect and collect nested are traced back by tracing back their body expression, which opens a new scope;
            // all iterator variables enter scope
            result = new HashSet<Variable>();
            for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> v : getExpression().getIterator()) {
                result.add((Variable) v);
            }
        } else {
            result = Collections.emptySet();
        }
        return result;
    }
}
