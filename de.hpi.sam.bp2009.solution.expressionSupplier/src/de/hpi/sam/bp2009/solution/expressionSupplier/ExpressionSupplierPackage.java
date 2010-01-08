/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.expressionSupplier;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionSupplierPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressionSupplier";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.expressionSupplier";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expressionSupplier";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionSupplierPackage eINSTANCE = de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierImpl <em>Expression Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierImpl
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierPackageImpl#getExpressionSupplier()
	 * @generated
	 */
	int EXPRESSION_SUPPLIER = 0;

	/**
	 * The feature id for the '<em><b>Analyzer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SUPPLIER__ANALYZER = 0;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SUPPLIER__QUERIES = 1;

	/**
	 * The number of structural features of the '<em>Expression Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SUPPLIER_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier <em>Expression Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Supplier</em>'.
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier
	 * @generated
	 */
	EClass getExpressionSupplier();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getAnalyzer <em>Analyzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Analyzer</em>'.
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getAnalyzer()
	 * @see #getExpressionSupplier()
	 * @generated
	 */
	EReference getExpressionSupplier_Analyzer();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queries</em>'.
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getQueries()
	 * @see #getExpressionSupplier()
	 * @generated
	 */
	EAttribute getExpressionSupplier_Queries();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionSupplierFactory getExpressionSupplierFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierImpl <em>Expression Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierImpl
		 * @see de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierPackageImpl#getExpressionSupplier()
		 * @generated
		 */
		EClass EXPRESSION_SUPPLIER = eINSTANCE.getExpressionSupplier();

		/**
		 * The meta object literal for the '<em><b>Analyzer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_SUPPLIER__ANALYZER = eINSTANCE.getExpressionSupplier_Analyzer();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_SUPPLIER__QUERIES = eINSTANCE.getExpressionSupplier_Queries();

	}

} //ExpressionSupplierPackage
