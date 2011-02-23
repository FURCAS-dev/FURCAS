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
package org.eclipse.ocl.examples.impactanalyzer.impl;

import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.Variable;

public interface OperationBodyToCallMapper {
    /**
     * Returns all the calls to the operation whose body is <tt>operationBodyExpression</tt> that are reachable from some scope.
     * Which scope this is depends on the particular implementation. If no such calls exist, an empty set is returned.
     * 
     * TODO generalize such that instead of an OperationCallExp this method can return a TCS::Property (template "invocation") as well
     */
    public Set<OperationCallExp> getCallsOf(OCLExpression operationBodyExpression);

    /**
     * Determines the <code>self</code> variables as used by the operation body or top-level non-operation-body (e.g., invariant)
     * expression <code>body</code>. While it might seem a little strange to have multiple <code>self</code> variables within the
     * same operation body, that's however what may happen in Ecore OCL. It would otherwise be tricky to identify the
     * <code>self</code> variable when given the body or the {@link EOperation} element. If <code>self</code> is not used by the
     * body, then <code>null</code> will be returned. Never returns <code>null</code> but may return an empty set.
     */
    public Set<Variable> getSelfVariablesUsedInBody(OCLExpression body);
    
    /**
     * Determines the <code>self</code> variable as used by the operation body <code>body</code>. It would otherwise
     * be tricky to identify the <code>self</code> variable when given the body or the {@link EOperation} element. If
     * <code>self</code> is not used by the body, then <code>null</code> will be returned. Never returns <code>null</code>
     * but may return an empty set.
     */
    public Set<Variable> getParameterVariablesUsedInBody(OCLExpression body);

    /**
     * Determines the body expression of an operation
     */
    public OCLExpression getOperationBody(EOperation operation);
}
