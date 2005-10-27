/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.internal.utilities;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.internal.utilities.UtilitiesFactory
 * @model kind="package"
 * @generated
 */
public interface UtilitiesPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "utilities";//$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/OCL2/7.0.0/ocl/utilities";//$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ocl.util";//$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UtilitiesPackage eINSTANCE = org.eclipse.emf.ocl.internal.utilities.impl.UtilitiesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.internal.utilities.impl.VisitableImpl <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.internal.utilities.impl.VisitableImpl
	 * @see org.eclipse.emf.ocl.internal.utilities.impl.UtilitiesPackageImpl#getVisitable()
	 * @generated
	 */
	int VISITABLE = 0;

	/**
	 * The number of structural features of the the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.internal.utilities.AstNode <em>Ast Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.internal.utilities.AstNode
	 * @see org.eclipse.emf.ocl.internal.utilities.impl.UtilitiesPackageImpl#getAstNode()
	 * @generated
	 */
	int AST_NODE = 1;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE__START_POSITION = 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE__END_POSITION = 1;

	/**
	 * The number of structural features of the the '<em>Ast Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode <em>Typed Ast Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.internal.utilities.TypedAstNode
	 * @see org.eclipse.emf.ocl.internal.utilities.impl.UtilitiesPackageImpl#getTypedAstNode()
	 * @generated
	 */
	int TYPED_AST_NODE = 2;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_AST_NODE__START_POSITION = AST_NODE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_AST_NODE__END_POSITION = AST_NODE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_AST_NODE__TYPE_START_POSITION = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_AST_NODE__TYPE_END_POSITION = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Typed Ast Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_AST_NODE_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.internal.utilities.CallingAstNode <em>Calling Ast Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.internal.utilities.CallingAstNode
	 * @see org.eclipse.emf.ocl.internal.utilities.impl.UtilitiesPackageImpl#getCallingAstNode()
	 * @generated
	 */
	int CALLING_AST_NODE = 3;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLING_AST_NODE__START_POSITION = AST_NODE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLING_AST_NODE__END_POSITION = AST_NODE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLING_AST_NODE__PROPERTY_START_POSITION = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLING_AST_NODE__PROPERTY_END_POSITION = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Calling Ast Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLING_AST_NODE_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.internal.utilities.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.Visitable
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.internal.utilities.AstNode <em>Ast Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ast Node</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.AstNode
	 * @generated
	 */
	EClass getAstNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.internal.utilities.AstNode#getStartPosition <em>Start Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Position</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.AstNode#getStartPosition()
	 * @see #getAstNode()
	 * @generated
	 */
	EAttribute getAstNode_StartPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.internal.utilities.AstNode#getEndPosition <em>End Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Position</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.AstNode#getEndPosition()
	 * @see #getAstNode()
	 * @generated
	 */
	EAttribute getAstNode_EndPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode <em>Typed Ast Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Ast Node</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.TypedAstNode
	 * @generated
	 */
	EClass getTypedAstNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeStartPosition <em>Type Start Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Start Position</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeStartPosition()
	 * @see #getTypedAstNode()
	 * @generated
	 */
	EAttribute getTypedAstNode_TypeStartPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeEndPosition <em>Type End Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type End Position</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.TypedAstNode#getTypeEndPosition()
	 * @see #getTypedAstNode()
	 * @generated
	 */
	EAttribute getTypedAstNode_TypeEndPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.internal.utilities.CallingAstNode <em>Calling Ast Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calling Ast Node</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.CallingAstNode
	 * @generated
	 */
	EClass getCallingAstNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.internal.utilities.CallingAstNode#getPropertyStartPosition <em>Property Start Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Start Position</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.CallingAstNode#getPropertyStartPosition()
	 * @see #getCallingAstNode()
	 * @generated
	 */
	EAttribute getCallingAstNode_PropertyStartPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.internal.utilities.CallingAstNode#getPropertyEndPosition <em>Property End Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property End Position</em>'.
	 * @see org.eclipse.emf.ocl.internal.utilities.CallingAstNode#getPropertyEndPosition()
	 * @see #getCallingAstNode()
	 * @generated
	 */
	EAttribute getCallingAstNode_PropertyEndPosition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UtilitiesFactory getUtilitiesFactory();

} //UtilitiesPackage
