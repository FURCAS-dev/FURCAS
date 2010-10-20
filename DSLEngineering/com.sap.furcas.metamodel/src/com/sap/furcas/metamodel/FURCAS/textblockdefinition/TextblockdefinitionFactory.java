/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage
 * @generated
 */
public interface TextblockdefinitionFactory extends EFactory {
        /**
         * The singleton instance of the factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        TextblockdefinitionFactory eINSTANCE = com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionFactoryImpl.init();

        /**
         * Returns a new object of class '<em>Text Block Definition</em>'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return a new object of class '<em>Text Block Definition</em>'.
         * @generated
         */
        TextBlockDefinition createTextBlockDefinition();

        /**
         * Returns the package supported by this factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the package supported by this factory.
         * @generated
         */
        TextblockdefinitionPackage getTextblockdefinitionPackage();

} //TextblockdefinitionFactory
