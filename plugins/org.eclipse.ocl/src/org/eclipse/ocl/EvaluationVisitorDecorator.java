/**
 * <copyright>
 *
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
 * $Id: EvaluationVisitorDecorator.java,v 1.2 2008/01/02 20:12:59 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.Map;
import java.util.Set;

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
import org.eclipse.ocl.utilities.ExpressionInOCL;


/**
 * A visitor that decorates another {@link EvaluationVisitor}, to intercept
 * invocations of the <code>visitXxx(...)</code> methods.  By default, every
 * visitation is simply delegated to the decorated visitor.  Subclasses may
 * extend these delegations with any additional behaviour that is required,
 * even replacing calls to the delegate where necessary.
 * <p>
 * This class works together with the {@link AbstractEvaluationVisitor} to
 * ensure that recursive <code>visitXxx()</code> calls are correctly intercepted
 * by me (and not just implemented within the decorated visitor).  Moreover,
 * this works with decorators nested to any depth.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public class EvaluationVisitorDecorator<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    implements EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

    private final EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> delegate;
    
    protected EvaluationVisitorDecorator(
            EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> decorated) {
        assert decorated != null : "cannot decorate a null visitor"; //$NON-NLS-1$
        
        this.delegate = decorated;
        
        setupRecursion(decorated, this);
    }
    
    /**
     * Configures the specified decorated visitor to correctly handle the
     * invocation of recursive <code>visitXxx(...)</code> calls.  In particular,
     * the tail of a chain of decorators is informed (if it is an
     * {@link AbstractEvaluationVisitor} of the head decorator of the chain,
     * so that recursive visitation follows the entire decorator chain at
     * every step.
     * 
     * @param decorated a visitor that is decorated by a decorator
     * @param decorator the decorator decorating the decorated visitor
     */
    static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    void setupRecursion(
            EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> decorated,
            EvaluationVisitorDecorator<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> decorator) {
        if (decorated instanceof AbstractEvaluationVisitor) {
            // tell the visitor to recursively invoke the head decorator so
            //   that it may intercept the recursion
            AbstractEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
                abstractVisitor = (AbstractEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) decorated;
            
            abstractVisitor.setVisitor(decorator);
        } else if (decorated instanceof EvaluationVisitorDecorator) {
            // propagate the head decorator down the chain to the tail
            //   (which, hopefully, is an AbstractEvaluationVisitor)
            EvaluationVisitorDecorator<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
                nestedDecorator = (EvaluationVisitorDecorator<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) decorated;
            
            setupRecursion(nestedDecorator.getDelegate(), decorator);
        }
    }
    
    /**
     * Obtains the visitor that I decorate.
     * 
     * @return my decorated visitor
     */
    protected final EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    getDelegate() {
        return delegate;
    }
    
    /**
     * Obtains my delegate's environment.
     */
    public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getEnvironment() {
        return getDelegate().getEnvironment();
    }

    /**
     * Obtains my delegate's evaluation environment.
     */
    public EvaluationEnvironment<C, O, P, CLS, E> getEvaluationEnvironment() {
        return getDelegate().getEvaluationEnvironment();
    }

    /**
     * Obtains my delegate's extent map.
     */
    public Map<? extends CLS, ? extends Set<? extends E>> getExtentMap() {
        return getDelegate().getExtentMap();
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitConstraint(CT constraint) {
        return getDelegate().visitConstraint(constraint);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitExpression(OCLExpression<C> expression) {
        return getDelegate().visitExpression(expression);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitAssociationClassCallExp(
            AssociationClassCallExp<C, P> callExp) {
        return getDelegate().visitAssociationClassCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitBooleanLiteralExp(BooleanLiteralExp<C> literalExp) {
        return getDelegate().visitBooleanLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitCollectionItem(CollectionItem<C> item) {
        return getDelegate().visitCollectionItem(item);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitCollectionLiteralExp(CollectionLiteralExp<C> literalExp) {
        return getDelegate().visitCollectionLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitCollectionRange(CollectionRange<C> range) {
        return getDelegate().visitCollectionRange(range);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitEnumLiteralExp(EnumLiteralExp<C, EL> literalExp) {
        return getDelegate().visitEnumLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitExpressionInOCL(ExpressionInOCL<C, PM> expression) {
        return getDelegate().visitExpressionInOCL(expression);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitIfExp(IfExp<C> ifExp) {
        return getDelegate().visitIfExp(ifExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitIntegerLiteralExp(IntegerLiteralExp<C> literalExp) {
        return getDelegate().visitIntegerLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitInvalidLiteralExp(InvalidLiteralExp<C> literalExp) {
        return getDelegate().visitInvalidLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitIterateExp(IterateExp<C, PM> callExp) {
        return getDelegate().visitIterateExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitIteratorExp(IteratorExp<C, PM> callExp) {
        return getDelegate().visitIteratorExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitLetExp(LetExp<C, PM> letExp) {
        return getDelegate().visitLetExp(letExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitMessageExp(MessageExp<C, COA, SSA> messageExp) {
        return getDelegate().visitMessageExp(messageExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitNullLiteralExp(NullLiteralExp<C> literalExp) {
        return getDelegate().visitNullLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitOperationCallExp(OperationCallExp<C, O> callExp) {
        return getDelegate().visitOperationCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitPropertyCallExp(PropertyCallExp<C, P> callExp) {
        return getDelegate().visitPropertyCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitRealLiteralExp(RealLiteralExp<C> literalExp) {
        return getDelegate().visitRealLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitStateExp(StateExp<C, S> stateExp) {
        return getDelegate().visitStateExp(stateExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitStringLiteralExp(StringLiteralExp<C> literalExp) {
        return getDelegate().visitStringLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitTupleLiteralExp(TupleLiteralExp<C, P> literalExp) {
        return getDelegate().visitTupleLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitTupleLiteralPart(TupleLiteralPart<C, P> part) {
        return getDelegate().visitTupleLiteralPart(part);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitTypeExp(TypeExp<C> typeExp) {
        return getDelegate().visitTypeExp(typeExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitUnlimitedNaturalLiteralExp(
            UnlimitedNaturalLiteralExp<C> literalExp) {
        return getDelegate().visitUnlimitedNaturalLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<C> unspecExp) {
        return getDelegate().visitUnspecifiedValueExp(unspecExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitVariable(Variable<C, PM> variable) {
        return getDelegate().visitVariable(variable);
    }

    /**
     * Delegates to my decorated visitor.
     */
    public Object visitVariableExp(VariableExp<C, PM> variableExp) {
        return getDelegate().visitVariableExp(variableExp);
    }
}
