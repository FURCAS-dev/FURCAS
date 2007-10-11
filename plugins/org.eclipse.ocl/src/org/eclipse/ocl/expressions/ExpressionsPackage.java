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
 * $Id: ExpressionsPackage.java,v 1.5 2007/10/11 23:05:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.utilities.UtilitiesPackage;

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
 * @see org.eclipse.ocl.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "expressions"; //$NON-NLS-1$

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.eclipse.org/ocl/1.1.0/OCL/Expressions"; //$NON-NLS-1$

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ocl.expr"; //$NON-NLS-1$

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ExpressionsPackage eINSTANCE = org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl.init();

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.OCLExpressionImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getOCLExpression()
     * @generated
     */
	int OCL_EXPRESSION = 4;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__START_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__END_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>OCL Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION_FEATURE_COUNT = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.CallExpImpl <em>Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.CallExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCallExp()
     * @generated
     */
	int CALL_EXP = 3;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.FeatureCallExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getFeatureCallExp()
     * @generated
     */
	int FEATURE_CALL_EXP = 2;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__START_POSITION = CALL_EXP__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__END_POSITION = CALL_EXP__END_POSITION;

	/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__PROPERTY_START_POSITION = CALL_EXP__PROPERTY_START_POSITION;

	/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__PROPERTY_END_POSITION = CALL_EXP__PROPERTY_END_POSITION;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__MARKED_PRE = CALL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Feature Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.NavigationCallExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getNavigationCallExp()
     * @generated
     */
	int NAVIGATION_CALL_EXP = 1;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

	/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

	/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

	/**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__QUALIFIER = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Navigation Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.AssociationClassCallExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getAssociationClassCallExp()
     * @generated
     */
	int ASSOCIATION_CLASS_CALL_EXP = 0;

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
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

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
     * The number of structural features of the '<em>Association Class Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.LiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getLiteralExp()
     * @generated
     */
	int LITERAL_EXP = 7;

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
     * The number of structural features of the '<em>Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.PrimitiveLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getPrimitiveLiteralExp()
     * @generated
     */
	int PRIMITIVE_LITERAL_EXP = 6;

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
     * The number of structural features of the '<em>Primitive Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.BooleanLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getBooleanLiteralExp()
     * @generated
     */
	int BOOLEAN_LITERAL_EXP = 5;

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
     * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.CollectionLiteralPartImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralPart()
     * @generated
     */
	int COLLECTION_LITERAL_PART = 9;

	/**
     * The number of structural features of the '<em>Collection Literal Part</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART_FEATURE_COUNT = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.CollectionItemImpl <em>Collection Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.CollectionItemImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionItem()
     * @generated
     */
	int COLLECTION_ITEM = 8;

	/**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Collection Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.CollectionLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralExp()
     * @generated
     */
	int COLLECTION_LITERAL_EXP = 10;

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
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Part</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Simple Range</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__SIMPLE_RANGE = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Collection Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.CollectionRangeImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionRange()
     * @generated
     */
	int COLLECTION_RANGE = 11;

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
     * The number of structural features of the '<em>Collection Range</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.EnumLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getEnumLiteralExp()
     * @generated
     */
	int ENUM_LITERAL_EXP = 12;

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
     * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Enum Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.IfExpImpl <em>If Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.IfExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIfExp()
     * @generated
     */
	int IF_EXP = 13;

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
     * The number of structural features of the '<em>If Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.NumericLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getNumericLiteralExp()
     * @generated
     */
	int NUMERIC_LITERAL_EXP = 15;

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
     * The number of structural features of the '<em>Numeric Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.IntegerLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIntegerLiteralExp()
     * @generated
     */
	int INTEGER_LITERAL_EXP = 14;

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
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Integer Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.UnlimitedNaturalLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getUnlimitedNaturalLiteralExp()
     * @generated
     */
    int UNLIMITED_NATURAL_LITERAL_EXP = 16;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Unlimited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Unlimited Natural Literal Exp</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.InvalidLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getInvalidLiteralExp()
     * @generated
     */
	int INVALID_LITERAL_EXP = 17;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
     * The number of structural features of the '<em>Invalid Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.LoopExpImpl <em>Loop Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.LoopExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getLoopExp()
     * @generated
     */
	int LOOP_EXP = 19;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__START_POSITION = CALL_EXP__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__END_POSITION = CALL_EXP__END_POSITION;

	/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__PROPERTY_START_POSITION = CALL_EXP__PROPERTY_START_POSITION;

	/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__PROPERTY_END_POSITION = CALL_EXP__PROPERTY_END_POSITION;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__BODY = CALL_EXP_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__ITERATOR = CALL_EXP_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Loop Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.IterateExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIterateExp()
     * @generated
     */
	int ITERATE_EXP = 18;

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
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Iterate Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.IteratorExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIteratorExp()
     * @generated
     */
	int ITERATOR_EXP = 21;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.LetExpImpl <em>Let Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.LetExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getLetExp()
     * @generated
     */
	int LET_EXP = 22;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.MessageExpImpl <em>Message Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.MessageExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getMessageExp()
     * @generated
     */
	int MESSAGE_EXP = 23;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.NullLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getNullLiteralExp()
     * @generated
     */
	int NULL_LITERAL_EXP = 24;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.OperationCallExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getOperationCallExp()
     * @generated
     */
	int OPERATION_CALL_EXP = 25;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.PropertyCallExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getPropertyCallExp()
     * @generated
     */
	int PROPERTY_CALL_EXP = 26;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.RealLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getRealLiteralExp()
     * @generated
     */
	int REAL_LITERAL_EXP = 27;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.StateExpImpl <em>State Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.StateExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getStateExp()
     * @generated
     */
	int STATE_EXP = 28;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.StringLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getStringLiteralExp()
     * @generated
     */
	int STRING_LITERAL_EXP = 29;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.TupleLiteralExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getTupleLiteralExp()
     * @generated
     */
	int TUPLE_LITERAL_EXP = 30;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.TupleLiteralPartImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getTupleLiteralPart()
     * @generated
     */
	int TUPLE_LITERAL_PART = 31;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.TypeExpImpl <em>Type Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.TypeExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getTypeExp()
     * @generated
     */
	int TYPE_EXP = 32;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.UnspecifiedValueExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getUnspecifiedValueExp()
     * @generated
     */
	int UNSPECIFIED_VALUE_EXP = 33;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.VariableImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getVariable()
     * @generated
     */
	int VARIABLE = 20;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__START_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__END_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__TYPE_START_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__TYPE_END_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__INIT_EXPRESSION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__REPRESENTED_PARAMETER = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Variable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_FEATURE_COUNT = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 6;

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
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
     * The number of structural features of the '<em>Iterator Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

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
     * The number of structural features of the '<em>Let Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Target</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__TARGET = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__ARGUMENT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Called Operation</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__CALLED_OPERATION = OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Sent Signal</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__SENT_SIGNAL = OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Message Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
     * The number of structural features of the '<em>Null Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

	/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

	/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__ARGUMENT = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Operation Code</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__OPERATION_CODE = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Operation Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

	/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

	/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

	/**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
     * The feature id for the '<em><b>Referred Property</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__REFERRED_PROPERTY = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Property Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

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
     * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Real Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
     * The feature id for the '<em><b>Referred State</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__REFERRED_STATE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>State Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

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
     * The feature id for the '<em><b>String Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>String Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

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
     * The feature id for the '<em><b>Part</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Tuple Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__START_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__END_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__TYPE_START_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__TYPE_END_POSITION = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__VALUE = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__ATTRIBUTE = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Tuple Literal Part</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART_FEATURE_COUNT = UtilitiesPackage.TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
     * The feature id for the '<em><b>Referred Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__REFERRED_TYPE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Type Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

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
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Unspecified Value Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.impl.VariableExpImpl <em>Variable Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.impl.VariableExpImpl
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getVariableExp()
     * @generated
     */
	int VARIABLE_EXP = 34;

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
     * The feature id for the '<em><b>Referred Variable</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Variable Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.expressions.CollectionKind <em>Collection Kind</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.expressions.CollectionKind
     * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionKind()
     * @generated
     */
	int COLLECTION_KIND = 35;


	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Association Class Call Exp</em>'.
     * @see org.eclipse.ocl.expressions.AssociationClassCallExp
     * @generated
     */
	EClass getAssociationClassCallExp();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.AssociationClassCallExp#getReferredAssociationClass <em>Referred Association Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Association Class</em>'.
     * @see org.eclipse.ocl.expressions.AssociationClassCallExp#getReferredAssociationClass()
     * @see #getAssociationClassCallExp()
     * @generated
     */
	EReference getAssociationClassCallExp_ReferredAssociationClass();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.BooleanLiteralExp
     * @generated
     */
	EClass getBooleanLiteralExp();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.BooleanLiteralExp#getBooleanSymbol <em>Boolean Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
     * @see org.eclipse.ocl.expressions.BooleanLiteralExp#getBooleanSymbol()
     * @see #getBooleanLiteralExp()
     * @generated
     */
	EAttribute getBooleanLiteralExp_BooleanSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.CallExp <em>Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call Exp</em>'.
     * @see org.eclipse.ocl.expressions.CallExp
     * @generated
     */
	EClass getCallExp();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.CallExp#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Source</em>'.
     * @see org.eclipse.ocl.expressions.CallExp#getSource()
     * @see #getCallExp()
     * @generated
     */
	EReference getCallExp_Source();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.CollectionItem <em>Collection Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Item</em>'.
     * @see org.eclipse.ocl.expressions.CollectionItem
     * @generated
     */
	EClass getCollectionItem();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.CollectionItem#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Item</em>'.
     * @see org.eclipse.ocl.expressions.CollectionItem#getItem()
     * @see #getCollectionItem()
     * @generated
     */
	EReference getCollectionItem_Item();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.CollectionLiteralExp
     * @generated
     */
	EClass getCollectionLiteralExp();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.CollectionLiteralExp#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see org.eclipse.ocl.expressions.CollectionLiteralExp#getKind()
     * @see #getCollectionLiteralExp()
     * @generated
     */
	EAttribute getCollectionLiteralExp_Kind();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.expressions.CollectionLiteralExp#getPart <em>Part</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Part</em>'.
     * @see org.eclipse.ocl.expressions.CollectionLiteralExp#getPart()
     * @see #getCollectionLiteralExp()
     * @generated
     */
	EReference getCollectionLiteralExp_Part();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.CollectionLiteralExp#isSimpleRange <em>Simple Range</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Simple Range</em>'.
     * @see org.eclipse.ocl.expressions.CollectionLiteralExp#isSimpleRange()
     * @see #getCollectionLiteralExp()
     * @generated
     */
	EAttribute getCollectionLiteralExp_SimpleRange();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.CollectionLiteralPart <em>Collection Literal Part</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Literal Part</em>'.
     * @see org.eclipse.ocl.expressions.CollectionLiteralPart
     * @generated
     */
	EClass getCollectionLiteralPart();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.CollectionRange <em>Collection Range</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Range</em>'.
     * @see org.eclipse.ocl.expressions.CollectionRange
     * @generated
     */
	EClass getCollectionRange();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.CollectionRange#getFirst <em>First</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>First</em>'.
     * @see org.eclipse.ocl.expressions.CollectionRange#getFirst()
     * @see #getCollectionRange()
     * @generated
     */
	EReference getCollectionRange_First();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.CollectionRange#getLast <em>Last</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Last</em>'.
     * @see org.eclipse.ocl.expressions.CollectionRange#getLast()
     * @see #getCollectionRange()
     * @generated
     */
	EReference getCollectionRange_Last();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.EnumLiteralExp
     * @generated
     */
	EClass getEnumLiteralExp();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Enum Literal</em>'.
     * @see org.eclipse.ocl.expressions.EnumLiteralExp#getReferredEnumLiteral()
     * @see #getEnumLiteralExp()
     * @generated
     */
	EReference getEnumLiteralExp_ReferredEnumLiteral();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.FeatureCallExp <em>Feature Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Call Exp</em>'.
     * @see org.eclipse.ocl.expressions.FeatureCallExp
     * @generated
     */
	EClass getFeatureCallExp();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.FeatureCallExp#isMarkedPre <em>Marked Pre</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Marked Pre</em>'.
     * @see org.eclipse.ocl.expressions.FeatureCallExp#isMarkedPre()
     * @see #getFeatureCallExp()
     * @generated
     */
	EAttribute getFeatureCallExp_MarkedPre();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.IfExp <em>If Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>If Exp</em>'.
     * @see org.eclipse.ocl.expressions.IfExp
     * @generated
     */
	EClass getIfExp();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.IfExp#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see org.eclipse.ocl.expressions.IfExp#getCondition()
     * @see #getIfExp()
     * @generated
     */
	EReference getIfExp_Condition();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.IfExp#getThenExpression <em>Then Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Then Expression</em>'.
     * @see org.eclipse.ocl.expressions.IfExp#getThenExpression()
     * @see #getIfExp()
     * @generated
     */
	EReference getIfExp_ThenExpression();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.IfExp#getElseExpression <em>Else Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Else Expression</em>'.
     * @see org.eclipse.ocl.expressions.IfExp#getElseExpression()
     * @see #getIfExp()
     * @generated
     */
	EReference getIfExp_ElseExpression();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integer Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.IntegerLiteralExp
     * @generated
     */
	EClass getIntegerLiteralExp();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Integer Symbol</em>'.
     * @see org.eclipse.ocl.expressions.IntegerLiteralExp#getIntegerSymbol()
     * @see #getIntegerLiteralExp()
     * @generated
     */
	EAttribute getIntegerLiteralExp_IntegerSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unlimited Natural Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp
     * @generated
     */
    EClass getUnlimitedNaturalLiteralExp();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Integer Symbol</em>'.
     * @see org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp#getIntegerSymbol()
     * @see #getUnlimitedNaturalLiteralExp()
     * @generated
     */
    EAttribute getUnlimitedNaturalLiteralExp_IntegerSymbol();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp#isUnlimited <em>Unlimited</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unlimited</em>'.
     * @see org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp#isUnlimited()
     * @see #getUnlimitedNaturalLiteralExp()
     * @generated
     */
    EAttribute getUnlimitedNaturalLiteralExp_Unlimited();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Invalid Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.InvalidLiteralExp
     * @generated
     */
	EClass getInvalidLiteralExp();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.IterateExp <em>Iterate Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Iterate Exp</em>'.
     * @see org.eclipse.ocl.expressions.IterateExp
     * @generated
     */
	EClass getIterateExp();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.IterateExp#getResult <em>Result</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Result</em>'.
     * @see org.eclipse.ocl.expressions.IterateExp#getResult()
     * @see #getIterateExp()
     * @generated
     */
	EReference getIterateExp_Result();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.IteratorExp <em>Iterator Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Iterator Exp</em>'.
     * @see org.eclipse.ocl.expressions.IteratorExp
     * @generated
     */
	EClass getIteratorExp();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.LetExp <em>Let Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Let Exp</em>'.
     * @see org.eclipse.ocl.expressions.LetExp
     * @generated
     */
	EClass getLetExp();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.LetExp#getIn <em>In</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>In</em>'.
     * @see org.eclipse.ocl.expressions.LetExp#getIn()
     * @see #getLetExp()
     * @generated
     */
	EReference getLetExp_In();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.LetExp#getVariable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Variable</em>'.
     * @see org.eclipse.ocl.expressions.LetExp#getVariable()
     * @see #getLetExp()
     * @generated
     */
	EReference getLetExp_Variable();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.LiteralExp <em>Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.LiteralExp
     * @generated
     */
	EClass getLiteralExp();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.LoopExp <em>Loop Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Loop Exp</em>'.
     * @see org.eclipse.ocl.expressions.LoopExp
     * @generated
     */
	EClass getLoopExp();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.LoopExp#getBody <em>Body</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Body</em>'.
     * @see org.eclipse.ocl.expressions.LoopExp#getBody()
     * @see #getLoopExp()
     * @generated
     */
	EReference getLoopExp_Body();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.expressions.LoopExp#getIterator <em>Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Iterator</em>'.
     * @see org.eclipse.ocl.expressions.LoopExp#getIterator()
     * @see #getLoopExp()
     * @generated
     */
	EReference getLoopExp_Iterator();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.MessageExp <em>Message Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Exp</em>'.
     * @see org.eclipse.ocl.expressions.MessageExp
     * @generated
     */
	EClass getMessageExp();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.MessageExp#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Target</em>'.
     * @see org.eclipse.ocl.expressions.MessageExp#getTarget()
     * @see #getMessageExp()
     * @generated
     */
	EReference getMessageExp_Target();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.expressions.MessageExp#getArgument <em>Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Argument</em>'.
     * @see org.eclipse.ocl.expressions.MessageExp#getArgument()
     * @see #getMessageExp()
     * @generated
     */
	EReference getMessageExp_Argument();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.MessageExp#getCalledOperation <em>Called Operation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Called Operation</em>'.
     * @see org.eclipse.ocl.expressions.MessageExp#getCalledOperation()
     * @see #getMessageExp()
     * @generated
     */
	EReference getMessageExp_CalledOperation();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.MessageExp#getSentSignal <em>Sent Signal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Sent Signal</em>'.
     * @see org.eclipse.ocl.expressions.MessageExp#getSentSignal()
     * @see #getMessageExp()
     * @generated
     */
	EReference getMessageExp_SentSignal();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.NavigationCallExp <em>Navigation Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Navigation Call Exp</em>'.
     * @see org.eclipse.ocl.expressions.NavigationCallExp
     * @generated
     */
	EClass getNavigationCallExp();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.expressions.NavigationCallExp#getQualifier <em>Qualifier</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Qualifier</em>'.
     * @see org.eclipse.ocl.expressions.NavigationCallExp#getQualifier()
     * @see #getNavigationCallExp()
     * @generated
     */
	EReference getNavigationCallExp_Qualifier();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Navigation Source</em>'.
     * @see org.eclipse.ocl.expressions.NavigationCallExp#getNavigationSource()
     * @see #getNavigationCallExp()
     * @generated
     */
	EReference getNavigationCallExp_NavigationSource();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.NullLiteralExp <em>Null Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Null Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.NullLiteralExp
     * @generated
     */
	EClass getNullLiteralExp();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Numeric Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.NumericLiteralExp
     * @generated
     */
	EClass getNumericLiteralExp();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.OCLExpression <em>OCL Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>OCL Expression</em>'.
     * @see org.eclipse.ocl.expressions.OCLExpression
     * @generated
     */
	EClass getOCLExpression();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.OperationCallExp <em>Operation Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation Call Exp</em>'.
     * @see org.eclipse.ocl.expressions.OperationCallExp
     * @generated
     */
	EClass getOperationCallExp();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.expressions.OperationCallExp#getArgument <em>Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Argument</em>'.
     * @see org.eclipse.ocl.expressions.OperationCallExp#getArgument()
     * @see #getOperationCallExp()
     * @generated
     */
	EReference getOperationCallExp_Argument();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.OperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Operation</em>'.
     * @see org.eclipse.ocl.expressions.OperationCallExp#getReferredOperation()
     * @see #getOperationCallExp()
     * @generated
     */
	EReference getOperationCallExp_ReferredOperation();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.OperationCallExp#getOperationCode <em>Operation Code</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Operation Code</em>'.
     * @see org.eclipse.ocl.expressions.OperationCallExp#getOperationCode()
     * @see #getOperationCallExp()
     * @generated
     */
	EAttribute getOperationCallExp_OperationCode();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.PrimitiveLiteralExp
     * @generated
     */
	EClass getPrimitiveLiteralExp();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.PropertyCallExp <em>Property Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Call Exp</em>'.
     * @see org.eclipse.ocl.expressions.PropertyCallExp
     * @generated
     */
	EClass getPropertyCallExp();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.PropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Property</em>'.
     * @see org.eclipse.ocl.expressions.PropertyCallExp#getReferredProperty()
     * @see #getPropertyCallExp()
     * @generated
     */
	EReference getPropertyCallExp_ReferredProperty();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Real Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.RealLiteralExp
     * @generated
     */
	EClass getRealLiteralExp();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Real Symbol</em>'.
     * @see org.eclipse.ocl.expressions.RealLiteralExp#getRealSymbol()
     * @see #getRealLiteralExp()
     * @generated
     */
	EAttribute getRealLiteralExp_RealSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.StateExp <em>State Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>State Exp</em>'.
     * @see org.eclipse.ocl.expressions.StateExp
     * @generated
     */
	EClass getStateExp();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.StateExp#getReferredState <em>Referred State</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred State</em>'.
     * @see org.eclipse.ocl.expressions.StateExp#getReferredState()
     * @see #getStateExp()
     * @generated
     */
	EReference getStateExp_ReferredState();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.StringLiteralExp <em>String Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.StringLiteralExp
     * @generated
     */
	EClass getStringLiteralExp();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.expressions.StringLiteralExp#getStringSymbol <em>String Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>String Symbol</em>'.
     * @see org.eclipse.ocl.expressions.StringLiteralExp#getStringSymbol()
     * @see #getStringLiteralExp()
     * @generated
     */
	EAttribute getStringLiteralExp_StringSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Literal Exp</em>'.
     * @see org.eclipse.ocl.expressions.TupleLiteralExp
     * @generated
     */
	EClass getTupleLiteralExp();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.expressions.TupleLiteralExp#getPart <em>Part</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Part</em>'.
     * @see org.eclipse.ocl.expressions.TupleLiteralExp#getPart()
     * @see #getTupleLiteralExp()
     * @generated
     */
	EReference getTupleLiteralExp_Part();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.TupleLiteralPart <em>Tuple Literal Part</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Literal Part</em>'.
     * @see org.eclipse.ocl.expressions.TupleLiteralPart
     * @generated
     */
	EClass getTupleLiteralPart();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.TupleLiteralPart#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see org.eclipse.ocl.expressions.TupleLiteralPart#getValue()
     * @see #getTupleLiteralPart()
     * @generated
     */
	EReference getTupleLiteralPart_Value();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.TupleLiteralPart#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Attribute</em>'.
     * @see org.eclipse.ocl.expressions.TupleLiteralPart#getAttribute()
     * @see #getTupleLiteralPart()
     * @generated
     */
	EReference getTupleLiteralPart_Attribute();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.TypeExp <em>Type Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Exp</em>'.
     * @see org.eclipse.ocl.expressions.TypeExp
     * @generated
     */
	EClass getTypeExp();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.TypeExp#getReferredType <em>Referred Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Type</em>'.
     * @see org.eclipse.ocl.expressions.TypeExp#getReferredType()
     * @see #getTypeExp()
     * @generated
     */
	EReference getTypeExp_ReferredType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unspecified Value Exp</em>'.
     * @see org.eclipse.ocl.expressions.UnspecifiedValueExp
     * @generated
     */
	EClass getUnspecifiedValueExp();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.Variable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable</em>'.
     * @see org.eclipse.ocl.expressions.Variable
     * @generated
     */
	EClass getVariable();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.expressions.Variable#getInitExpression <em>Init Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Init Expression</em>'.
     * @see org.eclipse.ocl.expressions.Variable#getInitExpression()
     * @see #getVariable()
     * @generated
     */
	EReference getVariable_InitExpression();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.Variable#getRepresentedParameter <em>Represented Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Represented Parameter</em>'.
     * @see org.eclipse.ocl.expressions.Variable#getRepresentedParameter()
     * @see #getVariable()
     * @generated
     */
	EReference getVariable_RepresentedParameter();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.expressions.VariableExp <em>Variable Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable Exp</em>'.
     * @see org.eclipse.ocl.expressions.VariableExp
     * @generated
     */
	EClass getVariableExp();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.expressions.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Variable</em>'.
     * @see org.eclipse.ocl.expressions.VariableExp#getReferredVariable()
     * @see #getVariableExp()
     * @generated
     */
	EReference getVariableExp_ReferredVariable();

	/**
     * Returns the meta object for enum '{@link org.eclipse.ocl.expressions.CollectionKind <em>Collection Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Collection Kind</em>'.
     * @see org.eclipse.ocl.expressions.CollectionKind
     * @generated
     */
	EEnum getCollectionKind();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ExpressionsFactory getExpressionsFactory();

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
	interface Literals {
		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.AssociationClassCallExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getAssociationClassCallExp()
         * @generated
         */
		EClass ASSOCIATION_CLASS_CALL_EXP = eINSTANCE.getAssociationClassCallExp();

		/**
         * The meta object literal for the '<em><b>Referred Association Class</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = eINSTANCE.getAssociationClassCallExp_ReferredAssociationClass();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.BooleanLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getBooleanLiteralExp()
         * @generated
         */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
         * The meta object literal for the '<em><b>Boolean Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = eINSTANCE.getBooleanLiteralExp_BooleanSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.CallExpImpl <em>Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.CallExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCallExp()
         * @generated
         */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
         * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CALL_EXP__SOURCE = eINSTANCE.getCallExp_Source();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.CollectionItemImpl <em>Collection Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.CollectionItemImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionItem()
         * @generated
         */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

		/**
         * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_ITEM__ITEM = eINSTANCE.getCollectionItem_Item();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.CollectionLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralExp()
         * @generated
         */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLLECTION_LITERAL_EXP__KIND = eINSTANCE.getCollectionLiteralExp_Kind();

		/**
         * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_LITERAL_EXP__PART = eINSTANCE.getCollectionLiteralExp_Part();

		/**
         * The meta object literal for the '<em><b>Simple Range</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLLECTION_LITERAL_EXP__SIMPLE_RANGE = eINSTANCE.getCollectionLiteralExp_SimpleRange();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.CollectionLiteralPartImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralPart()
         * @generated
         */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.CollectionRangeImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionRange()
         * @generated
         */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

		/**
         * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_RANGE__FIRST = eINSTANCE.getCollectionRange_First();

		/**
         * The meta object literal for the '<em><b>Last</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_RANGE__LAST = eINSTANCE.getCollectionRange_Last();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.EnumLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getEnumLiteralExp()
         * @generated
         */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

		/**
         * The meta object literal for the '<em><b>Referred Enum Literal</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = eINSTANCE.getEnumLiteralExp_ReferredEnumLiteral();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.FeatureCallExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getFeatureCallExp()
         * @generated
         */
		EClass FEATURE_CALL_EXP = eINSTANCE.getFeatureCallExp();

		/**
         * The meta object literal for the '<em><b>Marked Pre</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute FEATURE_CALL_EXP__MARKED_PRE = eINSTANCE.getFeatureCallExp_MarkedPre();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.IfExpImpl <em>If Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.IfExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIfExp()
         * @generated
         */
		EClass IF_EXP = eINSTANCE.getIfExp();

		/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IF_EXP__CONDITION = eINSTANCE.getIfExp_Condition();

		/**
         * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IF_EXP__THEN_EXPRESSION = eINSTANCE.getIfExp_ThenExpression();

		/**
         * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IF_EXP__ELSE_EXPRESSION = eINSTANCE.getIfExp_ElseExpression();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.IntegerLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIntegerLiteralExp()
         * @generated
         */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
         * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute INTEGER_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExp_IntegerSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.UnlimitedNaturalLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getUnlimitedNaturalLiteralExp()
         * @generated
         */
        EClass UNLIMITED_NATURAL_LITERAL_EXP = eINSTANCE.getUnlimitedNaturalLiteralExp();

        /**
         * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getUnlimitedNaturalLiteralExp_IntegerSymbol();

        /**
         * The meta object literal for the '<em><b>Unlimited</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED = eINSTANCE.getUnlimitedNaturalLiteralExp_Unlimited();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.InvalidLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getInvalidLiteralExp()
         * @generated
         */
		EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.IterateExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIterateExp()
         * @generated
         */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

		/**
         * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATE_EXP__RESULT = eINSTANCE.getIterateExp_Result();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.IteratorExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getIteratorExp()
         * @generated
         */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.LetExpImpl <em>Let Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.LetExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getLetExp()
         * @generated
         */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
         * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LET_EXP__IN = eINSTANCE.getLetExp_In();

		/**
         * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LET_EXP__VARIABLE = eINSTANCE.getLetExp_Variable();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.LiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getLiteralExp()
         * @generated
         */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.LoopExpImpl <em>Loop Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.LoopExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getLoopExp()
         * @generated
         */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

		/**
         * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LOOP_EXP__BODY = eINSTANCE.getLoopExp_Body();

		/**
         * The meta object literal for the '<em><b>Iterator</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LOOP_EXP__ITERATOR = eINSTANCE.getLoopExp_Iterator();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.MessageExpImpl <em>Message Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.MessageExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getMessageExp()
         * @generated
         */
		EClass MESSAGE_EXP = eINSTANCE.getMessageExp();

		/**
         * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_EXP__TARGET = eINSTANCE.getMessageExp_Target();

		/**
         * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_EXP__ARGUMENT = eINSTANCE.getMessageExp_Argument();

		/**
         * The meta object literal for the '<em><b>Called Operation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_EXP__CALLED_OPERATION = eINSTANCE.getMessageExp_CalledOperation();

		/**
         * The meta object literal for the '<em><b>Sent Signal</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_EXP__SENT_SIGNAL = eINSTANCE.getMessageExp_SentSignal();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.NavigationCallExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getNavigationCallExp()
         * @generated
         */
		EClass NAVIGATION_CALL_EXP = eINSTANCE.getNavigationCallExp();

		/**
         * The meta object literal for the '<em><b>Qualifier</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAVIGATION_CALL_EXP__QUALIFIER = eINSTANCE.getNavigationCallExp_Qualifier();

		/**
         * The meta object literal for the '<em><b>Navigation Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = eINSTANCE.getNavigationCallExp_NavigationSource();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.NullLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getNullLiteralExp()
         * @generated
         */
		EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.NumericLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getNumericLiteralExp()
         * @generated
         */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.OCLExpressionImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getOCLExpression()
         * @generated
         */
		EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.OperationCallExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getOperationCallExp()
         * @generated
         */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
         * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CALL_EXP__ARGUMENT = eINSTANCE.getOperationCallExp_Argument();

		/**
         * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getOperationCallExp_ReferredOperation();

		/**
         * The meta object literal for the '<em><b>Operation Code</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OPERATION_CALL_EXP__OPERATION_CODE = eINSTANCE.getOperationCallExp_OperationCode();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.PrimitiveLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getPrimitiveLiteralExp()
         * @generated
         */
		EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.PropertyCallExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getPropertyCallExp()
         * @generated
         */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
         * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExp_ReferredProperty();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.RealLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getRealLiteralExp()
         * @generated
         */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
         * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute REAL_LITERAL_EXP__REAL_SYMBOL = eINSTANCE.getRealLiteralExp_RealSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.StateExpImpl <em>State Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.StateExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getStateExp()
         * @generated
         */
		EClass STATE_EXP = eINSTANCE.getStateExp();

		/**
         * The meta object literal for the '<em><b>Referred State</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STATE_EXP__REFERRED_STATE = eINSTANCE.getStateExp_ReferredState();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.StringLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getStringLiteralExp()
         * @generated
         */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
         * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute STRING_LITERAL_EXP__STRING_SYMBOL = eINSTANCE.getStringLiteralExp_StringSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.TupleLiteralExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getTupleLiteralExp()
         * @generated
         */
		EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

		/**
         * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TUPLE_LITERAL_EXP__PART = eINSTANCE.getTupleLiteralExp_Part();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.TupleLiteralPartImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getTupleLiteralPart()
         * @generated
         */
		EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TUPLE_LITERAL_PART__VALUE = eINSTANCE.getTupleLiteralPart_Value();

		/**
         * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TUPLE_LITERAL_PART__ATTRIBUTE = eINSTANCE.getTupleLiteralPart_Attribute();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.TypeExpImpl <em>Type Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.TypeExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getTypeExp()
         * @generated
         */
		EClass TYPE_EXP = eINSTANCE.getTypeExp();

		/**
         * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_EXP__REFERRED_TYPE = eINSTANCE.getTypeExp_ReferredType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.UnspecifiedValueExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getUnspecifiedValueExp()
         * @generated
         */
		EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.VariableImpl <em>Variable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.VariableImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getVariable()
         * @generated
         */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
         * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE__INIT_EXPRESSION = eINSTANCE.getVariable_InitExpression();

		/**
         * The meta object literal for the '<em><b>Represented Parameter</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE__REPRESENTED_PARAMETER = eINSTANCE.getVariable_RepresentedParameter();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.impl.VariableExpImpl <em>Variable Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.impl.VariableExpImpl
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getVariableExp()
         * @generated
         */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
         * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.expressions.CollectionKind <em>Collection Kind</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.expressions.CollectionKind
         * @see org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl#getCollectionKind()
         * @generated
         */
		EEnum COLLECTION_KIND = eINSTANCE.getCollectionKind();

	}

} //ExpressionsPackage
