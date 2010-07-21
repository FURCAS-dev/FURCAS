/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator;

import org.eclipse.emf.ecore.EFactory;

import de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOperator;
import de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage
 * @generated
 */
public interface OclOperatorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclOperatorFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ocl Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Operator</em>'.
	 * @generated
	 */
	OclOperator createOclOperator();

	/**
	 * Returns a new object of class '<em>Ocl Option Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Option Object</em>'.
	 * @generated
	 */
	OclOptionObject createOclOptionObject();

	/**
	 * Returns a new object of class '<em>Ocl Util</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Util</em>'.
	 * @generated
	 */
	OclUtil createOclUtil();

	/**
	 * Returns a new object of class '<em>Ocl Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Result</em>'.
	 * @generated
	 */
	OclResult createOclResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OclOperatorPackage getOclOperatorPackage();

} //OclOperatorFactory
