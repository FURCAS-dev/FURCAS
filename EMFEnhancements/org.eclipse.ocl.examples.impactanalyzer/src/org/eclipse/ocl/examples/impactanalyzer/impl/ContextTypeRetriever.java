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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.utilities.AbstractVisitor;
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
 * From an OCL expression tries to determine the context type for <code>self</code> by looking for {@link VariableExp} expressions
 * in the expression tree referencing the <code>self</code> variable and extracting the expression's type. If no <code>self</code>
 * expression is found, <code>null</code> is returned.
 * <p>
 * 
 * Note, that this visitor will not descend into the bodies of called operations or derived properties because there the
 * <code>self</code> variable's type doesn't imply the overall context type.
 * <p>
 * 
 * @author Axel Uhl
 * 
 */
public class ContextTypeRetriever extends AbstractVisitor<EClass> {

    /**
     * Initializes the result with <code>null</code> for the case that no <code>self</code> reference is found in the expression
     * tree
     */
    public ContextTypeRetriever() {
        super();
    }

    @Override
    public EClass visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        if (result == null) {
            if (v.getReferredVariable().getName().equals(EcoreEnvironment.SELF_VARIABLE_NAME)) {
                result = (EClass) v.getType();
                return result;
            }
        }
        return super.visitVariableExp(v);
    }

    @Override
    public EClass visitOperationCallExp(OperationCallExp<EClassifier, EOperation> callExp) {
        if (result == null)
            return super.visitOperationCallExp(callExp);
        else
            return result;
    }

    @Override
    public EClass visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> callExp) {
        if (result == null)
            return super.visitPropertyCallExp(callExp);
        else
            return result;
    }

    @Override
    public EClass visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> callExp) {
        if (result == null)
            return super.visitAssociationClassCallExp(callExp);
        else
            return result;
    }

    @Override
    public EClass visitVariable(Variable<EClassifier, EParameter> variable) {
        if (result == null)
            return super.visitVariable(variable);
        else
            return result;
    }

    @Override
    public EClass visitIfExp(IfExp<EClassifier> ifExp) {
        if (result == null)
            return super.visitIfExp(ifExp);
        else
            return result;
    }

    @Override
    public EClass visitTypeExp(TypeExp<EClassifier> t) {
        if (result == null)
            return super.visitTypeExp(t);
        else
            return result;
    }

    @Override
    public EClass visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> messageExp) {
        if (result == null)
            return super.visitMessageExp(messageExp);
        else
            return result;
    }

    @Override
    public EClass visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> unspecExp) {
        if (result == null)
            return super.visitUnspecifiedValueExp(unspecExp);
        else
            return result;
    }

    @Override
    public EClass visitStateExp(StateExp<EClassifier, EObject> stateExp) {
        if (result == null)
            return super.visitStateExp(stateExp);
        else
            return result;
    }

    @Override
    public EClass visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitIntegerLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitUnlimitedNaturalLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitRealLiteralExp(RealLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitRealLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitStringLiteralExp(StringLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitStringLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitBooleanLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitNullLiteralExp(NullLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitNullLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitInvalidLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> literalExp) {
        if (result == null)
            return super.visitTupleLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> part) {
        if (result == null)
            return super.visitTupleLiteralPart(part);
        else
            return result;
    }

    @Override
    public EClass visitLetExp(LetExp<EClassifier, EParameter> letExp) {
        if (result == null)
            return super.visitLetExp(letExp);
        else
            return result;
    }

    @Override
    public EClass visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> literalExp) {
        if (result == null)
            return super.visitEnumLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> literalExp) {
        if (result == null)
            return super.visitCollectionLiteralExp(literalExp);
        else
            return result;
    }

    @Override
    public EClass visitCollectionItem(CollectionItem<EClassifier> item) {
        if (result == null)
            return super.visitCollectionItem(item);
        else
            return result;
    }

    @Override
    public EClass visitCollectionRange(CollectionRange<EClassifier> range) {
        if (result == null)
            return super.visitCollectionRange(range);
        else
            return result;
    }

    @Override
    public EClass visitIteratorExp(IteratorExp<EClassifier, EParameter> callExp) {
        if (result == null)
            return super.visitIteratorExp(callExp);
        else
            return result;
    }

    @Override
    public EClass visitIterateExp(IterateExp<EClassifier, EParameter> callExp) {
        if (result == null)
            return super.visitIterateExp(callExp);
        else
            return result;
    }

    @Override
    public EClass visitExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> expression) {
        if (result == null)
            return super.visitExpressionInOCL(expression);
        else
            return result;
    }

    @Override
    public EClass visitConstraint(Constraint constraint) {
        if (result == null)
            return super.visitConstraint(constraint);
        else
            return result;
    }

    public EClass visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
        if (result == null) {
            // source is null when the property call expression is an
            // association class navigation qualifier
            safeVisit(callExp.getSource());
            return result;
        } else {
            return result;
        }
    }
}
