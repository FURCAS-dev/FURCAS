/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: UtilitiesPackage.java,v 1.4 2007/10/11 23:05:15 cdamus Exp $
 */
package org.eclipse.emf.ocl.utilities;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @deprecated Use the {@link org.eclipse.ocl.utilities.UtilitiesPackage} interface,
 * instead.
 * 
 * @see org.eclipse.emf.ocl.utilities.UtilitiesFactory
 * @model kind="package"
 * @generated
 */
@Deprecated
public interface UtilitiesPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "utilities"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/OCL2/1.0.0/ocl/utilities"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ocl.util"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UtilitiesPackage eINSTANCE = org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.utilities.impl.VisitableImpl <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.utilities.impl.VisitableImpl
	 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getVisitable()
	 * @generated
	 */
	int VISITABLE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.utilities.ASTNode <em>AST Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.utilities.ASTNode
	 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getASTNode()
	 * @generated
	 */
	int AST_NODE = 0;

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
	 * The number of structural features of the '<em>AST Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.utilities.TypedASTNode <em>Typed AST Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.utilities.TypedASTNode
	 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getTypedASTNode()
	 * @generated
	 */
	int TYPED_AST_NODE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.utilities.CallingASTNode <em>Calling AST Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.utilities.CallingASTNode
	 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getCallingASTNode()
	 * @generated
	 */
	int CALLING_AST_NODE = 1;

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
	 * The number of structural features of the '<em>Calling AST Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLING_AST_NODE_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.utilities.PredefinedType <em>Predefined Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.utilities.PredefinedType
	 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getPredefinedType()
	 * @generated
	 */
	int PREDEFINED_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Predefined Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TYPE_FEATURE_COUNT = 0;


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
	 * The number of structural features of the '<em>Typed AST Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_AST_NODE_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Semantic Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.parser.SemanticException
	 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getSemanticException()
	 * @generated
	 */
	int SEMANTIC_EXCEPTION = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.utilities.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.eclipse.emf.ocl.utilities.Visitable
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.utilities.ASTNode <em>AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AST Node</em>'.
	 * @see org.eclipse.emf.ocl.utilities.ASTNode
	 * @generated
	 */
	EClass getASTNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.utilities.ASTNode#getStartPosition <em>Start Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Position</em>'.
	 * @see org.eclipse.emf.ocl.utilities.ASTNode#getStartPosition()
	 * @see #getASTNode()
	 * @generated
	 */
	EAttribute getASTNode_StartPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.utilities.ASTNode#getEndPosition <em>End Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Position</em>'.
	 * @see org.eclipse.emf.ocl.utilities.ASTNode#getEndPosition()
	 * @see #getASTNode()
	 * @generated
	 */
	EAttribute getASTNode_EndPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.utilities.TypedASTNode <em>Typed AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed AST Node</em>'.
	 * @see org.eclipse.emf.ocl.utilities.TypedASTNode
	 * @generated
	 */
	EClass getTypedASTNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.utilities.TypedASTNode#getTypeStartPosition <em>Type Start Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Start Position</em>'.
	 * @see org.eclipse.emf.ocl.utilities.TypedASTNode#getTypeStartPosition()
	 * @see #getTypedASTNode()
	 * @generated
	 */
	EAttribute getTypedASTNode_TypeStartPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.utilities.TypedASTNode#getTypeEndPosition <em>Type End Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type End Position</em>'.
	 * @see org.eclipse.emf.ocl.utilities.TypedASTNode#getTypeEndPosition()
	 * @see #getTypedASTNode()
	 * @generated
	 */
	EAttribute getTypedASTNode_TypeEndPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.utilities.CallingASTNode <em>Calling AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calling AST Node</em>'.
	 * @see org.eclipse.emf.ocl.utilities.CallingASTNode
	 * @generated
	 */
	EClass getCallingASTNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.utilities.CallingASTNode#getPropertyStartPosition <em>Property Start Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Start Position</em>'.
	 * @see org.eclipse.emf.ocl.utilities.CallingASTNode#getPropertyStartPosition()
	 * @see #getCallingASTNode()
	 * @generated
	 */
	EAttribute getCallingASTNode_PropertyStartPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.utilities.CallingASTNode#getPropertyEndPosition <em>Property End Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property End Position</em>'.
	 * @see org.eclipse.emf.ocl.utilities.CallingASTNode#getPropertyEndPosition()
	 * @see #getCallingASTNode()
	 * @generated
	 */
	EAttribute getCallingASTNode_PropertyEndPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.utilities.PredefinedType <em>Predefined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predefined Type</em>'.
	 * @see org.eclipse.emf.ocl.utilities.PredefinedType
	 * @generated
	 */
	EClass getPredefinedType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ocl.parser.SemanticException <em>Semantic Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Semantic Exception</em>'.
	 * @see org.eclipse.emf.ocl.parser.SemanticException
	 * @model instanceClass="org.eclipse.emf.ocl.parser.SemanticException" serializable="false"
	 * @generated
	 */
	EDataType getSemanticException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UtilitiesFactory getUtilitiesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ocl.utilities.impl.VisitableImpl <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ocl.utilities.impl.VisitableImpl
		 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ocl.utilities.ASTNode <em>AST Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ocl.utilities.ASTNode
		 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getASTNode()
		 * @generated
		 */
		EClass AST_NODE = eINSTANCE.getASTNode();

		/**
		 * The meta object literal for the '<em><b>Start Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AST_NODE__START_POSITION = eINSTANCE.getASTNode_StartPosition();

		/**
		 * The meta object literal for the '<em><b>End Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AST_NODE__END_POSITION = eINSTANCE.getASTNode_EndPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ocl.utilities.TypedASTNode <em>Typed AST Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ocl.utilities.TypedASTNode
		 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getTypedASTNode()
		 * @generated
		 */
		EClass TYPED_AST_NODE = eINSTANCE.getTypedASTNode();

		/**
		 * The meta object literal for the '<em><b>Type Start Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_AST_NODE__TYPE_START_POSITION = eINSTANCE.getTypedASTNode_TypeStartPosition();

		/**
		 * The meta object literal for the '<em><b>Type End Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_AST_NODE__TYPE_END_POSITION = eINSTANCE.getTypedASTNode_TypeEndPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ocl.utilities.CallingASTNode <em>Calling AST Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ocl.utilities.CallingASTNode
		 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getCallingASTNode()
		 * @generated
		 */
		EClass CALLING_AST_NODE = eINSTANCE.getCallingASTNode();

		/**
		 * The meta object literal for the '<em><b>Property Start Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLING_AST_NODE__PROPERTY_START_POSITION = eINSTANCE.getCallingASTNode_PropertyStartPosition();

		/**
		 * The meta object literal for the '<em><b>Property End Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLING_AST_NODE__PROPERTY_END_POSITION = eINSTANCE.getCallingASTNode_PropertyEndPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ocl.utilities.PredefinedType <em>Predefined Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ocl.utilities.PredefinedType
		 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getPredefinedType()
		 * @generated
		 */
		EClass PREDEFINED_TYPE = eINSTANCE.getPredefinedType();

		/**
		 * The meta object literal for the '<em>Semantic Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ocl.parser.SemanticException
		 * @see org.eclipse.emf.ocl.utilities.impl.UtilitiesPackageImpl#getSemanticException()
		 * @generated
		 */
		EDataType SEMANTIC_EXCEPTION = eINSTANCE.getSemanticException();

	}

} //UtilitiesPackage
