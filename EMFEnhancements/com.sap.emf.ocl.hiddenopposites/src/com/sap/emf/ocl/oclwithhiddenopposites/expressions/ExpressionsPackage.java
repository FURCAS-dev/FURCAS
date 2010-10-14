/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.expressions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.ecore.EcorePackage;

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
 * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsFactory
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
	String eNAME = "expressions";

	/**
         * The package namespace URI.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	String eNS_URI = "http://www.sap.com/emf/oppositepropertycallexp";

	/**
         * The package namespace name.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	String eNS_PREFIX = "oppositepropertycallexp";

	/**
         * The singleton instance of the package.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	ExpressionsPackage eINSTANCE = com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.ExpressionsPackageImpl.init();

	/**
         * The meta object id for the '{@link com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.OppositePropertyCallExpImpl <em>Opposite Property Call Exp</em>}' class.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.OppositePropertyCallExpImpl
         * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.ExpressionsPackageImpl#getOppositePropertyCallExp()
         * @generated
         */
	int OPPOSITE_PROPERTY_CALL_EXP = 0;

	/**
         * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__EANNOTATIONS = EcorePackage.NAVIGATION_CALL_EXP__EANNOTATIONS;

	/**
         * The feature id for the '<em><b>Name</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__NAME = EcorePackage.NAVIGATION_CALL_EXP__NAME;

	/**
         * The feature id for the '<em><b>Ordered</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__ORDERED = EcorePackage.NAVIGATION_CALL_EXP__ORDERED;

	/**
         * The feature id for the '<em><b>Unique</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__UNIQUE = EcorePackage.NAVIGATION_CALL_EXP__UNIQUE;

	/**
         * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__LOWER_BOUND = EcorePackage.NAVIGATION_CALL_EXP__LOWER_BOUND;

	/**
         * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__UPPER_BOUND = EcorePackage.NAVIGATION_CALL_EXP__UPPER_BOUND;

	/**
         * The feature id for the '<em><b>Many</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__MANY = EcorePackage.NAVIGATION_CALL_EXP__MANY;

	/**
         * The feature id for the '<em><b>Required</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__REQUIRED = EcorePackage.NAVIGATION_CALL_EXP__REQUIRED;

	/**
         * The feature id for the '<em><b>EType</b></em>' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__ETYPE = EcorePackage.NAVIGATION_CALL_EXP__ETYPE;

	/**
         * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__EGENERIC_TYPE = EcorePackage.NAVIGATION_CALL_EXP__EGENERIC_TYPE;

	/**
         * The feature id for the '<em><b>Start Position</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__START_POSITION = EcorePackage.NAVIGATION_CALL_EXP__START_POSITION;

	/**
         * The feature id for the '<em><b>End Position</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__END_POSITION = EcorePackage.NAVIGATION_CALL_EXP__END_POSITION;

	/**
         * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__PROPERTY_START_POSITION = EcorePackage.NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

	/**
         * The feature id for the '<em><b>Property End Position</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__PROPERTY_END_POSITION = EcorePackage.NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

	/**
         * The feature id for the '<em><b>Source</b></em>' containment reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__SOURCE = EcorePackage.NAVIGATION_CALL_EXP__SOURCE;

	/**
         * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__MARKED_PRE = EcorePackage.NAVIGATION_CALL_EXP__MARKED_PRE;

	/**
         * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__QUALIFIER = EcorePackage.NAVIGATION_CALL_EXP__QUALIFIER;

	/**
         * The feature id for the '<em><b>Navigation Source</b></em>' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__NAVIGATION_SOURCE = EcorePackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
         * The feature id for the '<em><b>Referred Opposite Property</b></em>' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY = EcorePackage.NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
         * The number of structural features of the '<em>Opposite Property Call Exp</em>' class.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int OPPOSITE_PROPERTY_CALL_EXP_FEATURE_COUNT = EcorePackage.NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;


	/**
         * Returns the meta object for class '{@link com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp <em>Opposite Property Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the meta object for class '<em>Opposite Property Call Exp</em>'.
         * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp
         * @generated
         */
	EClass getOppositePropertyCallExp();

	/**
         * Returns the meta object for the reference '{@link com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp#getReferredOppositeProperty <em>Referred Opposite Property</em>}'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the meta object for the reference '<em>Referred Opposite Property</em>'.
         * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp#getReferredOppositeProperty()
         * @see #getOppositePropertyCallExp()
         * @generated
         */
	EReference getOppositePropertyCallExp_ReferredOppositeProperty();

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
                 * The meta object literal for the '{@link com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.OppositePropertyCallExpImpl <em>Opposite Property Call Exp</em>}' class.
                 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
                 * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.OppositePropertyCallExpImpl
                 * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.ExpressionsPackageImpl#getOppositePropertyCallExp()
                 * @generated
                 */
		EClass OPPOSITE_PROPERTY_CALL_EXP = eINSTANCE.getOppositePropertyCallExp();

		/**
                 * The meta object literal for the '<em><b>Referred Opposite Property</b></em>' reference feature.
                 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
                 * @generated
                 */
		EReference OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY = eINSTANCE.getOppositePropertyCallExp_ReferredOppositeProperty();

	}

} //ExpressionsPackage
