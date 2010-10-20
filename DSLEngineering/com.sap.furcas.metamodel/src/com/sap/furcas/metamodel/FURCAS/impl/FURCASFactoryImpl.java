/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.impl;

import com.sap.furcas.metamodel.FURCAS.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FURCASFactoryImpl extends EFactoryImpl implements FURCASFactory {
        /**
         * Creates the default factory implementation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static FURCASFactory init() {
                try {
                        FURCASFactory theFURCASFactory = (FURCASFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.furcas.org"); 
                        if (theFURCASFactory != null) {
                                return theFURCASFactory;
                        }
                }
                catch (Exception exception) {
                        EcorePlugin.INSTANCE.log(exception);
                }
                return new FURCASFactoryImpl();
        }

        /**
         * Creates an instance of the factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public FURCASFactoryImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public EObject create(EClass eClass) {
                switch (eClass.getClassifierID()) {
                        case FURCASPackage.EMPTY_DUMMY_CLASS_TO_WORKAROUND_GENERATOR_BUG: return createEmptyDummyClassToWorkaroundGeneratorBug();
                        default:
                                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
                }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EmptyDummyClassToWorkaroundGeneratorBug createEmptyDummyClassToWorkaroundGeneratorBug() {
                EmptyDummyClassToWorkaroundGeneratorBugImpl emptyDummyClassToWorkaroundGeneratorBug = new EmptyDummyClassToWorkaroundGeneratorBugImpl();
                return emptyDummyClassToWorkaroundGeneratorBug;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public FURCASPackage getFURCASPackage() {
                return (FURCASPackage)getEPackage();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @deprecated
         * @generated
         */
        @Deprecated
        public static FURCASPackage getPackage() {
                return FURCASPackage.eINSTANCE;
        }

} //FURCASFactoryImpl
