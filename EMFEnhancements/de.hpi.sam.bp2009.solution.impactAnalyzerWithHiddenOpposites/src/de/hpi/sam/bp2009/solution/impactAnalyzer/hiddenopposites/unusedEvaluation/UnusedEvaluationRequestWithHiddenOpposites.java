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
package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.unusedEvaluation;

import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.PartialEvaluatorNoAllInstances;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;

/**
 * Specializes {@link UnusedEvaluationRequest} because here we need to use {@link FindAlwaysUsedVariablesVisitorWithHiddenOpposites}
 * to handle {@link OppositePropertyCallExp} expressions as well.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class UnusedEvaluationRequestWithHiddenOpposites extends UnusedEvaluationRequest {
    /**
     * Must not be called from anywhere except {@link UnusedEvaluationRequestFactory#getUnusedEvaluationRequest(OCLExpression, Object, Map, Set)}
     * because resulting instances need to be <em>managed</em> as their equality and hash code fall back to their identity. Hence,
     * equal objects in a given scope must be guaranteed to be identical. Such a scope is defined by the use of a
     * {@link UnusedEvaluationRequestFactory}.
     * 
     * @param expression
     *            the expression to evaluate
     * @param resultIndicatingUnused
     *            if <code>expression</code> evaluates to this result, this request will return <code>true</code> from its
     *            {@link #evaluate(OppositeEndFinder, OCL)} method; as a special case, <code>null</code> will be considered "equal"
     *            to an empty collection as the result of evaluating <code>expression</code>
     * @param inferredVariableValues
     *            may be <code>null</code>. In this case, a new {@link Map} is created internally.
     * @param slots
     *            the variables currently within their dynamic scope such that, when a value is inferred for such a variable, it
     *            is correct to assign it for use in evaluating <code>expression</code> in this request
     */
    UnusedEvaluationRequestWithHiddenOpposites(OCLExpression expression, Object resultIndicatingUnused,
            Map<Variable, Object> inferredVariableValues, Set<Variable> slots) {
        this(expression, resultIndicatingUnused, inferredVariableValues, slots,
                expression.accept(new FindAlwaysUsedVariablesVisitorWithHiddenOpposites()));
    }
    
    /**
     * Must not be called from anywhere except {@link UnusedEvaluationRequestFactory#getUnusedEvaluationRequest(OCLExpression, Object, Map, Set)}
     * because resulting instances need to be <em>managed</em> as their equality and hash code fall back to their identity. Hence,
     * equal objects in a given scope must be guaranteed to be identical. Such a scope is defined by the use of a
     * {@link UnusedEvaluationRequestFactory}.
     * 
     * @param expression
     *            the expression to evaluate
     * @param resultIndicatingUnused
     *            if <code>expression</code> evaluates to this result, this request will return <code>true</code> from its
     *            {@link #evaluate(OppositeEndFinder, OCL)} method; as a special case, <code>null</code> will be considered "equal"
     *            to an empty collection as the result of evaluating <code>expression</code>
     * @param inferredVariableValues
     *            may be <code>null</code>. In this case, a new {@link Map} is created internally.
     * @param slots
     *            the variables currently within their dynamic scope such that, when a value is inferred for such a variable, it
     *            is correct to assign it for use in evaluating <code>expression</code> in this request
     */
    UnusedEvaluationRequestWithHiddenOpposites(OCLExpression expression, Object resultIndicatingUnused,
            Map<Variable, Object> inferredVariableValues, Set<Variable> slots, Set<VariableExp> inevitableVariableUsages) {
        super(expression, resultIndicatingUnused, inferredVariableValues, slots, inevitableVariableUsages);
    }
    
    protected PartialEvaluatorNoAllInstances createPartialEvaluatorNoAllInstances(OppositeEndFinder oppositeEndFinder,
            OCLFactory oclFactory) {
        return new PartialEvaluatorNoAllInstancesWithHiddenOpposites(oppositeEndFinder, oclFactory);
    }
}
