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
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;


public class IfExpTracer extends AbstractTracer<IfExp> {
	public IfExpTracer(IfExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
		super(expression, tuplePartNames, oclFactory);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
		NavigationStep thenPath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getThenExpression(), context, operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor(), oclFactory);
		NavigationStep elsePath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getElseExpression(), context, operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor(), oclFactory);
		NavigationStep result = pathCache.navigationStepForBranch(getInnermostElementType(getExpression().getType()), context, getExpression(),
		        getTupleLiteralPartNamesToLookFor(), thenPath, elsePath);
		applyScopesOnNavigationStep(result, operationBodyToCallMapper);
		return result;
	}

}
