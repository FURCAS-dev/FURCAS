/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.kernel;

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
 * @see de.ikv.medini.kernel.KernelFactory
 * @model kind="package"
 * @generated
 */
public interface KernelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kernel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///de/ikv/medini/kernel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.ikv.medini.kernel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KernelPackage eINSTANCE = de.ikv.medini.kernel.impl.KernelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.kernel.impl.MediniObjectImpl <em>Medini Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.kernel.impl.MediniObjectImpl
	 * @see de.ikv.medini.kernel.impl.KernelPackageImpl#getMediniObject()
	 * @generated
	 */
	int MEDINI_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDINI_OBJECT__MEDINI_IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Medini Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDINI_OBJECT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.ikv.medini.kernel.MediniObject <em>Medini Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Medini Object</em>'.
	 * @see de.ikv.medini.kernel.MediniObject
	 * @generated
	 */
	EClass getMediniObject();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.kernel.MediniObject#getMediniIdentifier <em>Medini Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Medini Identifier</em>'.
	 * @see de.ikv.medini.kernel.MediniObject#getMediniIdentifier()
	 * @see #getMediniObject()
	 * @generated
	 */
	EAttribute getMediniObject_MediniIdentifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KernelFactory getKernelFactory();

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
		 * The meta object literal for the '{@link de.ikv.medini.kernel.impl.MediniObjectImpl <em>Medini Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.kernel.impl.MediniObjectImpl
		 * @see de.ikv.medini.kernel.impl.KernelPackageImpl#getMediniObject()
		 * @generated
		 */
		EClass MEDINI_OBJECT = eINSTANCE.getMediniObject();

		/**
		 * The meta object literal for the '<em><b>Medini Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDINI_OBJECT__MEDINI_IDENTIFIER = eINSTANCE.getMediniObject_MediniIdentifier();

	}

} //KernelPackage
