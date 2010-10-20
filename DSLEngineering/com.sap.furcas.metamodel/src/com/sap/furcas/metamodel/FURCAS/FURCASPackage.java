/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see com.sap.furcas.metamodel.FURCAS.FURCASFactory
 * @model kind="package"
 * @generated
 */
public interface FURCASPackage extends EPackage {
        /**
         * The package name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNAME = "FURCAS";

        /**
         * The package namespace URI.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNS_URI = "http://www.furcas.org";

        /**
         * The package namespace name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNS_PREFIX = "com.sap.furcas";

        /**
         * The singleton instance of the package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        FURCASPackage eINSTANCE = com.sap.furcas.metamodel.FURCAS.impl.FURCASPackageImpl.init();

        /**
         * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.impl.EmptyDummyClassToWorkaroundGeneratorBugImpl <em>Empty Dummy Class To Workaround Generator Bug</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.impl.EmptyDummyClassToWorkaroundGeneratorBugImpl
         * @see com.sap.furcas.metamodel.FURCAS.impl.FURCASPackageImpl#getEmptyDummyClassToWorkaroundGeneratorBug()
         * @generated
         */
        int EMPTY_DUMMY_CLASS_TO_WORKAROUND_GENERATOR_BUG = 0;

        /**
         * The number of structural features of the '<em>Empty Dummy Class To Workaround Generator Bug</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int EMPTY_DUMMY_CLASS_TO_WORKAROUND_GENERATOR_BUG_FEATURE_COUNT = 0;


        /**
         * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.EmptyDummyClassToWorkaroundGeneratorBug <em>Empty Dummy Class To Workaround Generator Bug</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for class '<em>Empty Dummy Class To Workaround Generator Bug</em>'.
         * @see com.sap.furcas.metamodel.FURCAS.EmptyDummyClassToWorkaroundGeneratorBug
         * @generated
         */
        EClass getEmptyDummyClassToWorkaroundGeneratorBug();

        /**
         * Returns the factory that creates the instances of the model.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the factory that creates the instances of the model.
         * @generated
         */
        FURCASFactory getFURCASFactory();

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
                 * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.impl.EmptyDummyClassToWorkaroundGeneratorBugImpl <em>Empty Dummy Class To Workaround Generator Bug</em>}' class.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see com.sap.furcas.metamodel.FURCAS.impl.EmptyDummyClassToWorkaroundGeneratorBugImpl
                 * @see com.sap.furcas.metamodel.FURCAS.impl.FURCASPackageImpl#getEmptyDummyClassToWorkaroundGeneratorBug()
                 * @generated
                 */
                EClass EMPTY_DUMMY_CLASS_TO_WORKAROUND_GENERATOR_BUG = eINSTANCE.getEmptyDummyClassToWorkaroundGeneratorBug();

        }

} //FURCASPackage
