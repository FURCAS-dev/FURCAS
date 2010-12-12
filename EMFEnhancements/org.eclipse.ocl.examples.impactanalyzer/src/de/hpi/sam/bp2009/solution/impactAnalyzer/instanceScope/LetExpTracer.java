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
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class LetExpTracer extends AbstractTracer<LetExp> {
    public LetExpTracer(LetExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getIn(), context,
                operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor(), oclFactory);
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

    @Override
    protected Set<Variable> calculateEnteringScope(OperationBodyToCallMapper operationBodyToCallMapper) {
        // tracing back a LetExp always leads to a traceback of the in expression, which opens a new scope
        return Collections.singleton((Variable) getExpression().getVariable());
    }
}
