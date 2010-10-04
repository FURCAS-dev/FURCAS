/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblockdefinition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.textblockdefinition.TextblockdefinitionPackage
 * @generated
 */
public interface TextblockdefinitionFactory extends EFactory {
        /**
         * The singleton instance of the factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        TextblockdefinitionFactory eINSTANCE = com.sap.furcas.metamodel.textblockdefinition.impl.TextblockdefinitionFactoryImpl.init();

        /**
         * Returns a new object of class '<em>Textblock Definition</em>'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return a new object of class '<em>Textblock Definition</em>'.
         * @generated
         */
        TextblockDefinition createTextblockDefinition();

        /**
         * Returns the package supported by this factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the package supported by this factory.
         * @generated
         */
        TextblockdefinitionPackage getTextblockdefinitionPackage();

} //TextblockdefinitionFactory
