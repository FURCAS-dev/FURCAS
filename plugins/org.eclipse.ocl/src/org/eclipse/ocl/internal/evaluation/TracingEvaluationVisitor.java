/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TracingEvaluationVisitor.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.EvaluationVisitorDecorator;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.utilities.ExpressionInOCL;


/**
 * A decorator for evaluation visitors that is installed when evaluation tracing
 * is enabled, to trace interim evaluation results to the console.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TracingEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    extends EvaluationVisitorDecorator<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

    /**
     * Initializes me with the visitor whose evaluation I trace to the console.
     * 
     * @param decorated a real evaluation visitor
     */
    public TracingEvaluationVisitor(
            EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> decorated) {
        super(decorated);
    }

    private boolean isInvalid(Object value) {
        return value == getEnvironment().getOCLStandardLibrary().getOclInvalid();
    }
    
    private Object trace(Object expression, Object value) {
        try {
            OCLPlugin.trace("Evaluate: " + expression); //$NON-NLS-1$
            OCLPlugin.trace("Result  : " + //$NON-NLS-1$
                (isInvalid(value)? "OclInvalid" : String.valueOf(value))); //$NON-NLS-1$
        } catch (Exception e) {
            // tracing must not interfere with evaluation
        }
        
        return value;
    }
    
    @Override
    public Object visitAssociationClassCallExp(
            AssociationClassCallExp<C, P> callExp) {
        return trace(callExp, getDelegate().visitAssociationClassCallExp(callExp));
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitBooleanLiteralExp(literalExp));
    }

    @Override
    public Object visitCollectionItem(CollectionItem<C> item) {
        return trace(item, getDelegate().visitCollectionItem(item));
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitCollectionLiteralExp(literalExp));
    }

    @Override
    public Object visitCollectionRange(CollectionRange<C> range) {
        return trace(range, getDelegate().visitCollectionRange(range));
    }

    @Override
    public Object visitConstraint(CT constraint) {
        return trace(constraint, getDelegate().visitConstraint(constraint));
    }

    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<C, EL> literalExp) {
        return trace(literalExp, getDelegate().visitEnumLiteralExp(literalExp));
    }

    @Override
    public Object visitExpression(OCLExpression<C> expression) {
        return trace(expression, getDelegate().visitExpression(expression));
    }

    @Override
    public Object visitExpressionInOCL(ExpressionInOCL<C, PM> expression) {
        return trace(expression, getDelegate().visitExpressionInOCL(expression));
    }

    @Override
    public Object visitIfExp(IfExp<C> ifExp) {
        return trace(ifExp, getDelegate().visitIfExp(ifExp));
    }

    @Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitIntegerLiteralExp(literalExp));
    }

    @Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitInvalidLiteralExp(literalExp));
    }

    @Override
    public Object visitIterateExp(IterateExp<C, PM> callExp) {
        return trace(callExp, getDelegate().visitIterateExp(callExp));
    }

    @Override
    public Object visitIteratorExp(IteratorExp<C, PM> callExp) {
        return trace(callExp, getDelegate().visitIteratorExp(callExp));
    }

    @Override
    public Object visitLetExp(LetExp<C, PM> letExp) {
        return trace(letExp, getDelegate().visitLetExp(letExp));
    }

    @Override
    public Object visitMessageExp(MessageExp<C, COA, SSA> messageExp) {
        return trace(messageExp, getDelegate().visitMessageExp(messageExp));
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitNullLiteralExp(literalExp));
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<C, O> callExp) {
        return trace(callExp, getDelegate().visitOperationCallExp(callExp));
    }

    @Override
    public Object visitPropertyCallExp(PropertyCallExp<C, P> callExp) {
        return trace(callExp, getDelegate().visitPropertyCallExp(callExp));
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitRealLiteralExp(literalExp));
    }

    @Override
    public Object visitStateExp(StateExp<C, S> stateExp) {
        return trace(stateExp, getDelegate().visitStateExp(stateExp));
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitStringLiteralExp(literalExp));
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<C, P> literalExp) {
        return trace(literalExp, getDelegate().visitTupleLiteralExp(literalExp));
    }

    @Override
    public Object visitTupleLiteralPart(TupleLiteralPart<C, P> part) {
        return trace(part, getDelegate().visitTupleLiteralPart(part));
    }

    @Override
    public Object visitTypeExp(TypeExp<C> typeExp) {
        return trace(typeExp, getDelegate().visitTypeExp(typeExp));
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(
            UnlimitedNaturalLiteralExp<C> literalExp) {
        return trace(literalExp, getDelegate().visitUnlimitedNaturalLiteralExp(literalExp));
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<C> unspecExp) {
        return trace(unspecExp, getDelegate().visitUnspecifiedValueExp(unspecExp));
    }

    @Override
    public Object visitVariable(Variable<C, PM> variable) {
        return trace(variable, getDelegate().visitVariable(variable));
    }

    @Override
    public Object visitVariableExp(VariableExp<C, PM> variableExp) {
        return trace(variableExp, getDelegate().visitVariableExp(variableExp));
    }
}
