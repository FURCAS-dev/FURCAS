/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLCSTFactory.java,v 1.1 2010/04/13 06:32:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage
 * @generated
 */
public interface EssentialOCLCSTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EssentialOCLCSTFactory eINSTANCE = org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ocl Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Expression CS</em>'.
	 * @generated
	 */
	OclExpressionCS createOclExpressionCS();

	/**
	 * Returns a new object of class '<em>Simple Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Name CS</em>'.
	 * @generated
	 */
	SimpleNameCS createSimpleNameCS();

	/**
	 * Returns a new object of class '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Name CS</em>'.
	 * @generated
	 */
	PathNameCS createPathNameCS();

	/**
	 * Returns a new object of class '<em>Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type CS</em>'.
	 * @generated
	 */
	TypeCS createTypeCS();

	/**
	 * Returns a new object of class '<em>Collection Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type CS</em>'.
	 * @generated
	 */
	CollectionTypeCS createCollectionTypeCS();

	/**
	 * Returns a new object of class '<em>Tuple Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type CS</em>'.
	 * @generated
	 */
	TupleTypeCS createTupleTypeCS();

	/**
	 * Returns a new object of class '<em>Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable CS</em>'.
	 * @generated
	 */
	VariableCS createVariableCS();

	/**
	 * Returns a new object of class '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Exp CS</em>'.
	 * @generated
	 */
	LiteralExpCS createLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Collection Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Literal Exp CS</em>'.
	 * @generated
	 */
	CollectionLiteralExpCS createCollectionLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Collection Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Literal Part CS</em>'.
	 * @generated
	 */
	CollectionLiteralPartCS createCollectionLiteralPartCS();

	/**
	 * Returns a new object of class '<em>Primitive Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Literal Exp CS</em>'.
	 * @generated
	 */
	PrimitiveLiteralExpCS createPrimitiveLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Tuple Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Literal Exp CS</em>'.
	 * @generated
	 */
	TupleLiteralExpCS createTupleLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Integer Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal Exp CS</em>'.
	 * @generated
	 */
	IntegerLiteralExpCS createIntegerLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Real Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Literal Exp CS</em>'.
	 * @generated
	 */
	RealLiteralExpCS createRealLiteralExpCS();

	/**
	 * Returns a new object of class '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Exp CS</em>'.
	 * @generated
	 */
	StringLiteralExpCS createStringLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Exp CS</em>'.
	 * @generated
	 */
	BooleanLiteralExpCS createBooleanLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @generated
	 */
	UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Invalid Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Literal Exp CS</em>'.
	 * @generated
	 */
	InvalidLiteralExpCS createInvalidLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Null Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal Exp CS</em>'.
	 * @generated
	 */
	NullLiteralExpCS createNullLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Type Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Literal Exp CS</em>'.
	 * @generated
	 */
	TypeLiteralExpCS createTypeLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Call Arguments CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Arguments CS</em>'.
	 * @generated
	 */
	CallArgumentsCS createCallArgumentsCS();

	/**
	 * Returns a new object of class '<em>Variable Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Exp CS</em>'.
	 * @generated
	 */
	VariableExpCS createVariableExpCS();

	/**
	 * Returns a new object of class '<em>If Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Exp CS</em>'.
	 * @generated
	 */
	IfExpCS createIfExpCS();

	/**
	 * Returns a new object of class '<em>Let Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Exp CS</em>'.
	 * @generated
	 */
	LetExpCS createLetExpCS();

	/**
	 * Returns a new object of class '<em>Binary Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Expression CS</em>'.
	 * @generated
	 */
	BinaryExpressionCS createBinaryExpressionCS();

	/**
	 * Returns a new object of class '<em>Unary Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression CS</em>'.
	 * @generated
	 */
	UnaryExpressionCS createUnaryExpressionCS();

	/**
	 * Returns a new object of class '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Exp CS</em>'.
	 * @generated
	 */
	CallExpCS createCallExpCS();

	/**
	 * Returns a new object of class '<em>Arrow Call Arguments CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arrow Call Arguments CS</em>'.
	 * @generated
	 */
	ArrowCallArgumentsCS createArrowCallArgumentsCS();

	/**
	 * Returns a new object of class '<em>Dot Index Arguments CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dot Index Arguments CS</em>'.
	 * @generated
	 */
	DotIndexArgumentsCS createDotIndexArgumentsCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EssentialOCLCSTPackage getEssentialOCLCSTPackage();

} //EssentialOCLCSTFactory
