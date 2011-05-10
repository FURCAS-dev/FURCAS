/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.oclequation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.oclinversion.oclequation.OclequationPackage
 * @generated
 */
public interface OclequationFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OclequationFactory eINSTANCE = com.sap.furcas.oclinversion.oclequation.impl.OclequationFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Ocl Equation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ocl Equation</em>'.
     * @generated
     */
    OclEquation createOclEquation();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    OclequationPackage getOclequationPackage();

} //OclequationFactory
