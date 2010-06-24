/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage
 * @generated
 */
public interface OclToMqlOperatorFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OclToMqlOperatorFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Ocl To Mql Operator</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ocl To Mql Operator</em>'.
     * @generated
     */
    OclToMqlOperator createOclToMqlOperator();

    /**
     * Returns a new object of class '<em>Ocl To Mql Util</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ocl To Mql Util</em>'.
     * @generated
     */
    OclToMqlUtil createOclToMqlUtil();

    /**
     * Returns a new object of class '<em>Ocl To Mql Result</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ocl To Mql Result</em>'.
     * @generated
     */
    OclToMqlResult createOclToMqlResult();

    /**
     * Returns a new object of class '<em>Ocl To Mql Option Object</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ocl To Mql Option Object</em>'.
     * @generated
     */
    OclToMqlOptionObject createOclToMqlOptionObject();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    OclToMqlOperatorPackage getOclToMqlOperatorPackage();

} //OclToMqlOperatorFactory
