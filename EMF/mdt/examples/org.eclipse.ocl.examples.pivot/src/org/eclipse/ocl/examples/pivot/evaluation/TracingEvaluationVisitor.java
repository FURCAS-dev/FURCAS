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
 * $Id: TracingEvaluationVisitor.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
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
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;


/**
 * A decorator for evaluation visitors that is installed when evaluation tracing
 * is enabled, to trace interim evaluation results to the console.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TracingEvaluationVisitor extends EvaluationVisitorDecorator {

    /**
     * Initializes me with the visitor whose evaluation I trace to the console.
     * 
     * @param decorated a real evaluation visitor
     */
    public TracingEvaluationVisitor(EvaluationVisitor decorated) {
        super(decorated);
    }

	@Override
	public EvaluationVisitor createNestedVisitor() {
		return new TracingEvaluationVisitor(super.createNestedVisitor());
	}

	public ValueFactory getValueFactory() {
		return getDelegate().getValueFactory();
	}

//    private boolean isInvalid(Object value) {
//        return value == getEnvironment().getOCLStandardLibrary().getInvalidValue();
//    }
    
    private Value trace(Object expression, Value value) {
        try {
            PivotPlugin.trace("Evaluate: " + expression); //$NON-NLS-1$
            PivotPlugin.trace("Result  : " + //$NON-NLS-1$
                (value.isInvalid() ? "OclInvalid" : String.valueOf(value))); //$NON-NLS-1$
        } catch (Exception e) {
            // tracing must not interfere with evaluation
        }
        
        return value;
    }
    
    @Override
    public Value visitAssociationClassCallExp(AssociationClassCallExp callExp) {
        return trace(callExp, getDelegate().visitAssociationClassCallExp(callExp));
    }

    @Override
    public Value visitBooleanLiteralExp(BooleanLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitBooleanLiteralExp(literalExp));
    }

    @Override
    public Value visitCollectionItem(CollectionItem item) {
        return trace(item, getDelegate().visitCollectionItem(item));
    }

    @Override
    public Value visitCollectionLiteralExp(CollectionLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitCollectionLiteralExp(literalExp));
    }

    @Override
    public Value visitCollectionRange(CollectionRange range) {
        return trace(range, getDelegate().visitCollectionRange(range));
    }

    @Override
    public Value visitConstraint(Constraint constraint) {
        return trace(constraint, getDelegate().visitConstraint(constraint));
    }

    @Override
    public Value visitEnumLiteralExp(EnumLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitEnumLiteralExp(literalExp));
    }

//    @Override
//    public Value visitExpression(OclExpression expression) {
//        return trace(expression, getDelegate().visitExpression(expression));
//    }

    @Override
    public Value visitExpressionInOcl(ExpressionInOcl expression) {
        return trace(expression, getDelegate().visitExpressionInOcl(expression));
    }

    @Override
    public Value visitIfExp(IfExp ifExp) {
        return trace(ifExp, getDelegate().visitIfExp(ifExp));
    }

    @Override
    public Value visitIntegerLiteralExp(IntegerLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitIntegerLiteralExp(literalExp));
    }

    @Override
    public Value visitInvalidLiteralExp(InvalidLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitInvalidLiteralExp(literalExp));
    }

    @Override
    public Value visitLetExp(LetExp letExp) {
        return trace(letExp, getDelegate().visitLetExp(letExp));
    }

    @Override
    public Value visitMessageExp(MessageExp messageExp) {
        return trace(messageExp, getDelegate().visitMessageExp(messageExp));
    }

    @Override
    public Value visitNullLiteralExp(NullLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitNullLiteralExp(literalExp));
    }

    @Override
    public Value visitOperationCallExp(OperationCallExp callExp) {
        return trace(callExp, getDelegate().visitOperationCallExp(callExp));
    }

    @Override
    public Value visitPropertyCallExp(PropertyCallExp callExp) {
        return trace(callExp, getDelegate().visitPropertyCallExp(callExp));
    }

    @Override
    public Value visitRealLiteralExp(RealLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitRealLiteralExp(literalExp));
    }

    @Override
    public Value visitStateExp(StateExp stateExp) {
        return trace(stateExp, getDelegate().visitStateExp(stateExp));
    }

    @Override
    public Value visitStringLiteralExp(StringLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitStringLiteralExp(literalExp));
    }

    @Override
    public Value visitTupleLiteralExp(TupleLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitTupleLiteralExp(literalExp));
    }

    @Override
    public Value visitTupleLiteralPart(TupleLiteralPart part) {
        return trace(part, getDelegate().visitTupleLiteralPart(part));
    }

    @Override
    public Value visitTypeExp(TypeExp typeExp) {
        return trace(typeExp, getDelegate().visitTypeExp(typeExp));
    }

    @Override
    public Value visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitUnlimitedNaturalLiteralExp(literalExp));
    }

    @Override
    public Value visitUnspecifiedValueExp(UnspecifiedValueExp unspecExp) {
        return trace(unspecExp, getDelegate().visitUnspecifiedValueExp(unspecExp));
    }

    @Override
    public Value visitVariable(Variable variable) {
        return trace(variable, getDelegate().visitVariable(variable));
    }

    @Override
    public Value visitVariableExp(VariableExp variableExp) {
        return trace(variableExp, getDelegate().visitVariableExp(variableExp));
    }
}
