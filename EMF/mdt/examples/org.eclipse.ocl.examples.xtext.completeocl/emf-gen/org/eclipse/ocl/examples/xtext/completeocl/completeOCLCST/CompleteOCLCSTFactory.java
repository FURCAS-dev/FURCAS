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
 * $Id: CompleteOCLCSTFactory.java,v 1.3 2010/05/16 19:26:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage
 * @generated
 */
public interface CompleteOCLCSTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompleteOCLCSTFactory eINSTANCE = org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Package Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Declaration CS</em>'.
	 * @generated
	 */
	PackageDeclarationCS createPackageDeclarationCS();

	/**
	 * Returns a new object of class '<em>Property Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Context Decl CS</em>'.
	 * @generated
	 */
	PropertyContextDeclCS createPropertyContextDeclCS();

	/**
	 * Returns a new object of class '<em>Init CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Init CS</em>'.
	 * @generated
	 */
	InitCS createInitCS();

	/**
	 * Returns a new object of class '<em>Der CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Der CS</em>'.
	 * @generated
	 */
	DerCS createDerCS();

	/**
	 * Returns a new object of class '<em>Classifier Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Context Decl CS</em>'.
	 * @generated
	 */
	ClassifierContextDeclCS createClassifierContextDeclCS();

	/**
	 * Returns a new object of class '<em>Complete OCL Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete OCL Document CS</em>'.
	 * @generated
	 */
	CompleteOCLDocumentCS createCompleteOCLDocumentCS();

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
	 * Returns a new object of class '<em>Operation Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Context Decl CS</em>'.
	 * @generated
	 */
	OperationContextDeclCS createOperationContextDeclCS();

	/**
	 * Returns a new object of class '<em>Pre CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pre CS</em>'.
	 * @generated
	 */
	PreCS createPreCS();

	/**
	 * Returns a new object of class '<em>Post CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post CS</em>'.
	 * @generated
	 */
	PostCS createPostCS();

	/**
	 * Returns a new object of class '<em>Body CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Body CS</em>'.
	 * @generated
	 */
	BodyCS createBodyCS();

	/**
	 * Returns a new object of class '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint CS</em>'.
	 * @generated
	 */
	ConstraintCS createConstraintCS();

	/**
	 * Returns a new object of class '<em>Named Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Constraint CS</em>'.
	 * @generated
	 */
	NamedConstraintCS createNamedConstraintCS();

	/**
	 * Returns a new object of class '<em>Ocl Message Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Message Arg CS</em>'.
	 * @generated
	 */
	OclMessageArgCS createOclMessageArgCS();

	/**
	 * Returns a new object of class '<em>Ocl Message CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Message CS</em>'.
	 * @generated
	 */
	OclMessageCS createOclMessageCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CompleteOCLCSTPackage getCompleteOCLCSTPackage();

} //CompleteOCLCSTFactory
