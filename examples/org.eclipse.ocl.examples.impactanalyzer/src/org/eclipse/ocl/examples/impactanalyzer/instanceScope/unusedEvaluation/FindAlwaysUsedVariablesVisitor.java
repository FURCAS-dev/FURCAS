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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * For an OCL expression finds out which of the {@link Variable}s referred by any {@link VariableExp} within
 * the expression will inevitably be used, regardless the values of any variables, deciding which branches
 * may be taken. This can be useful to avoid expression evaluations when such variables are not yet defined.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class FindAlwaysUsedVariablesVisitor extends AbstractVisitor<Set<VariableExp>, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
    public FindAlwaysUsedVariablesVisitor() {
        super(new HashSet<VariableExp>());
    }
    
    @Override
    public Set<VariableExp> visitVariableExp(org.eclipse.ocl.expressions.VariableExp<EClassifier, EParameter> v) {
        return Collections.singleton((org.eclipse.ocl.ecore.VariableExp) v);
    }

    /**
     * For an operation call it's not sure that the argument expression(s) will actually be evaluated. Examples of unused argument
     * expressions are -&gt;at(...) expressions on empty collections where the partial evaluator may cut that short to <code>invalid</code>
     * as well as Boolean shortcut evaluation.
     */
    @Override
    protected Set<VariableExp> handleOperationCallExp(OperationCallExp<EClassifier, EOperation> callExp, Set<VariableExp> sourceResult,
            List<Set<VariableExp>> argumentResults) {
        Set<VariableExp> result = sourceResult;
        if (areArgumentsUsedInevitably(callExp)) {
            // in this case, all arguments will be evaluated, too:
            result = combine(sourceResult, argumentResults);
        }
        return result;
    }

    /**
     * Checks if the evaluator will evaluate the arguments. Mostly they are; however, Boolean shortcut evaluation serves
     * as a counter example, as does our own redefinition of <code>-&gt;at(...)</code> shortcut evaluation on empty collection.
     * The current OCL evaluator implementation even evaluates the argument expressions if the source expression evaluated
     * to an undefined / <code>null</code> result.
     */
    private boolean areArgumentsUsedInevitably(OperationCallExp<EClassifier, EOperation> callExp) {
        Class<?> sourceTypeInstanceClass;
        return callExp.getOperationCode() != PredefinedType.AT
               && (sourceTypeInstanceClass = callExp.getSource().getType().getInstanceClass()) != null &&
                       !Boolean.class.isAssignableFrom(sourceTypeInstanceClass);
    }

    @Override
    protected Set<VariableExp> handlePropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> callExp,
            Set<VariableExp> sourceResult, List<Set<VariableExp>> qualifierResults) {
        return sourceResult;
    }

    /**
     * An if-expression inevitably uses all variables that are inevitably used in the condition plus those inevitably used in
     * both, the <code>then</code> and the <code>else</code> branch.
     */
    @Override
    protected Set<VariableExp> handleIfExp(IfExp<EClassifier> ifExp, Set<VariableExp> conditionResult, Set<VariableExp> thenResult,
            Set<VariableExp> elseResult) {
        Set<VariableExp> result = new HashSet<VariableExp>(thenResult);
        result.retainAll(elseResult);
        result.addAll(conditionResult);
        return result;
    }

    @Override
    protected Set<VariableExp> handleTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> literalExp,
            List<Set<VariableExp>> partResults) {
        return combine(partResults);
    }

    @Override
    protected Set<VariableExp> handleTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> part,
            Set<VariableExp> valueResult) {
        return valueResult;
    }

    /**
     * For a <code>let</code> expression, all variables inevitably used in the variable's initialization
     * expression as well as all variables inevitably used in the <code>in</code> expression are used inevitably
     * by the <code>let</code> expression.
     */
    @Override
    protected Set<VariableExp> handleLetExp(LetExp<EClassifier, EParameter> letExp, Set<VariableExp> variableResult,
            Set<VariableExp> inResult) {
        return combine(variableResult, inResult);
    }

    @Override
    protected Set<VariableExp> handleCollectionLiteralExp(CollectionLiteralExp<EClassifier> literalExp,
            List<Set<VariableExp>> partResults) {
        return combine(partResults);
    }

    @Override
    protected Set<VariableExp> handleCollectionItem(CollectionItem<EClassifier> item, Set<VariableExp> itemResult) {
        return itemResult;
    }

    @Override
    protected Set<VariableExp> handleCollectionRange(CollectionRange<EClassifier> range, Set<VariableExp> firstResult,
            Set<VariableExp> lastResult) {
        return combine(firstResult, lastResult);
    }

    @Override
    protected Set<VariableExp> handleIteratorExp(IteratorExp<EClassifier, EParameter> callExp, Set<VariableExp> sourceResult,
            List<Set<VariableExp>> variableResults, Set<VariableExp> bodyResult) {
        return sourceResult;
    }

    @Override
    protected Set<VariableExp> handleIterateExp(IterateExp<EClassifier, EParameter> callExp, Set<VariableExp> sourceResult,
            List<Set<VariableExp>> variableResults, Set<VariableExp> resultResult, Set<VariableExp> bodyResult) {
        return combine(sourceResult, resultResult);
    }

    @Override
    protected Set<VariableExp> handleExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> expression,
            Set<VariableExp> contextResult, Set<VariableExp> resultResult, List<Set<VariableExp>> parameterResults,
            Set<VariableExp> bodyResult) {
        return bodyResult;
    }

    @Override
    protected Set<VariableExp> handleConstraint(Constraint constraint, Set<VariableExp> specificationResult) {
        return specificationResult;
    }

    @Override
    protected Set<VariableExp> handleVariable(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> variable,
            Set<VariableExp> initResult) {
        return initResult;
    }
    
    
    private Set<VariableExp> combine(Set<VariableExp> firstResult, Set<VariableExp> secondResult) {
        Set<VariableExp> result = new HashSet<VariableExp>(firstResult);
        result.addAll(secondResult);
        return result;
    }

    private Set<VariableExp> combine(List<Set<VariableExp>> results) {
        Set<VariableExp> result = new HashSet<VariableExp>();
        for (Set<VariableExp> partResult : results) {
            result.addAll(partResult);
        }
        return result;
    }

    private Set<VariableExp> combine(Set<VariableExp> sourceResult, List<Set<VariableExp>> argumentResults) {
        Set<VariableExp> result = new HashSet<VariableExp>(sourceResult);
        for (Set<VariableExp> partResult : argumentResults) {
            result.addAll(partResult);
        }
        return result;
    }

    @Override
    public Set<VariableExp> visitOperationCallExp(OperationCallExp<EClassifier, EOperation> callExp) {
        // TODO Implement FindAlwaysUsedVariablesVisitor.visitOperationCallExp(...)
        return super.visitOperationCallExp(callExp);
    }

    @Override
    public Set<VariableExp> visitIteratorExp(IteratorExp<EClassifier, EParameter> callExp) {
        // TODO Implement FindAlwaysUsedVariablesVisitor.visitIteratorExp(...)
        return super.visitIteratorExp(callExp);
    }

    @Override
    public Set<VariableExp> visitIterateExp(IterateExp<EClassifier, EParameter> callExp) {
        // TODO Implement FindAlwaysUsedVariablesVisitor.visitIterateExp(...)
        return super.visitIterateExp(callExp);
    }

    @Override
    public Set<VariableExp> visitExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> expression) {
        // TODO Implement FindAlwaysUsedVariablesVisitor.visitExpressionInOCL(...)
        return super.visitExpressionInOCL(expression);
    }

    protected Set<VariableExp> handleOppositePropertyCallExp(OppositePropertyCallExp callExp, Set<VariableExp> sourceResult) {
        return sourceResult;
    }

    /**
     * Visits the property-call source and then its qualifiers (if any). Returns the result of
     * {@link #handlePropertyCallExp(PropertyCallExp, Object, List)}.
     */
    public Set<VariableExp> visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
        // source is null when the property call expression is an
        // association class navigation qualifier
        Set<VariableExp> sourceResult = safeVisit(callExp.getSource());
        return handleOppositePropertyCallExp(callExp, sourceResult);
    }
}
