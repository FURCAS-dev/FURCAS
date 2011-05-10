/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.oclinversion.OclinversionPackage
 * @generated
 */
public interface OclinversionFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OclinversionFactory eINSTANCE = com.sap.furcas.oclinversion.impl.OclinversionFactoryImpl.init();

    /**
     * Returns a new object of class '<em>QMark Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>QMark Literal Exp</em>'.
     * @generated
     */
    QMarkLiteralExp createQMarkLiteralExp();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    OclinversionPackage getOclinversionPackage();

} //OclinversionFactory
