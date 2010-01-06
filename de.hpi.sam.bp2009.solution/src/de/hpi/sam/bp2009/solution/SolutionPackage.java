/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see de.hpi.sam.bp2009.solution.SolutionFactory
 * @model kind="package"
 * @generated
 */
public interface SolutionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "solution";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SolutionPackage eINSTANCE = de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl <em>Expression Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getExpressionSupplier()
	 * @generated
	 */
	int EXPRESSION_SUPPLIER = 0;

	/**
	 * The feature id for the '<em><b>IA</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SUPPLIER__IA = 0;

	/**
	 * The number of structural features of the '<em>Expression Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SUPPLIER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impl.PersistenceImpl <em>Persistence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impl.PersistenceImpl
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getPersistence()
	 * @generated
	 */
	int PERSISTENCE = 1;

	/**
	 * The feature id for the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENCE__EVENT_MANAGER = 0;

	/**
	 * The number of structural features of the '<em>Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENCE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.ExpressionSupplier <em>Expression Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Supplier</em>'.
	 * @see de.hpi.sam.bp2009.solution.ExpressionSupplier
	 * @generated
	 */
	EClass getExpressionSupplier();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.ExpressionSupplier#getIA <em>IA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>IA</em>'.
	 * @see de.hpi.sam.bp2009.solution.ExpressionSupplier#getIA()
	 * @see #getExpressionSupplier()
	 * @generated
	 */
	EReference getExpressionSupplier_IA();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.Persistence <em>Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Persistence</em>'.
	 * @see de.hpi.sam.bp2009.solution.Persistence
	 * @generated
	 */
	EClass getPersistence();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.Persistence#getEventManager <em>Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Manager</em>'.
	 * @see de.hpi.sam.bp2009.solution.Persistence#getEventManager()
	 * @see #getPersistence()
	 * @generated
	 */
	EReference getPersistence_EventManager();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SolutionFactory getSolutionFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl <em>Expression Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getExpressionSupplier()
		 * @generated
		 */
		EClass EXPRESSION_SUPPLIER = eINSTANCE.getExpressionSupplier();

		/**
		 * The meta object literal for the '<em><b>IA</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_SUPPLIER__IA = eINSTANCE.getExpressionSupplier_IA();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impl.PersistenceImpl <em>Persistence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impl.PersistenceImpl
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getPersistence()
		 * @generated
		 */
		EClass PERSISTENCE = eINSTANCE.getPersistence();

		/**
		 * The meta object literal for the '<em><b>Event Manager</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSISTENCE__EVENT_MANAGER = eINSTANCE.getPersistence_EventManager();

	}

} //SolutionPackage
