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

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc --> The <b>Package </b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "expressions";//$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://www.ibm.com/OCL2/7.0.0/ocl/expressions";//$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "ocl.expr";//$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    ExpressionsPackage eINSTANCE = org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl.init();


	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl <em>Ocl Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.OclExpressionImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getOclExpression()
	 * @generated
	 */
	int OCL_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__START_POSITION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__END_POSITION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__APPLIED_PROPERTY = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__INITIALIZED_VARIABLE = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__PARENT_OPERATION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__TYPE = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the the '<em>Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.PropertyCallExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getPropertyCallExp()
	 * @generated
	 */
	int PROPERTY_CALL_EXP = 22;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__INITIALIZED_VARIABLE = OCL_EXPRESSION__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__PARENT_OPERATION = OCL_EXPRESSION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.ModelPropertyCallExpImpl <em>Model Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ModelPropertyCallExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getModelPropertyCallExp()
	 * @generated
	 */
	int MODEL_PROPERTY_CALL_EXP = 15;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__EANNOTATIONS = PROPERTY_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__NAME = PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__START_POSITION = PROPERTY_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__END_POSITION = PROPERTY_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__APPLIED_PROPERTY = PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__INITIALIZED_VARIABLE = PROPERTY_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__PARENT_OPERATION = PROPERTY_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__TYPE = PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__PROPERTY_START_POSITION = PROPERTY_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__PROPERTY_END_POSITION = PROPERTY_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__SOURCE = PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__MARKED_PRE = PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Model Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT = PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.NavigationCallExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getNavigationCallExp()
	 * @generated
	 */
	int NAVIGATION_CALL_EXP = 16;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__EANNOTATIONS = MODEL_PROPERTY_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAME = MODEL_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__START_POSITION = MODEL_PROPERTY_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__END_POSITION = MODEL_PROPERTY_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__APPLIED_PROPERTY = MODEL_PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__INITIALIZED_VARIABLE = MODEL_PROPERTY_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__PARENT_OPERATION = MODEL_PROPERTY_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__TYPE = MODEL_PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__PROPERTY_START_POSITION = MODEL_PROPERTY_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__PROPERTY_END_POSITION = MODEL_PROPERTY_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__SOURCE = MODEL_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__MARKED_PRE = MODEL_PROPERTY_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__QUALIFIERS = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP_FEATURE_COUNT = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.AssociationEndCallExpImpl <em>Association End Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.AssociationEndCallExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getAssociationEndCallExp()
	 * @generated
	 */
	int ASSOCIATION_END_CALL_EXP = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__EANNOTATIONS = NAVIGATION_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__APPLIED_PROPERTY = NAVIGATION_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__INITIALIZED_VARIABLE = NAVIGATION_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__PARENT_OPERATION = NAVIGATION_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__QUALIFIERS = NAVIGATION_CALL_EXP__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Association End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Association End Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.AttributeCallExpImpl <em>Attribute Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.AttributeCallExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getAttributeCallExp()
	 * @generated
	 */
	int ATTRIBUTE_CALL_EXP = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__EANNOTATIONS = MODEL_PROPERTY_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__NAME = MODEL_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__START_POSITION = MODEL_PROPERTY_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__END_POSITION = MODEL_PROPERTY_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__APPLIED_PROPERTY = MODEL_PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__INITIALIZED_VARIABLE = MODEL_PROPERTY_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__PARENT_OPERATION = MODEL_PROPERTY_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__TYPE = MODEL_PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__PROPERTY_START_POSITION = MODEL_PROPERTY_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__PROPERTY_END_POSITION = MODEL_PROPERTY_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__SOURCE = MODEL_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__MARKED_PRE = MODEL_PROPERTY_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Referred Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Attribute Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CALL_EXP_FEATURE_COUNT = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.LiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getLiteralExp()
	 * @generated
	 */
	int LITERAL_EXP = 13;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__INITIALIZED_VARIABLE = OCL_EXPRESSION__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__PARENT_OPERATION = OCL_EXPRESSION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.PrimitiveLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getPrimitiveLiteralExp()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP = 21;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__INITIALIZED_VARIABLE = LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__PARENT_OPERATION = LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.BooleanLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__APPLIED_PROPERTY = PRIMITIVE_LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__INITIALIZED_VARIABLE = PRIMITIVE_LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__PARENT_OPERATION = PRIMITIVE_LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.CollectionLiteralPartImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getCollectionLiteralPart()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__TYPE = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Collection Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.CollectionItemImpl <em>Collection Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.CollectionItemImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getCollectionItem()
	 * @generated
	 */
	int COLLECTION_ITEM = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__EANNOTATIONS = COLLECTION_LITERAL_PART__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Collection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.CollectionLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getCollectionLiteralExp()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__INITIALIZED_VARIABLE = LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PARENT_OPERATION = LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PARTS = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.CollectionRangeImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getCollectionRange()
	 * @generated
	 */
	int COLLECTION_RANGE = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__EANNOTATIONS = COLLECTION_LITERAL_PART__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__FIRST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__LAST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.EnumLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getEnumLiteralExp()
	 * @generated
	 */
	int ENUM_LITERAL_EXP = 7;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__INITIALIZED_VARIABLE = LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__PARENT_OPERATION = LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.IfExpImpl <em>If Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.IfExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getIfExp()
	 * @generated
	 */
	int IF_EXP = 8;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__INITIALIZED_VARIABLE = OCL_EXPRESSION__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__PARENT_OPERATION = OCL_EXPRESSION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__CONDITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__THEN_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__ELSE_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.NumericLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getNumericLiteralExp()
	 * @generated
	 */
	int NUMERIC_LITERAL_EXP = 17;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__APPLIED_PROPERTY = PRIMITIVE_LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__INITIALIZED_VARIABLE = PRIMITIVE_LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__PARENT_OPERATION = PRIMITIVE_LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.IntegerLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 9;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__APPLIED_PROPERTY = NUMERIC_LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INITIALIZED_VARIABLE = NUMERIC_LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__PARENT_OPERATION = NUMERIC_LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.LoopExpImpl <em>Loop Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.LoopExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getLoopExp()
	 * @generated
	 */
	int LOOP_EXP = 14;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__EANNOTATIONS = PROPERTY_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__NAME = PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__START_POSITION = PROPERTY_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__END_POSITION = PROPERTY_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__APPLIED_PROPERTY = PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__INITIALIZED_VARIABLE = PROPERTY_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__PARENT_OPERATION = PROPERTY_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__TYPE = PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__PROPERTY_START_POSITION = PROPERTY_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__PROPERTY_END_POSITION = PROPERTY_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__SOURCE = PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__BODY = PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__ITERATORS = PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_FEATURE_COUNT = PROPERTY_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.IterateExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getIterateExp()
	 * @generated
	 */
	int ITERATE_EXP = 10;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__EANNOTATIONS = LOOP_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__START_POSITION = LOOP_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__END_POSITION = LOOP_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__APPLIED_PROPERTY = LOOP_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__INITIALIZED_VARIABLE = LOOP_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__PARENT_OPERATION = LOOP_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__ITERATORS = LOOP_EXP__ITERATORS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.IteratorExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getIteratorExp()
	 * @generated
	 */
	int ITERATOR_EXP = 11;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__EANNOTATIONS = LOOP_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__START_POSITION = LOOP_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__END_POSITION = LOOP_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__APPLIED_PROPERTY = LOOP_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__INITIALIZED_VARIABLE = LOOP_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__PARENT_OPERATION = LOOP_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__ITERATORS = LOOP_EXP__ITERATORS;

	/**
	 * The number of structural features of the the '<em>Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.LetExpImpl <em>Let Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.LetExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getLetExp()
	 * @generated
	 */
	int LET_EXP = 12;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__INITIALIZED_VARIABLE = OCL_EXPRESSION__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__PARENT_OPERATION = OCL_EXPRESSION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IN = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.OclMessageArgImpl <em>Ocl Message Arg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.OclMessageArgImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getOclMessageArg()
	 * @generated
	 */
	int OCL_MESSAGE_ARG = 19;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG__EXPRESSION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unspecified</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG__UNSPECIFIED = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Ocl Message Arg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.OperationCallExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 20;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__EANNOTATIONS = MODEL_PROPERTY_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__NAME = MODEL_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__START_POSITION = MODEL_PROPERTY_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__END_POSITION = MODEL_PROPERTY_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__APPLIED_PROPERTY = MODEL_PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__INITIALIZED_VARIABLE = MODEL_PROPERTY_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__PARENT_OPERATION = MODEL_PROPERTY_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__TYPE = MODEL_PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__PROPERTY_START_POSITION = MODEL_PROPERTY_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__PROPERTY_END_POSITION = MODEL_PROPERTY_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__SOURCE = MODEL_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__MARKED_PRE = MODEL_PROPERTY_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__ARGUMENTS = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_FEATURE_COUNT = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.RealLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 23;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__APPLIED_PROPERTY = NUMERIC_LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__INITIALIZED_VARIABLE = NUMERIC_LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__PARENT_OPERATION = NUMERIC_LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.StringLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 24;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__APPLIED_PROPERTY = PRIMITIVE_LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__INITIALIZED_VARIABLE = PRIMITIVE_LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__PARENT_OPERATION = PRIMITIVE_LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.TupleLiteralExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getTupleLiteralExp()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP = 25;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__INITIALIZED_VARIABLE = LITERAL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__PARENT_OPERATION = LITERAL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Tuple Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TUPLE_PART = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.UnspecifiedValueExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getUnspecifiedValueExp()
	 * @generated
	 */
	int UNSPECIFIED_VALUE_EXP = 26;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__INITIALIZED_VARIABLE = OCL_EXPRESSION__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__PARENT_OPERATION = OCL_EXPRESSION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.VariableDeclarationImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 27;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__START_POSITION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__END_POSITION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE_START_POSITION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE_END_POSITION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__VAR_NAME = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Loop Expr</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__LOOP_EXPR = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INIT_EXPRESSION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__BASE_EXP = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.VariableExpImpl <em>Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.VariableExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 28;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__INITIALIZED_VARIABLE = OCL_EXPRESSION__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__PARENT_OPERATION = OCL_EXPRESSION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.internal.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.AssociationClassCallExpImpl
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getAssociationClassCallExp()
	 * @generated
	 */
	int ASSOCIATION_CLASS_CALL_EXP = 29;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__EANNOTATIONS = NAVIGATION_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__APPLIED_PROPERTY = NAVIGATION_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__INITIALIZED_VARIABLE = NAVIGATION_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__PARENT_OPERATION = NAVIGATION_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__QUALIFIERS = NAVIGATION_CALL_EXP__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Association Class Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.expressions.CollectionKind <em>Collection Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.CollectionKind
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getCollectionKind()
	 * @generated
	 */
	int COLLECTION_KIND = 30;

	/**
	 * The meta object id for the '<em>Visitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.expressions.Visitor
	 * @see org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl#getVisitor()
	 * @generated
	 */
	int VISITOR = 31;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.AssociationEndCallExp <em>Association End Call Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association End Call Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.AssociationEndCallExp
	 * @generated
	 */
    EClass getAssociationEndCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.AssociationEndCallExp#getReferredAssociationEnd <em>Referred Association End</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Association End</em>'.
	 * @see org.eclipse.emf.ocl.expressions.AssociationEndCallExp#getReferredAssociationEnd()
	 * @see #getAssociationEndCallExp()
	 * @generated
	 */
    EReference getAssociationEndCallExp_ReferredAssociationEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.AttributeCallExp <em>Attribute Call Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Call Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.AttributeCallExp
	 * @generated
	 */
    EClass getAttributeCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.AttributeCallExp#getReferredAttribute <em>Referred Attribute</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Attribute</em>'.
	 * @see org.eclipse.emf.ocl.expressions.AttributeCallExp#getReferredAttribute()
	 * @see #getAttributeCallExp()
	 * @generated
	 */
    EReference getAttributeCallExp_ReferredAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.BooleanLiteralExp
	 * @generated
	 */
    EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.expressions.BooleanLiteralExp#getBooleanSymbol <em>Boolean Symbol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
	 * @see org.eclipse.emf.ocl.expressions.BooleanLiteralExp#getBooleanSymbol()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
    EAttribute getBooleanLiteralExp_BooleanSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Item</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionItem
	 * @generated
	 */
    EClass getCollectionItem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.CollectionItem#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionItem#getItem()
	 * @see #getCollectionItem()
	 * @generated
	 */
    EReference getCollectionItem_Item();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionLiteralExp
	 * @generated
	 */
    EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralExp#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionLiteralExp#getKind()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
    EAttribute getCollectionLiteralExp_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralExp#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionLiteralExp#getParts()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
    EReference getCollectionLiteralExp_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionLiteralPart
	 * @generated
	 */
    EClass getCollectionLiteralPart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralPart#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionLiteralPart#getType()
	 * @see #getCollectionLiteralPart()
	 * @generated
	 */
    EReference getCollectionLiteralPart_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionRange
	 * @generated
	 */
    EClass getCollectionRange();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.CollectionRange#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionRange#getFirst()
	 * @see #getCollectionRange()
	 * @generated
	 */
    EReference getCollectionRange_First();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.CollectionRange#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionRange#getLast()
	 * @see #getCollectionRange()
	 * @generated
	 */
    EReference getCollectionRange_Last();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.EnumLiteralExp
	 * @generated
	 */
    EClass getEnumLiteralExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Enum Literal</em>'.
	 * @see org.eclipse.emf.ocl.expressions.EnumLiteralExp#getReferredEnumLiteral()
	 * @see #getEnumLiteralExp()
	 * @generated
	 */
    EReference getEnumLiteralExp_ReferredEnumLiteral();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.emf.ocl.expressions.IfExp <em>If Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>If Exp</em>'.
     * @see org.eclipse.emf.ocl.expressions.IfExp
     * @generated
     */
    EClass getIfExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.IfExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.emf.ocl.expressions.IfExp#getCondition()
	 * @see #getIfExp()
	 * @generated
	 */
    EReference getIfExp_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.IfExp#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.eclipse.emf.ocl.expressions.IfExp#getThenExpression()
	 * @see #getIfExp()
	 * @generated
	 */
    EReference getIfExp_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.IfExp#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see org.eclipse.emf.ocl.expressions.IfExp#getElseExpression()
	 * @see #getIfExp()
	 * @generated
	 */
    EReference getIfExp_ElseExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.IntegerLiteralExp
	 * @generated
	 */
    EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.expressions.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see org.eclipse.emf.ocl.expressions.IntegerLiteralExp#getIntegerSymbol()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
    EAttribute getIntegerLiteralExp_IntegerSymbol();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.emf.ocl.expressions.IterateExp <em>Iterate Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Iterate Exp</em>'.
     * @see org.eclipse.emf.ocl.expressions.IterateExp
     * @generated
     */
    EClass getIterateExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.IterateExp#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.emf.ocl.expressions.IterateExp#getResult()
	 * @see #getIterateExp()
	 * @generated
	 */
    EReference getIterateExp_Result();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.emf.ocl.expressions.IteratorExp <em>Iterator Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Iterator Exp</em>'.
     * @see org.eclipse.emf.ocl.expressions.IteratorExp
     * @generated
     */
    EClass getIteratorExp();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.emf.ocl.expressions.LetExp <em>Let Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Let Exp</em>'.
     * @see org.eclipse.emf.ocl.expressions.LetExp
     * @generated
     */
    EClass getLetExp();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.emf.ocl.expressions.LetExp#getIn <em>In</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>In</em>'.
     * @see org.eclipse.emf.ocl.expressions.LetExp#getIn()
     * @see #getLetExp()
     * @generated
     */
    EReference getLetExp_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.LetExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.eclipse.emf.ocl.expressions.LetExp#getVariable()
	 * @see #getLetExp()
	 * @generated
	 */
    EReference getLetExp_Variable();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.emf.ocl.expressions.LiteralExp <em>Literal Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Literal Exp</em>'.
     * @see org.eclipse.emf.ocl.expressions.LiteralExp
     * @generated
     */
    EClass getLiteralExp();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.emf.ocl.expressions.LoopExp <em>Loop Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Loop Exp</em>'.
     * @see org.eclipse.emf.ocl.expressions.LoopExp
     * @generated
     */
    EClass getLoopExp();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.emf.ocl.expressions.LoopExp#getBody <em>Body</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Body</em>'.
     * @see org.eclipse.emf.ocl.expressions.LoopExp#getBody()
     * @see #getLoopExp()
     * @generated
     */
    EReference getLoopExp_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ocl.expressions.LoopExp#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iterators</em>'.
	 * @see org.eclipse.emf.ocl.expressions.LoopExp#getIterators()
	 * @see #getLoopExp()
	 * @generated
	 */
    EReference getLoopExp_Iterators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.ModelPropertyCallExp <em>Model Property Call Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Property Call Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.ModelPropertyCallExp
	 * @generated
	 */
    EClass getModelPropertyCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.expressions.ModelPropertyCallExp#isMarkedPre <em>Marked Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Marked Pre</em>'.
	 * @see org.eclipse.emf.ocl.expressions.ModelPropertyCallExp#isMarkedPre()
	 * @see #getModelPropertyCallExp()
	 * @generated
	 */
	EAttribute getModelPropertyCallExp_MarkedPre();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Call Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.NavigationCallExp
	 * @generated
	 */
    EClass getNavigationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ocl.expressions.NavigationCallExp#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Qualifiers</em>'.
	 * @see org.eclipse.emf.ocl.expressions.NavigationCallExp#getQualifiers()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
    EReference getNavigationCallExp_Qualifiers();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Navigation Source</em>'.
	 * @see org.eclipse.emf.ocl.expressions.NavigationCallExp#getNavigationSource()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
    EReference getNavigationCallExp_NavigationSource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.NumericLiteralExp
	 * @generated
	 */
    EClass getNumericLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.OclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Expression</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclExpression
	 * @generated
	 */
    EClass getOclExpression();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.ocl.expressions.OclExpression#getAppliedProperty <em>Applied Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Applied Property</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclExpression#getAppliedProperty()
	 * @see #getOclExpression()
	 * @generated
	 */
    EReference getOclExpression_AppliedProperty();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.ocl.expressions.OclExpression#getInitializedVariable <em>Initialized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Initialized Variable</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclExpression#getInitializedVariable()
	 * @see #getOclExpression()
	 * @generated
	 */
	EReference getOclExpression_InitializedVariable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.ocl.expressions.OclExpression#getParentOperation <em>Parent Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Operation</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclExpression#getParentOperation()
	 * @see #getOclExpression()
	 * @generated
	 */
    EReference getOclExpression_ParentOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.OclExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclExpression#getType()
	 * @see #getOclExpression()
	 * @generated
	 */
    EReference getOclExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.OclMessageArg <em>Ocl Message Arg</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Message Arg</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclMessageArg
	 * @generated
	 */
    EClass getOclMessageArg();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.OclMessageArg#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclMessageArg#getExpression()
	 * @see #getOclMessageArg()
	 * @generated
	 */
    EReference getOclMessageArg_Expression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.OclMessageArg#getUnspecified <em>Unspecified</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unspecified</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OclMessageArg#getUnspecified()
	 * @see #getOclMessageArg()
	 * @generated
	 */
    EReference getOclMessageArg_Unspecified();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OperationCallExp
	 * @generated
	 */
    EClass getOperationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ocl.expressions.OperationCallExp#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OperationCallExp#getArguments()
	 * @see #getOperationCallExp()
	 * @generated
	 */
    EReference getOperationCallExp_Arguments();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.OperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.emf.ocl.expressions.OperationCallExp#getReferredOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
    EReference getOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp
	 * @generated
	 */
    EClass getPrimitiveLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.PropertyCallExp
	 * @generated
	 */
    EClass getPropertyCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.PropertyCallExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.emf.ocl.expressions.PropertyCallExp#getSource()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
    EReference getPropertyCallExp_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.RealLiteralExp
	 * @generated
	 */
    EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.expressions.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Symbol</em>'.
	 * @see org.eclipse.emf.ocl.expressions.RealLiteralExp#getRealSymbol()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
    EAttribute getRealLiteralExp_RealSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.StringLiteralExp
	 * @generated
	 */
    EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.expressions.StringLiteralExp#getStringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Symbol</em>'.
	 * @see org.eclipse.emf.ocl.expressions.StringLiteralExp#getStringSymbol()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
    EAttribute getStringLiteralExp_StringSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.TupleLiteralExp
	 * @generated
	 */
    EClass getTupleLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ocl.expressions.TupleLiteralExp#getTuplePart <em>Tuple Part</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tuple Part</em>'.
	 * @see org.eclipse.emf.ocl.expressions.TupleLiteralExp#getTuplePart()
	 * @see #getTupleLiteralExp()
	 * @generated
	 */
    EReference getTupleLiteralExp_TuplePart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unspecified Value Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.UnspecifiedValueExp
	 * @generated
	 */
    EClass getUnspecifiedValueExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration
	 * @generated
	 */
    EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration#getVarName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
    EAttribute getVariableDeclaration_VarName();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getLoopExpr <em>Loop Expr</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Loop Expr</em>'.
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration#getLoopExpr()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
    EReference getVariableDeclaration_LoopExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration#getInitExpression()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
    EReference getVariableDeclaration_InitExpression();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getBaseExp <em>Base Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Base Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration#getBaseExp()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
    EReference getVariableDeclaration_BaseExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
    EReference getVariableDeclaration_Type();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.emf.ocl.expressions.VariableExp <em>Variable Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Variable Exp</em>'.
     * @see org.eclipse.emf.ocl.expressions.VariableExp
     * @generated
     */
    EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.emf.ocl.expressions.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
    EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.expressions.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class Call Exp</em>'.
	 * @see org.eclipse.emf.ocl.expressions.AssociationClassCallExp
	 * @generated
	 */
	EClass getAssociationClassCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.expressions.AssociationClassCallExp#getReferredAssociationClass <em>Referred Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Association Class</em>'.
	 * @see org.eclipse.emf.ocl.expressions.AssociationClassCallExp#getReferredAssociationClass()
	 * @see #getAssociationClassCallExp()
	 * @generated
	 */
	EReference getAssociationClassCallExp_ReferredAssociationClass();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.ocl.expressions.CollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Kind</em>'.
	 * @see org.eclipse.emf.ocl.expressions.CollectionKind
	 * @generated
	 */
    EEnum getCollectionKind();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ocl.expressions.Visitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Visitor</em>'.
	 * @see org.eclipse.emf.ocl.expressions.Visitor
	 * @model instanceClass="org.eclipse.emf.ocl.expressions.Visitor"
	 * @generated
	 */
	EDataType getVisitor();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ExpressionsFactory getExpressionsFactory();

} //ExpressionsPackage
