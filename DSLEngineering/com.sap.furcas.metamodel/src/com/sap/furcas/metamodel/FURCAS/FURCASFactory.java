/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.FURCASPackage
 * @generated
 */
public interface FURCASFactory extends EFactory {
        /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        FURCASFactory eINSTANCE = com.sap.furcas.metamodel.FURCAS.impl.FURCASFactoryImpl.init();

        /**
	 * Returns a new object of class '<em>Empty Dummy Class To Workaround Generator Bug</em>'.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return a new object of class '<em>Empty Dummy Class To Workaround Generator Bug</em>'.
	 * @generated
	 */
        EmptyDummyClassToWorkaroundGeneratorBug createEmptyDummyClassToWorkaroundGeneratorBug();

        /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
        FURCASPackage getFURCASPackage();

} //FURCASFactory
