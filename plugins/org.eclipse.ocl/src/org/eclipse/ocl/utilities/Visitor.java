/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: Visitor.java,v 1.3 2007/10/11 23:05:05 cdamus Exp $
 */

package org.eclipse.ocl.utilities;

//import org.eclipse.emf.ecore.EObject;
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



/**
 * Something which can visit an <code>OCLExpression</code>.  Each subclass
 * will call a corresponding method on the <code>Visitor</code>.  See
 * Design Patterns -- Visitor.
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public interface Visitor<T, C, O, P, EL, PM, S, COA, SSA, CT>  {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model variableExpRequired="true"
     * @generated
     */
    T visitVariableExp(VariableExp<C, PM> variableExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model letExpRequired="true"
     * @generated
     */
    T visitLetExp(LetExp<C, PM> letExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model ifExpRequired="true"
     * @generated
     */
    T visitIfExp(IfExp<C> ifExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model typeExpRequired="true"
     * @generated
     */
    T visitTypeExp(TypeExp<C> typeExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model callExpRequired="true"
     * @generated
     */
    T visitPropertyCallExp(PropertyCallExp<C, P> callExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model callExpRequired="true"
     * @generated
     */
    T visitOperationCallExp(OperationCallExp<C, O> callExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model callExpRequired="true"
     * @generated
     */
    T visitAssociationClassCallExp(AssociationClassCallExp<C, P> callExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model callExpRequired="true"
     * @generated
     */
    T visitIteratorExp(IteratorExp<C, PM> callExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model callExpRequired="true"
     * @generated
     */
    T visitIterateExp(IterateExp<C, PM> callExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model unspecExpRequired="true"
     * @generated
     */
    T visitUnspecifiedValueExp(UnspecifiedValueExp<C> unspecExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitIntegerLiteralExp(IntegerLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitRealLiteralExp(RealLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitStringLiteralExp(StringLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitBooleanLiteralExp(BooleanLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitEnumLiteralExp(EnumLiteralExp<C, EL> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitCollectionLiteralExp(CollectionLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model itemRequired="true"
     * @generated
     */
    T visitCollectionItem(CollectionItem<C> item);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model rangeRequired="true"
     * @generated
     */
    T visitCollectionRange(CollectionRange<C> range);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitTupleLiteralExp(TupleLiteralExp<C, P> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model partRequired="true"
     * @generated
     */
    T visitTupleLiteralPart(TupleLiteralPart<C, P> part);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitInvalidLiteralExp(InvalidLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model literalExpRequired="true"
     * @generated
     */
    T visitNullLiteralExp(NullLiteralExp<C> literalExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model stateExpRequired="true"
     * @generated
     */
    T visitStateExp(StateExp<C, S> stateExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model messageExpRequired="true"
     * @generated
     */
    T visitMessageExp(MessageExp<C, COA, SSA> messageExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model variableRequired="true"
     * @generated
     */
    T visitVariable(Variable<C, PM> variable);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model expressionRequired="true"
     * @generated
     */
    T visitExpressionInOCL(ExpressionInOCL<C, PM> expression);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model constraintRequired="true"
     * @generated
     */
    T visitConstraint(CT constraint);
}
