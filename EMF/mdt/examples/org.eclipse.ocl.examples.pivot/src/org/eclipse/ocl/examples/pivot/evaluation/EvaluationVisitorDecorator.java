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
 * $Id: EvaluationVisitorDecorator.java,v 1.4 2011/02/08 17:51:47 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.values.Value;

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
public abstract class EvaluationVisitorDecorator extends AbstractExtendingVisitor<Value, Object> implements EvaluationVisitor {

    private final EvaluationVisitor delegate;
    
    protected EvaluationVisitorDecorator(EvaluationVisitor decorated) {
        super(null);
        assert decorated != null : "cannot decorate a null visitor"; //$NON-NLS-1$
        
        this.delegate = decorated;
        
        decorated.setUndecoratedVisitor(this);
    }

    /**
     * Delegates to my decorated visitor.
     */
	public EvaluationVisitor createNestedVisitor() {
        return getDelegate().createNestedVisitor();
	}
  
    /**
     * Obtains the visitor that I decorate.
     * 
     * @return my decorated visitor
     */
    protected final EvaluationVisitor getDelegate() {
        return delegate;
    }
    
    /**
     * Obtains my delegate's environment.
     */
    public Environment getEnvironment() {
        return getDelegate().getEnvironment();
    }

    /**
     * Obtains my delegate's evaluation environment.
     */
    public EvaluationEnvironment getEvaluationEnvironment() {
        return getDelegate().getEvaluationEnvironment();
    }

    /**
     * Obtains my delegate's extent map.
     */
    public ModelManager getModelManager() {
        return getDelegate().getModelManager();
    }

    /**
     * Delegates to my decorated visitor.
     */
	public void setUndecoratedVisitor(EvaluationVisitor evaluationVisitor) {
        getDelegate().setUndecoratedVisitor(evaluationVisitor);
	}

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitConstraint(Constraint constraint) {
        return getDelegate().visitConstraint(constraint);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitAssociationClassCallExp(
            AssociationClassCallExp callExp) {
        return getDelegate().visitAssociationClassCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitBooleanLiteralExp(BooleanLiteralExp literalExp) {
        return getDelegate().visitBooleanLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitCollectionItem(CollectionItem item) {
        return getDelegate().visitCollectionItem(item);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitCollectionLiteralExp(CollectionLiteralExp literalExp) {
        return getDelegate().visitCollectionLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitCollectionRange(CollectionRange range) {
        return getDelegate().visitCollectionRange(range);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitEnumLiteralExp(EnumLiteralExp literalExp) {
        return getDelegate().visitEnumLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitExpressionInOcl(ExpressionInOcl expression) {
        return getDelegate().visitExpressionInOcl(expression);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitIfExp(IfExp ifExp) {
        return getDelegate().visitIfExp(ifExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitIntegerLiteralExp(IntegerLiteralExp literalExp) {
        return getDelegate().visitIntegerLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitInvalidLiteralExp(InvalidLiteralExp literalExp) {
        return getDelegate().visitInvalidLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitLetExp(LetExp letExp) {
        return getDelegate().visitLetExp(letExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitMessageExp(MessageExp messageExp) {
        return getDelegate().visitMessageExp(messageExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitNullLiteralExp(NullLiteralExp literalExp) {
        return getDelegate().visitNullLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitOperationCallExp(OperationCallExp callExp) {
        return getDelegate().visitOperationCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitPropertyCallExp(PropertyCallExp callExp) {
        return getDelegate().visitPropertyCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitRealLiteralExp(RealLiteralExp literalExp) {
        return getDelegate().visitRealLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitStateExp(StateExp stateExp) {
        return getDelegate().visitStateExp(stateExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitStringLiteralExp(StringLiteralExp literalExp) {
        return getDelegate().visitStringLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitTupleLiteralExp(TupleLiteralExp literalExp) {
        return getDelegate().visitTupleLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitTupleLiteralPart(TupleLiteralPart part) {
        return getDelegate().visitTupleLiteralPart(part);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitTypeExp(TypeExp typeExp) {
        return getDelegate().visitTypeExp(typeExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitUnlimitedNaturalLiteralExp(
            UnlimitedNaturalLiteralExp literalExp) {
        return getDelegate().visitUnlimitedNaturalLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitUnspecifiedValueExp(UnspecifiedValueExp unspecExp) {
        return getDelegate().visitUnspecifiedValueExp(unspecExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitVariable(Variable variable) {
        return getDelegate().visitVariable(variable);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Value visitVariableExp(VariableExp variableExp) {
        return getDelegate().visitVariableExp(variableExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
	public Value visiting(Visitable visitable) {
        return getDelegate().visiting(visitable);
	}
}
