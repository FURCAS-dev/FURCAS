/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.utilities;

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
 * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesFactory
 * @model kind="package"
 * @generated
 */
public interface UtilitiesPackage extends EPackage {
	/**
         * The package name.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	String eNAME = "utilities";

	/**
         * The package namespace URI.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	String eNS_URI = "http://www.sap.com/emf/oppositepropertycallexputil";

	/**
         * The package namespace name.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	String eNS_PREFIX = "oppositepropertycallexputil";

	/**
         * The singleton instance of the package.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	UtilitiesPackage eINSTANCE = com.sap.emf.ocl.oclwithhiddenopposites.utilities.impl.UtilitiesPackageImpl.init();

	/**
         * The meta object id for the '{@link com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite <em>Visitor With Hidden Opposite</em>}' class.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite
         * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.impl.UtilitiesPackageImpl#getVisitorWithHiddenOpposite()
         * @generated
         */
	int VISITOR_WITH_HIDDEN_OPPOSITE = 0;

	/**
         * The number of structural features of the '<em>Visitor With Hidden Opposite</em>' class.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
	int VISITOR_WITH_HIDDEN_OPPOSITE_FEATURE_COUNT = org.eclipse.ocl.utilities.UtilitiesPackage.VISITOR_FEATURE_COUNT + 0;


	/**
         * Returns the meta object for class '{@link com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite <em>Visitor With Hidden Opposite</em>}'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the meta object for class '<em>Visitor With Hidden Opposite</em>'.
         * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite
         * @generated
         */
	EClass getVisitorWithHiddenOpposite();

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
	interface Literals {
		/**
                 * The meta object literal for the '{@link com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite <em>Visitor With Hidden Opposite</em>}' class.
                 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
                 * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite
                 * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.impl.UtilitiesPackageImpl#getVisitorWithHiddenOpposite()
                 * @generated
                 */
		EClass VISITOR_WITH_HIDDEN_OPPOSITE = eINSTANCE.getVisitorWithHiddenOpposite();

	}

} //UtilitiesPackage
