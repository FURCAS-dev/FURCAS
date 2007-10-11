/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CSTFactory.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.cst.CSTPackage
 * @generated
 */
public interface CSTFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	CSTFactory eINSTANCE = org.eclipse.ocl.cst.impl.CSTFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Package Declaration CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Package Declaration CS</em>'.
     * @generated
     */
	PackageDeclarationCS createPackageDeclarationCS();

	/**
     * Returns a new object of class '<em>Path Name CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Path Name CS</em>'.
     * @generated
     */
	PathNameCS createPathNameCS();

	/**
     * Returns a new object of class '<em>Property Context CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Property Context CS</em>'.
     * @generated
     */
	PropertyContextCS createPropertyContextCS();

	/**
     * Returns a new object of class '<em>Simple Name CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Name CS</em>'.
     * @generated
     */
	SimpleNameCS createSimpleNameCS();

	/**
     * Returns a new object of class '<em>Classifier Context Decl CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Classifier Context Decl CS</em>'.
     * @generated
     */
	ClassifierContextDeclCS createClassifierContextDeclCS();

	/**
     * Returns a new object of class '<em>Operation Context Decl CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Context Decl CS</em>'.
     * @generated
     */
	OperationContextDeclCS createOperationContextDeclCS();

	/**
     * Returns a new object of class '<em>Operation CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation CS</em>'.
     * @generated
     */
	OperationCS createOperationCS();

	/**
     * Returns a new object of class '<em>Variable CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable CS</em>'.
     * @generated
     */
	VariableCS createVariableCS();

	/**
     * Returns a new object of class '<em>Pre Post Or Body Decl CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Pre Post Or Body Decl CS</em>'.
     * @generated
     */
	PrePostOrBodyDeclCS createPrePostOrBodyDeclCS();

	/**
     * Returns a new object of class '<em>Der Value CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Der Value CS</em>'.
     * @generated
     */
	DerValueCS createDerValueCS();

	/**
     * Returns a new object of class '<em>Init Value CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Init Value CS</em>'.
     * @generated
     */
	InitValueCS createInitValueCS();

	/**
     * Returns a new object of class '<em>Inv CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Inv CS</em>'.
     * @generated
     */
	InvCS createInvCS();

	/**
     * Returns a new object of class '<em>Def CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Def CS</em>'.
     * @generated
     */
	DefCS createDefCS();

	/**
     * Returns a new object of class '<em>Def Expression CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Def Expression CS</em>'.
     * @generated
     */
	DefExpressionCS createDefExpressionCS();

	/**
     * Returns a new object of class '<em>Variable Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable Exp CS</em>'.
     * @generated
     */
	VariableExpCS createVariableExpCS();

	/**
     * Returns a new object of class '<em>Is Marked Pre CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Is Marked Pre CS</em>'.
     * @generated
     */
	IsMarkedPreCS createIsMarkedPreCS();

	/**
     * Returns a new object of class '<em>Primitive Type CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Type CS</em>'.
     * @generated
     */
	PrimitiveTypeCS createPrimitiveTypeCS();

	/**
     * Returns a new object of class '<em>Tuple Type CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Type CS</em>'.
     * @generated
     */
	TupleTypeCS createTupleTypeCS();

	/**
     * Returns a new object of class '<em>Collection Type CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Type CS</em>'.
     * @generated
     */
	CollectionTypeCS createCollectionTypeCS();

	/**
     * Returns a new object of class '<em>Let Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Let Exp CS</em>'.
     * @generated
     */
	LetExpCS createLetExpCS();

	/**
     * Returns a new object of class '<em>If Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>If Exp CS</em>'.
     * @generated
     */
	IfExpCS createIfExpCS();

	/**
     * Returns a new object of class '<em>Message Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Exp CS</em>'.
     * @generated
     */
	MessageExpCS createMessageExpCS();

	/**
     * Returns a new object of class '<em>OCL Message Arg CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>OCL Message Arg CS</em>'.
     * @generated
     */
	OCLMessageArgCS createOCLMessageArgCS();

	/**
     * Returns a new object of class '<em>Enum Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum Literal Exp CS</em>'.
     * @generated
     */
	EnumLiteralExpCS createEnumLiteralExpCS();

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
     * Returns a new object of class '<em>Tuple Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Literal Exp CS</em>'.
     * @generated
     */
	TupleLiteralExpCS createTupleLiteralExpCS();

	/**
     * Returns a new object of class '<em>Primitive Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Literal Exp CS</em>'.
     * @generated
     */
	PrimitiveLiteralExpCS createPrimitiveLiteralExpCS();

	/**
     * Returns a new object of class '<em>Integer Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Integer Literal Exp CS</em>'.
     * @generated
     */
	IntegerLiteralExpCS createIntegerLiteralExpCS();

	/**
     * Returns a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
     * @generated
     */
	UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS();

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
     * Returns a new object of class '<em>Null Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Null Literal Exp CS</em>'.
     * @generated
     */
	NullLiteralExpCS createNullLiteralExpCS();

	/**
     * Returns a new object of class '<em>Invalid Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Invalid Literal Exp CS</em>'.
     * @generated
     */
	InvalidLiteralExpCS createInvalidLiteralExpCS();

	/**
     * Returns a new object of class '<em>Collection Range CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Range CS</em>'.
     * @generated
     */
	CollectionRangeCS createCollectionRangeCS();

	/**
     * Returns a new object of class '<em>Call Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Call Exp CS</em>'.
     * @generated
     */
	CallExpCS createCallExpCS();

	/**
     * Returns a new object of class '<em>Loop Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Loop Exp CS</em>'.
     * @generated
     */
	LoopExpCS createLoopExpCS();

	/**
     * Returns a new object of class '<em>Iterator Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Iterator Exp CS</em>'.
     * @generated
     */
	IteratorExpCS createIteratorExpCS();

	/**
     * Returns a new object of class '<em>Iterate Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Iterate Exp CS</em>'.
     * @generated
     */
	IterateExpCS createIterateExpCS();

	/**
     * Returns a new object of class '<em>Feature Call Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Feature Call Exp CS</em>'.
     * @generated
     */
	FeatureCallExpCS createFeatureCallExpCS();

	/**
     * Returns a new object of class '<em>Operation Call Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Call Exp CS</em>'.
     * @generated
     */
	OperationCallExpCS createOperationCallExpCS();

	/**
     * Returns a new object of class '<em>State Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>State Exp CS</em>'.
     * @generated
     */
	StateExpCS createStateExpCS();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	CSTPackage getCSTPackage();

} //CSTFactory
