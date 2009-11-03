/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.qvt;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.oslo.ocl20.semantics.SemanticsPackage;

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
 * @see de.ikv.medini.qvt.qvt.QvtFactory
 * @model kind="package"
 * @generated
 */
public interface QvtPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:semanticsQvt.qvt.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "semanticsQvt.qvt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QvtPackage eINSTANCE = de.ikv.medini.qvt.qvt.impl.QvtPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.qvt.impl.QvtVisitorImpl <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.qvt.qvt.impl.QvtVisitorImpl
	 * @see de.ikv.medini.qvt.qvt.impl.QvtPackageImpl#getQvtVisitor()
	 * @generated
	 */
	int QVT_VISITOR = 0;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QVT_VISITOR_FEATURE_COUNT = SemanticsPackage.OCL_VISITOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.qvt.QvtVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see de.ikv.medini.qvt.qvt.QvtVisitor
	 * @generated
	 */
	EClass getQvtVisitor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QvtFactory getQvtFactory();

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
		 * The meta object literal for the '{@link de.ikv.medini.qvt.qvt.impl.QvtVisitorImpl <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.qvt.qvt.impl.QvtVisitorImpl
		 * @see de.ikv.medini.qvt.qvt.impl.QvtPackageImpl#getQvtVisitor()
		 * @generated
		 */
		EClass QVT_VISITOR = eINSTANCE.getQvtVisitor();

	}

} //QvtPackage
